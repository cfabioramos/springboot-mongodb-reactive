package com.cfestudo.reactivemongodb.repository;

import com.cfestudo.reactivemongodb.document.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {

    Flux<Playlist> findByName(String name);

}
