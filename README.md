![milenio capital](https://user-images.githubusercontent.com/80921933/166538142-3d177de7-8596-4ebf-a9c4-997287fa70f1.png)
# Teste técnico - Milênio Capital

>Status: Em andamento ⚠️

## Tecnologias usadas:

+ Java
+ Docker
+ Spring Data JPA
+ Hibernate
+ Mockito
+ Prometheus
+ Grafana
+ Swagger

## Como rodar a aplicação?

+ 1- Clone o projeto para o diretório desejado
+ 2- Abra um terminal (git bash, de preferência) na raiz do projeto
+ 3- Execute os seguintes comandos:
```
mvn clean install
mvn clean package
docker-compose up -d
```

+ 4- Rode a aplicação com o IntelliJ
+ 5- Acesse os endpoints da aplicação, via `localhost:8080/{endpointDesejado}`

## Acesso às tabelas

Como o ambiente da aplicação sobe via docker-compose, o MySQL é um contêiner, e para acessar as tabelas, deve-se executar, na raiz do projeto, os seguintes comandos:
```
docker exec -it mysql mysql -uroot -proot
use teste_mcapital;
select * from [NOME_TABELA];
```
![route](https://user-images.githubusercontent.com/80921933/166553435-f53c0c8f-e51b-4bde-820d-ae0054972360.png)



## Features

+ <b>Validações de entrada:</b> Ao tentar realizar uma entrada com dados inválidos ou incompletos, o projeto retorna, precisamente, onde está o problema, por meio de uma lista de excessões personalizadas.

COLOCAR IMAGEM VALIDAÇÃO

+ <b>Utilização do @Transactional:</b> A utilização do `@Transactional` é de suma importância em casos onde, por alguma regra de negócio, a transação do banco de dados não deve ser finalizada. A anotação é responsável pela execução do rollback, e evita a inserção/atualização/deleção de dados que, a priori, não deveriam ser modificados quando o fluxo de dados é interrompido.

COLOCAR IMAGEM TRANSACTIONAL

+ <b>Subindo o ambiente via docker-compose:</b> Todo o ambiente da aplicação sobe via docker-compose. Pode-se, também, subir o app inteiro, fato que facilita o deploy em produção. Além disso, são disponibilizadas portas para aplicações de observabilidade, como:

  `localhost:3000` - Grafana <br>
  `localhost:9090` - Prometheus
  
+ <b>Testes unitários:</b> Os testes são de suma importância para garantir a confiabilidade da aplicação. Neste projeto, foram aplicados testes na camada de serviço e na camada acesso ao banco de dados.

![testes](https://user-images.githubusercontent.com/80921933/166562548-fd0a521b-c8fa-4921-b867-f69a3a3fc77b.png)


+ <b>Ferramentas de observabilidade:</b> O Grafana é uma ferramenta que, com o auxílio do Prometheus, gera dados importantes para verificarmos a saúde da nossa API. Por meio dela, podemos verificar, por exemplo, quantos erros foram gerados em um determinado endpoint, e, dessa forma, facilitar a vida do programador na busca por erros, ou até mesmo a otimizar endpoints falhos.

COLOCAR IMAGEM GRAFANA DASHBOARD

## Melhorias

COLOCAS MELHORIAS
