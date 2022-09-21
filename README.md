# Marvel List

Aplicativo em Kotlin com Jetpack Compose, organizado em MVVM.

A tela inicial mostra uma lista de até 100 personagens da Marvel, podendo o usuário passar ou voltar de página para ver mais 100.
Cada item da lista apresenta a miniatura e o nome do personagem; ao clicar no item, o usuário é levado para uma tela que apresenta as mesmas informações
anteriores, mais uma rápida descrição do personagem e a lista de quadrinhos nos quais o mesmo apareceu.

Foi utilizado Retrofit para as funcionalidades da api e Glide para apresentar as imagens.
Também foi utilizado Dagger Hilt para injeção de dependências.
