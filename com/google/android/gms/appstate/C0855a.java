package com.google.android.gms.appstate;

import com.google.android.gms.internal.ep;

/* renamed from: com.google.android.gms.appstate.a */
public final class C0855a implements AppState {
    private final int uU;
    private final String uV;
    private final byte[] uW;
    private final boolean uX;
    private final String uY;
    private final byte[] uZ;

    public C0855a(AppState appState) {
        this.uU = appState.getKey();
        this.uV = appState.getLocalVersion();
        this.uW = appState.getLocalData();
        this.uX = appState.hasConflict();
        this.uY = appState.getConflictVersion();
        this.uZ = appState.getConflictData();
    }

    static int m2406a(AppState appState) {
        return ep.hashCode(Integer.valueOf(appState.getKey()), appState.getLocalVersion(), appState.getLocalData(), Boolean.valueOf(appState.hasConflict()), appState.getConflictVersion(), appState.getConflictData());
    }

    static boolean m2407a(AppState appState, Object obj) {
        if (!(obj instanceof AppState)) {
            return false;
        }
        if (appState == obj) {
            return true;
        }
        AppState appState2 = (AppState) obj;
        return ep.equal(Integer.valueOf(appState2.getKey()), Integer.valueOf(appState.getKey())) && ep.equal(appState2.getLocalVersion(), appState.getLocalVersion()) && ep.equal(appState2.getLocalData(), appState.getLocalData()) && ep.equal(Boolean.valueOf(appState2.hasConflict()), Boolean.valueOf(appState.hasConflict())) && ep.equal(appState2.getConflictVersion(), appState.getConflictVersion()) && ep.equal(appState2.getConflictData(), appState.getConflictData());
    }

    static String m2408b(AppState appState) {
        return ep.m713e(appState).m712a("Key", Integer.valueOf(appState.getKey())).m712a("LocalVersion", appState.getLocalVersion()).m712a("LocalData", appState.getLocalData()).m712a("HasConflict", Boolean.valueOf(appState.hasConflict())).m712a("ConflictVersion", appState.getConflictVersion()).m712a("ConflictData", appState.getConflictData()).toString();
    }

    public AppState cL() {
        return this;
    }

    public boolean equals(Object obj) {
        return C0855a.m2407a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return cL();
    }

    public byte[] getConflictData() {
        return this.uZ;
    }

    public String getConflictVersion() {
        return this.uY;
    }

    public int getKey() {
        return this.uU;
    }

    public byte[] getLocalData() {
        return this.uW;
    }

    public String getLocalVersion() {
        return this.uV;
    }

    public boolean hasConflict() {
        return this.uX;
    }

    public int hashCode() {
        return C0855a.m2406a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return C0855a.m2408b(this);
    }
}
