package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.MutableTypeSystem;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Escaping;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Types {
    private static Boolean DEFAULT_BOOLEAN;
    private static Double DEFAULT_DOUBLE;
    private static Long DEFAULT_INT64;
    private static List<Object> DEFAULT_LIST;
    private static Map<Object, Object> DEFAULT_MAP;
    private static TypedNumber DEFAULT_NUMBER;
    private static final Object DEFAULT_OBJECT;
    private static String DEFAULT_STRING;
    private static Value DEFAULT_VALUE;

    /* renamed from: com.google.tagmanager.Types.1 */
    static /* synthetic */ class C04461 {
        static final /* synthetic */ int[] f52xa390a19;

        static {
            f52xa390a19 = new int[Type.values().length];
            try {
                f52xa390a19[Type.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f52xa390a19[Type.LIST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f52xa390a19[Type.MAP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f52xa390a19[Type.MACRO_REFERENCE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f52xa390a19[Type.FUNCTION_ID.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f52xa390a19[Type.INTEGER.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f52xa390a19[Type.TEMPLATE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f52xa390a19[Type.BOOLEAN.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    static {
        DEFAULT_OBJECT = null;
        DEFAULT_INT64 = new Long(0);
        DEFAULT_DOUBLE = new Double(0.0d);
        DEFAULT_NUMBER = TypedNumber.numberWithInt64(0);
        DEFAULT_STRING = new String("");
        DEFAULT_BOOLEAN = new Boolean(false);
        DEFAULT_LIST = new ArrayList(0);
        DEFAULT_MAP = new HashMap();
        DEFAULT_VALUE = objectToValue(DEFAULT_STRING);
    }

    private Types() {
    }

    public static Object getDefaultObject() {
        return DEFAULT_OBJECT;
    }

    public static Long getDefaultInt64() {
        return DEFAULT_INT64;
    }

    public static Double getDefaultDouble() {
        return DEFAULT_DOUBLE;
    }

    public static Boolean getDefaultBoolean() {
        return DEFAULT_BOOLEAN;
    }

    public static TypedNumber getDefaultNumber() {
        return DEFAULT_NUMBER;
    }

    public static String getDefaultString() {
        return DEFAULT_STRING;
    }

    public static List<Object> getDefaultList() {
        return DEFAULT_LIST;
    }

    public static Map<Object, Object> getDefaultMap() {
        return DEFAULT_MAP;
    }

    public static Value getDefaultValue() {
        return DEFAULT_VALUE;
    }

    public static String objectToString(Object o) {
        return o == null ? DEFAULT_STRING : o.toString();
    }

    public static TypedNumber objectToNumber(Object o) {
        if (o instanceof TypedNumber) {
            return (TypedNumber) o;
        }
        if (isInt64ableNumber(o)) {
            return TypedNumber.numberWithInt64(getInt64(o));
        }
        if (isDoubleableNumber(o)) {
            return TypedNumber.numberWithDouble(Double.valueOf(getDouble(o)));
        }
        return parseNumber(objectToString(o));
    }

    public static Long objectToInt64(Object o) {
        return isInt64ableNumber(o) ? Long.valueOf(getInt64(o)) : parseInt64(objectToString(o));
    }

    public static Double objectToDouble(Object o) {
        return isDoubleableNumber(o) ? Double.valueOf(getDouble(o)) : parseDouble(objectToString(o));
    }

    public static Boolean objectToBoolean(Object o) {
        return o instanceof Boolean ? (Boolean) o : parseBoolean(objectToString(o));
    }

    public static String valueToString(Value v) {
        return objectToString(valueToObject(v));
    }

    public static TypedNumber valueToNumber(Value v) {
        return objectToNumber(valueToObject(v));
    }

    public static Long valueToInt64(Value v) {
        return objectToInt64(valueToObject(v));
    }

    public static Double valueToDouble(Value v) {
        return objectToDouble(valueToObject(v));
    }

    public static Boolean valueToBoolean(Value v) {
        return objectToBoolean(valueToObject(v));
    }

    public static Value objectToValue(Object o) {
        Builder builder = Value.newBuilder();
        boolean containsRef = false;
        if (o instanceof Value) {
            return (Value) o;
        }
        if (o instanceof String) {
            builder.setType(Type.STRING).setString((String) o);
        } else if (o instanceof List) {
            builder.setType(Type.LIST);
            for (Object listObject : (List) o) {
                Value listValue = objectToValue(listObject);
                if (listValue == DEFAULT_VALUE) {
                    return DEFAULT_VALUE;
                }
                if (containsRef || listValue.getContainsReferences()) {
                    containsRef = true;
                } else {
                    containsRef = false;
                }
                builder.addListItem(listValue);
            }
        } else if (o instanceof Map) {
            builder.setType(Type.MAP);
            for (Entry<Object, Object> entry : ((Map) o).entrySet()) {
                Value key = objectToValue(entry.getKey());
                Value value = objectToValue(entry.getValue());
                if (key == DEFAULT_VALUE || value == DEFAULT_VALUE) {
                    return DEFAULT_VALUE;
                }
                if (containsRef || key.getContainsReferences() || value.getContainsReferences()) {
                    containsRef = true;
                } else {
                    containsRef = false;
                }
                builder.addMapKey(key);
                builder.addMapValue(value);
            }
        } else if (isDoubleableNumber(o)) {
            builder.setType(Type.STRING).setString(o.toString());
        } else if (isInt64ableNumber(o)) {
            builder.setType(Type.INTEGER).setInteger(getInt64(o));
        } else if (o instanceof Boolean) {
            builder.setType(Type.BOOLEAN).setBoolean(((Boolean) o).booleanValue());
        } else {
            Log.m1389e("Converting to Value from unknown object type: " + (o == null ? "null" : o.getClass().toString()));
            return DEFAULT_VALUE;
        }
        if (containsRef) {
            builder.setContainsReferences(true);
        }
        return builder.build();
    }

    public static Value functionIdToValue(String id) {
        return Value.newBuilder().setType(Type.FUNCTION_ID).setFunctionId(id).build();
    }

    public static Value macroReferenceToValue(String macroName, Escaping... escapings) {
        Builder builder = Value.newBuilder().setType(Type.MACRO_REFERENCE).setMacroReference(macroName).setContainsReferences(true);
        for (Escaping escaping : escapings) {
            builder.addEscaping(escaping);
        }
        return builder.build();
    }

    public static Value templateToValue(Value... tokens) {
        Builder builder = Value.newBuilder().setType(Type.TEMPLATE);
        boolean containsRef = false;
        for (Value token : tokens) {
            builder.addTemplateToken(token);
            containsRef = containsRef || token.getContainsReferences();
        }
        if (containsRef) {
            builder.setContainsReferences(true);
        }
        return builder.build();
    }

    private static boolean isDoubleableNumber(Object o) {
        return (o instanceof Double) || (o instanceof Float) || ((o instanceof TypedNumber) && ((TypedNumber) o).isDouble());
    }

    private static double getDouble(Object o) {
        if (o instanceof Number) {
            return ((Number) o).doubleValue();
        }
        Log.m1389e("getDouble received non-Number");
        return 0.0d;
    }

    private static boolean isInt64ableNumber(Object o) {
        return (o instanceof Byte) || (o instanceof Short) || (o instanceof Integer) || (o instanceof Long) || ((o instanceof TypedNumber) && ((TypedNumber) o).isInt64());
    }

    private static long getInt64(Object o) {
        if (o instanceof Number) {
            return ((Number) o).longValue();
        }
        Log.m1389e("getInt64 received non-Number");
        return 0;
    }

    private static TypedNumber parseNumber(String s) {
        try {
            return TypedNumber.numberWithString(s);
        } catch (NumberFormatException e) {
            Log.m1389e("Failed to convert '" + s + "' to a number.");
            return DEFAULT_NUMBER;
        }
    }

    private static Long parseInt64(String s) {
        TypedNumber result = parseNumber(s);
        return result == DEFAULT_NUMBER ? DEFAULT_INT64 : Long.valueOf(result.longValue());
    }

    private static Double parseDouble(String s) {
        TypedNumber result = parseNumber(s);
        return result == DEFAULT_NUMBER ? DEFAULT_DOUBLE : Double.valueOf(result.doubleValue());
    }

    private static Boolean parseBoolean(String s) {
        if ("true".equalsIgnoreCase(s)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(s)) {
            return Boolean.FALSE;
        }
        return DEFAULT_BOOLEAN;
    }

    public static Object valueToObject(Value v) {
        if (v == null) {
            return DEFAULT_OBJECT;
        }
        switch (C04461.f52xa390a19[v.getType().ordinal()]) {
            case MutableTypeSystem.Value.TYPE_FIELD_NUMBER /*1*/:
                return v.getString();
            case MutableTypeSystem.Value.STRING_FIELD_NUMBER /*2*/:
                Object result = new ArrayList(v.getListItemCount());
                for (Value val : v.getListItemList()) {
                    Object o = valueToObject(val);
                    if (o == DEFAULT_OBJECT) {
                        return DEFAULT_OBJECT;
                    }
                    result.add(o);
                }
                return result;
            case MutableTypeSystem.Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                if (v.getMapKeyCount() != v.getMapValueCount()) {
                    Log.m1389e("Converting an invalid value to object: " + v.toString());
                    return DEFAULT_OBJECT;
                }
                Map<Object, Object> result2 = new HashMap(v.getMapValueCount());
                for (int i = 0; i < v.getMapKeyCount(); i++) {
                    Object key = valueToObject(v.getMapKey(i));
                    Object value = valueToObject(v.getMapValue(i));
                    if (key == DEFAULT_OBJECT || value == DEFAULT_OBJECT) {
                        return DEFAULT_OBJECT;
                    }
                    result2.put(key, value);
                }
                return result2;
            case MutableTypeSystem.Value.MAP_KEY_FIELD_NUMBER /*4*/:
                Log.m1389e("Trying to convert a macro reference to object");
                return DEFAULT_OBJECT;
            case MutableTypeSystem.Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                Log.m1389e("Trying to convert a function id to object");
                return DEFAULT_OBJECT;
            case MutableTypeSystem.Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                return Long.valueOf(v.getInteger());
            case MutableTypeSystem.Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                StringBuffer result3 = new StringBuffer();
                for (Value val2 : v.getTemplateTokenList()) {
                    String s = valueToString(val2);
                    if (s == DEFAULT_STRING) {
                        return DEFAULT_OBJECT;
                    }
                    result3.append(s);
                }
                return result3.toString();
            case MutableTypeSystem.Value.INTEGER_FIELD_NUMBER /*8*/:
                return Boolean.valueOf(v.getBoolean());
            default:
                Log.m1389e("Failed to convert a value of type: " + v.getType());
                return DEFAULT_OBJECT;
        }
    }
}
