package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.di;
import com.google.android.gms.internal.dj;
import com.google.android.gms.internal.dj.C0597a;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.c */
class C0507c implements C0093b {
    private Context mContext;
    private ServiceConnection qM;
    private C0095b qN;
    private C0096c qO;
    private dj qP;

    /* renamed from: com.google.android.gms.analytics.c.a */
    final class C0094a implements ServiceConnection {
        final /* synthetic */ C0507c qQ;

        C0094a(C0507c c0507c) {
            this.qQ = c0507c;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            aa.m46v("service connected, binder: " + binder);
            try {
                if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(binder.getInterfaceDescriptor())) {
                    aa.m46v("bound to service");
                    this.qQ.qP = C0597a.m1726r(binder);
                    this.qQ.bn();
                    return;
                }
            } catch (RemoteException e) {
            }
            this.qQ.mContext.unbindService(this);
            this.qQ.qM = null;
            this.qQ.qO.m61a(2, null);
        }

        public void onServiceDisconnected(ComponentName component) {
            aa.m46v("service disconnected: " + component);
            this.qQ.qM = null;
            this.qQ.qN.onDisconnected();
        }
    }

    /* renamed from: com.google.android.gms.analytics.c.b */
    public interface C0095b {
        void onConnected();

        void onDisconnected();
    }

    /* renamed from: com.google.android.gms.analytics.c.c */
    public interface C0096c {
        void m61a(int i, Intent intent);
    }

    public C0507c(Context context, C0095b c0095b, C0096c c0096c) {
        this.mContext = context;
        if (c0095b == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.qN = c0095b;
        if (c0096c == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.qO = c0096c;
    }

    private dj bl() {
        bm();
        return this.qP;
    }

    private void bn() {
        bo();
    }

    private void bo() {
        this.qN.onConnected();
    }

    public void m1455a(Map<String, String> map, long j, String str, List<di> list) {
        try {
            bl().m595a(map, j, str, list);
        } catch (RemoteException e) {
            aa.m44t("sendHit failed: " + e);
        }
    }

    public void bk() {
        try {
            bl().bk();
        } catch (RemoteException e) {
            aa.m44t("clear hits failed: " + e);
        }
    }

    protected void bm() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect() {
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.analytics.service.AnalyticsService"));
        intent.putExtra(AnalyticsGmsCoreClient.KEY_APP_PACKAGE_NAME, this.mContext.getPackageName());
        if (this.qM != null) {
            aa.m44t("Calling connect() while still connected, missing disconnect().");
            return;
        }
        this.qM = new C0094a(this);
        boolean bindService = this.mContext.bindService(intent, this.qM, 129);
        aa.m46v("connect: bindService returned " + bindService + " for " + intent);
        if (!bindService) {
            this.qM = null;
            this.qO.m61a(1, null);
        }
    }

    public void disconnect() {
        this.qP = null;
        if (this.qM != null) {
            try {
                this.mContext.unbindService(this.qM);
            } catch (IllegalStateException e) {
            } catch (IllegalArgumentException e2) {
            }
            this.qM = null;
            this.qN.onDisconnected();
        }
    }

    public boolean isConnected() {
        return this.qP != null;
    }
}
