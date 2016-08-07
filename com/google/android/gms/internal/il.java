package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.C0132b;
import com.google.android.gms.common.api.C0136a.C0135c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.Plus.C0975a;
import com.google.android.gms.plus.internal.C0979e;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class il implements People {
    private final C0132b<C0979e> Rw;

    /* renamed from: com.google.android.gms.internal.il.a */
    private static abstract class C1060a extends C0975a<LoadPeopleResult> {

        /* renamed from: com.google.android.gms.internal.il.a.1 */
        class C09461 implements LoadPeopleResult {
            final /* synthetic */ C1060a RK;
            final /* synthetic */ Status vb;

            C09461(C1060a c1060a, Status status) {
                this.RK = c1060a;
                this.vb = status;
            }

            public String getNextPageToken() {
                return null;
            }

            public PersonBuffer getPersonBuffer() {
                return null;
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        C1060a(C0132b<C0979e> c0132b) {
            super(c0132b);
        }

        public LoadPeopleResult m3118N(Status status) {
            return new C09461(this, status);
        }

        public /* synthetic */ Result m3119d(Status status) {
            return m3118N(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.il.1 */
    class C11551 extends C1060a {
        final /* synthetic */ int RG;
        final /* synthetic */ il RH;
        final /* synthetic */ String Rz;

        C11551(il ilVar, C0132b c0132b, int i, String str) {
            this.RH = ilVar;
            this.RG = i;
            this.Rz = str;
            super(c0132b);
        }

        protected void m3327a(C0979e c0979e) {
            c0979e.m2866a((C0135c) this, this.RG, this.Rz);
        }
    }

    /* renamed from: com.google.android.gms.internal.il.2 */
    class C11562 extends C1060a {
        final /* synthetic */ il RH;
        final /* synthetic */ String Rz;

        C11562(il ilVar, C0132b c0132b, String str) {
            this.RH = ilVar;
            this.Rz = str;
            super(c0132b);
        }

        protected void m3329a(C0979e c0979e) {
            c0979e.m2873i(this, this.Rz);
        }
    }

    /* renamed from: com.google.android.gms.internal.il.3 */
    class C11573 extends C1060a {
        final /* synthetic */ il RH;

        C11573(il ilVar, C0132b c0132b) {
            this.RH = ilVar;
            super(c0132b);
        }

        protected void m3331a(C0979e c0979e) {
            c0979e.m2874j(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.il.4 */
    class C11584 extends C1060a {
        final /* synthetic */ il RH;
        final /* synthetic */ Collection RI;

        C11584(il ilVar, C0132b c0132b, Collection collection) {
            this.RH = ilVar;
            this.RI = collection;
            super(c0132b);
        }

        protected void m3333a(C0979e c0979e) {
            c0979e.m2869a((C0135c) this, this.RI);
        }
    }

    /* renamed from: com.google.android.gms.internal.il.5 */
    class C11595 extends C1060a {
        final /* synthetic */ il RH;
        final /* synthetic */ String[] RJ;

        C11595(il ilVar, C0132b c0132b, String[] strArr) {
            this.RH = ilVar;
            this.RJ = strArr;
            super(c0132b);
        }

        protected void m3335a(C0979e c0979e) {
            c0979e.m2871c(this, this.RJ);
        }
    }

    public il(C0132b<C0979e> c0132b) {
        this.Rw = c0132b;
    }

    public Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.m1174a(googleApiClient, this.Rw).getCurrentPerson();
    }

    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, Collection<String> personIds) {
        return googleApiClient.m136a(new C11584(this, this.Rw, personIds));
    }

    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, String... personIds) {
        return googleApiClient.m136a(new C11595(this, this.Rw, personIds));
    }

    public PendingResult<LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.m136a(new C11573(this, this.Rw));
    }

    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, int orderBy, String pageToken) {
        return googleApiClient.m136a(new C11551(this, this.Rw, orderBy, pageToken));
    }

    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, String pageToken) {
        return googleApiClient.m136a(new C11562(this, this.Rw, pageToken));
    }
}
