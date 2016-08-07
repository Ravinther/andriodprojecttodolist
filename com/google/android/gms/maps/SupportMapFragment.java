package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
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

public class SupportMapFragment extends Fragment {
    private GoogleMap Pn;
    private final C0683b Py;

    /* renamed from: com.google.android.gms.maps.SupportMapFragment.a */
    static class C0682a implements LifecycleDelegate {
        private final IMapFragmentDelegate Pp;
        private final Fragment Pz;

        public C0682a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.Pp = (IMapFragmentDelegate) er.m721f(iMapFragmentDelegate);
            this.Pz = (Fragment) er.m721f(fragment);
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
            Bundle arguments = this.Pz.getArguments();
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

    /* renamed from: com.google.android.gms.maps.SupportMapFragment.b */
    static class C0683b extends C0191a<C0682a> {
        protected C0193d<C0682a> Pq;
        private final Fragment Pz;
        private Activity nd;

        C0683b(Fragment fragment) {
            this.Pz = fragment;
        }

        private void setActivity(Activity activity) {
            this.nd = activity;
            gW();
        }

        protected void m2150a(C0193d<C0682a> c0193d) {
            this.Pq = c0193d;
            gW();
        }

        public void gW() {
            if (this.nd != null && this.Pq != null && fj() == null) {
                try {
                    MapsInitializer.initialize(this.nd);
                    this.Pq.m357a(new C0682a(this.Pz, C0328q.m1135A(this.nd).m1123f(C0882c.m2446h(this.nd))));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public SupportMapFragment() {
        this.Py = new C0683b(this);
    }

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(GoogleMapOptions options) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", options);
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }

    protected IMapFragmentDelegate gV() {
        this.Py.gW();
        return this.Py.fj() == null ? null : ((C0682a) this.Py.fj()).gV();
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
            savedInstanceState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.Py.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.Py.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.Py.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.Py.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.Py.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.Py.setActivity(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.Py.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.Py.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.Py.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.Py.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.Py.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
