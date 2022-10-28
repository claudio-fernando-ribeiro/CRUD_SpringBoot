# Projeto módulo 3 Spring Boot

## Spring Framework
Conjunto de bibliotecas escritas em Java para simplificar o desenvolvimento de aplicação WEB.

## Spring Boot
Ferramente de acelaração de inicialização de um projeto utilizando o Spring Boot.
 - Documentação: https://spring.io/project/spring-boot
 - Start: https://start.spring.io/
 Site que cria a estrutura de um projeto utilizando o Spring Boot.

 ## Configuração do ambiente
 - Java Development KIT (JDK)
 - Maven (gerenciador de pacotes e ferramenta de build)
 - VSCode
    - Extesion Pack For Java (microsoft)
    - Extension Pack for Spring Boot (Pivotal)
- Banco de dados (MariaDB)

## Estrutura do projeto
- Pacote src: todo o código da apliocação (Java, HTML, CSS, JS). É nessa pasta que está a lógica do sistema.
- Pacote target: código compilado gerado pelo Maven. (não é carregada pelo Git).
- Arquivo pom.xml: arquivo descritor utilizado pelo Maven para download das dependências e build de aplicação. 
- <nomedoprojeto>Application.java - main da aplicação Java.
- pacote controller: classes que responsáveis por tratar as requisições HTTP enviadas para as toras definidas por anotação.

## Executar a aplicação
- Encontrar o Spring Boot Dashboard.
- Clicar no ícone de "Play" do lado do nome do projeto.


## Passo a passo de criação
- Criar uma pasta no disco do computador
- Abrir a pasta no VSCode

- Iniciar um projeto Spring-Boot. -> Selecionar o Spring Initializr: Create a Maven Project: versão spring boot / linguagem / pacote (br.univille) / nome do projeto (não usar espaço, nem caractere especial) / Forma de empacotamento (Jar) / versão do JDK (Java) / 
- Instalar as dependências necessárias. 
   - spring-boot-devtools
   - spring-boot-starter-web
   - spring-boot-starter-test
   - spring-boot-starter-thymeleaf
- Selecionar a pasta onde vai ser salvo o projeto.
- Na pasta resources, selecionar e configurar o arquivo: application.properties
    - Esse arquivo configura nossa aplicação. Para isso é necessário a inserção de algumas configurações. Vide: src/main/resources/templates/application.properties
    - São elas:
        - spring.thymeleaf.check-template-location=true - Verifica a existência do diretório
        - spring.thymeleaf.prefix=classpath:/templates/ - informa onde ficarão os arquivos HTML
        - spring.thymeleaf.suffix=.html - Informa a extensão dos arquivos.
- Criar o arquivo HTML
- Desenvolver nosso controlador com a lógica requerida para seu funcionamento.
- Configurar nosso arquivo HTML, importando uma TAG LIB (biblioteca de tags).
    - A forma de informar o caminho da nossa informação do controlador, é utilizando ${valor}
    - Configurar o bootstrap no CSS - buscar o arquivo em "mvnrepository", depois entrar na dependência correta, copiar o código e colocar dentro do arquivo pom.xml
    - Configurar o caminho para o bootstrap html.

## Como adicionar uma nova dependência
    - Ctrl + Shift + P - Spring Initializr: Add starts
    - Digitar o nome da dependência, selecionar a dependência e atualizar. 
    - Salvar o arquivo POM.

Opção 2 - Acessar o site https://mvnrepository.com/
    - Procurar a dependência, copiar o xml, copiar o xml e colar no arquivo POM.

## Como repetir o mesmo layout (menu) em todas as páginas?
    - Criar um arquivo "layout.html" dentro da pasta :./resources/templates/.
criar a estrutura do html5.
    - Dentro da tag que deve ser repetida (no meu caso usei o Navbar do bootstrap), inserir _th:fragment="menu"_(menu é uma variável).
    - A mesma coisa deve ser feita dentro da tag <head>. Ficando dessa forma <head th:fragment="head">
    - Da mesma forma, qualquer parte do meu código que deva permanecer dentro do meu código pode/deve ser feito dessa forma, como por exemplo <footer> ou algum ícone ou link de contato.
    - Feito isso, devo substituir as partes que quero que permaneçam dentro do arquivo index.html. No caso <head> e do <footer> utilizo o th:include="layout :: NOME DO ARQUIVO", e no caso do que vai dentro do body, utilizo o th:relace="layout :: NOME DO ARQUIVO"


## Criando uma tela de cadastro de clientes Passo-a-Passo
- Criar um arquivo dentro da pasta controller "ClienteController.java"
- "Avisar" que é um arquivo de controler, ou seja, que é uma classe capaz de ouvir requisições, usando a anotação "@Controller" (essa classe deve ser importada).
- Informo a rota que ele deve exercutar, utilizando a anotação "@RequestMapping("/clientes")
- Definir quais métodos serão "Get" dentro da aplicação, para isso utilizar a anotação "@GetMapping"

## Configuração para conexão no banco de dados relacional
- Adicionar dependências (Spring Data JPA, H2, MariaDB JDBC Driver).
- Configurar a conexão da aplicação com o BD, isso acontece no arquivo application.properties.
