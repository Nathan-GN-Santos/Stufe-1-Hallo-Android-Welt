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
Estarei compreendendo o código agora.


03/04/2026 07:50
Comecei a modificar o código novamente. O botão mudava com o clique
indo pra o próximo idioma de forma sequencial sem poder escolher o idioma que vc quer ir direto.

Aqui aprendi PopupMenu :que é a listinha de opções
view, que ficou dentro do setOnClickListener, que indica aonde a listinha deve aparecer(botão)
menu.add() é os itens da lista, nela colocamos seus nomes como tbm seus códigos de verificação.
setMenuOnClickListener: è um listener especiifico para menus. ele fica esperando vc clicar na opçõa
item: é a opção q o user escolher
itemId: o RG do dos itens, onde acessamos seus codigos de identificação do menu.add()

08:48
Agora estou mexendo no xml e pondo meu meu nome e uma foto placeholder.
no android:src n é necessário colocar o .jpg no final. Eu tinha colocado e deu erro.

09:24
Na hora de organizar dentro dos <textView> estarei utilizando:
    -Identidade; android:id ="@id/
    -Contéudo; android:text = "texto"
    -Estilo:
    -Tamanho;
    -Posicionamento; constraint e layouts


05/04/2026 09:24 My House
So here are again. Let's go!

11:58 

O app, foi atualizado
- Botão Cores removido
- Botão que muda o tema do app foi add
- Agora o botão GitHub e LinkedIn levam para  os meus perfis respectivos
- TextViews de Kotlin e Python foram adicionados( e seus ícones)
- Bio foi adicionada

A Fazer:
- Implementar a funcionalidade de mudança de idioma a Bio.
- Melhorar o Design to Cartão
- Adicionar o botão "Me Contrate" que encaminha para Whatsapp.
- Ajudar as mensagens que aparecem quando se aperta repetidamente o botãoidiomas. Há um certo delay.
- Fazer com que ao clicar nas caixas Kotlin e Python apareça um breve resumo do que planejo fazer com elas.
    