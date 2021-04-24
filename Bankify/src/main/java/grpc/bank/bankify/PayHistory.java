// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: BankifyPay.proto

package grpc.bank.bankify;

/**
 * Protobuf type {@code bankify.PayHistory}
 */
public  final class PayHistory extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:bankify.PayHistory)
    PayHistoryOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PayHistory.newBuilder() to construct.
  private PayHistory(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PayHistory() {
    cardNumber_ = "";
    holderAcc_ = 0;
    value_ = 0F;
    date_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PayHistory(
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            cardNumber_ = s;
            break;
          }
          case 16: {

            holderAcc_ = input.readInt32();
            break;
          }
          case 29: {

            value_ = input.readFloat();
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            date_ = s;
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
    return grpc.bank.bankify.BankifyPayImpl.internal_static_bankify_PayHistory_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.bank.bankify.BankifyPayImpl.internal_static_bankify_PayHistory_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.bank.bankify.PayHistory.class, grpc.bank.bankify.PayHistory.Builder.class);
  }

  public static final int CARDNUMBER_FIELD_NUMBER = 1;
  private volatile java.lang.Object cardNumber_;
  /**
   * <code>string cardNumber = 1;</code>
   */
  public java.lang.String getCardNumber() {
    java.lang.Object ref = cardNumber_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      cardNumber_ = s;
      return s;
    }
  }
  /**
   * <code>string cardNumber = 1;</code>
   */
  public com.google.protobuf.ByteString
      getCardNumberBytes() {
    java.lang.Object ref = cardNumber_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      cardNumber_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int HOLDERACC_FIELD_NUMBER = 2;
  private int holderAcc_;
  /**
   * <code>int32 holderAcc = 2;</code>
   */
  public int getHolderAcc() {
    return holderAcc_;
  }

  public static final int VALUE_FIELD_NUMBER = 3;
  private float value_;
  /**
   * <code>float value = 3;</code>
   */
  public float getValue() {
    return value_;
  }

  public static final int DATE_FIELD_NUMBER = 4;
  private volatile java.lang.Object date_;
  /**
   * <code>string date = 4;</code>
   */
  public java.lang.String getDate() {
    java.lang.Object ref = date_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      date_ = s;
      return s;
    }
  }
  /**
   * <code>string date = 4;</code>
   */
  public com.google.protobuf.ByteString
      getDateBytes() {
    java.lang.Object ref = date_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      date_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getCardNumberBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, cardNumber_);
    }
    if (holderAcc_ != 0) {
      output.writeInt32(2, holderAcc_);
    }
    if (value_ != 0F) {
      output.writeFloat(3, value_);
    }
    if (!getDateBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, date_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getCardNumberBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, cardNumber_);
    }
    if (holderAcc_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, holderAcc_);
    }
    if (value_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(3, value_);
    }
    if (!getDateBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, date_);
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
    if (!(obj instanceof grpc.bank.bankify.PayHistory)) {
      return super.equals(obj);
    }
    grpc.bank.bankify.PayHistory other = (grpc.bank.bankify.PayHistory) obj;

    boolean result = true;
    result = result && getCardNumber()
        .equals(other.getCardNumber());
    result = result && (getHolderAcc()
        == other.getHolderAcc());
    result = result && (
        java.lang.Float.floatToIntBits(getValue())
        == java.lang.Float.floatToIntBits(
            other.getValue()));
    result = result && getDate()
        .equals(other.getDate());
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
    hash = (37 * hash) + CARDNUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getCardNumber().hashCode();
    hash = (37 * hash) + HOLDERACC_FIELD_NUMBER;
    hash = (53 * hash) + getHolderAcc();
    hash = (37 * hash) + VALUE_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getValue());
    hash = (37 * hash) + DATE_FIELD_NUMBER;
    hash = (53 * hash) + getDate().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.bank.bankify.PayHistory parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.bank.bankify.PayHistory parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.bank.bankify.PayHistory parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.bank.bankify.PayHistory parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.bank.bankify.PayHistory parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.bank.bankify.PayHistory parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.bank.bankify.PayHistory parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.bank.bankify.PayHistory parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.bank.bankify.PayHistory parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.bank.bankify.PayHistory parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.bank.bankify.PayHistory parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.bank.bankify.PayHistory parseFrom(
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
  public static Builder newBuilder(grpc.bank.bankify.PayHistory prototype) {
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
   * Protobuf type {@code bankify.PayHistory}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:bankify.PayHistory)
      grpc.bank.bankify.PayHistoryOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.bank.bankify.BankifyPayImpl.internal_static_bankify_PayHistory_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.bank.bankify.BankifyPayImpl.internal_static_bankify_PayHistory_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.bank.bankify.PayHistory.class, grpc.bank.bankify.PayHistory.Builder.class);
    }

    // Construct using grpc.bank.bankify.PayHistory.newBuilder()
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
      cardNumber_ = "";

      holderAcc_ = 0;

      value_ = 0F;

      date_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.bank.bankify.BankifyPayImpl.internal_static_bankify_PayHistory_descriptor;
    }

    @java.lang.Override
    public grpc.bank.bankify.PayHistory getDefaultInstanceForType() {
      return grpc.bank.bankify.PayHistory.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.bank.bankify.PayHistory build() {
      grpc.bank.bankify.PayHistory result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.bank.bankify.PayHistory buildPartial() {
      grpc.bank.bankify.PayHistory result = new grpc.bank.bankify.PayHistory(this);
      result.cardNumber_ = cardNumber_;
      result.holderAcc_ = holderAcc_;
      result.value_ = value_;
      result.date_ = date_;
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
      if (other instanceof grpc.bank.bankify.PayHistory) {
        return mergeFrom((grpc.bank.bankify.PayHistory)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.bank.bankify.PayHistory other) {
      if (other == grpc.bank.bankify.PayHistory.getDefaultInstance()) return this;
      if (!other.getCardNumber().isEmpty()) {
        cardNumber_ = other.cardNumber_;
        onChanged();
      }
      if (other.getHolderAcc() != 0) {
        setHolderAcc(other.getHolderAcc());
      }
      if (other.getValue() != 0F) {
        setValue(other.getValue());
      }
      if (!other.getDate().isEmpty()) {
        date_ = other.date_;
        onChanged();
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
      grpc.bank.bankify.PayHistory parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.bank.bankify.PayHistory) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object cardNumber_ = "";
    /**
     * <code>string cardNumber = 1;</code>
     */
    public java.lang.String getCardNumber() {
      java.lang.Object ref = cardNumber_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        cardNumber_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string cardNumber = 1;</code>
     */
    public com.google.protobuf.ByteString
        getCardNumberBytes() {
      java.lang.Object ref = cardNumber_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        cardNumber_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string cardNumber = 1;</code>
     */
    public Builder setCardNumber(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      cardNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string cardNumber = 1;</code>
     */
    public Builder clearCardNumber() {
      
      cardNumber_ = getDefaultInstance().getCardNumber();
      onChanged();
      return this;
    }
    /**
     * <code>string cardNumber = 1;</code>
     */
    public Builder setCardNumberBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      cardNumber_ = value;
      onChanged();
      return this;
    }

    private int holderAcc_ ;
    /**
     * <code>int32 holderAcc = 2;</code>
     */
    public int getHolderAcc() {
      return holderAcc_;
    }
    /**
     * <code>int32 holderAcc = 2;</code>
     */
    public Builder setHolderAcc(int value) {
      
      holderAcc_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 holderAcc = 2;</code>
     */
    public Builder clearHolderAcc() {
      
      holderAcc_ = 0;
      onChanged();
      return this;
    }

    private float value_ ;
    /**
     * <code>float value = 3;</code>
     */
    public float getValue() {
      return value_;
    }
    /**
     * <code>float value = 3;</code>
     */
    public Builder setValue(float value) {
      
      value_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float value = 3;</code>
     */
    public Builder clearValue() {
      
      value_ = 0F;
      onChanged();
      return this;
    }

    private java.lang.Object date_ = "";
    /**
     * <code>string date = 4;</code>
     */
    public java.lang.String getDate() {
      java.lang.Object ref = date_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        date_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string date = 4;</code>
     */
    public com.google.protobuf.ByteString
        getDateBytes() {
      java.lang.Object ref = date_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        date_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string date = 4;</code>
     */
    public Builder setDate(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      date_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string date = 4;</code>
     */
    public Builder clearDate() {
      
      date_ = getDefaultInstance().getDate();
      onChanged();
      return this;
    }
    /**
     * <code>string date = 4;</code>
     */
    public Builder setDateBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      date_ = value;
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


    // @@protoc_insertion_point(builder_scope:bankify.PayHistory)
  }

  // @@protoc_insertion_point(class_scope:bankify.PayHistory)
  private static final grpc.bank.bankify.PayHistory DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.bank.bankify.PayHistory();
  }

  public static grpc.bank.bankify.PayHistory getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PayHistory>
      PARSER = new com.google.protobuf.AbstractParser<PayHistory>() {
    @java.lang.Override
    public PayHistory parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PayHistory(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PayHistory> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PayHistory> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.bank.bankify.PayHistory getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
