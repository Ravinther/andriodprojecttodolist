package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0237c.C0904f;
import com.google.android.gms.internal.C0237c.C0908j;
import com.google.android.gms.internal.fl;
import com.google.android.gms.internal.fn;
import com.google.android.gms.internal.jd.C0957a;
import com.google.android.gms.tagmanager.C0981n.C0402a;
import com.google.android.gms.tagmanager.bg.C0374a;
import com.google.android.gms.tagmanager.ce.C0377a;
import com.google.android.gms.tagmanager.cr.C0385c;

/* renamed from: com.google.android.gms.tagmanager.o */
class C0982o extends ca<ContainerHolder> {
    private final String TM;
    private long TR;
    private final TagManager TY;
    private final fl Ty;
    private final C0797d Ub;
    private final cg Uc;
    private final int Ud;
    private C0799f Ue;
    private volatile C0981n Uf;
    private volatile boolean Ug;
    private C0908j Uh;
    private String Ui;
    private C0798e Uj;
    private C0404a Uk;
    private final Context mContext;
    private final Looper zs;

    /* renamed from: com.google.android.gms.tagmanager.o.a */
    interface C0404a {
        boolean m1367b(Container container);
    }

    /* renamed from: com.google.android.gms.tagmanager.o.1 */
    class C07931 implements C0402a {
        final /* synthetic */ C0982o Ul;

        C07931(C0982o c0982o) {
            this.Ul = c0982o;
        }

        public void bc(String str) {
            this.Ul.bc(str);
        }

        public String iF() {
            return this.Ul.iF();
        }

