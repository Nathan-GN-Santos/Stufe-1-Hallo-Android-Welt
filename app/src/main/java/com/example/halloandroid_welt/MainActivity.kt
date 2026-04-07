package com.example.halloandroid_welt

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Variáveis sincronizadas com os novos IDs do XML
        val tvDegree = findViewById<TextView>(R.id.degreeName)
        val tvUniversity = findViewById<TextView>(R.id.universityName)
        val tvBio = findViewById<TextView>(R.id.bio)
        val tvEducationTitle = findViewById<TextView>(R.id.titleEducation)

        // Variáveis dos Botões
        val btnGitHub = findViewById<ImageButton>(R.id.botaoGitHub)
        val btnLinkedIn = findViewById<ImageButton>(R.id.botaoLinkedIn)
        val btnIdiomas = findViewById<Button>(R.id.btnLanguage)
        val btnTema = findViewById<Button>(R.id.btnMode)

        val rootLayout = findViewById<ConstraintLayout>(R.id.main)

        var isDarkMode = false

        btnTema.setOnClickListener {
            if (!isDarkMode) {
                rootLayout.setBackgroundColor(Color.parseColor("#121212"))
                btnTema.text = "☀️"
                btnTema.setBackgroundColor(Color.WHITE)
                isDarkMode = true
            } else {
                rootLayout.setBackgroundColor(Color.parseColor("#F5F5F5"))
                btnTema.text = "🌙"
                btnTema.setBackgroundColor(Color.parseColor("#444444"))
                isDarkMode = false
            }
        }

        btnGitHub.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Nathan-GN-Santos"))
            startActivity(intent)
        }

        btnLinkedIn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/nathangabrielsantos/"))
            startActivity(intent)
        }

        btnIdiomas.setOnClickListener {
            if (btnIdiomas.text == "PT") {
                btnIdiomas.text = "EN"
                tvDegree.text = "Associate Degree in Systems Analysis and Development"
                tvUniversity.text = "Braz Cubas University Center"
                tvEducationTitle.text = "Education"
                tvBio.text = "ADS student focused on mastering the Android ecosystem. Currently focused on Kotlin and mobile architecture."
                Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show()
            } else {
                btnIdiomas.text = "PT"
                tvDegree.text = "Tecnologia em ADS"
                tvUniversity.text = "Centro Univ. Braz Cubas"
                tvEducationTitle.text = "Formação"
                tvBio.text = "Estudante de ADS focado em dominar o ecossistema Android. Atualmente focado em Kotlin e arquitetura mobile."
                Toast.makeText(this, "Bem-vindo!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}