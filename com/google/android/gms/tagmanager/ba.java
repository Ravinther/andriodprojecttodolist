package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0214b;
import com.google.android.gms.internal.C0247d.C0911a;
import com.google.android.gms.tagmanager.cr.C0383a;
import com.google.android.gms.tagmanager.cr.C0385c;
import com.google.android.gms.tagmanager.cr.C0386d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ba {
    public static C0385c br(String str) throws JSONException {
        C0911a k = m1259k(new JSONObject(str));
        C0386d jI = C0385c.jI();
        for (int i = 0; i < k.ga.length; i++) {
            jI.m1295a(C0383a.jE().m1293b(C0214b.INSTANCE_NAME.toString(), k.ga[i]).m1293b(C0214b.FUNCTION.toString(), di.bI(C0792m.iB())).m1293b(C0792m.iC(), k.gb[i]).jH());
        }
        return jI.jL();
    }

    private static C0911a m1259k(Object obj) throws JSONException {
        return di.m1356r(m1260l(obj));
    }

    static Object m1260l(Object obj) throws JSONException {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            Map hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, m1260l(jSONObject.get(str)));
            }
            return hashMap;
        }
    }
}
