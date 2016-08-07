package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C0136a.C0135c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.eh.C0270b;
import com.google.android.gms.internal.eh.C0608c;
import com.google.android.gms.internal.eh.C0609d;
import com.google.android.gms.internal.eh.C0917e;
import com.google.android.gms.internal.eh.C0918g;
import com.google.android.gms.internal.en;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.io;
import com.google.android.gms.internal.ir;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.internal.C0353d.C0762a;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: com.google.android.gms.plus.internal.e */
public class C0979e extends eh<C0353d> implements GooglePlayServicesClient {
    private Person Rd;
    private final C0765h Re;

    /* renamed from: com.google.android.gms.plus.internal.e.d */
    final class C0763d extends C0270b<C0135c<Status>> {
        final /* synthetic */ C0979e Rf;
        private final Status vl;

        public C0763d(C0979e c0979e, C0135c<Status> c0135c, Status status) {
            this.Rf = c0979e;
            super(c0979e, c0135c);
            this.vl = status;
        }

        protected /* synthetic */ void m2240a(Object obj) {
            m2241c((C0135c) obj);
        }

        protected void m2241c(C0135c<Status> c0135c) {
            if (c0135c != null) {
                c0135c.m143b(this.vl);
            }
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.h */
    final class C0764h extends C0270b<C0135c<Status>> {
        final /* synthetic */ C0979e Rf;
        private final Status vl;

        public C0764h(C0979e c0979e, C0135c<Status> c0135c, Status status) {
            this.Rf = c0979e;
            super(c0979e, c0135c);
            this.vl = status;
        }

        protected /* synthetic */ void m2242a(Object obj) {
            m2243c((C0135c) obj);
        }

        protected void m2243c(C0135c<Status> c0135c) {
            this.Rf.disconnect();
            if (c0135c != null) {
                c0135c.m143b(this.vl);
            }
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.c */
    final class C0977c extends C0609d<C0135c<LoadMomentsResult>> implements LoadMomentsResult {
        private final String Dh;
        final /* synthetic */ C0979e Rf;
        private final String Rg;
        private MomentBuffer Rh;
        private final Status vl;

        public C0977c(C0979e c0979e, C0135c<LoadMomentsResult> c0135c, Status status, DataHolder dataHolder, String str, String str2) {
            this.Rf = c0979e;
            super(c0979e, c0135c, dataHolder);
            this.vl = status;
            this.Dh = str;
            this.Rg = str2;
        }

        protected void m2861a(C0135c<LoadMomentsResult> c0135c, DataHolder dataHolder) {
            this.Rh = dataHolder != null ? new MomentBuffer(dataHolder) : null;
            c0135c.m143b(this);
        }

        public MomentBuffer getMomentBuffer() {
            return this.Rh;
        }

        public String getNextPageToken() {
            return this.Dh;
        }

        public Status getStatus() {
            return this.vl;
        }

        public String getUpdated() {
            return this.Rg;
        }

        public void release() {
            if (this.Rh != null) {
                this.Rh.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.f */
    final class C0978f extends C0609d<C0135c<LoadPeopleResult>> implements LoadPeopleResult {
        private final String Dh;
        final /* synthetic */ C0979e Rf;
        private PersonBuffer Ri;
        private final Status vl;

        public C0978f(C0979e c0979e, C0135c<LoadPeopleResult> c0135c, Status status, DataHolder dataHolder, String str) {
            this.Rf = c0979e;
            super(c0979e, c0135c, dataHolder);
            this.vl = status;
            this.Dh = str;
        }

        protected void m2863a(C0135c<LoadPeopleResult> c0135c, DataHolder dataHolder) {
            this.Ri = dataHolder != null ? new PersonBuffer(dataHolder) : null;
            c0135c.m143b(this);
        }

        public String getNextPageToken() {
            return this.Dh;
        }

        public PersonBuffer getPersonBuffer() {
            return this.Ri;
        }

        public Status getStatus() {
            return this.vl;
        }

        public void release() {
            if (this.Ri != null) {
                this.Ri.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.a */
    final class C1064a extends C0976a {
        private final C0135c<Status> QI;
        final /* synthetic */ C0979e Rf;

        public C1064a(C0979e c0979e, C0135c<Status> c0135c) {
            this.Rf = c0979e;
            this.QI = c0135c;
        }

        public void m3127L(Status status) {
            this.Rf.m1791a(new C0763d(this.Rf, this.QI, status));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.b */
    final class C1065b extends C0976a {
        private final C0135c<LoadMomentsResult> QI;
        final /* synthetic */ C0979e Rf;

        public C1065b(C0979e c0979e, C0135c<LoadMomentsResult> c0135c) {
            this.Rf = c0979e;
            this.QI = c0135c;
        }

        public void m3128a(DataHolder dataHolder, String str, String str2) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.getMetadata() != null ? (PendingIntent) dataHolder.getMetadata().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            this.Rf.m1791a(new C0977c(this.Rf, this.QI, status, dataHolder2, str, str2));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.e */
    final class C1066e extends C0976a {
        private final C0135c<LoadPeopleResult> QI;
        final /* synthetic */ C0979e Rf;

        public C1066e(C0979e c0979e, C0135c<LoadPeopleResult> c0135c) {
            this.Rf = c0979e;
            this.QI = c0135c;
        }

        public void m3129a(DataHolder dataHolder, String str) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.getMetadata() != null ? (PendingIntent) dataHolder.getMetadata().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            this.Rf.m1791a(new C0978f(this.Rf, this.QI, status, dataHolder2, str));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.g */
    final class C1067g extends C0976a {
        private final C0135c<Status> QI;
        final /* synthetic */ C0979e Rf;

        public C1067g(C0979e c0979e, C0135c<Status> c0135c) {
            this.Rf = c0979e;
            this.QI = c0135c;
        }

        public void m3130d(int i, Bundle bundle) {
            this.Rf.m1791a(new C0764h(this.Rf, this.QI, new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null)));
        }
    }

    public C0979e(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, C0765h c0765h) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, c0765h.hq());
        this.Re = c0765h;
    }

    @Deprecated
    public C0979e(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, C0765h c0765h) {
        this(context, context.getMainLooper(), new C0608c(connectionCallbacks), new C0918g(onConnectionFailedListener), c0765h);
    }

    protected void m2865a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.Rd = ir.m2792i(bundle.getByteArray("loaded_person"));
        }
        super.m1790a(i, iBinder, bundle);
    }

    public void m2866a(C0135c<LoadPeopleResult> c0135c, int i, String str) {
        bm();
        Object c1066e = new C1066e(this, c0135c);
        try {
            ((C0353d) eb()).m1191a(c1066e, 1, i, -1, str);
        } catch (RemoteException e) {
            c1066e.m3129a(DataHolder.empty(8), null);
        }
    }

    public void m2867a(C0135c<LoadMomentsResult> c0135c, int i, String str, Uri uri, String str2, String str3) {
        bm();
        Object c1065b = c0135c != null ? new C1065b(this, c0135c) : null;
        try {
            ((C0353d) eb()).m1192a(c1065b, i, str, uri, str2, str3);
        } catch (RemoteException e) {
            c1065b.m3128a(DataHolder.empty(8), null, null);
        }
    }

    public void m2868a(C0135c<Status> c0135c, Moment moment) {
        bm();
        C0351b c1064a = c0135c != null ? new C1064a(this, c0135c) : null;
        try {
            ((C0353d) eb()).m1194a(c1064a, fh.m1861a((io) moment));
        } catch (Throwable e) {
            if (c1064a == null) {
                throw new IllegalStateException(e);
            }
            c1064a.m3127L(new Status(8, null, null));
        }
    }

    public void m2869a(C0135c<LoadPeopleResult> c0135c, Collection<String> collection) {
        bm();
        C0351b c1066e = new C1066e(this, c0135c);
        try {
            ((C0353d) eb()).m1197a(c1066e, new ArrayList(collection));
        } catch (RemoteException e) {
            c1066e.m3129a(DataHolder.empty(8), null);
        }
    }

    protected void m2870a(en enVar, C0917e c0917e) throws RemoteException {
        Bundle hy = this.Re.hy();
        hy.putStringArray(GoogleAuthUtil.KEY_REQUEST_VISIBLE_ACTIVITIES, this.Re.hr());
        enVar.m692a(c0917e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, this.Re.hu(), this.Re.ht(), ea(), this.Re.getAccountName(), hy);
    }

    protected C0353d aB(IBinder iBinder) {
        return C0762a.aA(iBinder);
    }

    protected String aF() {
        return "com.google.android.gms.plus.service.START";
    }

    protected String aG() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    public boolean aR(String str) {
        return Arrays.asList(ea()).contains(str);
    }

    public void m2871c(C0135c<LoadPeopleResult> c0135c, String[] strArr) {
        m2869a((C0135c) c0135c, Arrays.asList(strArr));
    }

    public void clearDefaultAccount() {
        bm();
        try {
            this.Rd = null;
            ((C0353d) eb()).clearDefaultAccount();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public String getAccountName() {
        bm();
        try {
            return ((C0353d) eb()).getAccountName();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public Person getCurrentPerson() {
        bm();
        return this.Rd;
    }

    public void m2872i(C0135c<LoadMomentsResult> c0135c) {
        m2867a(c0135c, 20, null, null, null, "me");
    }

    public void m2873i(C0135c<LoadPeopleResult> c0135c, String str) {
        m2866a((C0135c) c0135c, 0, str);
    }

    public void m2874j(C0135c<LoadPeopleResult> c0135c) {
        bm();
        Object c1066e = new C1066e(this, c0135c);
        try {
            ((C0353d) eb()).m1191a(c1066e, 2, 1, -1, null);
        } catch (RemoteException e) {
            c1066e.m3129a(DataHolder.empty(8), null);
        }
    }

    public void m2875k(C0135c<Status> c0135c) {
        bm();
        clearDefaultAccount();
        Object c1067g = new C1067g(this, c0135c);
        try {
            ((C0353d) eb()).m1198b(c1067g);
        } catch (RemoteException e) {
            c1067g.m3130d(8, null);
        }
    }

    protected /* synthetic */ IInterface m2876p(IBinder iBinder) {
        return aB(iBinder);
    }

    public void removeMoment(String momentId) {
        bm();
        try {
            ((C0353d) eb()).removeMoment(momentId);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
