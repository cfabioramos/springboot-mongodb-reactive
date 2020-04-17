package com.cfestudo.reactivemongodb.controller;

import com.cfestudo.reactivemongodb.document.Playlist;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class PlaylistRouter {

    @Bean
    public RouterFunction<ServerResponse> route(PlaylistHandler handler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/playlistrouter").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(RequestPredicates.GET("/playlistrouter/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::findById)
                .andRoute(RequestPredicates.POST("/playlistrouter").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::save);
    }

}
