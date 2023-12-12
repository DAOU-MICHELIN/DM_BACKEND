package com.michelinguide.daou.config.env;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties
@PropertySource(value = {"smtp.yml"}, factory = YmlLoadFactory.class)
@Getter
public class AppConfig {

    @Value("${smtp.from}")
    private String from;
}
