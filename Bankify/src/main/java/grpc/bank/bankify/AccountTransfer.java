// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Bankify.proto

package grpc.bank.bankify;

/**
 * <pre>
 * Account, pin, Destination account and value for TransferBalance
 * </pre>
 *
 * Protobuf type {@code bankify.AccountTransfer}
 */
public  final class AccountTransfer extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:bankify.AccountTransfer)
    AccountTransferOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AccountTransfer.newBuilder() to construct.
  private AccountTransfer(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AccountTransfer() {
    accountNumber_ = 0;
    pin_ = 0;
    toAccountNumber_ = 0;
    value_ = 0F;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AccountTransfer(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            accountNumber_ = input.readInt32();
            break;
          }
          case 16: {

            pin_ = input.readInt32();
            break;
          }
          case 24: {

            toAccountNumber_ = input.readInt32();
            break;
          }
          case 37: {

            value_ = input.readFloat();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.bank.bankify.BankifyServiceImpl.internal_static_bankify_AccountTransfer_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.bank.bankify.BankifyServiceImpl.internal_static_bankify_AccountTransfer_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.bank.bankify.AccountTransfer.class, grpc.bank.bankify.AccountTransfer.Builder.class);
  }

  public static final int ACCOUNTNUMBER_FIELD_NUMBER = 1;
  private int accountNumber_;
  /**
   * <code>int32 accountNumber = 1;</code>
   */
  public int getAccountNumber() {
    return accountNumber_;
  }

  public static final int PIN_FIELD_NUMBER = 2;
  private int pin_;
  /**
   * <code>int32 pin = 2;</code>
   */
  public int getPin() {
    return pin_;
  }

  public static final int TOACCOUNTNUMBER_FIELD_NUMBER = 3;
  private int toAccountNumber_;
  /**
   * <code>int32 toAccountNumber = 3;</code>
   */
  public int getToAccountNumber() {
    return toAccountNumber_;
  }

  public static final int VALUE_FIELD_NUMBER = 4;
  private float value_;
  /**
   * <code>float value = 4;</code>
   */
  public float getValue() {
    return value_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (accountNumber_ != 0) {
      output.writeInt32(1, accountNumber_);
    }
    if (pin_ != 0) {
      output.writeInt32(2, pin_);
    }
    if (toAccountNumber_ != 0) {
      output.writeInt32(3, toAccountNumber_);
    }
    if (value_ != 0F) {
      output.writeFloat(4, value_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (accountNumber_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, accountNumber_);
    }
    if (pin_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, pin_);
    }
    if (toAccountNumber_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, toAccountNumber_);
    }
    if (value_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(4, value_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.bank.bankify.AccountTransfer)) {
      return super.equals(obj);
    }
    grpc.bank.bankify.AccountTransfer other = (grpc.bank.bankify.AccountTransfer) obj;

    boolean result = true;
    result = result && (getAccountNumber()
        == other.getAccountNumber());
    result = result && (getPin()
        == other.getPin());
    result = result && (getToAccountNumber()
        == other.getToAccountNumber());
    result = result && (
        java.lang.Float.floatToIntBits(getValue())
        == java.lang.Float.floatToIntBits(
            other.getValue()));
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ACCOUNTNUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getAccountNumber();
    hash = (37 * hash) + PIN_FIELD_NUMBER;
    hash = (53 * hash) + getPin();
    hash = (37 * hash) + TOACCOUNTNUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getToAccountNumber();
    hash = (37 * hash) + VALUE_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getValue());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.bank.bankify.AccountTransfer parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.bank.bankify.AccountTransfer parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.bank.bankify.AccountTransfer parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.bank.bankify.AccountTransfer parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.bank.bankify.AccountTransfer parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.bank.bankify.AccountTransfer parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.bank.bankify.AccountTransfer parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.bank.bankify.AccountTransfer parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.bank.bankify.AccountTransfer parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.bank.bankify.AccountTransfer parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.bank.bankify.AccountTransfer parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.bank.bankify.AccountTransfer parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.bank.bankify.AccountTransfer prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Account, pin, Destination account and value for TransferBalance
   * </pre>
   *
   * Protobuf type {@code bankify.AccountTransfer}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:bankify.AccountTransfer)
      grpc.bank.bankify.AccountTransferOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.bank.bankify.BankifyServiceImpl.internal_static_bankify_AccountTransfer_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.bank.bankify.BankifyServiceImpl.internal_static_bankify_AccountTransfer_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.bank.bankify.AccountTransfer.class, grpc.bank.bankify.AccountTransfer.Builder.class);
    }

    // Construct using grpc.bank.bankify.AccountTransfer.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      accountNumber_ = 0;

      pin_ = 0;

      toAccountNumber_ = 0;

      value_ = 0F;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.bank.bankify.BankifyServiceImpl.internal_static_bankify_AccountTransfer_descriptor;
    }

    @java.lang.Override
    public grpc.bank.bankify.AccountTransfer getDefaultInstanceForType() {
      return grpc.bank.bankify.AccountTransfer.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.bank.bankify.AccountTransfer build() {
      grpc.bank.bankify.AccountTransfer result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.bank.bankify.AccountTransfer buildPartial() {
      grpc.bank.bankify.AccountTransfer result = new grpc.bank.bankify.AccountTransfer(this);
      result.accountNumber_ = accountNumber_;
      result.pin_ = pin_;
      result.toAccountNumber_ = toAccountNumber_;
      result.value_ = value_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.bank.bankify.AccountTransfer) {
        return mergeFrom((grpc.bank.bankify.AccountTransfer)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.bank.bankify.AccountTransfer other) {
      if (other == grpc.bank.bankify.AccountTransfer.getDefaultInstance()) return this;
      if (other.getAccountNumber() != 0) {
        setAccountNumber(other.getAccountNumber());
      }
      if (other.getPin() != 0) {
        setPin(other.getPin());
      }
      if (other.getToAccountNumber() != 0) {
        setToAccountNumber(other.getToAccountNumber());
      }
      if (other.getValue() != 0F) {
        setValue(other.getValue());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      grpc.bank.bankify.AccountTransfer parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.bank.bankify.AccountTransfer) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int accountNumber_ ;
    /**
     * <code>int32 accountNumber = 1;</code>
     */
    public int getAccountNumber() {
      return accountNumber_;
    }
    /**
     * <code>int32 accountNumber = 1;</code>
     */
    public Builder setAccountNumber(int value) {
      
      accountNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 accountNumber = 1;</code>
     */
    public Builder clearAccountNumber() {
      
      accountNumber_ = 0;
      onChanged();
      return this;
    }

    private int pin_ ;
    /**
     * <code>int32 pin = 2;</code>
     */
    public int getPin() {
      return pin_;
    }
    /**
     * <code>int32 pin = 2;</code>
     */
    public Builder setPin(int value) {
      
      pin_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 pin = 2;</code>
     */
    public Builder clearPin() {
      
      pin_ = 0;
      onChanged();
      return this;
    }

    private int toAccountNumber_ ;
    /**
     * <code>int32 toAccountNumber = 3;</code>
     */
    public int getToAccountNumber() {
      return toAccountNumber_;
    }
    /**
     * <code>int32 toAccountNumber = 3;</code>
     */
    public Builder setToAccountNumber(int value) {
      
      toAccountNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 toAccountNumber = 3;</code>
     */
    public Builder clearToAccountNumber() {
      
      toAccountNumber_ = 0;
      onChanged();
      return this;
    }

    private float value_ ;
    /**
     * <code>float value = 4;</code>
     */
    public float getValue() {
      return value_;
    }
    /**
     * <code>float value = 4;</code>
     */
    public Builder setValue(float value) {
      
      value_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float value = 4;</code>
     */
    public Builder clearValue() {
      
      value_ = 0F;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:bankify.AccountTransfer)
  }

  // @@protoc_insertion_point(class_scope:bankify.AccountTransfer)
  private static final grpc.bank.bankify.AccountTransfer DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.bank.bankify.AccountTransfer();
  }

  public static grpc.bank.bankify.AccountTransfer getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AccountTransfer>
      PARSER = new com.google.protobuf.AbstractParser<AccountTransfer>() {
    @java.lang.Override
    public AccountTransfer parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AccountTransfer(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AccountTransfer> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AccountTransfer> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.bank.bankify.AccountTransfer getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

