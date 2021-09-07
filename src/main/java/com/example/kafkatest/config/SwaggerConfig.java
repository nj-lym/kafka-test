package com.example.kafkatest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description swagger 配置类
 * @Auther lym
 * @Date 2021-09-07 9:42
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //swagger的实例bean是docket,所以通过配置Docket实例来配置swagger
    /*
    any() // 扫描所有，项目中的所有接口都会被扫描到
    none() // 不扫描接口
    // 通过方法上的注解扫描，如withMethodAnnotation(GetMapping.class)只扫描get请求
    withMethodAnnotation(final Class<? extends Annotation> annotation)
    // 通过类上的注解扫描，如.withClassAnnotation(Controller.class)只扫描有controller注解的类中的接口
    withClassAnnotation(final Class<? extends Annotation> annotation)
    basePackage(final String basePackage) // 根据包路径扫描接口
 */
 /*
    paths(PathSelectors.ant("/kuang/**")) // 配置如何通过path过滤,即这里只扫描请求以/kuang开头的接口
        any() // 任何请求都扫描
        none() // 任何请求都不扫描
        regex(final String pathRegex) // 通过正则表达式控制
        ant(final String antPattern) // 通过ant()控制
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select() //配置扫描路径
                .apis(RequestHandlerSelectors.basePackage("com.example.kafkatest.controller")).build();
    }



    //可以通过apiInfo()属性配置文档信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("lym", "https://www.baidu.com", "vip_lym@163.com");
        return new ApiInfoBuilder()
                .title("学习swagger")
                .contact(contact)
                .version("1.0")
                .description("spring boot集成 swagger测试")
                .license("许可")
                .licenseUrl("许可链接")
                .build();
    }

}
