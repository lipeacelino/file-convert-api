
# file-processing-api

Este projeto é uma API de conversão de dados que recebe um arquivo e converte seus dados para serem consumidos em formato json através de uma API REST. Foi desenvolvida usando Java 17 e Spring Boot 3. A aplicação utiliza MongoDB para armazenamento de dados e Redis para caching, visando otimizar a performance especialmente em operações que envolvem grande volume de dados.


## API

#### Retorna todos os itens ou de acordo com os filtros

```http
  GET /orders
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `size` | `int` | **Opcional** Quantidade máxima de arquivos retornados |
| `page` | `int` | **Opcional** Navegação entre as páginas |
| `sort` | `string` | **Opcional** Ordenar por campo de forma ASC ou DESC |
| `userId` | `int` | **Opcional** Pesquisa por id de usuário |
| `name` | `string` | **Opcional** Pesquisa por nome de usuário |

#### Faz upload de arquivo

```http
  POST /orders/upload
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `file`      | `string` | **Obrigatório** Campo que é passado o arquivo |


## Tecnologias Utilizadas

- Java 17: Linguagem de programação.
- Spring Boot 3: Framework para desenvolvimento de aplicações Spring com mais agilidade.
- MongoDB: Banco de dados NoSQL para armazenamento de dados.
- Redis: Armazenamento de estrutura de dados em memória, usado como sistema de cache.


## Execução

Para executar o projeto, é necessário ter as tecnologias mencionadas instaladas, configurar o seu usuário e senha do mongo no application.properties e em seguida rodar a aplicação. Para rodar a aplicação basta ir na classe FileConvertApiApplication, onde o método principal pode ser executado para iniciar a aplicação.

- **Um detalhe importante: a collection para fazer requisições via Postman está disponível nos arquivos do projeto**

## Estrutura do Projeto
O projeto segue uma arquitetura em camadas, organizada da seguinte forma:
- controllers: Camada de apresentação que lida com as requisições HTTP.
- documents: Classes que representam os documentos armazenados no MongoDB.
- dto: Data Transfer Objects para encapsular os dados que são transferidos entre as camadas.
- exceptions: Tratamento centralizado de exceções.
- mappers: Utilização do MapStruct para mapeamento entre entidades e DTOs.
- repositories: Camada de acesso aos dados, interagindo diretamente com o banco de dados.
- services: Lógica de negócios da aplicação.

## Detalhe Sobre as Validações no Service

Há duas validações que são feitas em cada linha do arquivo para garantir a integridade dos dados, se uma dessas duas validações falha, a linha em questão não é salva, mas, o processamento continua e ao final é mostrado todas as linhas que tiveram erro para o usuário poder tratar e reprocessá-las.


## Escolha do MongoDB
Optei pelo MongoDB devido à sua facilidade de uso e performance superior em cenários que exigem inserção frequente de grande volume de dados. Inicialmente, testes com bancos SQL mostraram latências maiores, o que foi significativamente melhorado com o uso do MongoDB, especialmente com a aplicação de índices.
## Práticas de Desenvolvimento

Em todo o código, mantive uma abordagem coerente e coesa na escolha dos nomes das classes, variáveis e métodos. Priorizei a simplicidade e as boas práticas de programação, incluindo a organização estrutural em pacotes, injeção de dependências via construtor para facilitar os testes, utilização de DTOs, definição de expressões regulares em variáveis estáticas para simplificar a manutenção, tratamento adequado de exceções, implementação de cache e paginação, além de princípios do SOLID.
## Testes Unitários
Os testes unitários foram desenvolvidos visando o isolamento de componentes, utilizando constantes e métodos específicos em cada classe, para evitar interdependências entre testes, facilitando a manutenção futura.
