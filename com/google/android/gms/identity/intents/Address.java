package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.C0131a;
import com.google.android.gms.common.api.Api.C0132b;
import com.google.android.gms.common.api.C0136a.C0526a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.er;
import com.google.android.gms.internal.hc;

public final class Address {
    public static final Api API;
    static final C0132b<hc> va;

    /* renamed from: com.google.android.gms.identity.intents.Address.1 */
    static class C05651 implements C0132b<hc> {
        C05651() {
        }

        public /* synthetic */ C0131a m1644b(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m1645f(context, looper, eeVar, apiOptions, connectionCallbacks, onConnectionFailedListener);
        }

        public hc m1645f(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            AddressOptions addressOptions;
            er.m720b(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            AddressOptions addressOptions2 = new AddressOptions();
            if (apiOptions != null) {
                er.m720b(apiOptions instanceof AddressOptions, (Object) "Must use AddressOptions with Address API");
                addressOptions = (AddressOptions) apiOptions;
            } else {
                addressOptions = addressOptions2;
            }
            return new hc((Activity) context, looper, connectionCallbacks, onConnectionFailedListener, eeVar.getAccountName(), addressOptions.theme);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public static final class AddressOptions implements ApiOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int theme) {
            this.theme = theme;
        }
    }

    /* renamed from: com.google.android.gms.identity.intents.Address.a */
    private static abstract class C0898a extends C0526a<Status, hc> {
        public C0898a() {
            super(Address.va);
        }

        public /* synthetic */ Result m2473d(Status status) {
            return m2474f(status);
        }

        public Status m2474f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.identity.intents.Address.2 */
    static class C10162 extends C0898a {
        final /* synthetic */ UserAddressRequest Kw;
        final /* synthetic */ int Kx;

        C10162(UserAddressRequest userAddressRequest, int i) {
            this.Kw = userAddressRequest;
            this.Kx = i;
        }

        protected void m3006a(hc hcVar) throws RemoteException {
            hcVar.m2754a(this.Kw, this.Kx);
            m1527a(Status.zQ);
        }
    }

    static {
        va = new C05651();
        API = new Api(va, new Scope[0]);
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, UserAddressRequest request, int requestCode) {
        googleApiClient.m136a(new C10162(request, requestCode));
    }
}
