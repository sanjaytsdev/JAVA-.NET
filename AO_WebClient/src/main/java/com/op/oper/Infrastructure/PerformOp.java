package com.op.oper.Infrastructure;

import org.springframework.web.reactive.function.client.WebClient;

import com.op.oper.Entity.Operations;

import reactor.core.publisher.Mono;

public class PerformOp {

    private final WebClient webClient;

    public Mono<Operations> performCalculation(Integer a, Integer b, String op) {
        Operations request = new Operations(a, b, op);

        return webClient.post()
                .uri("/calc")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Operations.class);

    }

    public PerformOp(WebClient webClient) {
        this.webClient = webClient;
    }
}
