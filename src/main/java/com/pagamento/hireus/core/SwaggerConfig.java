package com.pagamento.hireus.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String BASE_PACKAGE = "com.pagamento.hireus.api.controller";
    private static final String API_TITLE = "API de Folha de Pagamento";
    private static final String API_DESCRIPTION = "O projeto HireUs consiste em uma REST api com regra de negócio: Folha de pagamento.\n" +
			 									"O sistema permite criar funcionários, cargos, e aplicar regras de negócios financeiros e acompanhar o holerite mensal.";
    private static final String CONTACT_NAME = "Projeto HIRE US";
    private static final String CONTACT_GITHUB = "https://github.com/Camargovf/RestAPI-Folha-de-Pagamento";
    private static final String CONTACT_EMAIL = "Em construção";

    //Classe Externa Docket
	@Bean
	public Docket folhaPagamentoApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(construirApiInfo());
	}
	
	private ApiInfo construirApiInfo() {
		return new ApiInfoBuilder()
				.title(API_TITLE)
				.description(API_DESCRIPTION)
				.version("1.0.0")
				.contact(new springfox.documentation.service.Contact(CONTACT_NAME, CONTACT_GITHUB, CONTACT_EMAIL))
				.build();
	}
}