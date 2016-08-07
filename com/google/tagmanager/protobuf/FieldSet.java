package com.google.tagmanager.protobuf;

import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.tagmanager.protobuf.Internal.EnumLite;
import com.google.tagmanager.protobuf.Internal.EnumLiteMap;
import com.google.tagmanager.protobuf.MessageLite.Builder;
import com.google.tagmanager.protobuf.WireFormat.FieldType;
import com.google.tagmanager.protobuf.WireFormat.JavaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> {
    private static final FieldSet DEFAULT_INSTANCE;
    private final SmallSortedMap<FieldDescriptorType, Object> fields;
    private boolean hasLazyField;
    private boolean isImmutable;

    /* renamed from: com.google.tagmanager.protobuf.FieldSet.1 */
    static /* synthetic */ class C04521 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

        static {
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[FieldType.values().length];
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.BYTES.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SFIXED32.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SFIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SINT32.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SINT64.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.GROUP.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = new int[JavaType.values().length];
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError e20) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError e21) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError e22) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError e23) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError e24) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError e25) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError e26) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError e27) {
            }
        }
    }

    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        EnumLiteMap<?> getEnumType();

        JavaType getLiteJavaType();

        FieldType getLiteType();

        int getNumber();

        Builder internalMergeFrom(Builder builder, MessageLite messageLite);

        MutableMessageLite internalMergeFrom(MutableMessageLite mutableMessageLite, MutableMessageLite mutableMessageLite2);

        boolean isPacked();

        boolean isRepeated();
    }

    private FieldSet() {
        this.hasLazyField = false;
        this.fields = SmallSortedMap.newFieldMap(16);
    }

    private FieldSet(boolean dummy) {
        this.hasLazyField = false;
        this.fields = SmallSortedMap.newFieldMap(0);
        makeImmutable();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return DEFAULT_INSTANCE;
    }

    static {
        DEFAULT_INSTANCE = new FieldSet(true);
    }

    public void makeImmutable() {
        if (!this.isImmutable) {
            this.fields.makeImmutable();
            this.isImmutable = true;
        }
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public FieldSet<FieldDescriptorType> clone() {
        FieldSet<FieldDescriptorType> clone = newFieldSet();
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            Entry<FieldDescriptorType, Object> entry = this.fields.getArrayEntryAt(i);
            clone.setField((FieldDescriptorLite) entry.getKey(), entry.getValue());
        }
        for (Entry<FieldDescriptorType, Object> entry2 : this.fields.getOverflowEntries()) {
            clone.setField((FieldDescriptorLite) entry2.getKey(), entry2.getValue());
        }
        clone.hasLazyField = this.hasLazyField;
        return clone;
    }

    private Object convertToImmutable(FieldDescriptorType descriptor, Object value) {
        Iterator i$;
        if (descriptor.getLiteJavaType() == JavaType.MESSAGE) {
            if (descriptor.isRepeated()) {
                List<Object> mutableMessages = (List) value;
                Object arrayList = new ArrayList();
                i$ = mutableMessages.iterator();
                while (i$.hasNext()) {
                    arrayList.add(((MutableMessageLite) i$.next()).immutableCopy());
                }
                return arrayList;
            } else if (value instanceof LazyField) {
                return ((MutableMessageLite) ((LazyField) value).getValue()).immutableCopy();
            } else {
                return ((MutableMessageLite) value).immutableCopy();
            }
        } else if (descriptor.getLiteJavaType() != JavaType.BYTE_STRING) {
            return value;
        } else {
            if (!descriptor.isRepeated()) {
                return ByteString.copyFrom((byte[]) value);
            }
            List<Object> mutableFields = (List) value;
            List<Object> immutableFields = new ArrayList();
            i$ = mutableFields.iterator();
            while (i$.hasNext()) {
                immutableFields.add(ByteString.copyFrom((byte[]) i$.next()));
            }
            return immutableFields;
        }
    }

    private Object convertToMutable(FieldDescriptorType descriptor, Object value) {
        Iterator i$;
        if (descriptor.getLiteJavaType() == JavaType.MESSAGE) {
            if (descriptor.isRepeated()) {
                Object arrayList = new ArrayList();
                i$ = ((List) value).iterator();
                while (i$.hasNext()) {
                    arrayList.add(((MessageLite) i$.next()).mutableCopy());
                }
                return arrayList;
            } else if (value instanceof LazyField) {
                return ((LazyField) value).getValue().mutableCopy();
            } else {
                return ((MessageLite) value).mutableCopy();
            }
        } else if (descriptor.getLiteJavaType() != JavaType.BYTE_STRING) {
            return value;
        } else {
            if (!descriptor.isRepeated()) {
                return ((ByteString) value).toByteArray();
            }
            List<Object> immutableFields = (List) value;
            List<Object> mutableFields = new ArrayList();
            i$ = immutableFields.iterator();
            while (i$.hasNext()) {
                mutableFields.add(((ByteString) i$.next()).toByteArray());
            }
            return mutableFields;
        }
    }

    public FieldSet<FieldDescriptorType> cloneWithAllFieldsToImmutable() {
        FieldSet<FieldDescriptorType> clone = newFieldSet();
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            Entry<FieldDescriptorType, Object> entry = this.fields.getArrayEntryAt(i);
            FieldDescriptorLite descriptor = (FieldDescriptorLite) entry.getKey();
            clone.setField(descriptor, convertToImmutable(descriptor, entry.getValue()));
        }
        for (Entry<FieldDescriptorType, Object> entry2 : this.fields.getOverflowEntries()) {
            descriptor = (FieldDescriptorLite) entry2.getKey();
            clone.setField(descriptor, convertToImmutable(descriptor, entry2.getValue()));
        }
        clone.hasLazyField = false;
        return clone;
    }

    public FieldSet<FieldDescriptorType> cloneWithAllFieldsToMutable() {
        FieldSet<FieldDescriptorType> clone = newFieldSet();
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            Entry<FieldDescriptorType, Object> entry = this.fields.getArrayEntryAt(i);
            FieldDescriptorLite descriptor = (FieldDescriptorLite) entry.getKey();
            clone.setField(descriptor, convertToMutable(descriptor, entry.getValue()));
        }
        for (Entry<FieldDescriptorType, Object> entry2 : this.fields.getOverflowEntries()) {
            descriptor = (FieldDescriptorLite) entry2.getKey();
            clone.setField(descriptor, convertToMutable(descriptor, entry2.getValue()));
        }
        clone.hasLazyField = false;
        return clone;
    }

    public void clear() {
        this.fields.clear();
        this.hasLazyField = false;
    }

    public Map<FieldDescriptorType, Object> getAllFields() {
        if (this.hasLazyField) {
            SmallSortedMap<FieldDescriptorType, Object> result = SmallSortedMap.newFieldMap(16);
            for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
                cloneFieldEntry(result, this.fields.getArrayEntryAt(i));
            }
            for (Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
                cloneFieldEntry(result, entry);
            }
            if (!this.fields.isImmutable()) {
                return result;
            }
            result.makeImmutable();
            return result;
        }
        return this.fields.isImmutable() ? this.fields : Collections.unmodifiableMap(this.fields);
    }

    private void cloneFieldEntry(Map<FieldDescriptorType, Object> map, Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorLite key = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            map.put(key, ((LazyField) value).getValue());
        } else {
            map.put(key, value);
        }
    }

    public Iterator<Entry<FieldDescriptorType, Object>> iterator() {
        if (this.hasLazyField) {
            return new LazyIterator(this.fields.entrySet().iterator());
        }
        return this.fields.entrySet().iterator();
    }

    public boolean hasField(FieldDescriptorType descriptor) {
        if (!descriptor.isRepeated()) {
            return this.fields.get(descriptor) != null;
        } else {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
    }

    public Object getField(FieldDescriptorType descriptor) {
        Object obj = this.fields.get(descriptor);
        if (obj instanceof LazyField) {
            return ((LazyField) obj).getValue();
        }
        return obj;
    }

    public void setField(FieldDescriptorType descriptor, Object value) {
        if (!descriptor.isRepeated()) {
            verifyType(descriptor.getLiteType(), value);
        } else if (value instanceof List) {
            List<Object> newList = new ArrayList();
            newList.addAll((List) value);
            for (Object element : newList) {
                verifyType(descriptor.getLiteType(), element);
            }
            value = newList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (value instanceof LazyField) {
            this.hasLazyField = true;
        }
        this.fields.put((Comparable) descriptor, value);
    }

    public void clearField(FieldDescriptorType descriptor) {
        this.fields.remove(descriptor);
        if (this.fields.isEmpty()) {
            this.hasLazyField = false;
        }
    }

    public int getRepeatedFieldCount(FieldDescriptorType descriptor) {
        if (descriptor.isRepeated()) {
            Object value = getField(descriptor);
            if (value == null) {
                return 0;
            }
            return ((List) value).size();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public Object getRepeatedField(FieldDescriptorType descriptor, int index) {
        if (descriptor.isRepeated()) {
            Object value = getField(descriptor);
            if (value != null) {
                return ((List) value).get(index);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void setRepeatedField(FieldDescriptorType descriptor, int index, Object value) {
        if (descriptor.isRepeated()) {
            Object list = getField(descriptor);
            if (list == null) {
                throw new IndexOutOfBoundsException();
            }
            verifyType(descriptor.getLiteType(), value);
            ((List) list).set(index, value);
            return;
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void addRepeatedField(FieldDescriptorType descriptor, Object value) {
        if (descriptor.isRepeated()) {
            List<Object> list;
            verifyType(descriptor.getLiteType(), value);
            Object existingValue = getField(descriptor);
            if (existingValue == null) {
                list = new ArrayList();
                this.fields.put((Comparable) descriptor, (Object) list);
            } else {
                list = (List) existingValue;
            }
            list.add(value);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    private static void verifyType(FieldType type, Object value) {
        if (value == null) {
            throw new NullPointerException();
        }
        boolean isValid = false;
        switch (C04521.$SwitchMap$com$google$protobuf$WireFormat$JavaType[type.getJavaType().ordinal()]) {
            case Value.TYPE_FIELD_NUMBER /*1*/:
                isValid = value instanceof Integer;
                break;
            case Value.STRING_FIELD_NUMBER /*2*/:
                isValid = value instanceof Long;
                break;
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                isValid = value instanceof Float;
                break;
            case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                isValid = value instanceof Double;
                break;
            case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                isValid = value instanceof Boolean;
                break;
            case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                isValid = value instanceof String;
                break;
            case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                if ((value instanceof ByteString) || (value instanceof byte[])) {
                    isValid = true;
                } else {
                    isValid = false;
                }
                break;
            case Value.INTEGER_FIELD_NUMBER /*8*/:
                if ((value instanceof Integer) || (value instanceof EnumLite)) {
                    isValid = true;
                } else {
                    isValid = false;
                }
                break;
            case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                isValid = (value instanceof MessageLite) || (value instanceof LazyField);
                break;
        }
        if (!isValid) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public boolean isInitialized() {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            if (!isInitialized(this.fields.getArrayEntryAt(i))) {
                return false;
            }
        }
        for (Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
            if (!isInitialized(entry)) {
                return false;
            }
        }
        return true;
    }

    private boolean isInitialized(Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorLite descriptor = (FieldDescriptorLite) entry.getKey();
        if (descriptor.getLiteJavaType() == JavaType.MESSAGE) {
            if (descriptor.isRepeated()) {
                for (MessageLite element : (List) entry.getValue()) {
                    if (!element.isInitialized()) {
                        return false;
                    }
                }
            }
            Object value = entry.getValue();
            if (value instanceof MessageLite) {
                if (!((MessageLite) value).isInitialized()) {
                    return false;
                }
            } else if (value instanceof LazyField) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    static int getWireFormatForFieldType(FieldType type, boolean isPacked) {
        if (isPacked) {
            return 2;
        }
        return type.getWireType();
    }

    public void mergeFrom(FieldSet<FieldDescriptorType> other) {
        for (int i = 0; i < other.fields.getNumArrayEntries(); i++) {
            mergeFromField(other.fields.getArrayEntryAt(i));
        }
        for (Entry<FieldDescriptorType, Object> entry : other.fields.getOverflowEntries()) {
            mergeFromField(entry);
        }
    }

    private void mergeFromField(Entry<FieldDescriptorType, Object> entry) {
        Comparable descriptor = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).getValue();
        }
        Object value2;
        if (descriptor.isRepeated()) {
            value2 = getField(descriptor);
            if (value2 == null) {
                this.fields.put(descriptor, new ArrayList((List) value));
            } else {
                ((List) value2).addAll((List) value);
            }
        } else if (descriptor.getLiteJavaType() == JavaType.MESSAGE) {
            value2 = getField(descriptor);
            if (value2 == null) {
                this.fields.put(descriptor, value);
                return;
            }
            if (value2 instanceof MutableMessageLite) {
                value2 = descriptor.internalMergeFrom((MutableMessageLite) value2, (MutableMessageLite) value);
            } else {
                value2 = descriptor.internalMergeFrom(((MessageLite) value2).toBuilder(), (MessageLite) value).build();
            }
            this.fields.put(descriptor, value2);
        } else {
            this.fields.put(descriptor, value);
        }
    }

    public static Object readPrimitiveField(CodedInputStream input, FieldType type, boolean checkUtf8) throws IOException {
        switch (C04521.$SwitchMap$com$google$protobuf$WireFormat$FieldType[type.ordinal()]) {
            case Value.TYPE_FIELD_NUMBER /*1*/:
                return Double.valueOf(input.readDouble());
            case Value.STRING_FIELD_NUMBER /*2*/:
                return Float.valueOf(input.readFloat());
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                return Long.valueOf(input.readInt64());
            case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                return Long.valueOf(input.readUInt64());
            case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                return Integer.valueOf(input.readInt32());
            case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                return Long.valueOf(input.readFixed64());
            case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                return Integer.valueOf(input.readFixed32());
            case Value.INTEGER_FIELD_NUMBER /*8*/:
                return Boolean.valueOf(input.readBool());
            case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                if (checkUtf8) {
                    return input.readStringRequireUtf8();
                }
                return input.readString();
            case Value.ESCAPING_FIELD_NUMBER /*10*/:
                return input.readBytes();
            case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                return Integer.valueOf(input.readUInt32());
            case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                return Integer.valueOf(input.readSFixed32());
            case Resource.VERSION_FIELD_NUMBER /*13*/:
                return Long.valueOf(input.readSFixed64());
            case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                return Integer.valueOf(input.readSInt32());
            case Resource.REPORTING_SAMPLE_RATE_FIELD_NUMBER /*15*/:
                return Long.valueOf(input.readSInt64());
            case Resource.USAGE_CONTEXT_FIELD_NUMBER /*16*/:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case Resource.RESOURCE_FORMAT_VERSION_FIELD_NUMBER /*17*/:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static Object readPrimitiveFieldForMutable(CodedInputStream input, FieldType type, boolean checkUtf8) throws IOException {
        if (type == FieldType.BYTES) {
            return input.readByteArray();
        }
        return readPrimitiveField(input, type, checkUtf8);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            Entry<FieldDescriptorType, Object> entry = this.fields.getArrayEntryAt(i);
            writeField((FieldDescriptorLite) entry.getKey(), entry.getValue(), output);
        }
        for (Entry<FieldDescriptorType, Object> entry2 : this.fields.getOverflowEntries()) {
            writeField((FieldDescriptorLite) entry2.getKey(), entry2.getValue(), output);
        }
    }

    public void writeMessageSetTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            writeMessageSetTo(this.fields.getArrayEntryAt(i), output);
        }
        for (Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
            writeMessageSetTo(entry, output);
        }
    }

    private void writeMessageSetTo(Entry<FieldDescriptorType, Object> entry, CodedOutputStream output) throws IOException {
        FieldDescriptorLite descriptor = (FieldDescriptorLite) entry.getKey();
        if (descriptor.getLiteJavaType() != JavaType.MESSAGE || descriptor.isRepeated() || descriptor.isPacked()) {
            writeField(descriptor, entry.getValue(), output);
        } else {
            output.writeMessageSetExtension(((FieldDescriptorLite) entry.getKey()).getNumber(), (MessageLite) entry.getValue());
        }
    }

    private static void writeElement(CodedOutputStream output, FieldType type, int number, Object value) throws IOException {
        if (type != FieldType.GROUP) {
            output.writeTag(number, getWireFormatForFieldType(type, false));
            writeElementNoTag(output, type, value);
        } else if (Internal.isProto1Group((MessageLite) value)) {
            output.writeTag(number, 3);
            output.writeGroupNoTag((MessageLite) value);
        } else {
            output.writeGroup(number, (MessageLite) value);
        }
    }

    private static void writeElementNoTag(CodedOutputStream output, FieldType type, Object value) throws IOException {
        switch (C04521.$SwitchMap$com$google$protobuf$WireFormat$FieldType[type.ordinal()]) {
            case Value.TYPE_FIELD_NUMBER /*1*/:
                output.writeDoubleNoTag(((Double) value).doubleValue());
            case Value.STRING_FIELD_NUMBER /*2*/:
                output.writeFloatNoTag(((Float) value).floatValue());
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                output.writeInt64NoTag(((Long) value).longValue());
            case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                output.writeUInt64NoTag(((Long) value).longValue());
            case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                output.writeInt32NoTag(((Integer) value).intValue());
            case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                output.writeFixed64NoTag(((Long) value).longValue());
            case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                output.writeFixed32NoTag(((Integer) value).intValue());
            case Value.INTEGER_FIELD_NUMBER /*8*/:
                output.writeBoolNoTag(((Boolean) value).booleanValue());
            case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                output.writeStringNoTag((String) value);
            case Value.ESCAPING_FIELD_NUMBER /*10*/:
                if (value instanceof ByteString) {
                    output.writeBytesNoTag((ByteString) value);
                } else {
                    output.writeByteArrayNoTag((byte[]) value);
                }
            case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                output.writeUInt32NoTag(((Integer) value).intValue());
            case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                output.writeSFixed32NoTag(((Integer) value).intValue());
            case Resource.VERSION_FIELD_NUMBER /*13*/:
                output.writeSFixed64NoTag(((Long) value).longValue());
            case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                output.writeSInt32NoTag(((Integer) value).intValue());
            case Resource.REPORTING_SAMPLE_RATE_FIELD_NUMBER /*15*/:
                output.writeSInt64NoTag(((Long) value).longValue());
            case Resource.USAGE_CONTEXT_FIELD_NUMBER /*16*/:
                output.writeGroupNoTag((MessageLite) value);
            case Resource.RESOURCE_FORMAT_VERSION_FIELD_NUMBER /*17*/:
                output.writeMessageNoTag((MessageLite) value);
            case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                if (value instanceof EnumLite) {
                    output.writeEnumNoTag(((EnumLite) value).getNumber());
                } else {
                    output.writeEnumNoTag(((Integer) value).intValue());
                }
            default:
        }
    }

    public static void writeField(FieldDescriptorLite<?> descriptor, Object value, CodedOutputStream output) throws IOException {
        FieldType type = descriptor.getLiteType();
        int number = descriptor.getNumber();
        if (descriptor.isRepeated()) {
            List<?> valueList = (List) value;
            if (descriptor.isPacked()) {
                output.writeTag(number, 2);
                int dataSize = 0;
                for (Object element : valueList) {
                    dataSize += computeElementSizeNoTag(type, element);
                }
                output.writeRawVarint32(dataSize);
                for (Object element2 : valueList) {
                    writeElementNoTag(output, type, element2);
                }
                return;
            }
            for (Object element22 : valueList) {
                writeElement(output, type, number, element22);
            }
        } else if (value instanceof LazyField) {
            writeElement(output, type, number, ((LazyField) value).getValue());
        } else {
            writeElement(output, type, number, value);
        }
    }

    public int getSerializedSize() {
        int size = 0;
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            Entry<FieldDescriptorType, Object> entry = this.fields.getArrayEntryAt(i);
            size += computeFieldSize((FieldDescriptorLite) entry.getKey(), entry.getValue());
        }
        for (Entry<FieldDescriptorType, Object> entry2 : this.fields.getOverflowEntries()) {
            size += computeFieldSize((FieldDescriptorLite) entry2.getKey(), entry2.getValue());
        }
        return size;
    }

    public int getMessageSetSerializedSize() {
        int size = 0;
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            size += getMessageSetSerializedSize(this.fields.getArrayEntryAt(i));
        }
        for (Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
            size += getMessageSetSerializedSize(entry);
        }
        return size;
    }

    private int getMessageSetSerializedSize(Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorLite descriptor = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        if (descriptor.getLiteJavaType() != JavaType.MESSAGE || descriptor.isRepeated() || descriptor.isPacked()) {
            return computeFieldSize(descriptor, value);
        }
        if (value instanceof LazyField) {
            return CodedOutputStream.computeLazyFieldMessageSetExtensionSize(((FieldDescriptorLite) entry.getKey()).getNumber(), (LazyField) value);
        }
        return CodedOutputStream.computeMessageSetExtensionSize(((FieldDescriptorLite) entry.getKey()).getNumber(), (MessageLite) value);
    }

    private static int computeElementSize(FieldType type, int number, Object value) {
        int tagSize = CodedOutputStream.computeTagSize(number);
        if (type == FieldType.GROUP && !Internal.isProto1Group((MessageLite) value)) {
            tagSize *= 2;
        }
        return computeElementSizeNoTag(type, value) + tagSize;
    }

    private static int computeElementSizeNoTag(FieldType type, Object value) {
        switch (C04521.$SwitchMap$com$google$protobuf$WireFormat$FieldType[type.ordinal()]) {
            case Value.TYPE_FIELD_NUMBER /*1*/:
                return CodedOutputStream.computeDoubleSizeNoTag(((Double) value).doubleValue());
            case Value.STRING_FIELD_NUMBER /*2*/:
                return CodedOutputStream.computeFloatSizeNoTag(((Float) value).floatValue());
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                return CodedOutputStream.computeInt64SizeNoTag(((Long) value).longValue());
            case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) value).longValue());
            case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) value).intValue());
            case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                return CodedOutputStream.computeFixed64SizeNoTag(((Long) value).longValue());
            case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                return CodedOutputStream.computeFixed32SizeNoTag(((Integer) value).intValue());
            case Value.INTEGER_FIELD_NUMBER /*8*/:
                return CodedOutputStream.computeBoolSizeNoTag(((Boolean) value).booleanValue());
            case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                return CodedOutputStream.computeStringSizeNoTag((String) value);
            case Value.ESCAPING_FIELD_NUMBER /*10*/:
                if (value instanceof ByteString) {
                    return CodedOutputStream.computeBytesSizeNoTag((ByteString) value);
                }
                return CodedOutputStream.computeByteArraySizeNoTag((byte[]) value);
            case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) value).intValue());
            case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) value).intValue());
            case Resource.VERSION_FIELD_NUMBER /*13*/:
                return CodedOutputStream.computeSFixed64SizeNoTag(((Long) value).longValue());
            case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) value).intValue());
            case Resource.REPORTING_SAMPLE_RATE_FIELD_NUMBER /*15*/:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) value).longValue());
            case Resource.USAGE_CONTEXT_FIELD_NUMBER /*16*/:
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite) value);
            case Resource.RESOURCE_FORMAT_VERSION_FIELD_NUMBER /*17*/:
                if (value instanceof LazyField) {
                    return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) value);
                }
                return CodedOutputStream.computeMessageSizeNoTag((MessageLite) value);
            case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                if (value instanceof EnumLite) {
                    return CodedOutputStream.computeEnumSizeNoTag(((EnumLite) value).getNumber());
                }
                return CodedOutputStream.computeEnumSizeNoTag(((Integer) value).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int computeFieldSize(FieldDescriptorLite<?> descriptor, Object value) {
        FieldType type = descriptor.getLiteType();
        int number = descriptor.getNumber();
        if (!descriptor.isRepeated()) {
            return computeElementSize(type, number, value);
        }
        if (descriptor.isPacked()) {
            int dataSize = 0;
            for (Object element : (List) value) {
                dataSize += computeElementSizeNoTag(type, element);
            }
            return (CodedOutputStream.computeTagSize(number) + dataSize) + CodedOutputStream.computeRawVarint32Size(dataSize);
        }
        int size = 0;
        for (Object element2 : (List) value) {
            size += computeElementSize(type, number, element2);
        }
        return size;
    }
}
