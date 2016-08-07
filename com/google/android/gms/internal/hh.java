package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.location.C0309a;
import com.google.android.gms.location.C0309a.C0675a;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import java.util.HashMap;

public class hh {
    private final hl<hg> Lk;
    private ContentProviderClient Ll;
    private boolean Lm;
    private HashMap<LocationListener, C0941b> Ln;
    private final Context mContext;

    /* renamed from: com.google.android.gms.internal.hh.a */
    private static class C0288a extends Handler {
        private final LocationListener Lo;

        public C0288a(LocationListener locationListener) {
            this.Lo = locationListener;
        }

        public C0288a(LocationListener locationListener, Looper looper) {
            super(looper);
            this.Lo = locationListener;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    this.Lo.onLocationChanged(new Location((Location) msg.obj));
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.hh.b */
    private static class C0941b extends C0675a {
        private Handler Lp;

        C0941b(LocationListener locationListener, Looper looper) {
            this.Lp = looper == null ? new C0288a(locationListener) : new C0288a(locationListener, looper);
        }

        public void onLocationChanged(Location location) {
            if (this.Lp == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.Lp.sendMessage(obtain);
        }

        public void release() {
            this.Lp = null;
        }
    }

    public hh(Context context, hl<hg> hlVar) {
        this.Ll = null;
        this.Lm = false;
        this.Ln = new HashMap();
        this.mContext = context;
        this.Lk = hlVar;
    }

    public Location getLastLocation() {
        this.Lk.bm();
        try {
            return ((hg) this.Lk.eb()).aF(this.mContext.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void gl() {
        if (this.Lm) {
            setMockMode(false);
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.Ln) {
                for (C0309a c0309a : this.Ln.values()) {
                    if (c0309a != null) {
                        ((hg) this.Lk.eb()).m965a(c0309a);
                    }
                }
                this.Ln.clear();
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) {
        this.Lk.bm();
        try {
            ((hg) this.Lk.eb()).m954a(callbackIntent);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(LocationListener listener) {
        this.Lk.bm();
        er.m719b((Object) listener, (Object) "Invalid null listener");
        synchronized (this.Ln) {
            C0309a c0309a = (C0941b) this.Ln.remove(listener);
            if (this.Ll != null && this.Ln.isEmpty()) {
                this.Ll.release();
                this.Ll = null;
            }
            if (c0309a != null) {
                c0309a.release();
                try {
                    ((hg) this.Lk.eb()).m965a(c0309a);
                } catch (Throwable e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) {
        this.Lk.bm();
        try {
            ((hg) this.Lk.eb()).m962a(request, callbackIntent);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) {
        this.Lk.bm();
        if (looper == null) {
            er.m719b(Looper.myLooper(), (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        }
        synchronized (this.Ln) {
            C0309a c0941b;
            C0941b c0941b2 = (C0941b) this.Ln.get(listener);
            if (c0941b2 == null) {
                c0941b = new C0941b(listener, looper);
            } else {
                Object obj = c0941b2;
            }
            this.Ln.put(listener, c0941b);
            try {
                ((hg) this.Lk.eb()).m964a(request, c0941b, this.mContext.getPackageName());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public void setMockLocation(Location mockLocation) {
        this.Lk.bm();
        try {
            ((hg) this.Lk.eb()).setMockLocation(mockLocation);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void setMockMode(boolean isMockMode) {
        this.Lk.bm();
        try {
            ((hg) this.Lk.eb()).setMockMode(isMockMode);
            this.Lm = isMockMode;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
