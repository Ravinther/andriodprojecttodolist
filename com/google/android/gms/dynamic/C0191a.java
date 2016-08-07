package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.google.android.gms.dynamic.a */
public abstract class C0191a<T extends LifecycleDelegate> {
    private T Fp;
    private Bundle Fq;
    private LinkedList<C0190a> Fr;
    private final C0193d<T> Fs;

    /* renamed from: com.google.android.gms.dynamic.a.5 */
    static class C01895 implements OnClickListener {
        final /* synthetic */ int FA;
        final /* synthetic */ Context os;

        C01895(Context context, int i) {
            this.os = context;
            this.FA = i;
        }

        public void onClick(View v) {
            this.os.startActivity(GooglePlayServicesUtil.m121a(this.os, this.FA, -1));
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.a */
    private interface C0190a {
        void m348b(LifecycleDelegate lifecycleDelegate);

        int getState();
    }

    /* renamed from: com.google.android.gms.dynamic.a.1 */
    class C05511 implements C0193d<T> {
        final /* synthetic */ C0191a Ft;

        C05511(C0191a c0191a) {
            this.Ft = c0191a;
        }

        public void m1636a(T t) {
            this.Ft.Fp = t;
            Iterator it = this.Ft.Fr.iterator();
            while (it.hasNext()) {
                ((C0190a) it.next()).m348b(this.Ft.Fp);
            }
            this.Ft.Fr.clear();
            this.Ft.Fq = null;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.2 */
    class C05522 implements C0190a {
        final /* synthetic */ C0191a Ft;
        final /* synthetic */ Activity Fu;
        final /* synthetic */ Bundle Fv;
        final /* synthetic */ Bundle Fw;

        C05522(C0191a c0191a, Activity activity, Bundle bundle, Bundle bundle2) {
            this.Ft = c0191a;
            this.Fu = activity;
            this.Fv = bundle;
            this.Fw = bundle2;
        }

        public void m1637b(LifecycleDelegate lifecycleDelegate) {
            this.Ft.Fp.onInflate(this.Fu, this.Fv, this.Fw);
        }

        public int getState() {
            return 0;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.3 */
    class C05533 implements C0190a {
        final /* synthetic */ C0191a Ft;
        final /* synthetic */ Bundle Fw;

        C05533(C0191a c0191a, Bundle bundle) {
            this.Ft = c0191a;
            this.Fw = bundle;
        }

        public void m1638b(LifecycleDelegate lifecycleDelegate) {
            this.Ft.Fp.onCreate(this.Fw);
        }

        public int getState() {
            return 1;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.4 */
    class C05544 implements C0190a {
        final /* synthetic */ C0191a Ft;
        final /* synthetic */ Bundle Fw;
        final /* synthetic */ FrameLayout Fx;
        final /* synthetic */ LayoutInflater Fy;
        final /* synthetic */ ViewGroup Fz;

        C05544(C0191a c0191a, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.Ft = c0191a;
            this.Fx = frameLayout;
            this.Fy = layoutInflater;
            this.Fz = viewGroup;
            this.Fw = bundle;
        }

        public void m1639b(LifecycleDelegate lifecycleDelegate) {
            this.Fx.removeAllViews();
            this.Fx.addView(this.Ft.Fp.onCreateView(this.Fy, this.Fz, this.Fw));
        }

        public int getState() {
            return 2;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.6 */
    class C05556 implements C0190a {
        final /* synthetic */ C0191a Ft;

        C05556(C0191a c0191a) {
            this.Ft = c0191a;
        }

        public void m1640b(LifecycleDelegate lifecycleDelegate) {
            this.Ft.Fp.onResume();
        }

        public int getState() {
            return 5;
        }
    }

    public C0191a() {
        this.Fs = new C05511(this);
    }

    private void m352a(Bundle bundle, C0190a c0190a) {
        if (this.Fp != null) {
            c0190a.m348b(this.Fp);
            return;
        }
        if (this.Fr == null) {
            this.Fr = new LinkedList();
        }
        this.Fr.add(c0190a);
        if (bundle != null) {
            if (this.Fq == null) {
                this.Fq = (Bundle) bundle.clone();
            } else {
                this.Fq.putAll(bundle);
            }
        }
        m356a(this.Fs);
    }

    private void aO(int i) {
        while (!this.Fr.isEmpty() && ((C0190a) this.Fr.getLast()).getState() >= i) {
            this.Fr.removeLast();
        }
    }

    public static void m354b(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        CharSequence b = GooglePlayServicesUtil.m126b(context, isGooglePlayServicesAvailable, -1);
        CharSequence b2 = GooglePlayServicesUtil.m125b(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(b);
        linearLayout.addView(textView);
        if (b2 != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(b2);
            linearLayout.addView(button);
            button.setOnClickListener(new C01895(context, isGooglePlayServicesAvailable));
        }
    }

    protected void m355a(FrameLayout frameLayout) {
        C0191a.m354b(frameLayout);
    }

    protected abstract void m356a(C0193d<T> c0193d);

    public T fj() {
        return this.Fp;
    }

    public void onCreate(Bundle savedInstanceState) {
        m352a(savedInstanceState, new C05533(this, savedInstanceState));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        m352a(savedInstanceState, new C05544(this, frameLayout, inflater, container, savedInstanceState));
        if (this.Fp == null) {
            m355a(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.Fp != null) {
            this.Fp.onDestroy();
        } else {
            aO(1);
        }
    }

    public void onDestroyView() {
        if (this.Fp != null) {
            this.Fp.onDestroyView();
        } else {
            aO(2);
        }
    }

    public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
        m352a(savedInstanceState, new C05522(this, activity, attrs, savedInstanceState));
    }

    public void onLowMemory() {
        if (this.Fp != null) {
            this.Fp.onLowMemory();
        }
    }

    public void onPause() {
        if (this.Fp != null) {
            this.Fp.onPause();
        } else {
            aO(5);
        }
    }

    public void onResume() {
        m352a(null, new C05556(this));
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.Fp != null) {
            this.Fp.onSaveInstanceState(outState);
        } else if (this.Fq != null) {
            outState.putAll(this.Fq);
        }
    }
}
