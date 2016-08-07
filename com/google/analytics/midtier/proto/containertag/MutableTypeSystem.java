package com.google.analytics.midtier.proto.containertag;

import android.support.v4.media.TransportMediator;
import com.google.ads.AdSize;
import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.android.gms.drive.DriveFile;
import com.google.tagmanager.protobuf.AbstractMutableMessageLite;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMutableMessageLite;
import com.google.tagmanager.protobuf.GeneratedMutableMessageLite.ExtendableMutableMessage;
import com.google.tagmanager.protobuf.Internal;
import com.google.tagmanager.protobuf.Internal.EnumLite;
import com.google.tagmanager.protobuf.Internal.EnumLiteMap;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import com.mobeta.android.dslv.DragSortController;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class MutableTypeSystem {

    public static final class Value extends ExtendableMutableMessage<Value> implements MutableMessageLite {
        public static final int BOOLEAN_FIELD_NUMBER = 12;
        public static final int CONTAINS_REFERENCES_FIELD_NUMBER = 9;
        public static final int ESCAPING_FIELD_NUMBER = 10;
        public static final int FUNCTION_ID_FIELD_NUMBER = 7;
        public static final int INTEGER_FIELD_NUMBER = 8;
        public static final int LIST_ITEM_FIELD_NUMBER = 3;
        public static final int MACRO_REFERENCE_FIELD_NUMBER = 6;
        public static final int MAP_KEY_FIELD_NUMBER = 4;
        public static final int MAP_VALUE_FIELD_NUMBER = 5;
        public static Parser<Value> PARSER = null;
        public static final int STRING_FIELD_NUMBER = 2;
        public static final int TEMPLATE_TOKEN_FIELD_NUMBER = 11;
        public static final int TYPE_FIELD_NUMBER = 1;
        private static final Value defaultInstance;
        private static volatile MessageLite immutableDefault;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean boolean_;
        private boolean containsReferences_;
        private List<Escaping> escaping_;
        private Object functionId_;
        private long integer_;
        private List<Value> listItem_;
        private Object macroReference_;
        private List<Value> mapKey_;
        private List<Value> mapValue_;
        private Object string_;
        private List<Value> templateToken_;
        private Type type_;

        public enum Escaping implements EnumLite {
            ESCAPE_HTML(0, ESCAPE_HTML_VALUE),
            ESCAPE_HTML_RCDATA(ESCAPE_HTML_VALUE, ESCAPE_HTML_RCDATA_VALUE),
            ESCAPE_HTML_ATTRIBUTE(ESCAPE_HTML_RCDATA_VALUE, ESCAPE_HTML_ATTRIBUTE_VALUE),
            ESCAPE_HTML_ATTRIBUTE_NOSPACE(ESCAPE_HTML_ATTRIBUTE_VALUE, ESCAPE_HTML_ATTRIBUTE_NOSPACE_VALUE),
            FILTER_HTML_ELEMENT_NAME(ESCAPE_HTML_ATTRIBUTE_NOSPACE_VALUE, FILTER_HTML_ELEMENT_NAME_VALUE),
            FILTER_HTML_ATTRIBUTES(FILTER_HTML_ELEMENT_NAME_VALUE, FILTER_HTML_ATTRIBUTES_VALUE),
            ESCAPE_JS_STRING(FILTER_HTML_ATTRIBUTES_VALUE, ESCAPE_JS_STRING_VALUE),
            ESCAPE_JS_VALUE(ESCAPE_JS_STRING_VALUE, ESCAPE_JS_VALUE_VALUE),
            ESCAPE_JS_REGEX(ESCAPE_JS_VALUE_VALUE, ESCAPE_JS_REGEX_VALUE),
            ESCAPE_CSS_STRING(ESCAPE_JS_REGEX_VALUE, ESCAPE_CSS_STRING_VALUE),
            FILTER_CSS_VALUE(ESCAPE_CSS_STRING_VALUE, FILTER_CSS_VALUE_VALUE),
            ESCAPE_URI(FILTER_CSS_VALUE_VALUE, ESCAPE_URI_VALUE),
            NORMALIZE_URI(ESCAPE_URI_VALUE, NORMALIZE_URI_VALUE),
            FILTER_NORMALIZE_URI(NORMALIZE_URI_VALUE, FILTER_NORMALIZE_URI_VALUE),
            NO_AUTOESCAPE(FILTER_NORMALIZE_URI_VALUE, NO_AUTOESCAPE_VALUE),
            TEXT(NO_AUTOESCAPE_VALUE, TEXT_VALUE),
            CONVERT_JS_VALUE_TO_EXPRESSION(CONVERT_JS_VALUE_TO_EXPRESSION_VALUE, CONVERT_JS_VALUE_TO_EXPRESSION_VALUE);
            
            public static final int CONVERT_JS_VALUE_TO_EXPRESSION_VALUE = 16;
            public static final int ESCAPE_CSS_STRING_VALUE = 10;
            public static final int ESCAPE_HTML_ATTRIBUTE_NOSPACE_VALUE = 4;
            public static final int ESCAPE_HTML_ATTRIBUTE_VALUE = 3;
            public static final int ESCAPE_HTML_RCDATA_VALUE = 2;
            public static final int ESCAPE_HTML_VALUE = 1;
            public static final int ESCAPE_JS_REGEX_VALUE = 9;
            public static final int ESCAPE_JS_STRING_VALUE = 7;
            public static final int ESCAPE_JS_VALUE_VALUE = 8;
            public static final int ESCAPE_URI_VALUE = 12;
            public static final int FILTER_CSS_VALUE_VALUE = 11;
            public static final int FILTER_HTML_ATTRIBUTES_VALUE = 6;
            public static final int FILTER_HTML_ELEMENT_NAME_VALUE = 5;
            public static final int FILTER_NORMALIZE_URI_VALUE = 14;
            public static final int NORMALIZE_URI_VALUE = 13;
            public static final int NO_AUTOESCAPE_VALUE = 15;
            public static final int TEXT_VALUE = 17;
            private static EnumLiteMap<Escaping> internalValueMap;
            private final int value;

            /* renamed from: com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.Escaping.1 */
            static class C04941 implements EnumLiteMap<Escaping> {
                C04941() {
                }

                public Escaping findValueByNumber(int number) {
                    return Escaping.valueOf(number);
                }
            }

            static {
                internalValueMap = new C04941();
            }

            public final int getNumber() {
                return this.value;
            }

            public static Escaping valueOf(int value) {
                switch (value) {
                    case ESCAPE_HTML_VALUE:
                        return ESCAPE_HTML;
                    case ESCAPE_HTML_RCDATA_VALUE:
                        return ESCAPE_HTML_RCDATA;
                    case ESCAPE_HTML_ATTRIBUTE_VALUE:
                        return ESCAPE_HTML_ATTRIBUTE;
                    case ESCAPE_HTML_ATTRIBUTE_NOSPACE_VALUE:
                        return ESCAPE_HTML_ATTRIBUTE_NOSPACE;
                    case FILTER_HTML_ELEMENT_NAME_VALUE:
                        return FILTER_HTML_ELEMENT_NAME;
                    case FILTER_HTML_ATTRIBUTES_VALUE:
                        return FILTER_HTML_ATTRIBUTES;
                    case ESCAPE_JS_STRING_VALUE:
                        return ESCAPE_JS_STRING;
                    case ESCAPE_JS_VALUE_VALUE:
                        return ESCAPE_JS_VALUE;
                    case ESCAPE_JS_REGEX_VALUE:
                        return ESCAPE_JS_REGEX;
                    case ESCAPE_CSS_STRING_VALUE:
                        return ESCAPE_CSS_STRING;
                    case FILTER_CSS_VALUE_VALUE:
                        return FILTER_CSS_VALUE;
                    case ESCAPE_URI_VALUE:
                        return ESCAPE_URI;
                    case NORMALIZE_URI_VALUE:
                        return NORMALIZE_URI;
                    case FILTER_NORMALIZE_URI_VALUE:
                        return FILTER_NORMALIZE_URI;
                    case NO_AUTOESCAPE_VALUE:
                        return NO_AUTOESCAPE;
                    case CONVERT_JS_VALUE_TO_EXPRESSION_VALUE:
                        return CONVERT_JS_VALUE_TO_EXPRESSION;
                    case TEXT_VALUE:
                        return TEXT;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<Escaping> internalGetValueMap() {
                return internalValueMap;
            }

            private Escaping(int index, int value) {
                this.value = value;
            }
        }

        public enum Type implements EnumLite {
            STRING(0, STRING_VALUE),
            LIST(STRING_VALUE, LIST_VALUE),
            MAP(LIST_VALUE, MAP_VALUE),
            MACRO_REFERENCE(MAP_VALUE, MACRO_REFERENCE_VALUE),
            FUNCTION_ID(MACRO_REFERENCE_VALUE, FUNCTION_ID_VALUE),
            INTEGER(FUNCTION_ID_VALUE, INTEGER_VALUE),
            TEMPLATE(INTEGER_VALUE, TEMPLATE_VALUE),
            BOOLEAN(TEMPLATE_VALUE, BOOLEAN_VALUE);
            
            public static final int BOOLEAN_VALUE = 8;
            public static final int FUNCTION_ID_VALUE = 5;
            public static final int INTEGER_VALUE = 6;
            public static final int LIST_VALUE = 2;
            public static final int MACRO_REFERENCE_VALUE = 4;
            public static final int MAP_VALUE = 3;
            public static final int STRING_VALUE = 1;
            public static final int TEMPLATE_VALUE = 7;
            private static EnumLiteMap<Type> internalValueMap;
            private final int value;

            /* renamed from: com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.Type.1 */
            static class C04951 implements EnumLiteMap<Type> {
                C04951() {
                }

                public Type findValueByNumber(int number) {
                    return Type.valueOf(number);
                }
            }

            static {
                internalValueMap = new C04951();
            }

            public final int getNumber() {
                return this.value;
            }

            public static Type valueOf(int value) {
                switch (value) {
                    case STRING_VALUE:
                        return STRING;
                    case LIST_VALUE:
                        return LIST;
                    case MAP_VALUE:
                        return MAP;
                    case MACRO_REFERENCE_VALUE:
                        return MACRO_REFERENCE;
                    case FUNCTION_ID_VALUE:
                        return FUNCTION_ID;
                    case INTEGER_VALUE:
                        return INTEGER;
                    case TEMPLATE_VALUE:
                        return TEMPLATE;
                    case BOOLEAN_VALUE:
                        return BOOLEAN;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<Type> internalGetValueMap() {
                return internalValueMap;
            }

            private Type(int index, int value) {
                this.value = value;
            }
        }

        private Value() {
            this.type_ = Type.STRING;
            this.string_ = Internal.EMPTY_BYTE_ARRAY;
            this.listItem_ = null;
            this.mapKey_ = null;
            this.mapValue_ = null;
            this.macroReference_ = Internal.EMPTY_BYTE_ARRAY;
            this.functionId_ = Internal.EMPTY_BYTE_ARRAY;
            this.templateToken_ = null;
            this.escaping_ = null;
            initFields();
        }

        private Value(boolean noInit) {
            this.type_ = Type.STRING;
            this.string_ = Internal.EMPTY_BYTE_ARRAY;
            this.listItem_ = null;
            this.mapKey_ = null;
            this.mapValue_ = null;
            this.macroReference_ = Internal.EMPTY_BYTE_ARRAY;
            this.functionId_ = Internal.EMPTY_BYTE_ARRAY;
            this.templateToken_ = null;
            this.escaping_ = null;
        }

        public Value newMessageForType() {
            return new Value();
        }

        public static Value newMessage() {
            return new Value();
        }

        private void initFields() {
            this.type_ = Type.STRING;
        }

        public static Value getDefaultInstance() {
            return defaultInstance;
        }

        public final Value getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Parser<Value> getParserForType() {
            return PARSER;
        }

        public boolean hasType() {
            return (this.bitField0_ & TYPE_FIELD_NUMBER) == TYPE_FIELD_NUMBER;
        }

        public Type getType() {
            return this.type_;
        }

        public Value setType(Type value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= TYPE_FIELD_NUMBER;
            this.type_ = value;
            return this;
        }

        public Value clearType() {
            assertMutable();
            this.bitField0_ &= -2;
            this.type_ = Type.STRING;
            return this;
        }

        public boolean hasString() {
            return (this.bitField0_ & STRING_FIELD_NUMBER) == STRING_FIELD_NUMBER;
        }

        public String getString() {
            Object ref = this.string_;
            if (ref instanceof String) {
                return (String) ref;
            }
            byte[] byteArray = (byte[]) ref;
            String s = Internal.toStringUtf8(byteArray);
            if (Internal.isValidUtf8(byteArray)) {
                this.string_ = s;
            }
            return s;
        }

        public byte[] getStringAsBytes() {
            String ref = this.string_;
            if (!(ref instanceof String)) {
                return (byte[]) ref;
            }
            byte[] byteArray = Internal.toByteArray(ref);
            this.string_ = byteArray;
            return byteArray;
        }

        public Value setString(String value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= STRING_FIELD_NUMBER;
            this.string_ = value;
            return this;
        }

        public Value setStringAsBytes(byte[] value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= STRING_FIELD_NUMBER;
            this.string_ = value;
            return this;
        }

        public Value clearString() {
            assertMutable();
            this.bitField0_ &= -3;
            this.string_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        private void ensureListItemInitialized() {
            if (this.listItem_ == null) {
                this.listItem_ = new ArrayList();
            }
        }

        public int getListItemCount() {
            return this.listItem_ == null ? 0 : this.listItem_.size();
        }

        public List<Value> getListItemList() {
            if (this.listItem_ == null) {
                return Collections.emptyList();
            }
            return Collections.unmodifiableList(this.listItem_);
        }

        public List<Value> getMutableListItemList() {
            assertMutable();
            ensureListItemInitialized();
            return this.listItem_;
        }

        public Value getListItem(int index) {
            return (Value) this.listItem_.get(index);
        }

        public Value getMutableListItem(int index) {
            return (Value) this.listItem_.get(index);
        }

        public Value addListItem() {
            assertMutable();
            ensureListItemInitialized();
            Value value = newMessage();
            this.listItem_.add(value);
            return value;
        }

        public Value addListItem(Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            ensureListItemInitialized();
            this.listItem_.add(value);
            return this;
        }

        public Value addAllListItem(Iterable<? extends Value> values) {
            assertMutable();
            ensureListItemInitialized();
            AbstractMutableMessageLite.addAll(values, this.listItem_);
            return this;
        }

        public Value setListItem(int index, Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            ensureListItemInitialized();
            this.listItem_.set(index, value);
            return this;
        }

        public Value clearListItem() {
            assertMutable();
            this.listItem_ = null;
            return this;
        }

        private void ensureMapKeyInitialized() {
            if (this.mapKey_ == null) {
                this.mapKey_ = new ArrayList();
            }
        }

        public int getMapKeyCount() {
            return this.mapKey_ == null ? 0 : this.mapKey_.size();
        }

        public List<Value> getMapKeyList() {
            if (this.mapKey_ == null) {
                return Collections.emptyList();
            }
            return Collections.unmodifiableList(this.mapKey_);
        }

        public List<Value> getMutableMapKeyList() {
            assertMutable();
            ensureMapKeyInitialized();
            return this.mapKey_;
        }

        public Value getMapKey(int index) {
            return (Value) this.mapKey_.get(index);
        }

        public Value getMutableMapKey(int index) {
            return (Value) this.mapKey_.get(index);
        }

        public Value addMapKey() {
            assertMutable();
            ensureMapKeyInitialized();
            Value value = newMessage();
            this.mapKey_.add(value);
            return value;
        }

        public Value addMapKey(Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            ensureMapKeyInitialized();
            this.mapKey_.add(value);
            return this;
        }

        public Value addAllMapKey(Iterable<? extends Value> values) {
            assertMutable();
            ensureMapKeyInitialized();
            AbstractMutableMessageLite.addAll(values, this.mapKey_);
            return this;
        }

        public Value setMapKey(int index, Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            ensureMapKeyInitialized();
            this.mapKey_.set(index, value);
            return this;
        }

        public Value clearMapKey() {
            assertMutable();
            this.mapKey_ = null;
            return this;
        }

        private void ensureMapValueInitialized() {
            if (this.mapValue_ == null) {
                this.mapValue_ = new ArrayList();
            }
        }

        public int getMapValueCount() {
            return this.mapValue_ == null ? 0 : this.mapValue_.size();
        }

        public List<Value> getMapValueList() {
            if (this.mapValue_ == null) {
                return Collections.emptyList();
            }
            return Collections.unmodifiableList(this.mapValue_);
        }

        public List<Value> getMutableMapValueList() {
            assertMutable();
            ensureMapValueInitialized();
            return this.mapValue_;
        }

        public Value getMapValue(int index) {
            return (Value) this.mapValue_.get(index);
        }

        public Value getMutableMapValue(int index) {
            return (Value) this.mapValue_.get(index);
        }

        public Value addMapValue() {
            assertMutable();
            ensureMapValueInitialized();
            Value value = newMessage();
            this.mapValue_.add(value);
            return value;
        }

        public Value addMapValue(Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            ensureMapValueInitialized();
            this.mapValue_.add(value);
            return this;
        }

        public Value addAllMapValue(Iterable<? extends Value> values) {
            assertMutable();
            ensureMapValueInitialized();
            AbstractMutableMessageLite.addAll(values, this.mapValue_);
            return this;
        }

        public Value setMapValue(int index, Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            ensureMapValueInitialized();
            this.mapValue_.set(index, value);
            return this;
        }

        public Value clearMapValue() {
            assertMutable();
            this.mapValue_ = null;
            return this;
        }

        public boolean hasMacroReference() {
            return (this.bitField0_ & MAP_KEY_FIELD_NUMBER) == MAP_KEY_FIELD_NUMBER;
        }

        public String getMacroReference() {
            Object ref = this.macroReference_;
            if (ref instanceof String) {
                return (String) ref;
            }
            byte[] byteArray = (byte[]) ref;
            String s = Internal.toStringUtf8(byteArray);
            if (Internal.isValidUtf8(byteArray)) {
                this.macroReference_ = s;
            }
            return s;
        }

        public byte[] getMacroReferenceAsBytes() {
            String ref = this.macroReference_;
            if (!(ref instanceof String)) {
                return (byte[]) ref;
            }
            byte[] byteArray = Internal.toByteArray(ref);
            this.macroReference_ = byteArray;
            return byteArray;
        }

        public Value setMacroReference(String value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= MAP_KEY_FIELD_NUMBER;
            this.macroReference_ = value;
            return this;
        }

        public Value setMacroReferenceAsBytes(byte[] value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= MAP_KEY_FIELD_NUMBER;
            this.macroReference_ = value;
            return this;
        }

        public Value clearMacroReference() {
            assertMutable();
            this.bitField0_ &= -5;
            this.macroReference_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public boolean hasFunctionId() {
            return (this.bitField0_ & INTEGER_FIELD_NUMBER) == INTEGER_FIELD_NUMBER;
        }

        public String getFunctionId() {
            Object ref = this.functionId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            byte[] byteArray = (byte[]) ref;
            String s = Internal.toStringUtf8(byteArray);
            if (Internal.isValidUtf8(byteArray)) {
                this.functionId_ = s;
            }
            return s;
        }

        public byte[] getFunctionIdAsBytes() {
            String ref = this.functionId_;
            if (!(ref instanceof String)) {
                return (byte[]) ref;
            }
            byte[] byteArray = Internal.toByteArray(ref);
            this.functionId_ = byteArray;
            return byteArray;
        }

        public Value setFunctionId(String value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= INTEGER_FIELD_NUMBER;
            this.functionId_ = value;
            return this;
        }

        public Value setFunctionIdAsBytes(byte[] value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= INTEGER_FIELD_NUMBER;
            this.functionId_ = value;
            return this;
        }

        public Value clearFunctionId() {
            assertMutable();
            this.bitField0_ &= -9;
            this.functionId_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public boolean hasInteger() {
            return (this.bitField0_ & 16) == 16;
        }

        public long getInteger() {
            return this.integer_;
        }

        public Value setInteger(long value) {
            assertMutable();
            this.bitField0_ |= 16;
            this.integer_ = value;
            return this;
        }

        public Value clearInteger() {
            assertMutable();
            this.bitField0_ &= -17;
            this.integer_ = 0;
            return this;
        }

        public boolean hasBoolean() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean getBoolean() {
            return this.boolean_;
        }

        public Value setBoolean(boolean value) {
            assertMutable();
            this.bitField0_ |= 32;
            this.boolean_ = value;
            return this;
        }

        public Value clearBoolean() {
            assertMutable();
            this.bitField0_ &= -33;
            this.boolean_ = false;
            return this;
        }

        private void ensureTemplateTokenInitialized() {
            if (this.templateToken_ == null) {
                this.templateToken_ = new ArrayList();
            }
        }

        public int getTemplateTokenCount() {
            return this.templateToken_ == null ? 0 : this.templateToken_.size();
        }

        public List<Value> getTemplateTokenList() {
            if (this.templateToken_ == null) {
                return Collections.emptyList();
            }
            return Collections.unmodifiableList(this.templateToken_);
        }

        public List<Value> getMutableTemplateTokenList() {
            assertMutable();
            ensureTemplateTokenInitialized();
            return this.templateToken_;
        }

        public Value getTemplateToken(int index) {
            return (Value) this.templateToken_.get(index);
        }

        public Value getMutableTemplateToken(int index) {
            return (Value) this.templateToken_.get(index);
        }

        public Value addTemplateToken() {
            assertMutable();
            ensureTemplateTokenInitialized();
            Value value = newMessage();
            this.templateToken_.add(value);
            return value;
        }

        public Value addTemplateToken(Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            ensureTemplateTokenInitialized();
            this.templateToken_.add(value);
            return this;
        }

        public Value addAllTemplateToken(Iterable<? extends Value> values) {
            assertMutable();
            ensureTemplateTokenInitialized();
            AbstractMutableMessageLite.addAll(values, this.templateToken_);
            return this;
        }

        public Value setTemplateToken(int index, Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            ensureTemplateTokenInitialized();
            this.templateToken_.set(index, value);
            return this;
        }

        public Value clearTemplateToken() {
            assertMutable();
            this.templateToken_ = null;
            return this;
        }

        private void ensureEscapingInitialized() {
            if (this.escaping_ == null) {
                this.escaping_ = new ArrayList();
            }
        }

        public List<Escaping> getEscapingList() {
            if (this.escaping_ == null) {
                return Collections.emptyList();
            }
            return Collections.unmodifiableList(this.escaping_);
        }

        public List<Escaping> getMutableEscapingList() {
            assertMutable();
            ensureEscapingInitialized();
            return this.escaping_;
        }

        public int getEscapingCount() {
            if (this.escaping_ == null) {
                return 0;
            }
            return this.escaping_.size();
        }

        public Escaping getEscaping(int index) {
            return (Escaping) this.escaping_.get(index);
        }

        public Value setEscaping(int index, Escaping value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            ensureEscapingInitialized();
            this.escaping_.set(index, value);
            return this;
        }

        public Value addEscaping(Escaping value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            ensureEscapingInitialized();
            this.escaping_.add(value);
            return this;
        }

        public Value addAllEscaping(Iterable<? extends Escaping> values) {
            assertMutable();
            ensureEscapingInitialized();
            AbstractMutableMessageLite.addAll(values, this.escaping_);
            return this;
        }

        public Value clearEscaping() {
            assertMutable();
            this.escaping_ = null;
            return this;
        }

        public boolean hasContainsReferences() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean getContainsReferences() {
            return this.containsReferences_;
        }

        public Value setContainsReferences(boolean value) {
            assertMutable();
            this.bitField0_ |= 64;
            this.containsReferences_ = value;
            return this;
        }

        public Value clearContainsReferences() {
            assertMutable();
            this.bitField0_ &= -65;
            this.containsReferences_ = false;
            return this;
        }

        public final boolean isInitialized() {
            if (!hasType()) {
                return false;
            }
            int i;
            for (i = 0; i < getListItemCount(); i += TYPE_FIELD_NUMBER) {
                if (!getListItem(i).isInitialized()) {
                    return false;
                }
            }
            for (i = 0; i < getMapKeyCount(); i += TYPE_FIELD_NUMBER) {
                if (!getMapKey(i).isInitialized()) {
                    return false;
                }
            }
            for (i = 0; i < getMapValueCount(); i += TYPE_FIELD_NUMBER) {
                if (!getMapValue(i).isInitialized()) {
                    return false;
                }
            }
            for (i = 0; i < getTemplateTokenCount(); i += TYPE_FIELD_NUMBER) {
                if (!getTemplateToken(i).isInitialized()) {
                    return false;
                }
            }
            if (extensionsAreInitialized()) {
                return true;
            }
            return false;
        }

        public Value clone() {
            return newMessageForType().mergeFrom(this);
        }

        public Value mergeFrom(Value other) {
            if (this == other) {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (other != getDefaultInstance()) {
                byte[] ba;
                if (other.hasType()) {
                    setType(other.getType());
                }
                if (other.hasString()) {
                    this.bitField0_ |= STRING_FIELD_NUMBER;
                    if (other.string_ instanceof String) {
                        this.string_ = other.string_;
                    } else {
                        ba = (byte[]) other.string_;
                        this.string_ = Arrays.copyOf(ba, ba.length);
                    }
                }
                if (!(other.listItem_ == null || other.listItem_.isEmpty())) {
                    ensureListItemInitialized();
                    AbstractMutableMessageLite.addAll(other.listItem_, this.listItem_);
                }
                if (!(other.mapKey_ == null || other.mapKey_.isEmpty())) {
                    ensureMapKeyInitialized();
                    AbstractMutableMessageLite.addAll(other.mapKey_, this.mapKey_);
                }
                if (!(other.mapValue_ == null || other.mapValue_.isEmpty())) {
                    ensureMapValueInitialized();
                    AbstractMutableMessageLite.addAll(other.mapValue_, this.mapValue_);
                }
                if (other.hasMacroReference()) {
                    this.bitField0_ |= MAP_KEY_FIELD_NUMBER;
                    if (other.macroReference_ instanceof String) {
                        this.macroReference_ = other.macroReference_;
                    } else {
                        ba = (byte[]) other.macroReference_;
                        this.macroReference_ = Arrays.copyOf(ba, ba.length);
                    }
                }
                if (other.hasFunctionId()) {
                    this.bitField0_ |= INTEGER_FIELD_NUMBER;
                    if (other.functionId_ instanceof String) {
                        this.functionId_ = other.functionId_;
                    } else {
                        ba = (byte[]) other.functionId_;
                        this.functionId_ = Arrays.copyOf(ba, ba.length);
                    }
                }
                if (other.hasInteger()) {
                    setInteger(other.getInteger());
                }
                if (other.hasContainsReferences()) {
                    setContainsReferences(other.getContainsReferences());
                }
                if (!(other.escaping_ == null || other.escaping_.isEmpty())) {
                    ensureEscapingInitialized();
                    this.escaping_.addAll(other.escaping_);
                }
                if (!(other.templateToken_ == null || other.templateToken_.isEmpty())) {
                    ensureTemplateTokenInitialized();
                    AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
                }
                if (other.hasBoolean()) {
                    setBoolean(other.getBoolean());
                }
                mergeExtensionFields(other);
                this.unknownFields = this.unknownFields.concat(other.unknownFields);
            }
            return this;
        }

        public boolean mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) {
            assertMutable();
            try {
                OutputStream unknownFieldsOutput = ByteString.newOutput();
                CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    int rawValue;
                    Escaping value;
                    switch (tag) {
                        case DragSortController.ON_DOWN /*0*/:
                            done = true;
                            break;
                        case INTEGER_FIELD_NUMBER /*8*/:
                            rawValue = input.readEnum();
                            Type value2 = Type.valueOf(rawValue);
                            if (value2 != null) {
                                this.bitField0_ |= TYPE_FIELD_NUMBER;
                                this.type_ = value2;
                                break;
                            }
                            unknownFieldsCodedOutput.writeRawVarint32(tag);
                            unknownFieldsCodedOutput.writeRawVarint32(rawValue);
                            break;
                        case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                            this.bitField0_ |= STRING_FIELD_NUMBER;
                            this.string_ = input.readByteArray();
                            break;
                        case 26:
                            input.readMessage(addListItem(), extensionRegistry);
                            break;
                        case 34:
                            input.readMessage(addMapKey(), extensionRegistry);
                            break;
                        case 42:
                            input.readMessage(addMapValue(), extensionRegistry);
                            break;
                        case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                            this.bitField0_ |= MAP_KEY_FIELD_NUMBER;
                            this.macroReference_ = input.readByteArray();
                            break;
                        case 58:
                            this.bitField0_ |= INTEGER_FIELD_NUMBER;
                            this.functionId_ = input.readByteArray();
                            break;
                        case TransportMediator.FLAG_KEY_MEDIA_FAST_FORWARD /*64*/:
                            this.bitField0_ |= 16;
                            this.integer_ = input.readInt64();
                            break;
                        case 72:
                            this.bitField0_ |= 64;
                            this.containsReferences_ = input.readBool();
                            break;
                        case 80:
                            rawValue = input.readEnum();
                            value = Escaping.valueOf(rawValue);
                            if (value != null) {
                                if (this.escaping_ == null) {
                                    this.escaping_ = new ArrayList();
                                }
                                this.escaping_.add(value);
                                break;
                            }
                            unknownFieldsCodedOutput.writeRawVarint32(tag);
                            unknownFieldsCodedOutput.writeRawVarint32(rawValue);
                            break;
                        case 82:
                            int oldLimit = input.pushLimit(input.readRawVarint32());
                            while (input.getBytesUntilLimit() > 0) {
                                rawValue = input.readEnum();
                                value = Escaping.valueOf(rawValue);
                                if (value == null) {
                                    unknownFieldsCodedOutput.writeRawVarint32(tag);
                                    unknownFieldsCodedOutput.writeRawVarint32(rawValue);
                                } else {
                                    if (this.escaping_ == null) {
                                        this.escaping_ = new ArrayList();
                                    }
                                    this.escaping_.add(value);
                                }
                            }
                            input.popLimit(oldLimit);
                            break;
                        case AdSize.LARGE_AD_HEIGHT /*90*/:
                            input.readMessage(addTemplateToken(), extensionRegistry);
                            break;
                        case 96:
                            this.bitField0_ |= 32;
                            this.boolean_ = input.readBool();
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
                                done = true;
                                break;
                            }
                            break;
                    }
                }
                unknownFieldsCodedOutput.flush();
                this.unknownFields = unknownFieldsOutput.toByteString();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        public void writeToWithCachedSizes(CodedOutputStream output) throws IOException {
            int i;
            int bytesWrittenBefore = output.getTotalBytesWritten();
            ExtensionWriter extensionWriter = newExtensionWriter();
            output.writeEnum(TYPE_FIELD_NUMBER, this.type_.getNumber());
            if ((this.bitField0_ & STRING_FIELD_NUMBER) == STRING_FIELD_NUMBER) {
                output.writeByteArray(STRING_FIELD_NUMBER, getStringAsBytes());
            }
            if (this.listItem_ != null) {
                for (i = 0; i < this.listItem_.size(); i += TYPE_FIELD_NUMBER) {
                    output.writeMessageWithCachedSizes(LIST_ITEM_FIELD_NUMBER, (MutableMessageLite) this.listItem_.get(i));
                }
            }
            if (this.mapKey_ != null) {
                for (i = 0; i < this.mapKey_.size(); i += TYPE_FIELD_NUMBER) {
                    output.writeMessageWithCachedSizes(MAP_KEY_FIELD_NUMBER, (MutableMessageLite) this.mapKey_.get(i));
                }
            }
            if (this.mapValue_ != null) {
                for (i = 0; i < this.mapValue_.size(); i += TYPE_FIELD_NUMBER) {
                    output.writeMessageWithCachedSizes(MAP_VALUE_FIELD_NUMBER, (MutableMessageLite) this.mapValue_.get(i));
                }
            }
            if ((this.bitField0_ & MAP_KEY_FIELD_NUMBER) == MAP_KEY_FIELD_NUMBER) {
                output.writeByteArray(MACRO_REFERENCE_FIELD_NUMBER, getMacroReferenceAsBytes());
            }
            if ((this.bitField0_ & INTEGER_FIELD_NUMBER) == INTEGER_FIELD_NUMBER) {
                output.writeByteArray(FUNCTION_ID_FIELD_NUMBER, getFunctionIdAsBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                output.writeInt64(INTEGER_FIELD_NUMBER, this.integer_);
            }
            if ((this.bitField0_ & 64) == 64) {
                output.writeBool(CONTAINS_REFERENCES_FIELD_NUMBER, this.containsReferences_);
            }
            if (this.escaping_ != null) {
                for (i = 0; i < this.escaping_.size(); i += TYPE_FIELD_NUMBER) {
                    output.writeEnum(ESCAPING_FIELD_NUMBER, ((Escaping) this.escaping_.get(i)).getNumber());
                }
            }
            if (this.templateToken_ != null) {
                for (i = 0; i < this.templateToken_.size(); i += TYPE_FIELD_NUMBER) {
                    output.writeMessageWithCachedSizes(TEMPLATE_TOKEN_FIELD_NUMBER, (MutableMessageLite) this.templateToken_.get(i));
                }
            }
            if ((this.bitField0_ & 32) == 32) {
                output.writeBool(BOOLEAN_FIELD_NUMBER, this.boolean_);
            }
            extensionWriter.writeUntil(DriveFile.MODE_WRITE_ONLY, output);
            output.writeRawBytes(this.unknownFields);
            if (getCachedSize() != output.getTotalBytesWritten() - bytesWrittenBefore) {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            }
        }

        public int getSerializedSize() {
            int i;
            int size = 0 + CodedOutputStream.computeEnumSize(TYPE_FIELD_NUMBER, this.type_.getNumber());
            if ((this.bitField0_ & STRING_FIELD_NUMBER) == STRING_FIELD_NUMBER) {
                size += CodedOutputStream.computeByteArraySize(STRING_FIELD_NUMBER, getStringAsBytes());
            }
            if (this.listItem_ != null) {
                for (i = 0; i < this.listItem_.size(); i += TYPE_FIELD_NUMBER) {
                    size += CodedOutputStream.computeMessageSize(LIST_ITEM_FIELD_NUMBER, (MessageLite) this.listItem_.get(i));
                }
            }
            if (this.mapKey_ != null) {
                for (i = 0; i < this.mapKey_.size(); i += TYPE_FIELD_NUMBER) {
                    size += CodedOutputStream.computeMessageSize(MAP_KEY_FIELD_NUMBER, (MessageLite) this.mapKey_.get(i));
                }
            }
            if (this.mapValue_ != null) {
                for (i = 0; i < this.mapValue_.size(); i += TYPE_FIELD_NUMBER) {
                    size += CodedOutputStream.computeMessageSize(MAP_VALUE_FIELD_NUMBER, (MessageLite) this.mapValue_.get(i));
                }
            }
            if ((this.bitField0_ & MAP_KEY_FIELD_NUMBER) == MAP_KEY_FIELD_NUMBER) {
                size += CodedOutputStream.computeByteArraySize(MACRO_REFERENCE_FIELD_NUMBER, getMacroReferenceAsBytes());
            }
            if ((this.bitField0_ & INTEGER_FIELD_NUMBER) == INTEGER_FIELD_NUMBER) {
                size += CodedOutputStream.computeByteArraySize(FUNCTION_ID_FIELD_NUMBER, getFunctionIdAsBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                size += CodedOutputStream.computeInt64Size(INTEGER_FIELD_NUMBER, this.integer_);
            }
            if ((this.bitField0_ & 32) == 32) {
                size += CodedOutputStream.computeBoolSize(BOOLEAN_FIELD_NUMBER, this.boolean_);
            }
            if (this.templateToken_ != null) {
                for (i = 0; i < this.templateToken_.size(); i += TYPE_FIELD_NUMBER) {
                    size += CodedOutputStream.computeMessageSize(TEMPLATE_TOKEN_FIELD_NUMBER, (MessageLite) this.templateToken_.get(i));
                }
            }
            if (this.escaping_ != null && this.escaping_.size() > 0) {
                int dataSize = 0;
                for (i = 0; i < this.escaping_.size(); i += TYPE_FIELD_NUMBER) {
                    dataSize += CodedOutputStream.computeEnumSizeNoTag(((Escaping) this.escaping_.get(i)).getNumber());
                }
                size = (size + dataSize) + (this.escaping_.size() * TYPE_FIELD_NUMBER);
            }
            if ((this.bitField0_ & 64) == 64) {
                size += CodedOutputStream.computeBoolSize(CONTAINS_REFERENCES_FIELD_NUMBER, this.containsReferences_);
            }
            size = (size + extensionsSerializedSize()) + this.unknownFields.size();
            this.cachedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public Value clear() {
            assertMutable();
            super.clear();
            this.type_ = Type.STRING;
            this.bitField0_ &= -2;
            this.string_ = Internal.EMPTY_BYTE_ARRAY;
            this.bitField0_ &= -3;
            this.listItem_ = null;
            this.mapKey_ = null;
            this.mapValue_ = null;
            this.macroReference_ = Internal.EMPTY_BYTE_ARRAY;
            this.bitField0_ &= -5;
            this.functionId_ = Internal.EMPTY_BYTE_ARRAY;
            this.bitField0_ &= -9;
            this.integer_ = 0;
            this.bitField0_ &= -17;
            this.boolean_ = false;
            this.bitField0_ &= -33;
            this.templateToken_ = null;
            this.escaping_ = null;
            this.containsReferences_ = false;
            this.bitField0_ &= -65;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Value)) {
                return super.equals(obj);
            }
            Value other = (Value) obj;
            boolean result = true && hasType() == other.hasType();
            if (hasType()) {
                result = result && getType() == other.getType();
            }
            if (result && hasString() == other.hasString()) {
                result = true;
            } else {
                result = false;
            }
            if (hasString()) {
                if (result && getString().equals(other.getString())) {
                    result = true;
                } else {
                    result = false;
                }
            }
            if (result && getListItemList().equals(other.getListItemList())) {
                result = true;
            } else {
                result = false;
            }
            if (result && getMapKeyList().equals(other.getMapKeyList())) {
                result = true;
            } else {
                result = false;
            }
            if (result && getMapValueList().equals(other.getMapValueList())) {
                result = true;
            } else {
                result = false;
            }
            if (result && hasMacroReference() == other.hasMacroReference()) {
                result = true;
            } else {
                result = false;
            }
            if (hasMacroReference()) {
                if (result && getMacroReference().equals(other.getMacroReference())) {
                    result = true;
                } else {
                    result = false;
                }
            }
            if (result && hasFunctionId() == other.hasFunctionId()) {
                result = true;
            } else {
                result = false;
            }
            if (hasFunctionId()) {
                if (result && getFunctionId().equals(other.getFunctionId())) {
                    result = true;
                } else {
                    result = false;
                }
            }
            if (result && hasInteger() == other.hasInteger()) {
                result = true;
            } else {
                result = false;
            }
            if (hasInteger()) {
                if (result && getInteger() == other.getInteger()) {
                    result = true;
                } else {
                    result = false;
                }
            }
            if (result && hasBoolean() == other.hasBoolean()) {
                result = true;
            } else {
                result = false;
            }
            if (hasBoolean()) {
                if (result && getBoolean() == other.getBoolean()) {
                    result = true;
                } else {
                    result = false;
                }
            }
            if (result && getTemplateTokenList().equals(other.getTemplateTokenList())) {
                result = true;
            } else {
                result = false;
            }
            if (result && getEscapingList().equals(other.getEscapingList())) {
                result = true;
            } else {
                result = false;
            }
            if (result && hasContainsReferences() == other.hasContainsReferences()) {
                result = true;
            } else {
                result = false;
            }
            if (hasContainsReferences()) {
                if (result && getContainsReferences() == other.getContainsReferences()) {
                    result = true;
                } else {
                    result = false;
                }
            }
            return result;
        }

        public int hashCode() {
            int hash = 41;
            if (hasType()) {
                hash = 1517 + TYPE_FIELD_NUMBER;
                hash = 80454 + Internal.hashEnum(getType());
            }
            if (hasString()) {
                hash = (((hash * 37) + STRING_FIELD_NUMBER) * 53) + getString().hashCode();
            }
            if (getListItemCount() > 0) {
                hash = (((hash * 37) + LIST_ITEM_FIELD_NUMBER) * 53) + getListItemList().hashCode();
            }
            if (getMapKeyCount() > 0) {
                hash = (((hash * 37) + MAP_KEY_FIELD_NUMBER) * 53) + getMapKeyList().hashCode();
            }
            if (getMapValueCount() > 0) {
                hash = (((hash * 37) + MAP_VALUE_FIELD_NUMBER) * 53) + getMapValueList().hashCode();
            }
            if (hasMacroReference()) {
                hash = (((hash * 37) + MACRO_REFERENCE_FIELD_NUMBER) * 53) + getMacroReference().hashCode();
            }
            if (hasFunctionId()) {
                hash = (((hash * 37) + FUNCTION_ID_FIELD_NUMBER) * 53) + getFunctionId().hashCode();
            }
            if (hasInteger()) {
                hash = (((hash * 37) + INTEGER_FIELD_NUMBER) * 53) + Internal.hashLong(getInteger());
            }
            if (hasBoolean()) {
                hash = (((hash * 37) + BOOLEAN_FIELD_NUMBER) * 53) + Internal.hashBoolean(getBoolean());
            }
            if (getTemplateTokenCount() > 0) {
                hash = (((hash * 37) + TEMPLATE_TOKEN_FIELD_NUMBER) * 53) + getTemplateTokenList().hashCode();
            }
            if (getEscapingCount() > 0) {
                hash = (((hash * 37) + ESCAPING_FIELD_NUMBER) * 53) + Internal.hashEnumList(getEscapingList());
            }
            if (hasContainsReferences()) {
                hash = (((hash * 37) + CONTAINS_REFERENCES_FIELD_NUMBER) * 53) + Internal.hashBoolean(getContainsReferences());
            }
            return (hash * 29) + this.unknownFields.hashCode();
        }

        static {
            immutableDefault = null;
            defaultInstance = new Value(true);
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
            PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        }

        protected MessageLite internalImmutableDefault() {
            if (immutableDefault == null) {
                immutableDefault = GeneratedMutableMessageLite.internalImmutableDefault("com.google.analytics.midtier.proto.containertag.TypeSystem$Value");
            }
            return immutableDefault;
        }
    }

    private MutableTypeSystem() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    static {
    }
}
