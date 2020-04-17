package com.cfestudo.reactivemongodb.services;

import com.cfestudo.reactivemongodb.document.Playlist;
import com.cfestudo.reactivemongodb.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    PlaylistRepository repository;

    public Flux<Playlist> findAll() {
        return this.repository.findAll();
    }

    public Mono<Playlist> findById(String id) {
        return this.repository.findById(id);
    }

    public Flux<Playlist> findByName(String name) {
        return this.repository.findByName(name);
    }

    public Mono<Playlist> save(Playlist playlist) {
        return this.repository.save(playlist);
    }

}
