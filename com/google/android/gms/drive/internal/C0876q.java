package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0136a.C0135c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.Builder;
import com.google.android.gms.drive.query.SearchableField;

/* renamed from: com.google.android.gms.drive.internal.q */
public class C0876q extends C0538r implements DriveFolder {

    /* renamed from: com.google.android.gms.drive.internal.q.d */
    private static class C0874d implements DriveFileResult {
        private final DriveFile DN;
        private final Status vl;

        public C0874d(Status status, DriveFile driveFile) {
            this.vl = status;
            this.DN = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.DN;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q.e */
    private static class C0875e implements DriveFolderResult {
        private final DriveFolder DO;
        private final Status vl;

        public C0875e(Status status, DriveFolder driveFolder) {
            this.vl = status;
            this.DO = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.DO;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q.1 */
    class C10061 extends C0871m<DriveFileResult> {
        final /* synthetic */ MetadataChangeSet DK;
        final /* synthetic */ C0876q DM;
        final /* synthetic */ Contents Dw;

        C10061(C0876q c0876q, Contents contents, MetadataChangeSet metadataChangeSet) {
            this.DM = c0876q;
            this.Dw = contents;
            this.DK = metadataChangeSet;
        }

        protected void m2960a(C0872n c0872n) throws RemoteException {
            this.Dw.close();
            c0872n.eT().m306a(new CreateFileRequest(this.DM.getDriveId(), this.DK.eS(), this.Dw), new C1007a(this));
        }

        public /* synthetic */ Result m2961d(Status status) {
            return m2962p(status);
        }

        public DriveFileResult m2962p(Status status) {
            return new C0874d(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q.a */
    private static class C1007a extends C0866c {
        private final C0135c<DriveFileResult> vj;

        public C1007a(C0135c<DriveFileResult> c0135c) {
            this.vj = c0135c;
        }

        public void m2963a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.vj.m143b(new C0874d(Status.zQ, new C0873o(onDriveIdResponse.getDriveId())));
        }

        public void m2964l(Status status) throws RemoteException {
            this.vj.m143b(new C0874d(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q.b */
    private static class C1008b extends C0866c {
        private final C0135c<DriveFolderResult> vj;

        public C1008b(C0135c<DriveFolderResult> c0135c) {
            this.vj = c0135c;
        }

        public void m2965a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.vj.m143b(new C0875e(Status.zQ, new C0876q(onDriveIdResponse.getDriveId())));
        }

        public void m2966l(Status status) throws RemoteException {
            this.vj.m143b(new C0875e(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q.c */
    private abstract class C1009c extends C0871m<DriveFolderResult> {
        final /* synthetic */ C0876q DM;

        private C1009c(C0876q c0876q) {
            this.DM = c0876q;
        }

        public /* synthetic */ Result m2967d(Status status) {
            return m2968q(status);
        }

        public DriveFolderResult m2968q(Status status) {
            return new C0875e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q.2 */
    class C11092 extends C1009c {
        final /* synthetic */ MetadataChangeSet DK;
        final /* synthetic */ C0876q DM;

        C11092(C0876q c0876q, MetadataChangeSet metadataChangeSet) {
            this.DM = c0876q;
            this.DK = metadataChangeSet;
            super(null);
        }

        protected void m3223a(C0872n c0872n) throws RemoteException {
            c0872n.eT().m307a(new CreateFolderRequest(this.DM.getDriveId(), this.DK.eS()), new C1008b(this));
        }
    }

    public C0876q(DriveId driveId) {
        super(driveId);
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, Contents contents) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetatadataChangeSet must be provided.");
        } else if (contents == null) {
            throw new IllegalArgumentException("Contents must be provided.");
        } else if (!DriveFolder.MIME_TYPE.equals(changeSet.getMimeType())) {
            return apiClient.m137b(new C10061(this, contents, changeSet));
        } else {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        }
    }

    public PendingResult<DriveFolderResult> createFolder(GoogleApiClient apiClient, MetadataChangeSet changeSet) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetatadataChangeSet must be provided.");
        } else if (changeSet.getMimeType() == null || changeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return apiClient.m137b(new C11092(this, changeSet));
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult<MetadataBufferResult> listChildren(GoogleApiClient apiClient) {
        return queryChildren(apiClient, null);
    }

    public PendingResult<MetadataBufferResult> queryChildren(GoogleApiClient apiClient, Query query) {
        Builder addFilter = new Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
        }
        return new C0536l().query(apiClient, addFilter.build());
    }
}
