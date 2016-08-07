package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.eh.C0271f;
import com.mobeta.android.dslv.DragSortController;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class ej implements Callback {
    private static final Object BQ;
    private static ej BR;
    private final HashMap<String, C0275a> BS;
    private final Handler mHandler;
    private final Context qe;

    /* renamed from: com.google.android.gms.internal.ej.a */
    final class C0275a {
        private final String BT;
        private final C0274a BU;
        private final HashSet<C0271f> BV;
        private boolean BW;
        private IBinder BX;
        private ComponentName BY;
        final /* synthetic */ ej BZ;
        private int mState;

        /* renamed from: com.google.android.gms.internal.ej.a.a */
        public class C0274a implements ServiceConnection {
            final /* synthetic */ C0275a Ca;

            public C0274a(C0275a c0275a) {
                this.Ca = c0275a;
            }

            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (this.Ca.BZ.BS) {
                    this.Ca.BX = binder;
                    this.Ca.BY = component;
                    Iterator it = this.Ca.BV.iterator();
                    while (it.hasNext()) {
                        ((C0271f) it.next()).onServiceConnected(component, binder);
                    }
                    this.Ca.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (this.Ca.BZ.BS) {
                    this.Ca.BX = null;
                    this.Ca.BY = component;
                    Iterator it = this.Ca.BV.iterator();
                    while (it.hasNext()) {
                        ((C0271f) it.next()).onServiceDisconnected(component);
                    }
                    this.Ca.mState = 2;
                }
            }
        }

        public C0275a(ej ejVar, String str) {
            this.BZ = ejVar;
            this.BT = str;
            this.BU = new C0274a(this);
            this.BV = new HashSet();
            this.mState = 0;
        }

        public void m673a(C0271f c0271f) {
            this.BV.add(c0271f);
        }

        public void m674b(C0271f c0271f) {
            this.BV.remove(c0271f);
        }

        public boolean m675c(C0271f c0271f) {
            return this.BV.contains(c0271f);
        }

        public C0274a ee() {
            return this.BU;
        }

        public String ef() {
            return this.BT;
        }

        public boolean eg() {
            return this.BV.isEmpty();
        }

        public IBinder getBinder() {
            return this.BX;
        }

        public ComponentName getComponentName() {
            return this.BY;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.BW;
        }

        public void m676w(boolean z) {
            this.BW = z;
        }
    }

    static {
        BQ = new Object();
    }

    private ej(Context context) {
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.BS = new HashMap();
        this.qe = context.getApplicationContext();
    }

    public static ej m678y(Context context) {
        synchronized (BQ) {
            if (BR == null) {
                BR = new ej(context.getApplicationContext());
            }
        }
        return BR;
    }

    public boolean m679a(String str, C0271f c0271f) {
        boolean isBound;
        synchronized (this.BS) {
            C0275a c0275a = (C0275a) this.BS.get(str);
            if (c0275a != null) {
                this.mHandler.removeMessages(0, c0275a);
                if (!c0275a.m675c(c0271f)) {
                    c0275a.m673a((C0271f) c0271f);
                    switch (c0275a.getState()) {
                        case Value.TYPE_FIELD_NUMBER /*1*/:
                            c0271f.onServiceConnected(c0275a.getComponentName(), c0275a.getBinder());
                            break;
                        case Value.STRING_FIELD_NUMBER /*2*/:
                            c0275a.m676w(this.qe.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), c0275a.ee(), 129));
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + str);
            }
            c0275a = new C0275a(this, str);
            c0275a.m673a((C0271f) c0271f);
            c0275a.m676w(this.qe.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), c0275a.ee(), 129));
            this.BS.put(str, c0275a);
            isBound = c0275a.isBound();
        }
        return isBound;
    }

    public void m680b(String str, C0271f c0271f) {
        synchronized (this.BS) {
            C0275a c0275a = (C0275a) this.BS.get(str);
            if (c0275a == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + str);
            } else if (c0275a.m675c(c0271f)) {
                c0275a.m674b(c0271f);
                if (c0275a.eg()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, c0275a), 5000);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + str);
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case DragSortController.ON_DOWN /*0*/:
                C0275a c0275a = (C0275a) msg.obj;
                synchronized (this.BS) {
                    if (c0275a.eg()) {
                        this.qe.unbindService(c0275a.ee());
                        this.BS.remove(c0275a.ef());
                    }
                    break;
                }
                return true;
            default:
                return false;
        }
    }
}
