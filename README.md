# --pkg-name

#### Importante

>
> O ambiente de desenvolvimento foi configurado em sistema com base Unix, Mac e Linux, ou seja, pode haver divergência caso seja utilizado o Windows para desenvovlimento, dessa forma, caso seja extremamente necessário que se desenvolva nessa plataforma, as configurações podem variar, porém, não pude fazer os testes e nem tenho a pretenção de fazê-los para desenvolvimento em Windows.
>
> Dessa forma, todas as configurações foram realizadas utilizando a linha de comando.
>

## Setup

Para preparar o ambiente de desenvolvimento, é necessário gerar as variáveis de ambiente para a conexão com o banco de dados e baixar as dependências do projeto

##### Variáveis de ambiente

Executar

```shell
$ ./setup.sh
```

Ao final do processo, além da impressão das variáveis geradas no console, o arquivo `.env` será gerado na raiz do projeto.

> Ps.: As variáveis de sessão serão criadas apenas para a sessão do terminal em questão.
 
##### Dependências do projeto

```shell
$ ./gradle build
```

### Iniciar para desenvolvimento

Executar o projeto com suporte para auto-detecção da classe principal e recarregando recursos estáticos

```shell
$ ./gradle bootRun
```

### Build

Compila e testa o projeto

```shell
$ ./gradlew build
```

Executar apenas os testes pelo spring boot

```shell
$ ./gradlew test --debug
```

## Available Tasks

Todas as tarefas devem ser executadas à partir da base do projeto `./`

### Build tasks

- `assemble` - Assembles the outputs of this project.
- `bootRepackage` - Repackage existing JAR and WAR archives so that they can be executed from the command line using 'java -jar'
- `buildDependents` - Assembles and tests this project and all projects that depend on it.
- `buildNeeded` - Assembles and tests this project and all projects it depends on.
- `classes` - Assembles main classes.
- `clean` - Deletes the build directory.
- `jar` - Assembles a jar archive containing the main classes.
- `testClasses` - Assembles test classes.
- `war` - Generates a war archive with all the compiled classes, the web-app content and the libraries.

### Build Setup tasks

- `init` - Initializes a new Gradle build.
- `wrapper` - Generates Gradle wrapper files.

### Documentation tasks

- `javadoc` - Generates Javadoc API documentation for the main source code.

### Help tasks

- `buildEnvironment` - Displays all buildscript dependencies declared in root project '--pkg-name'.
- `components` - Displays the components produced by root project '--pkg-name'. [incubating]
- `dependencies` - Displays all dependencies declared in root project '--pkg-name'.
- `dependencyInsight` - Displays the insight into a specific dependency in root project '--pkg-name'.
- `dependencyManagement` - Displays the dependency management declared in root project '--pkg-name'.
- `dependentComponents` - Displays the dependent components of components in root project '--pkg-name'. [incubating]
- `help` - Displays a help message.
- `model` - Displays the configuration model of root project '--pkg-name'. [incubating]
- `projects` - Displays the sub-projects of root project '--pkg-name'.
- `properties` - Displays the properties of root project '--pkg-name'.
- `tasks` - Displays the tasks runnable from root project '--pkg-name'.

### Verification tasks

- `check` - Runs all checks.
- `test` - Runs the unit tests.

### Rules

- `Pattern: clean<TaskName>`: Cleans the output files of a task.
- `Pattern: build<ConfigurationName>`: Assembles the artifacts of a configuration.
- `Pattern: upload<ConfigurationName>`: Assembles and uploads the artifacts belonging to a configuration.
