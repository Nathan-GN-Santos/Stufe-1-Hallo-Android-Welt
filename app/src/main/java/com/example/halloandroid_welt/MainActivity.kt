package com.example.halloandroid_welt

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //variavel que muda as cores
        val listaDeCores = listOf(
            android.graphics.Color.MAGENTA,
            android.graphics.Color.GREEN,
            android.graphics.Color.RED,
            android.graphics.Color.BLUE
        )
        //contador para saber em que cor usar
        var contadorDeCliques = 0
        // 1. Achar o botão no XML usando o ID que demos
        //val botaoMudarCor = findViewById<Button>(R.id.meuBotao)

        // 2. Achar o texto (TextView) também
        val meuBotao = findViewById<Button>(R.id.meuBotao) // Ajuste se o ID do seu texto for diferente

        // 3. Criar a lógica do clique
        meuBotao.setOnClickListener {
            // Quando clicar, mude a cor do texto para VERMELHO
            //meuBotao.setTextColor(android.graphics.Color.WHITE)

            // Opcional: Mudar também a cor de fundo do PRÓPRIO BOTÃO
            //meuBotao.setBackgroundColor(android.graphics.Color.GREEN)

            val indice = contadorDeCliques % listaDeCores.size
            val corAtual = listaDeCores[indice]

            meuBotao.setBackgroundColor(corAtual)

            contadorDeCliques++
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}