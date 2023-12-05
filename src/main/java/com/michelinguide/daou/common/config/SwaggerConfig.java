package com.michelinguide.daou.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "DAOU MICHELIN GUIDE", description = "다우 맛집 가이드 REST API", version = "v1"))
public class SwaggerConfig {

    @Bean
    //TODO: SWAGGER 가이드라인으로, 생성 후 삭제처리 부탁드립니다.
    public GroupedOpenApi loginSwagger() {
        return GroupedOpenApi.builder()
                             .group("LOGIN")
                             .pathsToMatch("/test")
                             .build();
    }
}
