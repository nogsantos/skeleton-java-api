# Swagger

No projeto, a principal utilizada é gerar a documentação dos endpoints. Não está sendo utilizado para geração de código

## Setup

A documentação deve ser criada à partir das anotações implementadas nos endpoints nos controladores dos módulos

Ex.: 

```java
@ApiOperation(
	value = "Resource with param",
	notes = "Enabled and documenting params"
)
@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Request Success")
})
@ApiImplicitParams({
	@ApiImplicitParam(
		name = "Authorization",
		value = "Authorization token",
		required = true,
		paramType = "header"
	)
}) 
public ResponseEntity<String> hello(@RequestParam(required = true) @ApiParam(value = "Some string value") String param) {
	return response.ok("Hello " + param);	
}
```

### Swagger UI

Acessar a documentação gerada `http://[url]:[porta]/swagger-ui.html#/`

##### Referências

- [Usage of swagger in spring-boot applications](https://dzone.com/articles/usage-of-swagger-20-in-spring-boot-applications-to)
- [Swagger documentation for spring rest api](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api)
