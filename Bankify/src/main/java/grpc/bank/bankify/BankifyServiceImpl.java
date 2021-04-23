// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Bankify.proto

package grpc.bank.bankify;

public final class BankifyServiceImpl {
  private BankifyServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bankify_BankRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bankify_BankRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bankify_BankReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bankify_BankReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bankify_NewUserData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bankify_NewUserData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bankify_AccountData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bankify_AccountData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bankify_FloatReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bankify_FloatReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bankify_AccountTransfer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bankify_AccountTransfer_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bankify_LoginData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bankify_LoginData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bankify_LoginReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bankify_LoginReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bankify_LogoutData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bankify_LogoutData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bankify_MovementData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bankify_MovementData_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rBankify.proto\022\007bankify\"\033\n\013BankRequest\022" +
      "\014\n\004name\030\001 \001(\t\"\034\n\tBankReply\022\017\n\007message\030\001 " +
      "\001(\t\"\234\001\n\013NewUserData\022\021\n\tfirstName\030\001 \001(\t\022\020" +
      "\n\010lastName\030\002 \001(\t\022\n\n\002id\030\003 \001(\t\022\016\n\006gender\030\004" +
      " \001(\t\022\r\n\005email\030\005 \001(\t\022\020\n\010password\030\006 \001(\t\022\013\n" +
      "\003pin\030\007 \001(\005\022\r\n\005phone\030\010 \001(\t\022\017\n\007address\030\t \001" +
      "(\t\"1\n\013AccountData\022\025\n\raccountNumber\030\001 \001(\005" +
      "\022\013\n\003pin\030\002 \001(\005\".\n\nFloatReply\022\017\n\007message\030\001" +
      " \001(\t\022\017\n\007balance\030\002 \001(\002\"]\n\017AccountTransfer" +
      "\022\025\n\raccountNumber\030\001 \001(\005\022\013\n\003pin\030\002 \001(\005\022\027\n\017" +
      "toAccountNumber\030\003 \001(\005\022\r\n\005value\030\004 \001(\002\",\n\t" +
      "LoginData\022\r\n\005email\030\001 \001(\t\022\020\n\010password\030\002 \001" +
      "(\t\"[\n\nLoginReply\022\024\n\014LoginMessage\030\001 \001(\t\022\021" +
      "\n\tFirstName\030\002 \001(\t\022\r\n\005email\030\003 \001(\t\022\025\n\racco" +
      "untNumber\030\004 \001(\005\"\033\n\nLogoutData\022\r\n\005email\030\001" +
      " \001(\t\" \n\014MovementData\022\020\n\010movement\030\001 \001(\t2\263" +
      "\003\n\020BankTransactions\0226\n\010SendData\022\024.bankif" +
      "y.BankRequest\032\022.bankify.BankReply\"\000\0225\n\007A" +
      "ddUser\022\024.bankify.NewUserData\032\022.bankify.B" +
      "ankReply\"\000\0226\n\tUserLogin\022\022.bankify.LoginD" +
      "ata\032\023.bankify.LoginReply\"\000\0227\n\nUserLogout" +
      "\022\023.bankify.LogoutData\032\022.bankify.BankRepl" +
      "y\"\000\022@\n\017AccountMovement\022\022.bankify.LoginDa" +
      "ta\032\025.bankify.MovementData\"\0000\001\0229\n\nGetBala" +
      "nce\022\024.bankify.AccountData\032\023.bankify.Floa" +
      "tReply\"\000\022B\n\017TransferBalance\022\030.bankify.Ac" +
      "countTransfer\032\023.bankify.FloatReply\"\000B)\n\021" +
      "grpc.bank.bankifyB\022BankifyServiceImplP\001b" +
      "\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_bankify_BankRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_bankify_BankRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bankify_BankRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_bankify_BankReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_bankify_BankReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bankify_BankReply_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_bankify_NewUserData_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_bankify_NewUserData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bankify_NewUserData_descriptor,
        new java.lang.String[] { "FirstName", "LastName", "Id", "Gender", "Email", "Password", "Pin", "Phone", "Address", });
    internal_static_bankify_AccountData_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_bankify_AccountData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bankify_AccountData_descriptor,
        new java.lang.String[] { "AccountNumber", "Pin", });
    internal_static_bankify_FloatReply_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_bankify_FloatReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bankify_FloatReply_descriptor,
        new java.lang.String[] { "Message", "Balance", });
    internal_static_bankify_AccountTransfer_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_bankify_AccountTransfer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bankify_AccountTransfer_descriptor,
        new java.lang.String[] { "AccountNumber", "Pin", "ToAccountNumber", "Value", });
    internal_static_bankify_LoginData_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_bankify_LoginData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bankify_LoginData_descriptor,
        new java.lang.String[] { "Email", "Password", });
    internal_static_bankify_LoginReply_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_bankify_LoginReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bankify_LoginReply_descriptor,
        new java.lang.String[] { "LoginMessage", "FirstName", "Email", "AccountNumber", });
    internal_static_bankify_LogoutData_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_bankify_LogoutData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bankify_LogoutData_descriptor,
        new java.lang.String[] { "Email", });
    internal_static_bankify_MovementData_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_bankify_MovementData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bankify_MovementData_descriptor,
        new java.lang.String[] { "Movement", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
