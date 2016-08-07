package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0237c.C0908j;
import com.google.android.gms.tagmanager.C0982o.C0798e;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class cp implements C0798e {
    private final String TM;
    private String Ui;
    private bg<C0908j> Wi;
    private C0405r Wj;
    private final ScheduledExecutorService Wl;
    private final C0378a Wm;
    private ScheduledFuture<?> Wn;
    private boolean mClosed;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.cp.a */
    interface C0378a {
        co m1291a(C0405r c0405r);
    }

    /* renamed from: com.google.android.gms.tagmanager.cp.b */
    interface C0379b {
        ScheduledExecutorService jB();
    }

    /* renamed from: com.google.android.gms.tagmanager.cp.1 */
    class C07771 implements C0379b {
        final /* synthetic */ cp Wo;

        C07771(cp cpVar) {
            this.Wo = cpVar;
        }

        public ScheduledExecutorService jB() {
            return Executors.newSingleThreadScheduledExecutor();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cp.2 */
    class C07782 implements C0378a {
        final /* synthetic */ cp Wo;

        C07782(cp cpVar) {
            this.Wo = cpVar;
        }

        public co m2309a(C0405r c0405r) {
            return new co(this.Wo.mContext, this.Wo.TM, c0405r);
        }
    }

    public cp(Context context, String str, C0405r c0405r) {
        this(context, str, c0405r, null, null);
    }

    cp(Context context, String str, C0405r c0405r, C0379b c0379b, C0378a c0378a) {
        this.Wj = c0405r;
        this.mContext = context;
        this.TM = str;
        if (c0379b == null) {
            c0379b = new C07771(this);
        }
        this.Wl = c0379b.jB();
        if (c0378a == null) {
            this.Wm = new C07782(this);
        } else {
            this.Wm = c0378a;
        }
    }

    private co bv(String str) {
        co a = this.Wm.m1291a(this.Wj);
        a.m1290a(this.Wi);
        a.bf(this.Ui);
        a.bu(str);
        return a;
    }

    private synchronized void jA() {
        if (this.mClosed) {
            throw new IllegalStateException("called method after closed");
        }
    }

    public synchronized void m2881a(bg<C0908j> bgVar) {
        jA();
        this.Wi = bgVar;
    }

    public synchronized void bf(String str) {
        jA();
        this.Ui = str;
    }

    public synchronized void m2882d(long j, String str) {
        bh.m1268v("loadAfterDelay: containerId=" + this.TM + " delay=" + j);
        jA();
        if (this.Wi == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.Wn != null) {
            this.Wn.cancel(false);
        }
        this.Wn = this.Wl.schedule(bv(str), j, TimeUnit.MILLISECONDS);
    }

    public synchronized void release() {
        jA();
        if (this.Wn != null) {
            this.Wn.cancel(false);
        }
        this.Wl.shutdown();
        this.mClosed = true;
    }
}
