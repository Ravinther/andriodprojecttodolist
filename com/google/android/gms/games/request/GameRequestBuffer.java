package com.google.android.gms.games.request;

import com.google.android.gms.common.data.C0533d;
import com.google.android.gms.common.data.DataHolder;

public final class GameRequestBuffer extends C0533d<GameRequest> {
    public GameRequestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object m2468c(int i, int i2) {
        return getEntry(i, i2);
    }

    protected GameRequest getEntry(int rowIndex, int numChildren) {
        return new C0897a(this.zU, rowIndex, numChildren);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_request_id";
    }
}
