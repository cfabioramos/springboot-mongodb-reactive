package com.cfestudo.reactivemongodb.services;

import com.cfestudo.reactivemongodb.document.Playlist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlaylistService {

    Flux<Playlist> findAll();
    public Mono<Playlist> findById(String id);
    public Flux<Playlist> findByName(String name);
    public Mono<Playlist> save(Playlist playlist);

}
