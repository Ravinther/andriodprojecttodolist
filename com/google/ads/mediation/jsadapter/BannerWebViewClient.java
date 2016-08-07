package com.google.ads.mediation.jsadapter;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.da;
import java.net.URI;
import java.net.URISyntaxException;

public final class BannerWebViewClient extends WebViewClient {
    private final String f17A;
    private boolean f18B;
    private final JavascriptAdapter f19r;

    public BannerWebViewClient(JavascriptAdapter adapter, String passbackUrl) {
        this.f17A = m9c(passbackUrl);
        this.f19r = adapter;
        this.f18B = false;
    }

    private boolean m8b(String str) {
        Object c = m9c(str);
        if (TextUtils.isEmpty(c)) {
            return false;
        }
        try {
            URI uri = new URI(c);
            if ("passback".equals(uri.getScheme())) {
                da.m562s("Passback received");
                this.f19r.sendAdNotReceivedUpdate();
                return true;
            } else if (TextUtils.isEmpty(this.f17A)) {
                return false;
            } else {
                URI uri2 = new URI(this.f17A);
                String host = uri2.getHost();
                String host2 = uri.getHost();
                String path = uri2.getPath();
                String path2 = uri.getPath();
                if (!equals(host, host2) || !equals(path, path2)) {
                    return false;
                }
                da.m562s("Passback received");
                this.f19r.sendAdNotReceivedUpdate();
                return true;
            }
        } catch (URISyntaxException e) {
            da.m563t(e.getMessage());
            return false;
        }
    }

    private String m9c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.endsWith("/")) {
                    str = str.substring(0, str.length() - 1);
                }
            } catch (IndexOutOfBoundsException e) {
                da.m563t(e.getMessage());
            }
        }
        return str;
    }

    private static boolean equals(Object obj1, Object obj2) {
        return obj1 == obj2 || (obj1 != null && obj1.equals(obj2));
    }

    public void onLoadResource(WebView view, String url) {
        da.m565v("onLoadResource: " + url);
        if (!m8b(url)) {
            super.onLoadResource(view, url);
        }
    }

    public void onPageFinished(WebView view, String url) {
        da.m565v("onPageFinished: " + url);
        super.onPageFinished(view, url);
        if (!this.f18B) {
            this.f19r.startCheckingForAd();
            this.f18B = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        da.m565v("shouldOverrideUrlLoading: " + url);
        if (!m8b(url)) {
            return false;
        }
        da.m562s("shouldOverrideUrlLoading: received passback url");
        return true;
    }
}
