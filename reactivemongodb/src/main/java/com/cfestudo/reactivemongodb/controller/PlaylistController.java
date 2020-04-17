package com.cfestudo.reactivemongodb.controller;

import com.cfestudo.reactivemongodb.document.Playlist;
import com.cfestudo.reactivemongodb.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

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

    @GetMapping(value = "/playlist/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Playlist>> getPlaylistByEvents() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<Playlist> events = service.findAll();
        System.out.println("PASSOU AQUI EVENTS...");
        return Flux.zip(interval, events);
    }

}
