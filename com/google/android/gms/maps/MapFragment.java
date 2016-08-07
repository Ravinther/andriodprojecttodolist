package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.C0191a;
import com.google.android.gms.dynamic.C0193d;
import com.google.android.gms.dynamic.C0882c;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.er;
import com.google.android.gms.maps.internal.C0327p;
import com.google.android.gms.maps.internal.C0328q;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapFragment extends Fragment {
    private final C0679b Pm;
    private GoogleMap Pn;

    /* renamed from: com.google.android.gms.maps.MapFragment.a */
    static class C0678a implements LifecycleDelegate {
        private final Fragment Po;
        private final IMapFragmentDelegate Pp;

        public C0678a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.Pp = (IMapFragmentDelegate) er.m721f(iMapFragmentDelegate);
            this.Po = (Fragment) er.m721f(fragment);
        }

        public IMapFragmentDelegate gV() {
            return this.Pp;
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.Po.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                C0327p.m1134a(savedInstanceState, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.Pp.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C0882c.m2445b(this.Pp.onCreateView(C0882c.m2446h(inflater), C0882c.m2446h(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.Pp.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.Pp.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.Pp.onInflate(C0882c.m2446h(activity), (GoogleMapOptions) attrs.getParcelable("MapOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.Pp.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.Pp.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.Pp.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.Pp.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.MapFragment.b */
    static class C0679b extends C0191a<C0678a> {
        private final Fragment Po;
        protected C0193d<C0678a> Pq;
        private Activity nd;

        C0679b(Fragment fragment) {
            this.Po = fragment;
        }

        private void setActivity(Activity activity) {
            this.nd = activity;
            gW();
        }

        protected void m2147a(C0193d<C0678a> c0193d) {
            this.Pq = c0193d;
            gW();
        }

        public void gW() {
            if (this.nd != null && this.Pq != null && fj() == null) {
                try {
                    MapsInitializer.initialize(this.nd);
                    this.Pq.m357a(new C0678a(this.Po, C0328q.m1135A(this.nd).m1123f(C0882c.m2446h(this.nd))));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public MapFragment() {
        this.Pm = new C0679b(this);
    }

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(GoogleMapOptions options) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", options);
        mapFragment.setArguments(bundle);
        return mapFragment;
    }

    protected IMapFragmentDelegate gV() {
        this.Pm.gW();
        return this.Pm.fj() == null ? null : ((C0678a) this.Pm.fj()).gV();
    }

    public final GoogleMap getMap() {
        IMapFragmentDelegate gV = gV();
        if (gV == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = gV.getMap();
            if (map == null) {
                return null;
            }
            if (this.Pn == null || this.Pn.gM().asBinder() != map.asBinder()) {
                this.Pn = new GoogleMap(map);
            }
            return this.Pn;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.Pm.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.Pm.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.Pm.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.Pm.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.Pm.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.Pm.setActivity(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.Pm.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.Pm.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.Pm.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.Pm.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.Pm.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
