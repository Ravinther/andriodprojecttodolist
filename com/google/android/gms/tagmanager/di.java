package com.google.android.gms.tagmanager;

import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class di {
    private static final Object XI;
    private static Long XJ;
    private static Double XK;
    private static dh XL;
    private static String XM;
    private static Boolean XN;
    private static List<Object> XO;
    private static Map<Object, Object> XP;
    private static C0911a XQ;

    static {
        XI = null;
        XJ = new Long(0);
        XK = new Double(0.0d);
        XL = dh.m1343v(0);
        XM = new String("");
        XN = new Boolean(false);
        XO = new ArrayList(0);
        XP = new HashMap();
        XQ = m1356r(XM);
    }

    public static C0911a bI(String str) {
        C0911a c0911a = new C0911a();
        c0911a.type = 5;
        c0911a.gd = str;
        return c0911a;
    }

    private static dh bJ(String str) {
        try {
            return dh.bH(str);
        } catch (NumberFormatException e) {
            bh.m1266t("Failed to convert '" + str + "' to a number.");
            return XL;
        }
    }

    private static Long bK(String str) {
        dh bJ = bJ(str);
        return bJ == XL ? XJ : Long.valueOf(bJ.longValue());
    }

    private static Double bL(String str) {
        dh bJ = bJ(str);
        return bJ == XL ? XK : Double.valueOf(bJ.doubleValue());
    }

    private static Boolean bM(String str) {
        return "true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : XN;
    }

    private static double getDouble(Object o) {
        if (o instanceof Number) {
            return ((Number) o).doubleValue();
        }
        bh.m1266t("getDouble received non-Number");
        return 0.0d;
    }

    public static String m1345j(C0911a c0911a) {
        return m1349m(m1353o(c0911a));
    }

    public static dh m1346k(C0911a c0911a) {
        return m1350n(m1353o(c0911a));
    }

    public static Object ko() {
        return XI;
    }

    public static Long kp() {
        return XJ;
    }

    public static Double kq() {
        return XK;
    }

    public static Boolean kr() {
        return XN;
    }

    public static dh ks() {
        return XL;
    }

    public static String kt() {
        return XM;
    }

    public static C0911a ku() {
        return XQ;
    }

    public static Long m1347l(C0911a c0911a) {
        return m1352o(m1353o(c0911a));
    }

    public static Double m1348m(C0911a c0911a) {
        return m1354p(m1353o(c0911a));
    }

    public static String m1349m(Object obj) {
        return obj == null ? XM : obj.toString();
    }

    public static dh m1350n(Object obj) {
        return obj instanceof dh ? (dh) obj : m1358t(obj) ? dh.m1343v(m1359u(obj)) : m1357s(obj) ? dh.m1342a(Double.valueOf(getDouble(obj))) : bJ(m1349m(obj));
    }

    public static Boolean m1351n(C0911a c0911a) {
        return m1355q(m1353o(c0911a));
    }

    public static Long m1352o(Object obj) {
        return m1358t(obj) ? Long.valueOf(m1359u(obj)) : bK(m1349m(obj));
    }

    public static Object m1353o(C0911a c0911a) {
        int i = 0;
        if (c0911a == null) {
            return XI;
        }
        C0911a[] c0911aArr;
        int length;
        switch (c0911a.type) {
            case Value.TYPE_FIELD_NUMBER /*1*/:
                return c0911a.fY;
            case Value.STRING_FIELD_NUMBER /*2*/:
                ArrayList arrayList = new ArrayList(c0911a.fZ.length);
                c0911aArr = c0911a.fZ;
                length = c0911aArr.length;
                while (i < length) {
                    Object o = m1353o(c0911aArr[i]);
                    if (o == XI) {
                        return XI;
                    }
                    arrayList.add(o);
                    i++;
                }
                return arrayList;
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                if (c0911a.ga.length != c0911a.gb.length) {
                    bh.m1266t("Converting an invalid value to object: " + c0911a.toString());
                    return XI;
                }
                Map hashMap = new HashMap(c0911a.gb.length);
                while (i < c0911a.ga.length) {
                    Object o2 = m1353o(c0911a.ga[i]);
                    Object o3 = m1353o(c0911a.gb[i]);
                    if (o2 == XI || o3 == XI) {
                        return XI;
                    }
                    hashMap.put(o2, o3);
                    i++;
                }
                return hashMap;
            case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                bh.m1266t("Trying to convert a macro reference to object");
                return XI;
            case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                bh.m1266t("Trying to convert a function id to object");
                return XI;
            case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                return Long.valueOf(c0911a.ge);
            case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                StringBuffer stringBuffer = new StringBuffer();
                c0911aArr = c0911a.gg;
                length = c0911aArr.length;
                while (i < length) {
                    String j = m1345j(c0911aArr[i]);
                    if (j == XM) {
                        return XI;
                    }
                    stringBuffer.append(j);
                    i++;
                }
                return stringBuffer.toString();
            case Value.INTEGER_FIELD_NUMBER /*8*/:
                return Boolean.valueOf(c0911a.gf);
            default:
                bh.m1266t("Failed to convert a value of type: " + c0911a.type);
                return XI;
        }
    }

    public static Double m1354p(Object obj) {
        return m1357s(obj) ? Double.valueOf(getDouble(obj)) : bL(m1349m(obj));
    }

    public static Boolean m1355q(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : bM(m1349m(obj));
    }

    public static C0911a m1356r(Object obj) {
        boolean z = false;
        C0911a c0911a = new C0911a();
        if (obj instanceof C0911a) {
            return (C0911a) obj;
        }
        if (obj instanceof String) {
            c0911a.type = 1;
            c0911a.fY = (String) obj;
        } else if (obj instanceof List) {
            c0911a.type = 2;
            List<Object> list = (List) obj;
            r5 = new ArrayList(list.size());
            r1 = false;
            for (Object r : list) {
                C0911a r2 = m1356r(r);
                if (r2 == XQ) {
                    return XQ;
                }
                r0 = r1 || r2.gi;
                r5.add(r2);
                r1 = r0;
            }
            c0911a.fZ = (C0911a[]) r5.toArray(new C0911a[0]);
            z = r1;
        } else if (obj instanceof Map) {
            c0911a.type = 3;
            Set<Entry> entrySet = ((Map) obj).entrySet();
            r5 = new ArrayList(entrySet.size());
            List arrayList = new ArrayList(entrySet.size());
            r1 = false;
            for (Entry entry : entrySet) {
                C0911a r3 = m1356r(entry.getKey());
                C0911a r4 = m1356r(entry.getValue());
                if (r3 == XQ || r4 == XQ) {
                    return XQ;
                }
                r0 = r1 || r3.gi || r4.gi;
                r5.add(r3);
                arrayList.add(r4);
                r1 = r0;
            }
            c0911a.ga = (C0911a[]) r5.toArray(new C0911a[0]);
            c0911a.gb = (C0911a[]) arrayList.toArray(new C0911a[0]);
            z = r1;
        } else if (m1357s(obj)) {
            c0911a.type = 1;
            c0911a.fY = obj.toString();
        } else if (m1358t(obj)) {
            c0911a.type = 6;
            c0911a.ge = m1359u(obj);
        } else if (obj instanceof Boolean) {
            c0911a.type = 8;
            c0911a.gf = ((Boolean) obj).booleanValue();
        } else {
            bh.m1266t("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
            return XQ;
        }
        c0911a.gi = z;
        return c0911a;
    }

    private static boolean m1357s(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof dh) && ((dh) obj).kj());
    }

    private static boolean m1358t(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof dh) && ((dh) obj).kk());
    }

    private static long m1359u(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        bh.m1266t("getInt64 received non-Number");
        return 0;
    }
}
