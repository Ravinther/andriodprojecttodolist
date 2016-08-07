package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0083R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0312a;
import com.google.android.gms.maps.internal.C0329r;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
    public static final GoogleMapOptionsCreator CREATOR;
    private Boolean Pc;
    private Boolean Pd;
    private int Pe;
    private CameraPosition Pf;
    private Boolean Pg;
    private Boolean Ph;
    private Boolean Pi;
    private Boolean Pj;
    private Boolean Pk;
    private Boolean Pl;
    private final int wj;

    static {
        CREATOR = new GoogleMapOptionsCreator();
    }

    public GoogleMapOptions() {
        this.Pe = -1;
        this.wj = 1;
    }

    GoogleMapOptions(int versionCode, byte zOrderOnTop, byte useViewLifecycleInFragment, int mapType, CameraPosition camera, byte zoomControlsEnabled, byte compassEnabled, byte scrollGesturesEnabled, byte zoomGesturesEnabled, byte tiltGesturesEnabled, byte rotateGesturesEnabled) {
        this.Pe = -1;
        this.wj = versionCode;
        this.Pc = C0312a.m1118a(zOrderOnTop);
        this.Pd = C0312a.m1118a(useViewLifecycleInFragment);
        this.Pe = mapType;
        this.Pf = camera;
        this.Pg = C0312a.m1118a(zoomControlsEnabled);
        this.Ph = C0312a.m1118a(compassEnabled);
        this.Pi = C0312a.m1118a(scrollGesturesEnabled);
        this.Pj = C0312a.m1118a(zoomGesturesEnabled);
        this.Pk = C0312a.m1118a(tiltGesturesEnabled);
        this.Pl = C0312a.m1118a(rotateGesturesEnabled);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, C0083R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(0)) {
            googleMapOptions.mapType(obtainAttributes.getInt(0, -1));
        }
        if (obtainAttributes.hasValue(13)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(13, false));
        }
        if (obtainAttributes.hasValue(12)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(12, false));
        }
        if (obtainAttributes.hasValue(6)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(6, true));
        }
        if (obtainAttributes.hasValue(7)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(7, true));
        }
        if (obtainAttributes.hasValue(8)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(8, true));
        }
        if (obtainAttributes.hasValue(9)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(9, true));
        }
        if (obtainAttributes.hasValue(11)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(11, true));
        }
        if (obtainAttributes.hasValue(10)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(10, true));
        }
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attrs));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public GoogleMapOptions camera(CameraPosition camera) {
        this.Pf = camera;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean enabled) {
        this.Ph = Boolean.valueOf(enabled);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    byte gN() {
        return C0312a.m1119c(this.Pc);
    }

    byte gO() {
        return C0312a.m1119c(this.Pd);
    }

    byte gP() {
        return C0312a.m1119c(this.Pg);
    }

    byte gQ() {
        return C0312a.m1119c(this.Ph);
    }

    byte gR() {
        return C0312a.m1119c(this.Pi);
    }

    byte gS() {
        return C0312a.m1119c(this.Pj);
    }

    byte gT() {
        return C0312a.m1119c(this.Pk);
    }

    byte gU() {
        return C0312a.m1119c(this.Pl);
    }

    public CameraPosition getCamera() {
        return this.Pf;
    }

    public Boolean getCompassEnabled() {
        return this.Ph;
    }

    public int getMapType() {
        return this.Pe;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.Pl;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.Pi;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.Pk;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.Pd;
    }

    int getVersionCode() {
        return this.wj;
    }

    public Boolean getZOrderOnTop() {
        return this.Pc;
    }

    public Boolean getZoomControlsEnabled() {
        return this.Pg;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.Pj;
    }

    public GoogleMapOptions mapType(int mapType) {
        this.Pe = mapType;
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean enabled) {
        this.Pl = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean enabled) {
        this.Pi = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean enabled) {
        this.Pk = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        this.Pd = Boolean.valueOf(useViewLifecycleInFragment);
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0329r.hc()) {
            C0311a.m1117a(this, out, flags);
        } else {
            GoogleMapOptionsCreator.m1116a(this, out, flags);
        }
    }

    public GoogleMapOptions zOrderOnTop(boolean zOrderOnTop) {
        this.Pc = Boolean.valueOf(zOrderOnTop);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean enabled) {
        this.Pg = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean enabled) {
        this.Pj = Boolean.valueOf(enabled);
        return this;
    }
}
