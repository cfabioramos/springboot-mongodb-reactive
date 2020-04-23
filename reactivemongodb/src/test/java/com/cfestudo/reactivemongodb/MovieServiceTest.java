package com.cfestudo.reactivemongodb;

import com.cfestudo.reactivemongodb.services.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

import java.time.Duration;

@SpringBootTest
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    public void getEventsTake10() throws Exception {
        String movieId = movieService.findAll().blockFirst().getId();

        StepVerifier.withVirtualTime(() -> movieService.findEvents(movieId).take(10))
                .thenAwait(Duration.ofHours(10))
                .expectNextCount(10)
                .verifyComplete();
    }

}
