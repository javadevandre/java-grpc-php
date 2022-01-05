package com.migration.poc;

import io.grpc.stub.StreamObserver;
import jakarta.inject.Singleton;

@Singleton
public class JavaRpcServerServiceImpl extends JavaRpcServerServiceGrpc.JavaRpcServerServiceImplBase {

    @Override
    public void send(JavaRpcServerRequest request, StreamObserver<JavaRpcServerReply> responseObserver) {
        System.out.println("Handling grpc request:: " + request.toString());
        JavaRpcServerReply response = JavaRpcServerReply.newBuilder()
                .setMessage("Response from 2nd Java service:: " + request.getName()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
        System.out.println("Finished handling grpc request");
    }

}
