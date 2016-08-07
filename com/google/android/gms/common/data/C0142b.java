package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.er;

/* renamed from: com.google.android.gms.common.data.b */
public abstract class C0142b {
    protected final DataHolder zU;
    protected final int zW;
    private final int zX;

    public C0142b(DataHolder dataHolder, int i) {
        this.zU = (DataHolder) er.m721f(dataHolder);
        boolean z = i >= 0 && i < dataHolder.getCount();
        er.m722v(z);
        this.zW = i;
        this.zX = dataHolder.m1554I(this.zW);
    }

    protected void m152a(String str, CharArrayBuffer charArrayBuffer) {
        this.zU.copyToBuffer(str, this.zW, this.zX, charArrayBuffer);
    }

    protected Uri aa(String str) {
        return this.zU.parseUri(str, this.zW, this.zX);
    }

    protected boolean ab(String str) {
        return this.zU.hasNull(str, this.zW, this.zX);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0142b)) {
            return false;
        }
        C0142b c0142b = (C0142b) obj;
        return ep.equal(Integer.valueOf(c0142b.zW), Integer.valueOf(this.zW)) && ep.equal(Integer.valueOf(c0142b.zX), Integer.valueOf(this.zX)) && c0142b.zU == this.zU;
    }

    protected boolean getBoolean(String column) {
        return this.zU.getBoolean(column, this.zW, this.zX);
    }

    protected byte[] getByteArray(String column) {
        return this.zU.getByteArray(column, this.zW, this.zX);
    }

    protected int getInteger(String column) {
        return this.zU.getInteger(column, this.zW, this.zX);
    }

    protected long getLong(String column) {
        return this.zU.getLong(column, this.zW, this.zX);
    }

    protected String getString(String column) {
        return this.zU.getString(column, this.zW, this.zX);
    }

    public boolean hasColumn(String column) {
        return this.zU.hasColumn(column);
    }

    public int hashCode() {
        return ep.hashCode(Integer.valueOf(this.zW), Integer.valueOf(this.zX), this.zU);
    }

    public boolean isDataValid() {
        return !this.zU.isClosed();
    }
}
