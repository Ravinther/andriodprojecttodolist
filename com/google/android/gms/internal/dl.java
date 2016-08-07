package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.C0136a.C0135c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.dn.C0602a;
import com.google.android.gms.internal.eh.C0270b;
import com.google.android.gms.internal.eh.C0609d;
import com.google.android.gms.internal.eh.C0917e;

public final class dl extends eh<dn> {
    private final String vi;

    /* renamed from: com.google.android.gms.internal.dl.h */
    final class C0598h extends C0270b<C0135c<Status>> {
        final /* synthetic */ dl vk;
        private final Status vl;

        public C0598h(dl dlVar, C0135c<Status> c0135c, Status status) {
            this.vk = dlVar;
            super(dlVar, c0135c);
            this.vl = status;
        }

        public /* synthetic */ void m1727a(Object obj) {
            m1728c((C0135c) obj);
        }

        public void m1728c(C0135c<Status> c0135c) {
            c0135c.m143b(this.vl);
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.dl.b */
    final class C0912b extends C0270b<C0135c<StateDeletedResult>> implements StateDeletedResult {
        final /* synthetic */ dl vk;
        private final Status vl;
        private final int vm;

        public C0912b(dl dlVar, C0135c<StateDeletedResult> c0135c, Status status, int i) {
            this.vk = dlVar;
            super(dlVar, c0135c);
            this.vl = status;
            this.vm = i;
        }

        public /* synthetic */ void m2569a(Object obj) {
            m2570c((C0135c) obj);
        }

        public void m2570c(C0135c<StateDeletedResult> c0135c) {
            c0135c.m143b(this);
        }

        protected void cP() {
        }

        public int getStateKey() {
            return this.vm;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    /* renamed from: com.google.android.gms.internal.dl.d */
    final class C0913d extends C0609d<C0135c<StateListResult>> implements StateListResult {
        final /* synthetic */ dl vk;
        private final Status vl;
        private final AppStateBuffer vn;

        public C0913d(dl dlVar, C0135c<StateListResult> c0135c, Status status, DataHolder dataHolder) {
            this.vk = dlVar;
            super(dlVar, c0135c, dataHolder);
            this.vl = status;
            this.vn = new AppStateBuffer(dataHolder);
        }

        public void m2571a(C0135c<StateListResult> c0135c, DataHolder dataHolder) {
            c0135c.m143b(this);
        }

        public AppStateBuffer getStateBuffer() {
            return this.vn;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    /* renamed from: com.google.android.gms.internal.dl.f */
    final class C0914f extends C0609d<C0135c<StateResult>> implements StateConflictResult, StateLoadedResult, StateResult {
        final /* synthetic */ dl vk;
        private final Status vl;
        private final int vm;
        private final AppStateBuffer vn;

        public C0914f(dl dlVar, C0135c<StateResult> c0135c, int i, DataHolder dataHolder) {
            this.vk = dlVar;
            super(dlVar, c0135c, dataHolder);
            this.vm = i;
            this.vl = new Status(dataHolder.getStatusCode());
            this.vn = new AppStateBuffer(dataHolder);
        }

        private boolean cQ() {
            return this.vl.getStatusCode() == GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS;
        }

        public void m2573a(C0135c<StateResult> c0135c, DataHolder dataHolder) {
            c0135c.m143b(this);
        }

        public StateConflictResult getConflictResult() {
            return cQ() ? this : null;
        }

        public StateLoadedResult getLoadedResult() {
            return cQ() ? null : this;
        }

        public byte[] getLocalData() {
            return this.vn.getCount() == 0 ? null : this.vn.get(0).getLocalData();
        }

        public String getResolvedVersion() {
            return this.vn.getCount() == 0 ? null : this.vn.get(0).getConflictVersion();
        }

        public byte[] getServerData() {
            return this.vn.getCount() == 0 ? null : this.vn.get(0).getConflictData();
        }

        public int getStateKey() {
            return this.vm;
        }

        public Status getStatus() {
            return this.vl;
        }

        public void release() {
            this.vn.close();
        }
    }

    /* renamed from: com.google.android.gms.internal.dl.a */
    final class C1017a extends dk {
        private final C0135c<StateDeletedResult> vj;
        final /* synthetic */ dl vk;

        public C1017a(dl dlVar, C0135c<StateDeletedResult> c0135c) {
            this.vk = dlVar;
            this.vj = (C0135c) er.m719b((Object) c0135c, (Object) "Result holder must not be null");
        }

        public void m3007b(int i, int i2) {
            this.vk.m1791a(new C0912b(this.vk, this.vj, new Status(i), i2));
        }
    }

    /* renamed from: com.google.android.gms.internal.dl.c */
    final class C1018c extends dk {
        private final C0135c<StateListResult> vj;
        final /* synthetic */ dl vk;

        public C1018c(dl dlVar, C0135c<StateListResult> c0135c) {
            this.vk = dlVar;
            this.vj = (C0135c) er.m719b((Object) c0135c, (Object) "Result holder must not be null");
        }

        public void m3008a(DataHolder dataHolder) {
            this.vk.m1791a(new C0913d(this.vk, this.vj, new Status(dataHolder.getStatusCode()), dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.dl.e */
    final class C1019e extends dk {
        private final C0135c<StateResult> vj;
        final /* synthetic */ dl vk;

        public C1019e(dl dlVar, C0135c<StateResult> c0135c) {
            this.vk = dlVar;
            this.vj = (C0135c) er.m719b((Object) c0135c, (Object) "Result holder must not be null");
        }

        public void m3009a(int i, DataHolder dataHolder) {
            this.vk.m1791a(new C0914f(this.vk, this.vj, i, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.dl.g */
    final class C1020g extends dk {
        C0135c<Status> vj;
        final /* synthetic */ dl vk;

        public C1020g(dl dlVar, C0135c<Status> c0135c) {
            this.vk = dlVar;
            this.vj = (C0135c) er.m719b((Object) c0135c, (Object) "Holder must not be null");
        }

        public void cM() {
            this.vk.m1791a(new C0598h(this.vk, this.vj, new Status(0)));
        }
    }

    public dl(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String[] strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.vi = (String) er.m721f(str);
    }

    public void m2575a(C0135c<StateListResult> c0135c) {
        try {
            ((dn) eb()).m600a(new C1018c(this, c0135c));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void m2576a(C0135c<StateDeletedResult> c0135c, int i) {
        try {
            ((dn) eb()).m605b(new C1017a(this, c0135c), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void m2577a(C0135c<StateResult> c0135c, int i, String str, byte[] bArr) {
        try {
            ((dn) eb()).m602a(new C1019e(this, c0135c), i, str, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void m2578a(C0135c<StateResult> c0135c, int i, byte[] bArr) {
        if (c0135c == null) {
            dm dmVar = null;
        } else {
            Object c1019e = new C1019e(this, c0135c);
        }
        try {
            ((dn) eb()).m603a(dmVar, i, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    protected void m2579a(en enVar, C0917e c0917e) throws RemoteException {
        enVar.m691a((em) c0917e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.vi, ea());
    }

    protected String aF() {
        return "com.google.android.gms.appstate.service.START";
    }

    protected String aG() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    public void m2580b(C0135c<Status> c0135c) {
        try {
            ((dn) eb()).m604b(new C1020g(this, c0135c));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void m2581b(C0135c<StateResult> c0135c, int i) {
        try {
            ((dn) eb()).m601a(new C1019e(this, c0135c), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    protected void m2582b(String... strArr) {
        boolean z = false;
        for (String equals : strArr) {
            if (equals.equals(Scopes.APP_STATE)) {
                z = true;
            }
        }
        er.m717a(z, String.format("App State APIs requires %s to function.", new Object[]{Scopes.APP_STATE}));
    }

    public int cN() {
        try {
            return ((dn) eb()).cN();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public int cO() {
        try {
            return ((dn) eb()).cO();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    protected /* synthetic */ IInterface m2583p(IBinder iBinder) {
        return m2584s(iBinder);
    }

    protected dn m2584s(IBinder iBinder) {
        return C0602a.m1741u(iBinder);
    }
}
