package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.internal.by.C0232a;
import com.google.android.gms.internal.ca.C0238a;
import com.google.android.gms.internal.cd.C0239a;
import com.google.android.gms.internal.de.C0250a;
import com.mobeta.android.dslv.DragSortController;
import org.json.JSONException;

public final class bz extends ct implements C0238a, C0250a {
    private final bf kH;
    private final Context mContext;
    private final Object mg;
    private ay mh;
    private final C0232a nM;
    private final Object nN;
    private final C0239a nO;
    private final C0296l nP;
    private ct nQ;
    private cf nR;
    private boolean nS;
    private aw nT;
    private bc nU;
    private final dd ng;

    /* renamed from: com.google.android.gms.internal.bz.1 */
    class C02331 implements Runnable {
        final /* synthetic */ bz nV;

        C02331(bz bzVar) {
            this.nV = bzVar;
        }

        public void run() {
            this.nV.onStop();
        }
    }

    /* renamed from: com.google.android.gms.internal.bz.2 */
    class C02342 implements Runnable {
        final /* synthetic */ bz nV;
        final /* synthetic */ cn nW;

        C02342(bz bzVar, cn cnVar) {
            this.nV = bzVar;
            this.nW = cnVar;
        }

        public void run() {
            synchronized (this.nV.mg) {
                this.nV.nM.m466a(this.nW);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bz.3 */
    class C02353 implements Runnable {
        final /* synthetic */ bz nV;

        C02353(bz bzVar) {
            this.nV = bzVar;
        }

        public void run() {
            synchronized (this.nV.mg) {
                if (this.nV.nR.errorCode != -2) {
                    return;
                }
                this.nV.ng.bb().m582a(this.nV);
                if (this.nV.nR.errorCode == -3) {
                    da.m565v("Loading URL in WebView: " + this.nV.nR.nw);
                    this.nV.ng.loadUrl(this.nV.nR.nw);
                } else {
                    da.m565v("Loading HTML in WebView.");
                    this.nV.ng.loadDataWithBaseURL(cv.m543p(this.nV.nR.nw), this.nV.nR.oi, "text/html", "UTF-8", null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bz.a */
    private static final class C0236a extends Exception {
        private final int nX;

        public C0236a(String str, int i) {
            super(str);
            this.nX = i;
        }

        public int getErrorCode() {
            return this.nX;
        }
    }

    public bz(Context context, C0239a c0239a, C0296l c0296l, dd ddVar, bf bfVar, C0232a c0232a) {
        this.nN = new Object();
        this.mg = new Object();
        this.nS = false;
        this.kH = bfVar;
        this.nM = c0232a;
        this.ng = ddVar;
        this.mContext = context;
        this.nO = c0239a;
        this.nP = c0296l;
    }

    private ab m1707a(cd cdVar) throws C0236a {
        if (this.nR.on == null) {
            throw new C0236a("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.nR.on.split("x");
        if (split.length != 2) {
            throw new C0236a("Could not parse the ad size from the ad response: " + this.nR.on, 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (ab abVar : cdVar.kQ.lp) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i = abVar.width == -1 ? (int) (((float) abVar.widthPixels) / f) : abVar.width;
                int i2 = abVar.height == -2 ? (int) (((float) abVar.heightPixels) / f) : abVar.height;
                if (parseInt == i && parseInt2 == i2) {
                    return new ab(abVar, cdVar.kQ.lp);
                }
            }
            throw new C0236a("The ad size from the ad response was not one of the requested sizes: " + this.nR.on, 0);
        } catch (NumberFormatException e) {
            throw new C0236a("Could not parse the ad size from the ad response: " + this.nR.on, 0);
        }
    }

    private void m1709a(cd cdVar, long j) throws C0236a {
        synchronized (this.nN) {
            this.nT = new aw(this.mContext, cdVar, this.kH, this.mh);
        }
        this.nU = this.nT.m424a(j, 60000);
        switch (this.nU.mL) {
            case DragSortController.ON_DOWN /*0*/:
            case Value.TYPE_FIELD_NUMBER /*1*/:
                throw new C0236a("No fill from any mediation ad networks.", 3);
            default:
                throw new C0236a("Unexpected mediation result: " + this.nU.mL, 0);
        }
    }

    private void aC() throws C0236a {
        if (this.nR.errorCode != -3) {
            if (TextUtils.isEmpty(this.nR.oi)) {
                throw new C0236a("No fill from ad server.", 3);
            } else if (this.nR.ok) {
                try {
                    this.mh = new ay(this.nR.oi);
                } catch (JSONException e) {
                    throw new C0236a("Could not parse mediation config: " + this.nR.oi, 0);
                }
            }
        }
    }

    private void m1711b(long j) throws C0236a {
        cz.pT.post(new C02353(this));
        m1715d(j);
    }

    private void m1713c(long j) throws C0236a {
        while (m1716e(j)) {
            if (this.nR != null) {
                synchronized (this.nN) {
                    this.nQ = null;
                }
                if (this.nR.errorCode != -2 && this.nR.errorCode != -3) {
                    throw new C0236a("There was a problem getting an ad response. ErrorCode: " + this.nR.errorCode, this.nR.errorCode);
                }
                return;
            }
        }
        throw new C0236a("Timed out waiting for ad response.", 2);
    }

    private void m1715d(long j) throws C0236a {
        while (m1716e(j)) {
            if (this.nS) {
                return;
            }
        }
        throw new C0236a("Timed out waiting for WebView to finish loading.", 2);
    }

    private boolean m1716e(long j) throws C0236a {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.mg.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new C0236a("Ad request cancelled.", -1);
        }
    }

    public void m1717a(cf cfVar) {
        synchronized (this.mg) {
            da.m562s("Received ad response.");
            this.nR = cfVar;
            this.mg.notify();
        }
    }

    public void m1718a(dd ddVar) {
        synchronized (this.mg) {
            da.m562s("WebView finished loading.");
            this.nS = true;
            this.mg.notify();
        }
    }

    public void aB() {
        synchronized (this.mg) {
            long j;
            ab abVar;
            da.m562s("AdLoaderBackgroundTask started.");
            cd cdVar = new cd(this.nO, this.nP.m1078y().m944a(this.mContext));
            ab abVar2 = null;
            int i = -2;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ct a = ca.m469a(this.mContext, cdVar, this);
                synchronized (this.nN) {
                    this.nQ = a;
                    if (this.nQ == null) {
                        throw new C0236a("Could not start the ad request service.", 0);
                    }
                }
                m1713c(elapsedRealtime);
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                aC();
                if (cdVar.kQ.lp != null) {
                    abVar2 = m1707a(cdVar);
                }
                if (this.nR.ok) {
                    m1709a(cdVar, elapsedRealtime);
                } else {
                    m1711b(elapsedRealtime);
                }
                j = elapsedRealtime2;
                abVar = abVar2;
            } catch (C0236a e) {
                i = e.getErrorCode();
                if (i == 3 || i == -1) {
                    da.m564u(e.getMessage());
                } else {
                    da.m566w(e.getMessage());
                }
                this.nR = new cf(i);
                cz.pT.post(new C02331(this));
                j = -1;
                abVar = null;
            }
            cz.pT.post(new C02342(this, new cn(cdVar.oc, this.ng, this.nR.mt, i, this.nR.mu, this.nR.om, this.nR.orientation, this.nR.mx, cdVar.of, this.nR.ok, this.nU != null ? this.nU.mM : null, this.nU != null ? this.nU.mN : null, this.nU != null ? this.nU.mO : null, this.mh, this.nU != null ? this.nU.mP : null, this.nR.ol, abVar, this.nR.oj, j, this.nR.oo)));
        }
    }

    public void onStop() {
        synchronized (this.nN) {
            if (this.nQ != null) {
                this.nQ.cancel();
            }
            this.ng.stopLoading();
            cv.m530a(this.ng);
            if (this.nT != null) {
                this.nT.cancel();
            }
        }
    }
}
