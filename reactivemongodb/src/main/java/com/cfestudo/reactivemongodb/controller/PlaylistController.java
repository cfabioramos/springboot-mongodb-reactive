package com.cfestudo.reactivemongodb.controller;

import com.cfestudo.reactivemongodb.document.Playlist;
import com.cfestudo.reactivemongodb.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PlaylistController {

    @Autowired
    PlaylistService service;

    @GetMapping(value="/playlist")
    public Flux<Playlist> getPlaylist() {
        return this.service.findAll();
    }

    @GetMapping(value="/playlist/{id}")
    public Mono<Playlist> getPlaylistId(@PathVariable String id) {
        return this.service.findById(id);
    }

    @PostMapping(value="/playlist")
    public Mono<Playlist> save(@RequestBody Playlist playlist) {
        return this.service.save(playlist);
    }

}
