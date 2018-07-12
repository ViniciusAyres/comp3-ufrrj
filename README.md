## Configurando o projeto

1. Baixe o repositorio, **utilizando o git clone**, no diretório em que preferir
2. Abra o IntelliJ
3. Se você estiver com algum projeto aberto, feche o projeto. Para isso, vá em File > Close Project
4. Na tela inicial do Intellij selecione Import Project.
5. Encontre o caminho que você baixou o projeto e selecione o arquivo pom.xml
6. Selecione Next algumas vezes. Se em algum momento o JDK não estiver definido selecione o seu JDK. Quando não puder mais, selecione Finish.
7. Quando o Intellij carregar o projeto, vá em File > Project Structure. No item Project selecione seu SDK. Clique em Apply.
8. Após isso selecione o item Modules. Clique no botão +. Após carregar uma lista de opções, selecione a opção web. Clique em Apply.
9. Por fim selecione o item Artifacts. Clique no botão + e selecione Web Application: Exploded > From modules .. > nome do projeto (nesse caso, comp3-natacao). Clique em Ok, depois Apply e Ok novamente.
10. Agora configure o Tomcat. Vá em Run > Edit Configurations.
11. Clique no botão + e selecione Tomcat server > local. Escolha um nome para o servidor. Vá na aba Deployment, clique no botão + e selecione o artefato que acabou de criar(comp3-natacao:war exploded). Clique em Apply e Ok.
12. Rode o projeto

