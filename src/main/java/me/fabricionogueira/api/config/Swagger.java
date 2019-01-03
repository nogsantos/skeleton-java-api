package me.fabricionogueira.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class Swagger {

	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${spring.application.description}")
	private String applicationDescription;

	@Value("${spring.application.version}")
	private String applicationVersion;

	@Value("${spring.application.contact.name}")
	private String applicationContactName;

	@Value("${spring.application.contact.site}")
	private String applicationContactSite;

	@Value("${spring.application.contact.email}")
	private String applicationContactEmail;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("me.fabricionogueira.api"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(apiInfo())
			.useDefaultResponseMessages(false);

	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
			applicationName,
			applicationDescription,
			applicationVersion,
			null,
			new Contact(
				applicationContactName,
				applicationContactSite,
				applicationContactEmail
			),
			null,
			null,
			Collections.emptyList()
		);
	}
}
