package com.cfestudo.reactivemongodb;

import com.cfestudo.reactivemongodb.repository.MovieRepository;
import com.cfestudo.reactivemongodb.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ReactivemongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactivemongodbApplication.class, args);
	}

	@Autowired
	private PlaylistRepository playlistRepository;
	@Autowired
	private MovieRepository movieRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void run() {
/*
	FlatMap transform the elements emitted by the Flux asynchronously into Publishers,
	then flatten these inner publishers into a single Flux through merging.
 */
//		this.playlistRepository.deleteAll()
//				.thenMany(
//						Flux.just("API Rest Spring Boot", "Deploy de uma aplicação Java no IBM Cloud",
//								"Github", "Spring Security", "Web Service RESTFUL", "Bean no Spring Framework")
//								.map(name -> new Playlist(UUID.randomUUID().toString(), name))
//								.flatMap(playlistRepository::save))
//				.subscribe(System.out::println);

//		this.movieRepository.deleteAll().thenMany(
//			Flux.just("Back to the Future", "Matrix", "Anime", "Hollywood", "Capone", "The Eddy",
//					"Parasite", "Joker", "The Platform", "La Casa de Papel", "Coringa", "The Avengers",
//					"Lion King", "Spiderman", "As Golpistas", "Money Heist")
//					.map(name -> new Movie(UUID.randomUUID().toString(), name))
//					.flatMap(movieRepository::save))
//				.thenMany(movieRepository.findAll())
//				.subscribe(System.out::println);
	}

}
