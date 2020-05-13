package com.vinicius.financeiro.api;

import com.vinicius.financeiro.api.config.propertiy.FinanceiroApiProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(FinanceiroApiProperty.class)
public class FinanceiroApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceiroApiApplication.class, args);
    }

}
