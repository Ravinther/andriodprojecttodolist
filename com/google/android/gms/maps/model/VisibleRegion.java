package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ep;
import com.google.android.gms.maps.internal.C0329r;

public final class VisibleRegion implements SafeParcelable {
    public static final VisibleRegionCreator CREATOR;
    public final LatLng farLeft;
    public final LatLng farRight;
    public final LatLngBounds latLngBounds;
    public final LatLng nearLeft;
    public final LatLng nearRight;
    private final int wj;

    static {
        CREATOR = new VisibleRegionCreator();
    }

    VisibleRegion(int versionCode, LatLng nearLeft, LatLng nearRight, LatLng farLeft, LatLng farRight, LatLngBounds latLngBounds) {
        this.wj = versionCode;
        this.nearLeft = nearLeft;
        this.nearRight = nearRight;
        this.farLeft = farLeft;
        this.farRight = farRight;
        this.latLngBounds = latLngBounds;
    }

    public VisibleRegion(LatLng nearLeft, LatLng nearRight, LatLng farLeft, LatLng farRight, LatLngBounds latLngBounds) {
        this(1, nearLeft, nearRight, farLeft, farRight, latLngBounds);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) o;
        return this.nearLeft.equals(visibleRegion.nearLeft) && this.nearRight.equals(visibleRegion.nearRight) && this.farLeft.equals(visibleRegion.farLeft) && this.farRight.equals(visibleRegion.farRight) && this.latLngBounds.equals(visibleRegion.latLngBounds);
    }

    int getVersionCode() {
        return this.wj;
    }

    public int hashCode() {
        return ep.hashCode(this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds);
    }

    public String toString() {
        return ep.m713e(this).m712a("nearLeft", this.nearLeft).m712a("nearRight", this.nearRight).m712a("farLeft", this.farLeft).m712a("farRight", this.farRight).m712a("latLngBounds", this.latLngBounds).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0329r.hc()) {
            C0347k.m1173a(this, out, flags);
        } else {
            VisibleRegionCreator.m1152a(this, out, flags);
        }
    }
}
