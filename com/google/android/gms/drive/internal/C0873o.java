package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0136a.C0135c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.ContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.C0536l.C0868a;

/* renamed from: com.google.android.gms.drive.internal.o */
public class C0873o extends C0538r implements DriveFile {

    /* renamed from: com.google.android.gms.drive.internal.o.a */
    private abstract class C1002a extends C0871m<Status> {
        final /* synthetic */ C0873o DJ;

        private C1002a(C0873o c0873o) {
            this.DJ = c0873o;
        }

        public /* synthetic */ Result m2950d(Status status) {
            return m2951f(status);
        }

        public Status m2951f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o.b */
    private abstract class C1003b extends C0871m<Status> {
        final /* synthetic */ C0873o DJ;

        private C1003b(C0873o c0873o) {
            this.DJ = c0873o;
        }

        public /* synthetic */ Result m2952d(Status status) {
            return m2953f(status);
        }

        public Status m2953f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o.c */
    private static class C1004c extends C0866c {
        private final DownloadProgressListener DL;
        private final C0135c<ContentsResult> vj;

        public C1004c(C0135c<ContentsResult> c0135c, DownloadProgressListener downloadProgressListener) {
            this.vj = c0135c;
            this.DL = downloadProgressListener;
        }

        public void m2954a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.vj.m143b(new C0868a(Status.zQ, onContentsResponse.eX()));
        }

        public void m2955a(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
            if (this.DL != null) {
                this.DL.onProgress(onDownloadProgressResponse.eY(), onDownloadProgressResponse.eZ());
            }
        }

        public void m2956l(Status status) throws RemoteException {
            this.vj.m143b(new C0868a(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o.d */
    private abstract class C1005d extends C0871m<ContentsResult> {
        final /* synthetic */ C0873o DJ;

        private C1005d(C0873o c0873o) {
            this.DJ = c0873o;
        }

        public /* synthetic */ Result m2957d(Status status) {
            return m2958n(status);
        }

        public ContentsResult m2958n(Status status) {
            return new C0868a(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o.1 */
    class C11061 extends C1005d {
        final /* synthetic */ int DH;
        final /* synthetic */ DownloadProgressListener DI;
        final /* synthetic */ C0873o DJ;

        C11061(C0873o c0873o, int i, DownloadProgressListener downloadProgressListener) {
            this.DJ = c0873o;
            this.DH = i;
            this.DI = downloadProgressListener;
            super(null);
        }

        protected void m3217a(C0872n c0872n) throws RemoteException {
            c0872n.eT().m311a(new OpenContentsRequest(this.DJ.getDriveId(), this.DH), new C1004c(this, this.DI));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o.2 */
    class C11072 extends C1003b {
        final /* synthetic */ C0873o DJ;
        final /* synthetic */ Contents Dw;

        C11072(C0873o c0873o, Contents contents) {
            this.DJ = c0873o;
            this.Dw = contents;
            super(null);
        }

        protected void m3219a(C0872n c0872n) throws RemoteException {
            this.Dw.close();
            c0872n.eT().m304a(new CloseContentsRequest(this.Dw, true), new ak(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o.3 */
    class C11083 extends C1002a {
        final /* synthetic */ C0873o DJ;
        final /* synthetic */ MetadataChangeSet DK;
        final /* synthetic */ Contents Dw;

        C11083(C0873o c0873o, Contents contents, MetadataChangeSet metadataChangeSet) {
            this.DJ = c0873o;
            this.Dw = contents;
            this.DK = metadataChangeSet;
            super(null);
        }

        protected void m3221a(C0872n c0872n) throws RemoteException {
            this.Dw.close();
            c0872n.eT().m303a(new CloseContentsAndUpdateMetadataRequest(this.DJ.CS, this.DK.eS(), this.Dw), new ak(this));
        }
    }

    public C0873o(DriveId driveId) {
        super(driveId);
    }

    public PendingResult<Status> commitAndCloseContents(GoogleApiClient apiClient, Contents contents) {
        if (contents != null) {
            return apiClient.m137b(new C11072(this, contents));
        }
        throw new IllegalArgumentException("Contents must be provided.");
    }

    public PendingResult<Status> commitAndCloseContents(GoogleApiClient apiClient, Contents contents, MetadataChangeSet changeSet) {
        if (contents != null) {
            return apiClient.m137b(new C11083(this, contents, changeSet));
        }
        throw new IllegalArgumentException("Contents must be provided.");
    }

    public PendingResult<Status> discardContents(GoogleApiClient apiClient, Contents contents) {
        return Drive.DriveApi.discardContents(apiClient, contents);
    }

    public PendingResult<ContentsResult> openContents(GoogleApiClient apiClient, int mode, DownloadProgressListener listener) {
        if (mode == DriveFile.MODE_READ_ONLY || mode == DriveFile.MODE_WRITE_ONLY || mode == DriveFile.MODE_READ_WRITE) {
            return apiClient.m136a(new C11061(this, mode, listener));
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
