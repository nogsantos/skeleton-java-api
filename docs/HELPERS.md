# Helpers

São as bibliotecas auxiliares utilizadas no sistema.

## Lombok 1.18

O Projeto Lombok é uma biblioteca java que automatiza a criação de método padrões como getter, setters, equals, etc. Com uma anotação nas classe esses métodos são gerados no build.

Na IDE, é necessário que se utilize o plugin:

- [Intellij](https://projectlombok.org/setup/intellij)
- [VSCode](https://projectlombok.org/setup/vscode)

Ex.:

##### Classe
 
```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Some {
	...
}
```

##### Atributos
 
```java
public class Some {
	@Setter
	private String foo;	
	...
}
```

## MapStruct 1.2

Um gerador de código que simplifica a implementação de mapeamentos entre os tipos de Java beans com base em uma abordagem de convenção sobre configuração. No projeto inicialmente utilizando para mapeamento dos DTO's

[Documentação e exemplo](http://mapstruct.org/#get-started)

## Json 20180813

JSON é um formato de intercâmbio de dados leve, independente de linguagem.

Ex.:

##### Gerando um objeto 

```java
JSONObject userDetails = new JSONObject();
userDetails.put("id", user.getId());
userDetails.put("name", user.getName());
userDetails.put("email", user.getEmail());
```

##### Lendo um objeto 

```java
JSONObject user = new JSONObject(auth.getName());
return response.ok("bye " + user.get("name") + "!");
```

## Apache Commons lang3 3.8.1

Lang fornece uma série de utilitários auxiliares para a API java.lang, métodos de manipulação de strings, métodos numéricos básicos, reflexão de objetos, simultaneidade, criação e serialização e propriedades do sistema. Além disso, ele contém aprimoramentos básicos para java.util.Date e uma série de utilitários dedicados a ajudar na construção de métodos, como hashCode, toString e equals.

Ex.:

##### Gerar uma string aleatória 

```java
import org.apache.commons.lang3.RandomStringUtils;

...

public static String value(Integer length) {
	return RandomStringUtils.randomAlphanumeric(new Random().nextInt(checkLength(length)));
}
```
