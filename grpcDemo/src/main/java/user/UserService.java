package user;

import demo.grpc.User;
import demo.grpc.User.Empty;
import demo.grpc.User.APIResponse;
import demo.grpc.User.LoginRequest;
import demo.grpc.userGrpc.userImplBase;
import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase {
  @Override
  public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
    System.out.println("Inside login");

    String username = request.getUsername();
    String password = request.getPassword();

    APIResponse.Builder response = APIResponse.newBuilder();
    if (!username.equals(password)) {
      response.setResponseCode(0).setResponseMessage("SUCCESS");
    } else {
      response.setResponseCode(1).setResponseMessage("INVALID PASSWORD");
    }

    responseObserver.onNext(response.build());
    responseObserver.onCompleted();
  }

  @Override
  public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
    System.out.println("Inside logout");
  }
}
