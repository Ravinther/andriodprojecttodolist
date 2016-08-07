package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.internal.h */
public abstract class C0549h<T extends Parcelable> extends MetadataField<T> {
    public C0549h(String str, Collection<String> collection, int i) {
        super(str, collection, i);
    }

    protected void m1626a(Bundle bundle, T t) {
        bundle.putParcelable(getName(), t);
    }

    protected /* synthetic */ Object m1628e(Bundle bundle) {
        return m1629k(bundle);
    }

    protected T m1629k(Bundle bundle) {
        return bundle.getParcelable(getName());
    }
}
