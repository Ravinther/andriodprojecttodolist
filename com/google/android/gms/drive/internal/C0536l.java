package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0136a.C0135c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.ContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;

/* renamed from: com.google.android.gms.drive.internal.l */
public class C0536l implements DriveApi {

    /* renamed from: com.google.android.gms.drive.internal.l.a */
    static class C0868a implements ContentsResult {
        private final Contents CW;
        private final Status vl;

        public C0868a(Status status, Contents contents) {
            this.vl = status;
            this.CW = contents;
        }

        public Contents getContents() {
            return this.CW;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.c */
    static class C0869c implements DriveIdResult {
        private final DriveId CS;
        private final Status vl;

        public C0869c(Status status, DriveId driveId) {
            this.vl = status;
            this.CS = driveId;
        }

        public DriveId getDriveId() {
            return this.CS;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.e */
    static class C0870e implements MetadataBufferResult {
        private final MetadataBuffer Dy;
        private final Status vl;

        public C0870e(Status status, MetadataBuffer metadataBuffer) {
            this.vl = status;
            this.Dy = metadataBuffer;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.Dy;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.b */
    private static class C0994b extends C0866c {
        private final C0135c<DriveIdResult> vj;

        public C0994b(C0135c<DriveIdResult> c0135c) {
            this.vj = c0135c;
        }

        public void m2934a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.vj.m143b(new C0869c(Status.zQ, new C0867j(onMetadataResponse.fe()).getDriveId()));
        }

        public void m2935l(Status status) throws RemoteException {
            this.vj.m143b(new C0869c(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.d */
    abstract class C0995d extends C0871m<DriveIdResult> {
        final /* synthetic */ C0536l Dv;

        C0995d(C0536l c0536l) {
            this.Dv = c0536l;
        }

        public /* synthetic */ Result m2936d(Status status) {
            return m2937m(status);
        }

        public DriveIdResult m2937m(Status status) {
            return new C0869c(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.f */
    private static class C0996f extends C0866c {
        private final C0135c<ContentsResult> vj;

        public C0996f(C0135c<ContentsResult> c0135c) {
            this.vj = c0135c;
        }

        public void m2938a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.vj.m143b(new C0868a(Status.zQ, onContentsResponse.eX()));
        }

        public void m2939l(Status status) throws RemoteException {
            this.vj.m143b(new C0868a(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.g */
    abstract class C0997g extends C0871m<ContentsResult> {
        final /* synthetic */ C0536l Dv;

        C0997g(C0536l c0536l) {
            this.Dv = c0536l;
        }

        public /* synthetic */ Result m2940d(Status status) {
            return m2941n(status);
        }

        public ContentsResult m2941n(Status status) {
            return new C0868a(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.h */
    static class C0998h extends C0866c {
        private final C0135c<MetadataBufferResult> vj;

        public C0998h(C0135c<MetadataBufferResult> c0135c) {
            this.vj = c0135c;
        }

        public void m2942a(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
            this.vj.m143b(new C0870e(Status.zQ, new MetadataBuffer(onListEntriesResponse.fc(), null)));
        }

        public void m2943l(Status status) throws RemoteException {
            this.vj.m143b(new C0870e(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.i */
    abstract class C0999i extends C0871m<MetadataBufferResult> {
        final /* synthetic */ C0536l Dv;

        C0999i(C0536l c0536l) {
            this.Dv = c0536l;
        }

        public /* synthetic */ Result m2944d(Status status) {
            return m2945o(status);
        }

        public MetadataBufferResult m2945o(Status status) {
            return new C0870e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.j */
    static abstract class C1000j extends C0871m<Status> {
        C1000j() {
        }

        public /* synthetic */ Result m2946d(Status status) {
            return m2947f(status);
        }

        public Status m2947f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.l */
    abstract class C1001l extends C0871m<Status> {
        final /* synthetic */ C0536l Dv;

        C1001l(C0536l c0536l) {
            this.Dv = c0536l;
        }

        public /* synthetic */ Result m2948d(Status status) {
            return m2949f(status);
        }

        public Status m2949f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.1 */
    class C10981 extends C0999i {
        final /* synthetic */ Query Du;
        final /* synthetic */ C0536l Dv;

        C10981(C0536l c0536l, Query query) {
            this.Dv = c0536l;
            this.Du = query;
            super(c0536l);
        }

        protected void m3201a(C0872n c0872n) throws RemoteException {
            c0872n.eT().m312a(new QueryRequest(this.Du), new C0998h(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.2 */
    class C10992 extends C0997g {
        final /* synthetic */ C0536l Dv;

        C10992(C0536l c0536l) {
            this.Dv = c0536l;
            super(c0536l);
        }

        protected void m3203a(C0872n c0872n) throws RemoteException {
            c0872n.eT().m305a(new CreateContentsRequest(), new C0996f(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.3 */
    class C11003 extends C1000j {
        final /* synthetic */ C0536l Dv;
        final /* synthetic */ Contents Dw;

        C11003(C0536l c0536l, Contents contents) {
            this.Dv = c0536l;
            this.Dw = contents;
        }

        protected void m3205a(C0872n c0872n) throws RemoteException {
            c0872n.eT().m304a(new CloseContentsRequest(this.Dw, false), new ak(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.4 */
    class C11014 extends C0995d {
        final /* synthetic */ C0536l Dv;
        final /* synthetic */ String Dx;

        C11014(C0536l c0536l, String str) {
            this.Dv = c0536l;
            this.Dx = str;
            super(c0536l);
        }

        protected void m3207a(C0872n c0872n) throws RemoteException {
            c0872n.eT().m309a(new GetMetadataRequest(DriveId.aq(this.Dx)), new C0994b(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.5 */
    class C11025 extends C1001l {
        final /* synthetic */ C0536l Dv;

        C11025(C0536l c0536l) {
            this.Dv = c0536l;
            super(c0536l);
        }

        protected void m3209a(C0872n c0872n) throws RemoteException {
            c0872n.eT().m316a(new ak(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.k */
    static class C1103k extends C1000j {
        C1103k(Status status) {
            m1527a((Result) status);
        }

        protected void m3211a(C0872n c0872n) {
        }
    }

    public PendingResult<Status> discardContents(GoogleApiClient apiClient, Contents contents) {
        return apiClient.m137b(new C11003(this, contents));
    }

    public PendingResult<DriveIdResult> fetchDriveId(GoogleApiClient apiClient, String resourceId) {
        return apiClient.m136a(new C11014(this, resourceId));
    }

    public DriveFolder getAppFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            DriveId eV = ((C0872n) apiClient.m135a(Drive.va)).eV();
            return eV != null ? new C0876q(eV) : null;
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFile getFile(GoogleApiClient apiClient, DriveId id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new C0873o(id);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getFolder(GoogleApiClient apiClient, DriveId id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new C0876q(id);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            return new C0876q(((C0872n) apiClient.m135a(Drive.va)).eU());
        }
        throw new IllegalStateException("Client must be connected");
    }

    public PendingResult<ContentsResult> newContents(GoogleApiClient apiClient) {
        return apiClient.m136a(new C10992(this));
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult<MetadataBufferResult> query(GoogleApiClient apiClient, Query query) {
        if (query != null) {
            return apiClient.m136a(new C10981(this, query));
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    public PendingResult<Status> requestSync(GoogleApiClient client) {
        return client.m137b(new C11025(this));
    }
}
