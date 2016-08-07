package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C0136a.C0135c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0291if.C0660a;
import com.google.android.gms.internal.eh.C0270b;
import com.google.android.gms.internal.eh.C0608c;
import com.google.android.gms.internal.eh.C0917e;
import com.google.android.gms.internal.eh.C0918g;
import com.google.android.gms.internal.ig.C0662a;
import com.google.android.gms.panorama.Panorama.C0972a;
import com.google.android.gms.panorama.Panorama.PanoramaResult;

public class ih extends eh<ig> {

    /* renamed from: com.google.android.gms.internal.ih.b */
    final class C0943b extends C0660a {
        final /* synthetic */ ih QG;
        private final C0135c<C0972a> QH;
        private final C0135c<PanoramaResult> QI;
        private final Uri QJ;

        public C0943b(ih ihVar, C0135c<C0972a> c0135c, C0135c<PanoramaResult> c0135c2, Uri uri) {
            this.QG = ihVar;
            this.QH = c0135c;
            this.QI = c0135c2;
            this.QJ = uri;
        }

        public void m2762a(int i, Bundle bundle, int i2, Intent intent) {
            if (this.QJ != null) {
                this.QG.getContext().revokeUriPermission(this.QJ, 1);
            }
            Status status = new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null);
            if (this.QI != null) {
                this.QG.m1791a(new C0944c(this.QG, this.QI, status, intent));
            } else if (this.QH != null) {
                this.QG.m1791a(new C1055a(this.QG, this.QH, status, i2, intent));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ih.c */
    final class C0944c extends C0270b<C0135c<PanoramaResult>> implements PanoramaResult {
        private final Status QE;
        private final Intent QF;
        final /* synthetic */ ih QG;

        public C0944c(ih ihVar, C0135c<PanoramaResult> c0135c, Status status, Intent intent) {
            this.QG = ihVar;
            super(ihVar, c0135c);
            this.QE = status;
            this.QF = intent;
        }

        protected /* synthetic */ void m2763a(Object obj) {
            m2764c((C0135c) obj);
        }

        protected void m2764c(C0135c<PanoramaResult> c0135c) {
            c0135c.m143b(this);
        }

        protected void cP() {
        }

        public Status getStatus() {
            return this.QE;
        }

        public Intent getViewerIntent() {
            return this.QF;
        }
    }

    /* renamed from: com.google.android.gms.internal.ih.a */
    final class C1055a extends C0270b<C0135c<C0972a>> implements C0972a {
        public final Status QE;
        public final Intent QF;
        final /* synthetic */ ih QG;
        public final int type;

        public C1055a(ih ihVar, C0135c<C0972a> c0135c, Status status, int i, Intent intent) {
            this.QG = ihVar;
            super(ihVar, c0135c);
            this.QE = status;
            this.type = i;
            this.QF = intent;
        }

        protected /* synthetic */ void m3108a(Object obj) {
            m3109c((C0135c) obj);
        }

        protected void m3109c(C0135c<C0972a> c0135c) {
            c0135c.m143b(this);
        }

        protected void cP() {
        }

        public Status getStatus() {
            return this.QE;
        }

        public Intent getViewerIntent() {
            return this.QF;
        }
    }

    public ih(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, (String[]) null);
    }

    @Deprecated
    public ih(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, context.getMainLooper(), new C0608c(connectionCallbacks), new C0918g(onConnectionFailedListener));
    }

    public void m2765a(C0135c<PanoramaResult> c0135c, Uri uri, boolean z) {
        m2767a(new C0943b(this, null, c0135c, z ? uri : null), uri, null, z);
    }

    protected void m2766a(en enVar, C0917e c0917e) throws RemoteException {
        enVar.m689a(c0917e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), new Bundle());
    }

    public void m2767a(C0943b c0943b, Uri uri, Bundle bundle, boolean z) {
        bm();
        if (z) {
            getContext().grantUriPermission(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, uri, 1);
        }
        try {
            ((ig) eb()).m985a(c0943b, uri, bundle, z);
        } catch (RemoteException e) {
            c0943b.m2762a(8, null, 0, null);
        }
    }

    protected String aF() {
        return "com.google.android.gms.panorama.service.START";
    }

    protected String aG() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }

    public ig ax(IBinder iBinder) {
        return C0662a.aw(iBinder);
    }

    public /* synthetic */ IInterface m2768p(IBinder iBinder) {
        return ax(iBinder);
    }
}
