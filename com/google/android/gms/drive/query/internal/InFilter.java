package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;
import java.util.Collections;

public class InFilter<T> implements SafeParcelable, Filter {
    public static final C0185e CREATOR;
    final MetadataBundle EP;
    private final CollectionMetadataField<T> EX;
    final int wj;

    static {
        CREATOR = new C0185e();
    }

    InFilter(int versionCode, MetadataBundle value) {
        this.wj = versionCode;
        this.EP = value;
        this.EX = (CollectionMetadataField) C0184d.m342b(value);
    }

    public InFilter(CollectionMetadataField<T> field, T value) {
        this(1, MetadataBundle.m1604a(field, Collections.singleton(value)));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0185e.m343a(this, out, flags);
    }
}
