# Gradle 5.1

##### Dependências do projeto

```bash
$ ./gradlew build
```

### Iniciar para desenvolvimento

Executar o projeto com suporte para auto-detecção da classe principal e recarregando recursos estáticos

```bash
$ ./gradlew bootRun
```

Executar testes de integração com spring boot

```bash
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
- `jar or bootJar` - Assembles a jar archive containing the main classes.
- `testClasses` - Assembles test classes.
- `war or bootWar` - Generates a war archive with all the compiled classes, the web-app content and the libraries.

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
