package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type;
import com.google.android.gms.plus.PlusShare;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class JoinerMacro extends FunctionCallImplementation {
    private static final String ARG0;
    private static final String DEFAULT_ITEM_SEPARATOR = "";
    private static final String DEFAULT_KEY_VALUE_SEPARATOR = "=";
    private static final String ESCAPE;
    private static final String ID;
    private static final String ITEM_SEPARATOR;
    private static final String KEY_VALUE_SEPARATOR;

    /* renamed from: com.google.tagmanager.JoinerMacro.1 */
    static /* synthetic */ class C04351 {
        static final /* synthetic */ int[] f49xa390a19;
        static final /* synthetic */ int[] $SwitchMap$com$google$tagmanager$JoinerMacro$EscapeType;

        static {
            $SwitchMap$com$google$tagmanager$JoinerMacro$EscapeType = new int[EscapeType.values().length];
            try {
                $SwitchMap$com$google$tagmanager$JoinerMacro$EscapeType[EscapeType.URL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$tagmanager$JoinerMacro$EscapeType[EscapeType.BACKSLASH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$tagmanager$JoinerMacro$EscapeType[EscapeType.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            f49xa390a19 = new int[Type.values().length];
            try {
                f49xa390a19[Type.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f49xa390a19[Type.MAP.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private enum EscapeType {
        NONE,
        URL,
        BACKSLASH
    }

    static {
        ID = FunctionType.JOINER.toString();
        ARG0 = Key.ARG0.toString();
        ITEM_SEPARATOR = Key.ITEM_SEPARATOR.toString();
        KEY_VALUE_SEPARATOR = Key.KEY_VALUE_SEPARATOR.toString();
        ESCAPE = Key.ESCAPE.toString();
    }

    public static String getFunctionId() {
        return ID;
    }

    public JoinerMacro() {
        super(ID, ARG0);
    }

    public boolean isCacheable() {
        return true;
    }

    public Value evaluate(Map<String, Value> parameters) {
        Value input = (Value) parameters.get(ARG0);
        if (input == null) {
            return Types.getDefaultValue();
        }
        Value itemSeparatorParameter = (Value) parameters.get(ITEM_SEPARATOR);
        String itemSeparator = itemSeparatorParameter != null ? Types.valueToString(itemSeparatorParameter) : DEFAULT_ITEM_SEPARATOR;
        Value keyValueSeparatorParameter = (Value) parameters.get(KEY_VALUE_SEPARATOR);
        String keyValueSeparator = keyValueSeparatorParameter != null ? Types.valueToString(keyValueSeparatorParameter) : DEFAULT_KEY_VALUE_SEPARATOR;
        EscapeType escapeType = EscapeType.NONE;
        Value escapeParameter = (Value) parameters.get(ESCAPE);
        Set<Character> charsToBackslashEscape = null;
        if (escapeParameter != null) {
            String escape = Types.valueToString(escapeParameter);
            if (PlusShare.KEY_CALL_TO_ACTION_URL.equals(escape)) {
                escapeType = EscapeType.URL;
            } else {
                if ("backslash".equals(escape)) {
                    escapeType = EscapeType.BACKSLASH;
                    charsToBackslashEscape = new HashSet();
                    addTo(charsToBackslashEscape, itemSeparator);
                    addTo(charsToBackslashEscape, keyValueSeparator);
                    charsToBackslashEscape.remove(Character.valueOf('\\'));
                } else {
                    Log.m1389e("Joiner: unsupported escape type: " + escape);
                    return Types.getDefaultValue();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        switch (C04351.f49xa390a19[input.getType().ordinal()]) {
            case MutableTypeSystem.Value.TYPE_FIELD_NUMBER /*1*/:
                boolean firstTime = true;
                for (Value itemVal : input.getListItemList()) {
                    if (!firstTime) {
                        sb.append(itemSeparator);
                    }
                    firstTime = false;
                    append(sb, Types.valueToString(itemVal), escapeType, charsToBackslashEscape);
                }
                break;
            case MutableTypeSystem.Value.STRING_FIELD_NUMBER /*2*/:
                for (int i = 0; i < input.getMapKeyCount(); i++) {
                    if (i > 0) {
                        sb.append(itemSeparator);
                    }
                    String key = Types.valueToString(input.getMapKey(i));
                    String value = Types.valueToString(input.getMapValue(i));
                    append(sb, key, escapeType, charsToBackslashEscape);
                    sb.append(keyValueSeparator);
                    append(sb, value, escapeType, charsToBackslashEscape);
                }
                break;
            default:
                append(sb, Types.valueToString(input), escapeType, charsToBackslashEscape);
                break;
        }
        return Types.objectToValue(sb.toString());
    }

    private void addTo(Set<Character> set, String string) {
        for (int i = 0; i < string.length(); i++) {
            set.add(Character.valueOf(string.charAt(i)));
        }
    }

    private void append(StringBuilder sb, String s, EscapeType escapeType, Set<Character> charsToBackslashEscape) {
        sb.append(escape(s, escapeType, charsToBackslashEscape));
    }

    private String escape(String s, EscapeType escapeType, Set<Character> charsToBackslashEscape) {
        switch (C04351.$SwitchMap$com$google$tagmanager$JoinerMacro$EscapeType[escapeType.ordinal()]) {
            case MutableTypeSystem.Value.TYPE_FIELD_NUMBER /*1*/:
                try {
                    return ValueEscapeUtil.urlEncode(s);
                } catch (UnsupportedEncodingException e) {
                    Log.m1390e("Joiner: unsupported encoding", e);
                    return s;
                }
            case MutableTypeSystem.Value.STRING_FIELD_NUMBER /*2*/:
                s = s.replace("\\", "\\\\");
                for (Character c : charsToBackslashEscape) {
                    String charAsString = c.toString();
                    s = s.replace(charAsString, "\\" + charAsString);
                }
                return s;
            default:
                return s;
        }
    }
}
