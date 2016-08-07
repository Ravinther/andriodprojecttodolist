package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.er;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class MetadataField<T> {
    private final String Eg;
    private final Set<String> Eh;
    private final int Ei;

    protected MetadataField(String fieldName, int versionAdded) {
        this.Eg = (String) er.m719b((Object) fieldName, (Object) "fieldName");
        this.Eh = Collections.singleton(fieldName);
        this.Ei = versionAdded;
    }

    protected MetadataField(String fieldName, Collection<String> dataHolderFieldNames, int versionAdded) {
        this.Eg = (String) er.m719b((Object) fieldName, (Object) "fieldName");
        this.Eh = Collections.unmodifiableSet(new HashSet(dataHolderFieldNames));
        this.Ei = versionAdded;
    }

    protected abstract void m329a(Bundle bundle, T t);

    public final void m330a(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2) {
        er.m719b((Object) dataHolder, (Object) "dataHolder");
        er.m719b((Object) metadataBundle, (Object) "bundle");
        metadataBundle.m1607b(this, m333c(dataHolder, i, i2));
    }

    public final void m331a(T t, Bundle bundle) {
        er.m719b((Object) bundle, (Object) "bundle");
        if (t == null) {
            bundle.putString(getName(), null);
        } else {
            m329a(bundle, (Object) t);
        }
    }

    protected abstract T m332b(DataHolder dataHolder, int i, int i2);

    public final T m333c(DataHolder dataHolder, int i, int i2) {
        for (String hasNull : this.Eh) {
            if (dataHolder.hasNull(hasNull, i, i2)) {
                return null;
            }
        }
        return m332b(dataHolder, i, i2);
    }

    public final T m334d(Bundle bundle) {
        er.m719b((Object) bundle, (Object) "bundle");
        return bundle.get(getName()) != null ? m335e(bundle) : null;
    }

    protected abstract T m335e(Bundle bundle);

    public final Collection<String> ff() {
        return this.Eh;
    }

    public final String getName() {
        return this.Eg;
    }

    public final int getVersionAdded() {
        return this.Ei;
    }

    public String toString() {
        return this.Eg;
    }
}
