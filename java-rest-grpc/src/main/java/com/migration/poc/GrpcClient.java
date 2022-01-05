package com.migration.poc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.micronaut.context.annotation.Factory;
import io.micronaut.grpc.annotation.GrpcChannel;
import jakarta.inject.Inject;

@Factory
public class GrpcClient {
    private final JavaRpcServerServiceGrpc.JavaRpcServerServiceBlockingStub blockingStub;

    @Inject
    public GrpcClient(@GrpcChannel("java-rpc-server") ManagedChannel channel) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forTarget("localhost:6005").usePlaintext().build();
        blockingStub = JavaRpcServerServiceGrpc.newBlockingStub(managedChannel);
        System.out.println();
    }

    public String callRpcServer(String name) {
        System.out.println("Calling grpc server:: " + name);
        JavaRpcServerRequest request = JavaRpcServerRequest.newBuilder().setName(name).build();
        JavaRpcServerReply response;
        try {
            response = blockingStub.send(request);
        } catch (StatusRuntimeException e) {
            System.err.println("Failed... :( :: " + e);
            return "";
        }
        System.out.println("Finished call with grpc response message:: " + response.getMessage());
        return response.getMessage();
    }

}
