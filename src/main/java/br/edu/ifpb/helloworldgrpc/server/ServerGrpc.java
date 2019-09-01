package br.edu.ifpb.helloworldgrpc.server;

import br.edu.ifpb.helloworldgrpc.service.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ServerGrpc {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080).addService(new HelloServiceImpl()).build();
        server.start();
        System.out.println("Servidor inicializado em " + server.getPort());
        server.awaitTermination();
    }
}
