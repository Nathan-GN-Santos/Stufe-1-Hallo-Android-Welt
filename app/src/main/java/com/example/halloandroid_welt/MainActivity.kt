package com.example.halloandroid_welt

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //variavéis vítimas para traduzir:
        val tvCurso = findViewById<TextView>(R.id.nomeCurso)
        val tvBadgeKotlin = findViewById<TextView>(R.id.badgeKotlin)
        val tvBadgePython = findViewById<TextView>(R.id.badgePython)
        val tvCidade = findViewById<TextView>(R.id.nomeCidade)
        val tvFaculdade = findViewById<TextView>(R.id.nomeFaculdade)
        val tvBio = findViewById<TextView>(R.id.bio)

        // Variáveis dos Botões
        val btnGitHub = findViewById<ImageButton>(R.id.botaoGitHub)
        val btnLinkedIn = findViewById<ImageButton>(R.id.botaoLinkedIn)
        val btnIdiomas = findViewById<Button>(R.id.botaoIdiomas)
        val btnBadgeKotlin = findViewById<TextView>(R.id.badgeKotlin)
        val btnBadgePython = findViewById<TextView>(R.id.badgePython)
        // No seu MainActivity.kt, dentro do onCreate

        val rootLayout = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)
        val btnTema = findViewById<Button>(R.id.botaoTema)
        var isDarkMode = false

        btnTema.setOnClickListener {
            if (!isDarkMode) {
                // MODO ESCURO
                rootLayout.setBackgroundColor(android.graphics.Color.parseColor("#121212"))
                btnTema.text = "☀️" // Muda ícone para Sol
                btnTema.setBackgroundColor(android.graphics.Color.parseColor("#FFFFFF")) // A
                isDarkMode = true
            } else {
                // MODO CLARO
                rootLayout.setBackgroundColor(android.graphics.Color.parseColor("#F5F5F5"))
                btnTema.text = "🌙" // Muda ícone para Lua
                btnTema.setBackgroundColor(android.graphics.Color.parseColor("#444444"))
                isDarkMode = false
            }
        }


        // Ação Botão GitHub
        btnGitHub.setOnClickListener {
            Toast.makeText(this, "Abrindo GitHub...", Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Nathan-GN-Santos"))
            startActivity(intent)
        }

        // Ação Botão LinkedIn
        btnLinkedIn.setOnClickListener {
            Toast.makeText(this, "Abrindo LinkedIn...", Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/nathangabrielsantos/"))
            startActivity(intent)
        }

        // Ação Botão Idiomas (Lógica inicial)
        btnIdiomas.setOnClickListener {
            if (btnIdiomas.text == "PT") {
                btnIdiomas.text = "EN" // Muda para Inglês

                tvCurso.text = "Analysis and Systems Development"
                tvBadgeKotlin.text = "Kotlin (Studying)"
                tvBadgePython.text = "Python AI (Interest)"
                tvCidade.text = "📍 Mogi das Cruzes, Brazil" // Location stays mostly the same
                tvFaculdade.text = "🏫 Braz Cubas University Center"
                tvBio.text = """
                    Estudante de ADS focado em dominar o ecossistema Android. 
                    Atualmente focado em Kotlin e arquitetura mobile, 
                    com futuros planos para trabalhar com IA e Machine Learning. 
                    Em busca da primeira oportunidade como estagiário/júnior.
                    """.trimIndent()

                Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show()
            } else {
                //troca para PT
                btnIdiomas.text = "PT"

                tvCurso.text = "Tecnologia em ADS"
                tvBadgeKotlin.text = "Kotlin (Estudando)"
                tvBadgePython.text = "Python IA (Interesse)"
                tvCidade.text = "📍 Mogi das Cruzes, Brazil"
                tvFaculdade.text = "🏫 Centro Univ. Braz Cubas"
                tvBio.text = """
                    Estudante de ADS focado em dominar o ecossistema Android.
                    Atualmente focado em Kotlin e arquitetura mobile,
                    com futuros planos para trabalhar com IA e Machine Learning.
                    Em busca da primeira oportunidade como estagiário/júnior.
                """.trimIndent()
                Toast.makeText(this, "Bem-vindo!", Toast.LENGTH_SHORT).show()
            }
        }

        //botões kotlin e python

        btnBadgeKotlin.setOnClickListener{ view ->
            val popupView = TextView(this).apply{
                text = if (btnIdiomas.text == "PT") {
                    "Isso aqui é o que eu planejo fazer com Koltin"
                } else {
                    "This is what I plan to do with Kotlin"
                }
                setBackgroundColor(Color.parseColor("#333333"))
                setTextColor(Color.WHITE)
                setPadding(20,20,20,20)
            }

            val MeuPopup = PopupWindow(
                popupView,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                true
            )
            // oq faz o popup aparecer debaixo do botão
            MeuPopup.showAsDropDown(view)

        }
        // botão python
        btnBadgePython.setOnClickListener{ view ->
            val popupView = TextView(this).apply{
                text = if (btnIdiomas == "PT") {
                    "Isso aqui é o que eu planejo fazer com Python"
                } else {
                    "This is what I plan to with Python"
                }
                setBackgroundColor(Color.parseColor("#333333"))
                setTextColor(Color.WHITE)
                setPadding(20,20,20,20)
            }

            val MeuPopup = PopupWindow(
                popupView,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                true
            )
            // oq faz o popup aparecer debaixo do botão
            MeuPopup.showAsDropDown(view)

        }

    }
}