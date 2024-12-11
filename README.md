# Gerenciamento de Estoque

Este projeto foi desenvolvido como solução para uma loja que enfrentava dificuldades em localizar produtos. A aplicação permite o cadastro e a consulta de produtos, prateleiras e móveis, exibindo o nome, código de barras e o local (prateleira e móvel) de cada produto.

O sistema foi implementado em Java com Spring Boot e utiliza PostgreSQL como banco de dados. Esta documentação apresenta as etapas de instalação e configuração do ambiente, além das dependências utilizadas.

---

## Funcionalidades
- Cadastro de móveis, prateleiras e produtos.
- Consulta de produtos com exibição de código de barras e localização.
- Interface web para interações simples e eficientes.

---

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
- **Thymeleaf**
- **PostgreSQL**
- **PGAdmin 4**

---

## Dependências do Projeto
As seguintes dependências foram usadas no projeto:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jdbc</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.jetbrains</groupId>
        <artifactId>annotations</artifactId>
        <version>RELEASE</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```

---

## Configuração do Ambiente

### 1. Instalar o Java
1. Baixe e instale o **Java Development Kit (JDK)** na versão 17:
   - [Download do JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
2. Configure a variável de ambiente `JAVA_HOME`:
   - Localize o diretório de instalação do JDK.
   - Adicione o caminho do diretório nas variáveis de ambiente.
   - Verifique a instalação executando `java -version` no terminal.

### 2. Instalar o PostgreSQL e o PGAdmin 4
1. Baixe o instalador do PostgreSQL:
   - [Download do PostgreSQL](https://www.postgresql.org/download/)
2. Durante a instalação:
   - Defina o nome de usuário como `postgres`.
   - Configure a senha como `admim` (ou altere para outra de sua preferência e atualize no código).
3. Instale o **PGAdmin 4**:
   - Acesse o [Download do PGAdmin 4](https://www.pgadmin.org/download/).
   - Conecte-se ao servidor PostgreSQL e crie o banco de dados `loja`.

### 3. Configurar o Banco de Dados no Spring Boot
O acesso ao banco de dados foi configurado no projeto com o seguinte código:

```java
public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://localhost:5432/loja");
    dataSource.setUsername("postgres");
    dataSource.setPassword("admim");
    return dataSource;
}

@Bean
public JpaVendorAdapter jpaVendorAdapter() {
    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    adapter.setDatabase(Database.POSTGRESQL);
    adapter.setShowSql(true);
    adapter.setGenerateDdl(true);
    adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
    adapter.setPrepareConnection(true);
    return adapter;
}
```

---

## Passos para Executar o Projeto
1. Clone este repositório em sua máquina.
2. Instale as dependências do projeto com o Maven.
3. Configure o banco de dados `loja` no PostgreSQL.
4. Execute a aplicação pelo comando:
   ```bash
   mvn spring-boot:run
   ```
5. Acesse a interface pelo navegador:
   - URL: [http://localhost:8080](http://localhost:8080)

---

## Contribuições
Sugestões de melhorias e relatórios de problemas são bem-vindos! Sinta-se à vontade para abrir uma *issue* ou enviar um *pull request*.

---

## Autor
Desenvolvido por Pedro Jonnathan. Para mais informações, entre em contato via [LinkedIn](https://www.linkedin.com/in/seu-perfil).

