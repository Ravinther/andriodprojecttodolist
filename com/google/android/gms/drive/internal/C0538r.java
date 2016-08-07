package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0136a.C0135c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.internal.C0536l.C0870e;

/* renamed from: com.google.android.gms.drive.internal.r */
public class C0538r implements DriveResource {
    protected final DriveId CS;

    /* renamed from: com.google.android.gms.drive.internal.r.e */
    private static class C0877e implements MetadataResult {
        private final Metadata DQ;
        private final Status vl;

        public C0877e(Status status, Metadata metadata) {
            this.vl = status;
            this.DQ = metadata;
        }

        public Metadata getMetadata() {
            return this.DQ;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.a */
    private abstract class C1010a extends C0871m<MetadataResult> {
        final /* synthetic */ C0538r DP;

        private C1010a(C0538r c0538r) {
            this.DP = c0538r;
        }

        public /* synthetic */ Result m2969d(Status status) {
            return m2970r(status);
        }

        public MetadataResult m2970r(Status status) {
            return new C0877e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.b */
    private static class C1011b extends C0866c {
        private final C0135c<MetadataBufferResult> vj;

        public C1011b(C0135c<MetadataBufferResult> c0135c) {
            this.vj = c0135c;
        }

        public void m2971a(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.vj.m143b(new C0870e(Status.zQ, new MetadataBuffer(onListParentsResponse.fd(), null)));
        }

        public void m2972l(Status status) throws RemoteException {
            this.vj.m143b(new C0870e(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.c */
    private abstract class C1012c extends C0871m<MetadataBufferResult> {
        final /* synthetic */ C0538r DP;

        private C1012c(C0538r c0538r) {
            this.DP = c0538r;
        }

        public /* synthetic */ Result m2973d(Status status) {
            return m2974o(status);
        }

        public MetadataBufferResult m2974o(Status status) {
            return new C0870e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.d */
    private static class C1013d extends C0866c {
        private final C0135c<MetadataResult> vj;

        public C1013d(C0135c<MetadataResult> c0135c) {
            this.vj = c0135c;
        }

        public void m2975a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.vj.m143b(new C0877e(Status.zQ, new C0867j(onMetadataResponse.fe())));
        }

        public void m2976l(Status status) throws RemoteException {
            this.vj.m143b(new C0877e(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.f */
    private abstract class C1014f extends C0871m<MetadataResult> {
        final /* synthetic */ C0538r DP;

        private C1014f(C0538r c0538r) {
            this.DP = c0538r;
        }

        public /* synthetic */ Result m2977d(Status status) {
            return m2978r(status);
        }

        public MetadataResult m2978r(Status status) {
            return new C0877e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.1 */
    class C11101 extends C1010a {
        final /* synthetic */ C0538r DP;

        C11101(C0538r c0538r) {
            this.DP = c0538r;
            super(null);
        }

        protected void m3225a(C0872n c0872n) throws RemoteException {
            c0872n.eT().m309a(new GetMetadataRequest(this.DP.CS), new C1013d(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.2 */
    class C11112 extends C1012c {
        final /* synthetic */ C0538r DP;

        C11112(C0538r c0538r) {
            this.DP = c0538r;
            super(null);
        }

        protected void m3227a(C0872n c0872n) throws RemoteException {
            c0872n.eT().m310a(new ListParentsRequest(this.DP.CS), new C1011b(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.3 */
    class C11123 extends C1014f {
        final /* synthetic */ MetadataChangeSet DK;
        final /* synthetic */ C0538r DP;

        C11123(C0538r c0538r, MetadataChangeSet metadataChangeSet) {
            this.DP = c0538r;
            this.DK = metadataChangeSet;
            super(null);
        }

        protected void m3229a(C0872n c0872n) throws RemoteException {
            c0872n.eT().m315a(new UpdateMetadataRequest(this.DP.CS, this.DK.eS()), new C1013d(this));
        }
    }

    protected C0538r(DriveId driveId) {
        this.CS = driveId;
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient apiClient, Listener<ChangeEvent> listener) {
        return ((C0872n) apiClient.m135a(Drive.va)).m2423a(apiClient, this.CS, 1, listener);
    }

    public DriveId getDriveId() {
        return this.CS;
    }

    public PendingResult<MetadataResult> getMetadata(GoogleApiClient apiClient) {
        return apiClient.m136a(new C11101(this));
    }

    public PendingResult<MetadataBufferResult> listParents(GoogleApiClient apiClient) {
        return apiClient.m136a(new C11112(this));
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient apiClient, Listener<ChangeEvent> listener) {
        return ((C0872n) apiClient.m135a(Drive.va)).m2426b(apiClient, this.CS, 1, listener);
    }

    public PendingResult<MetadataResult> updateMetadata(GoogleApiClient apiClient, MetadataChangeSet changeSet) {
        if (changeSet != null) {
            return apiClient.m137b(new C11123(this, changeSet));
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
