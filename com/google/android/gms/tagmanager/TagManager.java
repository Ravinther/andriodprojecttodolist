package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.tagmanager.DataLayer.C0361b;
import com.google.android.gms.tagmanager.ce.C0377a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager XB;
    private final DataLayer TN;
    private final C0405r Wj;
    private final ConcurrentMap<C0981n, Boolean> XA;
    private final C0366a Xz;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.TagManager.3 */
    static /* synthetic */ class C03653 {
        static final /* synthetic */ int[] XD;

        static {
            XD = new int[C0377a.values().length];
            try {
                XD[C0377a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                XD[C0377a.CONTAINER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                XD[C0377a.CONTAINER_DEBUG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.a */
    interface C0366a {
        C0982o m1233a(Context context, TagManager tagManager, Looper looper, String str, int i, C0405r c0405r);
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.1 */
    class C07701 implements C0361b {
        final /* synthetic */ TagManager XC;

        C07701(TagManager tagManager) {
            this.XC = tagManager;
        }

        public void m2249v(Map<String, Object> map) {
            Object obj = map.get(DataLayer.EVENT_KEY);
            if (obj != null) {
                this.XC.bE(obj.toString());
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.2 */
    static class C07712 implements C0366a {
        C07712() {
        }

        public C0982o m2250a(Context context, TagManager tagManager, Looper looper, String str, int i, C0405r c0405r) {
            return new C0982o(context, tagManager, looper, str, i, c0405r);
        }
    }

    TagManager(Context context, C0366a containerHolderLoaderProvider, DataLayer dataLayer) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.Xz = containerHolderLoaderProvider;
        this.XA = new ConcurrentHashMap();
        this.TN = dataLayer;
        this.TN.m1227a(new C07701(this));
        this.TN.m1227a(new C0784d(this.mContext));
        this.Wj = new C0405r();
    }

    private void bE(String str) {
        for (C0981n ba : this.XA.keySet()) {
            ba.ba(str);
        }
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (XB == null) {
                if (context == null) {
                    bh.m1266t("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                XB = new TagManager(context, new C07712(), new DataLayer(new C0803v(context)));
            }
            tagManager = XB;
        }
        return tagManager;
    }

    void m1235a(C0981n c0981n) {
        this.XA.put(c0981n, Boolean.valueOf(true));
    }

    boolean m1236b(C0981n c0981n) {
        return this.XA.remove(c0981n) != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized boolean m1237f(android.net.Uri r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r1 = com.google.android.gms.tagmanager.ce.ju();	 Catch:{ all -> 0x0049 }
        r0 = r1.m1285f(r6);	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x0085;
    L_0x000b:
        r2 = r1.getContainerId();	 Catch:{ all -> 0x0049 }
        r0 = com.google.android.gms.tagmanager.TagManager.C03653.XD;	 Catch:{ all -> 0x0049 }
        r3 = r1.jv();	 Catch:{ all -> 0x0049 }
        r3 = r3.ordinal();	 Catch:{ all -> 0x0049 }
        r0 = r0[r3];	 Catch:{ all -> 0x0049 }
        switch(r0) {
            case 1: goto L_0x0021;
            case 2: goto L_0x004c;
            case 3: goto L_0x004c;
            default: goto L_0x001e;
        };
    L_0x001e:
        r0 = 1;
    L_0x001f:
        monitor-exit(r5);
        return r0;
    L_0x0021:
        r0 = r5.XA;	 Catch:{ all -> 0x0049 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0049 }
        r1 = r0.iterator();	 Catch:{ all -> 0x0049 }
    L_0x002b:
        r0 = r1.hasNext();	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x001e;
    L_0x0031:
        r0 = r1.next();	 Catch:{ all -> 0x0049 }
        r0 = (com.google.android.gms.tagmanager.C0981n) r0;	 Catch:{ all -> 0x0049 }
        r3 = r0.getContainerId();	 Catch:{ all -> 0x0049 }
        r3 = r3.equals(r2);	 Catch:{ all -> 0x0049 }
        if (r3 == 0) goto L_0x002b;
    L_0x0041:
        r3 = 0;
        r0.bc(r3);	 Catch:{ all -> 0x0049 }
        r0.refresh();	 Catch:{ all -> 0x0049 }
        goto L_0x002b;
    L_0x0049:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x004c:
        r0 = r5.XA;	 Catch:{ all -> 0x0049 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0049 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0049 }
    L_0x0056:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x001e;
    L_0x005c:
        r0 = r3.next();	 Catch:{ all -> 0x0049 }
        r0 = (com.google.android.gms.tagmanager.C0981n) r0;	 Catch:{ all -> 0x0049 }
        r4 = r0.getContainerId();	 Catch:{ all -> 0x0049 }
        r4 = r4.equals(r2);	 Catch:{ all -> 0x0049 }
        if (r4 == 0) goto L_0x0077;
    L_0x006c:
        r4 = r1.jw();	 Catch:{ all -> 0x0049 }
        r0.bc(r4);	 Catch:{ all -> 0x0049 }
        r0.refresh();	 Catch:{ all -> 0x0049 }
        goto L_0x0056;
    L_0x0077:
        r4 = r0.iF();	 Catch:{ all -> 0x0049 }
        if (r4 == 0) goto L_0x0056;
    L_0x007d:
        r4 = 0;
        r0.bc(r4);	 Catch:{ all -> 0x0049 }
        r0.refresh();	 Catch:{ all -> 0x0049 }
        goto L_0x0056;
    L_0x0085:
        r0 = 0;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.TagManager.f(android.net.Uri):boolean");
    }

    public DataLayer getDataLayer() {
        return this.TN;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.Xz.m1233a(this.mContext, this, null, containerId, defaultContainerResourceId, this.Wj);
        a.iI();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.Xz.m1233a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.Wj);
        a.iI();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.Xz.m1233a(this.mContext, this, null, containerId, defaultContainerResourceId, this.Wj);
        a.iK();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.Xz.m1233a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.Wj);
        a.iK();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.Xz.m1233a(this.mContext, this, null, containerId, defaultContainerResourceId, this.Wj);
        a.iJ();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.Xz.m1233a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.Wj);
        a.iJ();
        return a;
    }

    public void setVerboseLoggingEnabled(boolean enableVerboseLogging) {
        bh.setLogLevel(enableVerboseLogging ? 2 : 5);
    }
}
