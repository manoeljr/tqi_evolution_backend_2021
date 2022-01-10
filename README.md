# TQI Evolution 2022 - Backend

Você pode explorar aqui todos os seus conhecimentos, demonstrando <b>fluxos</b>, <b>telas</b>, <b>protótipos</b> e/ou 
<b>codificação</b>.
É importante sabermos por que você decidiu fazer a solução, portanto deixe clara a motivação das suas escolhas.
Uma empresa de empréstimo precisa criar um sistema de análise de crédito para fornecer aos seus clientes as seguintes 
funcionalidades:

 1. Cadastro de clientes

    * O cliente pode cadastrar: 
       - nome 
       - e-mail 
       - CPF 
       - RG 
       - endereço completo 
       - renda  
       - senha

 2. Login
    * A autenticação será realizada por : 
       - e-mail
       - senha

 3. Solicitação de empréstimo

    * Para solicitar um empréstimo, 
        - precisamos do valor do empréstimo 
        - data da primeira parcela
        - quantidade de parcelas
    * O máximo de parcelas será 60
        - e a data da primeira parcela deve ser no máximo 3 meses após o dia atual.

 4. Acompanhamento das solicitações de empréstimo

    * O cliente pode visualizar a lista de empréstimos solicitados por ele mesmo e também os detalhes de um de 
      seus empréstimos.
    * Na listagem, devemos retornar no mínimo o código do empréstimo, o valor e a quantidade de parcelas.
    * No detalhe do empréstimo, devemos retornar: código do empréstimo, valor, quantidade de parcelas, 
      data da primeira parcela, e-mail do cliente e renda do cliente.


 Restrições

    * A implementação deve utilizar linguagem Java ou Kotlin.
    * Use todos os seus conhecimentos adquiridos no bootcamp para explorar bem a solução. 
      Não se preocupe, porque não existe certo ou errado. Só queremos conhecer um pouco mais sobre você.
    * Utilize o GitHub para repositório de código.

 Quando finalizar, você deve criar uma tag no GitHub chamada tqi_evolution_avaliacao. 
 Desta forma, nosso time já irá avaliar o material final.

### Tecnologias envolvidas

- [X]  [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- [X]  [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.2/maven-plugin/reference/html/)
- [X]  [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.6.2/reference/htmlsingle/#using-boot-devtools)
- [X]  [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.2/reference/htmlsingle/#boot-features-developing-web-applications)
- [X]  [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.6.2/reference/htmlsingle/#boot-features-jpa-and-spring-data)
- [X]  [Validation](https://docs.spring.io/spring-boot/docs/2.6.2/reference/htmlsingle/#boot-features-validation)
- [X]  [Project Lombok](https://projectlombok.org/)
- [X]  [Docker](https://www.docker.com/get-started)
- [X]  [PostgreSQL](https://www.postgresql.org/)
- [X]  [PGAdmin](https://www.pgadmin.org/)
- [X]  [Swagger](https://swagger.io/)
- [ ]  [Map Struct](https://mapstruct.org/) | [Model Mapper](http://modelmapper.org/)

### Documentações e Guias

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)