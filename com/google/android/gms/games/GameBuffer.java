package com.google.android.gms.games;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class GameBuffer extends DataBuffer<Game> {
    public GameBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public Game get(int position) {
        return new C0884b(this.zU, position);
    }
}
