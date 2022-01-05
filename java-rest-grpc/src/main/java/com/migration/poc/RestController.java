package com.migration.poc;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller("/frontend-will-use")
public class RestController {
    @Inject
    private GrpcClient grpcClient;

    @Post
    public HttpResponse<?> restCall(@Body String name) {
        return HttpResponse.status(HttpStatus.OK).body(grpcClient.callRpcServer(name));
    }
}
