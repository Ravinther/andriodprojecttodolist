package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.C0872n;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.internal.er;

public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private String CX;
    private DriveId CY;
    private String[] Dk;

    public IntentSender build(GoogleApiClient apiClient) {
        er.m719b(this.Dk, (Object) "setMimeType(String[]) must be called on this builder before calling build()");
        er.m717a(apiClient.isConnected(), "Client must be connected");
        try {
            return ((C0872n) apiClient.m135a(Drive.va)).eT().m300a(new OpenFileIntentSenderRequest(this.CX, this.Dk, this.CY));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.CY = (DriveId) er.m721f(folder);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String title) {
        this.CX = (String) er.m721f(title);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] mimeTypes) {
        boolean z = mimeTypes != null && mimeTypes.length > 0;
        er.m720b(z, (Object) "mimeTypes may not be null and must contain at least one value");
        this.Dk = mimeTypes;
        return this;
    }
}
