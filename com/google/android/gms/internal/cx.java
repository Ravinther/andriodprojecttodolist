package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;

public final class cx {
    public static void m551a(Context context, WebSettings webSettings) {
        cw.m545a(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
    }

    public static String getDefaultUserAgent(Context context) {
        return WebSettings.getDefaultUserAgent(context);
    }
}
