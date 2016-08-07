package com.google.android.gms.appstate;

import com.google.android.gms.common.data.C0142b;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.appstate.b */
public final class C0856b extends C0142b implements AppState {
    C0856b(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public AppState cL() {
        return new C0855a(this);
    }

    public boolean equals(Object obj) {
        return C0855a.m2407a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return cL();
    }

    public byte[] getConflictData() {
        return getByteArray("conflict_data");
    }

    public String getConflictVersion() {
        return getString("conflict_version");
    }

    public int getKey() {
        return getInteger("key");
    }

    public byte[] getLocalData() {
        return getByteArray("local_data");
    }

    public String getLocalVersion() {
        return getString("local_version");
    }

    public boolean hasConflict() {
        return !ab("conflict_version");
    }

    public int hashCode() {
        return C0855a.m2406a(this);
    }

    public String toString() {
        return C0855a.m2408b(this);
    }
}
