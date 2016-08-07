package com.google.android.gms.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.api.C0136a.C0135c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.C0883a;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class go implements Requests {

    /* renamed from: com.google.android.gms.internal.go.a */
    private static abstract class C1047a extends C0883a<LoadRequestsResult> {

        /* renamed from: com.google.android.gms.internal.go.a.1 */
        class C09321 implements LoadRequestsResult {
            final /* synthetic */ C1047a In;
            final /* synthetic */ Status vb;

            C09321(C1047a c1047a, Status status) {
                this.In = c1047a;
                this.vb = status;
            }

            public GameRequestBuffer getRequests(int type) {
                return null;
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        private C1047a() {
        }

        public LoadRequestsResult m3091B(Status status) {
            return new C09321(this, status);
        }

        public /* synthetic */ Result m3092d(Status status) {
            return m3091B(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.go.b */
    private static abstract class C1048b extends C0883a<UpdateRequestsResult> {

        /* renamed from: com.google.android.gms.internal.go.b.1 */
        class C09331 implements UpdateRequestsResult {
            final /* synthetic */ C1048b Io;
            final /* synthetic */ Status vb;

            C09331(C1048b c1048b, Status status) {
                this.Io = c1048b;
                this.vb = status;
            }

            public Set<String> getRequestIds() {
                return null;
            }

            public int getRequestOutcome(String requestId) {
                throw new IllegalArgumentException("Unknown request ID " + requestId);
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        private C1048b() {
        }

        public UpdateRequestsResult m3093C(Status status) {
            return new C09331(this, status);
        }

        public /* synthetic */ Result m3094d(Status status) {
            return m3093C(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.go.1 */
    class C11381 extends C1048b {
        final /* synthetic */ String[] Ij;
        final /* synthetic */ go Ik;

        C11381(go goVar, String[] strArr) {
            this.Ik = goVar;
            this.Ij = strArr;
            super();
        }

        protected void m3291a(fx fxVar) {
            fxVar.m2719a((C0135c) this, this.Ij);
        }
    }

    /* renamed from: com.google.android.gms.internal.go.2 */
    class C11392 extends C1048b {
        final /* synthetic */ String[] Ij;
        final /* synthetic */ go Ik;

        C11392(go goVar, String[] strArr) {
            this.Ik = goVar;
            this.Ij = strArr;
            super();
        }

        protected void m3293a(fx fxVar) {
            fxVar.m2732b((C0135c) this, this.Ij);
        }
    }

    /* renamed from: com.google.android.gms.internal.go.3 */
    class C11403 extends C1047a {
        final /* synthetic */ int HP;
        final /* synthetic */ go Ik;
        final /* synthetic */ int Il;
        final /* synthetic */ int Im;

        C11403(go goVar, int i, int i2, int i3) {
            this.Ik = goVar;
            this.Il = i;
            this.Im = i2;
            this.HP = i3;
            super();
        }

        protected void m3295a(fx fxVar) {
            fxVar.m2703a((C0135c) this, this.Il, this.Im, this.HP);
        }
    }

    public PendingResult<UpdateRequestsResult> acceptRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return acceptRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> acceptRequests(GoogleApiClient apiClient, List<String> requestIds) {
        return apiClient.m137b(new C11381(this, requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()])));
    }

    public PendingResult<UpdateRequestsResult> dismissRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return dismissRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> dismissRequests(GoogleApiClient apiClient, List<String> requestIds) {
        return apiClient.m137b(new C11392(this, requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()])));
    }

    public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle extras) {
        if (extras == null || !extras.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList();
        }
        ArrayList arrayList = (ArrayList) extras.get(Requests.EXTRA_REQUESTS);
        ArrayList<GameRequest> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent response) {
        return response == null ? new ArrayList() : getGameRequestsFromBundle(response.getExtras());
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.m360c(apiClient).fD();
    }

    public int getMaxLifetimeDays(GoogleApiClient apiClient) {
        return Games.m360c(apiClient).fF();
    }

    public int getMaxPayloadSize(GoogleApiClient apiClient) {
        return Games.m360c(apiClient).fE();
    }

    public Intent getSendIntent(GoogleApiClient apiClient, int type, byte[] payload, int requestLifetimeDays, Bitmap icon, String description) {
        return Games.m360c(apiClient).m2699a(type, payload, requestLifetimeDays, icon, description);
    }

    public PendingResult<LoadRequestsResult> loadRequests(GoogleApiClient apiClient, int requestDirection, int types, int sortOrder) {
        return apiClient.m136a(new C11403(this, requestDirection, types, sortOrder));
    }

    public void registerRequestListener(GoogleApiClient apiClient, OnRequestReceivedListener listener) {
        Games.m360c(apiClient).m2724a(listener);
    }

    public void unregisterRequestListener(GoogleApiClient apiClient) {
        Games.m360c(apiClient).fx();
    }
}
