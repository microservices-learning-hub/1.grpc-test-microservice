package com.learninghub.grpc.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrpcClientController {

    private final GrpcClientService grpcClientService;

    public GrpcClientController(GrpcClientService grpcClientService) {
        this.grpcClientService = grpcClientService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return grpcClientService.sayHello(name);
    }
}
