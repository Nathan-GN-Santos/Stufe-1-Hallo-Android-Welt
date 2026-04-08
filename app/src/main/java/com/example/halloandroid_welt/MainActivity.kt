package com.example.halloandroid_welt

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

// 1. Mova as classes para fora para organizar o código
data class Language(val name: String, val flagResId: Int)

class LanguageAdapter(context: android.content.Context, languages: List<Language>) :
    ArrayAdapter<Language>(context, 0, languages) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Usa o SEU layout novo aqui
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_language, parent, false)

        val language = getItem(position)
        //val textView = view.findViewById<TextView>(R.id.txtName)
        val imageView = view.findViewById<ImageView>(R.id.imgFlag)

       // textView.text = language?.name
        imageView.setImageResource(language?.flagResId ?: 0)

        return view
    }
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvDegree = findViewById<TextView>(R.id.degreeName)
        val tvUniversity = findViewById<TextView>(R.id.universityName)
        val tvBio = findViewById<TextView>(R.id.bio)
        val tvEducationTitle = findViewById<TextView>(R.id.titleEducation)
        val btnGitHub = findViewById<ImageButton>(R.id.botaoGitHub)
        val btnLinkedIn = findViewById<ImageButton>(R.id.botaoLinkedIn)
        val btnLanguage = findViewById<LinearLayout>(R.id.containerLanguages)
        val btnTema = findViewById<Button>(R.id.btnMode)
        val rootLayout = findViewById<ConstraintLayout>(R.id.main)

        // --- CÓDIGO NOVO INICIA AQUI ---

        // 2. Definir a lista de idiomas (Certifique-se que os nomes dos drawables estão corretos)
        // 1. Adicione as 4 bandeiras aqui
        val languages = listOf(
            Language("Português", R.drawable.brazil_icon),
            Language("English", R.drawable.usa_icon),
            Language("Español", R.drawable.spain_icon), // Adicione seus drawables
            Language("Deutsch", R.drawable.germany_icon)
        )


        // 3. Configurar o ListPopupWindow
        val listPopupWindow = ListPopupWindow(this)
        listPopupWindow.setAdapter(LanguageAdapter(this, languages))
        listPopupWindow.anchorView = btnLanguage // Alinha o popup abaixo do botão
        // APLIQUE ISSO AQUI:
        listPopupWindow.setBackgroundDrawable(androidx.core.content.ContextCompat.getDrawable(this, R.drawable.popup_background))
        listPopupWindow.horizontalOffset = 10 // Opcional: desloca um pouco para a esquerda/direita para alinhar melhor
        listPopupWindow.width = 100 // Ajuste a largura conforme necessário
        listPopupWindow.setModal(true)

        // 4. Lógica de clique no item da lista
        listPopupWindow.setOnItemClickListener { _, _, position, _ ->
            val selected = languages[position]

            if (selected.name == "English") {
                //btnLanguage.text = "EN"
                tvDegree.text = "Associate Degree in Systems Analysis and Development"
                tvUniversity.text = "Braz Cubas University Center"
                tvEducationTitle.text = "Education"
                tvBio.text = "ADS student focused on mastering the Android ecosystem."
                Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show()
            } else {
                //btnLanguage.text = "PT"
                tvDegree.text = "Tecnologia em ADS"
                tvUniversity.text = "Centro Univ. Braz Cubas"
                tvEducationTitle.text = "Formação"
                tvBio.text = "Estudante de ADS focado em dominar o ecossistema Android."
                Toast.makeText(this, "Bem-vindo!", Toast.LENGTH_SHORT).show()
            }
            listPopupWindow.dismiss()
        }

        // 5. Substituir o antigo clique do botão para abrir o Popup
        btnLanguage.setOnClickListener {
            listPopupWindow.show()
        }

        // --- CÓDIGO NOVO TERMINA AQUI ---

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
    }
}