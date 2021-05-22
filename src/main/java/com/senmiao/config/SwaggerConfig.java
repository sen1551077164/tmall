package com.senmiao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
@Component
public class SwaggerConfig {
    //配置swagger的docket的bean实例
    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("tmall aip接口文档")
                .apiInfo(webApiInfo())
                .enable(true)
                .select()
                //需要扫描的控制类包
                .apis(RequestHandlerSelectors.basePackage("com.senmiao.controller"))
                .build();

    }

    //配置swagger信息
    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                .title("标题")
                .description("描述")
                .version("1.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}