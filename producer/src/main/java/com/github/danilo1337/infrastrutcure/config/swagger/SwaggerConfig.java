package com.github.danilo1337.infrastrutcure.config.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	
	@Value("${application.name}")
	private String name;
	
	@Value("${application.version}")
	private String version;
	
	@Value("${application.description}")
	private String description;
	
	@Bean
	public OpenAPI openAPI() {
		
	  return new OpenAPI()
	          .info(new Info()
	                  .title(name)
	                  .description(description)
	                  .version(version)
	                  .termsOfService("Termo de uso: Open Source")
	                  .license(new License()
	                          .name("Apache 2.0")
	                          .url("http://www.seusite.com.br")
	                  )
	          ).externalDocs(
	                  new ExternalDocumentation()
	                  .description("Github")
	                  .url("https://github.com/danilo1337/estudo-kafka"));
	}
		
}