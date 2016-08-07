package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.MutableTypeSystem;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Escaping;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

class ValueEscapeUtil {

    /* renamed from: com.google.tagmanager.ValueEscapeUtil.1 */
    static /* synthetic */ class C04471 {
        static final /* synthetic */ int[] f53x6a3a745d;

        static {
            f53x6a3a745d = new int[Escaping.values().length];
            try {
                f53x6a3a745d[Escaping.ESCAPE_URI.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    private ValueEscapeUtil() {
    }

    static ObjectAndStatic<Value> applyEscapings(ObjectAndStatic<Value> value, List<Escaping> escapings) {
        ObjectAndStatic<Value> escapedValue = value;
        for (Escaping escaping : escapings) {
            escapedValue = applyEscaping(escapedValue, escaping);
        }
        return escapedValue;
    }

    static String urlEncode(String string) throws UnsupportedEncodingException {
        return URLEncoder.encode(string, "UTF-8").replaceAll("\\+", "%20");
    }

    private static ObjectAndStatic<Value> applyEscaping(ObjectAndStatic<Value> value, Escaping escaping) {
        if (isValidStringType((Value) value.getObject())) {
            switch (C04471.f53x6a3a745d[escaping.ordinal()]) {
                case MutableTypeSystem.Value.TYPE_FIELD_NUMBER /*1*/:
                    return escapeUri(value);
                default:
                    Log.m1389e("Unsupported Value Escaping: " + escaping);
                    return value;
            }
        }
        Log.m1389e("Escaping can only be applied to strings.");
        return value;
    }

    private static ObjectAndStatic<Value> escapeUri(ObjectAndStatic<Value> value) {
        try {
            return new ObjectAndStatic(Types.objectToValue(urlEncode(((Value) value.getObject()).getString())), value.isStatic());
        } catch (UnsupportedEncodingException e) {
            Log.m1390e("Escape URI: unsupported encoding", e);
            return value;
        }
    }

    private static boolean isValidStringType(Value value) {
        return value.hasType() && value.getType().equals(Type.STRING) && value.hasString();
    }
}
