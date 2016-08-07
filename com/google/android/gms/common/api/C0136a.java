package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.api.Api.C0131a;
import com.google.android.gms.common.api.Api.C0132b;
import com.google.android.gms.common.api.C0530b.C0137a;
import com.google.android.gms.common.api.C0530b.C0139c;
import com.google.android.gms.common.api.PendingResult.C0133a;
import com.google.android.gms.internal.er;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.common.api.a */
public class C0136a {

    /* renamed from: com.google.android.gms.common.api.a.b */
    public static class C0134b<R extends Result> extends Handler {
        public C0134b() {
            this(Looper.getMainLooper());
        }

        public C0134b(Looper looper) {
            super(looper);
        }

        public void m140a(ResultCallback<R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void m141a(C0526a<R, ?> c0526a, long j) {
            sendMessageDelayed(obtainMessage(2, c0526a), j);
        }

        protected void m142b(ResultCallback<R> resultCallback, R r) {
            resultCallback.onResult(r);
        }

        public void dw() {
            removeMessages(2);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    Pair pair = (Pair) msg.obj;
                    m142b((ResultCallback) pair.first, (Result) pair.second);
                case Value.STRING_FIELD_NUMBER /*2*/:
                    C0526a c0526a = (C0526a) msg.obj;
                    c0526a.m1527a(c0526a.m1531d(Status.zS));
                default:
                    Log.wtf("GoogleApi", "Don't know how to handle this message.");
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.c */
    public interface C0135c<R> {
        void m143b(R r);
    }

    /* renamed from: com.google.android.gms.common.api.a.a */
    public static abstract class C0526a<R extends Result, A extends C0131a> implements PendingResult<R>, C0135c<R>, C0139c<A> {
        private final C0132b<A> zc;
        private final Object zd;
        private C0134b<R> ze;
        private final CountDownLatch zf;
        private final ArrayList<C0133a> zg;
        private ResultCallback<R> zh;
        private volatile R zi;
        private volatile boolean zj;
        private boolean zk;
        private boolean zl;
        private C0137a zm;

        protected C0526a() {
            this((C0132b) null);
        }

        protected C0526a(C0132b<A> c0132b) {
            this.zd = new Object();
            this.zf = new CountDownLatch(1);
            this.zg = new ArrayList();
            this.zc = c0132b;
        }

        private void m1525a(RemoteException remoteException) {
            m1527a(m1531d(new Status(8, remoteException.getLocalizedMessage(), null)));
        }

        private R ds() {
            R r;
            synchronized (this.zd) {
                er.m717a(!this.zj, "Result has already been consumed.");
                er.m717a(isReady(), "Result is not ready.");
                r = this.zi;
                dt();
            }
            return r;
        }

        private void dv() {
            if (this.zi != null && (this instanceof Releasable)) {
                try {
                    ((Releasable) this).release();
                } catch (Throwable e) {
                    Log.w("GoogleApi", "Unable to release " + this, e);
                }
            }
        }

        protected abstract void m1526a(A a) throws RemoteException;

        public final void m1527a(R r) {
            boolean z = true;
            synchronized (this.zd) {
                if (this.zl) {
                    if (r instanceof Releasable) {
                        ((Releasable) r).release();
                    }
                    return;
                }
                er.m717a(!isReady(), "Results have already been set");
                if (this.zj) {
                    z = false;
                }
                er.m717a(z, "Result has already been consumed");
                this.zi = r;
                if (this.zk) {
                    dv();
                    return;
                }
                this.zf.countDown();
                Status status = this.zi.getStatus();
                if (this.zh != null) {
                    this.ze.dw();
                    this.ze.m140a(this.zh, ds());
                }
                Iterator it = this.zg.iterator();
                while (it.hasNext()) {
                    ((C0133a) it.next()).m138k(status);
                }
                this.zg.clear();
            }
        }

        public void m1528a(C0137a c0137a) {
            this.zm = c0137a;
        }

        public final R await() {
            boolean z = false;
            er.m717a(!this.zj, "Results has already been consumed");
            if (isReady() || Looper.myLooper() != Looper.getMainLooper()) {
                z = true;
            }
            er.m717a(z, "await must not be called on the UI thread");
            try {
                this.zf.await();
            } catch (InterruptedException e) {
                synchronized (this.zd) {
                }
                m1527a(m1531d(Status.zR));
                this.zl = true;
            }
            er.m717a(isReady(), "Result is not ready.");
            return ds();
        }

        public final R await(long time, TimeUnit units) {
            boolean z = false;
            er.m717a(!this.zj, "Result has already been consumed.");
            if (isReady() || Looper.myLooper() != Looper.getMainLooper()) {
                z = true;
            }
            er.m717a(z, "await must not be called on the UI thread");
            try {
                if (!this.zf.await(time, units)) {
                    synchronized (this.zd) {
                        m1527a(m1531d(Status.zS));
                        this.zl = true;
                    }
                }
            } catch (InterruptedException e) {
                synchronized (this.zd) {
                }
                m1527a(m1531d(Status.zR));
                this.zl = true;
            }
            er.m717a(isReady(), "Result is not ready.");
            return ds();
        }

        public final void m1529b(A a) throws DeadObjectException {
            this.ze = new C0134b(a.getLooper());
            try {
                m1526a((C0131a) a);
            } catch (RemoteException e) {
                m1525a(e);
                throw e;
            } catch (RemoteException e2) {
                m1525a(e2);
            }
        }

        public /* synthetic */ void m1530b(Object obj) {
            m1527a((Result) obj);
        }

        protected abstract R m1531d(Status status);

        public final C0132b<A> dp() {
            return this.zc;
        }

        public int dr() {
            return 0;
        }

        void dt() {
            this.zj = true;
            this.zi = null;
            if (this.zm != null) {
                this.zm.m144b(this);
            }
        }

        public void du() {
            dv();
            this.zk = true;
        }

        public final boolean isReady() {
            return this.zf.getCount() == 0;
        }

        public final void setResultCallback(ResultCallback<R> callback) {
            er.m717a(!this.zj, "Result has already been consumed.");
            synchronized (this.zd) {
                if (isReady()) {
                    this.ze.m140a((ResultCallback) callback, ds());
                } else {
                    this.zh = callback;
                }
            }
        }

        public final void setResultCallback(ResultCallback<R> callback, long time, TimeUnit units) {
            er.m717a(!this.zj, "Result has already been consumed.");
            synchronized (this.zd) {
                if (isReady()) {
                    this.ze.m140a((ResultCallback) callback, ds());
                } else {
                    this.zh = callback;
                    this.ze.m141a(this, units.toMillis(time));
                }
            }
        }
    }
}
