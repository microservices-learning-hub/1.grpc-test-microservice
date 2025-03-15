package com.learninghub.grpc.service;

import org.springframework.grpc.server.service.GrpcService;

import com.learninghub.grpc.generated.HelloRequest;
import com.learninghub.grpc.generated.HelloResponse;
import com.learninghub.grpc.generated.HelloServiceGrpc;

@GrpcService
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHello(HelloRequest request,
                         io.grpc.stub.StreamObserver<HelloResponse> responseObserver) {
        String greeting = "Hello, " + request.getName() + "! Welcome to gRPC with Spring Boot.";
        HelloResponse response = HelloResponse.newBuilder()
                .setMessage(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
