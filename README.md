# Projeto Comércio S.A.

Projeto feito para uma empresa fictícia Comércio S.A. que precisava de um site de uma agenda virtual para organizar os clientes.

## Pré-requisitos
Coisas necessários para o funcionamento da agenda virtual:
* [XAMPP](https://www.apachefriends.org/pt_br/index.html) - Cria e gerencia servidores web locais.
* [Maven](https://maven.apache.org/) - Gerente de Dependências.
* [MySQL Workbench](https://downloads.mysql.com/archives/workbench/) - Ferramenta visual de design de banco de dados para modelagem de dados.
* [Java 21 ou superior](https://www.oracle.com/br/java/technologies/downloads/#java24) - Rodar aplicações.
* [Spring Boot](https://docs.spring.io/spring-boot/installing.html) - Estrutura Web de software livre em Java.
* [VSCode](https://code.visualstudio.com/download) - IDE. 

## Instalação
Dentro do VSCode, abra o Terminal pressionando:

Ctrl + J

Ou vá em View > Terminal.

No Terminal, navegue até a pasta onde deseja clonar o repositótio

```
cd caminho/da/pasta
```

Agora, clone o repositório com o comando:

```
git clone https://github.com/VanessaDndll/projeto-comercio-SA.git
```

Após clonar, entre no repositório com o comando:

```
cd comercio-SA/backend
```

E abra o projeto com:

```
code .
```

## Executando
Orientações para executar o código.

### Iniciando o servidor local
Com o aplicativo do XAMPP aberto, clique nas opções:

- Apache 

- MySQL

Para iniciar o servidor local.

### Criar banco de dados
Abra o MySQL Workbench e faça o seguinte caminho:

Vá em *MySQL Connections +*

Em *Connection Name* coloque: comersioSA e clique em *Ok*

Selecione o *comercioSA*

Para abrir o banco inicial siga:

File > Open SQL Script... 

Navegue até a pasta com o repositório clonado e selecione:

init.sql

Selecione tudo com Ctrl + A e aperte no icone de raio para criar o banco.

### Ativando a API
Com a pasta extraída já na IDE, abra o terminal com o comando ctrl + J.

Certifique-se que você está no caminho certo:

```
PS C:\seu-caminho\comercio-SA\backend>
```

E coloque o seguinte comando para ativar a API:

```
mvn spring-boot:run
```

Com a API ativa e funcionando, abrar o arquivo index.html para poder começar a usar.