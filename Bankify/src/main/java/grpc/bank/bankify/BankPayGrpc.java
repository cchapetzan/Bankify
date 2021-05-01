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
 *Service for Bankify pay
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: BankifyPay.proto")
public final class BankPayGrpc {

  private BankPayGrpc() {}

  public static final String SERVICE_NAME = "bankify.BankPay";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.bank.bankify.LoginData,
      grpc.bank.bankify.LoginPayReply> getHolderLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HolderLogin",
      requestType = grpc.bank.bankify.LoginData.class,
      responseType = grpc.bank.bankify.LoginPayReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.bank.bankify.LoginData,
      grpc.bank.bankify.LoginPayReply> getHolderLoginMethod() {
    io.grpc.MethodDescriptor<grpc.bank.bankify.LoginData, grpc.bank.bankify.LoginPayReply> getHolderLoginMethod;
    if ((getHolderLoginMethod = BankPayGrpc.getHolderLoginMethod) == null) {
      synchronized (BankPayGrpc.class) {
        if ((getHolderLoginMethod = BankPayGrpc.getHolderLoginMethod) == null) {
          BankPayGrpc.getHolderLoginMethod = getHolderLoginMethod = 
              io.grpc.MethodDescriptor.<grpc.bank.bankify.LoginData, grpc.bank.bankify.LoginPayReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "bankify.BankPay", "HolderLogin"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.LoginData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.LoginPayReply.getDefaultInstance()))
                  .setSchemaDescriptor(new BankPayMethodDescriptorSupplier("HolderLogin"))
                  .build();
          }
        }
     }
     return getHolderLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.bank.bankify.LogoutData,
      grpc.bank.bankify.BankReply> getUserLogoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UserLogout",
      requestType = grpc.bank.bankify.LogoutData.class,
      responseType = grpc.bank.bankify.BankReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.bank.bankify.LogoutData,
      grpc.bank.bankify.BankReply> getUserLogoutMethod() {
    io.grpc.MethodDescriptor<grpc.bank.bankify.LogoutData, grpc.bank.bankify.BankReply> getUserLogoutMethod;
    if ((getUserLogoutMethod = BankPayGrpc.getUserLogoutMethod) == null) {
      synchronized (BankPayGrpc.class) {
        if ((getUserLogoutMethod = BankPayGrpc.getUserLogoutMethod) == null) {
          BankPayGrpc.getUserLogoutMethod = getUserLogoutMethod = 
              io.grpc.MethodDescriptor.<grpc.bank.bankify.LogoutData, grpc.bank.bankify.BankReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "bankify.BankPay", "UserLogout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.LogoutData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.BankReply.getDefaultInstance()))
                  .setSchemaDescriptor(new BankPayMethodDescriptorSupplier("UserLogout"))
                  .build();
          }
        }
     }
     return getUserLogoutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.bank.bankify.PayRequest,
      grpc.bank.bankify.PayReply> getPayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Pay",
      requestType = grpc.bank.bankify.PayRequest.class,
      responseType = grpc.bank.bankify.PayReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.bank.bankify.PayRequest,
      grpc.bank.bankify.PayReply> getPayMethod() {
    io.grpc.MethodDescriptor<grpc.bank.bankify.PayRequest, grpc.bank.bankify.PayReply> getPayMethod;
    if ((getPayMethod = BankPayGrpc.getPayMethod) == null) {
      synchronized (BankPayGrpc.class) {
        if ((getPayMethod = BankPayGrpc.getPayMethod) == null) {
          BankPayGrpc.getPayMethod = getPayMethod = 
              io.grpc.MethodDescriptor.<grpc.bank.bankify.PayRequest, grpc.bank.bankify.PayReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "bankify.BankPay", "Pay"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.PayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.PayReply.getDefaultInstance()))
                  .setSchemaDescriptor(new BankPayMethodDescriptorSupplier("Pay"))
                  .build();
          }
        }
     }
     return getPayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.bank.bankify.PayHistory,
      grpc.bank.bankify.BankReply> getPayHistoryRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PayHistoryRegister",
      requestType = grpc.bank.bankify.PayHistory.class,
      responseType = grpc.bank.bankify.BankReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.bank.bankify.PayHistory,
      grpc.bank.bankify.BankReply> getPayHistoryRegisterMethod() {
    io.grpc.MethodDescriptor<grpc.bank.bankify.PayHistory, grpc.bank.bankify.BankReply> getPayHistoryRegisterMethod;
    if ((getPayHistoryRegisterMethod = BankPayGrpc.getPayHistoryRegisterMethod) == null) {
      synchronized (BankPayGrpc.class) {
        if ((getPayHistoryRegisterMethod = BankPayGrpc.getPayHistoryRegisterMethod) == null) {
          BankPayGrpc.getPayHistoryRegisterMethod = getPayHistoryRegisterMethod = 
              io.grpc.MethodDescriptor.<grpc.bank.bankify.PayHistory, grpc.bank.bankify.BankReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "bankify.BankPay", "PayHistoryRegister"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.PayHistory.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.BankReply.getDefaultInstance()))
                  .setSchemaDescriptor(new BankPayMethodDescriptorSupplier("PayHistoryRegister"))
                  .build();
          }
        }
     }
     return getPayHistoryRegisterMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BankPayStub newStub(io.grpc.Channel channel) {
    return new BankPayStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BankPayBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BankPayBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BankPayFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BankPayFutureStub(channel);
  }

  /**
   * <pre>
   *Service for Bankify pay
   * </pre>
   */
  public static abstract class BankPayImplBase implements io.grpc.BindableService {

    /**
     */
    public void holderLogin(grpc.bank.bankify.LoginData request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.LoginPayReply> responseObserver) {
      asyncUnimplementedUnaryCall(getHolderLoginMethod(), responseObserver);
    }

    /**
     */
    public void userLogout(grpc.bank.bankify.LogoutData request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.BankReply> responseObserver) {
      asyncUnimplementedUnaryCall(getUserLogoutMethod(), responseObserver);
    }

    /**
     */
    public void pay(grpc.bank.bankify.PayRequest request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.PayReply> responseObserver) {
      asyncUnimplementedUnaryCall(getPayMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.bank.bankify.PayHistory> payHistoryRegister(
        io.grpc.stub.StreamObserver<grpc.bank.bankify.BankReply> responseObserver) {
      return asyncUnimplementedStreamingCall(getPayHistoryRegisterMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHolderLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.bank.bankify.LoginData,
                grpc.bank.bankify.LoginPayReply>(
                  this, METHODID_HOLDER_LOGIN)))
          .addMethod(
            getUserLogoutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.bank.bankify.LogoutData,
                grpc.bank.bankify.BankReply>(
                  this, METHODID_USER_LOGOUT)))
          .addMethod(
            getPayMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.bank.bankify.PayRequest,
                grpc.bank.bankify.PayReply>(
                  this, METHODID_PAY)))
          .addMethod(
            getPayHistoryRegisterMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.bank.bankify.PayHistory,
                grpc.bank.bankify.BankReply>(
                  this, METHODID_PAY_HISTORY_REGISTER)))
          .build();
    }
  }

  /**
   * <pre>
   *Service for Bankify pay
   * </pre>
   */
  public static final class BankPayStub extends io.grpc.stub.AbstractStub<BankPayStub> {
    private BankPayStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BankPayStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankPayStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BankPayStub(channel, callOptions);
    }

    /**
     */
    public void holderLogin(grpc.bank.bankify.LoginData request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.LoginPayReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHolderLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void userLogout(grpc.bank.bankify.LogoutData request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.BankReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUserLogoutMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void pay(grpc.bank.bankify.PayRequest request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.PayReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPayMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.bank.bankify.PayHistory> payHistoryRegister(
        io.grpc.stub.StreamObserver<grpc.bank.bankify.BankReply> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getPayHistoryRegisterMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *Service for Bankify pay
   * </pre>
   */
  public static final class BankPayBlockingStub extends io.grpc.stub.AbstractStub<BankPayBlockingStub> {
    private BankPayBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BankPayBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankPayBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BankPayBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.bank.bankify.LoginPayReply holderLogin(grpc.bank.bankify.LoginData request) {
      return blockingUnaryCall(
          getChannel(), getHolderLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.bank.bankify.BankReply userLogout(grpc.bank.bankify.LogoutData request) {
      return blockingUnaryCall(
          getChannel(), getUserLogoutMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.bank.bankify.PayReply pay(grpc.bank.bankify.PayRequest request) {
      return blockingUnaryCall(
          getChannel(), getPayMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Service for Bankify pay
   * </pre>
   */
  public static final class BankPayFutureStub extends io.grpc.stub.AbstractStub<BankPayFutureStub> {
    private BankPayFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BankPayFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankPayFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BankPayFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.bank.bankify.LoginPayReply> holderLogin(
        grpc.bank.bankify.LoginData request) {
      return futureUnaryCall(
          getChannel().newCall(getHolderLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.bank.bankify.BankReply> userLogout(
        grpc.bank.bankify.LogoutData request) {
      return futureUnaryCall(
          getChannel().newCall(getUserLogoutMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.bank.bankify.PayReply> pay(
        grpc.bank.bankify.PayRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPayMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HOLDER_LOGIN = 0;
  private static final int METHODID_USER_LOGOUT = 1;
  private static final int METHODID_PAY = 2;
  private static final int METHODID_PAY_HISTORY_REGISTER = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BankPayImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BankPayImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HOLDER_LOGIN:
          serviceImpl.holderLogin((grpc.bank.bankify.LoginData) request,
              (io.grpc.stub.StreamObserver<grpc.bank.bankify.LoginPayReply>) responseObserver);
          break;
        case METHODID_USER_LOGOUT:
          serviceImpl.userLogout((grpc.bank.bankify.LogoutData) request,
              (io.grpc.stub.StreamObserver<grpc.bank.bankify.BankReply>) responseObserver);
          break;
        case METHODID_PAY:
          serviceImpl.pay((grpc.bank.bankify.PayRequest) request,
              (io.grpc.stub.StreamObserver<grpc.bank.bankify.PayReply>) responseObserver);
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
        case METHODID_PAY_HISTORY_REGISTER:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.payHistoryRegister(
              (io.grpc.stub.StreamObserver<grpc.bank.bankify.BankReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BankPayBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BankPayBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.bank.bankify.BankifyPayImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BankPay");
    }
  }

  private static final class BankPayFileDescriptorSupplier
      extends BankPayBaseDescriptorSupplier {
    BankPayFileDescriptorSupplier() {}
  }

  private static final class BankPayMethodDescriptorSupplier
      extends BankPayBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BankPayMethodDescriptorSupplier(String methodName) {
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
      synchronized (BankPayGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BankPayFileDescriptorSupplier())
              .addMethod(getHolderLoginMethod())
              .addMethod(getUserLogoutMethod())
              .addMethod(getPayMethod())
              .addMethod(getPayHistoryRegisterMethod())
              .build();
        }
      }
    }
    return result;
  }
}
