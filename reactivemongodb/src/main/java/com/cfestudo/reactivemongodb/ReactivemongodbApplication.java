package com.cfestudo.reactivemongodb;

import com.cfestudo.reactivemongodb.document.Playlist;
import com.cfestudo.reactivemongodb.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import reactor.core.publisher.Flux;

import java.util.UUID;

@SpringBootApplication
public class ReactivemongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactivemongodbApplication.class, args);
	}

	@Autowired
	private PlaylistRepository playlistRepository;
	@EventListener(ApplicationReadyEvent.class)
	public void run() {
//		this.playlistRepository.deleteAll()
//				.thenMany(
//						Flux.just("API Rest Spring Boot", "Deploy de uma aplicação Java no IBM Cloud",
//								"Github", "Spring Security", "Web Service RESTFUL", "Bean no Spring Framework")
//								.map(name -> new Playlist(UUID.randomUUID().toString(), name))
//								.flatMap(playlistRepository::save))
//				.subscribe(System.out::println);

		System.out.println(this.playlistRepository.findAll().subscribe(System.out::println));
		System.out.println("VAI LOCALIZAR POR NOME: ");
		System.out.println(this.playlistRepository.findByName("Github").subscribe(System.out::println));
	}

}
