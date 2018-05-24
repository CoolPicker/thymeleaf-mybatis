package com.nya;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SpringBoot整合Swagger2配置类
 * 注意：与application启动类同级目录
 * @Author: nya
 * @Date: 18-5-24 上午10:14
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    /**
     * swagger基本信息配置，扫描包等
     * @return
     */
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nya.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建api文档的详细信息配置
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("SpringBoot 整合 swagger 测试 restful api")
                .contact(new Contact("nya","http://www.baidu.com","niuya312@163.com"))
                .version("1.0")
                .description("API 描述")
                .build();
    }

}
