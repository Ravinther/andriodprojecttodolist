package com.google.android.gms.tagmanager;

import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0214b;
import com.google.android.gms.internal.C0247d.C0911a;
import com.google.android.gms.plus.PlusShare;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class az extends aj {
    private static final String ID;
    private static final String US;
    private static final String Vo;
    private static final String Vp;
    private static final String Vq;

    /* renamed from: com.google.android.gms.tagmanager.az.1 */
    static /* synthetic */ class C03711 {
        static final /* synthetic */ int[] Vr;

        static {
            Vr = new int[C0372a.values().length];
            try {
                Vr[C0372a.URL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Vr[C0372a.BACKSLASH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Vr[C0372a.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.az.a */
    private enum C0372a {
        NONE,
        URL,
        BACKSLASH
    }

    static {
        ID = C0211a.JOINER.toString();
        US = C0214b.ARG0.toString();
        Vo = C0214b.ITEM_SEPARATOR.toString();
        Vp = C0214b.KEY_VALUE_SEPARATOR.toString();
        Vq = C0214b.ESCAPE.toString();
    }

    public az() {
        super(ID, US);
    }

    private String m2269a(String str, C0372a c0372a, Set<Character> set) {
        switch (C03711.Vr[c0372a.ordinal()]) {
            case Value.TYPE_FIELD_NUMBER /*1*/:
                try {
                    return dl.bO(str);
                } catch (Throwable e) {
                    bh.m1264c("Joiner: unsupported encoding", e);
                    return str;
                }
            case Value.STRING_FIELD_NUMBER /*2*/:
                String replace = str.replace("\\", "\\\\");
                String str2 = replace;
                for (Character ch : set) {
                    CharSequence ch2 = ch.toString();
                    str2 = str2.replace(ch2, "\\" + ch2);
                }
                return str2;
            default:
                return str;
        }
    }

    private void m2270a(StringBuilder stringBuilder, String str, C0372a c0372a, Set<Character> set) {
        stringBuilder.append(m2269a(str, c0372a, set));
    }

    private void m2271a(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    public boolean iy() {
        return true;
    }

    public C0911a m2272u(Map<String, C0911a> map) {
        C0911a c0911a = (C0911a) map.get(US);
        if (c0911a == null) {
            return di.ku();
        }
        C0372a c0372a;
        C0911a c0911a2 = (C0911a) map.get(Vo);
        String j = c0911a2 != null ? di.m1345j(c0911a2) : "";
        c0911a2 = (C0911a) map.get(Vp);
        String j2 = c0911a2 != null ? di.m1345j(c0911a2) : "=";
        C0372a c0372a2 = C0372a.NONE;
        c0911a2 = (C0911a) map.get(Vq);
        Set set;
        if (c0911a2 != null) {
            String j3 = di.m1345j(c0911a2);
            if (PlusShare.KEY_CALL_TO_ACTION_URL.equals(j3)) {
                c0372a = C0372a.URL;
                set = null;
            } else if ("backslash".equals(j3)) {
                c0372a = C0372a.BACKSLASH;
                set = new HashSet();
                m2271a(set, j);
                m2271a(set, j2);
                set.remove(Character.valueOf('\\'));
            } else {
                bh.m1266t("Joiner: unsupported escape type: " + j3);
                return di.ku();
            }
        }
        set = null;
        c0372a = c0372a2;
        StringBuilder stringBuilder = new StringBuilder();
        switch (c0911a.type) {
            case Value.STRING_FIELD_NUMBER /*2*/:
                Object obj = 1;
                C0911a[] c0911aArr = c0911a.fZ;
                int length = c0911aArr.length;
                int i = 0;
                while (i < length) {
                    C0911a c0911a3 = c0911aArr[i];
                    if (obj == null) {
                        stringBuilder.append(j);
                    }
                    m2270a(stringBuilder, di.m1345j(c0911a3), c0372a, set);
                    i++;
                    obj = null;
                }
                break;
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                for (int i2 = 0; i2 < c0911a.ga.length; i2++) {
                    if (i2 > 0) {
                        stringBuilder.append(j);
                    }
                    String j4 = di.m1345j(c0911a.ga[i2]);
                    String j5 = di.m1345j(c0911a.gb[i2]);
                    m2270a(stringBuilder, j4, c0372a, set);
                    stringBuilder.append(j2);
                    m2270a(stringBuilder, j5, c0372a, set);
                }
                break;
            default:
                m2270a(stringBuilder, di.m1345j(c0911a), c0372a, set);
                break;
        }
        return di.m1356r(stringBuilder.toString());
    }
}
