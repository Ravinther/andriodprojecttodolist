package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ViewSwitcher;
import com.google.android.gms.dynamic.C0192b;
import com.google.android.gms.dynamic.C0882c;
import com.google.android.gms.internal.ag.C0569a;
import com.google.android.gms.internal.by.C0232a;
import com.google.android.gms.internal.cd.C0239a;
import java.util.HashSet;

/* renamed from: com.google.android.gms.internal.v */
public final class C0959v extends C0569a implements ap, az, br, bu, C0232a, C0305u {
    private final bf kH;
    private final C0306a kI;
    private final C0308w kJ;

    /* renamed from: com.google.android.gms.internal.v.a */
    public static final class C0306a {
        public final String adUnitId;
        public final ViewSwitcher kK;
        public final Context kL;
        public final C0296l kM;
        public final db kN;
        public af kO;
        public ct kP;
        public ab kQ;
        public cn kR;
        public co kS;
        public ai kT;
        public cr kU;
        private HashSet<co> kV;

        public C0306a(Context context, ab abVar, String str, db dbVar) {
            this.kU = null;
            this.kV = null;
            if (abVar.lo) {
                this.kK = null;
            } else {
                this.kK = new ViewSwitcher(context);
                this.kK.setMinimumWidth(abVar.widthPixels);
                this.kK.setMinimumHeight(abVar.heightPixels);
                this.kK.setVisibility(4);
            }
            this.kQ = abVar;
            this.adUnitId = str;
            this.kL = context;
            this.kM = new C0296l(C1061k.m3120a(dbVar.pU, context));
            this.kN = dbVar;
        }

        public void m1106a(HashSet<co> hashSet) {
            this.kV = hashSet;
        }

        public HashSet<co> ah() {
            return this.kV;
        }
    }

    public C0959v(Context context, ab abVar, String str, bf bfVar, db dbVar) {
        this.kI = new C0306a(context, abVar, str, dbVar);
        this.kH = bfVar;
        this.kJ = new C0308w(this);
        da.m564u("Use AdRequest.Builder.addTestDevice(\"" + cz.m557l(context) + "\") to get test ads on this device.");
        cv.m538i(context);
    }

