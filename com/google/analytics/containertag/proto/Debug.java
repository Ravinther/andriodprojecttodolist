package com.google.analytics.containertag.proto;

import com.google.ads.AdSize;
import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite.GeneratedExtension;
import com.google.tagmanager.protobuf.Internal;
import com.google.tagmanager.protobuf.Internal.EnumLite;
import com.google.tagmanager.protobuf.Internal.EnumLiteMap;
import com.google.tagmanager.protobuf.InvalidProtocolBufferException;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MessageLiteOrBuilder;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import com.google.tagmanager.protobuf.WireFormat.FieldType;
import com.mobeta.android.dslv.DragSortController;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Debug {

    public interface DataLayerEventEvaluationInfoOrBuilder extends MessageLiteOrBuilder {
        ResolvedFunctionCall getResults(int i);

        int getResultsCount();

        List<ResolvedFunctionCall> getResultsList();

        RuleEvaluationStepInfo getRulesEvaluation();

        boolean hasRulesEvaluation();
    }

    public interface DebugEventsOrBuilder extends MessageLiteOrBuilder {
        EventInfo getEvent(int i);

        int getEventCount();

        List<EventInfo> getEventList();
    }

    public interface EventInfoOrBuilder extends MessageLiteOrBuilder {
        String getContainerId();

        ByteString getContainerIdBytes();

        String getContainerVersion();

        ByteString getContainerVersionBytes();

        DataLayerEventEvaluationInfo getDataLayerEventResult();

        EventType getEventType();

        String getKey();

        ByteString getKeyBytes();

        MacroEvaluationInfo getMacroResult();

        boolean hasContainerId();

        boolean hasContainerVersion();

        boolean hasDataLayerEventResult();

        boolean hasEventType();

        boolean hasKey();

        boolean hasMacroResult();
    }

    public interface MacroEvaluationInfoOrBuilder extends MessageLiteOrBuilder {
        ResolvedFunctionCall getResult();

        RuleEvaluationStepInfo getRulesEvaluation();

        boolean hasResult();

        boolean hasRulesEvaluation();
    }

    public interface ResolvedFunctionCallOrBuilder extends MessageLiteOrBuilder {
        String getAssociatedRuleName();

        ByteString getAssociatedRuleNameBytes();

        ResolvedProperty getProperties(int i);

        int getPropertiesCount();

        List<ResolvedProperty> getPropertiesList();

        Value getResult();

        boolean hasAssociatedRuleName();

        boolean hasResult();
    }

    public interface ResolvedPropertyOrBuilder extends MessageLiteOrBuilder {
        String getKey();

        ByteString getKeyBytes();

        Value getValue();

        boolean hasKey();

        boolean hasValue();
    }

    public interface ResolvedRuleOrBuilder extends MessageLiteOrBuilder {
        ResolvedFunctionCall getAddMacros(int i);

        int getAddMacrosCount();

        List<ResolvedFunctionCall> getAddMacrosList();

        ResolvedFunctionCall getAddTags(int i);

        int getAddTagsCount();

        List<ResolvedFunctionCall> getAddTagsList();

        ResolvedFunctionCall getNegativePredicates(int i);

        int getNegativePredicatesCount();

        List<ResolvedFunctionCall> getNegativePredicatesList();

        ResolvedFunctionCall getPositivePredicates(int i);

        int getPositivePredicatesCount();

        List<ResolvedFunctionCall> getPositivePredicatesList();

        ResolvedFunctionCall getRemoveMacros(int i);

        int getRemoveMacrosCount();

        List<ResolvedFunctionCall> getRemoveMacrosList();

        ResolvedFunctionCall getRemoveTags(int i);

        int getRemoveTagsCount();

        List<ResolvedFunctionCall> getRemoveTagsList();

        Value getResult();

        boolean hasResult();
    }

    public interface RuleEvaluationStepInfoOrBuilder extends MessageLiteOrBuilder {
        ResolvedFunctionCall getEnabledFunctions(int i);

        int getEnabledFunctionsCount();

        List<ResolvedFunctionCall> getEnabledFunctionsList();

        ResolvedRule getRules(int i);

        int getRulesCount();

        List<ResolvedRule> getRulesList();
    }

    public static final class DataLayerEventEvaluationInfo extends GeneratedMessageLite implements DataLayerEventEvaluationInfoOrBuilder {
        public static Parser<DataLayerEventEvaluationInfo> PARSER = null;
        public static final int RESULTS_FIELD_NUMBER = 2;
        public static final int RULES_EVALUATION_FIELD_NUMBER = 1;
        private static final DataLayerEventEvaluationInfo defaultInstance;
        private static volatile MutableMessageLite mutableDefault;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<ResolvedFunctionCall> results_;
        private RuleEvaluationStepInfo rulesEvaluation_;
        private final ByteString unknownFields;

        /* renamed from: com.google.analytics.containertag.proto.Debug.DataLayerEventEvaluationInfo.1 */
        static class C08341 extends AbstractParser<DataLayerEventEvaluationInfo> {
            C08341() {
            }

            public DataLayerEventEvaluationInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DataLayerEventEvaluationInfo(extensionRegistry, null);
            }
        }

        public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<DataLayerEventEvaluationInfo, Builder> implements DataLayerEventEvaluationInfoOrBuilder {
            private int bitField0_;
            private List<ResolvedFunctionCall> results_;
            private RuleEvaluationStepInfo rulesEvaluation_;

            private Builder() {
                this.rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
                this.results_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
                this.bitField0_ &= -2;
                this.results_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public DataLayerEventEvaluationInfo getDefaultInstanceForType() {
                return DataLayerEventEvaluationInfo.getDefaultInstance();
            }

            public DataLayerEventEvaluationInfo build() {
                DataLayerEventEvaluationInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(result);
            }

            public DataLayerEventEvaluationInfo buildPartial() {
                DataLayerEventEvaluationInfo result = new DataLayerEventEvaluationInfo(null);
                int to_bitField0_ = 0;
                if ((this.bitField0_ & DataLayerEventEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER) == DataLayerEventEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER) {
                    to_bitField0_ = 0 | DataLayerEventEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER;
                }
                result.rulesEvaluation_ = this.rulesEvaluation_;
                if ((this.bitField0_ & DataLayerEventEvaluationInfo.RESULTS_FIELD_NUMBER) == DataLayerEventEvaluationInfo.RESULTS_FIELD_NUMBER) {
                    this.results_ = Collections.unmodifiableList(this.results_);
                    this.bitField0_ &= -3;
                }
                result.results_ = this.results_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            public Builder mergeFrom(DataLayerEventEvaluationInfo other) {
                if (other != DataLayerEventEvaluationInfo.getDefaultInstance()) {
                    if (other.hasRulesEvaluation()) {
                        mergeRulesEvaluation(other.getRulesEvaluation());
                    }
                    if (!other.results_.isEmpty()) {
                        if (this.results_.isEmpty()) {
                            this.results_ = other.results_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureResultsIsMutable();
                            this.results_.addAll(other.results_);
                        }
                    }
                    setUnknownFields(getUnknownFields().concat(other.unknownFields));
                }
                return this;
            }

            public final boolean isInitialized() {
                if (hasRulesEvaluation() && !getRulesEvaluation().isInitialized()) {
                    return false;
                }
                for (int i = 0; i < getResultsCount(); i += DataLayerEventEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER) {
                    if (!getResults(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                DataLayerEventEvaluationInfo parsedMessage = null;
                try {
                    parsedMessage = (DataLayerEventEvaluationInfo) DataLayerEventEvaluationInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DataLayerEventEvaluationInfo) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
            }

            public boolean hasRulesEvaluation() {
                return (this.bitField0_ & DataLayerEventEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER) == DataLayerEventEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER;
            }

            public RuleEvaluationStepInfo getRulesEvaluation() {
                return this.rulesEvaluation_;
            }

            public Builder setRulesEvaluation(RuleEvaluationStepInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.rulesEvaluation_ = value;
                this.bitField0_ |= DataLayerEventEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER;
                return this;
            }

            public Builder setRulesEvaluation(Builder builderForValue) {
                this.rulesEvaluation_ = builderForValue.build();
                this.bitField0_ |= DataLayerEventEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER;
                return this;
            }

            public Builder mergeRulesEvaluation(RuleEvaluationStepInfo value) {
                if ((this.bitField0_ & DataLayerEventEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER) != DataLayerEventEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER || this.rulesEvaluation_ == RuleEvaluationStepInfo.getDefaultInstance()) {
                    this.rulesEvaluation_ = value;
                } else {
                    this.rulesEvaluation_ = RuleEvaluationStepInfo.newBuilder(this.rulesEvaluation_).mergeFrom(value).buildPartial();
                }
                this.bitField0_ |= DataLayerEventEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER;
                return this;
            }

            public Builder clearRulesEvaluation() {
                this.rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
                this.bitField0_ &= -2;
                return this;
            }

            private void ensureResultsIsMutable() {
                if ((this.bitField0_ & DataLayerEventEvaluationInfo.RESULTS_FIELD_NUMBER) != DataLayerEventEvaluationInfo.RESULTS_FIELD_NUMBER) {
                    this.results_ = new ArrayList(this.results_);
                    this.bitField0_ |= DataLayerEventEvaluationInfo.RESULTS_FIELD_NUMBER;
                }
            }

            public List<ResolvedFunctionCall> getResultsList() {
                return Collections.unmodifiableList(this.results_);
            }

            public int getResultsCount() {
                return this.results_.size();
            }

            public ResolvedFunctionCall getResults(int index) {
                return (ResolvedFunctionCall) this.results_.get(index);
            }

            public Builder setResults(int index, ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureResultsIsMutable();
                this.results_.set(index, value);
                return this;
            }

            public Builder setResults(int index, Builder builderForValue) {
                ensureResultsIsMutable();
                this.results_.set(index, builderForValue.build());
                return this;
            }

            public Builder addResults(ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureResultsIsMutable();
                this.results_.add(value);
                return this;
            }

            public Builder addResults(int index, ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureResultsIsMutable();
                this.results_.add(index, value);
                return this;
            }

            public Builder addResults(Builder builderForValue) {
                ensureResultsIsMutable();
                this.results_.add(builderForValue.build());
                return this;
            }

            public Builder addResults(int index, Builder builderForValue) {
                ensureResultsIsMutable();
                this.results_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllResults(Iterable<? extends ResolvedFunctionCall> values) {
                ensureResultsIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.results_);
                return this;
            }

            public Builder clearResults() {
                this.results_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder removeResults(int index) {
                ensureResultsIsMutable();
                this.results_.remove(index);
                return this;
            }
        }

        private DataLayerEventEvaluationInfo(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DataLayerEventEvaluationInfo(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static DataLayerEventEvaluationInfo getDefaultInstance() {
            return defaultInstance;
        }

        public DataLayerEventEvaluationInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        private DataLayerEventEvaluationInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            OutputStream unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            boolean done = false;
            while (!done) {
                try {
                    int tag = input.readTag();
                    switch (tag) {
                        case DragSortController.ON_DOWN /*0*/:
                            done = true;
                            break;
                        case MutableTypeSystem.Value.ESCAPING_FIELD_NUMBER /*10*/:
                            Builder subBuilder = null;
                            if ((this.bitField0_ & RULES_EVALUATION_FIELD_NUMBER) == RULES_EVALUATION_FIELD_NUMBER) {
                                subBuilder = this.rulesEvaluation_.toBuilder();
                            }
                            this.rulesEvaluation_ = (RuleEvaluationStepInfo) input.readMessage(RuleEvaluationStepInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.rulesEvaluation_);
                                this.rulesEvaluation_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= RULES_EVALUATION_FIELD_NUMBER;
                            break;
                        case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                            if ((mutable_bitField0_ & RESULTS_FIELD_NUMBER) != RESULTS_FIELD_NUMBER) {
                                this.results_ = new ArrayList();
                                mutable_bitField0_ |= RESULTS_FIELD_NUMBER;
                            }
                            this.results_.add(input.readMessage(ResolvedFunctionCall.PARSER, extensionRegistry));
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
                                done = true;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if ((mutable_bitField0_ & RESULTS_FIELD_NUMBER) == RESULTS_FIELD_NUMBER) {
                        this.results_ = Collections.unmodifiableList(this.results_);
                    }
                    try {
                        unknownFieldsCodedOutput.flush();
                    } catch (IOException e3) {
                        makeExtensionsImmutable();
                    } finally {
                        this.unknownFields = unknownFieldsOutput.toByteString();
                    }
                    makeExtensionsImmutable();
                }
            }
            if ((mutable_bitField0_ & RESULTS_FIELD_NUMBER) == RESULTS_FIELD_NUMBER) {
                this.results_ = Collections.unmodifiableList(this.results_);
            }
            try {
                unknownFieldsCodedOutput.flush();
            } catch (IOException e4) {
            } finally {
                this.unknownFields = unknownFieldsOutput.toByteString();
            }
            makeExtensionsImmutable();
        }

        static {
            PARSER = new C08341();
            mutableDefault = null;
            defaultInstance = new DataLayerEventEvaluationInfo(true);
            defaultInstance.initFields();
        }

        public Parser<DataLayerEventEvaluationInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasRulesEvaluation() {
            return (this.bitField0_ & RULES_EVALUATION_FIELD_NUMBER) == RULES_EVALUATION_FIELD_NUMBER;
        }

        public RuleEvaluationStepInfo getRulesEvaluation() {
            return this.rulesEvaluation_;
        }

        public List<ResolvedFunctionCall> getResultsList() {
            return this.results_;
        }

        public List<? extends ResolvedFunctionCallOrBuilder> getResultsOrBuilderList() {
            return this.results_;
        }

        public int getResultsCount() {
            return this.results_.size();
        }

        public ResolvedFunctionCall getResults(int index) {
            return (ResolvedFunctionCall) this.results_.get(index);
        }

        public ResolvedFunctionCallOrBuilder getResultsOrBuilder(int index) {
            return (ResolvedFunctionCallOrBuilder) this.results_.get(index);
        }

        private void initFields() {
            this.rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
            this.results_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                if (isInitialized == (byte) 1) {
                    return true;
                }
                return false;
            } else if (!hasRulesEvaluation() || getRulesEvaluation().isInitialized()) {
                int i = 0;
                while (i < getResultsCount()) {
                    if (getResults(i).isInitialized()) {
                        i += RULES_EVALUATION_FIELD_NUMBER;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & RULES_EVALUATION_FIELD_NUMBER) == RULES_EVALUATION_FIELD_NUMBER) {
                output.writeMessage(RULES_EVALUATION_FIELD_NUMBER, this.rulesEvaluation_);
            }
            for (int i = 0; i < this.results_.size(); i += RULES_EVALUATION_FIELD_NUMBER) {
                output.writeMessage(RESULTS_FIELD_NUMBER, (MessageLite) this.results_.get(i));
            }
            output.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & RULES_EVALUATION_FIELD_NUMBER) == RULES_EVALUATION_FIELD_NUMBER) {
                size = 0 + CodedOutputStream.computeMessageSize(RULES_EVALUATION_FIELD_NUMBER, this.rulesEvaluation_);
            }
            for (int i = 0; i < this.results_.size(); i += RULES_EVALUATION_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(RESULTS_FIELD_NUMBER, (MessageLite) this.results_.get(i));
            }
            size += this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DataLayerEventEvaluationInfo)) {
                return super.equals(obj);
            }
            DataLayerEventEvaluationInfo other = (DataLayerEventEvaluationInfo) obj;
            boolean result = true && hasRulesEvaluation() == other.hasRulesEvaluation();
            if (hasRulesEvaluation()) {
                result = result && getRulesEvaluation().equals(other.getRulesEvaluation());
            }
            if (result && getResultsList().equals(other.getResultsList())) {
                result = true;
            } else {
                result = false;
            }
            return result;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = DataLayerEventEvaluationInfo.class.hashCode() + 779;
            if (hasRulesEvaluation()) {
                hash = (((hash * 37) + RULES_EVALUATION_FIELD_NUMBER) * 53) + getRulesEvaluation().hashCode();
            }
            if (getResultsCount() > 0) {
                hash = (((hash * 37) + RESULTS_FIELD_NUMBER) * 53) + getResultsList().hashCode();
            }
            hash = (hash * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$DataLayerEventEvaluationInfo");
            }
            return mutableDefault;
        }

        public static DataLayerEventEvaluationInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DataLayerEventEvaluationInfo) PARSER.parseFrom(data);
        }

        public static DataLayerEventEvaluationInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DataLayerEventEvaluationInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DataLayerEventEvaluationInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DataLayerEventEvaluationInfo) PARSER.parseFrom(data);
        }

        public static DataLayerEventEvaluationInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DataLayerEventEvaluationInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DataLayerEventEvaluationInfo parseFrom(InputStream input) throws IOException {
            return (DataLayerEventEvaluationInfo) PARSER.parseFrom(input);
        }

        public static DataLayerEventEvaluationInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DataLayerEventEvaluationInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DataLayerEventEvaluationInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (DataLayerEventEvaluationInfo) PARSER.parseDelimitedFrom(input);
        }

        public static DataLayerEventEvaluationInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DataLayerEventEvaluationInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DataLayerEventEvaluationInfo parseFrom(CodedInputStream input) throws IOException {
            return (DataLayerEventEvaluationInfo) PARSER.parseFrom(input);
        }

        public static DataLayerEventEvaluationInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DataLayerEventEvaluationInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DataLayerEventEvaluationInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class DebugEvents extends GeneratedMessageLite implements DebugEventsOrBuilder {
        public static final int EVENT_FIELD_NUMBER = 1;
        public static Parser<DebugEvents> PARSER;
        private static final DebugEvents defaultInstance;
        private static volatile MutableMessageLite mutableDefault;
        private static final long serialVersionUID = 0;
        private List<EventInfo> event_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        /* renamed from: com.google.analytics.containertag.proto.Debug.DebugEvents.1 */
        static class C08351 extends AbstractParser<DebugEvents> {
            C08351() {
            }

            public DebugEvents parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DebugEvents(extensionRegistry, null);
            }
        }

        public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<DebugEvents, Builder> implements DebugEventsOrBuilder {
            private int bitField0_;
            private List<EventInfo> event_;

            private Builder() {
                this.event_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.event_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public DebugEvents getDefaultInstanceForType() {
                return DebugEvents.getDefaultInstance();
            }

            public DebugEvents build() {
                DebugEvents result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(result);
            }

            public DebugEvents buildPartial() {
                DebugEvents result = new DebugEvents(null);
                int from_bitField0_ = this.bitField0_;
                if ((this.bitField0_ & DebugEvents.EVENT_FIELD_NUMBER) == DebugEvents.EVENT_FIELD_NUMBER) {
                    this.event_ = Collections.unmodifiableList(this.event_);
                    this.bitField0_ &= -2;
                }
                result.event_ = this.event_;
                return result;
            }

            public Builder mergeFrom(DebugEvents other) {
                if (other != DebugEvents.getDefaultInstance()) {
                    if (!other.event_.isEmpty()) {
                        if (this.event_.isEmpty()) {
                            this.event_ = other.event_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureEventIsMutable();
                            this.event_.addAll(other.event_);
                        }
                    }
                    setUnknownFields(getUnknownFields().concat(other.unknownFields));
                }
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getEventCount(); i += DebugEvents.EVENT_FIELD_NUMBER) {
                    if (!getEvent(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                DebugEvents parsedMessage = null;
                try {
                    parsedMessage = (DebugEvents) DebugEvents.PARSER.parsePartialFrom(input, extensionRegistry);
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (DebugEvents) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
            }

            private void ensureEventIsMutable() {
                if ((this.bitField0_ & DebugEvents.EVENT_FIELD_NUMBER) != DebugEvents.EVENT_FIELD_NUMBER) {
                    this.event_ = new ArrayList(this.event_);
                    this.bitField0_ |= DebugEvents.EVENT_FIELD_NUMBER;
                }
            }

            public List<EventInfo> getEventList() {
                return Collections.unmodifiableList(this.event_);
            }

            public int getEventCount() {
                return this.event_.size();
            }

            public EventInfo getEvent(int index) {
                return (EventInfo) this.event_.get(index);
            }

            public Builder setEvent(int index, EventInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureEventIsMutable();
                this.event_.set(index, value);
                return this;
            }

            public Builder setEvent(int index, Builder builderForValue) {
                ensureEventIsMutable();
                this.event_.set(index, builderForValue.build());
                return this;
            }

            public Builder addEvent(EventInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureEventIsMutable();
                this.event_.add(value);
                return this;
            }

            public Builder addEvent(int index, EventInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureEventIsMutable();
                this.event_.add(index, value);
                return this;
            }

            public Builder addEvent(Builder builderForValue) {
                ensureEventIsMutable();
                this.event_.add(builderForValue.build());
                return this;
            }

            public Builder addEvent(int index, Builder builderForValue) {
                ensureEventIsMutable();
                this.event_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllEvent(Iterable<? extends EventInfo> values) {
                ensureEventIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.event_);
                return this;
            }

            public Builder clearEvent() {
                this.event_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder removeEvent(int index) {
                ensureEventIsMutable();
                this.event_.remove(index);
                return this;
            }
        }

        private DebugEvents(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DebugEvents(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static DebugEvents getDefaultInstance() {
            return defaultInstance;
        }

        public DebugEvents getDefaultInstanceForType() {
            return defaultInstance;
        }

        private DebugEvents(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            OutputStream unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            boolean done = false;
            while (!done) {
                try {
                    int tag = input.readTag();
                    switch (tag) {
                        case DragSortController.ON_DOWN /*0*/:
                            done = true;
                            break;
                        case MutableTypeSystem.Value.ESCAPING_FIELD_NUMBER /*10*/:
                            if ((mutable_bitField0_ & EVENT_FIELD_NUMBER) != EVENT_FIELD_NUMBER) {
                                this.event_ = new ArrayList();
                                mutable_bitField0_ |= EVENT_FIELD_NUMBER;
                            }
                            this.event_.add(input.readMessage(EventInfo.PARSER, extensionRegistry));
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
                                done = true;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if ((mutable_bitField0_ & EVENT_FIELD_NUMBER) == EVENT_FIELD_NUMBER) {
                        this.event_ = Collections.unmodifiableList(this.event_);
                    }
                    try {
                        unknownFieldsCodedOutput.flush();
                    } catch (IOException e3) {
                        makeExtensionsImmutable();
                    } finally {
                        this.unknownFields = unknownFieldsOutput.toByteString();
                    }
                    makeExtensionsImmutable();
                }
            }
            if ((mutable_bitField0_ & EVENT_FIELD_NUMBER) == EVENT_FIELD_NUMBER) {
                this.event_ = Collections.unmodifiableList(this.event_);
            }
            try {
                unknownFieldsCodedOutput.flush();
            } catch (IOException e4) {
            } finally {
                this.unknownFields = unknownFieldsOutput.toByteString();
            }
            makeExtensionsImmutable();
        }

        static {
            PARSER = new C08351();
            mutableDefault = null;
            defaultInstance = new DebugEvents(true);
            defaultInstance.initFields();
        }

        public Parser<DebugEvents> getParserForType() {
            return PARSER;
        }

        public List<EventInfo> getEventList() {
            return this.event_;
        }

        public List<? extends EventInfoOrBuilder> getEventOrBuilderList() {
            return this.event_;
        }

        public int getEventCount() {
            return this.event_.size();
        }

        public EventInfo getEvent(int index) {
            return (EventInfo) this.event_.get(index);
        }

        public EventInfoOrBuilder getEventOrBuilder(int index) {
            return (EventInfoOrBuilder) this.event_.get(index);
        }

        private void initFields() {
            this.event_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == -1) {
                int i = 0;
                while (i < getEventCount()) {
                    if (getEvent(i).isInitialized()) {
                        i += EVENT_FIELD_NUMBER;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else if (isInitialized == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.event_.size(); i += EVENT_FIELD_NUMBER) {
                output.writeMessage(EVENT_FIELD_NUMBER, (MessageLite) this.event_.get(i));
            }
            output.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (int i = 0; i < this.event_.size(); i += EVENT_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(EVENT_FIELD_NUMBER, (MessageLite) this.event_.get(i));
            }
            size += this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DebugEvents)) {
                return super.equals(obj);
            }
            boolean result = true && getEventList().equals(((DebugEvents) obj).getEventList());
            return result;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = DebugEvents.class.hashCode() + 779;
            if (getEventCount() > 0) {
                hash = (((hash * 37) + EVENT_FIELD_NUMBER) * 53) + getEventList().hashCode();
            }
            hash = (hash * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$DebugEvents");
            }
            return mutableDefault;
        }

        public static DebugEvents parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DebugEvents) PARSER.parseFrom(data);
        }

        public static DebugEvents parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DebugEvents) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DebugEvents parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DebugEvents) PARSER.parseFrom(data);
        }

        public static DebugEvents parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DebugEvents) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DebugEvents parseFrom(InputStream input) throws IOException {
            return (DebugEvents) PARSER.parseFrom(input);
        }

        public static DebugEvents parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DebugEvents) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DebugEvents parseDelimitedFrom(InputStream input) throws IOException {
            return (DebugEvents) PARSER.parseDelimitedFrom(input);
        }

        public static DebugEvents parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DebugEvents) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DebugEvents parseFrom(CodedInputStream input) throws IOException {
            return (DebugEvents) PARSER.parseFrom(input);
        }

        public static DebugEvents parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DebugEvents) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DebugEvents prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class EventInfo extends GeneratedMessageLite implements EventInfoOrBuilder {
        public static final int CONTAINER_ID_FIELD_NUMBER = 3;
        public static final int CONTAINER_VERSION_FIELD_NUMBER = 2;
        public static final int DATA_LAYER_EVENT_RESULT_FIELD_NUMBER = 7;
        public static final int EVENT_TYPE_FIELD_NUMBER = 1;
        public static final int KEY_FIELD_NUMBER = 4;
        public static final int MACRO_RESULT_FIELD_NUMBER = 6;
        public static Parser<EventInfo> PARSER;
        private static final EventInfo defaultInstance;
        private static volatile MutableMessageLite mutableDefault;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object containerId_;
        private Object containerVersion_;
        private DataLayerEventEvaluationInfo dataLayerEventResult_;
        private EventType eventType_;
        private Object key_;
        private MacroEvaluationInfo macroResult_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        public enum EventType implements EnumLite {
            DATA_LAYER_EVENT(0, DATA_LAYER_EVENT_VALUE),
            MACRO_REFERENCE(DATA_LAYER_EVENT_VALUE, MACRO_REFERENCE_VALUE);
            
            public static final int DATA_LAYER_EVENT_VALUE = 1;
            public static final int MACRO_REFERENCE_VALUE = 2;
            private static EnumLiteMap<EventType> internalValueMap;
            private final int value;

            /* renamed from: com.google.analytics.containertag.proto.Debug.EventInfo.EventType.1 */
            static class C04861 implements EnumLiteMap<EventType> {
                C04861() {
                }

                public EventType findValueByNumber(int number) {
                    return EventType.valueOf(number);
                }
            }

            static {
                internalValueMap = new C04861();
            }

            public final int getNumber() {
                return this.value;
            }

            public static EventType valueOf(int value) {
                switch (value) {
                    case DATA_LAYER_EVENT_VALUE:
                        return DATA_LAYER_EVENT;
                    case MACRO_REFERENCE_VALUE:
                        return MACRO_REFERENCE;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<EventType> internalGetValueMap() {
                return internalValueMap;
            }

            private EventType(int index, int value) {
                this.value = value;
            }
        }

        /* renamed from: com.google.analytics.containertag.proto.Debug.EventInfo.1 */
        static class C08361 extends AbstractParser<EventInfo> {
            C08361() {
            }

            public EventInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EventInfo(extensionRegistry, null);
            }
        }

        public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<EventInfo, Builder> implements EventInfoOrBuilder {
            private int bitField0_;
            private Object containerId_;
            private Object containerVersion_;
            private DataLayerEventEvaluationInfo dataLayerEventResult_;
            private EventType eventType_;
            private Object key_;
            private MacroEvaluationInfo macroResult_;

            private Builder() {
                this.eventType_ = EventType.DATA_LAYER_EVENT;
                this.containerVersion_ = "";
                this.containerId_ = "";
                this.key_ = "";
                this.macroResult_ = MacroEvaluationInfo.getDefaultInstance();
                this.dataLayerEventResult_ = DataLayerEventEvaluationInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.eventType_ = EventType.DATA_LAYER_EVENT;
                this.bitField0_ &= -2;
                this.containerVersion_ = "";
                this.bitField0_ &= -3;
                this.containerId_ = "";
                this.bitField0_ &= -5;
                this.key_ = "";
                this.bitField0_ &= -9;
                this.macroResult_ = MacroEvaluationInfo.getDefaultInstance();
                this.bitField0_ &= -17;
                this.dataLayerEventResult_ = DataLayerEventEvaluationInfo.getDefaultInstance();
                this.bitField0_ &= -33;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public EventInfo getDefaultInstanceForType() {
                return EventInfo.getDefaultInstance();
            }

            public EventInfo build() {
                EventInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(result);
            }

            public EventInfo buildPartial() {
                EventInfo result = new EventInfo(null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & EventInfo.EVENT_TYPE_FIELD_NUMBER) == EventInfo.EVENT_TYPE_FIELD_NUMBER) {
                    to_bitField0_ = 0 | EventInfo.EVENT_TYPE_FIELD_NUMBER;
                }
                result.eventType_ = this.eventType_;
                if ((from_bitField0_ & EventInfo.CONTAINER_VERSION_FIELD_NUMBER) == EventInfo.CONTAINER_VERSION_FIELD_NUMBER) {
                    to_bitField0_ |= EventInfo.CONTAINER_VERSION_FIELD_NUMBER;
                }
                result.containerVersion_ = this.containerVersion_;
                if ((from_bitField0_ & EventInfo.KEY_FIELD_NUMBER) == EventInfo.KEY_FIELD_NUMBER) {
                    to_bitField0_ |= EventInfo.KEY_FIELD_NUMBER;
                }
                result.containerId_ = this.containerId_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 8;
                }
                result.key_ = this.key_;
                if ((from_bitField0_ & 16) == 16) {
                    to_bitField0_ |= 16;
                }
                result.macroResult_ = this.macroResult_;
                if ((from_bitField0_ & 32) == 32) {
                    to_bitField0_ |= 32;
                }
                result.dataLayerEventResult_ = this.dataLayerEventResult_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            public Builder mergeFrom(EventInfo other) {
                if (other != EventInfo.getDefaultInstance()) {
                    if (other.hasEventType()) {
                        setEventType(other.getEventType());
                    }
                    if (other.hasContainerVersion()) {
                        this.bitField0_ |= EventInfo.CONTAINER_VERSION_FIELD_NUMBER;
                        this.containerVersion_ = other.containerVersion_;
                    }
                    if (other.hasContainerId()) {
                        this.bitField0_ |= EventInfo.KEY_FIELD_NUMBER;
                        this.containerId_ = other.containerId_;
                    }
                    if (other.hasKey()) {
                        this.bitField0_ |= 8;
                        this.key_ = other.key_;
                    }
                    if (other.hasMacroResult()) {
                        mergeMacroResult(other.getMacroResult());
                    }
                    if (other.hasDataLayerEventResult()) {
                        mergeDataLayerEventResult(other.getDataLayerEventResult());
                    }
                    setUnknownFields(getUnknownFields().concat(other.unknownFields));
                }
                return this;
            }

            public final boolean isInitialized() {
                if (hasMacroResult() && !getMacroResult().isInitialized()) {
                    return false;
                }
                if (!hasDataLayerEventResult() || getDataLayerEventResult().isInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                EventInfo parsedMessage = null;
                try {
                    parsedMessage = (EventInfo) EventInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (EventInfo) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
            }

            public boolean hasEventType() {
                return (this.bitField0_ & EventInfo.EVENT_TYPE_FIELD_NUMBER) == EventInfo.EVENT_TYPE_FIELD_NUMBER;
            }

            public EventType getEventType() {
                return this.eventType_;
            }

            public Builder setEventType(EventType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= EventInfo.EVENT_TYPE_FIELD_NUMBER;
                this.eventType_ = value;
                return this;
            }

            public Builder clearEventType() {
                this.bitField0_ &= -2;
                this.eventType_ = EventType.DATA_LAYER_EVENT;
                return this;
            }

            public boolean hasContainerVersion() {
                return (this.bitField0_ & EventInfo.CONTAINER_VERSION_FIELD_NUMBER) == EventInfo.CONTAINER_VERSION_FIELD_NUMBER;
            }

            public String getContainerVersion() {
                ByteString ref = this.containerVersion_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                ByteString bs = ref;
                String s = bs.toStringUtf8();
                if (!bs.isValidUtf8()) {
                    return s;
                }
                this.containerVersion_ = s;
                return s;
            }

            public ByteString getContainerVersionBytes() {
                Object ref = this.containerVersion_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.containerVersion_ = b;
                return b;
            }

            public Builder setContainerVersion(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= EventInfo.CONTAINER_VERSION_FIELD_NUMBER;
                this.containerVersion_ = value;
                return this;
            }

            public Builder clearContainerVersion() {
                this.bitField0_ &= -3;
                this.containerVersion_ = EventInfo.getDefaultInstance().getContainerVersion();
                return this;
            }

            public Builder setContainerVersionBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= EventInfo.CONTAINER_VERSION_FIELD_NUMBER;
                this.containerVersion_ = value;
                return this;
            }

            public boolean hasContainerId() {
                return (this.bitField0_ & EventInfo.KEY_FIELD_NUMBER) == EventInfo.KEY_FIELD_NUMBER;
            }

            public String getContainerId() {
                ByteString ref = this.containerId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                ByteString bs = ref;
                String s = bs.toStringUtf8();
                if (!bs.isValidUtf8()) {
                    return s;
                }
                this.containerId_ = s;
                return s;
            }

            public ByteString getContainerIdBytes() {
                Object ref = this.containerId_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.containerId_ = b;
                return b;
            }

            public Builder setContainerId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= EventInfo.KEY_FIELD_NUMBER;
                this.containerId_ = value;
                return this;
            }

            public Builder clearContainerId() {
                this.bitField0_ &= -5;
                this.containerId_ = EventInfo.getDefaultInstance().getContainerId();
                return this;
            }

            public Builder setContainerIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= EventInfo.KEY_FIELD_NUMBER;
                this.containerId_ = value;
                return this;
            }

            public boolean hasKey() {
                return (this.bitField0_ & 8) == 8;
            }

            public String getKey() {
                ByteString ref = this.key_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                ByteString bs = ref;
                String s = bs.toStringUtf8();
                if (!bs.isValidUtf8()) {
                    return s;
                }
                this.key_ = s;
                return s;
            }

            public ByteString getKeyBytes() {
                Object ref = this.key_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.key_ = b;
                return b;
            }

            public Builder setKey(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.key_ = value;
                return this;
            }

            public Builder clearKey() {
                this.bitField0_ &= -9;
                this.key_ = EventInfo.getDefaultInstance().getKey();
                return this;
            }

            public Builder setKeyBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.key_ = value;
                return this;
            }

            public boolean hasMacroResult() {
                return (this.bitField0_ & 16) == 16;
            }

            public MacroEvaluationInfo getMacroResult() {
                return this.macroResult_;
            }

            public Builder setMacroResult(MacroEvaluationInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.macroResult_ = value;
                this.bitField0_ |= 16;
                return this;
            }

            public Builder setMacroResult(Builder builderForValue) {
                this.macroResult_ = builderForValue.build();
                this.bitField0_ |= 16;
                return this;
            }

            public Builder mergeMacroResult(MacroEvaluationInfo value) {
                if ((this.bitField0_ & 16) != 16 || this.macroResult_ == MacroEvaluationInfo.getDefaultInstance()) {
                    this.macroResult_ = value;
                } else {
                    this.macroResult_ = MacroEvaluationInfo.newBuilder(this.macroResult_).mergeFrom(value).buildPartial();
                }
                this.bitField0_ |= 16;
                return this;
            }

            public Builder clearMacroResult() {
                this.macroResult_ = MacroEvaluationInfo.getDefaultInstance();
                this.bitField0_ &= -17;
                return this;
            }

            public boolean hasDataLayerEventResult() {
                return (this.bitField0_ & 32) == 32;
            }

            public DataLayerEventEvaluationInfo getDataLayerEventResult() {
                return this.dataLayerEventResult_;
            }

            public Builder setDataLayerEventResult(DataLayerEventEvaluationInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.dataLayerEventResult_ = value;
                this.bitField0_ |= 32;
                return this;
            }

            public Builder setDataLayerEventResult(Builder builderForValue) {
                this.dataLayerEventResult_ = builderForValue.build();
                this.bitField0_ |= 32;
                return this;
            }

            public Builder mergeDataLayerEventResult(DataLayerEventEvaluationInfo value) {
                if ((this.bitField0_ & 32) != 32 || this.dataLayerEventResult_ == DataLayerEventEvaluationInfo.getDefaultInstance()) {
                    this.dataLayerEventResult_ = value;
                } else {
                    this.dataLayerEventResult_ = DataLayerEventEvaluationInfo.newBuilder(this.dataLayerEventResult_).mergeFrom(value).buildPartial();
                }
                this.bitField0_ |= 32;
                return this;
            }

            public Builder clearDataLayerEventResult() {
                this.dataLayerEventResult_ = DataLayerEventEvaluationInfo.getDefaultInstance();
                this.bitField0_ &= -33;
                return this;
            }
        }

        private EventInfo(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private EventInfo(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static EventInfo getDefaultInstance() {
            return defaultInstance;
        }

        public EventInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        private EventInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            OutputStream unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            boolean done = false;
            while (!done) {
                try {
                    int tag = input.readTag();
                    ByteString bs;
                    switch (tag) {
                        case DragSortController.ON_DOWN /*0*/:
                            done = true;
                            break;
                        case MutableTypeSystem.Value.INTEGER_FIELD_NUMBER /*8*/:
                            int rawValue = input.readEnum();
                            EventType value = EventType.valueOf(rawValue);
                            if (value != null) {
                                this.bitField0_ |= EVENT_TYPE_FIELD_NUMBER;
                                this.eventType_ = value;
                                break;
                            }
                            unknownFieldsCodedOutput.writeRawVarint32(tag);
                            unknownFieldsCodedOutput.writeRawVarint32(rawValue);
                            break;
                        case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                            bs = input.readBytes();
                            this.bitField0_ |= CONTAINER_VERSION_FIELD_NUMBER;
                            this.containerVersion_ = bs;
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= KEY_FIELD_NUMBER;
                            this.containerId_ = bs;
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 8;
                            this.key_ = bs;
                            break;
                        case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                            Builder subBuilder = null;
                            if ((this.bitField0_ & 16) == 16) {
                                subBuilder = this.macroResult_.toBuilder();
                            }
                            this.macroResult_ = (MacroEvaluationInfo) input.readMessage(MacroEvaluationInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.macroResult_);
                                this.macroResult_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 16;
                            break;
                        case 58:
                            Builder subBuilder2 = null;
                            if ((this.bitField0_ & 32) == 32) {
                                subBuilder2 = this.dataLayerEventResult_.toBuilder();
                            }
                            this.dataLayerEventResult_ = (DataLayerEventEvaluationInfo) input.readMessage(DataLayerEventEvaluationInfo.PARSER, extensionRegistry);
                            if (subBuilder2 != null) {
                                subBuilder2.mergeFrom(this.dataLayerEventResult_);
                                this.dataLayerEventResult_ = subBuilder2.buildPartial();
                            }
                            this.bitField0_ |= 32;
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
                                done = true;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    try {
                        unknownFieldsCodedOutput.flush();
                    } catch (IOException e3) {
                        makeExtensionsImmutable();
                    } finally {
                        this.unknownFields = unknownFieldsOutput.toByteString();
                    }
                    makeExtensionsImmutable();
                }
            }
            try {
                unknownFieldsCodedOutput.flush();
            } catch (IOException e4) {
            } finally {
                this.unknownFields = unknownFieldsOutput.toByteString();
            }
            makeExtensionsImmutable();
        }

        static {
            PARSER = new C08361();
            mutableDefault = null;
            defaultInstance = new EventInfo(true);
            defaultInstance.initFields();
        }

        public Parser<EventInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasEventType() {
            return (this.bitField0_ & EVENT_TYPE_FIELD_NUMBER) == EVENT_TYPE_FIELD_NUMBER;
        }

        public EventType getEventType() {
            return this.eventType_;
        }

        public boolean hasContainerVersion() {
            return (this.bitField0_ & CONTAINER_VERSION_FIELD_NUMBER) == CONTAINER_VERSION_FIELD_NUMBER;
        }

        public String getContainerVersion() {
            ByteString ref = this.containerVersion_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.containerVersion_ = s;
            }
            return s;
        }

        public ByteString getContainerVersionBytes() {
            Object ref = this.containerVersion_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.containerVersion_ = b;
            return b;
        }

        public boolean hasContainerId() {
            return (this.bitField0_ & KEY_FIELD_NUMBER) == KEY_FIELD_NUMBER;
        }

        public String getContainerId() {
            ByteString ref = this.containerId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.containerId_ = s;
            }
            return s;
        }

        public ByteString getContainerIdBytes() {
            Object ref = this.containerId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.containerId_ = b;
            return b;
        }

        public boolean hasKey() {
            return (this.bitField0_ & 8) == 8;
        }

        public String getKey() {
            ByteString ref = this.key_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.key_ = s;
            }
            return s;
        }

        public ByteString getKeyBytes() {
            Object ref = this.key_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.key_ = b;
            return b;
        }

        public boolean hasMacroResult() {
            return (this.bitField0_ & 16) == 16;
        }

        public MacroEvaluationInfo getMacroResult() {
            return this.macroResult_;
        }

        public boolean hasDataLayerEventResult() {
            return (this.bitField0_ & 32) == 32;
        }

        public DataLayerEventEvaluationInfo getDataLayerEventResult() {
            return this.dataLayerEventResult_;
        }

        private void initFields() {
            this.eventType_ = EventType.DATA_LAYER_EVENT;
            this.containerVersion_ = "";
            this.containerId_ = "";
            this.key_ = "";
            this.macroResult_ = MacroEvaluationInfo.getDefaultInstance();
            this.dataLayerEventResult_ = DataLayerEventEvaluationInfo.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                if (isInitialized == (byte) 1) {
                    return true;
                }
                return false;
            } else if (hasMacroResult() && !getMacroResult().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!hasDataLayerEventResult() || getDataLayerEventResult().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & EVENT_TYPE_FIELD_NUMBER) == EVENT_TYPE_FIELD_NUMBER) {
                output.writeEnum(EVENT_TYPE_FIELD_NUMBER, this.eventType_.getNumber());
            }
            if ((this.bitField0_ & CONTAINER_VERSION_FIELD_NUMBER) == CONTAINER_VERSION_FIELD_NUMBER) {
                output.writeBytes(CONTAINER_VERSION_FIELD_NUMBER, getContainerVersionBytes());
            }
            if ((this.bitField0_ & KEY_FIELD_NUMBER) == KEY_FIELD_NUMBER) {
                output.writeBytes(CONTAINER_ID_FIELD_NUMBER, getContainerIdBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeBytes(KEY_FIELD_NUMBER, getKeyBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                output.writeMessage(MACRO_RESULT_FIELD_NUMBER, this.macroResult_);
            }
            if ((this.bitField0_ & 32) == 32) {
                output.writeMessage(DATA_LAYER_EVENT_RESULT_FIELD_NUMBER, this.dataLayerEventResult_);
            }
            output.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & EVENT_TYPE_FIELD_NUMBER) == EVENT_TYPE_FIELD_NUMBER) {
                size = 0 + CodedOutputStream.computeEnumSize(EVENT_TYPE_FIELD_NUMBER, this.eventType_.getNumber());
            }
            if ((this.bitField0_ & CONTAINER_VERSION_FIELD_NUMBER) == CONTAINER_VERSION_FIELD_NUMBER) {
                size += CodedOutputStream.computeBytesSize(CONTAINER_VERSION_FIELD_NUMBER, getContainerVersionBytes());
            }
            if ((this.bitField0_ & KEY_FIELD_NUMBER) == KEY_FIELD_NUMBER) {
                size += CodedOutputStream.computeBytesSize(CONTAINER_ID_FIELD_NUMBER, getContainerIdBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeBytesSize(KEY_FIELD_NUMBER, getKeyBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                size += CodedOutputStream.computeMessageSize(MACRO_RESULT_FIELD_NUMBER, this.macroResult_);
            }
            if ((this.bitField0_ & 32) == 32) {
                size += CodedOutputStream.computeMessageSize(DATA_LAYER_EVENT_RESULT_FIELD_NUMBER, this.dataLayerEventResult_);
            }
            size += this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EventInfo)) {
                return super.equals(obj);
            }
            EventInfo other = (EventInfo) obj;
            boolean result = true && hasEventType() == other.hasEventType();
            if (hasEventType()) {
                result = result && getEventType() == other.getEventType();
            }
            if (result && hasContainerVersion() == other.hasContainerVersion()) {
                result = true;
            } else {
                result = false;
            }
            if (hasContainerVersion()) {
                if (result && getContainerVersion().equals(other.getContainerVersion())) {
                    result = true;
                } else {
                    result = false;
                }
            }
            if (result && hasContainerId() == other.hasContainerId()) {
                result = true;
            } else {
                result = false;
            }
            if (hasContainerId()) {
                if (result && getContainerId().equals(other.getContainerId())) {
                    result = true;
                } else {
                    result = false;
                }
            }
            if (result && hasKey() == other.hasKey()) {
                result = true;
            } else {
                result = false;
            }
            if (hasKey()) {
                if (result && getKey().equals(other.getKey())) {
                    result = true;
                } else {
                    result = false;
                }
            }
            if (result && hasMacroResult() == other.hasMacroResult()) {
                result = true;
            } else {
                result = false;
            }
            if (hasMacroResult()) {
                if (result && getMacroResult().equals(other.getMacroResult())) {
                    result = true;
                } else {
                    result = false;
                }
            }
            if (result && hasDataLayerEventResult() == other.hasDataLayerEventResult()) {
                result = true;
            } else {
                result = false;
            }
            if (hasDataLayerEventResult()) {
                if (result && getDataLayerEventResult().equals(other.getDataLayerEventResult())) {
                    result = true;
                } else {
                    result = false;
                }
            }
            return result;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = EventInfo.class.hashCode() + 779;
            if (hasEventType()) {
                hash = (((hash * 37) + EVENT_TYPE_FIELD_NUMBER) * 53) + Internal.hashEnum(getEventType());
            }
            if (hasContainerVersion()) {
                hash = (((hash * 37) + CONTAINER_VERSION_FIELD_NUMBER) * 53) + getContainerVersion().hashCode();
            }
            if (hasContainerId()) {
                hash = (((hash * 37) + CONTAINER_ID_FIELD_NUMBER) * 53) + getContainerId().hashCode();
            }
            if (hasKey()) {
                hash = (((hash * 37) + KEY_FIELD_NUMBER) * 53) + getKey().hashCode();
            }
            if (hasMacroResult()) {
                hash = (((hash * 37) + MACRO_RESULT_FIELD_NUMBER) * 53) + getMacroResult().hashCode();
            }
            if (hasDataLayerEventResult()) {
                hash = (((hash * 37) + DATA_LAYER_EVENT_RESULT_FIELD_NUMBER) * 53) + getDataLayerEventResult().hashCode();
            }
            hash = (hash * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$EventInfo");
            }
            return mutableDefault;
        }

        public static EventInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (EventInfo) PARSER.parseFrom(data);
        }

        public static EventInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EventInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static EventInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (EventInfo) PARSER.parseFrom(data);
        }

        public static EventInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EventInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static EventInfo parseFrom(InputStream input) throws IOException {
            return (EventInfo) PARSER.parseFrom(input);
        }

        public static EventInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EventInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static EventInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (EventInfo) PARSER.parseDelimitedFrom(input);
        }

        public static EventInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EventInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static EventInfo parseFrom(CodedInputStream input) throws IOException {
            return (EventInfo) PARSER.parseFrom(input);
        }

        public static EventInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EventInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EventInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class MacroEvaluationInfo extends GeneratedMessageLite implements MacroEvaluationInfoOrBuilder {
        public static final int MACRO_FIELD_NUMBER = 47497405;
        public static Parser<MacroEvaluationInfo> PARSER = null;
        public static final int RESULT_FIELD_NUMBER = 3;
        public static final int RULES_EVALUATION_FIELD_NUMBER = 1;
        private static final MacroEvaluationInfo defaultInstance;
        public static final GeneratedExtension<Value, MacroEvaluationInfo> macro;
        private static volatile MutableMessageLite mutableDefault;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private ResolvedFunctionCall result_;
        private RuleEvaluationStepInfo rulesEvaluation_;
        private final ByteString unknownFields;

        /* renamed from: com.google.analytics.containertag.proto.Debug.MacroEvaluationInfo.1 */
        static class C08371 extends AbstractParser<MacroEvaluationInfo> {
            C08371() {
            }

            public MacroEvaluationInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MacroEvaluationInfo(extensionRegistry, null);
            }
        }

        public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<MacroEvaluationInfo, Builder> implements MacroEvaluationInfoOrBuilder {
            private int bitField0_;
            private ResolvedFunctionCall result_;
            private RuleEvaluationStepInfo rulesEvaluation_;

            private Builder() {
                this.rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
                this.result_ = ResolvedFunctionCall.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
                this.bitField0_ &= -2;
                this.result_ = ResolvedFunctionCall.getDefaultInstance();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public MacroEvaluationInfo getDefaultInstanceForType() {
                return MacroEvaluationInfo.getDefaultInstance();
            }

            public MacroEvaluationInfo build() {
                MacroEvaluationInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(result);
            }

            public MacroEvaluationInfo buildPartial() {
                MacroEvaluationInfo result = new MacroEvaluationInfo(null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & MacroEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER) == MacroEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER) {
                    to_bitField0_ = 0 | MacroEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER;
                }
                result.rulesEvaluation_ = this.rulesEvaluation_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.result_ = this.result_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            public Builder mergeFrom(MacroEvaluationInfo other) {
                if (other != MacroEvaluationInfo.getDefaultInstance()) {
                    if (other.hasRulesEvaluation()) {
                        mergeRulesEvaluation(other.getRulesEvaluation());
                    }
                    if (other.hasResult()) {
                        mergeResult(other.getResult());
                    }
                    setUnknownFields(getUnknownFields().concat(other.unknownFields));
                }
                return this;
            }

            public final boolean isInitialized() {
                if (hasRulesEvaluation() && !getRulesEvaluation().isInitialized()) {
                    return false;
                }
                if (!hasResult() || getResult().isInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MacroEvaluationInfo parsedMessage = null;
                try {
                    parsedMessage = (MacroEvaluationInfo) MacroEvaluationInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MacroEvaluationInfo) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
            }

            public boolean hasRulesEvaluation() {
                return (this.bitField0_ & MacroEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER) == MacroEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER;
            }

            public RuleEvaluationStepInfo getRulesEvaluation() {
                return this.rulesEvaluation_;
            }

            public Builder setRulesEvaluation(RuleEvaluationStepInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.rulesEvaluation_ = value;
                this.bitField0_ |= MacroEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER;
                return this;
            }

            public Builder setRulesEvaluation(Builder builderForValue) {
                this.rulesEvaluation_ = builderForValue.build();
                this.bitField0_ |= MacroEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER;
                return this;
            }

            public Builder mergeRulesEvaluation(RuleEvaluationStepInfo value) {
                if ((this.bitField0_ & MacroEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER) != MacroEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER || this.rulesEvaluation_ == RuleEvaluationStepInfo.getDefaultInstance()) {
                    this.rulesEvaluation_ = value;
                } else {
                    this.rulesEvaluation_ = RuleEvaluationStepInfo.newBuilder(this.rulesEvaluation_).mergeFrom(value).buildPartial();
                }
                this.bitField0_ |= MacroEvaluationInfo.RULES_EVALUATION_FIELD_NUMBER;
                return this;
            }

            public Builder clearRulesEvaluation() {
                this.rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
                this.bitField0_ &= -2;
                return this;
            }

            public boolean hasResult() {
                return (this.bitField0_ & 2) == 2;
            }

            public ResolvedFunctionCall getResult() {
                return this.result_;
            }

            public Builder setResult(ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result_ = value;
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setResult(Builder builderForValue) {
                this.result_ = builderForValue.build();
                this.bitField0_ |= 2;
                return this;
            }

            public Builder mergeResult(ResolvedFunctionCall value) {
                if ((this.bitField0_ & 2) != 2 || this.result_ == ResolvedFunctionCall.getDefaultInstance()) {
                    this.result_ = value;
                } else {
                    this.result_ = ResolvedFunctionCall.newBuilder(this.result_).mergeFrom(value).buildPartial();
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder clearResult() {
                this.result_ = ResolvedFunctionCall.getDefaultInstance();
                this.bitField0_ &= -3;
                return this;
            }
        }

        private MacroEvaluationInfo(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MacroEvaluationInfo(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static MacroEvaluationInfo getDefaultInstance() {
            return defaultInstance;
        }

        public MacroEvaluationInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        private MacroEvaluationInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            OutputStream unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            boolean done = false;
            while (!done) {
                try {
                    int tag = input.readTag();
                    switch (tag) {
                        case DragSortController.ON_DOWN /*0*/:
                            done = true;
                            break;
                        case MutableTypeSystem.Value.ESCAPING_FIELD_NUMBER /*10*/:
                            Builder subBuilder = null;
                            if ((this.bitField0_ & RULES_EVALUATION_FIELD_NUMBER) == RULES_EVALUATION_FIELD_NUMBER) {
                                subBuilder = this.rulesEvaluation_.toBuilder();
                            }
                            this.rulesEvaluation_ = (RuleEvaluationStepInfo) input.readMessage(RuleEvaluationStepInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.rulesEvaluation_);
                                this.rulesEvaluation_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= RULES_EVALUATION_FIELD_NUMBER;
                            break;
                        case 26:
                            Builder subBuilder2 = null;
                            if ((this.bitField0_ & 2) == 2) {
                                subBuilder2 = this.result_.toBuilder();
                            }
                            this.result_ = (ResolvedFunctionCall) input.readMessage(ResolvedFunctionCall.PARSER, extensionRegistry);
                            if (subBuilder2 != null) {
                                subBuilder2.mergeFrom(this.result_);
                                this.result_ = subBuilder2.buildPartial();
                            }
                            this.bitField0_ |= 2;
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
                                done = true;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    try {
                        unknownFieldsCodedOutput.flush();
                    } catch (IOException e3) {
                        makeExtensionsImmutable();
                    } finally {
                        this.unknownFields = unknownFieldsOutput.toByteString();
                    }
                    makeExtensionsImmutable();
                }
            }
            try {
                unknownFieldsCodedOutput.flush();
            } catch (IOException e4) {
            } finally {
                this.unknownFields = unknownFieldsOutput.toByteString();
            }
            makeExtensionsImmutable();
        }

        static {
            PARSER = new C08371();
            mutableDefault = null;
            defaultInstance = new MacroEvaluationInfo(true);
            defaultInstance.initFields();
            macro = GeneratedMessageLite.newSingularGeneratedExtension(Value.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, MACRO_FIELD_NUMBER, FieldType.MESSAGE, MacroEvaluationInfo.class);
        }

        public Parser<MacroEvaluationInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasRulesEvaluation() {
            return (this.bitField0_ & RULES_EVALUATION_FIELD_NUMBER) == RULES_EVALUATION_FIELD_NUMBER;
        }

        public RuleEvaluationStepInfo getRulesEvaluation() {
            return this.rulesEvaluation_;
        }

        public boolean hasResult() {
            return (this.bitField0_ & 2) == 2;
        }

        public ResolvedFunctionCall getResult() {
            return this.result_;
        }

        private void initFields() {
            this.rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
            this.result_ = ResolvedFunctionCall.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                if (isInitialized == (byte) 1) {
                    return true;
                }
                return false;
            } else if (hasRulesEvaluation() && !getRulesEvaluation().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!hasResult() || getResult().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & RULES_EVALUATION_FIELD_NUMBER) == RULES_EVALUATION_FIELD_NUMBER) {
                output.writeMessage(RULES_EVALUATION_FIELD_NUMBER, this.rulesEvaluation_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeMessage(RESULT_FIELD_NUMBER, this.result_);
            }
            output.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & RULES_EVALUATION_FIELD_NUMBER) == RULES_EVALUATION_FIELD_NUMBER) {
                size = 0 + CodedOutputStream.computeMessageSize(RULES_EVALUATION_FIELD_NUMBER, this.rulesEvaluation_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeMessageSize(RESULT_FIELD_NUMBER, this.result_);
            }
            size += this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MacroEvaluationInfo)) {
                return super.equals(obj);
            }
            MacroEvaluationInfo other = (MacroEvaluationInfo) obj;
            boolean result = true && hasRulesEvaluation() == other.hasRulesEvaluation();
            if (hasRulesEvaluation()) {
                result = result && getRulesEvaluation().equals(other.getRulesEvaluation());
            }
            if (result && hasResult() == other.hasResult()) {
                result = true;
            } else {
                result = false;
            }
            if (hasResult()) {
                if (result && getResult().equals(other.getResult())) {
                    result = true;
                } else {
                    result = false;
                }
            }
            return result;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = MacroEvaluationInfo.class.hashCode() + 779;
            if (hasRulesEvaluation()) {
                hash = (((hash * 37) + RULES_EVALUATION_FIELD_NUMBER) * 53) + getRulesEvaluation().hashCode();
            }
            if (hasResult()) {
                hash = (((hash * 37) + RESULT_FIELD_NUMBER) * 53) + getResult().hashCode();
            }
            hash = (hash * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$MacroEvaluationInfo");
            }
            return mutableDefault;
        }

        public static MacroEvaluationInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MacroEvaluationInfo) PARSER.parseFrom(data);
        }

        public static MacroEvaluationInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MacroEvaluationInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MacroEvaluationInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MacroEvaluationInfo) PARSER.parseFrom(data);
        }

        public static MacroEvaluationInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MacroEvaluationInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MacroEvaluationInfo parseFrom(InputStream input) throws IOException {
            return (MacroEvaluationInfo) PARSER.parseFrom(input);
        }

        public static MacroEvaluationInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MacroEvaluationInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MacroEvaluationInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (MacroEvaluationInfo) PARSER.parseDelimitedFrom(input);
        }

        public static MacroEvaluationInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MacroEvaluationInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MacroEvaluationInfo parseFrom(CodedInputStream input) throws IOException {
            return (MacroEvaluationInfo) PARSER.parseFrom(input);
        }

        public static MacroEvaluationInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MacroEvaluationInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MacroEvaluationInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class ResolvedFunctionCall extends GeneratedMessageLite implements ResolvedFunctionCallOrBuilder {
        public static final int ASSOCIATED_RULE_NAME_FIELD_NUMBER = 3;
        public static Parser<ResolvedFunctionCall> PARSER = null;
        public static final int PROPERTIES_FIELD_NUMBER = 1;
        public static final int RESULT_FIELD_NUMBER = 2;
        private static final ResolvedFunctionCall defaultInstance;
        private static volatile MutableMessageLite mutableDefault;
        private static final long serialVersionUID = 0;
        private Object associatedRuleName_;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<ResolvedProperty> properties_;
        private Value result_;
        private final ByteString unknownFields;

        /* renamed from: com.google.analytics.containertag.proto.Debug.ResolvedFunctionCall.1 */
        static class C08381 extends AbstractParser<ResolvedFunctionCall> {
            C08381() {
            }

            public ResolvedFunctionCall parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ResolvedFunctionCall(extensionRegistry, null);
            }
        }

        public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<ResolvedFunctionCall, Builder> implements ResolvedFunctionCallOrBuilder {
            private Object associatedRuleName_;
            private int bitField0_;
            private List<ResolvedProperty> properties_;
            private Value result_;

            private Builder() {
                this.properties_ = Collections.emptyList();
                this.result_ = Value.getDefaultInstance();
                this.associatedRuleName_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.properties_ = Collections.emptyList();
                this.bitField0_ &= -2;
                this.result_ = Value.getDefaultInstance();
                this.bitField0_ &= -3;
                this.associatedRuleName_ = "";
                this.bitField0_ &= -5;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public ResolvedFunctionCall getDefaultInstanceForType() {
                return ResolvedFunctionCall.getDefaultInstance();
            }

            public ResolvedFunctionCall build() {
                ResolvedFunctionCall result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(result);
            }

            public ResolvedFunctionCall buildPartial() {
                ResolvedFunctionCall result = new ResolvedFunctionCall(null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((this.bitField0_ & ResolvedFunctionCall.PROPERTIES_FIELD_NUMBER) == ResolvedFunctionCall.PROPERTIES_FIELD_NUMBER) {
                    this.properties_ = Collections.unmodifiableList(this.properties_);
                    this.bitField0_ &= -2;
                }
                result.properties_ = this.properties_;
                if ((from_bitField0_ & ResolvedFunctionCall.RESULT_FIELD_NUMBER) == ResolvedFunctionCall.RESULT_FIELD_NUMBER) {
                    to_bitField0_ = 0 | ResolvedFunctionCall.PROPERTIES_FIELD_NUMBER;
                }
                result.result_ = this.result_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= ResolvedFunctionCall.RESULT_FIELD_NUMBER;
                }
                result.associatedRuleName_ = this.associatedRuleName_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            public Builder mergeFrom(ResolvedFunctionCall other) {
                if (other != ResolvedFunctionCall.getDefaultInstance()) {
                    if (!other.properties_.isEmpty()) {
                        if (this.properties_.isEmpty()) {
                            this.properties_ = other.properties_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePropertiesIsMutable();
                            this.properties_.addAll(other.properties_);
                        }
                    }
                    if (other.hasResult()) {
                        mergeResult(other.getResult());
                    }
                    if (other.hasAssociatedRuleName()) {
                        this.bitField0_ |= 4;
                        this.associatedRuleName_ = other.associatedRuleName_;
                    }
                    setUnknownFields(getUnknownFields().concat(other.unknownFields));
                }
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getPropertiesCount(); i += ResolvedFunctionCall.PROPERTIES_FIELD_NUMBER) {
                    if (!getProperties(i).isInitialized()) {
                        return false;
                    }
                }
                if (!hasResult() || getResult().isInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ResolvedFunctionCall parsedMessage = null;
                try {
                    parsedMessage = (ResolvedFunctionCall) ResolvedFunctionCall.PARSER.parsePartialFrom(input, extensionRegistry);
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ResolvedFunctionCall) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
            }

            private void ensurePropertiesIsMutable() {
                if ((this.bitField0_ & ResolvedFunctionCall.PROPERTIES_FIELD_NUMBER) != ResolvedFunctionCall.PROPERTIES_FIELD_NUMBER) {
                    this.properties_ = new ArrayList(this.properties_);
                    this.bitField0_ |= ResolvedFunctionCall.PROPERTIES_FIELD_NUMBER;
                }
            }

            public List<ResolvedProperty> getPropertiesList() {
                return Collections.unmodifiableList(this.properties_);
            }

            public int getPropertiesCount() {
                return this.properties_.size();
            }

            public ResolvedProperty getProperties(int index) {
                return (ResolvedProperty) this.properties_.get(index);
            }

            public Builder setProperties(int index, ResolvedProperty value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensurePropertiesIsMutable();
                this.properties_.set(index, value);
                return this;
            }

            public Builder setProperties(int index, Builder builderForValue) {
                ensurePropertiesIsMutable();
                this.properties_.set(index, builderForValue.build());
                return this;
            }

            public Builder addProperties(ResolvedProperty value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensurePropertiesIsMutable();
                this.properties_.add(value);
                return this;
            }

            public Builder addProperties(int index, ResolvedProperty value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensurePropertiesIsMutable();
                this.properties_.add(index, value);
                return this;
            }

            public Builder addProperties(Builder builderForValue) {
                ensurePropertiesIsMutable();
                this.properties_.add(builderForValue.build());
                return this;
            }

            public Builder addProperties(int index, Builder builderForValue) {
                ensurePropertiesIsMutable();
                this.properties_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllProperties(Iterable<? extends ResolvedProperty> values) {
                ensurePropertiesIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.properties_);
                return this;
            }

            public Builder clearProperties() {
                this.properties_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder removeProperties(int index) {
                ensurePropertiesIsMutable();
                this.properties_.remove(index);
                return this;
            }

            public boolean hasResult() {
                return (this.bitField0_ & ResolvedFunctionCall.RESULT_FIELD_NUMBER) == ResolvedFunctionCall.RESULT_FIELD_NUMBER;
            }

            public Value getResult() {
                return this.result_;
            }

            public Builder setResult(Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result_ = value;
                this.bitField0_ |= ResolvedFunctionCall.RESULT_FIELD_NUMBER;
                return this;
            }

            public Builder setResult(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builderForValue) {
                this.result_ = builderForValue.build();
                this.bitField0_ |= ResolvedFunctionCall.RESULT_FIELD_NUMBER;
                return this;
            }

            public Builder mergeResult(Value value) {
                if ((this.bitField0_ & ResolvedFunctionCall.RESULT_FIELD_NUMBER) != ResolvedFunctionCall.RESULT_FIELD_NUMBER || this.result_ == Value.getDefaultInstance()) {
                    this.result_ = value;
                } else {
                    this.result_ = Value.newBuilder(this.result_).mergeFrom(value).buildPartial();
                }
                this.bitField0_ |= ResolvedFunctionCall.RESULT_FIELD_NUMBER;
                return this;
            }

            public Builder clearResult() {
                this.result_ = Value.getDefaultInstance();
                this.bitField0_ &= -3;
                return this;
            }

            public boolean hasAssociatedRuleName() {
                return (this.bitField0_ & 4) == 4;
            }

            public String getAssociatedRuleName() {
                ByteString ref = this.associatedRuleName_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                ByteString bs = ref;
                String s = bs.toStringUtf8();
                if (!bs.isValidUtf8()) {
                    return s;
                }
                this.associatedRuleName_ = s;
                return s;
            }

            public ByteString getAssociatedRuleNameBytes() {
                Object ref = this.associatedRuleName_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.associatedRuleName_ = b;
                return b;
            }

            public Builder setAssociatedRuleName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.associatedRuleName_ = value;
                return this;
            }

            public Builder clearAssociatedRuleName() {
                this.bitField0_ &= -5;
                this.associatedRuleName_ = ResolvedFunctionCall.getDefaultInstance().getAssociatedRuleName();
                return this;
            }

            public Builder setAssociatedRuleNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.associatedRuleName_ = value;
                return this;
            }
        }

        private ResolvedFunctionCall(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ResolvedFunctionCall(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static ResolvedFunctionCall getDefaultInstance() {
            return defaultInstance;
        }

        public ResolvedFunctionCall getDefaultInstanceForType() {
            return defaultInstance;
        }

        private ResolvedFunctionCall(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            OutputStream unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            boolean done = false;
            while (!done) {
                try {
                    int tag = input.readTag();
                    switch (tag) {
                        case DragSortController.ON_DOWN /*0*/:
                            done = true;
                            break;
                        case MutableTypeSystem.Value.ESCAPING_FIELD_NUMBER /*10*/:
                            if ((mutable_bitField0_ & PROPERTIES_FIELD_NUMBER) != PROPERTIES_FIELD_NUMBER) {
                                this.properties_ = new ArrayList();
                                mutable_bitField0_ |= PROPERTIES_FIELD_NUMBER;
                            }
                            this.properties_.add(input.readMessage(ResolvedProperty.PARSER, extensionRegistry));
                            break;
                        case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                            com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder subBuilder = null;
                            if ((this.bitField0_ & PROPERTIES_FIELD_NUMBER) == PROPERTIES_FIELD_NUMBER) {
                                subBuilder = this.result_.toBuilder();
                            }
                            this.result_ = (Value) input.readMessage(Value.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.result_);
                                this.result_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= PROPERTIES_FIELD_NUMBER;
                            break;
                        case 26:
                            ByteString bs = input.readBytes();
                            this.bitField0_ |= RESULT_FIELD_NUMBER;
                            this.associatedRuleName_ = bs;
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
                                done = true;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if ((mutable_bitField0_ & PROPERTIES_FIELD_NUMBER) == PROPERTIES_FIELD_NUMBER) {
                        this.properties_ = Collections.unmodifiableList(this.properties_);
                    }
                    try {
                        unknownFieldsCodedOutput.flush();
                    } catch (IOException e3) {
                        makeExtensionsImmutable();
                    } finally {
                        this.unknownFields = unknownFieldsOutput.toByteString();
                    }
                    makeExtensionsImmutable();
                }
            }
            if ((mutable_bitField0_ & PROPERTIES_FIELD_NUMBER) == PROPERTIES_FIELD_NUMBER) {
                this.properties_ = Collections.unmodifiableList(this.properties_);
            }
            try {
                unknownFieldsCodedOutput.flush();
            } catch (IOException e4) {
            } finally {
                this.unknownFields = unknownFieldsOutput.toByteString();
            }
            makeExtensionsImmutable();
        }

        static {
            PARSER = new C08381();
            mutableDefault = null;
            defaultInstance = new ResolvedFunctionCall(true);
            defaultInstance.initFields();
        }

        public Parser<ResolvedFunctionCall> getParserForType() {
            return PARSER;
        }

        public List<ResolvedProperty> getPropertiesList() {
            return this.properties_;
        }

        public List<? extends ResolvedPropertyOrBuilder> getPropertiesOrBuilderList() {
            return this.properties_;
        }

        public int getPropertiesCount() {
            return this.properties_.size();
        }

        public ResolvedProperty getProperties(int index) {
            return (ResolvedProperty) this.properties_.get(index);
        }

        public ResolvedPropertyOrBuilder getPropertiesOrBuilder(int index) {
            return (ResolvedPropertyOrBuilder) this.properties_.get(index);
        }

        public boolean hasResult() {
            return (this.bitField0_ & PROPERTIES_FIELD_NUMBER) == PROPERTIES_FIELD_NUMBER;
        }

        public Value getResult() {
            return this.result_;
        }

        public boolean hasAssociatedRuleName() {
            return (this.bitField0_ & RESULT_FIELD_NUMBER) == RESULT_FIELD_NUMBER;
        }

        public String getAssociatedRuleName() {
            ByteString ref = this.associatedRuleName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.associatedRuleName_ = s;
            }
            return s;
        }

        public ByteString getAssociatedRuleNameBytes() {
            Object ref = this.associatedRuleName_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.associatedRuleName_ = b;
            return b;
        }

        private void initFields() {
            this.properties_ = Collections.emptyList();
            this.result_ = Value.getDefaultInstance();
            this.associatedRuleName_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == -1) {
                int i = 0;
                while (i < getPropertiesCount()) {
                    if (getProperties(i).isInitialized()) {
                        i += PROPERTIES_FIELD_NUMBER;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (!hasResult() || getResult().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (isInitialized == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.properties_.size(); i += PROPERTIES_FIELD_NUMBER) {
                output.writeMessage(PROPERTIES_FIELD_NUMBER, (MessageLite) this.properties_.get(i));
            }
            if ((this.bitField0_ & PROPERTIES_FIELD_NUMBER) == PROPERTIES_FIELD_NUMBER) {
                output.writeMessage(RESULT_FIELD_NUMBER, this.result_);
            }
            if ((this.bitField0_ & RESULT_FIELD_NUMBER) == RESULT_FIELD_NUMBER) {
                output.writeBytes(ASSOCIATED_RULE_NAME_FIELD_NUMBER, getAssociatedRuleNameBytes());
            }
            output.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (int i = 0; i < this.properties_.size(); i += PROPERTIES_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(PROPERTIES_FIELD_NUMBER, (MessageLite) this.properties_.get(i));
            }
            if ((this.bitField0_ & PROPERTIES_FIELD_NUMBER) == PROPERTIES_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(RESULT_FIELD_NUMBER, this.result_);
            }
            if ((this.bitField0_ & RESULT_FIELD_NUMBER) == RESULT_FIELD_NUMBER) {
                size += CodedOutputStream.computeBytesSize(ASSOCIATED_RULE_NAME_FIELD_NUMBER, getAssociatedRuleNameBytes());
            }
            size += this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ResolvedFunctionCall)) {
                return super.equals(obj);
            }
            ResolvedFunctionCall other = (ResolvedFunctionCall) obj;
            boolean result = true && getPropertiesList().equals(other.getPropertiesList());
            if (result && hasResult() == other.hasResult()) {
                result = true;
            } else {
                result = false;
            }
            if (hasResult()) {
                if (result && getResult().equals(other.getResult())) {
                    result = true;
                } else {
                    result = false;
                }
            }
            if (result && hasAssociatedRuleName() == other.hasAssociatedRuleName()) {
                result = true;
            } else {
                result = false;
            }
            if (hasAssociatedRuleName()) {
                if (result && getAssociatedRuleName().equals(other.getAssociatedRuleName())) {
                    result = true;
                } else {
                    result = false;
                }
            }
            return result;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = ResolvedFunctionCall.class.hashCode() + 779;
            if (getPropertiesCount() > 0) {
                hash = (((hash * 37) + PROPERTIES_FIELD_NUMBER) * 53) + getPropertiesList().hashCode();
            }
            if (hasResult()) {
                hash = (((hash * 37) + RESULT_FIELD_NUMBER) * 53) + getResult().hashCode();
            }
            if (hasAssociatedRuleName()) {
                hash = (((hash * 37) + ASSOCIATED_RULE_NAME_FIELD_NUMBER) * 53) + getAssociatedRuleName().hashCode();
            }
            hash = (hash * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$ResolvedFunctionCall");
            }
            return mutableDefault;
        }

        public static ResolvedFunctionCall parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ResolvedFunctionCall) PARSER.parseFrom(data);
        }

        public static ResolvedFunctionCall parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ResolvedFunctionCall) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResolvedFunctionCall parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ResolvedFunctionCall) PARSER.parseFrom(data);
        }

        public static ResolvedFunctionCall parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ResolvedFunctionCall) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResolvedFunctionCall parseFrom(InputStream input) throws IOException {
            return (ResolvedFunctionCall) PARSER.parseFrom(input);
        }

        public static ResolvedFunctionCall parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResolvedFunctionCall) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ResolvedFunctionCall parseDelimitedFrom(InputStream input) throws IOException {
            return (ResolvedFunctionCall) PARSER.parseDelimitedFrom(input);
        }

        public static ResolvedFunctionCall parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResolvedFunctionCall) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ResolvedFunctionCall parseFrom(CodedInputStream input) throws IOException {
            return (ResolvedFunctionCall) PARSER.parseFrom(input);
        }

        public static ResolvedFunctionCall parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResolvedFunctionCall) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ResolvedFunctionCall prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class ResolvedProperty extends GeneratedMessageLite implements ResolvedPropertyOrBuilder {
        public static final int KEY_FIELD_NUMBER = 1;
        public static Parser<ResolvedProperty> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 2;
        private static final ResolvedProperty defaultInstance;
        private static volatile MutableMessageLite mutableDefault;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object key_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;
        private Value value_;

        /* renamed from: com.google.analytics.containertag.proto.Debug.ResolvedProperty.1 */
        static class C08391 extends AbstractParser<ResolvedProperty> {
            C08391() {
            }

            public ResolvedProperty parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ResolvedProperty(extensionRegistry, null);
            }
        }

        public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<ResolvedProperty, Builder> implements ResolvedPropertyOrBuilder {
            private int bitField0_;
            private Object key_;
            private Value value_;

            private Builder() {
                this.key_ = "";
                this.value_ = Value.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.key_ = "";
                this.bitField0_ &= -2;
                this.value_ = Value.getDefaultInstance();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public ResolvedProperty getDefaultInstanceForType() {
                return ResolvedProperty.getDefaultInstance();
            }

            public ResolvedProperty build() {
                ResolvedProperty result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(result);
            }

            public ResolvedProperty buildPartial() {
                ResolvedProperty result = new ResolvedProperty(null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & ResolvedProperty.KEY_FIELD_NUMBER) == ResolvedProperty.KEY_FIELD_NUMBER) {
                    to_bitField0_ = 0 | ResolvedProperty.KEY_FIELD_NUMBER;
                }
                result.key_ = this.key_;
                if ((from_bitField0_ & ResolvedProperty.VALUE_FIELD_NUMBER) == ResolvedProperty.VALUE_FIELD_NUMBER) {
                    to_bitField0_ |= ResolvedProperty.VALUE_FIELD_NUMBER;
                }
                result.value_ = this.value_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            public Builder mergeFrom(ResolvedProperty other) {
                if (other != ResolvedProperty.getDefaultInstance()) {
                    if (other.hasKey()) {
                        this.bitField0_ |= ResolvedProperty.KEY_FIELD_NUMBER;
                        this.key_ = other.key_;
                    }
                    if (other.hasValue()) {
                        mergeValue(other.getValue());
                    }
                    setUnknownFields(getUnknownFields().concat(other.unknownFields));
                }
                return this;
            }

            public final boolean isInitialized() {
                if (!hasValue() || getValue().isInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ResolvedProperty parsedMessage = null;
                try {
                    parsedMessage = (ResolvedProperty) ResolvedProperty.PARSER.parsePartialFrom(input, extensionRegistry);
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ResolvedProperty) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
            }

            public boolean hasKey() {
                return (this.bitField0_ & ResolvedProperty.KEY_FIELD_NUMBER) == ResolvedProperty.KEY_FIELD_NUMBER;
            }

            public String getKey() {
                ByteString ref = this.key_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                ByteString bs = ref;
                String s = bs.toStringUtf8();
                if (!bs.isValidUtf8()) {
                    return s;
                }
                this.key_ = s;
                return s;
            }

            public ByteString getKeyBytes() {
                Object ref = this.key_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.key_ = b;
                return b;
            }

            public Builder setKey(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= ResolvedProperty.KEY_FIELD_NUMBER;
                this.key_ = value;
                return this;
            }

            public Builder clearKey() {
                this.bitField0_ &= -2;
                this.key_ = ResolvedProperty.getDefaultInstance().getKey();
                return this;
            }

            public Builder setKeyBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= ResolvedProperty.KEY_FIELD_NUMBER;
                this.key_ = value;
                return this;
            }

            public boolean hasValue() {
                return (this.bitField0_ & ResolvedProperty.VALUE_FIELD_NUMBER) == ResolvedProperty.VALUE_FIELD_NUMBER;
            }

            public Value getValue() {
                return this.value_;
            }

            public Builder setValue(Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.value_ = value;
                this.bitField0_ |= ResolvedProperty.VALUE_FIELD_NUMBER;
                return this;
            }

            public Builder setValue(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builderForValue) {
                this.value_ = builderForValue.build();
                this.bitField0_ |= ResolvedProperty.VALUE_FIELD_NUMBER;
                return this;
            }

            public Builder mergeValue(Value value) {
                if ((this.bitField0_ & ResolvedProperty.VALUE_FIELD_NUMBER) != ResolvedProperty.VALUE_FIELD_NUMBER || this.value_ == Value.getDefaultInstance()) {
                    this.value_ = value;
                } else {
                    this.value_ = Value.newBuilder(this.value_).mergeFrom(value).buildPartial();
                }
                this.bitField0_ |= ResolvedProperty.VALUE_FIELD_NUMBER;
                return this;
            }

            public Builder clearValue() {
                this.value_ = Value.getDefaultInstance();
                this.bitField0_ &= -3;
                return this;
            }
        }

        private ResolvedProperty(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ResolvedProperty(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static ResolvedProperty getDefaultInstance() {
            return defaultInstance;
        }

        public ResolvedProperty getDefaultInstanceForType() {
            return defaultInstance;
        }

        private ResolvedProperty(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            OutputStream unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            boolean done = false;
            while (!done) {
                try {
                    int tag = input.readTag();
                    switch (tag) {
                        case DragSortController.ON_DOWN /*0*/:
                            done = true;
                            break;
                        case MutableTypeSystem.Value.ESCAPING_FIELD_NUMBER /*10*/:
                            ByteString bs = input.readBytes();
                            this.bitField0_ |= KEY_FIELD_NUMBER;
                            this.key_ = bs;
                            break;
                        case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                            com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder subBuilder = null;
                            if ((this.bitField0_ & VALUE_FIELD_NUMBER) == VALUE_FIELD_NUMBER) {
                                subBuilder = this.value_.toBuilder();
                            }
                            this.value_ = (Value) input.readMessage(Value.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.value_);
                                this.value_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= VALUE_FIELD_NUMBER;
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
                                done = true;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    try {
                        unknownFieldsCodedOutput.flush();
                    } catch (IOException e3) {
                        makeExtensionsImmutable();
                    } finally {
                        this.unknownFields = unknownFieldsOutput.toByteString();
                    }
                    makeExtensionsImmutable();
                }
            }
            try {
                unknownFieldsCodedOutput.flush();
            } catch (IOException e4) {
            } finally {
                this.unknownFields = unknownFieldsOutput.toByteString();
            }
            makeExtensionsImmutable();
        }

        static {
            PARSER = new C08391();
            mutableDefault = null;
            defaultInstance = new ResolvedProperty(true);
            defaultInstance.initFields();
        }

        public Parser<ResolvedProperty> getParserForType() {
            return PARSER;
        }

        public boolean hasKey() {
            return (this.bitField0_ & KEY_FIELD_NUMBER) == KEY_FIELD_NUMBER;
        }

        public String getKey() {
            ByteString ref = this.key_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.key_ = s;
            }
            return s;
        }

        public ByteString getKeyBytes() {
            Object ref = this.key_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.key_ = b;
            return b;
        }

        public boolean hasValue() {
            return (this.bitField0_ & VALUE_FIELD_NUMBER) == VALUE_FIELD_NUMBER;
        }

        public Value getValue() {
            return this.value_;
        }

        private void initFields() {
            this.key_ = "";
            this.value_ = Value.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                if (isInitialized == (byte) 1) {
                    return true;
                }
                return false;
            } else if (!hasValue() || getValue().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & KEY_FIELD_NUMBER) == KEY_FIELD_NUMBER) {
                output.writeBytes(KEY_FIELD_NUMBER, getKeyBytes());
            }
            if ((this.bitField0_ & VALUE_FIELD_NUMBER) == VALUE_FIELD_NUMBER) {
                output.writeMessage(VALUE_FIELD_NUMBER, this.value_);
            }
            output.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & KEY_FIELD_NUMBER) == KEY_FIELD_NUMBER) {
                size = 0 + CodedOutputStream.computeBytesSize(KEY_FIELD_NUMBER, getKeyBytes());
            }
            if ((this.bitField0_ & VALUE_FIELD_NUMBER) == VALUE_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(VALUE_FIELD_NUMBER, this.value_);
            }
            size += this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ResolvedProperty)) {
                return super.equals(obj);
            }
            ResolvedProperty other = (ResolvedProperty) obj;
            boolean result = true && hasKey() == other.hasKey();
            if (hasKey()) {
                result = result && getKey().equals(other.getKey());
            }
            if (result && hasValue() == other.hasValue()) {
                result = true;
            } else {
                result = false;
            }
            if (hasValue()) {
                if (result && getValue().equals(other.getValue())) {
                    result = true;
                } else {
                    result = false;
                }
            }
            return result;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = ResolvedProperty.class.hashCode() + 779;
            if (hasKey()) {
                hash = (((hash * 37) + KEY_FIELD_NUMBER) * 53) + getKey().hashCode();
            }
            if (hasValue()) {
                hash = (((hash * 37) + VALUE_FIELD_NUMBER) * 53) + getValue().hashCode();
            }
            hash = (hash * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$ResolvedProperty");
            }
            return mutableDefault;
        }

        public static ResolvedProperty parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ResolvedProperty) PARSER.parseFrom(data);
        }

        public static ResolvedProperty parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ResolvedProperty) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResolvedProperty parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ResolvedProperty) PARSER.parseFrom(data);
        }

        public static ResolvedProperty parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ResolvedProperty) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResolvedProperty parseFrom(InputStream input) throws IOException {
            return (ResolvedProperty) PARSER.parseFrom(input);
        }

        public static ResolvedProperty parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResolvedProperty) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ResolvedProperty parseDelimitedFrom(InputStream input) throws IOException {
            return (ResolvedProperty) PARSER.parseDelimitedFrom(input);
        }

        public static ResolvedProperty parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResolvedProperty) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ResolvedProperty parseFrom(CodedInputStream input) throws IOException {
            return (ResolvedProperty) PARSER.parseFrom(input);
        }

        public static ResolvedProperty parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResolvedProperty) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ResolvedProperty prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class ResolvedRule extends GeneratedMessageLite implements ResolvedRuleOrBuilder {
        public static final int ADD_MACROS_FIELD_NUMBER = 5;
        public static final int ADD_TAGS_FIELD_NUMBER = 3;
        public static final int NEGATIVE_PREDICATES_FIELD_NUMBER = 2;
        public static Parser<ResolvedRule> PARSER = null;
        public static final int POSITIVE_PREDICATES_FIELD_NUMBER = 1;
        public static final int REMOVE_MACROS_FIELD_NUMBER = 6;
        public static final int REMOVE_TAGS_FIELD_NUMBER = 4;
        public static final int RESULT_FIELD_NUMBER = 7;
        private static final ResolvedRule defaultInstance;
        private static volatile MutableMessageLite mutableDefault;
        private static final long serialVersionUID = 0;
        private List<ResolvedFunctionCall> addMacros_;
        private List<ResolvedFunctionCall> addTags_;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<ResolvedFunctionCall> negativePredicates_;
        private List<ResolvedFunctionCall> positivePredicates_;
        private List<ResolvedFunctionCall> removeMacros_;
        private List<ResolvedFunctionCall> removeTags_;
        private Value result_;
        private final ByteString unknownFields;

        /* renamed from: com.google.analytics.containertag.proto.Debug.ResolvedRule.1 */
        static class C08401 extends AbstractParser<ResolvedRule> {
            C08401() {
            }

            public ResolvedRule parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ResolvedRule(extensionRegistry, null);
            }
        }

        public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<ResolvedRule, Builder> implements ResolvedRuleOrBuilder {
            private List<ResolvedFunctionCall> addMacros_;
            private List<ResolvedFunctionCall> addTags_;
            private int bitField0_;
            private List<ResolvedFunctionCall> negativePredicates_;
            private List<ResolvedFunctionCall> positivePredicates_;
            private List<ResolvedFunctionCall> removeMacros_;
            private List<ResolvedFunctionCall> removeTags_;
            private Value result_;

            private Builder() {
                this.positivePredicates_ = Collections.emptyList();
                this.negativePredicates_ = Collections.emptyList();
                this.addTags_ = Collections.emptyList();
                this.removeTags_ = Collections.emptyList();
                this.addMacros_ = Collections.emptyList();
                this.removeMacros_ = Collections.emptyList();
                this.result_ = Value.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.positivePredicates_ = Collections.emptyList();
                this.bitField0_ &= -2;
                this.negativePredicates_ = Collections.emptyList();
                this.bitField0_ &= -3;
                this.addTags_ = Collections.emptyList();
                this.bitField0_ &= -5;
                this.removeTags_ = Collections.emptyList();
                this.bitField0_ &= -9;
                this.addMacros_ = Collections.emptyList();
                this.bitField0_ &= -17;
                this.removeMacros_ = Collections.emptyList();
                this.bitField0_ &= -33;
                this.result_ = Value.getDefaultInstance();
                this.bitField0_ &= -65;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public ResolvedRule getDefaultInstanceForType() {
                return ResolvedRule.getDefaultInstance();
            }

            public ResolvedRule build() {
                ResolvedRule result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(result);
            }

            public ResolvedRule buildPartial() {
                ResolvedRule result = new ResolvedRule(null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((this.bitField0_ & ResolvedRule.POSITIVE_PREDICATES_FIELD_NUMBER) == ResolvedRule.POSITIVE_PREDICATES_FIELD_NUMBER) {
                    this.positivePredicates_ = Collections.unmodifiableList(this.positivePredicates_);
                    this.bitField0_ &= -2;
                }
                result.positivePredicates_ = this.positivePredicates_;
                if ((this.bitField0_ & ResolvedRule.NEGATIVE_PREDICATES_FIELD_NUMBER) == ResolvedRule.NEGATIVE_PREDICATES_FIELD_NUMBER) {
                    this.negativePredicates_ = Collections.unmodifiableList(this.negativePredicates_);
                    this.bitField0_ &= -3;
                }
                result.negativePredicates_ = this.negativePredicates_;
                if ((this.bitField0_ & ResolvedRule.REMOVE_TAGS_FIELD_NUMBER) == ResolvedRule.REMOVE_TAGS_FIELD_NUMBER) {
                    this.addTags_ = Collections.unmodifiableList(this.addTags_);
                    this.bitField0_ &= -5;
                }
                result.addTags_ = this.addTags_;
                if ((this.bitField0_ & 8) == 8) {
                    this.removeTags_ = Collections.unmodifiableList(this.removeTags_);
                    this.bitField0_ &= -9;
                }
                result.removeTags_ = this.removeTags_;
                if ((this.bitField0_ & 16) == 16) {
                    this.addMacros_ = Collections.unmodifiableList(this.addMacros_);
                    this.bitField0_ &= -17;
                }
                result.addMacros_ = this.addMacros_;
                if ((this.bitField0_ & 32) == 32) {
                    this.removeMacros_ = Collections.unmodifiableList(this.removeMacros_);
                    this.bitField0_ &= -33;
                }
                result.removeMacros_ = this.removeMacros_;
                if ((from_bitField0_ & 64) == 64) {
                    to_bitField0_ = 0 | ResolvedRule.POSITIVE_PREDICATES_FIELD_NUMBER;
                }
                result.result_ = this.result_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            public Builder mergeFrom(ResolvedRule other) {
                if (other != ResolvedRule.getDefaultInstance()) {
                    if (!other.positivePredicates_.isEmpty()) {
                        if (this.positivePredicates_.isEmpty()) {
                            this.positivePredicates_ = other.positivePredicates_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePositivePredicatesIsMutable();
                            this.positivePredicates_.addAll(other.positivePredicates_);
                        }
                    }
                    if (!other.negativePredicates_.isEmpty()) {
                        if (this.negativePredicates_.isEmpty()) {
                            this.negativePredicates_ = other.negativePredicates_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureNegativePredicatesIsMutable();
                            this.negativePredicates_.addAll(other.negativePredicates_);
                        }
                    }
                    if (!other.addTags_.isEmpty()) {
                        if (this.addTags_.isEmpty()) {
                            this.addTags_ = other.addTags_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureAddTagsIsMutable();
                            this.addTags_.addAll(other.addTags_);
                        }
                    }
                    if (!other.removeTags_.isEmpty()) {
                        if (this.removeTags_.isEmpty()) {
                            this.removeTags_ = other.removeTags_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureRemoveTagsIsMutable();
                            this.removeTags_.addAll(other.removeTags_);
                        }
                    }
                    if (!other.addMacros_.isEmpty()) {
                        if (this.addMacros_.isEmpty()) {
                            this.addMacros_ = other.addMacros_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureAddMacrosIsMutable();
                            this.addMacros_.addAll(other.addMacros_);
                        }
                    }
                    if (!other.removeMacros_.isEmpty()) {
                        if (this.removeMacros_.isEmpty()) {
                            this.removeMacros_ = other.removeMacros_;
                            this.bitField0_ &= -33;
                        } else {
                            ensureRemoveMacrosIsMutable();
                            this.removeMacros_.addAll(other.removeMacros_);
                        }
                    }
                    if (other.hasResult()) {
                        mergeResult(other.getResult());
                    }
                    setUnknownFields(getUnknownFields().concat(other.unknownFields));
                }
                return this;
            }

            public final boolean isInitialized() {
                int i;
                for (i = 0; i < getPositivePredicatesCount(); i += ResolvedRule.POSITIVE_PREDICATES_FIELD_NUMBER) {
                    if (!getPositivePredicates(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getNegativePredicatesCount(); i += ResolvedRule.POSITIVE_PREDICATES_FIELD_NUMBER) {
                    if (!getNegativePredicates(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getAddTagsCount(); i += ResolvedRule.POSITIVE_PREDICATES_FIELD_NUMBER) {
                    if (!getAddTags(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getRemoveTagsCount(); i += ResolvedRule.POSITIVE_PREDICATES_FIELD_NUMBER) {
                    if (!getRemoveTags(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getAddMacrosCount(); i += ResolvedRule.POSITIVE_PREDICATES_FIELD_NUMBER) {
                    if (!getAddMacros(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getRemoveMacrosCount(); i += ResolvedRule.POSITIVE_PREDICATES_FIELD_NUMBER) {
                    if (!getRemoveMacros(i).isInitialized()) {
                        return false;
                    }
                }
                if (!hasResult() || getResult().isInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ResolvedRule parsedMessage = null;
                try {
                    parsedMessage = (ResolvedRule) ResolvedRule.PARSER.parsePartialFrom(input, extensionRegistry);
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ResolvedRule) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
            }

            private void ensurePositivePredicatesIsMutable() {
                if ((this.bitField0_ & ResolvedRule.POSITIVE_PREDICATES_FIELD_NUMBER) != ResolvedRule.POSITIVE_PREDICATES_FIELD_NUMBER) {
                    this.positivePredicates_ = new ArrayList(this.positivePredicates_);
                    this.bitField0_ |= ResolvedRule.POSITIVE_PREDICATES_FIELD_NUMBER;
                }
            }

            public List<ResolvedFunctionCall> getPositivePredicatesList() {
                return Collections.unmodifiableList(this.positivePredicates_);
            }

            public int getPositivePredicatesCount() {
                return this.positivePredicates_.size();
            }

            public ResolvedFunctionCall getPositivePredicates(int index) {
                return (ResolvedFunctionCall) this.positivePredicates_.get(index);
            }

            public Builder setPositivePredicates(int index, ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensurePositivePredicatesIsMutable();
                this.positivePredicates_.set(index, value);
                return this;
            }

            public Builder setPositivePredicates(int index, Builder builderForValue) {
                ensurePositivePredicatesIsMutable();
                this.positivePredicates_.set(index, builderForValue.build());
                return this;
            }

            public Builder addPositivePredicates(ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensurePositivePredicatesIsMutable();
                this.positivePredicates_.add(value);
                return this;
            }

            public Builder addPositivePredicates(int index, ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensurePositivePredicatesIsMutable();
                this.positivePredicates_.add(index, value);
                return this;
            }

            public Builder addPositivePredicates(Builder builderForValue) {
                ensurePositivePredicatesIsMutable();
                this.positivePredicates_.add(builderForValue.build());
                return this;
            }

            public Builder addPositivePredicates(int index, Builder builderForValue) {
                ensurePositivePredicatesIsMutable();
                this.positivePredicates_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllPositivePredicates(Iterable<? extends ResolvedFunctionCall> values) {
                ensurePositivePredicatesIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.positivePredicates_);
                return this;
            }

            public Builder clearPositivePredicates() {
                this.positivePredicates_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder removePositivePredicates(int index) {
                ensurePositivePredicatesIsMutable();
                this.positivePredicates_.remove(index);
                return this;
            }

            private void ensureNegativePredicatesIsMutable() {
                if ((this.bitField0_ & ResolvedRule.NEGATIVE_PREDICATES_FIELD_NUMBER) != ResolvedRule.NEGATIVE_PREDICATES_FIELD_NUMBER) {
                    this.negativePredicates_ = new ArrayList(this.negativePredicates_);
                    this.bitField0_ |= ResolvedRule.NEGATIVE_PREDICATES_FIELD_NUMBER;
                }
            }

            public List<ResolvedFunctionCall> getNegativePredicatesList() {
                return Collections.unmodifiableList(this.negativePredicates_);
            }

            public int getNegativePredicatesCount() {
                return this.negativePredicates_.size();
            }

            public ResolvedFunctionCall getNegativePredicates(int index) {
                return (ResolvedFunctionCall) this.negativePredicates_.get(index);
            }

            public Builder setNegativePredicates(int index, ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureNegativePredicatesIsMutable();
                this.negativePredicates_.set(index, value);
                return this;
            }

            public Builder setNegativePredicates(int index, Builder builderForValue) {
                ensureNegativePredicatesIsMutable();
                this.negativePredicates_.set(index, builderForValue.build());
                return this;
            }

            public Builder addNegativePredicates(ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureNegativePredicatesIsMutable();
                this.negativePredicates_.add(value);
                return this;
            }

            public Builder addNegativePredicates(int index, ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureNegativePredicatesIsMutable();
                this.negativePredicates_.add(index, value);
                return this;
            }

            public Builder addNegativePredicates(Builder builderForValue) {
                ensureNegativePredicatesIsMutable();
                this.negativePredicates_.add(builderForValue.build());
                return this;
            }

            public Builder addNegativePredicates(int index, Builder builderForValue) {
                ensureNegativePredicatesIsMutable();
                this.negativePredicates_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllNegativePredicates(Iterable<? extends ResolvedFunctionCall> values) {
                ensureNegativePredicatesIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.negativePredicates_);
                return this;
            }

            public Builder clearNegativePredicates() {
                this.negativePredicates_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder removeNegativePredicates(int index) {
                ensureNegativePredicatesIsMutable();
                this.negativePredicates_.remove(index);
                return this;
            }

            private void ensureAddTagsIsMutable() {
                if ((this.bitField0_ & ResolvedRule.REMOVE_TAGS_FIELD_NUMBER) != ResolvedRule.REMOVE_TAGS_FIELD_NUMBER) {
                    this.addTags_ = new ArrayList(this.addTags_);
                    this.bitField0_ |= ResolvedRule.REMOVE_TAGS_FIELD_NUMBER;
                }
            }

            public List<ResolvedFunctionCall> getAddTagsList() {
                return Collections.unmodifiableList(this.addTags_);
            }

            public int getAddTagsCount() {
                return this.addTags_.size();
            }

            public ResolvedFunctionCall getAddTags(int index) {
                return (ResolvedFunctionCall) this.addTags_.get(index);
            }

            public Builder setAddTags(int index, ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureAddTagsIsMutable();
                this.addTags_.set(index, value);
                return this;
            }

            public Builder setAddTags(int index, Builder builderForValue) {
                ensureAddTagsIsMutable();
                this.addTags_.set(index, builderForValue.build());
                return this;
            }

            public Builder addAddTags(ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureAddTagsIsMutable();
                this.addTags_.add(value);
                return this;
            }

            public Builder addAddTags(int index, ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureAddTagsIsMutable();
                this.addTags_.add(index, value);
                return this;
            }

            public Builder addAddTags(Builder builderForValue) {
                ensureAddTagsIsMutable();
                this.addTags_.add(builderForValue.build());
                return this;
            }

            public Builder addAddTags(int index, Builder builderForValue) {
                ensureAddTagsIsMutable();
                this.addTags_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllAddTags(Iterable<? extends ResolvedFunctionCall> values) {
                ensureAddTagsIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.addTags_);
                return this;
            }

            public Builder clearAddTags() {
                this.addTags_ = Collections.emptyList();
                this.bitField0_ &= -5;
                return this;
            }

            public Builder removeAddTags(int index) {
                ensureAddTagsIsMutable();
                this.addTags_.remove(index);
                return this;
            }

            private void ensureRemoveTagsIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.removeTags_ = new ArrayList(this.removeTags_);
                    this.bitField0_ |= 8;
                }
            }

            public List<ResolvedFunctionCall> getRemoveTagsList() {
                return Collections.unmodifiableList(this.removeTags_);
            }

            public int getRemoveTagsCount() {
                return this.removeTags_.size();
            }

            public ResolvedFunctionCall getRemoveTags(int index) {
                return (ResolvedFunctionCall) this.removeTags_.get(index);
            }

            public Builder setRemoveTags(int index, ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureRemoveTagsIsMutable();
                this.removeTags_.set(index, value);
                return this;
            }

            public Builder setRemoveTags(int index, Builder builderForValue) {
                ensureRemoveTagsIsMutable();
                this.removeTags_.set(index, builderForValue.build());
                return this;
            }

            public Builder addRemoveTags(ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureRemoveTagsIsMutable();
                this.removeTags_.add(value);
                return this;
            }

            public Builder addRemoveTags(int index, ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureRemoveTagsIsMutable();
                this.removeTags_.add(index, value);
                return this;
            }

            public Builder addRemoveTags(Builder builderForValue) {
                ensureRemoveTagsIsMutable();
                this.removeTags_.add(builderForValue.build());
                return this;
            }

            public Builder addRemoveTags(int index, Builder builderForValue) {
                ensureRemoveTagsIsMutable();
                this.removeTags_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllRemoveTags(Iterable<? extends ResolvedFunctionCall> values) {
                ensureRemoveTagsIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.removeTags_);
                return this;
            }

            public Builder clearRemoveTags() {
                this.removeTags_ = Collections.emptyList();
                this.bitField0_ &= -9;
                return this;
            }

            public Builder removeRemoveTags(int index) {
                ensureRemoveTagsIsMutable();
                this.removeTags_.remove(index);
                return this;
            }

            private void ensureAddMacrosIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.addMacros_ = new ArrayList(this.addMacros_);
                    this.bitField0_ |= 16;
                }
            }

            public List<ResolvedFunctionCall> getAddMacrosList() {
                return Collections.unmodifiableList(this.addMacros_);
            }

            public int getAddMacrosCount() {
                return this.addMacros_.size();
            }

            public ResolvedFunctionCall getAddMacros(int index) {
                return (ResolvedFunctionCall) this.addMacros_.get(index);
            }

            public Builder setAddMacros(int index, ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureAddMacrosIsMutable();
                this.addMacros_.set(index, value);
                return this;
            }

            public Builder setAddMacros(int index, Builder builderForValue) {
                ensureAddMacrosIsMutable();
                this.addMacros_.set(index, builderForValue.build());
                return this;
            }

            public Builder addAddMacros(ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureAddMacrosIsMutable();
                this.addMacros_.add(value);
                return this;
            }

            public Builder addAddMacros(int index, ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureAddMacrosIsMutable();
                this.addMacros_.add(index, value);
                return this;
            }

            public Builder addAddMacros(Builder builderForValue) {
                ensureAddMacrosIsMutable();
                this.addMacros_.add(builderForValue.build());
                return this;
            }

            public Builder addAddMacros(int index, Builder builderForValue) {
                ensureAddMacrosIsMutable();
                this.addMacros_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllAddMacros(Iterable<? extends ResolvedFunctionCall> values) {
                ensureAddMacrosIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.addMacros_);
                return this;
            }

            public Builder clearAddMacros() {
                this.addMacros_ = Collections.emptyList();
                this.bitField0_ &= -17;
                return this;
            }

            public Builder removeAddMacros(int index) {
                ensureAddMacrosIsMutable();
                this.addMacros_.remove(index);
                return this;
            }

            private void ensureRemoveMacrosIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.removeMacros_ = new ArrayList(this.removeMacros_);
                    this.bitField0_ |= 32;
                }
            }

            public List<ResolvedFunctionCall> getRemoveMacrosList() {
                return Collections.unmodifiableList(this.removeMacros_);
            }

            public int getRemoveMacrosCount() {
                return this.removeMacros_.size();
            }

            public ResolvedFunctionCall getRemoveMacros(int index) {
                return (ResolvedFunctionCall) this.removeMacros_.get(index);
            }

            public Builder setRemoveMacros(int index, ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureRemoveMacrosIsMutable();
                this.removeMacros_.set(index, value);
                return this;
            }

            public Builder setRemoveMacros(int index, Builder builderForValue) {
                ensureRemoveMacrosIsMutable();
                this.removeMacros_.set(index, builderForValue.build());
                return this;
            }

            public Builder addRemoveMacros(ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureRemoveMacrosIsMutable();
                this.removeMacros_.add(value);
                return this;
            }

            public Builder addRemoveMacros(int index, ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureRemoveMacrosIsMutable();
                this.removeMacros_.add(index, value);
                return this;
            }

            public Builder addRemoveMacros(Builder builderForValue) {
                ensureRemoveMacrosIsMutable();
                this.removeMacros_.add(builderForValue.build());
                return this;
            }

            public Builder addRemoveMacros(int index, Builder builderForValue) {
                ensureRemoveMacrosIsMutable();
                this.removeMacros_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllRemoveMacros(Iterable<? extends ResolvedFunctionCall> values) {
                ensureRemoveMacrosIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.removeMacros_);
                return this;
            }

            public Builder clearRemoveMacros() {
                this.removeMacros_ = Collections.emptyList();
                this.bitField0_ &= -33;
                return this;
            }

            public Builder removeRemoveMacros(int index) {
                ensureRemoveMacrosIsMutable();
                this.removeMacros_.remove(index);
                return this;
            }

            public boolean hasResult() {
                return (this.bitField0_ & 64) == 64;
            }

            public Value getResult() {
                return this.result_;
            }

            public Builder setResult(Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result_ = value;
                this.bitField0_ |= 64;
                return this;
            }

            public Builder setResult(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builderForValue) {
                this.result_ = builderForValue.build();
                this.bitField0_ |= 64;
                return this;
            }

            public Builder mergeResult(Value value) {
                if ((this.bitField0_ & 64) != 64 || this.result_ == Value.getDefaultInstance()) {
                    this.result_ = value;
                } else {
                    this.result_ = Value.newBuilder(this.result_).mergeFrom(value).buildPartial();
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder clearResult() {
                this.result_ = Value.getDefaultInstance();
                this.bitField0_ &= -65;
                return this;
            }
        }

        private ResolvedRule(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ResolvedRule(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static ResolvedRule getDefaultInstance() {
            return defaultInstance;
        }

        public ResolvedRule getDefaultInstanceForType() {
            return defaultInstance;
        }

        private ResolvedRule(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            OutputStream unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            boolean done = false;
            while (!done) {
                try {
                    int tag = input.readTag();
                    switch (tag) {
                        case DragSortController.ON_DOWN /*0*/:
                            done = true;
                            break;
                        case MutableTypeSystem.Value.ESCAPING_FIELD_NUMBER /*10*/:
                            if ((mutable_bitField0_ & POSITIVE_PREDICATES_FIELD_NUMBER) != POSITIVE_PREDICATES_FIELD_NUMBER) {
                                this.positivePredicates_ = new ArrayList();
                                mutable_bitField0_ |= POSITIVE_PREDICATES_FIELD_NUMBER;
                            }
                            this.positivePredicates_.add(input.readMessage(ResolvedFunctionCall.PARSER, extensionRegistry));
                            break;
                        case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                            if ((mutable_bitField0_ & NEGATIVE_PREDICATES_FIELD_NUMBER) != NEGATIVE_PREDICATES_FIELD_NUMBER) {
                                this.negativePredicates_ = new ArrayList();
                                mutable_bitField0_ |= NEGATIVE_PREDICATES_FIELD_NUMBER;
                            }
                            this.negativePredicates_.add(input.readMessage(ResolvedFunctionCall.PARSER, extensionRegistry));
                            break;
                        case 26:
                            if ((mutable_bitField0_ & REMOVE_TAGS_FIELD_NUMBER) != REMOVE_TAGS_FIELD_NUMBER) {
                                this.addTags_ = new ArrayList();
                                mutable_bitField0_ |= REMOVE_TAGS_FIELD_NUMBER;
                            }
                            this.addTags_.add(input.readMessage(ResolvedFunctionCall.PARSER, extensionRegistry));
                            break;
                        case 34:
                            if ((mutable_bitField0_ & 8) != 8) {
                                this.removeTags_ = new ArrayList();
                                mutable_bitField0_ |= 8;
                            }
                            this.removeTags_.add(input.readMessage(ResolvedFunctionCall.PARSER, extensionRegistry));
                            break;
                        case 42:
                            if ((mutable_bitField0_ & 16) != 16) {
                                this.addMacros_ = new ArrayList();
                                mutable_bitField0_ |= 16;
                            }
                            this.addMacros_.add(input.readMessage(ResolvedFunctionCall.PARSER, extensionRegistry));
                            break;
                        case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                            if ((mutable_bitField0_ & 32) != 32) {
                                this.removeMacros_ = new ArrayList();
                                mutable_bitField0_ |= 32;
                            }
                            this.removeMacros_.add(input.readMessage(ResolvedFunctionCall.PARSER, extensionRegistry));
                            break;
                        case 58:
                            com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder subBuilder = null;
                            if ((this.bitField0_ & POSITIVE_PREDICATES_FIELD_NUMBER) == POSITIVE_PREDICATES_FIELD_NUMBER) {
                                subBuilder = this.result_.toBuilder();
                            }
                            this.result_ = (Value) input.readMessage(Value.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.result_);
                                this.result_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= POSITIVE_PREDICATES_FIELD_NUMBER;
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
                                done = true;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if ((mutable_bitField0_ & POSITIVE_PREDICATES_FIELD_NUMBER) == POSITIVE_PREDICATES_FIELD_NUMBER) {
                        this.positivePredicates_ = Collections.unmodifiableList(this.positivePredicates_);
                    }
                    if ((mutable_bitField0_ & NEGATIVE_PREDICATES_FIELD_NUMBER) == NEGATIVE_PREDICATES_FIELD_NUMBER) {
                        this.negativePredicates_ = Collections.unmodifiableList(this.negativePredicates_);
                    }
                    if ((mutable_bitField0_ & REMOVE_TAGS_FIELD_NUMBER) == REMOVE_TAGS_FIELD_NUMBER) {
                        this.addTags_ = Collections.unmodifiableList(this.addTags_);
                    }
                    if ((mutable_bitField0_ & 8) == 8) {
                        this.removeTags_ = Collections.unmodifiableList(this.removeTags_);
                    }
                    if ((mutable_bitField0_ & 16) == 16) {
                        this.addMacros_ = Collections.unmodifiableList(this.addMacros_);
                    }
                    if ((mutable_bitField0_ & 32) == 32) {
                        this.removeMacros_ = Collections.unmodifiableList(this.removeMacros_);
                    }
                    try {
                        unknownFieldsCodedOutput.flush();
                    } catch (IOException e3) {
                        makeExtensionsImmutable();
                    } finally {
                        this.unknownFields = unknownFieldsOutput.toByteString();
                    }
                    makeExtensionsImmutable();
                }
            }
            if ((mutable_bitField0_ & POSITIVE_PREDICATES_FIELD_NUMBER) == POSITIVE_PREDICATES_FIELD_NUMBER) {
                this.positivePredicates_ = Collections.unmodifiableList(this.positivePredicates_);
            }
            if ((mutable_bitField0_ & NEGATIVE_PREDICATES_FIELD_NUMBER) == NEGATIVE_PREDICATES_FIELD_NUMBER) {
                this.negativePredicates_ = Collections.unmodifiableList(this.negativePredicates_);
            }
            if ((mutable_bitField0_ & REMOVE_TAGS_FIELD_NUMBER) == REMOVE_TAGS_FIELD_NUMBER) {
                this.addTags_ = Collections.unmodifiableList(this.addTags_);
            }
            if ((mutable_bitField0_ & 8) == 8) {
                this.removeTags_ = Collections.unmodifiableList(this.removeTags_);
            }
            if ((mutable_bitField0_ & 16) == 16) {
                this.addMacros_ = Collections.unmodifiableList(this.addMacros_);
            }
            if ((mutable_bitField0_ & 32) == 32) {
                this.removeMacros_ = Collections.unmodifiableList(this.removeMacros_);
            }
            try {
                unknownFieldsCodedOutput.flush();
            } catch (IOException e4) {
            } finally {
                this.unknownFields = unknownFieldsOutput.toByteString();
            }
            makeExtensionsImmutable();
        }

        static {
            PARSER = new C08401();
            mutableDefault = null;
            defaultInstance = new ResolvedRule(true);
            defaultInstance.initFields();
        }

        public Parser<ResolvedRule> getParserForType() {
            return PARSER;
        }

        public List<ResolvedFunctionCall> getPositivePredicatesList() {
            return this.positivePredicates_;
        }

        public List<? extends ResolvedFunctionCallOrBuilder> getPositivePredicatesOrBuilderList() {
            return this.positivePredicates_;
        }

        public int getPositivePredicatesCount() {
            return this.positivePredicates_.size();
        }

        public ResolvedFunctionCall getPositivePredicates(int index) {
            return (ResolvedFunctionCall) this.positivePredicates_.get(index);
        }

        public ResolvedFunctionCallOrBuilder getPositivePredicatesOrBuilder(int index) {
            return (ResolvedFunctionCallOrBuilder) this.positivePredicates_.get(index);
        }

        public List<ResolvedFunctionCall> getNegativePredicatesList() {
            return this.negativePredicates_;
        }

        public List<? extends ResolvedFunctionCallOrBuilder> getNegativePredicatesOrBuilderList() {
            return this.negativePredicates_;
        }

        public int getNegativePredicatesCount() {
            return this.negativePredicates_.size();
        }

        public ResolvedFunctionCall getNegativePredicates(int index) {
            return (ResolvedFunctionCall) this.negativePredicates_.get(index);
        }

        public ResolvedFunctionCallOrBuilder getNegativePredicatesOrBuilder(int index) {
            return (ResolvedFunctionCallOrBuilder) this.negativePredicates_.get(index);
        }

        public List<ResolvedFunctionCall> getAddTagsList() {
            return this.addTags_;
        }

        public List<? extends ResolvedFunctionCallOrBuilder> getAddTagsOrBuilderList() {
            return this.addTags_;
        }

        public int getAddTagsCount() {
            return this.addTags_.size();
        }

        public ResolvedFunctionCall getAddTags(int index) {
            return (ResolvedFunctionCall) this.addTags_.get(index);
        }

        public ResolvedFunctionCallOrBuilder getAddTagsOrBuilder(int index) {
            return (ResolvedFunctionCallOrBuilder) this.addTags_.get(index);
        }

        public List<ResolvedFunctionCall> getRemoveTagsList() {
            return this.removeTags_;
        }

        public List<? extends ResolvedFunctionCallOrBuilder> getRemoveTagsOrBuilderList() {
            return this.removeTags_;
        }

        public int getRemoveTagsCount() {
            return this.removeTags_.size();
        }

        public ResolvedFunctionCall getRemoveTags(int index) {
            return (ResolvedFunctionCall) this.removeTags_.get(index);
        }

        public ResolvedFunctionCallOrBuilder getRemoveTagsOrBuilder(int index) {
            return (ResolvedFunctionCallOrBuilder) this.removeTags_.get(index);
        }

        public List<ResolvedFunctionCall> getAddMacrosList() {
            return this.addMacros_;
        }

        public List<? extends ResolvedFunctionCallOrBuilder> getAddMacrosOrBuilderList() {
            return this.addMacros_;
        }

        public int getAddMacrosCount() {
            return this.addMacros_.size();
        }

        public ResolvedFunctionCall getAddMacros(int index) {
            return (ResolvedFunctionCall) this.addMacros_.get(index);
        }

        public ResolvedFunctionCallOrBuilder getAddMacrosOrBuilder(int index) {
            return (ResolvedFunctionCallOrBuilder) this.addMacros_.get(index);
        }

        public List<ResolvedFunctionCall> getRemoveMacrosList() {
            return this.removeMacros_;
        }

        public List<? extends ResolvedFunctionCallOrBuilder> getRemoveMacrosOrBuilderList() {
            return this.removeMacros_;
        }

        public int getRemoveMacrosCount() {
            return this.removeMacros_.size();
        }

        public ResolvedFunctionCall getRemoveMacros(int index) {
            return (ResolvedFunctionCall) this.removeMacros_.get(index);
        }

        public ResolvedFunctionCallOrBuilder getRemoveMacrosOrBuilder(int index) {
            return (ResolvedFunctionCallOrBuilder) this.removeMacros_.get(index);
        }

        public boolean hasResult() {
            return (this.bitField0_ & POSITIVE_PREDICATES_FIELD_NUMBER) == POSITIVE_PREDICATES_FIELD_NUMBER;
        }

        public Value getResult() {
            return this.result_;
        }

        private void initFields() {
            this.positivePredicates_ = Collections.emptyList();
            this.negativePredicates_ = Collections.emptyList();
            this.addTags_ = Collections.emptyList();
            this.removeTags_ = Collections.emptyList();
            this.addMacros_ = Collections.emptyList();
            this.removeMacros_ = Collections.emptyList();
            this.result_ = Value.getDefaultInstance();
        }

        public final boolean isInitialized() {
            boolean z = true;
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                if (isInitialized != (byte) 1) {
                    z = false;
                }
                return z;
            }
            int i = 0;
            while (i < getPositivePredicatesCount()) {
                if (getPositivePredicates(i).isInitialized()) {
                    i += POSITIVE_PREDICATES_FIELD_NUMBER;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < getNegativePredicatesCount()) {
                if (getNegativePredicates(i).isInitialized()) {
                    i += POSITIVE_PREDICATES_FIELD_NUMBER;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < getAddTagsCount()) {
                if (getAddTags(i).isInitialized()) {
                    i += POSITIVE_PREDICATES_FIELD_NUMBER;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < getRemoveTagsCount()) {
                if (getRemoveTags(i).isInitialized()) {
                    i += POSITIVE_PREDICATES_FIELD_NUMBER;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < getAddMacrosCount()) {
                if (getAddMacros(i).isInitialized()) {
                    i += POSITIVE_PREDICATES_FIELD_NUMBER;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < getRemoveMacrosCount()) {
                if (getRemoveMacros(i).isInitialized()) {
                    i += POSITIVE_PREDICATES_FIELD_NUMBER;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!hasResult() || getResult().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            int i;
            getSerializedSize();
            for (i = 0; i < this.positivePredicates_.size(); i += POSITIVE_PREDICATES_FIELD_NUMBER) {
                output.writeMessage(POSITIVE_PREDICATES_FIELD_NUMBER, (MessageLite) this.positivePredicates_.get(i));
            }
            for (i = 0; i < this.negativePredicates_.size(); i += POSITIVE_PREDICATES_FIELD_NUMBER) {
                output.writeMessage(NEGATIVE_PREDICATES_FIELD_NUMBER, (MessageLite) this.negativePredicates_.get(i));
            }
            for (i = 0; i < this.addTags_.size(); i += POSITIVE_PREDICATES_FIELD_NUMBER) {
                output.writeMessage(ADD_TAGS_FIELD_NUMBER, (MessageLite) this.addTags_.get(i));
            }
            for (i = 0; i < this.removeTags_.size(); i += POSITIVE_PREDICATES_FIELD_NUMBER) {
                output.writeMessage(REMOVE_TAGS_FIELD_NUMBER, (MessageLite) this.removeTags_.get(i));
            }
            for (i = 0; i < this.addMacros_.size(); i += POSITIVE_PREDICATES_FIELD_NUMBER) {
                output.writeMessage(ADD_MACROS_FIELD_NUMBER, (MessageLite) this.addMacros_.get(i));
            }
            for (i = 0; i < this.removeMacros_.size(); i += POSITIVE_PREDICATES_FIELD_NUMBER) {
                output.writeMessage(REMOVE_MACROS_FIELD_NUMBER, (MessageLite) this.removeMacros_.get(i));
            }
            if ((this.bitField0_ & POSITIVE_PREDICATES_FIELD_NUMBER) == POSITIVE_PREDICATES_FIELD_NUMBER) {
                output.writeMessage(RESULT_FIELD_NUMBER, this.result_);
            }
            output.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int i;
            size = 0;
            for (i = 0; i < this.positivePredicates_.size(); i += POSITIVE_PREDICATES_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(POSITIVE_PREDICATES_FIELD_NUMBER, (MessageLite) this.positivePredicates_.get(i));
            }
            for (i = 0; i < this.negativePredicates_.size(); i += POSITIVE_PREDICATES_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(NEGATIVE_PREDICATES_FIELD_NUMBER, (MessageLite) this.negativePredicates_.get(i));
            }
            for (i = 0; i < this.addTags_.size(); i += POSITIVE_PREDICATES_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(ADD_TAGS_FIELD_NUMBER, (MessageLite) this.addTags_.get(i));
            }
            for (i = 0; i < this.removeTags_.size(); i += POSITIVE_PREDICATES_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(REMOVE_TAGS_FIELD_NUMBER, (MessageLite) this.removeTags_.get(i));
            }
            for (i = 0; i < this.addMacros_.size(); i += POSITIVE_PREDICATES_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(ADD_MACROS_FIELD_NUMBER, (MessageLite) this.addMacros_.get(i));
            }
            for (i = 0; i < this.removeMacros_.size(); i += POSITIVE_PREDICATES_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(REMOVE_MACROS_FIELD_NUMBER, (MessageLite) this.removeMacros_.get(i));
            }
            if ((this.bitField0_ & POSITIVE_PREDICATES_FIELD_NUMBER) == POSITIVE_PREDICATES_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(RESULT_FIELD_NUMBER, this.result_);
            }
            size += this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ResolvedRule)) {
                return super.equals(obj);
            }
            ResolvedRule other = (ResolvedRule) obj;
            boolean result = true && getPositivePredicatesList().equals(other.getPositivePredicatesList());
            if (result && getNegativePredicatesList().equals(other.getNegativePredicatesList())) {
                result = true;
            } else {
                result = false;
            }
            if (result && getAddTagsList().equals(other.getAddTagsList())) {
                result = true;
            } else {
                result = false;
            }
            if (result && getRemoveTagsList().equals(other.getRemoveTagsList())) {
                result = true;
            } else {
                result = false;
            }
            if (result && getAddMacrosList().equals(other.getAddMacrosList())) {
                result = true;
            } else {
                result = false;
            }
            if (result && getRemoveMacrosList().equals(other.getRemoveMacrosList())) {
                result = true;
            } else {
                result = false;
            }
            if (result && hasResult() == other.hasResult()) {
                result = true;
            } else {
                result = false;
            }
            if (hasResult()) {
                if (result && getResult().equals(other.getResult())) {
                    result = true;
                } else {
                    result = false;
                }
            }
            return result;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = ResolvedRule.class.hashCode() + 779;
            if (getPositivePredicatesCount() > 0) {
                hash = (((hash * 37) + POSITIVE_PREDICATES_FIELD_NUMBER) * 53) + getPositivePredicatesList().hashCode();
            }
            if (getNegativePredicatesCount() > 0) {
                hash = (((hash * 37) + NEGATIVE_PREDICATES_FIELD_NUMBER) * 53) + getNegativePredicatesList().hashCode();
            }
            if (getAddTagsCount() > 0) {
                hash = (((hash * 37) + ADD_TAGS_FIELD_NUMBER) * 53) + getAddTagsList().hashCode();
            }
            if (getRemoveTagsCount() > 0) {
                hash = (((hash * 37) + REMOVE_TAGS_FIELD_NUMBER) * 53) + getRemoveTagsList().hashCode();
            }
            if (getAddMacrosCount() > 0) {
                hash = (((hash * 37) + ADD_MACROS_FIELD_NUMBER) * 53) + getAddMacrosList().hashCode();
            }
            if (getRemoveMacrosCount() > 0) {
                hash = (((hash * 37) + REMOVE_MACROS_FIELD_NUMBER) * 53) + getRemoveMacrosList().hashCode();
            }
            if (hasResult()) {
                hash = (((hash * 37) + RESULT_FIELD_NUMBER) * 53) + getResult().hashCode();
            }
            hash = (hash * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$ResolvedRule");
            }
            return mutableDefault;
        }

        public static ResolvedRule parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ResolvedRule) PARSER.parseFrom(data);
        }

        public static ResolvedRule parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ResolvedRule) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResolvedRule parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ResolvedRule) PARSER.parseFrom(data);
        }

        public static ResolvedRule parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ResolvedRule) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResolvedRule parseFrom(InputStream input) throws IOException {
            return (ResolvedRule) PARSER.parseFrom(input);
        }

        public static ResolvedRule parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResolvedRule) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ResolvedRule parseDelimitedFrom(InputStream input) throws IOException {
            return (ResolvedRule) PARSER.parseDelimitedFrom(input);
        }

        public static ResolvedRule parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResolvedRule) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ResolvedRule parseFrom(CodedInputStream input) throws IOException {
            return (ResolvedRule) PARSER.parseFrom(input);
        }

        public static ResolvedRule parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResolvedRule) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ResolvedRule prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class RuleEvaluationStepInfo extends GeneratedMessageLite implements RuleEvaluationStepInfoOrBuilder {
        public static final int ENABLED_FUNCTIONS_FIELD_NUMBER = 2;
        public static Parser<RuleEvaluationStepInfo> PARSER = null;
        public static final int RULES_FIELD_NUMBER = 1;
        private static final RuleEvaluationStepInfo defaultInstance;
        private static volatile MutableMessageLite mutableDefault;
        private static final long serialVersionUID = 0;
        private List<ResolvedFunctionCall> enabledFunctions_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<ResolvedRule> rules_;
        private final ByteString unknownFields;

        /* renamed from: com.google.analytics.containertag.proto.Debug.RuleEvaluationStepInfo.1 */
        static class C08411 extends AbstractParser<RuleEvaluationStepInfo> {
            C08411() {
            }

            public RuleEvaluationStepInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RuleEvaluationStepInfo(extensionRegistry, null);
            }
        }

        public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<RuleEvaluationStepInfo, Builder> implements RuleEvaluationStepInfoOrBuilder {
            private int bitField0_;
            private List<ResolvedFunctionCall> enabledFunctions_;
            private List<ResolvedRule> rules_;

            private Builder() {
                this.rules_ = Collections.emptyList();
                this.enabledFunctions_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.rules_ = Collections.emptyList();
                this.bitField0_ &= -2;
                this.enabledFunctions_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public RuleEvaluationStepInfo getDefaultInstanceForType() {
                return RuleEvaluationStepInfo.getDefaultInstance();
            }

            public RuleEvaluationStepInfo build() {
                RuleEvaluationStepInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(result);
            }

            public RuleEvaluationStepInfo buildPartial() {
                RuleEvaluationStepInfo result = new RuleEvaluationStepInfo(null);
                int from_bitField0_ = this.bitField0_;
                if ((this.bitField0_ & RuleEvaluationStepInfo.RULES_FIELD_NUMBER) == RuleEvaluationStepInfo.RULES_FIELD_NUMBER) {
                    this.rules_ = Collections.unmodifiableList(this.rules_);
                    this.bitField0_ &= -2;
                }
                result.rules_ = this.rules_;
                if ((this.bitField0_ & RuleEvaluationStepInfo.ENABLED_FUNCTIONS_FIELD_NUMBER) == RuleEvaluationStepInfo.ENABLED_FUNCTIONS_FIELD_NUMBER) {
                    this.enabledFunctions_ = Collections.unmodifiableList(this.enabledFunctions_);
                    this.bitField0_ &= -3;
                }
                result.enabledFunctions_ = this.enabledFunctions_;
                return result;
            }

            public Builder mergeFrom(RuleEvaluationStepInfo other) {
                if (other != RuleEvaluationStepInfo.getDefaultInstance()) {
                    if (!other.rules_.isEmpty()) {
                        if (this.rules_.isEmpty()) {
                            this.rules_ = other.rules_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureRulesIsMutable();
                            this.rules_.addAll(other.rules_);
                        }
                    }
                    if (!other.enabledFunctions_.isEmpty()) {
                        if (this.enabledFunctions_.isEmpty()) {
                            this.enabledFunctions_ = other.enabledFunctions_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureEnabledFunctionsIsMutable();
                            this.enabledFunctions_.addAll(other.enabledFunctions_);
                        }
                    }
                    setUnknownFields(getUnknownFields().concat(other.unknownFields));
                }
                return this;
            }

            public final boolean isInitialized() {
                int i;
                for (i = 0; i < getRulesCount(); i += RuleEvaluationStepInfo.RULES_FIELD_NUMBER) {
                    if (!getRules(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getEnabledFunctionsCount(); i += RuleEvaluationStepInfo.RULES_FIELD_NUMBER) {
                    if (!getEnabledFunctions(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RuleEvaluationStepInfo parsedMessage = null;
                try {
                    parsedMessage = (RuleEvaluationStepInfo) RuleEvaluationStepInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RuleEvaluationStepInfo) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
            }

            private void ensureRulesIsMutable() {
                if ((this.bitField0_ & RuleEvaluationStepInfo.RULES_FIELD_NUMBER) != RuleEvaluationStepInfo.RULES_FIELD_NUMBER) {
                    this.rules_ = new ArrayList(this.rules_);
                    this.bitField0_ |= RuleEvaluationStepInfo.RULES_FIELD_NUMBER;
                }
            }

            public List<ResolvedRule> getRulesList() {
                return Collections.unmodifiableList(this.rules_);
            }

            public int getRulesCount() {
                return this.rules_.size();
            }

            public ResolvedRule getRules(int index) {
                return (ResolvedRule) this.rules_.get(index);
            }

            public Builder setRules(int index, ResolvedRule value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureRulesIsMutable();
                this.rules_.set(index, value);
                return this;
            }

            public Builder setRules(int index, Builder builderForValue) {
                ensureRulesIsMutable();
                this.rules_.set(index, builderForValue.build());
                return this;
            }

            public Builder addRules(ResolvedRule value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureRulesIsMutable();
                this.rules_.add(value);
                return this;
            }

            public Builder addRules(int index, ResolvedRule value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureRulesIsMutable();
                this.rules_.add(index, value);
                return this;
            }

            public Builder addRules(Builder builderForValue) {
                ensureRulesIsMutable();
                this.rules_.add(builderForValue.build());
                return this;
            }

            public Builder addRules(int index, Builder builderForValue) {
                ensureRulesIsMutable();
                this.rules_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllRules(Iterable<? extends ResolvedRule> values) {
                ensureRulesIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.rules_);
                return this;
            }

            public Builder clearRules() {
                this.rules_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder removeRules(int index) {
                ensureRulesIsMutable();
                this.rules_.remove(index);
                return this;
            }

            private void ensureEnabledFunctionsIsMutable() {
                if ((this.bitField0_ & RuleEvaluationStepInfo.ENABLED_FUNCTIONS_FIELD_NUMBER) != RuleEvaluationStepInfo.ENABLED_FUNCTIONS_FIELD_NUMBER) {
                    this.enabledFunctions_ = new ArrayList(this.enabledFunctions_);
                    this.bitField0_ |= RuleEvaluationStepInfo.ENABLED_FUNCTIONS_FIELD_NUMBER;
                }
            }

            public List<ResolvedFunctionCall> getEnabledFunctionsList() {
                return Collections.unmodifiableList(this.enabledFunctions_);
            }

            public int getEnabledFunctionsCount() {
                return this.enabledFunctions_.size();
            }

            public ResolvedFunctionCall getEnabledFunctions(int index) {
                return (ResolvedFunctionCall) this.enabledFunctions_.get(index);
            }

            public Builder setEnabledFunctions(int index, ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureEnabledFunctionsIsMutable();
                this.enabledFunctions_.set(index, value);
                return this;
            }

            public Builder setEnabledFunctions(int index, Builder builderForValue) {
                ensureEnabledFunctionsIsMutable();
                this.enabledFunctions_.set(index, builderForValue.build());
                return this;
            }

            public Builder addEnabledFunctions(ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureEnabledFunctionsIsMutable();
                this.enabledFunctions_.add(value);
                return this;
            }

            public Builder addEnabledFunctions(int index, ResolvedFunctionCall value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureEnabledFunctionsIsMutable();
                this.enabledFunctions_.add(index, value);
                return this;
            }

            public Builder addEnabledFunctions(Builder builderForValue) {
                ensureEnabledFunctionsIsMutable();
                this.enabledFunctions_.add(builderForValue.build());
                return this;
            }

            public Builder addEnabledFunctions(int index, Builder builderForValue) {
                ensureEnabledFunctionsIsMutable();
                this.enabledFunctions_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllEnabledFunctions(Iterable<? extends ResolvedFunctionCall> values) {
                ensureEnabledFunctionsIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.enabledFunctions_);
                return this;
            }

            public Builder clearEnabledFunctions() {
                this.enabledFunctions_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder removeEnabledFunctions(int index) {
                ensureEnabledFunctionsIsMutable();
                this.enabledFunctions_.remove(index);
                return this;
            }
        }

        private RuleEvaluationStepInfo(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private RuleEvaluationStepInfo(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static RuleEvaluationStepInfo getDefaultInstance() {
            return defaultInstance;
        }

        public RuleEvaluationStepInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        private RuleEvaluationStepInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            OutputStream unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            boolean done = false;
            while (!done) {
                try {
                    int tag = input.readTag();
                    switch (tag) {
                        case DragSortController.ON_DOWN /*0*/:
                            done = true;
                            break;
                        case MutableTypeSystem.Value.ESCAPING_FIELD_NUMBER /*10*/:
                            if ((mutable_bitField0_ & RULES_FIELD_NUMBER) != RULES_FIELD_NUMBER) {
                                this.rules_ = new ArrayList();
                                mutable_bitField0_ |= RULES_FIELD_NUMBER;
                            }
                            this.rules_.add(input.readMessage(ResolvedRule.PARSER, extensionRegistry));
                            break;
                        case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                            if ((mutable_bitField0_ & ENABLED_FUNCTIONS_FIELD_NUMBER) != ENABLED_FUNCTIONS_FIELD_NUMBER) {
                                this.enabledFunctions_ = new ArrayList();
                                mutable_bitField0_ |= ENABLED_FUNCTIONS_FIELD_NUMBER;
                            }
                            this.enabledFunctions_.add(input.readMessage(ResolvedFunctionCall.PARSER, extensionRegistry));
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
                                done = true;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if ((mutable_bitField0_ & RULES_FIELD_NUMBER) == RULES_FIELD_NUMBER) {
                        this.rules_ = Collections.unmodifiableList(this.rules_);
                    }
                    if ((mutable_bitField0_ & ENABLED_FUNCTIONS_FIELD_NUMBER) == ENABLED_FUNCTIONS_FIELD_NUMBER) {
                        this.enabledFunctions_ = Collections.unmodifiableList(this.enabledFunctions_);
                    }
                    try {
                        unknownFieldsCodedOutput.flush();
                    } catch (IOException e3) {
                        makeExtensionsImmutable();
                    } finally {
                        this.unknownFields = unknownFieldsOutput.toByteString();
                    }
                    makeExtensionsImmutable();
                }
            }
            if ((mutable_bitField0_ & RULES_FIELD_NUMBER) == RULES_FIELD_NUMBER) {
                this.rules_ = Collections.unmodifiableList(this.rules_);
            }
            if ((mutable_bitField0_ & ENABLED_FUNCTIONS_FIELD_NUMBER) == ENABLED_FUNCTIONS_FIELD_NUMBER) {
                this.enabledFunctions_ = Collections.unmodifiableList(this.enabledFunctions_);
            }
            try {
                unknownFieldsCodedOutput.flush();
            } catch (IOException e4) {
            } finally {
                this.unknownFields = unknownFieldsOutput.toByteString();
            }
            makeExtensionsImmutable();
        }

        static {
            PARSER = new C08411();
            mutableDefault = null;
            defaultInstance = new RuleEvaluationStepInfo(true);
            defaultInstance.initFields();
        }

        public Parser<RuleEvaluationStepInfo> getParserForType() {
            return PARSER;
        }

        public List<ResolvedRule> getRulesList() {
            return this.rules_;
        }

        public List<? extends ResolvedRuleOrBuilder> getRulesOrBuilderList() {
            return this.rules_;
        }

        public int getRulesCount() {
            return this.rules_.size();
        }

        public ResolvedRule getRules(int index) {
            return (ResolvedRule) this.rules_.get(index);
        }

        public ResolvedRuleOrBuilder getRulesOrBuilder(int index) {
            return (ResolvedRuleOrBuilder) this.rules_.get(index);
        }

        public List<ResolvedFunctionCall> getEnabledFunctionsList() {
            return this.enabledFunctions_;
        }

        public List<? extends ResolvedFunctionCallOrBuilder> getEnabledFunctionsOrBuilderList() {
            return this.enabledFunctions_;
        }

        public int getEnabledFunctionsCount() {
            return this.enabledFunctions_.size();
        }

        public ResolvedFunctionCall getEnabledFunctions(int index) {
            return (ResolvedFunctionCall) this.enabledFunctions_.get(index);
        }

        public ResolvedFunctionCallOrBuilder getEnabledFunctionsOrBuilder(int index) {
            return (ResolvedFunctionCallOrBuilder) this.enabledFunctions_.get(index);
        }

        private void initFields() {
            this.rules_ = Collections.emptyList();
            this.enabledFunctions_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == -1) {
                int i = 0;
                while (i < getRulesCount()) {
                    if (getRules(i).isInitialized()) {
                        i += RULES_FIELD_NUMBER;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < getEnabledFunctionsCount()) {
                    if (getEnabledFunctions(i).isInitialized()) {
                        i += RULES_FIELD_NUMBER;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else if (isInitialized == (byte) 1) {
                return true;
            } else {
                return false;
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            int i;
            getSerializedSize();
            for (i = 0; i < this.rules_.size(); i += RULES_FIELD_NUMBER) {
                output.writeMessage(RULES_FIELD_NUMBER, (MessageLite) this.rules_.get(i));
            }
            for (i = 0; i < this.enabledFunctions_.size(); i += RULES_FIELD_NUMBER) {
                output.writeMessage(ENABLED_FUNCTIONS_FIELD_NUMBER, (MessageLite) this.enabledFunctions_.get(i));
            }
            output.writeRawBytes(this.unknownFields);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int i;
            size = 0;
            for (i = 0; i < this.rules_.size(); i += RULES_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(RULES_FIELD_NUMBER, (MessageLite) this.rules_.get(i));
            }
            for (i = 0; i < this.enabledFunctions_.size(); i += RULES_FIELD_NUMBER) {
                size += CodedOutputStream.computeMessageSize(ENABLED_FUNCTIONS_FIELD_NUMBER, (MessageLite) this.enabledFunctions_.get(i));
            }
            size += this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof RuleEvaluationStepInfo)) {
                return super.equals(obj);
            }
            boolean result;
            RuleEvaluationStepInfo other = (RuleEvaluationStepInfo) obj;
            if (true && getRulesList().equals(other.getRulesList())) {
                result = true;
            } else {
                result = false;
            }
            if (result && getEnabledFunctionsList().equals(other.getEnabledFunctionsList())) {
                result = true;
            } else {
                result = false;
            }
            return result;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = RuleEvaluationStepInfo.class.hashCode() + 779;
            if (getRulesCount() > 0) {
                hash = (((hash * 37) + RULES_FIELD_NUMBER) * 53) + getRulesList().hashCode();
            }
            if (getEnabledFunctionsCount() > 0) {
                hash = (((hash * 37) + ENABLED_FUNCTIONS_FIELD_NUMBER) * 53) + getEnabledFunctionsList().hashCode();
            }
            hash = (hash * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$RuleEvaluationStepInfo");
            }
            return mutableDefault;
        }

        public static RuleEvaluationStepInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RuleEvaluationStepInfo) PARSER.parseFrom(data);
        }

        public static RuleEvaluationStepInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RuleEvaluationStepInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RuleEvaluationStepInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RuleEvaluationStepInfo) PARSER.parseFrom(data);
        }

        public static RuleEvaluationStepInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RuleEvaluationStepInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RuleEvaluationStepInfo parseFrom(InputStream input) throws IOException {
            return (RuleEvaluationStepInfo) PARSER.parseFrom(input);
        }

        public static RuleEvaluationStepInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RuleEvaluationStepInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static RuleEvaluationStepInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (RuleEvaluationStepInfo) PARSER.parseDelimitedFrom(input);
        }

        public static RuleEvaluationStepInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RuleEvaluationStepInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static RuleEvaluationStepInfo parseFrom(CodedInputStream input) throws IOException {
            return (RuleEvaluationStepInfo) PARSER.parseFrom(input);
        }

        public static RuleEvaluationStepInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RuleEvaluationStepInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(RuleEvaluationStepInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private Debug() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
        registry.add(MacroEvaluationInfo.macro);
    }

    static {
    }
}
