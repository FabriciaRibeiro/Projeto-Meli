SocialMeli API

API REST desenvolvida em Java com Spring Boot como parte do Bootcamp Mercado Livre, com o objetivo de implementar uma versão beta da funcionalidade SocialMeli, permitindo a interação social entre compradores e vendedores.

🎯 Objetivo

O objetivo deste projeto é aplicar os conceitos de:

APIs REST

Arquitetura em camadas

Validações

Tratamento de exceções

Documentação Swagger

Testes unitários e de integração

seguindo rigorosamente a especificação funcional fornecida pelo desafio API Social MELI.

📌 Funcionalidades Implementadas
Usuários

Seguir um vendedor

Deixar de seguir um vendedor

Obter quantidade de seguidores de um vendedor

Listar seguidores de um vendedor

Listar vendedores seguidos por um usuário

Ordenação alfabética (asc/desc)

Produtos

Registrar nova publicação

Registrar publicação promocional

Obter feed de publicações dos vendedores seguidos (últimas 2 semanas)

Ordenação por data (asc/desc)

Obter quantidade de produtos em promoção de um vendedor

🧱 Arquitetura do Projeto

O projeto segue uma arquitetura em camadas:

controller   → endpoints REST
service      → regras de negócio
dto          → objetos de entrada e saída
exception    → exceções customizadas
config       → configurações (Swagger)
repository   → abstração de dados (mock / in-memory)


Essa separação melhora a organização, manutenção e testabilidade do código.

🚀 Tecnologias Utilizadas

Java 21

Spring Boot

Spring Web

Spring Validation

SpringDoc OpenAPI (Swagger)

Gradle

JUnit 5

H2 (para testes)

🔗 Documentação da API (Swagger)

A API possui documentação interativa via Swagger.

Após subir a aplicação, acesse:

http://localhost:8080/swagger-ui/index.html


No Swagger é possível:

Visualizar todos os endpoints

Testar requisições

Ver exemplos de payload e respostas

📂 Principais Endpoints
👤 Usuários

Seguir vendedor
POST /users/{userId}/follow/{userIdToFollow}

Deixar de seguir vendedor
POST /users/{userId}/unfollow/{userIdToUnfollow}

Quantidade de seguidores
GET /users/{userId}/followers/count

Lista de seguidores
GET /users/{userId}/followers/list?order=name_asc|name_desc

Lista de vendedores seguidos
GET /users/{userId}/followed/list?order=name_asc|name_desc

🛒 Produtos

Publicar produto
POST /products/publish

Publicar produto promocional
POST /products/promo-pub

Feed das publicações (últimas 2 semanas)
GET /products/followed/{userId}/list?order=date_asc|date_desc

Quantidade de produtos em promoção
GET /products/promo-pub/count?user_id={userId}

✅ Validações Implementadas

IDs obrigatórios e maiores que zero

Strings com tamanho máximo definido

Campos obrigatórios validados

Regras de negócio:

Usuário não pode seguir a si mesmo

Não é permitido seguir o mesmo vendedor mais de uma vez

Não é permitido deixar de seguir quem não está sendo seguido

Produtos promocionais devem ter has_promo = true

❗ Tratamento de Erros

O projeto utiliza exceções customizadas e tratamento centralizado:

400 – Bad Request
Erros de validação e regras de negócio

404 – Not Found
Recursos inexistentes

Formato padrão de erro:

{
  "status": 400,
  "error": "Mensagem descritiva do erro"
}

🧪 Testes

O projeto possui testes unitários e testes de integração.

Executar todos os testes:
./gradlew clean test

Executar a aplicação:
./gradlew bootRun

⚠️ Observações

A persistência de dados é em memória

Não há autenticação ou autorização

Projeto voltado para fins educacionais e avaliação técnica

Estrutura preparada para evolução futura

🔮 Possíveis Melhorias Futuras

Persistência com JPA e banco relacional

Autenticação com JWT

Paginação de resultados

Cache do feed

Aumento da cobertura de testes

Monitoramento e métricas

📄 Status do Projeto

✔ Endpoints implementados
✔ Swagger configurado
✔ Estrutura organizada
⚠️ Projeto educacional (não produção)

👩‍💻 Autor

Projeto desenvolvido para o Bootcamp Mercado Livre – SocialMeli - Fabrícia Graziele Ribeiro.
