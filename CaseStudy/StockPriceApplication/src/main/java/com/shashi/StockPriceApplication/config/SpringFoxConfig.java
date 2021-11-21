package com.shashi.StockPriceApplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SpringFoxConfig 
{
	/*
	@Bean
	public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
          .select()                                  
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())
          .build();                                           
    }
    */
	
    @Bean
    public Docket todoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("stock-market-charting-api")
                .apiInfo(apiInfo())
                .select()
                .paths(postPaths())
                .build();
    }
    
    private Predicate<String> postPaths() {
        return or(regex("/stockPrices.*"));
    }
    
    private ApiInfo apiInfo() 
    {
        return new ApiInfoBuilder()
        		.title("Stock Price Rest APIs")
                .description("API reference for Stock Price Service")
                .contact(new Contact("L Sai Shashi Kumar Reddy", "https://github.com/sk-reddy17", "skrlekkala@gmail.com"))
                .version("1.0")
                .build();
    }
}