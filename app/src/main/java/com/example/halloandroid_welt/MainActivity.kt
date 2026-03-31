package com.example.halloandroid_welt

import android.os.Bundle
import android.widget.Button
//import android.widget.TextView // this a comment, ignore
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val meuBotao = findViewById<Button>(R.id.meuBotao)

        //variavel que muda as cores
        val listaDeCores = listOf(
            android.graphics.Color.GRAY,
            android.graphics.Color.MAGENTA,
            android.graphics.Color.parseColor("#4CAF50"),
            android.graphics.Color.RED,
            android.graphics.Color.BLUE
        )
        //variavel que muda as frases
        val listaDeFrases = listOf(
            "Hallo, Welt!",
            "Das ist Magenta",
            "Das ist Grün",
            "Das ist Rot",
            "Das ist Blau"
        )

        //contador para saber em que cor usar
        var contadorDeCliques = 0

        fun atualizarInterface() {
            val indice = contadorDeCliques % listaDeCores.size
            meuBotao.setBackgroundColor(listaDeCores[indice])
            meuBotao.text = listaDeFrases[indice]
        }

        atualizarInterface()
        meuBotao.setOnClickListener {
            contadorDeCliques++
            atualizarInterface()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}