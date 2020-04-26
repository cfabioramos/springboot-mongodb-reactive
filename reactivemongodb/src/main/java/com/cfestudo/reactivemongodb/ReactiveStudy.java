package com.cfestudo.reactivemongodb;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class ReactiveStudy {

    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> flux1 = Flux.just(1, 5, 10)
                .delayElements(Duration.ofMillis(200));

        Flux<Integer> flux2 = Flux.just(15, 20, 25)
                .delayElements(Duration.ofMillis(400));

        Mono<Integer> mono1 = Mono.just(1);

//        flux1.concat(flux2).concat(mono1)
//                .subscribe(System.out :: println);
        flux1.concatWith(flux2).concatWith(mono1)
                .subscribe(System.out :: println);

        flux1.zipWith(flux2).subscribe(System.out :: println);

        Thread.sleep(4000);
    }

}
