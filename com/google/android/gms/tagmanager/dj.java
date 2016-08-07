package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.analytics.tracking.android.Fields;
import com.google.analytics.tracking.android.HitTypes;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0214b;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class dj extends dg {
    private static final String ID;
    private static final String XR;
    private static final String XS;
    private static final String XT;
    private static final String XU;
    private static final String XV;
    private static final String XW;
    private static Map<String, String> XX;
    private static Map<String, String> XY;
    private final DataLayer TN;
    private final Set<String> XZ;
    private final df Ya;

    static {
        ID = C0211a.UNIVERSAL_ANALYTICS.toString();
        XR = C0214b.ACCOUNT.toString();
        XS = C0214b.ANALYTICS_PASS_THROUGH.toString();
        XT = C0214b.ANALYTICS_FIELDS.toString();
        XU = C0214b.TRACK_TRANSACTION.toString();
        XV = C0214b.TRANSACTION_DATALAYER_MAP.toString();
        XW = C0214b.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    }

    public dj(Context context, DataLayer dataLayer) {
        this(context, dataLayer, new df(context));
    }

    dj(Context context, DataLayer dataLayer, df dfVar) {
        super(ID, new String[0]);
        this.TN = dataLayer;
        this.Ya = dfVar;
        this.XZ = new HashSet();
        this.XZ.add("");
        this.XZ.add("0");
        this.XZ.add("false");
    }

    private Map<String, String> m2890E(Map<String, C0911a> map) {
        C0911a c0911a = (C0911a) map.get(XV);
        if (c0911a != null) {
            return m2894c(c0911a);
        }
        if (XX == null) {
            Map hashMap = new HashMap();
            hashMap.put("transactionId", Fields.TRANSACTION_ID);
            hashMap.put("transactionAffiliation", Fields.TRANSACTION_AFFILIATION);
            hashMap.put("transactionTax", Fields.TRANSACTION_TAX);
            hashMap.put("transactionShipping", Fields.TRANSACTION_SHIPPING);
            hashMap.put("transactionTotal", Fields.TRANSACTION_REVENUE);
            hashMap.put("transactionCurrency", Fields.CURRENCY_CODE);
            XX = hashMap;
        }
        return XX;
    }

    private Map<String, String> m2891F(Map<String, C0911a> map) {
        C0911a c0911a = (C0911a) map.get(XW);
        if (c0911a != null) {
            return m2894c(c0911a);
        }
        if (XY == null) {
            Map hashMap = new HashMap();
            hashMap.put("name", Fields.ITEM_NAME);
            hashMap.put("sku", Fields.ITEM_SKU);
            hashMap.put("category", Fields.ITEM_CATEGORY);
            hashMap.put("price", Fields.ITEM_PRICE);
            hashMap.put("quantity", Fields.ITEM_QUANTITY);
            hashMap.put("currency", Fields.CURRENCY_CODE);
            XY = hashMap;
        }
        return XY;
    }

    private void m2892a(Tracker tracker, Map<String, C0911a> map) {
        String bN = bN("transactionId");
        if (bN == null) {
            bh.m1266t("Cannot find transactionId in data layer.");
            return;
        }
        List<Map> linkedList = new LinkedList();
        try {
            Map p = m2896p((C0911a) map.get(XT));
            p.put(Fields.HIT_TYPE, HitTypes.TRANSACTION);
            for (Entry entry : m2890E(map).entrySet()) {
                m2893b(p, (String) entry.getValue(), bN((String) entry.getKey()));
            }
            linkedList.add(p);
            List<Map> kv = kv();
            if (kv != null) {
                for (Map map2 : kv) {
                    if (map2.get("name") == null) {
                        bh.m1266t("Unable to send transaction item hit due to missing 'name' field.");
                        return;
                    }
                    Map p2 = m2896p((C0911a) map.get(XT));
                    p2.put(Fields.HIT_TYPE, HitTypes.ITEM);
                    p2.put(Fields.TRANSACTION_ID, bN);
                    for (Entry entry2 : m2891F(map).entrySet()) {
                        m2893b(p2, (String) entry2.getValue(), (String) map2.get(entry2.getKey()));
                    }
                    linkedList.add(p2);
                }
            }
            for (Map map22 : linkedList) {
                tracker.send(map22);
            }
        } catch (Throwable e) {
            bh.m1264c("Unable to send transaction", e);
        }
    }

    private void m2893b(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    private String bN(String str) {
        Object obj = this.TN.get(str);
        return obj == null ? null : obj.toString();
    }

    private Map<String, String> m2894c(C0911a c0911a) {
        Object o = di.m1353o(c0911a);
        if (!(o instanceof Map)) {
            return null;
        }
        Map map = (Map) o;
        Map<String, String> linkedHashMap = new LinkedHashMap();
        for (Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private boolean m2895d(Map<String, C0911a> map, String str) {
        C0911a c0911a = (C0911a) map.get(str);
        return c0911a == null ? false : di.m1351n(c0911a).booleanValue();
    }

    private List<Map<String, String>> kv() {
        Object obj = this.TN.get("transactionProducts");
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                if (!(obj2 instanceof Map)) {
                    throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
                }
            }
            return (List) obj;
        }
        throw new IllegalArgumentException("transactionProducts should be of type List.");
    }

    private Map<String, String> m2896p(C0911a c0911a) {
        if (c0911a == null) {
            return new HashMap();
        }
        Map<String, String> c = m2894c(c0911a);
        if (c == null) {
            return new HashMap();
        }
        String str = (String) c.get(Fields.ANONYMIZE_IP);
        if (str != null && this.XZ.contains(str.toLowerCase())) {
            c.remove(Fields.ANONYMIZE_IP);
        }
        return c;
    }

    public void m2897w(Map<String, C0911a> map) {
        Tracker bF = this.Ya.bF("_GTM_DEFAULT_TRACKER_");
        if (m2895d(map, XS)) {
            bF.send(m2896p((C0911a) map.get(XT)));
        } else if (m2895d(map, XU)) {
            m2892a(bF, map);
        } else {
            bh.m1269w("Ignoring unknown tag.");
        }
    }
}
