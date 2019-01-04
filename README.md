# --pkg-name

[![CircleCI](https://circleci.com/gh/nogsantos/skeleton-java-api.svg?style=svg)](https://circleci.com/gh/nogsantos/skeleton-java-api)
 
Projeto base para construções de API RestFull utilizando Spring boot versão 2 como framework principal.

### Command Line Interface

Para realizar a substituição dos parâmetros utilizados na definição do projeto, utilize [CLI](nogsantoscli) selecionando a opção `❯ Java for RestFull API ` 

![](https://res.cloudinary.com/nogsantos/image/upload/v1546616696/Screenshot_from_2019-01-04_13-39-00_msw0et.png)
## Configurações e Setup

Todas as documentações para a configuração das bibliotecas, tarefas e setup do projeto estão disponíveis em [docs/conf](./docs/CONF.md) 

## Tecnologias

O projeto base utiliza as seguintes bibliotecas e frameworks

#### Core e build

<table>
	<theader>
		<tr>
			<th align="center">Spring boot</th>
			<th align="center">Gradle</th>      
		</tr>
	</theader>
  	<tbody>    
		<tr>
			<td align="center">
				<img src="https://res.cloudinary.com/nogsantos/image/upload/c_scale,w_100/v1546619148/java-skeleton/spring-boot-2.png" alt="Spring boot" />      	
			</td>
			<td align="center">
				<img src="https://res.cloudinary.com/nogsantos/image/upload/c_scale,w_100/v1546619391/java-skeleton/gradle-logo-png-transparent.png" alt="Gradle" />     
			</td>      
		</tr>
		<tr>			
			<td></td>
			<td>
				<ul>
					<li><a href="./docs/GRADLE.md">Referência</a></li>				
				</ul>    		
			</td>
		</tr>
	</tbody>
</table>

#### Banco de dados

<table>
	<theader>
		<tr>
		  <th align="center">PostgreSQL</th>      
		  <th align="center">Persistence API</th>      
		  <th align="center">Flywaydb</th>      
        </tr>
	<theader>
	<tbody>    
    	<tr>
      		<td align="center">
      			<img src="https://res.cloudinary.com/nogsantos/image/upload/c_scale,w_100/v1546621077/java-skeleton/200px-Pg_logo.png" alt="Postgres" />      	
			</td>
			<td align="center">
				<img src="https://res.cloudinary.com/nogsantos/image/upload/c_scale,w_100/v1546621470/java-skeleton/Hibernate-logo.png" alt="Persistence" />     
			</td>
			<td align="center">
				<img src="https://res.cloudinary.com/nogsantos/image/upload/c_scale,w_100/v1546621576/java-skeleton/flyway-logo-tm.png" alt="Flywaydb" />     
			</td>      
    	</tr>
    	<tr>
			<td></td>
			<td>
				<ul>
					<li><a href="https://spring.io/projects/spring-data-jpa">Referência</a></li>
					<li><a href="./docs/PERSISTENCE.md">Documentação</a></li>
				</ul>    		
			</td>    
			<td>
				<ul>
					<li><a href="https://flywaydb.org/">Referência</a></li>
					<li><a href="./docs/FLYWAYDB.md">Documentação</a></li>
				</ul>    		
			</td>	
		</tr>
  	</tbody>
</table>
 
 #### Autenticação

<table>
	<theader>
		<tr>
			<th align="center">Spring-security</th>
			<th align="center">JWT</th>
			<th align="center">Oauth2</th>      
		</tr>
	</theader>
	<tbody>    
		<tr>
			<td align="center">
				<img src="https://res.cloudinary.com/nogsantos/image/upload/c_scale,w_100/v1546619807/java-skeleton/spring-security.png" alt="Spring-security" />      	
			</td>
			<td align="center">
				<img src="https://res.cloudinary.com/nogsantos/image/upload/c_scale,w_100/v1546620026/java-skeleton/jwt-logo-400.png" alt="JWT" />     
			</td>
			<td align="center">
				<img src="https://res.cloudinary.com/nogsantos/image/upload/c_scale,w_100/v1546620358/java-skeleton/oauth2_logo.png" alt="Oauth2" />     
			</td>      
		</tr>  
		<tr>
			<td></td>
			<td>
				<ul>
					<li><a href="https://jwt.io/">Referência</a></li>				
				</ul>    		
			</td>	
			<td></td>
		</tr>  
	</tbody>
</table>

#### Documentação, CI e Container

<table>
	<theader>
		<tr>
			<th align="center">Swagger</th>
			<th align="center">CircleCI</th>      
			<th align="center">Docker</th>      
		</tr>
	</theader>
	<tbody>    
		<tr>
			<td align="center">
				<img src="https://res.cloudinary.com/nogsantos/image/upload/c_scale,w_100/v1546618916/java-skeleton/swagger-logo-300x239.png" alt="Swagger" />      	
			</td>
			<td align="center">
				<img src="https://res.cloudinary.com/nogsantos/image/upload/c_scale,w_100/v1546623211/java-skeleton/circleci-logo-stacked-fb.png" alt="CircleCI" />     
			</td>
			<td align="center">
				<img src="https://res.cloudinary.com/nogsantos/image/upload/c_scale,w_100/v1546631567/java-skeleton/docker.png" alt="Docker CE" />     
			</td>
		</tr>
		<tr>
			<td>
				<ul>
					<li><a href="./docs/SWAGGER.md">Referência</a></li>				
				</ul>    		
			</td>	
			<td></td>
			<td>
				<ul>
					<li><a href="./docs/DOCKER.md">Documentação</a></li>				
				</ul>
			</td>
		</tr>
	</tbody>
</table>

#### Ferramentas para desenvolvimento e produtividade

<table>
	<theader>
		<tr>
			<th align="center">Lombok</th>      
			<th align="center">MapStruct</th>      
			<th align="center">Helpers</th>      
		</tr>
	</theader>
  	<tbody>    
		<tr>
			<td align="center">
				<img src="https://res.cloudinary.com/nogsantos/image/upload/c_scale,w_100/v1546622165/java-skeleton/255-2556400_project-lombok-logo.jpg" alt="Lombok" />      	
			</td>
			<td align="center">
				<img src="https://res.cloudinary.com/nogsantos/image/upload/c_scale,w_100/v1546622349/java-skeleton/mapstruct.png" alt="MapStruct" />     
			</td>
			<td align="center">
				<img src="https://res.cloudinary.com/nogsantos/image/upload/c_scale,w_100/v1546622897/java-skeleton/package-153360_960_720.png" alt="Flywaydb" />     
			</td>      
		</tr>
		<tr>
			<td>
				<ul>
					<li><a href="./docs/HELPERS.md">Documentação</a></li>
				</ul>
			</td>
			<td>
				<ul>
					<li><a href="./docs/HELPERS.md">Documentação</a></li>
				</ul>
			</td>    
			<td>
				<ul>
					<li><a href="./docs/HELPERS.md">Documentação</a></li>
					<li><a href="https://github.com/stleary/JSON-java">Json</a></li>
					<li><a href="https://commons.apache.org/proper/commons-lang/">Apache Commons</a></li>
				</ul>    		
			</td>	
		</tr>
	</tbody>
</table>

#### Testes

<table>
	<theader>
		<tr>
			<th align="center">Junit</th>      
			<th align="center">Mockito</th>      
			<th align="center">Hamcrest</th>      
		</tr>
	</theader>
	<tbody>
    	<tr>
			<td align="center">
      			<img src="https://res.cloudinary.com/nogsantos/image/upload/c_scale,w_100/v1546623540/java-skeleton/junit5-logo.png" alt="Junit" />      	
			</td>
      		<td align="center">
      			<img src="https://res.cloudinary.com/nogsantos/image/upload/c_scale,w_100/v1546623627/java-skeleton/mockito-logo.png" alt="Mockito" />     
      		</td>
      		<td align="center">
      			<img src="https://res.cloudinary.com/nogsantos/image/upload/c_scale,w_100/v1546623461/java-skeleton/hamcrast.jpg" alt="Hamcrest" />     
      		</td>      
    	</tr>    
  	</tbody>
</table>


[nogsantoscli]:https://www.npmjs.com/package/@nogsantos/fn-cli
