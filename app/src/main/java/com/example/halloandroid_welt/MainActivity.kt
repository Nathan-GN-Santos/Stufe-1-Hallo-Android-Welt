package com.example.halloandroid_welt

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ListPopupWindow
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

// Data class mantida externa para melhor organização
data class Language(val name: String, val flagResId: Int)

class LanguageAdapter(context: Context, languages: List<Language>) :
    ArrayAdapter<Language>(context, 0, languages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_language, parent, false)

        val language = getItem(position)
        val imageView = view.findViewById<ImageView>(R.id.imgFlag)

        language?.let {
            imageView.setImageResource(it.flagResId)
        }

        return view
    }
}

class MainActivity : AppCompatActivity() {

    // Variável de estado movida para escopo de classe
    private var isDarkMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialização de Views
        val userLanguages = findViewById<TextView>(R.id.userLanguages).apply { isSelected = true }
        val tvDegree = findViewById<TextView>(R.id.degreeName)
        val tvUniversity = findViewById<TextView>(R.id.universityName)
        val tvBio = findViewById<TextView>(R.id.bio)
        val tvEducationTitle = findViewById<TextView>(R.id.titleEducation)

        val btnGitHub = findViewById<ImageButton>(R.id.btnGitHub)
        val btnLinkedIn = findViewById<ImageButton>(R.id.btnLinkedIn)
        val btnLanguage = findViewById<LinearLayout>(R.id.containerLanguages)
        val btnTema = findViewById<Button>(R.id.btnMode)

        val rootLayout = findViewById<ConstraintLayout>(R.id.main)
        val mainScrollView = findViewById<ScrollView>(R.id.theScrollView)

        // Configuração da Anchor Bar (Navegação interna)
        setupNavigation(mainScrollView)

        // Configuração de Idiomas
        setupLanguagePopup(
            btnLanguage,
            tvDegree,
            tvUniversity,
            tvEducationTitle,
            tvBio
        )

        // Configuração de Eventos
        btnTema.setOnClickListener { toggleTheme(rootLayout, it as Button) }

        btnGitHub.setOnClickListener {
            openUrl("https://github.com/Nathan-GN-Santos")
        }

        btnLinkedIn.setOnClickListener {
            openUrl("https://www.linkedin.com/in/nathangabrielsantos/")
        }
    }

    private fun setupNavigation(scrollView: ScrollView) {
        val navButtons = mapOf(
            R.id.gotoBio to R.id.tituloBio,
            R.id.gotoProjects to R.id.projectsTitle,
            R.id.gotoSkills to R.id.titleSkills,
            R.id.gotoEducation to R.id.sectionEducation,
            R.id.gotoContact to R.id.bottomBar
        )

        navButtons.forEach { (btnId, targetId) ->
            findViewById<Button>(btnId).setOnClickListener {
                val target = findViewById<View>(targetId)
                scrollView.post {
                    scrollView.smoothScrollTo(0, target.top)
                }
            }
        }
    }

    private fun setupLanguagePopup(
        anchor: View,
        tvDegree: TextView,
        tvUniv: TextView,
        tvEdu: TextView,
        tvBio: TextView
    ) {
        val imgCurrentFlag = findViewById<ImageView>(R.id.imgCurrentFlag)

        val languages = listOf(
            Language("Português", R.drawable.brazil_icon),
            Language("English", R.drawable.usa_icon),
            Language("Español", R.drawable.spain_icon),
            Language("Deutsch", R.drawable.germany_icon)
        )

        val listPopupWindow = ListPopupWindow(this).apply {
            setAdapter(LanguageAdapter(this@MainActivity, languages))
            anchorView = anchor
            setBackgroundDrawable(ContextCompat.getDrawable(this@MainActivity, R.drawable.popup_background))
            horizontalOffset = 10
            width = 100
            isModal = true
        }

        listPopupWindow.setOnItemClickListener { _, _, position, _ ->
            val selected = languages[position]

            imgCurrentFlag.setImageResource(selected.flagResId)
            updateContentLanguage(selected.name, tvDegree, tvUniv, tvEdu, tvBio)
            listPopupWindow.dismiss()
        }

        anchor.setOnClickListener { listPopupWindow.show() }
        }

    private fun updateContentLanguage(lang: String, deg: TextView, univ: TextView, edu: TextView, bio: TextView) {
        if (lang == "English") {
            deg.text = "Associate Degree in Systems Analysis and Development"
            univ.text = "Braz Cubas University Center"
            edu.text = "Education"
            bio.text = "ADS student focused on mastering the Android ecosystem."
            Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show()
        } else {
            deg.text = "Tecnologia em ADS"
            univ.text = "Centro Univ. Braz Cubas"
            edu.text = "Formação"
            bio.text = "Estudante de ADS focado em dominar o ecossistema Android."
            Toast.makeText(this, "Bem-vindo!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun toggleTheme(root: ConstraintLayout, btn: Button) {
        isDarkMode = !isDarkMode
        if (isDarkMode) {
            root.setBackgroundColor(Color.parseColor("#121212"))
            btn.text = "☀️"
            btn.setBackgroundColor(Color.WHITE)
        } else {
            root.setBackgroundColor(Color.parseColor("#F5F5F5"))
            btn.text = "🌙"
            btn.setBackgroundColor(Color.parseColor("#444444"))
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}