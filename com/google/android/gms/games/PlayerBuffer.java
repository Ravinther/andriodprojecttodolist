package com.google.android.gms.games;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class PlayerBuffer extends DataBuffer<Player> {
    public PlayerBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public Player get(int position) {
        return new C0885d(this.zU, position);
    }
}
