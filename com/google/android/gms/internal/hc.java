package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.identity.intents.AddressConstants.ErrorCodes;
import com.google.android.gms.identity.intents.AddressConstants.Extras;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.eh.C0917e;
import com.google.android.gms.internal.hd.C0645a;
import com.google.android.gms.internal.he.C0647a;

public class hc extends eh<he> {
    private C0940a KA;
    private final int mTheme;
    private Activity nd;
    private final String vi;

    /* renamed from: com.google.android.gms.internal.hc.a */
    public static final class C0940a extends C0645a {
        private final int Bq;
        private Activity nd;

        public C0940a(int i, Activity activity) {
            this.Bq = i;
            this.nd = activity;
        }

        private void setActivity(Activity activity) {
            this.nd = activity;
        }

        public void m2752c(int i, Bundle bundle) {
            PendingIntent createPendingResult;
            if (i == 1) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                createPendingResult = this.nd.createPendingResult(this.Bq, intent, 1073741824);
                if (createPendingResult != null) {
                    try {
                        createPendingResult.send(1);
                        return;
                    } catch (Throwable e) {
                        Log.w("AddressClientImpl", "Exception settng pending result", e);
                        return;
                    }
                }
                return;
            }
            createPendingResult = null;
            if (bundle != null) {
                createPendingResult = (PendingIntent) bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, createPendingResult);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.nd, this.Bq);
                    return;
                } catch (Throwable e2) {
                    Log.w("AddressClientImpl", "Exception starting pending intent", e2);
                    return;
                }
            }
            try {
                createPendingResult = this.nd.createPendingResult(this.Bq, new Intent(), 1073741824);
                if (createPendingResult != null) {
                    createPendingResult.send(1);
                }
            } catch (Throwable e22) {
                Log.w("AddressClientImpl", "Exception setting pending result", e22);
            }
        }
    }

    public hc(Activity activity, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, int i) {
        super(activity, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.vi = str;
        this.nd = activity;
        this.mTheme = i;
    }

    protected he m2753K(IBinder iBinder) {
        return C0647a.m2067M(iBinder);
    }

    public void m2754a(UserAddressRequest userAddressRequest, int i) {
        gj();
        this.KA = new C0940a(i, this.nd);
        Bundle bundle;
        try {
            bundle = new Bundle();
            bundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
            if (!TextUtils.isEmpty(this.vi)) {
                bundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.vi, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
            }
            bundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
            gi().m952a(this.KA, userAddressRequest, bundle);
        } catch (Throwable e) {
            Log.e("AddressClientImpl", "Exception requesting user address", e);
            bundle = new Bundle();
            bundle.putInt(Extras.EXTRA_ERROR_CODE, ErrorCodes.ERROR_CODE_NO_APPLICABLE_ADDRESSES);
            this.KA.m2752c(1, bundle);
        }
    }

    protected void m2755a(en enVar, C0917e c0917e) throws RemoteException {
        enVar.m699d(c0917e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    protected String aF() {
        return "com.google.android.gms.identity.service.BIND";
    }

    protected String aG() {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    public void disconnect() {
        super.disconnect();
        if (this.KA != null) {
            this.KA.setActivity(null);
            this.KA = null;
        }
    }

    protected he gi() {
        return (he) super.eb();
    }

    protected void gj() {
        super.bm();
    }

    protected /* synthetic */ IInterface m2756p(IBinder iBinder) {
        return m2753K(iBinder);
    }
}
