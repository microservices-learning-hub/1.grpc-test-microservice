package com.learninghub.grpc.client;

import com.learninghub.grpc.generated.HelloServiceGrpc;
import com.learninghub.grpc.generated.HelloRequest;
import com.learninghub.grpc.generated.HelloResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    private final HelloServiceGrpc.HelloServiceBlockingStub helloServiceStub;

    public GrpcClientService() {
        // Connect to gRPC server running in the same app (localhost:9090)
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9090)
                .usePlaintext()  // Disable for TLS
                .build();

        helloServiceStub = HelloServiceGrpc.newBlockingStub(channel);
    }

    public String sayHello(String name) {
        // Create request
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();

        // Call gRPC service
        HelloResponse response = helloServiceStub.sayHello(request);
        return response.getMessage();
    }
}
