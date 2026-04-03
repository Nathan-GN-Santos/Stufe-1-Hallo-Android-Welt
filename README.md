Hallo, README.md !

02/04/2026 09:06

O app já está com um botão no centro que muda de cor e frases em alemão quando apertado.
Agora, vou adicionar um botão que muda o idioma das frases. 

Estou criando um novo botão no .xml, antes de criar sua função.
    usar match_parent vai fazer que o botão tente ocupar a tela inteira. 
    usar wrap_content vai wrap/"se enrolar" em volta do contéudo do botão.

As linhas :
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
servem pra decidir aonde o botão vai fica na tela.
    app:layout_constraintBottom_toBottomOf="parent" faz o "botão" ficar preso no bottom of the parent(tela)
    app:layout_constraintEnd_toTopOf="parent" faz ficar no top of the parent.
        Logo, usando os dois, o botão fica "tensionado" no meio, como se as duas linhas estivessem querendo puxa-lo pro seu lado.
A mesma lógica é aplicada nos 
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
Start contando como esquerda, e End contando como direita, pelo visto.

Se eu quiser fazer que o botaoIdioma fique no canto superior esquerdo, eu poderia só usar
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintTop_toTopOf="parent"
mas, fazer dessa forma faria com que o botão ficasse colado nas bordas extremas do canto superior direita,
que ficaria feio. Pra evitar isso, utilizamos margens pra deixar afastado o botão da borda.
Essas sendo:
    android:layout_marginTop="16dp"
    android:layout_marginEnd="16dp"
Lembrando, top sendo topo, duh, e End sendo a "direita".

10:38

O app está atualizado, porém foi em maior parte copia e cola do Gemini. 
Estarei compreendo


    