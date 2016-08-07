package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0136a.C0135c;
import com.google.android.gms.common.api.Status;

public class ak extends C0866c {
    private final C0135c<Status> vj;

    public ak(C0135c<Status> c0135c) {
        this.vj = c0135c;
    }

    public void m2933l(Status status) throws RemoteException {
        this.vj.m143b(status);
    }

    public void onSuccess() throws RemoteException {
        this.vj.m143b(Status.zQ);
    }
}
