package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0192b.C0557a;
import com.google.android.gms.internal.er;
import com.google.android.gms.maps.internal.C0329r;

public final class GroundOverlayOptions implements SafeParcelable {
    public static final GroundOverlayOptionsCreator CREATOR;
    public static final float NO_DIMENSION = -1.0f;
    private float PI;
    private float PP;
    private boolean PQ;
    private BitmapDescriptor PS;
    private LatLng PT;
    private float PU;
    private float PV;
    private LatLngBounds PW;
    private float PX;
    private float PY;
    private float PZ;
    private final int wj;

    static {
        CREATOR = new GroundOverlayOptionsCreator();
    }

    public GroundOverlayOptions() {
        this.PQ = true;
        this.PX = 0.0f;
        this.PY = 0.5f;
        this.PZ = 0.5f;
        this.wj = 1;
    }

    GroundOverlayOptions(int versionCode, IBinder wrappedImage, LatLng location, float width, float height, LatLngBounds bounds, float bearing, float zIndex, boolean visible, float transparency, float anchorU, float anchorV) {
        this.PQ = true;
        this.PX = 0.0f;
        this.PY = 0.5f;
        this.PZ = 0.5f;
        this.wj = versionCode;
        this.PS = new BitmapDescriptor(C0557a.m1641G(wrappedImage));
        this.PT = location;
        this.PU = width;
        this.PV = height;
        this.PW = bounds;
        this.PI = bearing;
        this.PP = zIndex;
        this.PQ = visible;
        this.PX = transparency;
        this.PY = anchorU;
        this.PZ = anchorV;
    }

    private GroundOverlayOptions m2173a(LatLng latLng, float f, float f2) {
        this.PT = latLng;
        this.PU = f;
        this.PV = f2;
        return this;
    }

    public GroundOverlayOptions anchor(float u, float v) {
        this.PY = u;
        this.PZ = v;
        return this;
    }

    public GroundOverlayOptions bearing(float bearing) {
        this.PI = ((bearing % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.PY;
    }

    public float getAnchorV() {
        return this.PZ;
    }

    public float getBearing() {
        return this.PI;
    }

    public LatLngBounds getBounds() {
        return this.PW;
    }

    public float getHeight() {
        return this.PV;
    }

    public BitmapDescriptor getImage() {
        return this.PS;
    }

    public LatLng getLocation() {
        return this.PT;
    }

    public float getTransparency() {
        return this.PX;
    }

    int getVersionCode() {
        return this.wj;
    }

    public float getWidth() {
        return this.PU;
    }

    public float getZIndex() {
        return this.PP;
    }

    IBinder he() {
        return this.PS.gK().asBinder();
    }

    public GroundOverlayOptions image(BitmapDescriptor image) {
        this.PS = image;
        return this;
    }

    public boolean isVisible() {
        return this.PQ;
    }

    public GroundOverlayOptions position(LatLng location, float width) {
        boolean z = true;
        er.m717a(this.PW == null, "Position has already been set using positionFromBounds");
        er.m720b(location != null, (Object) "Location must be specified");
        if (width < 0.0f) {
            z = false;
        }
        er.m720b(z, (Object) "Width must be non-negative");
        return m2173a(location, width, NO_DIMENSION);
    }

    public GroundOverlayOptions position(LatLng location, float width, float height) {
        boolean z = true;
        er.m717a(this.PW == null, "Position has already been set using positionFromBounds");
        er.m720b(location != null, (Object) "Location must be specified");
        er.m720b(width >= 0.0f, (Object) "Width must be non-negative");
        if (height < 0.0f) {
            z = false;
        }
        er.m720b(z, (Object) "Height must be non-negative");
        return m2173a(location, width, height);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds bounds) {
        er.m717a(this.PT == null, "Position has already been set using position: " + this.PT);
        this.PW = bounds;
        return this;
    }

    public GroundOverlayOptions transparency(float transparency) {
        boolean z = transparency >= 0.0f && transparency <= 1.0f;
        er.m720b(z, (Object) "Transparency must be in the range [0..1]");
        this.PX = transparency;
        return this;
    }

    public GroundOverlayOptions visible(boolean visible) {
        this.PQ = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0329r.hc()) {
            C0332c.m1155a(this, out, flags);
        } else {
            GroundOverlayOptionsCreator.m1143a(this, out, flags);
        }
    }

    public GroundOverlayOptions zIndex(float zIndex) {
        this.PP = zIndex;
        return this;
    }
}
