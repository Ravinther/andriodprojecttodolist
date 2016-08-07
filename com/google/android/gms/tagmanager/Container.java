package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0237c.C0904f;
import com.google.android.gms.internal.C0237c.C0907i;
import com.google.android.gms.internal.C0237c.C0908j;
import com.google.android.gms.internal.C0247d.C0911a;
import com.google.android.gms.tagmanager.C0801s.C0406a;
import com.google.android.gms.tagmanager.ce.C0377a;
import com.google.android.gms.tagmanager.cr.C0385c;
import com.google.android.gms.tagmanager.cr.C0389g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private final String TM;
    private final DataLayer TN;
    private ct TO;
    private Map<String, FunctionCallMacroCallback> TP;
    private Map<String, FunctionCallTagCallback> TQ;
    private volatile long TR;
    private volatile String TS;
    private final Context mContext;

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    /* renamed from: com.google.android.gms.tagmanager.Container.a */
    private class C0766a implements C0406a {
        final /* synthetic */ Container TT;

        private C0766a(Container container) {
            this.TT = container;
        }

        public Object m2244b(String str, Map<String, Object> map) {
            FunctionCallMacroCallback aY = this.TT.aY(str);
            return aY == null ? null : aY.getValue(str, map);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.Container.b */
    private class C0767b implements C0406a {
        final /* synthetic */ Container TT;

        private C0767b(Container container) {
            this.TT = container;
        }

        public Object m2245b(String str, Map<String, Object> map) {
            FunctionCallTagCallback aZ = this.TT.aZ(str);
            if (aZ != null) {
                aZ.execute(str, map);
            }
            return di.kt();
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, C0908j resource) {
        this.TP = new HashMap();
        this.TQ = new HashMap();
        this.TS = "";
        this.mContext = context;
        this.TN = dataLayer;
        this.TM = containerId;
        this.TR = lastRefreshTime;
        m1209a(resource.fV);
        if (resource.fU != null) {
            m1212a(resource.fU);
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, C0385c resource) {
        this.TP = new HashMap();
        this.TQ = new HashMap();
        this.TS = "";
        this.mContext = context;
        this.TN = dataLayer;
        this.TM = containerId;
        this.TR = lastRefreshTime;
        m1210a(resource);
    }

    private void m1209a(C0904f c0904f) {
        if (c0904f == null) {
            throw new NullPointerException();
        }
        try {
            m1210a(cr.m1307b(c0904f));
        } catch (C0389g e) {
            bh.m1266t("Not loading resource: " + c0904f + " because it is invalid: " + e.toString());
        }
    }

    private void m1210a(C0385c c0385c) {
        this.TS = c0385c.getVersion();
        C0385c c0385c2 = c0385c;
        m1211a(new ct(this.mContext, c0385c2, this.TN, new C0766a(), new C0767b(), bb(this.TS)));
    }

    private synchronized void m1211a(ct ctVar) {
        this.TO = ctVar;
    }

    private void m1212a(C0907i[] c0907iArr) {
        List arrayList = new ArrayList();
        for (Object add : c0907iArr) {
            arrayList.add(add);
        }
        iE().m1335f(arrayList);
    }

    private synchronized ct iE() {
        return this.TO;
    }

    FunctionCallMacroCallback aY(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.TP) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.TP.get(str);
        }
        return functionCallMacroCallback;
    }

    FunctionCallTagCallback aZ(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.TQ) {
            functionCallTagCallback = (FunctionCallTagCallback) this.TQ.get(str);
        }
        return functionCallTagCallback;
    }

    void ba(String str) {
        iE().ba(str);
    }

    ag bb(String str) {
        if (ce.ju().jv().equals(C0377a.CONTAINER_DEBUG)) {
        }
        return new bq();
    }

    public boolean getBoolean(String key) {
        ct iE = iE();
        if (iE == null) {
            bh.m1266t("getBoolean called for closed container.");
            return di.kr().booleanValue();
        }
        try {
            return di.m1351n((C0911a) iE.bC(key).getObject()).booleanValue();
        } catch (Exception e) {
            bh.m1266t("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return di.kr().booleanValue();
        }
    }

    public String getContainerId() {
        return this.TM;
    }

    public double getDouble(String key) {
        ct iE = iE();
        if (iE == null) {
            bh.m1266t("getDouble called for closed container.");
            return di.kq().doubleValue();
        }
        try {
            return di.m1348m((C0911a) iE.bC(key).getObject()).doubleValue();
        } catch (Exception e) {
            bh.m1266t("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return di.kq().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.TR;
    }

    public long getLong(String key) {
        ct iE = iE();
        if (iE == null) {
            bh.m1266t("getLong called for closed container.");
            return di.kp().longValue();
        }
        try {
            return di.m1347l((C0911a) iE.bC(key).getObject()).longValue();
        } catch (Exception e) {
            bh.m1266t("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return di.kp().longValue();
        }
    }

    public String getString(String key) {
        ct iE = iE();
        if (iE == null) {
            bh.m1266t("getString called for closed container.");
            return di.kt();
        }
        try {
            return di.m1345j((C0911a) iE.bC(key).getObject());
        } catch (Exception e) {
            bh.m1266t("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return di.kt();
        }
    }

    String iD() {
        return this.TS;
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String customMacroName, FunctionCallMacroCallback customMacroCallback) {
        if (customMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.TP) {
            this.TP.put(customMacroName, customMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String customTagName, FunctionCallTagCallback customTagCallback) {
        if (customTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.TQ) {
            this.TQ.put(customTagName, customTagCallback);
        }
    }

    void release() {
        this.TO = null;
    }

    public void unregisterFunctionCallMacroCallback(String customMacroName) {
        synchronized (this.TP) {
            this.TP.remove(customMacroName);
        }
    }

    public void unregisterFunctionCallTagCallback(String customTagName) {
        synchronized (this.TQ) {
            this.TQ.remove(customTagName);
        }
    }
}
