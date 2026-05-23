package com.example;

import reactor.core.publisher.Flux;

public class ReactorExample {

    public static void main(String[] args) {

        System.out.println("=== MAP ===");
        Flux.just(1,2,3,4,5)
                .map(x -> x * 2)
                .subscribe(System.out::println);

        System.out.println("=== FILTER ===");
        Flux.just(1,2,3,4,5)
                .filter(x -> x % 2 == 0)
                .subscribe(System.out::println);

        System.out.println("=== FLATMAP ===");
        Flux.just(1,2,3)
                .flatMap(x -> Flux.just(x * 10, x * 20))
                .subscribe(System.out::println);

        System.out.println("=== MERGE ===");
        Flux<Integer> a = Flux.just(1,3,5);
        Flux<Integer> b = Flux.just(2,4,6);

        Flux.merge(a,b)
                .subscribe(System.out::println);

        System.out.println("=== ZIP ===");
        Flux<Integer> nums = Flux.just(1,2,3);
        Flux<String> letras = Flux.just("A","B","C");

        Flux.zip(nums, letras, (n,l) -> n + l)
                .subscribe(System.out::println);
    }
}