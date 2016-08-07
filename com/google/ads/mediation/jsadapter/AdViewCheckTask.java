package com.google.ads.mediation.jsadapter;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.internal.da;

public final class AdViewCheckTask implements Runnable {
    public static final int BACKGROUND_COLOR = 0;
    private final JavascriptAdapter f13r;
    private final Handler f14s;
    private final long f15t;
    private long f16u;

    /* renamed from: com.google.ads.mediation.jsadapter.AdViewCheckTask.a */
    private final class C0071a extends AsyncTask<Void, Void, Boolean> {
        private final int f8v;
        private final int f9w;
        private final WebView f10x;
        private Bitmap f11y;
        final /* synthetic */ AdViewCheckTask f12z;

        public C0071a(AdViewCheckTask adViewCheckTask, int i, int i2, WebView webView) {
            this.f12z = adViewCheckTask;
            this.f8v = i2;
            this.f9w = i;
            this.f10x = webView;
        }

        protected synchronized Boolean m1a(Void... voidArr) {
            Boolean valueOf;
            int width = this.f11y.getWidth();
            int height = this.f11y.getHeight();
            if (width == 0 || height == 0) {
                valueOf = Boolean.valueOf(false);
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.f11y.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                valueOf = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return valueOf;
        }

        protected void m2a(Boolean bool) {
            AdViewCheckTask.m3a(this.f12z);
            if (bool.booleanValue()) {
                this.f12z.f13r.sendAdReceivedUpdate();
            } else if (this.f12z.f16u > 0) {
                if (da.m561n(2)) {
                    da.m562s("Ad not detected, scheduling another run.");
                }
                this.f12z.f14s.postDelayed(this.f12z, this.f12z.f15t);
            } else {
                da.m562s("Ad not detected, Not scheduling anymore runs.");
                this.f12z.f13r.sendAdNotReceivedUpdate();
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] x0) {
            return m1a((Void[]) x0);
        }

        protected /* synthetic */ void onPostExecute(Object x0) {
            m2a((Boolean) x0);
        }

        protected synchronized void onPreExecute() {
            this.f11y = Bitmap.createBitmap(this.f9w, this.f8v, Config.ARGB_8888);
            this.f10x.setVisibility(0);
            this.f10x.measure(MeasureSpec.makeMeasureSpec(this.f9w, 0), MeasureSpec.makeMeasureSpec(this.f8v, 0));
            this.f10x.layout(0, 0, this.f9w, this.f8v);
            this.f10x.draw(new Canvas(this.f11y));
            this.f10x.invalidate();
        }
    }

    public AdViewCheckTask(JavascriptAdapter adapter, long checkIntervalInMillis, long numIterations) {
        this.f13r = adapter;
        this.f15t = checkIntervalInMillis;
        this.f16u = numIterations;
        this.f14s = new Handler(Looper.getMainLooper());
    }

    static /* synthetic */ long m3a(AdViewCheckTask adViewCheckTask) {
        long j = adViewCheckTask.f16u - 1;
        adViewCheckTask.f16u = j;
        return j;
    }

    public void run() {
        if (this.f13r != null && !this.f13r.shouldStopAdCheck()) {
            new C0071a(this, this.f13r.getWebViewWidth(), this.f13r.getWebViewHeight(), this.f13r.getWebView()).execute(new Void[0]);
        }
    }

    public void start() {
        this.f14s.postDelayed(this, this.f15t);
    }
}