    private void m2819a(int i) {
        da.m566w("Failed to load ad: " + i);
        if (this.kI.kO != null) {
            try {
                this.kI.kO.onAdFailedToLoad(i);
            } catch (Throwable e) {
                da.m560b("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
    }

    private void aa() {
        da.m564u("Ad closing.");
        if (this.kI.kO != null) {
            try {
                this.kI.kO.onAdClosed();
            } catch (Throwable e) {
                da.m560b("Could not call AdListener.onAdClosed().", e);
            }
        }
    }

    private void ab() {
        da.m564u("Ad leaving application.");
        if (this.kI.kO != null) {
            try {
                this.kI.kO.onAdLeftApplication();
            } catch (Throwable e) {
                da.m560b("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
    }

    private void ac() {
        da.m564u("Ad opening.");
        if (this.kI.kO != null) {
            try {
                this.kI.kO.onAdOpened();
            } catch (Throwable e) {
                da.m560b("Could not call AdListener.onAdOpened().", e);
            }
        }
    }

    private void ad() {
        da.m564u("Ad finished loading.");
        if (this.kI.kO != null) {
            try {
                this.kI.kO.onAdLoaded();
            } catch (Throwable e) {
                da.m560b("Could not call AdListener.onAdLoaded().", e);
            }
        }
    }

    private boolean ae() {
        boolean z = true;
        if (!cv.m533a(this.kI.kL.getPackageManager(), this.kI.kL.getPackageName(), "android.permission.INTERNET")) {
            if (!this.kI.kQ.lo) {
                cz.m556a(this.kI.kK, this.kI.kQ, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            }
            z = false;
        }
        if (!cv.m537h(this.kI.kL)) {
            if (!this.kI.kQ.lo) {
                cz.m556a(this.kI.kK, this.kI.kQ, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            }
            z = false;
        }
        if (!(z || this.kI.kQ.lo)) {
            this.kI.kK.setVisibility(0);
        }
        return z;
    }

    private void af() {
        if (this.kI.kR == null) {
            da.m566w("Ad state was null when trying to ping click URLs.");
            return;
        }
        da.m562s("Pinging click URLs.");
        this.kI.kS.aK();
        if (this.kI.kR.mt != null) {
            cv.m528a(this.kI.kL, this.kI.kN.pU, this.kI.kR.mt);
        }
        if (this.kI.kR.pf != null && this.kI.kR.pf.mt != null) {
            bd.m433a(this.kI.kL, this.kI.kN.pU, this.kI.kR, this.kI.adUnitId, false, this.kI.kR.pf.mt);
        }
    }

    private void ag() {
        if (this.kI.kR != null) {
            this.kI.kR.nu.destroy();
            this.kI.kR = null;
        }
    }

    private void m2820b(View view) {
        this.kI.kK.addView(view, new LayoutParams(-2, -2));
    }

    private void m2821b(boolean z) {
        if (this.kI.kR == null) {
            da.m566w("Ad state was null when trying to ping impression URLs.");
            return;
        }
        da.m562s("Pinging Impression URLs.");
        this.kI.kS.aJ();
        if (this.kI.kR.mu != null) {
            cv.m528a(this.kI.kL, this.kI.kN.pU, this.kI.kR.mu);
        }
        if (!(this.kI.kR.pf == null || this.kI.kR.pf.mu == null)) {
            bd.m433a(this.kI.kL, this.kI.kN.pU, this.kI.kR, this.kI.adUnitId, z, this.kI.kR.pf.mu);
        }
        if (this.kI.kR.mM != null && this.kI.kR.mM.mp != null) {
            bd.m433a(this.kI.kL, this.kI.kN.pU, this.kI.kR, this.kI.adUnitId, z, this.kI.kR.mM.mp);
        }
    }

    private boolean m2822b(cn cnVar) {
        View view;
        if (cnVar.ok) {
            try {
                view = (View) C0882c.m2445b(cnVar.mN.getView());
                View nextView = this.kI.kK.getNextView();
                if (nextView != null) {
                    this.kI.kK.removeView(nextView);
                }
                try {
                    m2820b(view);
                } catch (Throwable th) {
                    da.m560b("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            } catch (Throwable th2) {
                da.m560b("Could not get View from mediation adapter.", th2);
                return false;
            }
        } else if (cnVar.pg != null) {
            cnVar.nu.m573a(cnVar.pg);
            this.kI.kK.removeAllViews();
            this.kI.kK.setMinimumWidth(cnVar.pg.widthPixels);
            this.kI.kK.setMinimumHeight(cnVar.pg.heightPixels);
            m2820b(cnVar.nu);
        }
        if (this.kI.kK.getChildCount() > 1) {
            this.kI.kK.showNext();
        }
        if (this.kI.kR != null) {
            view = this.kI.kK.getNextView();
            if (view instanceof dd) {
                ((dd) view).m572a(this.kI.kL, this.kI.kQ);
            } else if (view != null) {
                this.kI.kK.removeView(view);
            }
            if (this.kI.kR.mN != null) {
                try {
                    this.kI.kR.mN.destroy();
                } catch (RemoteException e) {
                    da.m566w("Could not destroy previous mediation adapter.");
                }
            }
        }
        this.kI.kK.setVisibility(0);
        return true;
    }

    private C0239a m2823c(C0673z c0673z) {
        PackageInfo packageInfo;
        Bundle bundle;
        ApplicationInfo applicationInfo = this.kI.kL.getApplicationInfo();
        try {
            packageInfo = this.kI.kL.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        if (this.kI.kQ.lo || this.kI.kK.getParent() == null) {
            bundle = null;
        } else {
            int[] iArr = new int[2];
            this.kI.kK.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            DisplayMetrics displayMetrics = this.kI.kL.getResources().getDisplayMetrics();
            int width = this.kI.kK.getWidth();
            int height = this.kI.kK.getHeight();
            int i3 = (!this.kI.kK.isShown() || i + width <= 0 || i2 + height <= 0 || i > displayMetrics.widthPixels || i2 > displayMetrics.heightPixels) ? 0 : 1;
            bundle = new Bundle(5);
            bundle.putInt("x", i);
            bundle.putInt("y", i2);
            bundle.putInt("width", width);
            bundle.putInt("height", height);
            bundle.putInt("visible", i3);
        }
        String aP = cp.aP();
        this.kI.kS = new co(aP, this.kI.adUnitId);
        this.kI.kS.m508f(c0673z);
        return new C0239a(bundle, c0673z, this.kI.kQ, this.kI.adUnitId, applicationInfo, packageInfo, aP, cp.pu, this.kI.kN, cp.m513a(this.kI, aP, this.kI.kL));
    }

    public void m2824O() {
        af();
    }

    public C0192b m2825P() {
        er.ac("getAdFrame must be called on the main UI thread.");
        return C0882c.m2446h(this.kI.kK);
    }

    public ab m2826Q() {
        er.ac("getAdSize must be called on the main UI thread.");
        return this.kI.kQ;
    }

    public void m2827R() {
        ab();
    }

    public void m2828S() {
        if (this.kI.kQ.lo) {
            ag();
        }
        aa();
        this.kI.kS.aL();
    }

    public void m2829T() {
        if (this.kI.kQ.lo) {
            m2821b(false);
        }
        ac();
    }

    public void m2830U() {
        m2824O();
    }

    public void m2831V() {
        m2828S();
    }

    public void m2832W() {
        m2827R();
    }

    public void m2833X() {
        m2829T();
    }

    public void m2834Y() {
        if (this.kI.kR != null) {
            da.m566w("Mediation adapter " + this.kI.kR.mO + " refreshed, but mediation adapters should never refresh.");
        }
        m2821b(true);
        ad();
    }

    public void m2835Z() {
        er.ac("recordManualImpression must be called on the main UI thread.");
        if (this.kI.kR == null) {
            da.m566w("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        da.m562s("Pinging manual tracking URLs.");
        if (this.kI.kR.om != null) {
            cv.m528a(this.kI.kL, this.kI.kN.pU, this.kI.kR.om);
        }
    }

    public void m2836a(ab abVar) {
        er.ac("setAdSize must be called on the main UI thread.");
        this.kI.kQ = abVar;
        if (this.kI.kR != null) {
            this.kI.kR.nu.m573a(abVar);
        }
        if (this.kI.kK.getChildCount() > 1) {
            this.kI.kK.removeView(this.kI.kK.getNextView());
        }
        this.kI.kK.setMinimumWidth(abVar.widthPixels);
        this.kI.kK.setMinimumHeight(abVar.heightPixels);
        this.kI.kK.requestLayout();
    }

    public void m2837a(af afVar) {
        er.ac("setAdListener must be called on the main UI thread.");
        this.kI.kO = afVar;
    }

    public void m2838a(ai aiVar) {
        er.ac("setAppEventListener must be called on the main UI thread.");
        this.kI.kT = aiVar;
    }

    public void m2839a(cn cnVar) {
        int i = 0;
        this.kI.kP = null;
        if (!(cnVar.errorCode == -2 || cnVar.errorCode == 3)) {
            cp.m515a(this.kI);
        }
        if (cnVar.errorCode != -1) {
            boolean z = cnVar.oc.extras != null ? cnVar.oc.extras.getBoolean("_noRefresh", false) : false;
            if (this.kI.kQ.lo) {
                cv.m530a(cnVar.nu);
            } else if (!z) {
                if (cnVar.mx > 0) {
                    this.kJ.m1109a(cnVar.oc, cnVar.mx);
                } else if (cnVar.pf != null && cnVar.pf.mx > 0) {
                    this.kJ.m1109a(cnVar.oc, cnVar.pf.mx);
                } else if (!cnVar.ok && cnVar.errorCode == 2) {
                    this.kJ.m1110d(cnVar.oc);
                }
            }
            if (!(cnVar.errorCode != 3 || cnVar.pf == null || cnVar.pf.mv == null)) {
                da.m562s("Pinging no fill URLs.");
                bd.m433a(this.kI.kL, this.kI.kN.pU, cnVar, this.kI.adUnitId, false, cnVar.pf.mv);
            }
            if (cnVar.errorCode != -2) {
                m2819a(cnVar.errorCode);
            } else if (this.kI.kQ.lo || m2822b(cnVar)) {
                int i2;
                if (!(this.kI.kR == null || this.kI.kR.mP == null)) {
                    this.kI.kR.mP.m2476a(null);
                }
                if (cnVar.mP != null) {
                    cnVar.mP.m2476a((az) this);
                }
                this.kI.kR = cnVar;
                if (cnVar.pg != null) {
                    this.kI.kQ = cnVar.pg;
                }
                this.kI.kS.m509g(cnVar.ph);
                this.kI.kS.m510h(cnVar.pi);
                this.kI.kS.m511k(this.kI.kQ.lo);
                this.kI.kS.m512l(cnVar.ok);
                if (!this.kI.kQ.lo) {
                    m2821b(false);
                }
                if (this.kI.kU == null) {
                    this.kI.kU = new cr(this.kI.adUnitId);
                }
                if (cnVar.pf != null) {
                    i2 = cnVar.pf.my;
                    i = cnVar.pf.mz;
                } else {
                    i2 = 0;
                }
                this.kI.kU.m519a(i2, i);
                ad();
            } else {
                m2819a(0);
            }
        }
    }

    public boolean m2840a(C0673z c0673z) {
        er.ac("loadAd must be called on the main UI thread.");
        if (this.kI.kP != null) {
            da.m566w("An ad request is already in progress. Aborting.");
            return false;
        } else if (this.kI.kQ.lo && this.kI.kR != null) {
            da.m566w("An interstitial is already loading. Aborting.");
            return false;
        } else if (!ae()) {
            return false;
        } else {
            dd ddVar;
            da.m564u("Starting ad request.");
            this.kJ.cancel();
            C0239a c = m2823c(c0673z);
            if (this.kI.kQ.lo) {
                dd a = dd.m570a(this.kI.kL, this.kI.kQ, false, false, this.kI.kM, this.kI.kN);
                a.bb().m583a(this, null, this, this, true);
                ddVar = a;
            } else {
                dd ddVar2;
                View nextView = this.kI.kK.getNextView();
                if (nextView instanceof dd) {
                    ddVar2 = (dd) nextView;
                    ddVar2.m572a(this.kI.kL, this.kI.kQ);
                } else {
                    if (nextView != null) {
                        this.kI.kK.removeView(nextView);
                    }
                    nextView = dd.m570a(this.kI.kL, this.kI.kQ, false, false, this.kI.kM, this.kI.kN);
                    if (this.kI.kQ.lp == null) {
                        m2820b(nextView);
                    }
                }
                ddVar2.bb().m583a(this, this, this, this, false);
                ddVar = ddVar2;
            }
            this.kI.kP = by.m467a(this.kI.kL, c, this.kI.kM, ddVar, this.kH, this);
            return true;
        }
    }

    public void m2841b(C0673z c0673z) {
        ViewParent parent = this.kI.kK.getParent();
        if ((parent instanceof View) && ((View) parent).isShown() && cv.aS()) {
            m2840a(c0673z);
            return;
        }
        da.m564u("Ad is not visible. Not refreshing ad.");
        this.kJ.m1110d(c0673z);
    }

    public void destroy() {
        er.ac("destroy must be called on the main UI thread.");
        this.kI.kO = null;
        this.kI.kT = null;
        this.kJ.cancel();
        stopLoading();
        if (this.kI.kK != null) {
            this.kI.kK.removeAllViews();
        }
        if (this.kI.kR != null && this.kI.kR.nu != null) {
            this.kI.kR.nu.destroy();
        }
    }

    public boolean isReady() {
        er.ac("isLoaded must be called on the main UI thread.");
        return this.kI.kP == null && this.kI.kR != null;
    }

    public void onAppEvent(String name, String info) {
        if (this.kI.kT != null) {
            try {
                this.kI.kT.onAppEvent(name, info);
            } catch (Throwable e) {
                da.m560b("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        er.ac("pause must be called on the main UI thread.");
        if (this.kI.kR != null) {
            cv.m530a(this.kI.kR.nu);
        }
    }

    public void resume() {
        er.ac("resume must be called on the main UI thread.");
        if (this.kI.kR != null) {
            cv.m536b(this.kI.kR.nu);
        }
    }

    public void showInterstitial() {
        er.ac("showInterstitial must be called on the main UI thread.");
        if (!this.kI.kQ.lo) {
            da.m566w("Cannot call showInterstitial on a banner ad.");
        } else if (this.kI.kR == null) {
            da.m566w("The interstitial has not loaded.");
        } else if (this.kI.kR.nu.be()) {
            da.m566w("The interstitial is already showing.");
        } else {
            this.kI.kR.nu.m576n(true);
            if (this.kI.kR.ok) {
                try {
                    this.kI.kR.mN.showInterstitial();
                    return;
                } catch (Throwable e) {
                    da.m560b("Could not show interstitial.", e);
                    ag();
                    return;
                }
            }
            bo.m2487a(this.kI.kL, new bq(this, this, this, this.kI.kR.nu, this.kI.kR.orientation, this.kI.kN));
        }
    }

    public void stopLoading() {
        er.ac("stopLoading must be called on the main UI thread.");
        if (this.kI.kR != null) {
            this.kI.kR.nu.stopLoading();
            this.kI.kR = null;
        }
        if (this.kI.kP != null) {
            this.kI.kP.cancel();
        }
    }
}
