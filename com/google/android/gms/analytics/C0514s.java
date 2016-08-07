package com.google.android.gms.analytics;

import android.content.Context;
import android.content.Intent;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.analytics.C0507c.C0095b;
import com.google.android.gms.analytics.C0507c.C0096c;
import com.google.android.gms.internal.di;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.google.android.gms.analytics.s */
class C0514s implements ag, C0095b, C0096c {
    private final Context mContext;
    private final GoogleAnalytics rA;
    private final Queue<C0117d> rB;
    private volatile int rC;
    private volatile Timer rD;
    private volatile Timer rE;
    private volatile Timer rF;
    private boolean rG;
    private boolean rH;
    private boolean rI;
    private C0101i rJ;
    private long rK;
    private C0097d rj;
    private final C0099f rk;
    private boolean rm;
    private volatile long rw;
    private volatile C0114a rx;
    private volatile C0093b ry;
    private C0097d rz;

    /* renamed from: com.google.android.gms.analytics.s.2 */
    class C01122 implements Runnable {
        final /* synthetic */ C0514s rL;

        C01122(C0514s c0514s) {
            this.rL = c0514s;
        }

        public void run() {
            this.rL.bJ();
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.3 */
    static /* synthetic */ class C01133 {
        static final /* synthetic */ int[] rM;

        static {
            rM = new int[C0114a.values().length];
            try {
                rM[C0114a.CONNECTED_LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                rM[C0114a.CONNECTED_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                rM[C0114a.CONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                rM[C0114a.PENDING_CONNECTION.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                rM[C0114a.PENDING_DISCONNECT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                rM[C0114a.DISCONNECTED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.a */
    private enum C0114a {
        CONNECTING,
        CONNECTED_SERVICE,
        CONNECTED_LOCAL,
        BLOCKED,
        PENDING_CONNECTION,
        PENDING_DISCONNECT,
        DISCONNECTED
    }

    /* renamed from: com.google.android.gms.analytics.s.b */
    private class C0115b extends TimerTask {
        final /* synthetic */ C0514s rL;

        private C0115b(C0514s c0514s) {
            this.rL = c0514s;
        }

        public void run() {
            if (this.rL.rx == C0114a.CONNECTED_SERVICE && this.rL.rB.isEmpty() && this.rL.rw + this.rL.rK < this.rL.rJ.currentTimeMillis()) {
                aa.m46v("Disconnecting due to inactivity");
                this.rL.aD();
                return;
            }
            this.rL.rF.schedule(new C0115b(this.rL), this.rL.rK);
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.c */
    private class C0116c extends TimerTask {
        final /* synthetic */ C0514s rL;

        private C0116c(C0514s c0514s) {
            this.rL = c0514s;
        }

        public void run() {
            if (this.rL.rx == C0114a.CONNECTING) {
                this.rL.bL();
            }
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.d */
    private static class C0117d {
        private final Map<String, String> rV;
        private final long rW;
        private final String rX;
        private final List<di> rY;

        public C0117d(Map<String, String> map, long j, String str, List<di> list) {
            this.rV = map;
            this.rW = j;
            this.rX = str;
            this.rY = list;
        }

        public Map<String, String> bO() {
            return this.rV;
        }

        public long bP() {
            return this.rW;
        }

        public List<di> bQ() {
            return this.rY;
        }

        public String getPath() {
            return this.rX;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PATH: ");
            stringBuilder.append(this.rX);
            if (this.rV != null) {
                stringBuilder.append("  PARAMS: ");
                for (Entry entry : this.rV.entrySet()) {
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append("=");
                    stringBuilder.append((String) entry.getValue());
                    stringBuilder.append(",  ");
                }
            }
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.e */
    private class C0118e extends TimerTask {
        final /* synthetic */ C0514s rL;

        private C0118e(C0514s c0514s) {
            this.rL = c0514s;
        }

        public void run() {
            this.rL.bM();
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.1 */
    class C05131 implements C0101i {
        final /* synthetic */ C0514s rL;

        C05131(C0514s c0514s) {
            this.rL = c0514s;
        }

        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }
    }

    C0514s(Context context, C0099f c0099f) {
        this(context, c0099f, null, GoogleAnalytics.getInstance(context));
    }

    C0514s(Context context, C0099f c0099f, C0097d c0097d, GoogleAnalytics googleAnalytics) {
        this.rB = new ConcurrentLinkedQueue();
        this.rK = 300000;
        this.rz = c0097d;
        this.mContext = context;
        this.rk = c0099f;
        this.rA = googleAnalytics;
        this.rJ = new C05131(this);
        this.rC = 0;
        this.rx = C0114a.DISCONNECTED;
    }

    private Timer m1473a(Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
        return null;
    }

    private synchronized void aD() {
        if (this.ry != null && this.rx == C0114a.CONNECTED_SERVICE) {
            this.rx = C0114a.PENDING_DISCONNECT;
            this.ry.disconnect();
        }
    }

    private void bH() {
        this.rD = m1473a(this.rD);
        this.rE = m1473a(this.rE);
        this.rF = m1473a(this.rF);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void bJ() {
        /*
        r7 = this;
        monitor-enter(r7);
        r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0074 }
        r2 = r7.rk;	 Catch:{ all -> 0x0074 }
        r2 = r2.getThread();	 Catch:{ all -> 0x0074 }
        r1 = r1.equals(r2);	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x0021;
    L_0x0011:
        r1 = r7.rk;	 Catch:{ all -> 0x0074 }
        r1 = r1.bs();	 Catch:{ all -> 0x0074 }
        r2 = new com.google.android.gms.analytics.s$2;	 Catch:{ all -> 0x0074 }
        r2.<init>(r7);	 Catch:{ all -> 0x0074 }
        r1.add(r2);	 Catch:{ all -> 0x0074 }
    L_0x001f:
        monitor-exit(r7);
        return;
    L_0x0021:
        r1 = r7.rG;	 Catch:{ all -> 0x0074 }
        if (r1 == 0) goto L_0x0028;
    L_0x0025:
        r7.bk();	 Catch:{ all -> 0x0074 }
    L_0x0028:
        r1 = com.google.android.gms.analytics.C0514s.C01133.rM;	 Catch:{ all -> 0x0074 }
        r2 = r7.rx;	 Catch:{ all -> 0x0074 }
        r2 = r2.ordinal();	 Catch:{ all -> 0x0074 }
        r1 = r1[r2];	 Catch:{ all -> 0x0074 }
        switch(r1) {
            case 1: goto L_0x0036;
            case 2: goto L_0x007f;
            case 3: goto L_0x0035;
            case 4: goto L_0x0035;
            case 5: goto L_0x0035;
            case 6: goto L_0x00da;
            default: goto L_0x0035;
        };	 Catch:{ all -> 0x0074 }
    L_0x0035:
        goto L_0x001f;
    L_0x0036:
        r1 = r7.rB;	 Catch:{ all -> 0x0074 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x0077;
    L_0x003e:
        r1 = r7.rB;	 Catch:{ all -> 0x0074 }
        r1 = r1.poll();	 Catch:{ all -> 0x0074 }
        r0 = r1;
        r0 = (com.google.android.gms.analytics.C0514s.C0117d) r0;	 Catch:{ all -> 0x0074 }
        r6 = r0;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r1.<init>();	 Catch:{ all -> 0x0074 }
        r2 = "Sending hit to store  ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0074 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x0074 }
        r1 = r1.toString();	 Catch:{ all -> 0x0074 }
        com.google.android.gms.analytics.aa.m46v(r1);	 Catch:{ all -> 0x0074 }
        r1 = r7.rj;	 Catch:{ all -> 0x0074 }
        r2 = r6.bO();	 Catch:{ all -> 0x0074 }
        r3 = r6.bP();	 Catch:{ all -> 0x0074 }
        r5 = r6.getPath();	 Catch:{ all -> 0x0074 }
        r6 = r6.bQ();	 Catch:{ all -> 0x0074 }
        r1.m62a(r2, r3, r5, r6);	 Catch:{ all -> 0x0074 }
        goto L_0x0036;
    L_0x0074:
        r1 = move-exception;
        monitor-exit(r7);
        throw r1;
    L_0x0077:
        r1 = r7.rm;	 Catch:{ all -> 0x0074 }
        if (r1 == 0) goto L_0x001f;
    L_0x007b:
        r7.bK();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x007f:
        r1 = r7.rB;	 Catch:{ all -> 0x0074 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x00d0;
    L_0x0087:
        r1 = r7.rB;	 Catch:{ all -> 0x0074 }
        r1 = r1.peek();	 Catch:{ all -> 0x0074 }
        r0 = r1;
        r0 = (com.google.android.gms.analytics.C0514s.C0117d) r0;	 Catch:{ all -> 0x0074 }
        r6 = r0;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r1.<init>();	 Catch:{ all -> 0x0074 }
        r2 = "Sending hit to service   ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0074 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x0074 }
        r1 = r1.toString();	 Catch:{ all -> 0x0074 }
        com.google.android.gms.analytics.aa.m46v(r1);	 Catch:{ all -> 0x0074 }
        r1 = r7.rA;	 Catch:{ all -> 0x0074 }
        r1 = r1.isDryRunEnabled();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x00ca;
    L_0x00af:
        r1 = r7.ry;	 Catch:{ all -> 0x0074 }
        r2 = r6.bO();	 Catch:{ all -> 0x0074 }
        r3 = r6.bP();	 Catch:{ all -> 0x0074 }
        r5 = r6.getPath();	 Catch:{ all -> 0x0074 }
        r6 = r6.bQ();	 Catch:{ all -> 0x0074 }
        r1.m60a(r2, r3, r5, r6);	 Catch:{ all -> 0x0074 }
    L_0x00c4:
        r1 = r7.rB;	 Catch:{ all -> 0x0074 }
        r1.poll();	 Catch:{ all -> 0x0074 }
        goto L_0x007f;
    L_0x00ca:
        r1 = "Dry run enabled. Hit not actually sent to service.";
        com.google.android.gms.analytics.aa.m46v(r1);	 Catch:{ all -> 0x0074 }
        goto L_0x00c4;
    L_0x00d0:
        r1 = r7.rJ;	 Catch:{ all -> 0x0074 }
        r1 = r1.currentTimeMillis();	 Catch:{ all -> 0x0074 }
        r7.rw = r1;	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x00da:
        r1 = "Need to reconnect";
        com.google.android.gms.analytics.aa.m46v(r1);	 Catch:{ all -> 0x0074 }
        r1 = r7.rB;	 Catch:{ all -> 0x0074 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x001f;
    L_0x00e7:
        r7.bM();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.s.bJ():void");
    }

    private void bK() {
        this.rj.bp();
        this.rm = false;
    }

    private synchronized void bL() {
        if (this.rx != C0114a.CONNECTED_LOCAL) {
            bH();
            aa.m46v("falling back to local store");
            if (this.rz != null) {
                this.rj = this.rz;
            } else {
                C0512r bB = C0512r.bB();
                bB.m1470a(this.mContext, this.rk);
                this.rj = bB.bE();
            }
            this.rx = C0114a.CONNECTED_LOCAL;
            bJ();
        }
    }

    private synchronized void bM() {
        if (this.rI || this.ry == null || this.rx == C0114a.CONNECTED_LOCAL) {
            aa.m47w("client not initialized.");
            bL();
        } else {
            try {
                this.rC++;
                m1473a(this.rE);
                this.rx = C0114a.CONNECTING;
                this.rE = new Timer("Failed Connect");
                this.rE.schedule(new C0116c(), 3000);
                aa.m46v("connecting to Analytics service");
                this.ry.connect();
            } catch (SecurityException e) {
                aa.m47w("security exception on connectToService");
                bL();
            }
        }
    }

    private void bN() {
        this.rD = m1473a(this.rD);
        this.rD = new Timer("Service Reconnect");
        this.rD.schedule(new C0118e(), 5000);
    }

    public synchronized void m1484a(int i, Intent intent) {
        this.rx = C0114a.PENDING_CONNECTION;
        if (this.rC < 2) {
            aa.m47w("Service unavailable (code=" + i + "), will retry.");
            bN();
        } else {
            aa.m47w("Service unavailable (code=" + i + "), using local store.");
            bL();
        }
    }

    public void m1485b(Map<String, String> map, long j, String str, List<di> list) {
        aa.m46v("putHit called");
        this.rB.add(new C0117d(map, j, str, list));
        bJ();
    }

    public void bI() {
        if (this.ry == null) {
            this.ry = new C0507c(this.mContext, this, this);
            bM();
        }
    }

    public void bk() {
        aa.m46v("clearHits called");
        this.rB.clear();
        switch (C01133.rM[this.rx.ordinal()]) {
            case Value.TYPE_FIELD_NUMBER /*1*/:
                this.rj.m63i(0);
                this.rG = false;
            case Value.STRING_FIELD_NUMBER /*2*/:
                this.ry.bk();
                this.rG = false;
            default:
                this.rG = true;
        }
    }

    public void bp() {
        switch (C01133.rM[this.rx.ordinal()]) {
            case Value.TYPE_FIELD_NUMBER /*1*/:
                bK();
            case Value.STRING_FIELD_NUMBER /*2*/:
            default:
                this.rm = true;
        }
    }

    public synchronized void br() {
        if (!this.rI) {
            aa.m46v("setForceLocalDispatch called.");
            this.rI = true;
            switch (C01133.rM[this.rx.ordinal()]) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    aD();
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    this.rH = true;
                    break;
                default:
                    break;
            }
        }
    }

    public synchronized void onConnected() {
        this.rE = m1473a(this.rE);
        this.rC = 0;
        aa.m46v("Connected to service");
        this.rx = C0114a.CONNECTED_SERVICE;
        if (this.rH) {
            aD();
            this.rH = false;
        } else {
            bJ();
            this.rF = m1473a(this.rF);
            this.rF = new Timer("disconnect check");
            this.rF.schedule(new C0115b(), this.rK);
        }
    }

    public synchronized void onDisconnected() {
        if (this.rx == C0114a.PENDING_DISCONNECT) {
            aa.m46v("Disconnected from service");
            bH();
            this.rx = C0114a.DISCONNECTED;
        } else {
            aa.m46v("Unexpected disconnect.");
            this.rx = C0114a.PENDING_CONNECTION;
            if (this.rC < 2) {
                bN();
            } else {
                bL();
            }
        }
    }
}
