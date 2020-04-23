package com.cfestudo.reactivemongodb.controller;

import com.cfestudo.reactivemongodb.document.Movie;
import com.cfestudo.reactivemongodb.document.MovieEvent;
import com.cfestudo.reactivemongodb.services.MovieService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MovieRestController {

    private MovieService service;

    MovieRestController(MovieService service){
        this.service = service;
    }

    @GetMapping("/movies")
    Flux<Movie> all() {
        return this.service.findAll();
    }

    @GetMapping("/movies/{id}")
    Mono<Movie> byId(@PathVariable String id) {
        return this.service.findById(id);
    }

    @GetMapping("/movies/{name}")
    Flux<Movie> byName(@PathVariable String name) {
        return this.service.findByName(name);
    }

    @GetMapping(value="/movies/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<MovieEvent> events(@PathVariable String id) {
        return this.service.findEvents(id);
    }

}
