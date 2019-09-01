package br.edu.ifpb.helloworldgrpc.service;

import br.edu.ifpb.helloworldgrpc.grpc.HelloServiceGrpc.HelloServiceImplBase;
import br.edu.ifpb.helloworldgrpc.grpc.HelloServiceOuterClass.*;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        HelloResponse response = HelloResponse.newBuilder().setGreeting(greeting).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
