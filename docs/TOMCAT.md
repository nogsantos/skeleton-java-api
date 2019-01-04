# Setup war Tomcat 9

Instruções para o deploy

## App

Build do projeto

```bash
$ ./gradlew build
```

War

```bash
$ ./gradlew bootWar
```

##### Ponto de atenção

> No arquivo de configuração  `build.gradle` está configurado para geração dos artefatos, nome e versão, através das variáveis de ambiente configuradas para o projeto. Dessa forma, é importante que estejam setadas no S.O, ou na sessão do terminal em questão.

Ao rodar o build, o arquivo será gerado no diretório `/build/libs` no projeto 

## Tomcat

Tomcat [versão 9](tomcatdonwload), utilizando sua configuração padrão com alguns ajustes.

Os comandos para inicializar, parar... o tomcat são: 

```bash
$ ./bin/catalina.sh [acao]
```

que podem ser

```bash
commands:
  debug             Start Catalina in a debugger
  debug -security   Debug Catalina with a security manager
  jpda start        Start Catalina under JPDA debugger
  run               Start Catalina in the current window
  run -security     Start in the current window with security manager
  start             Start Catalina in a separate window
  start -security   Start in a separate window with security manager
  stop              Stop Catalina, waiting up to 5 seconds for the process to end
  stop n            Stop Catalina, waiting up to n seconds for the process to end
  stop -force       Stop Catalina, wait up to 5 seconds and then use kill -KILL if still running
  stop n -force     Stop Catalina, wait up to n seconds and then use kill -KILL if still running
  configtest        Run a basic syntax check on server.xml - check exit code for result
  version           What version of tomcat are you running?
```

### Variáveis de ambiente

No diretório do tomcat, para setar as variáveis de ambiente utilizadas no projeto:

1. Criar um arquivo com o nome `setenv.sh` no diretório `<tomcat-install-dir>/bin`
2. Setar o arquivo executável `chmod +x setenv.sh`
3. No arquivo setar os valores dos parâmetros Ex.: `export APPLICATION_NAME=--pkg-name`
4. Reiniciar o Tomcat

### Deploy

O contexto default da aplicação será o nome do `war` gerado ex.: `http://localhost:8080/--pkg-name-0.1.0/` 

#### Manual 

Mover o arquivo `war` para `webapps` dentro do diretório do tomcat e inicializá-lo

#### Tomcat manager

Utilizar uma interface para gerenciamento do tomcat `http://localhost:8080/manager`

##### Tomcat user

Adicionar o usuário para gerenciamento `conf/tomcat-users.xml`

```xml
<role rolename="tomcat"/>
<role rolename="manager"/>
<role rolename="manager-gui"/>
<role rolename="manager-script"/>
<role rolename="manager-jmx"/>
<role rolename="manager-status"/>
<role rolename="admin-gui"/>
<user username="<usuario>" password="<senha>" roles="tomcat,manager,manager-gui,manager-script,manager-jmx,manager-status,admin-gui"/>
```
##### Limite Upload

Dependendo do tamanho final do arquivo `war` gerado, o limite padrão definido pelo tomcat pode ser extrapolado e será necessário aumentá-lo, para isso, edite o arquivo `webapps/manager/WEB-INF/web.xml` com tamanho necessário para o updload.

Ex.:

No arquivo, localize a linha com o seguinte trecho de código e redefina os valores:

```xml
<multipart-config>
  <!-- 50MB max -->
  <max-file-size>52428800</max-file-size>
  <max-request-size>52428800</max-request-size>
  <file-size-threshold>0</file-size-threshold>
</multipart-config>
```

Após as alterações, reinicie o tomcat novamente.

##### Acesso manager

Se for necessário que se disponibilize o acesso ao manager do tomcat externamente, deve ser configurado, além do usuário, o contexto para o acesso.

Criar o arquivo `manager.xml` em `conf/Catalina/localhost/`

Conteúdo do arquivo: 

```xml
<Context privileged="true" antiResourceLocking="false" docBase="${catalina.home}/webapps/manager">
    <Valve className="org.apache.catalina.valves.RemoteAddrValve" allow="^.*$" />
</Context>
 ```
Após as alterações, reinicie o tomcat novamente.

[tomcatdonwload]:http://mirror.nbtelecom.com.br/apache/tomcat/tomcat-9/v9.0.14/bin/apache-tomcat-9.0.14.tar.gz
