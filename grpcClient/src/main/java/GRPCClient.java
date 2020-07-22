import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import demo.grpc.userGrpc.*;
import demo.grpc.User.*;

import static demo.grpc.userGrpc.newBlockingStub;

public class GRPCClient {

  public static void main(String[] args) {

    ManagedChannel channel = ManagedChannelBuilder
        .forAddress("localhost", 9090).usePlaintext().build();
    userBlockingStub userStub = newBlockingStub(channel);
    LoginRequest loginRequest = LoginRequest.newBuilder().setUsername("username")
        .setPassword("password").build();
    APIResponse response = userStub.login(loginRequest);

    System.out.println(response.getResponseCode() + " " + response.getResponseMessage());
  }
}