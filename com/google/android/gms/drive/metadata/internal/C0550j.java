package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;

/* renamed from: com.google.android.gms.drive.metadata.internal.j */
public final class C0550j extends MetadataField<String> {
    public C0550j(String str, int i) {
        super(str, i);
    }

    protected void m1631a(Bundle bundle, String str) {
        bundle.putString(getName(), str);
    }

    protected /* synthetic */ Object m1632b(DataHolder dataHolder, int i, int i2) {
        return m1634h(dataHolder, i, i2);
    }

    protected /* synthetic */ Object m1633e(Bundle bundle) {
        return m1635l(bundle);
    }

    protected String m1634h(DataHolder dataHolder, int i, int i2) {
        return dataHolder.getString(getName(), i, i2);
    }

    protected String m1635l(Bundle bundle) {
        return bundle.getString(getName());
    }
}
