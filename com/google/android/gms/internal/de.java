package com.google.android.gms.internal;

import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.net.UrlQuerySanitizer.ParameterValuePair;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
import java.util.Map;

public class de extends WebViewClient {
    private ap lV;
    private final Object mg;
    protected final dd ng;
    private final HashMap<String, ar> qf;
    private C0305u qg;
    private br qh;
    private C0250a qi;
    private boolean qj;
    private boolean qk;
    private bu ql;

    /* renamed from: com.google.android.gms.internal.de.1 */
    class C02491 implements Runnable {
        final /* synthetic */ bo qm;
        final /* synthetic */ de qn;

        C02491(de deVar, bo boVar) {
            this.qn = deVar;
            this.qm = boVar;
        }

        public void run() {
            this.qm.ar();
        }
    }

    /* renamed from: com.google.android.gms.internal.de.a */
    public interface C0250a {
        void m577a(dd ddVar);
    }

    public de(dd ddVar, boolean z) {
        this.qf = new HashMap();
        this.mg = new Object();
        this.qj = false;
        this.ng = ddVar;
        this.qk = z;
    }

    private void m578a(bq bqVar) {
        bo.m2487a(this.ng.getContext(), bqVar);
    }

    private static boolean m579b(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void m580c(Uri uri) {
        String path = uri.getPath();
        ar arVar = (ar) this.qf.get(path);
        if (arVar != null) {
            Map hashMap = new HashMap();
            UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
            urlQuerySanitizer.setAllowUnregisteredParamaters(true);
            urlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
            urlQuerySanitizer.parseUrl(uri.toString());
            for (ParameterValuePair parameterValuePair : urlQuerySanitizer.getParameterList()) {
                hashMap.put(parameterValuePair.mParameter, parameterValuePair.mValue);
            }
            if (da.m561n(2)) {
                da.m565v("Received GMSG: " + path);
                for (String str : hashMap.keySet()) {
                    da.m565v("  " + str + ": " + ((String) hashMap.get(str)));
                }
            }
            arVar.m422a(this.ng, hashMap);
            return;
        }
        da.m566w("No GMSG handler found for GMSG: " + uri);
    }

    public final void m581a(bn bnVar) {
        br brVar = null;
        boolean be = this.ng.be();
        C0305u c0305u = (!be || this.ng.m571Q().lo) ? this.qg : null;
        if (!be) {
            brVar = this.qh;
        }
        m578a(new bq(bnVar, c0305u, brVar, this.ql, this.ng.bd()));
    }

    public final void m582a(C0250a c0250a) {
        this.qi = c0250a;
    }

    public void m583a(C0305u c0305u, br brVar, ap apVar, bu buVar, boolean z) {
        m584a("/appEvent", new ao(apVar));
        m584a("/canOpenURLs", aq.lW);
        m584a("/click", aq.lX);
        m584a("/close", aq.lY);
        m584a("/customClose", aq.lZ);
        m584a("/httpTrack", aq.ma);
        m584a("/log", aq.mb);
        m584a("/open", aq.mc);
        m584a("/touch", aq.md);
        m584a("/video", aq.me);
        this.qg = c0305u;
        this.qh = brVar;
        this.lV = apVar;
        this.ql = buVar;
        m588o(z);
    }

    public final void m584a(String str, ar arVar) {
        this.qf.put(str, arVar);
    }

    public final void m585a(boolean z, int i) {
        C0305u c0305u = (!this.ng.be() || this.ng.m571Q().lo) ? this.qg : null;
        m578a(new bq(c0305u, this.qh, this.ql, this.ng, z, i, this.ng.bd()));
    }

    public final void m586a(boolean z, int i, String str) {
        br brVar = null;
        boolean be = this.ng.be();
        C0305u c0305u = (!be || this.ng.m571Q().lo) ? this.qg : null;
        if (!be) {
            brVar = this.qh;
        }
        m578a(new bq(c0305u, brVar, this.lV, this.ql, this.ng, z, i, str, this.ng.bd()));
    }

    public final void m587a(boolean z, int i, String str, String str2) {
        br brVar = null;
        boolean be = this.ng.be();
        C0305u c0305u = (!be || this.ng.m571Q().lo) ? this.qg : null;
        if (!be) {
            brVar = this.qh;
        }
        m578a(new bq(c0305u, brVar, this.lV, this.ql, this.ng, z, i, str, str2, this.ng.bd()));
    }

    public final void ar() {
        synchronized (this.mg) {
            this.qj = false;
            this.qk = true;
            bo ba = this.ng.ba();
            if (ba != null) {
                if (cz.aX()) {
                    ba.ar();
                } else {
                    cz.pT.post(new C02491(this, ba));
                }
            }
        }
    }

    public boolean bi() {
        boolean z;
        synchronized (this.mg) {
            z = this.qk;
        }
        return z;
    }

    public final void m588o(boolean z) {
        this.qj = z;
    }

    public final void onPageFinished(WebView webView, String url) {
        if (this.qi != null) {
            this.qi.m577a(this.ng);
            this.qi = null;
        }
    }

    public final void reset() {
        synchronized (this.mg) {
            this.qf.clear();
            this.qg = null;
            this.qh = null;
            this.qi = null;
            this.lV = null;
            this.qj = false;
            this.qk = false;
            this.ql = null;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String url) {
        da.m565v("AdWebView shouldOverrideUrlLoading: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m580c(parse);
        } else if (this.qj && webView == this.ng && m579b(parse)) {
            return super.shouldOverrideUrlLoading(webView, url);
        } else {
            if (this.ng.willNotDraw()) {
                da.m566w("AdWebView unable to handle URL: " + url);
            } else {
                Uri uri;
                try {
                    C0296l bc = this.ng.bc();
                    if (bc != null && bc.m1077a(parse)) {
                        parse = bc.m1075a(parse, this.ng.getContext());
                    }
                    uri = parse;
                } catch (C0297m e) {
                    da.m566w("Unable to append parameter to URL: " + url);
                    uri = parse;
                }
                m581a(new bn("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            }
        }
        return true;
    }
}