        public void iH() {
            bh.m1269w("Refresh ignored: container loaded as default only.");
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.2 */
    class C07942 implements C0404a {
        final /* synthetic */ C0982o Ul;
        final /* synthetic */ boolean Um;

        C07942(C0982o c0982o, boolean z) {
            this.Ul = c0982o;
            this.Um = z;
        }

        public boolean m2341b(Container container) {
            return this.Um ? container.getLastRefreshTime() + 43200000 >= this.Ul.Ty.currentTimeMillis() : !container.isDefault();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.b */
    private class C0795b implements bg<C0957a> {
        final /* synthetic */ C0982o Ul;

        private C0795b(C0982o c0982o) {
            this.Ul = c0982o;
        }

        public void m2342a(C0957a c0957a) {
            C0908j c0908j;
            if (c0957a.Yc != null) {
                c0908j = c0957a.Yc;
            } else {
                C0904f c0904f = c0957a.fV;
                c0908j = new C0908j();
                c0908j.fV = c0904f;
                c0908j.fU = null;
                c0908j.fW = c0904f.fr;
            }
            this.Ul.m2902a(c0908j, c0957a.Yb, true);
        }

        public void m2343a(C0374a c0374a) {
            if (!this.Ul.Ug) {
                this.Ul.m2912s(0);
            }
        }

        public /* synthetic */ void m2344i(Object obj) {
            m2342a((C0957a) obj);
        }

        public void iM() {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.c */
    private class C0796c implements bg<C0908j> {
        final /* synthetic */ C0982o Ul;

        private C0796c(C0982o c0982o) {
            this.Ul = c0982o;
        }

        public void m2345a(C0374a c0374a) {
            if (this.Ul.Uf != null) {
                this.Ul.m2285a(this.Ul.Uf);
            } else {
                this.Ul.m2285a(this.Ul.m2914O(Status.zS));
            }
            this.Ul.m2912s(3600000);
        }

        public void m2346b(C0908j c0908j) {
            synchronized (this.Ul) {
                if (c0908j.fV == null) {
                    if (this.Ul.Uh.fV == null) {
                        bh.m1266t("Current resource is null; network resource is also null");
                        this.Ul.m2912s(3600000);
                        return;
                    }
                    c0908j.fV = this.Ul.Uh.fV;
                }
                this.Ul.m2902a(c0908j, this.Ul.Ty.currentTimeMillis(), false);
                bh.m1268v("setting refresh time to current time: " + this.Ul.TR);
                if (!this.Ul.iL()) {
                    this.Ul.m2901a(c0908j);
                }
            }
        }

        public /* synthetic */ void m2347i(Object obj) {
            m2346b((C0908j) obj);
        }

        public void iM() {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.d */
    private class C0797d implements C0402a {
        final /* synthetic */ C0982o Ul;

        private C0797d(C0982o c0982o) {
            this.Ul = c0982o;
        }

        public void bc(String str) {
            this.Ul.bc(str);
        }

        public String iF() {
            return this.Ul.iF();
        }

        public void iH() {
            if (this.Ul.Uc.cl()) {
                this.Ul.m2912s(0);
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.e */
    interface C0798e extends Releasable {
        void m2348a(bg<C0908j> bgVar);

        void bf(String str);

        void m2349d(long j, String str);
    }

    /* renamed from: com.google.android.gms.tagmanager.o.f */
    interface C0799f extends Releasable {
        void m2350a(bg<C0957a> bgVar);

        void m2351b(C0957a c0957a);

        C0385c bP(int i);

        void iN();
    }

    C0982o(Context context, TagManager tagManager, Looper looper, String str, int i, C0799f c0799f, C0798e c0798e, fl flVar, cg cgVar) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.mContext = context;
        this.TY = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.zs = looper;
        this.TM = str;
        this.Ud = i;
        this.Ue = c0799f;
        this.Uj = c0798e;
        this.Ub = new C0797d();
        this.Uh = new C0908j();
        this.Ty = flVar;
        this.Uc = cgVar;
        if (iL()) {
            bc(ce.ju().jw());
        }
    }

    public C0982o(Context context, TagManager tagManager, Looper looper, String str, int i, C0405r c0405r) {
        this(context, tagManager, looper, str, i, new cq(context, str), new cp(context, str, c0405r), fn.eI(), new bf(30, 900000, 5000, "refreshing", fn.eI()));
    }

    private synchronized void m2901a(C0908j c0908j) {
        if (this.Ue != null) {
            C0957a c0957a = new C0957a();
            c0957a.Yb = this.TR;
            c0957a.fV = new C0904f();
            c0957a.Yc = c0908j;
            this.Ue.m2351b(c0957a);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m2902a(com.google.android.gms.internal.C0237c.C0908j r9, long r10, boolean r12) {
        /*
        r8 = this;
        r6 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        monitor-enter(r8);
        if (r12 == 0) goto L_0x000c;
    L_0x0006:
        r0 = r8.Ug;	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r8);
        return;
    L_0x000c:
        r0 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x0016;
    L_0x0012:
        r0 = r8.Uf;	 Catch:{ all -> 0x006a }
        if (r0 != 0) goto L_0x0016;
    L_0x0016:
        r8.Uh = r9;	 Catch:{ all -> 0x006a }
        r8.TR = r10;	 Catch:{ all -> 0x006a }
        r0 = 0;
        r2 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        r4 = r8.TR;	 Catch:{ all -> 0x006a }
        r4 = r4 + r6;
        r6 = r8.Ty;	 Catch:{ all -> 0x006a }
        r6 = r6.currentTimeMillis();	 Catch:{ all -> 0x006a }
        r4 = r4 - r6;
        r2 = java.lang.Math.min(r2, r4);	 Catch:{ all -> 0x006a }
        r0 = java.lang.Math.max(r0, r2);	 Catch:{ all -> 0x006a }
        r8.m2912s(r0);	 Catch:{ all -> 0x006a }
        r0 = new com.google.android.gms.tagmanager.Container;	 Catch:{ all -> 0x006a }
        r1 = r8.mContext;	 Catch:{ all -> 0x006a }
        r2 = r8.TY;	 Catch:{ all -> 0x006a }
        r2 = r2.getDataLayer();	 Catch:{ all -> 0x006a }
        r3 = r8.TM;	 Catch:{ all -> 0x006a }
        r4 = r10;
        r6 = r9;
        r0.<init>(r1, r2, r3, r4, r6);	 Catch:{ all -> 0x006a }
        r1 = r8.Uf;	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x006d;
    L_0x0049:
        r1 = new com.google.android.gms.tagmanager.n;	 Catch:{ all -> 0x006a }
        r2 = r8.TY;	 Catch:{ all -> 0x006a }
        r3 = r8.zs;	 Catch:{ all -> 0x006a }
        r4 = r8.Ub;	 Catch:{ all -> 0x006a }
        r1.<init>(r2, r3, r0, r4);	 Catch:{ all -> 0x006a }
        r8.Uf = r1;	 Catch:{ all -> 0x006a }
    L_0x0056:
        r1 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x000a;
    L_0x005c:
        r1 = r8.Uk;	 Catch:{ all -> 0x006a }
        r0 = r1.m1367b(r0);	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000a;
    L_0x0064:
        r0 = r8.Uf;	 Catch:{ all -> 0x006a }
        r8.m2285a(r0);	 Catch:{ all -> 0x006a }
        goto L_0x000a;
    L_0x006a:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x006d:
        r1 = r8.Uf;	 Catch:{ all -> 0x006a }
        r1.m2899a(r0);	 Catch:{ all -> 0x006a }
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.o.a(com.google.android.gms.internal.c$j, long, boolean):void");
    }

    private boolean iL() {
        ce ju = ce.ju();
        return (ju.jv() == C0377a.CONTAINER || ju.jv() == C0377a.CONTAINER_DEBUG) && this.TM.equals(ju.getContainerId());
    }

    private synchronized void m2912s(long j) {
        if (this.Uj == null) {
            bh.m1269w("Refresh requested, but no network load scheduler.");
        } else {
            this.Uj.m2349d(j, this.Uh.fW);
        }
    }

    private void m2913z(boolean z) {
        this.Ue.m2350a(new C0795b());
        this.Uj.m2348a(new C0796c());
        C0385c bP = this.Ue.bP(this.Ud);
        if (bP != null) {
            this.Uf = new C0981n(this.TY, this.zs, new Container(this.mContext, this.TY.getDataLayer(), this.TM, 0, bP), this.Ub);
        }
        this.Uk = new C07942(this, z);
        if (iL()) {
            this.Uj.m2349d(0, "");
        } else {
            this.Ue.iN();
        }
    }

    protected ContainerHolder m2914O(Status status) {
        if (this.Uf != null) {
            return this.Uf;
        }
        if (status == Status.zS) {
            bh.m1266t("timer expired: setting result to failure");
        }
        return new C0981n(status);
    }

    synchronized void bc(String str) {
        this.Ui = str;
        if (this.Uj != null) {
            this.Uj.bf(str);
        }
    }

    protected /* synthetic */ Result m2915d(Status status) {
        return m2914O(status);
    }

    synchronized String iF() {
        return this.Ui;
    }

    public void iI() {
        C0385c bP = this.Ue.bP(this.Ud);
        if (bP != null) {
            m2285a(new C0981n(this.TY, this.zs, new Container(this.mContext, this.TY.getDataLayer(), this.TM, 0, bP), new C07931(this)));
        } else {
            String str = "Default was requested, but no default container was found";
            bh.m1266t(str);
            m2285a(m2914O(new Status(10, str, null)));
        }
        this.Uj = null;
        this.Ue = null;
    }

    public void iJ() {
        m2913z(false);
    }

    public void iK() {
        m2913z(true);
    }
}
