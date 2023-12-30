package com.springboot.customdbsecurity;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.print.Doc;

@Configuration
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.sb"))
//                .paths(PathSelectors.regex("/.*"))
//                .build().apiInfo(apiInfoMetaData());
//    }
//
//
//    private ApiInfo apiInfoMetaData() {
//
//        return new ApiInfoBuilder().title("NAME OF SERVICE")
//                .description("API Endpoint Decoration")
//                .contact(new Contact("Dev-Team", "https://www.dev-team.com/", "dev-team@gmail.com"))
//                .license("Apache 2.0")
//                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
//                .version("1.0.0")
//                .build();
//    }


    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.springboot.customdbsecurity"))
                .paths(PathSelectors.regex("/.*")).build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("").description("").
                contact(new Contact("Dev-Team", "https://www.dev-team.com/", "dev-team@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }

}

// http://localhost:8080/swagger-ui/index.html //