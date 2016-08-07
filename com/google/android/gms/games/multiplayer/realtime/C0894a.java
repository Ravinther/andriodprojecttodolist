package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.C0533d;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.games.multiplayer.realtime.a */
public final class C0894a extends C0533d<Room> {
    public C0894a(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object m2458c(int i, int i2) {
        return m2459d(i, i2);
    }

    protected Room m2459d(int i, int i2) {
        return new C0895c(this.zU, i, i2);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_match_id";
    }
}
