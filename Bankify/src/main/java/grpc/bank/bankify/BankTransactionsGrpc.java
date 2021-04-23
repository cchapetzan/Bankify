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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Bankify.proto")
public final class BankTransactionsGrpc {

  private BankTransactionsGrpc() {}

  public static final String SERVICE_NAME = "bankify.BankTransactions";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.bank.bankify.BankRequest,
      grpc.bank.bankify.BankReply> getSendDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendData",
      requestType = grpc.bank.bankify.BankRequest.class,
      responseType = grpc.bank.bankify.BankReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.bank.bankify.BankRequest,
      grpc.bank.bankify.BankReply> getSendDataMethod() {
    io.grpc.MethodDescriptor<grpc.bank.bankify.BankRequest, grpc.bank.bankify.BankReply> getSendDataMethod;
    if ((getSendDataMethod = BankTransactionsGrpc.getSendDataMethod) == null) {
      synchronized (BankTransactionsGrpc.class) {
        if ((getSendDataMethod = BankTransactionsGrpc.getSendDataMethod) == null) {
          BankTransactionsGrpc.getSendDataMethod = getSendDataMethod = 
              io.grpc.MethodDescriptor.<grpc.bank.bankify.BankRequest, grpc.bank.bankify.BankReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "bankify.BankTransactions", "SendData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.BankRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.BankReply.getDefaultInstance()))
                  .setSchemaDescriptor(new BankTransactionsMethodDescriptorSupplier("SendData"))
                  .build();
          }
        }
     }
     return getSendDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.bank.bankify.NewUserData,
      grpc.bank.bankify.BankReply> getAddUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddUser",
      requestType = grpc.bank.bankify.NewUserData.class,
      responseType = grpc.bank.bankify.BankReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.bank.bankify.NewUserData,
      grpc.bank.bankify.BankReply> getAddUserMethod() {
    io.grpc.MethodDescriptor<grpc.bank.bankify.NewUserData, grpc.bank.bankify.BankReply> getAddUserMethod;
    if ((getAddUserMethod = BankTransactionsGrpc.getAddUserMethod) == null) {
      synchronized (BankTransactionsGrpc.class) {
        if ((getAddUserMethod = BankTransactionsGrpc.getAddUserMethod) == null) {
          BankTransactionsGrpc.getAddUserMethod = getAddUserMethod = 
              io.grpc.MethodDescriptor.<grpc.bank.bankify.NewUserData, grpc.bank.bankify.BankReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "bankify.BankTransactions", "AddUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.NewUserData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.BankReply.getDefaultInstance()))
                  .setSchemaDescriptor(new BankTransactionsMethodDescriptorSupplier("AddUser"))
                  .build();
          }
        }
     }
     return getAddUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.bank.bankify.LoginData,
      grpc.bank.bankify.LoginReply> getUserLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UserLogin",
      requestType = grpc.bank.bankify.LoginData.class,
      responseType = grpc.bank.bankify.LoginReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.bank.bankify.LoginData,
      grpc.bank.bankify.LoginReply> getUserLoginMethod() {
    io.grpc.MethodDescriptor<grpc.bank.bankify.LoginData, grpc.bank.bankify.LoginReply> getUserLoginMethod;
    if ((getUserLoginMethod = BankTransactionsGrpc.getUserLoginMethod) == null) {
      synchronized (BankTransactionsGrpc.class) {
        if ((getUserLoginMethod = BankTransactionsGrpc.getUserLoginMethod) == null) {
          BankTransactionsGrpc.getUserLoginMethod = getUserLoginMethod = 
              io.grpc.MethodDescriptor.<grpc.bank.bankify.LoginData, grpc.bank.bankify.LoginReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "bankify.BankTransactions", "UserLogin"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.LoginData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.LoginReply.getDefaultInstance()))
                  .setSchemaDescriptor(new BankTransactionsMethodDescriptorSupplier("UserLogin"))
                  .build();
          }
        }
     }
     return getUserLoginMethod;
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
    if ((getUserLogoutMethod = BankTransactionsGrpc.getUserLogoutMethod) == null) {
      synchronized (BankTransactionsGrpc.class) {
        if ((getUserLogoutMethod = BankTransactionsGrpc.getUserLogoutMethod) == null) {
          BankTransactionsGrpc.getUserLogoutMethod = getUserLogoutMethod = 
              io.grpc.MethodDescriptor.<grpc.bank.bankify.LogoutData, grpc.bank.bankify.BankReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "bankify.BankTransactions", "UserLogout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.LogoutData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.BankReply.getDefaultInstance()))
                  .setSchemaDescriptor(new BankTransactionsMethodDescriptorSupplier("UserLogout"))
                  .build();
          }
        }
     }
     return getUserLogoutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.bank.bankify.LoginData,
      grpc.bank.bankify.MovementData> getAccountMovementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AccountMovement",
      requestType = grpc.bank.bankify.LoginData.class,
      responseType = grpc.bank.bankify.MovementData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.bank.bankify.LoginData,
      grpc.bank.bankify.MovementData> getAccountMovementMethod() {
    io.grpc.MethodDescriptor<grpc.bank.bankify.LoginData, grpc.bank.bankify.MovementData> getAccountMovementMethod;
    if ((getAccountMovementMethod = BankTransactionsGrpc.getAccountMovementMethod) == null) {
      synchronized (BankTransactionsGrpc.class) {
        if ((getAccountMovementMethod = BankTransactionsGrpc.getAccountMovementMethod) == null) {
          BankTransactionsGrpc.getAccountMovementMethod = getAccountMovementMethod = 
              io.grpc.MethodDescriptor.<grpc.bank.bankify.LoginData, grpc.bank.bankify.MovementData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "bankify.BankTransactions", "AccountMovement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.LoginData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.MovementData.getDefaultInstance()))
                  .setSchemaDescriptor(new BankTransactionsMethodDescriptorSupplier("AccountMovement"))
                  .build();
          }
        }
     }
     return getAccountMovementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.bank.bankify.AccountData,
      grpc.bank.bankify.FloatReply> getGetBalanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBalance",
      requestType = grpc.bank.bankify.AccountData.class,
      responseType = grpc.bank.bankify.FloatReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.bank.bankify.AccountData,
      grpc.bank.bankify.FloatReply> getGetBalanceMethod() {
    io.grpc.MethodDescriptor<grpc.bank.bankify.AccountData, grpc.bank.bankify.FloatReply> getGetBalanceMethod;
    if ((getGetBalanceMethod = BankTransactionsGrpc.getGetBalanceMethod) == null) {
      synchronized (BankTransactionsGrpc.class) {
        if ((getGetBalanceMethod = BankTransactionsGrpc.getGetBalanceMethod) == null) {
          BankTransactionsGrpc.getGetBalanceMethod = getGetBalanceMethod = 
              io.grpc.MethodDescriptor.<grpc.bank.bankify.AccountData, grpc.bank.bankify.FloatReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "bankify.BankTransactions", "GetBalance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.AccountData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.FloatReply.getDefaultInstance()))
                  .setSchemaDescriptor(new BankTransactionsMethodDescriptorSupplier("GetBalance"))
                  .build();
          }
        }
     }
     return getGetBalanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.bank.bankify.AccountTransfer,
      grpc.bank.bankify.FloatReply> getTransferBalanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TransferBalance",
      requestType = grpc.bank.bankify.AccountTransfer.class,
      responseType = grpc.bank.bankify.FloatReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.bank.bankify.AccountTransfer,
      grpc.bank.bankify.FloatReply> getTransferBalanceMethod() {
    io.grpc.MethodDescriptor<grpc.bank.bankify.AccountTransfer, grpc.bank.bankify.FloatReply> getTransferBalanceMethod;
    if ((getTransferBalanceMethod = BankTransactionsGrpc.getTransferBalanceMethod) == null) {
      synchronized (BankTransactionsGrpc.class) {
        if ((getTransferBalanceMethod = BankTransactionsGrpc.getTransferBalanceMethod) == null) {
          BankTransactionsGrpc.getTransferBalanceMethod = getTransferBalanceMethod = 
              io.grpc.MethodDescriptor.<grpc.bank.bankify.AccountTransfer, grpc.bank.bankify.FloatReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "bankify.BankTransactions", "TransferBalance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.AccountTransfer.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.bank.bankify.FloatReply.getDefaultInstance()))
                  .setSchemaDescriptor(new BankTransactionsMethodDescriptorSupplier("TransferBalance"))
                  .build();
          }
        }
     }
     return getTransferBalanceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BankTransactionsStub newStub(io.grpc.Channel channel) {
    return new BankTransactionsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BankTransactionsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BankTransactionsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BankTransactionsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BankTransactionsFutureStub(channel);
  }

  /**
   */
  public static abstract class BankTransactionsImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendData(grpc.bank.bankify.BankRequest request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.BankReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSendDataMethod(), responseObserver);
    }

    /**
     */
    public void addUser(grpc.bank.bankify.NewUserData request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.BankReply> responseObserver) {
      asyncUnimplementedUnaryCall(getAddUserMethod(), responseObserver);
    }

    /**
     */
    public void userLogin(grpc.bank.bankify.LoginData request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.LoginReply> responseObserver) {
      asyncUnimplementedUnaryCall(getUserLoginMethod(), responseObserver);
    }

    /**
     */
    public void userLogout(grpc.bank.bankify.LogoutData request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.BankReply> responseObserver) {
      asyncUnimplementedUnaryCall(getUserLogoutMethod(), responseObserver);
    }

    /**
     */
    public void accountMovement(grpc.bank.bankify.LoginData request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.MovementData> responseObserver) {
      asyncUnimplementedUnaryCall(getAccountMovementMethod(), responseObserver);
    }

    /**
     */
    public void getBalance(grpc.bank.bankify.AccountData request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.FloatReply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBalanceMethod(), responseObserver);
    }

    /**
     */
    public void transferBalance(grpc.bank.bankify.AccountTransfer request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.FloatReply> responseObserver) {
      asyncUnimplementedUnaryCall(getTransferBalanceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendDataMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.bank.bankify.BankRequest,
                grpc.bank.bankify.BankReply>(
                  this, METHODID_SEND_DATA)))
          .addMethod(
            getAddUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.bank.bankify.NewUserData,
                grpc.bank.bankify.BankReply>(
                  this, METHODID_ADD_USER)))
          .addMethod(
            getUserLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.bank.bankify.LoginData,
                grpc.bank.bankify.LoginReply>(
                  this, METHODID_USER_LOGIN)))
          .addMethod(
            getUserLogoutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.bank.bankify.LogoutData,
                grpc.bank.bankify.BankReply>(
                  this, METHODID_USER_LOGOUT)))
          .addMethod(
            getAccountMovementMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.bank.bankify.LoginData,
                grpc.bank.bankify.MovementData>(
                  this, METHODID_ACCOUNT_MOVEMENT)))
          .addMethod(
            getGetBalanceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.bank.bankify.AccountData,
                grpc.bank.bankify.FloatReply>(
                  this, METHODID_GET_BALANCE)))
          .addMethod(
            getTransferBalanceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.bank.bankify.AccountTransfer,
                grpc.bank.bankify.FloatReply>(
                  this, METHODID_TRANSFER_BALANCE)))
          .build();
    }
  }

  /**
   */
  public static final class BankTransactionsStub extends io.grpc.stub.AbstractStub<BankTransactionsStub> {
    private BankTransactionsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BankTransactionsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankTransactionsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BankTransactionsStub(channel, callOptions);
    }

    /**
     */
    public void sendData(grpc.bank.bankify.BankRequest request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.BankReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addUser(grpc.bank.bankify.NewUserData request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.BankReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void userLogin(grpc.bank.bankify.LoginData request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.LoginReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUserLoginMethod(), getCallOptions()), request, responseObserver);
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
    public void accountMovement(grpc.bank.bankify.LoginData request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.MovementData> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getAccountMovementMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBalance(grpc.bank.bankify.AccountData request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.FloatReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBalanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void transferBalance(grpc.bank.bankify.AccountTransfer request,
        io.grpc.stub.StreamObserver<grpc.bank.bankify.FloatReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTransferBalanceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BankTransactionsBlockingStub extends io.grpc.stub.AbstractStub<BankTransactionsBlockingStub> {
    private BankTransactionsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BankTransactionsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankTransactionsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BankTransactionsBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.bank.bankify.BankReply sendData(grpc.bank.bankify.BankRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.bank.bankify.BankReply addUser(grpc.bank.bankify.NewUserData request) {
      return blockingUnaryCall(
          getChannel(), getAddUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.bank.bankify.LoginReply userLogin(grpc.bank.bankify.LoginData request) {
      return blockingUnaryCall(
          getChannel(), getUserLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.bank.bankify.BankReply userLogout(grpc.bank.bankify.LogoutData request) {
      return blockingUnaryCall(
          getChannel(), getUserLogoutMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<grpc.bank.bankify.MovementData> accountMovement(
        grpc.bank.bankify.LoginData request) {
      return blockingServerStreamingCall(
          getChannel(), getAccountMovementMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.bank.bankify.FloatReply getBalance(grpc.bank.bankify.AccountData request) {
      return blockingUnaryCall(
          getChannel(), getGetBalanceMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.bank.bankify.FloatReply transferBalance(grpc.bank.bankify.AccountTransfer request) {
      return blockingUnaryCall(
          getChannel(), getTransferBalanceMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BankTransactionsFutureStub extends io.grpc.stub.AbstractStub<BankTransactionsFutureStub> {
    private BankTransactionsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BankTransactionsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankTransactionsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BankTransactionsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.bank.bankify.BankReply> sendData(
        grpc.bank.bankify.BankRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.bank.bankify.BankReply> addUser(
        grpc.bank.bankify.NewUserData request) {
      return futureUnaryCall(
          getChannel().newCall(getAddUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.bank.bankify.LoginReply> userLogin(
        grpc.bank.bankify.LoginData request) {
      return futureUnaryCall(
          getChannel().newCall(getUserLoginMethod(), getCallOptions()), request);
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
    public com.google.common.util.concurrent.ListenableFuture<grpc.bank.bankify.FloatReply> getBalance(
        grpc.bank.bankify.AccountData request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBalanceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.bank.bankify.FloatReply> transferBalance(
        grpc.bank.bankify.AccountTransfer request) {
      return futureUnaryCall(
          getChannel().newCall(getTransferBalanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_DATA = 0;
  private static final int METHODID_ADD_USER = 1;
  private static final int METHODID_USER_LOGIN = 2;
  private static final int METHODID_USER_LOGOUT = 3;
  private static final int METHODID_ACCOUNT_MOVEMENT = 4;
  private static final int METHODID_GET_BALANCE = 5;
  private static final int METHODID_TRANSFER_BALANCE = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BankTransactionsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BankTransactionsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_DATA:
          serviceImpl.sendData((grpc.bank.bankify.BankRequest) request,
              (io.grpc.stub.StreamObserver<grpc.bank.bankify.BankReply>) responseObserver);
          break;
        case METHODID_ADD_USER:
          serviceImpl.addUser((grpc.bank.bankify.NewUserData) request,
              (io.grpc.stub.StreamObserver<grpc.bank.bankify.BankReply>) responseObserver);
          break;
        case METHODID_USER_LOGIN:
          serviceImpl.userLogin((grpc.bank.bankify.LoginData) request,
              (io.grpc.stub.StreamObserver<grpc.bank.bankify.LoginReply>) responseObserver);
          break;
        case METHODID_USER_LOGOUT:
          serviceImpl.userLogout((grpc.bank.bankify.LogoutData) request,
              (io.grpc.stub.StreamObserver<grpc.bank.bankify.BankReply>) responseObserver);
          break;
        case METHODID_ACCOUNT_MOVEMENT:
          serviceImpl.accountMovement((grpc.bank.bankify.LoginData) request,
              (io.grpc.stub.StreamObserver<grpc.bank.bankify.MovementData>) responseObserver);
          break;
        case METHODID_GET_BALANCE:
          serviceImpl.getBalance((grpc.bank.bankify.AccountData) request,
              (io.grpc.stub.StreamObserver<grpc.bank.bankify.FloatReply>) responseObserver);
          break;
        case METHODID_TRANSFER_BALANCE:
          serviceImpl.transferBalance((grpc.bank.bankify.AccountTransfer) request,
              (io.grpc.stub.StreamObserver<grpc.bank.bankify.FloatReply>) responseObserver);
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

  private static abstract class BankTransactionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BankTransactionsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.bank.bankify.BankifyServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BankTransactions");
    }
  }

  private static final class BankTransactionsFileDescriptorSupplier
      extends BankTransactionsBaseDescriptorSupplier {
    BankTransactionsFileDescriptorSupplier() {}
  }

  private static final class BankTransactionsMethodDescriptorSupplier
      extends BankTransactionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BankTransactionsMethodDescriptorSupplier(String methodName) {
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
      synchronized (BankTransactionsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BankTransactionsFileDescriptorSupplier())
              .addMethod(getSendDataMethod())
              .addMethod(getAddUserMethod())
              .addMethod(getUserLoginMethod())
              .addMethod(getUserLogoutMethod())
              .addMethod(getAccountMovementMethod())
              .addMethod(getGetBalanceMethod())
              .addMethod(getTransferBalanceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
