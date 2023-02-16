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
| fa_map_quest | Chave para a API do MapQuest           |

## Execução

### Dependências
- Lombok

### Apenas aplicação

```
java -jar ....
```

### Subir apenas aplicação

Substituir os valores no arquivo .env na pasta raiz onde se encontra o Dockerfile e docker-compose.yml
```
docker compose up -d
```

## Referências

- [Run2Biz - Teste Backend Java](https://github.com/run2biz/teste-backend-java)
- [Simple calculations for working with lat/lon and km distance?](https://stackoverflow.com/questions/1253499/simple-calculations-for-working-with-lat-lon-and-km-distance)