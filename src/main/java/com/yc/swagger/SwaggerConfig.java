package com.yc.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 创建Swagger配置类时
 * 通过@Configuration注解，让Spring来加载该类配置
 * @EnableSwagger2:注解来启用Swagger2
 * 在通过被@Bean注解的函数创建Docket的Bean之后
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()  // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.yc.web.contorllers")) // 对所有contorllers进行监控
                .paths(PathSelectors.any()) // 对所有路径进行监控
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("项目信息相关内容")
                .description("以下接口是操作用户的相关信息")
                .version("1.0")
                .build();
    }

}
