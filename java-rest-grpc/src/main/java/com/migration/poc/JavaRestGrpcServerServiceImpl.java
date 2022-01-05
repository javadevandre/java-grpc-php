package com.migration.poc;

import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class JavaRestGrpcServerServiceImpl extends JavaRestGrpcServerServiceGrpc.JavaRestGrpcServerServiceImplBase {

    @Override
    public void send(JavaRestGrpcServerRequest request, StreamObserver<JavaRestGrpcServerReply> responseObserver) {
        System.out.println("Handling grpc request:: " + request.toString());
        GrpcClient grpcClient = new GrpcClient(ManagedChannelBuilder.forTarget("localhost:6005").usePlaintext().build());
        JavaRestGrpcServerReply response = JavaRestGrpcServerReply.newBuilder()
                .setMessage("Response from 1st Java service:: " + grpcClient.callRpcServer(request.getName())).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
        System.out.println("Finished handling grpc request");

    }
}
