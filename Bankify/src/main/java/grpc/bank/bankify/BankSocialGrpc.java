package grpc.bank.bankify;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *Service for Bankify Social user list
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: BankifySocial.proto")
public final class BankSocialGrpc {

  private BankSocialGrpc() {}

  public static final String SERVICE_NAME = "bankify.BankSocial";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.bank.bankify.NewSocialUserData,
      grpc.bank.bankify.BankReply> getAddSocialUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddSocialUser",
      requestType = grpc.bank.bankify.NewSocialUserData.class,
      responseType = grpc.bank.bankify.BankReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.bank.bankify.NewSocialUserData,
      grpc.bank.bankify.BankReply> getAddSocialUserMethod() {
    io.grpc.MethodDescriptor<grpc.bank.bankify.NewSocialUserData, grpc.bank.bankify.BankReply> getAddSocialUserMethod;
    if ((getAddSocialUserMethod = BankSocialGrpc.getAddSocialUserMethod) == null) {
      synchronized (BankSocialGrpc.class) {
        if ((getAddSocialUserMethod = BankSocialGrpc.getAddSocialUserMethod) == null) {
          BankSocialGrpc.getAddSocialUserMethod = getAddSocialUserMethod = 
              io.grpc.MethodDescriptor.<grpc.bank.bankify.NewSocialUserData, grpc.bank.bankify.BankReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "bankify.BankSocial", "AddSocialUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.NewSocialUserData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.BankReply.getDefaultInstance()))
                  .setSchemaDescriptor(new BankSocialMethodDescriptorSupplier("AddSocialUser"))
                  .build();
          }
        }
     }
     return getAddSocialUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BankSocialStub newStub(io.grpc.Channel channel) {
    return new BankSocialStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BankSocialBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BankSocialBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BankSocialFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BankSocialFutureStub(channel);
  }

  /**
   * <pre>
   *Service for Bankify Social user list
   * </pre>
   */
  public static abstract class BankSocialImplBase implements io.grpc.BindableService {

    /**
     */
    public void addSocialUser(grpc.bank.bankify.NewSocialUserData request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.BankReply> responseObserver) {
      asyncUnimplementedUnaryCall(getAddSocialUserMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddSocialUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.bank.bankify.NewSocialUserData,
                grpc.bank.bankify.BankReply>(
                  this, METHODID_ADD_SOCIAL_USER)))
          .build();
    }
  }

  /**
   * <pre>
   *Service for Bankify Social user list
   * </pre>
   */
  public static final class BankSocialStub extends io.grpc.stub.AbstractStub<BankSocialStub> {
    private BankSocialStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BankSocialStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankSocialStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BankSocialStub(channel, callOptions);
    }

    /**
     */
    public void addSocialUser(grpc.bank.bankify.NewSocialUserData request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.BankReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddSocialUserMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *Service for Bankify Social user list
   * </pre>
   */
  public static final class BankSocialBlockingStub extends io.grpc.stub.AbstractStub<BankSocialBlockingStub> {
    private BankSocialBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BankSocialBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankSocialBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BankSocialBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.bank.bankify.BankReply addSocialUser(grpc.bank.bankify.NewSocialUserData request) {
      return blockingUnaryCall(
          getChannel(), getAddSocialUserMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Service for Bankify Social user list
   * </pre>
   */
  public static final class BankSocialFutureStub extends io.grpc.stub.AbstractStub<BankSocialFutureStub> {
    private BankSocialFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BankSocialFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankSocialFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BankSocialFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.bank.bankify.BankReply> addSocialUser(
        grpc.bank.bankify.NewSocialUserData request) {
      return futureUnaryCall(
          getChannel().newCall(getAddSocialUserMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_SOCIAL_USER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BankSocialImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BankSocialImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_SOCIAL_USER:
          serviceImpl.addSocialUser((grpc.bank.bankify.NewSocialUserData) request,
              (io.grpc.stub.StreamObserver<grpc.bank.bankify.BankReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BankSocialBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BankSocialBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.bank.bankify.BankifySocialImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BankSocial");
    }
  }

  private static final class BankSocialFileDescriptorSupplier
      extends BankSocialBaseDescriptorSupplier {
    BankSocialFileDescriptorSupplier() {}
  }

  private static final class BankSocialMethodDescriptorSupplier
      extends BankSocialBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BankSocialMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BankSocialGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BankSocialFileDescriptorSupplier())
              .addMethod(getAddSocialUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}
