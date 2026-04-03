package com.example.halloandroid_welt

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // 0 = Português , 1 = Alemão , 2 = Inglês, 3 = Espanhol

    var idiomaCont = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //variaveis
        val botaoCores = findViewById<Button>(R.id.botaoCores)
        val botaoIdioma = findViewById<Button>(R.id.botaoIdiomas)
        val nomeUsuario = findViewById<TextView>(R.id.nomeUsuario)


    // botao das cores
        //variavel que muda as cores
        val listaDeCores = listOf(
            android.graphics.Color.GRAY,
            android.graphics.Color.MAGENTA,
            android.graphics.Color.parseColor("#4CAF50"),
            android.graphics.Color.RED,
            android.graphics.Color.BLUE
        )
        // Variável que armazena a cor atual para não perdê-la ao trocar o idioma
        var contadorDeCliques = 0

        // Função que retorna a frase certa baseada na cor E no idioma
        fun pegarFrase(indiceCor: Int): String {
            return when (idiomaCont) {
                0 -> listOf("Olá, Mundo!", "Isso é Magenta", "Isso é Verde", "Isso é Vermelho", "Isso é Azul")[indiceCor]
                1 -> listOf("Hallo, Welt!", "Das ist Magenta", "Das ist Grün", "Das ist Rot", "Das ist Blau")[indiceCor]
                2 -> listOf("Hello, World!", "This is Magenta", "This is Green", "This is Red", "This is Blue")[indiceCor]
                else -> listOf("¡Hola, Mundo!", "Isso é Magenta", "Esto es Verde", "Esto es Rojo", "Esto es Azul")[indiceCor]
            }
        }

        fun atualizarInterface() {
            val indice = contadorDeCliques % listaDeCores.size
            botaoCores.setBackgroundColor(listaDeCores[indice])
            botaoCores.text = pegarFrase(indice)

            // Atualiza o texto do próprio botão de idiomas
            botaoIdioma.text = when(idiomaCont) {
                0 -> "PT"
                1 -> "DE"
                2 -> "EN"
                else -> "ES"
            }
        }

        // Clique para mudar a COR
        botaoCores.setOnClickListener {
            contadorDeCliques++
            atualizarInterface()
        }

        // Clique para mudar o IDIOMA
        botaoIdioma.setOnClickListener {view ->
            //criar popoup menu
            //this é o context (essa activiy)
            //view é botão onde o menu vai brotar emcima
            val popup = android.widget.PopupMenu(this,view)

            //aqui fzmos o menu

            popup.menu.add(0,0,0, "Português")
            popup.menu.add(0,1,1,"Deutsch")
            popup.menu.add(0,2,2,"English")
            popup.menu.add(0,3,3,"Español")

            //aq dizemos oq aconteeu qunaod clicaar em uma opção
            popup.setOnMenuItemClickListener { item ->
                //item.id é pra ser aqueles números que colocamos ali em cima
                idiomaCont = item.itemId

                //agora que valor foi mudado, manda a interfacae att
                atualizarInterface()

                //true diz que o clique foi processado com sucesso
                true
            }

            // mostrar menu na tela
            popup.show()

        }

        atualizarInterface()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}