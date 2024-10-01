# Projeto API - Sistema de Gerenciamento de Alunos

Este projeto é uma API RESTful desenvolvida com **Spring Boot** e **MySQL**, focada no gerenciamento de alunos. Este projeto foi realizado como projeto final do curso Criando APIs com Spring Boot e MySQL do professor Ralf Lima. A API oferece operações de **CRUD** (Criar, Ler, Atualizar e Excluir) e diversas **consultas personalizadas**, como busca por termos, ordenação de nomes e cálculos sobre as médias de notas dos alunos.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **MySQL**
- **Spring Data JPA**
- **Jakarta Persistence API**
- **Maven**

## Funcionalidades

### Endpoints

- **POST `/api`**: Cadastrar um novo aluno. O corpo da requisição deve conter os campos `nome`, `nota1`, e `nota2`.
- **GET `/api`**: Listar todos os alunos.
- **GET `/api/{codigo}`**: Selecionar um aluno pelo código.
- **GET `/api/contador`**: Retornar o número total de alunos cadastrados.
- **PUT `/api`**: Editar um aluno existente. O código do aluno deve ser fornecido no corpo da requisição.
- **DELETE `/api/{codigo}`**: Remover um aluno pelo código.

### Consultas Personalizadas

- **GET `/api/ordenarNomes`**: Listar os alunos ordenados alfabeticamente por nome.
- **GET `/api/nomeContem/{termo}`**: Buscar alunos cujos nomes contêm o termo fornecido.
- **GET `/api/iniciaCom/{termo}`**: Buscar alunos cujos nomes começam com o termo fornecido.
- **GET `/api/terminaCom/{termo}`**: Buscar alunos cujos nomes terminam com o termo fornecido.
- **GET `/api/somaMedias`**: Calcular e retornar a soma das médias de todos os alunos.
- **GET `/api/mediaMaiorIgual/{nota}`**: Listar alunos cuja média é maior ou igual à nota fornecida.



## Como Executar

Pré-requisitos: Certifique-se de ter o Java 17, Maven, e um banco de dados MySQL em execução.

Clone o repositório:
git clone https://github.com/seu-usuario/seu-repositorio.git


Configure o banco de dados: Atualize o arquivo application.properties com as configurações do seu banco de dados MySQL.

Compile e execute o projeto:
mvn clean install
mvn spring-boot:run

##  Contribuições
Contribuições são bem-vindas!
