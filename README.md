# Teste Run2Biz

## Descrição
Teste baseado no repositório [Run2Biz - Teste Backend Java](https://github.com/run2biz/teste-backend-java).

## Variáveis de ambiente

| Variável     | Finalidade                             |
| ------------ | -------------------------------------- |
| fa_db_serv   | Hostname do servidor de banco de dados |
| fa_db_data   | Database name                          |
| fa_db_user   | Usuário para acesso ao banco de dados  |
| fa_db_pass   | Senha para acesso ao banco de dados    |

## Execução

### Dependências
- Lombok - necessário instalar lombok se for rodar no eclipse. Instruções para instalação no eclipse estão em: [Eclipse, Spring Tool Suite, (Red Hat) JBoss Developer Studio, MyEclipse](https://projectlombok.org/setup/eclipse). Para outras IDEs pode ser encontrado em: [Using lombok](https://projectlombok.org/setup/)

### Apenas aplicação s/ banco de dados(obrigatório postgress externo)

1. Obrigatório ter um banco de dados postgre para conseguir fazer o teste, seja localmente ou remotamente.

2. Compilar a aplicação

```
mvn clean compile package -Dfa_db_serv=<substituir> -Dfa_db_data=<substituir> -Dfa_db_user=<substituir> -Dfa_db_pass=<substituir>
```

este processo irá gerar um arquivo .jar na pasta target com o nome de Run2BizBff-0.0.1-SNAPSHOT.jar, com este arquivo execute o comando abaixo

```
java -jar Run2BizBff-0.0.1-SNAPSHOT.jar -Dfa_db_serv=<substituir> -Dfa_db_data=<substituir> -Dfa_db_user=<substituir> -Dfa_db_pass=<substituir>
```

### Subir usando o docker c/ bando de dados

Substituir os valores no arquivo .env na pasta raiz onde se encontra o Dockerfile e docker-compose.yml e executar o seguinte comando.
```
docker compose up -d
```

## Referências

- [Run2Biz - Teste Backend Java](https://github.com/run2biz/teste-backend-java)
- [Simple calculations for working with lat/lon and km distance?](https://stackoverflow.com/questions/1253499/simple-calculations-for-working-with-lat-lon-and-km-distance)