package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.Api.C0132b;
import com.google.android.gms.common.api.C0136a.C0135c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.Plus.C0975a;
import com.google.android.gms.plus.internal.C0979e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public final class ik implements Moments {
    private final C0132b<C0979e> Rw;

    /* renamed from: com.google.android.gms.internal.ik.a */
    private static abstract class C1057a extends C0975a<LoadMomentsResult> {

        /* renamed from: com.google.android.gms.internal.ik.a.1 */
        class C09451 implements LoadMomentsResult {
            final /* synthetic */ C1057a RF;
            final /* synthetic */ Status vb;

            C09451(C1057a c1057a, Status status) {
                this.RF = c1057a;
                this.vb = status;
            }

            public MomentBuffer getMomentBuffer() {
                return null;
            }

            public String getNextPageToken() {
                return null;
            }

            public Status getStatus() {
                return this.vb;
            }

            public String getUpdated() {
                return null;
            }

            public void release() {
            }
        }

        C1057a(C0132b<C0979e> c0132b) {
            super(c0132b);
        }

        public LoadMomentsResult m3112M(Status status) {
            return new C09451(this, status);
        }

        public /* synthetic */ Result m3113d(Status status) {
            return m3112M(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.ik.b */
    private static abstract class C1058b extends C0975a<Status> {
        C1058b(C0132b<C0979e> c0132b) {
            super(c0132b);
        }

        public /* synthetic */ Result m3114d(Status status) {
            return m3115f(status);
        }

        public Status m3115f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.ik.c */
    private static abstract class C1059c extends C0975a<Status> {
        C1059c(C0132b<C0979e> c0132b) {
            super(c0132b);
        }

        public /* synthetic */ Result m3116d(Status status) {
            return m3117f(status);
        }

        public Status m3117f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.ik.1 */
    class C11511 extends C1057a {
        final /* synthetic */ ik Ry;

        C11511(ik ikVar, C0132b c0132b) {
            this.Ry = ikVar;
            super(c0132b);
        }

        protected void m3319a(C0979e c0979e) {
            c0979e.m2872i(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.ik.2 */
    class C11522 extends C1057a {
        final /* synthetic */ int HW;
        final /* synthetic */ Uri RA;
        final /* synthetic */ String RB;
        final /* synthetic */ String RC;
        final /* synthetic */ ik Ry;
        final /* synthetic */ String Rz;

        C11522(ik ikVar, C0132b c0132b, int i, String str, Uri uri, String str2, String str3) {
            this.Ry = ikVar;
            this.HW = i;
            this.Rz = str;
            this.RA = uri;
            this.RB = str2;
            this.RC = str3;
            super(c0132b);
        }

        protected void m3321a(C0979e c0979e) {
            c0979e.m2867a(this, this.HW, this.Rz, this.RA, this.RB, this.RC);
        }
    }

    /* renamed from: com.google.android.gms.internal.ik.3 */
    class C11533 extends C1059c {
        final /* synthetic */ Moment RD;
        final /* synthetic */ ik Ry;

        C11533(ik ikVar, C0132b c0132b, Moment moment) {
            this.Ry = ikVar;
            this.RD = moment;
            super(c0132b);
        }

        protected void m3323a(C0979e c0979e) {
            c0979e.m2868a((C0135c) this, this.RD);
        }
    }

    /* renamed from: com.google.android.gms.internal.ik.4 */
    class C11544 extends C1058b {
        final /* synthetic */ String RE;
        final /* synthetic */ ik Ry;

        C11544(ik ikVar, C0132b c0132b, String str) {
            this.Ry = ikVar;
            this.RE = str;
            super(c0132b);
        }

        protected void m3325a(C0979e c0979e) {
            c0979e.removeMoment(this.RE);
            m1527a(Status.zQ);
        }
    }

    public ik(C0132b<C0979e> c0132b) {
        this.Rw = c0132b;
    }

    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient) {
        return googleApiClient.m136a(new C11511(this, this.Rw));
    }

    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        return googleApiClient.m136a(new C11522(this, this.Rw, maxResults, pageToken, targetUrl, type, userId));
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, String momentId) {
        return googleApiClient.m137b(new C11544(this, this.Rw, momentId));
    }

    public PendingResult<Status> write(GoogleApiClient googleApiClient, Moment moment) {
        return googleApiClient.m137b(new C11533(this, this.Rw, moment));
    }
}
