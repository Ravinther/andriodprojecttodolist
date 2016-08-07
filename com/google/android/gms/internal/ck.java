package com.google.android.gms.internal;

import com.google.android.gms.plus.PlusShare;
import java.util.Map;

public final class ck {
    private final Object mg;
    private int nX;
    private dd ng;
    public final ar oA;
    private String ox;
    private String oy;
    public final ar oz;

    /* renamed from: com.google.android.gms.internal.ck.1 */
    class C05941 implements ar {
        final /* synthetic */ ck oB;

        C05941(ck ckVar) {
            this.oB = ckVar;
        }

        public void m1722a(dd ddVar, Map<String, String> map) {
            synchronized (this.oB.mg) {
                String str = (String) map.get("errors");
                da.m566w("Invalid " + ((String) map.get("type")) + " request error: " + str);
                this.oB.nX = 1;
                this.oB.mg.notify();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ck.2 */
    class C05952 implements ar {
        final /* synthetic */ ck oB;

        C05952(ck ckVar) {
            this.oB = ckVar;
        }

        public void m1723a(dd ddVar, Map<String, String> map) {
            synchronized (this.oB.mg) {
                String str = (String) map.get(PlusShare.KEY_CALL_TO_ACTION_URL);
                if (str == null) {
                    da.m566w("URL missing in loadAdUrl GMSG.");
                    return;
                }
                if (str.contains("%40mediation_adapters%40")) {
                    str = str.replaceAll("%40mediation_adapters%40", cs.m520b(ddVar.getContext(), (String) map.get("check_adapters"), this.oB.ox));
                    da.m565v("Ad request URL modified to " + str);
                }
                this.oB.oy = str;
                this.oB.mg.notify();
            }
        }
    }

    public ck(String str) {
        this.mg = new Object();
        this.nX = -2;
        this.oz = new C05941(this);
        this.oA = new C05952(this);
        this.ox = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String aI() {
        /*
        r3 = this;
        r1 = r3.mg;
        monitor-enter(r1);
    L_0x0003:
        r0 = r3.oy;	 Catch:{ all -> 0x001f }
        if (r0 != 0) goto L_0x001b;
    L_0x0007:
        r0 = r3.nX;	 Catch:{ all -> 0x001f }
        r2 = -2;
        if (r0 != r2) goto L_0x001b;
    L_0x000c:
        r0 = r3.mg;	 Catch:{ InterruptedException -> 0x0012 }
        r0.wait();	 Catch:{ InterruptedException -> 0x0012 }
        goto L_0x0003;
    L_0x0012:
        r0 = move-exception;
        r0 = "Ad request service was interrupted.";
        com.google.android.gms.internal.da.m566w(r0);	 Catch:{ all -> 0x001f }
        r0 = 0;
        monitor-exit(r1);	 Catch:{ all -> 0x001f }
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = r3.oy;	 Catch:{ all -> 0x001f }
        monitor-exit(r1);	 Catch:{ all -> 0x001f }
        goto L_0x001a;
    L_0x001f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001f }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ck.aI():java.lang.String");
    }

    public void m491b(dd ddVar) {
        synchronized (this.mg) {
            this.ng = ddVar;
        }
    }

    public int getErrorCode() {
        int i;
        synchronized (this.mg) {
            i = this.nX;
        }
        return i;
    }
}
