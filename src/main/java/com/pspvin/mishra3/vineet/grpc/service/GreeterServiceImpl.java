package com.pspvin.mishra3.vineet.grpc.service;

import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;
import com.example.grpc.server.GreeterGrpc;

import com.example.grpc.server.HelloReply;
import com.example.grpc.server.HelloRequest;

@GrpcService
public class GreeterServiceImpl extends GreeterGrpc.GreeterImplBase {
	
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String greetingMessage = "Hello " + request.getName() + " from Spring Boot 4 server!";
        
        HelloReply reply = HelloReply.newBuilder()
                .setMessage(greetingMessage)
                .build();
                
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
