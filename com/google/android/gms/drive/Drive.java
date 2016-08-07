package com.google.android.gms.drive;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.C0131a;
import com.google.android.gms.common.api.Api.C0132b;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.C0536l;
import com.google.android.gms.drive.internal.C0537p;
import com.google.android.gms.drive.internal.C0872n;
import com.google.android.gms.internal.ee;
import java.util.List;

public final class Drive {
    public static final Api API;
    public static final Scope Da;
    public static final C0156c Db;
    public static final DriveApi DriveApi;
    public static final Scope SCOPE_APPFOLDER;
    public static final Scope SCOPE_FILE;
    public static final C0132b<C0872n> va;

    /* renamed from: com.google.android.gms.drive.Drive.1 */
    static class C05351 implements C0132b<C0872n> {
        C05351() {
        }

        public /* synthetic */ C0131a m1564b(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m1565d(context, looper, eeVar, apiOptions, connectionCallbacks, onConnectionFailedListener);
        }

        public C0872n m1565d(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            List dT = eeVar.dT();
            return new C0872n(context, looper, eeVar, connectionCallbacks, onConnectionFailedListener, (String[]) dT.toArray(new String[dT.size()]));
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    static {
        va = new C05351();
        SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
        SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
        Da = new Scope(Scopes.DRIVE_FULL);
        API = new Api(va, new Scope[0]);
        DriveApi = new C0536l();
        Db = new C0537p();
    }

    private Drive() {
    }
}
