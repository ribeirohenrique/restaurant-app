# Restaurant App

Este é um projeto Spring Boot que gerencia um sistema de restaurante. Ele utiliza PostgreSQL como banco de dados.

## Pré-requisitos

1. **PostgreSQL** instalado na máquina ou acessível via rede.
2. Banco de dados chamado `restaurant` criado no PostgreSQL.
3. Credenciais do banco de dados (IP, usuário e senha) disponíveis.

## Configuração

### 1. Clone o Repositório

Clone este repositório localmente:

```bash
git clone https://github.com/ribeirohenrique/restaurant-app.git
cd restaurant-app
```

### 2. Configure o Banco de Dados

1. Certifique-se de que o PostgreSQL está em execução.
2. Acesse o banco de dados PostgreSQL e crie o banco:

```sql
CREATE DATABASE restaurant;
```

### 3. Configure as Propriedades da Aplicação

No arquivo `src/main/resources/application-test.properties`, configure as propriedades de conexão com o banco de dados:

```properties
spring.datasource.url=jdbc:postgresql://<IP_DO_SERVIDOR>:5432/restaurant
spring.datasource.username=<SEU_USUARIO>
spring.datasource.password=<SUA_SENHA>
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

- Substitua `<IP_DO_SERVIDOR>` pelo endereço IP do servidor PostgreSQL (exemplo: `localhost`).
- Substitua `<SEU_USUARIO>` e `<SUA_SENHA>` pelas credenciais do banco de dados.

## Execução

1. Certifique-se de que o Maven está instalado.
2. No diretório raiz do projeto, execute o seguinte comando para iniciar a aplicação:

```bash
./mvnw spring-boot:run
```

A aplicação será iniciada e estará disponível em `http://localhost:8080`.

## Notas Adicionais

- **Collection**: Existe uma collection disponível na raiz do projeto para ser importada no Postman.

- **Driver PostgreSQL**: O projeto já inclui a dependência no arquivo `pom.xml`:

  ```xml
  <dependency>
      <groupId>org.postgresql</groupId>
      <artifactId>postgresql</artifactId>
      <version></version>
  </dependency>
  ```

- **Estrutura do Banco de Dados**: A aplicação criará ou atualizará automaticamente o esquema do banco de dados com base nas entidades definidas no código, devido à propriedade `spring.jpa.hibernate.ddl-auto=update`.

- **Dados Iniciais**: Caso necessário, insira dados iniciais no banco de dados manualmente ou configure uma classe de inicialização dentro do projeto.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para enviar pull requests ou abrir issues com sugestões e melhorias.

---
