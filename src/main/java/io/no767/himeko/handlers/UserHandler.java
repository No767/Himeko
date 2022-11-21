package io.no767.himeko.handlers;

import io.no767.himeko.models.User;
import io.no767.himeko.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;


@Component
public class UserHandler {
    @Autowired
    private UserRepo userRepo;

    public Mono<ServerResponse> getAllUsers(ServerRequest request) {
        Flux<User> users = userRepo.findAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(users, User.class));
    }

    public Mono<ServerResponse> createUser(ServerRequest request) {
        Mono<User> newUser = request.bodyToMono(User.class);
        return newUser.flatMap(user -> userRepo.save(user).flatMap(savedUser -> ServerResponse.accepted().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(savedUser)))).switchIfEmpty(ServerResponse.badRequest().build());
    }
}
