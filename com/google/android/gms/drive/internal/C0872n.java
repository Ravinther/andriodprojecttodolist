package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.C0160c;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.internal.C0173u.C0540a;
import com.google.android.gms.drive.internal.C0536l.C1000j;
import com.google.android.gms.drive.internal.C0536l.C1103k;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.eh.C0917e;
import com.google.android.gms.internal.en;
import com.google.android.gms.internal.er;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.drive.internal.n */
public class C0872n extends eh<C0173u> {
    private DriveId DA;
    final ConnectionCallbacks DB;
    Map<DriveId, Map<Listener<?>, C0878s<?>>> DC;
    private DriveId Dz;
    private final String vi;

    /* renamed from: com.google.android.gms.drive.internal.n.1 */
    class C11041 extends C1000j {
        final /* synthetic */ DriveId DD;
        final /* synthetic */ int DE;
        final /* synthetic */ C0878s DF;
        final /* synthetic */ C0872n DG;

        C11041(C0872n c0872n, DriveId driveId, int i, C0878s c0878s) {
            this.DG = c0872n;
            this.DD = driveId;
            this.DE = i;
            this.DF = c0878s;
        }

        protected void m3213a(C0872n c0872n) throws RemoteException {
            c0872n.eT().m301a(new AddEventListenerRequest(this.DD, this.DE), this.DF, null, new ak(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.n.2 */
    class C11052 extends C1000j {
        final /* synthetic */ DriveId DD;
        final /* synthetic */ int DE;
        final /* synthetic */ C0878s DF;
        final /* synthetic */ C0872n DG;

        C11052(C0872n c0872n, DriveId driveId, int i, C0878s c0878s) {
            this.DG = c0872n;
            this.DD = driveId;
            this.DE = i;
            this.DF = c0878s;
        }

        protected void m3215a(C0872n c0872n) throws RemoteException {
            c0872n.eT().m313a(new RemoveEventListenerRequest(this.DD, this.DE), this.DF, null, new ak(this));
        }
    }

    public C0872n(Context context, Looper looper, ee eeVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String[] strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.DC = new HashMap();
        this.vi = (String) er.m719b(eeVar.dR(), (Object) "Must call Api.ClientBuilder.setAccountName()");
        this.DB = connectionCallbacks;
    }

    protected C0173u m2422C(IBinder iBinder) {
        return C0540a.m1586D(iBinder);
    }

    <C extends DriveEvent> PendingResult<Status> m2423a(GoogleApiClient googleApiClient, DriveId driveId, int i, Listener<C> listener) {
        PendingResult<Status> c1103k;
        er.m720b(C0160c.m253a(i, driveId), (Object) "id");
        er.m719b((Object) listener, (Object) "listener");
        er.m717a(isConnected(), "Client must be connected");
        synchronized (this.DC) {
            Map map = (Map) this.DC.get(driveId);
            if (map == null) {
                map = new HashMap();
                this.DC.put(driveId, map);
            }
            if (map.containsKey(listener)) {
                c1103k = new C1103k(Status.zQ);
            } else {
                C0878s c0878s = new C0878s(getLooper(), i, listener);
                map.put(listener, c0878s);
                c1103k = googleApiClient.m137b(new C11041(this, driveId, i, c0878s));
            }
        }
        return c1103k;
    }

    protected void m2424a(int i, IBinder iBinder, Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.Dz = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.DA = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
        }
        super.m1790a(i, iBinder, bundle);
    }

    protected void m2425a(en enVar, C0917e c0917e) throws RemoteException {
        String packageName = getContext().getPackageName();
        er.m721f(c0917e);
        er.m721f(packageName);
        er.m721f(ea());
        enVar.m694a(c0917e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, packageName, ea(), this.vi, new Bundle());
    }

    protected String aF() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    protected String aG() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    PendingResult<Status> m2426b(GoogleApiClient googleApiClient, DriveId driveId, int i, Listener<?> listener) {
        PendingResult<Status> c1103k;
        er.m720b(C0160c.m253a(i, driveId), (Object) "id");
        er.m719b((Object) listener, (Object) "listener");
        er.m717a(isConnected(), "Client must be connected");
        synchronized (this.DC) {
            Map map = (Map) this.DC.get(driveId);
            if (map == null) {
                c1103k = new C1103k(Status.zQ);
            } else {
                C0878s c0878s = (C0878s) map.remove(listener);
                if (c0878s == null) {
                    c1103k = new C1103k(Status.zQ);
                } else {
                    if (map.isEmpty()) {
                        this.DC.remove(driveId);
                    }
                    c1103k = googleApiClient.m137b(new C11052(this, driveId, i, c0878s));
                }
            }
        }
        return c1103k;
    }

    public void disconnect() {
        C0173u c0173u = (C0173u) eb();
        if (c0173u != null) {
            try {
                c0173u.m308a(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        this.DC.clear();
    }

    public C0173u eT() {
        return (C0173u) eb();
    }

    public DriveId eU() {
        return this.Dz;
    }

    public DriveId eV() {
        return this.DA;
    }

    protected /* synthetic */ IInterface m2427p(IBinder iBinder) {
        return m2422C(iBinder);
    }
}
