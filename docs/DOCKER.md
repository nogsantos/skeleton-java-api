# Docker

No projeto há um arquivo `docker-composer` configurado para criar o banco de dados do projeto recebendo as variáveis de ambiente geradas.

## Conteiner para a base de dados

Para o conteiner, é necessário que no ambiente estejam instalados o [Docker CE](https://docs.docker.com/v17.12/install/) juntamente com o [docker-compose](https://docs.docker.com/compose/install/)

##### Subir

```bash
$ docker-compose up [opcional -d para rodar em segundo plano]
```

##### Finalizar

```bash
$ docker-compose down
```  
