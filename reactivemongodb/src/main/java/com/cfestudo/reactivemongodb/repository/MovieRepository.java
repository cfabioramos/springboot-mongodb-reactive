package com.cfestudo.reactivemongodb.repository;

import com.cfestudo.reactivemongodb.document.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
    Flux<Movie> findByTitle(String title);
}
