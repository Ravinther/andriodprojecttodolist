package com.google.android.gms.internal;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.q */
class C0667q implements C0299o {
    private jz kv;
    private byte[] kw;
    private final int kx;

    public C0667q(int i) {
        this.kx = i;
        reset();
    }

    public void m2129b(int i, long j) throws IOException {
        this.kv.m1045b(i, j);
    }

    public void m2130b(int i, String str) throws IOException {
        this.kv.m1046b(i, str);
    }

    public void reset() {
        this.kw = new byte[this.kx];
        this.kv = jz.m1037o(this.kw);
    }

    public byte[] m2131z() throws IOException {
        int kM = this.kv.kM();
        if (kM < 0) {
            throw new IOException();
        } else if (kM == 0) {
            return this.kw;
        } else {
            Object obj = new byte[(this.kw.length - kM)];
            System.arraycopy(this.kw, 0, obj, 0, obj.length);
            return obj;
        }
    }
}
