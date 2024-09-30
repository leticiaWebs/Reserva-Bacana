## Reserva Bacana 
O projeto consiste em uma aplicação que realiza reservas em restaurantes. 
## Ferramentas e Frameworks Utilizados

Este projeto utiliza diversas ferramentas e frameworks para facilitar o desenvolvimento e garantir boas práticas. A seguir estão as principais bibliotecas e tecnologias integradas:

### Tecnologias Principais

-   **Java 17**: Linguagem principal utilizada no projeto.
-   **Spring Boot 3.3.4**: Framework para criar aplicações Java de maneira ágil e com configurações simplificadas.
    -   `spring-boot-starter-data-jpa`: Integração com JPA para persistência de dados.
    -   `spring-boot-starter-mail`: Envio de e-mails.
    -   `spring-boot-starter-thymeleaf`: Suporte a templates Thymeleaf para geração de páginas HTML.
    -   `spring-boot-starter-validation`: Validações automáticas com base nas anotações Bean Validation.
    -   `spring-boot-starter-data-mongodb`: Integração com o banco de dados MongoDB.
    -   `spring-boot-starter-web`: Construção de APIs RESTful e aplicações web.
-   **H2 Database**: Banco de dados em memória para testes e desenvolvimento local.
-   **Lombok**: Facilita a redução de código boilerplate com anotações como `@Getter`, `@Setter`, `@Builder`, entre outras.
-   **MapStruct 1.5.2.Final**: Framework para mapeamento entre objetos de forma automática e eficiente.
-   **ModelMapper 2.4.2**: Ferramenta para conversão de objetos de um tipo para outro.

### Testes

-   **JUnit 5.9.3**: Framework para criação e execução de testes unitários.
    -   `junit-jupiter-engine` e `junit-jupiter-api`: Módulos de execução e escrita de testes com JUnit 5.
-   **AssertJ 3.24.2**: Framework de assertions fluentes para escrita de testes.
-   **Rest-Assured 5.3.0**: Framework para teste de APIs REST com suporte ao Mock MVC do Spring.

### Documentação

-   **SpringDoc OpenAPI 2.0.2**: Ferramenta para gerar a documentação da API no formato OpenAPI (Swagger).

### Plugins de Build

-   **Spring Boot Maven Plugin**: Plugin utilizado para empacotar e executar a aplicação Spring Boot.
-   **SonarQube Maven Plugin**: Ferramenta de análise estática para melhorar a qualidade do código e garantir boas práticas.

### Dependências Adicionais

-   **Jackson Datatype JSR310**: Suporte ao mapeamento de tipos de data e hora do Java 8 em JSON.
-   **Servlet API 4.0.1**: API para criação de servlets e comunicação com servidores we
