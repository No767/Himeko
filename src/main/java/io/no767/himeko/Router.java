package io.no767.himeko;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import io.no767.himeko.handlers.UserHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration(proxyBeanMethods = false)
public class Router {
    @Bean
    public RouterFunction<ServerResponse> route(UserHandler userHandler) {

        return RouterFunctions
                .route(GET("/users/all").and(accept(MediaType.APPLICATION_JSON)), userHandler::getAllUsers);
    }

    @Bean
    public RouterFunction<ServerResponse> route2(UserHandler userHandler) {

        return RouterFunctions
                .route(POST("/users/create").and(accept(MediaType.APPLICATION_JSON)), userHandler::createUser);
    }
}
