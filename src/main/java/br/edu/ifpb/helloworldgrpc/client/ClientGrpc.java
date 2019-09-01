package br.edu.ifpb.helloworldgrpc.client;

import br.edu.ifpb.helloworldgrpc.grpc.HelloServiceGrpc.HelloServiceBlockingStub;
import br.edu.ifpb.helloworldgrpc.grpc.HelloServiceGrpc;
import br.edu.ifpb.helloworldgrpc.grpc.HelloServiceOuterClass.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientGrpc {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 8080).usePlaintext().build();

        HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Rômulo")
                .setLastName("Soares")
                .build());

        System.out.println(helloResponse.getGreeting());

        channel.shutdown();
    }

}
