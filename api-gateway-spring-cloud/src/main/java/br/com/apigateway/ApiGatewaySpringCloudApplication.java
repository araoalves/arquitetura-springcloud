package br.com.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewaySpringCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewaySpringCloudApplication.class, args);
    }

}
