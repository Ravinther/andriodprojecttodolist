package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.C0192b;
import com.google.android.gms.dynamic.C0882c;
import com.google.android.gms.internal.er;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.google.android.gms.maps.internal.C0313b.C0699a;
import com.google.android.gms.maps.internal.C0315d.C0703a;
import com.google.android.gms.maps.internal.C0316e.C0705a;
import com.google.android.gms.maps.internal.C0317f.C0707a;
import com.google.android.gms.maps.internal.C0318g;
import com.google.android.gms.maps.internal.C0319h.C0711a;
import com.google.android.gms.maps.internal.C0320i.C0713a;
import com.google.android.gms.maps.internal.C0321j.C0715a;
import com.google.android.gms.maps.internal.C0322k.C0717a;
import com.google.android.gms.maps.internal.C0323l.C0719a;
import com.google.android.gms.maps.internal.C0324m.C0721a;
import com.google.android.gms.maps.internal.C0325n.C0723a;
import com.google.android.gms.maps.internal.C0326o.C0725a;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.ILocationSourceDelegate.C0689a;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.C0341c;
import com.google.android.gms.maps.model.internal.C0342d;
import com.google.android.gms.maps.model.internal.C0344f;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate OK;
    private UiSettings OL;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.10 */
    class AnonymousClass10 extends C0707a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ OnInfoWindowClickListener OY;

        AnonymousClass10(GoogleMap googleMap, OnInfoWindowClickListener onInfoWindowClickListener) {
            this.ON = googleMap;
            this.OY = onInfoWindowClickListener;
        }

        public void m2842e(C0342d c0342d) {
            this.OY.onInfoWindowClick(new Marker(c0342d));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.11 */
    class AnonymousClass11 extends C0703a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ InfoWindowAdapter OZ;

        AnonymousClass11(GoogleMap googleMap, InfoWindowAdapter infoWindowAdapter) {
            this.ON = googleMap;
            this.OZ = infoWindowAdapter;
        }

        public C0192b m2843f(C0342d c0342d) {
            return C0882c.m2446h(this.OZ.getInfoWindow(new Marker(c0342d)));
        }

        public C0192b m2844g(C0342d c0342d) {
            return C0882c.m2446h(this.OZ.getInfoContents(new Marker(c0342d)));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.12 */
    class AnonymousClass12 extends C0723a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ OnMyLocationChangeListener Pa;

        AnonymousClass12(GoogleMap googleMap, OnMyLocationChangeListener onMyLocationChangeListener) {
            this.ON = googleMap;
            this.Pa = onMyLocationChangeListener;
        }

        public void m2845d(C0192b c0192b) {
            this.Pa.onMyLocationChange((Location) C0882c.m2445b(c0192b));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.1 */
    class C09611 extends C0689a {
        final /* synthetic */ LocationSource OM;
        final /* synthetic */ GoogleMap ON;

        /* renamed from: com.google.android.gms.maps.GoogleMap.1.1 */
        class C06771 implements OnLocationChangedListener {
            final /* synthetic */ C0318g OO;
            final /* synthetic */ C09611 OP;

            C06771(C09611 c09611, C0318g c0318g) {
                this.OP = c09611;
                this.OO = c0318g;
            }

            public void onLocationChanged(Location location) {
                try {
                    this.OO.m1127g(C0882c.m2446h(location));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
        }

        C09611(GoogleMap googleMap, LocationSource locationSource) {
            this.ON = googleMap;
            this.OM = locationSource;
        }

        public void activate(C0318g listener) {
            this.OM.activate(new C06771(this, listener));
        }

        public void deactivate() {
            this.OM.deactivate();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.2 */
    class C09622 extends C0721a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ OnMyLocationButtonClickListener OQ;

        C09622(GoogleMap googleMap, OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
            this.ON = googleMap;
            this.OQ = onMyLocationButtonClickListener;
        }

        public boolean onMyLocationButtonClick() throws RemoteException {
            return this.OQ.onMyLocationButtonClick();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.3 */
    class C09633 extends C0713a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ OnMapLoadedCallback OR;

        C09633(GoogleMap googleMap, OnMapLoadedCallback onMapLoadedCallback) {
            this.ON = googleMap;
            this.OR = onMapLoadedCallback;
        }

        public void onMapLoaded() throws RemoteException {
            this.OR.onMapLoaded();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.4 */
    class C09644 extends C0725a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ SnapshotReadyCallback OS;

        C09644(GoogleMap googleMap, SnapshotReadyCallback snapshotReadyCallback) {
            this.ON = googleMap;
            this.OS = snapshotReadyCallback;
        }

        public void m2846c(C0192b c0192b) throws RemoteException {
            this.OS.onSnapshotReady((Bitmap) C0882c.m2445b(c0192b));
        }

        public void onSnapshotReady(Bitmap snapshot) throws RemoteException {
            this.OS.onSnapshotReady(snapshot);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.5 */
    class C09655 extends C0705a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ OnCameraChangeListener OT;

        C09655(GoogleMap googleMap, OnCameraChangeListener onCameraChangeListener) {
            this.ON = googleMap;
            this.OT = onCameraChangeListener;
        }

        public void onCameraChange(CameraPosition position) {
            this.OT.onCameraChange(position);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.6 */
    class C09666 extends C0711a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ OnMapClickListener OU;

        C09666(GoogleMap googleMap, OnMapClickListener onMapClickListener) {
            this.ON = googleMap;
            this.OU = onMapClickListener;
        }

        public void onMapClick(LatLng point) {
            this.OU.onMapClick(point);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.7 */
    class C09677 extends C0715a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ OnMapLongClickListener OV;

        C09677(GoogleMap googleMap, OnMapLongClickListener onMapLongClickListener) {
            this.ON = googleMap;
            this.OV = onMapLongClickListener;
        }

        public void onMapLongClick(LatLng point) {
            this.OV.onMapLongClick(point);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.8 */
    class C09688 extends C0717a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ OnMarkerClickListener OW;

        C09688(GoogleMap googleMap, OnMarkerClickListener onMarkerClickListener) {
            this.ON = googleMap;
            this.OW = onMarkerClickListener;
        }

        public boolean m2847a(C0342d c0342d) {
            return this.OW.onMarkerClick(new Marker(c0342d));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.9 */
    class C09699 extends C0719a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ OnMarkerDragListener OX;

        C09699(GoogleMap googleMap, OnMarkerDragListener onMarkerDragListener) {
            this.ON = googleMap;
            this.OX = onMarkerDragListener;
        }

        public void m2848b(C0342d c0342d) {
            this.OX.onMarkerDragStart(new Marker(c0342d));
        }

        public void m2849c(C0342d c0342d) {
            this.OX.onMarkerDragEnd(new Marker(c0342d));
        }

        public void m2850d(C0342d c0342d) {
            this.OX.onMarkerDrag(new Marker(c0342d));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.a */
    private static final class C0970a extends C0699a {
        private final CancelableCallback Pb;

        C0970a(CancelableCallback cancelableCallback) {
            this.Pb = cancelableCallback;
        }

        public void onCancel() {
            this.Pb.onCancel();
        }

        public void onFinish() {
            this.Pb.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate map) {
        this.OK = (IGoogleMapDelegate) er.m721f(map);
    }

    public final Circle addCircle(CircleOptions options) {
        try {
            return new Circle(this.OK.addCircle(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions options) {
        try {
            C0341c addGroundOverlay = this.OK.addGroundOverlay(options);
            return addGroundOverlay != null ? new GroundOverlay(addGroundOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions options) {
        try {
            C0342d addMarker = this.OK.addMarker(options);
            return addMarker != null ? new Marker(addMarker) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions options) {
        try {
            return new Polygon(this.OK.addPolygon(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions options) {
        try {
            return new Polyline(this.OK.addPolyline(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions options) {
        try {
            C0344f addTileOverlay = this.OK.addTileOverlay(options);
            return addTileOverlay != null ? new TileOverlay(addTileOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update) {
        try {
            this.OK.animateCamera(update.gK());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, int durationMs, CancelableCallback callback) {
        try {
            this.OK.animateCameraWithDurationAndCallback(update.gK(), durationMs, callback == null ? null : new C0970a(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, CancelableCallback callback) {
        try {
            this.OK.animateCameraWithCallback(update.gK(), callback == null ? null : new C0970a(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.OK.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    IGoogleMapDelegate gM() {
        return this.OK;
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.OK.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.OK.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.OK.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.OK.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.OK.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.OK.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.OL == null) {
                this.OL = new UiSettings(this.OK.getUiSettings());
            }
            return this.OL;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.OK.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.OK.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.OK.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.OK.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate update) {
        try {
            this.OK.moveCamera(update.gK());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean enabled) {
        try {
            this.OK.setBuildingsEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean enabled) {
        try {
            return this.OK.setIndoorEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter adapter) {
        if (adapter == null) {
            try {
                this.OK.setInfoWindowAdapter(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setInfoWindowAdapter(new AnonymousClass11(this, adapter));
    }

    public final void setLocationSource(LocationSource source) {
        if (source == null) {
            try {
                this.OK.setLocationSource(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setLocationSource(new C09611(this, source));
    }

    public final void setMapType(int type) {
        try {
            this.OK.setMapType(type);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean enabled) {
        try {
            this.OK.setMyLocationEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(OnCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.OK.setOnCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setOnCameraChangeListener(new C09655(this, listener));
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener listener) {
        if (listener == null) {
            try {
                this.OK.setOnInfoWindowClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setOnInfoWindowClickListener(new AnonymousClass10(this, listener));
    }

    public final void setOnMapClickListener(OnMapClickListener listener) {
        if (listener == null) {
            try {
                this.OK.setOnMapClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setOnMapClickListener(new C09666(this, listener));
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback callback) {
        if (callback == null) {
            try {
                this.OK.setOnMapLoadedCallback(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setOnMapLoadedCallback(new C09633(this, callback));
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener listener) {
        if (listener == null) {
            try {
                this.OK.setOnMapLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setOnMapLongClickListener(new C09677(this, listener));
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener listener) {
        if (listener == null) {
            try {
                this.OK.setOnMarkerClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setOnMarkerClickListener(new C09688(this, listener));
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener listener) {
        if (listener == null) {
            try {
                this.OK.setOnMarkerDragListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setOnMarkerDragListener(new C09699(this, listener));
    }

    public final void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener listener) {
        if (listener == null) {
            try {
                this.OK.setOnMyLocationButtonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setOnMyLocationButtonClickListener(new C09622(this, listener));
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener listener) {
        if (listener == null) {
            try {
                this.OK.setOnMyLocationChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setOnMyLocationChangeListener(new AnonymousClass12(this, listener));
    }

    public final void setPadding(int left, int top, int right, int bottom) {
        try {
            this.OK.setPadding(left, top, right, bottom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean enabled) {
        try {
            this.OK.setTrafficEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback callback) {
        snapshot(callback, null);
    }

    public final void snapshot(SnapshotReadyCallback callback, Bitmap bitmap) {
        try {
            this.OK.snapshot(new C09644(this, callback), (C0882c) (bitmap != null ? C0882c.m2446h(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.OK.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
