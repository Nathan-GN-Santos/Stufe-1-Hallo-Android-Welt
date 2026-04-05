package com.example.halloandroid_welt

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Variáveis dos Botões
        val btnGitHub = findViewById<ImageButton>(R.id.botaoGitHub)
        val btnLinkedIn = findViewById<ImageButton>(R.id.botaoLinkedIn)
        val btnIdiomas = findViewById<Button>(R.id.botaoIdiomas)
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
                btnIdiomas.text = "DE" // Muda para Alemão (Deutsch)
                Toast.makeText(this, "Willkommen!", Toast.LENGTH_SHORT).show()
            } else {
                btnIdiomas.text = "PT"
                Toast.makeText(this, "Bem-vindo!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}