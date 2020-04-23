package com.cfestudo.reactivemongodb.services;

import com.cfestudo.reactivemongodb.document.Movie;
import com.cfestudo.reactivemongodb.document.MovieEvent;
import com.cfestudo.reactivemongodb.repository.MovieRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

@Service
public class MovieService {

    private final MovieRepository repository;

    MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Flux<Movie> findAll() {
        return this.repository.findAll();
    }

    public Mono<Movie> findById(String id) {
        return this.repository.findById(id);
    }

    public Flux<Movie> findByName(String name) { return this.repository.findByTitle(name); }

    public Mono<Movie> save(Movie playlist) {
        return this.repository.save(playlist);
    }

    public Flux<MovieEvent> findEvents(String movieId) {
        //TODO faking the return of movie events
        return Flux.<MovieEvent>generate(sink -> sink.next(new MovieEvent(movieId, new Date())))
                .delayElements(Duration.ofSeconds(1));
    }
}
