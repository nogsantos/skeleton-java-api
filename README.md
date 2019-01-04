# --pkg-name

[![CircleCI](https://circleci.com/gh/nogsantos/skeleton-java-api.svg?style=svg)](https://circleci.com/gh/nogsantos/skeleton-java-api)

#### Importante

>
> O ambiente de desenvolvimento foi configurado em sistema com base Unix, Mac e Linux, ou seja, pode haver divergência caso seja utilizado o Windows para desenvovlimento, dessa forma, caso seja extremamente necessário que se desenvolva nessa plataforma, as configurações podem variar, porém, não pude fazer os testes e nem tenho a pretenção de fazê-los para desenvolvimento em Windows.
>
> Dessa forma, todas as configurações foram realizadas utilizando a linha de comando.
>

## Setup

Para preparar o ambiente, é necessário gerar as variáveis de ambiente para a conexão com o banco de dados e baixar as dependências do projeto

##### Variáveis de ambiente

##### Executar

```bash
$ ./setup.sh
```

Ao final do processo, além da impressão das variáveis geradas no console, o arquivo `.env` será gerado na raiz do projeto.

> Ps.: As variáveis de sessão serão criadas apenas para a sessão do terminal em questão.

##### Export no terminal

Exportar todas as variáveis de ambiente geradas, para a sessão atual do terminal

Com [Fish shell](https://fishshell.com/)

```shell
$ export (cat .env)
```

Terminal sem fish

```bash
$ export $(cat .env)
``` 
 
## Configurações

Todas as documentações para a configuração, tarefas e setup do projeto estão disponíveis em [Configurações](./docs/CONF.md)
