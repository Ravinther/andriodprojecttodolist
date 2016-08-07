package com.google.android.gms.panorama;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.C0131a;
import com.google.android.gms.common.api.Api.C0132b;
import com.google.android.gms.common.api.C0136a.C0526a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.ih;

public final class Panorama {
    public static final Api API;
    static final C0132b<ih> va;

    /* renamed from: com.google.android.gms.panorama.Panorama.1 */
    static class C07431 implements C0132b<ih> {
        C07431() {
        }

        public /* synthetic */ C0131a m2193b(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m2194g(context, looper, eeVar, apiOptions, connectionCallbacks, onConnectionFailedListener);
        }

        public ih m2194g(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new ih(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public interface PanoramaResult extends Result {
        Intent getViewerIntent();
    }

    /* renamed from: com.google.android.gms.panorama.Panorama.a */
    public interface C0972a extends PanoramaResult {
    }

    /* renamed from: com.google.android.gms.panorama.Panorama.b */
    private static abstract class C0974b extends C0526a<PanoramaResult, ih> {

        /* renamed from: com.google.android.gms.panorama.Panorama.b.1 */
        class C09731 implements PanoramaResult {
            final /* synthetic */ C0974b QA;
            final /* synthetic */ Status vb;

            C09731(C0974b c0974b, Status status) {
                this.QA = c0974b;
                this.vb = status;
            }

            public Status getStatus() {
                return this.vb;
            }

            public Intent getViewerIntent() {
                return null;
            }
        }

        public C0974b() {
            super(Panorama.va);
        }

        public PanoramaResult m2851J(Status status) {
            return new C09731(this, status);
        }

        public /* synthetic */ Result m2852d(Status status) {
            return m2851J(status);
        }
    }

    /* renamed from: com.google.android.gms.panorama.Panorama.2 */
    static class C10622 extends C0974b {
        final /* synthetic */ Uri Qz;

        C10622(Uri uri) {
            this.Qz = uri;
        }

        protected void m3124a(ih ihVar) {
            ihVar.m2765a(this, this.Qz, false);
        }
    }

    /* renamed from: com.google.android.gms.panorama.Panorama.3 */
    static class C10633 extends C0974b {
        final /* synthetic */ Uri Qz;

        C10633(Uri uri) {
            this.Qz = uri;
        }

        protected void m3126a(ih ihVar) {
            ihVar.m2765a(this, this.Qz, true);
        }
    }

    static {
        va = new C07431();
        API = new Api(va, new Scope[0]);
    }

    private Panorama() {
    }

    public static PendingResult<PanoramaResult> loadPanoramaInfo(GoogleApiClient client, Uri uri) {
        return client.m136a(new C10622(uri));
    }

    public static PendingResult<PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient client, Uri uri) {
        return client.m136a(new C10633(uri));
    }
}
