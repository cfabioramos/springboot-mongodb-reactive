package com.cfestudo.reactivemongodb.controller;

import com.cfestudo.reactivemongodb.document.MovieEvent;
import com.cfestudo.reactivemongodb.services.MovieService;
import com.cfestudo.reactivemongodb.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
// Otimo atalho para fazer esse import e outras coisas : alt + Enter

@Configuration
public class Routers {

    @Autowired
    MovieService movieService;

    @Bean
    public RouterFunction<ServerResponse> route(PlaylistHandler handler) {
        return RouterFunctions
                .route(GET("/playlistrouter").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/playlistrouter/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
                .andRoute(POST("/playlistrouter").and(accept(MediaType.APPLICATION_JSON)), handler::save)

                .andRoute(GET("/moviesrouter/{id}/events"),
                        request -> ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM)
                                .body(movieService.findEvents(request.pathVariable("id")), MovieEvent.class));
    }

}
