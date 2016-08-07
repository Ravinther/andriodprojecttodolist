package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.C0133a;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.er;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

abstract class ca<R extends Result> implements PendingResult<R> {
    private C0375a<R> VK;
    private final Object zd;
    private final CountDownLatch zf;
    private final ArrayList<C0133a> zg;
    private ResultCallback<R> zh;
    private volatile R zi;
    private volatile boolean zj;

    /* renamed from: com.google.android.gms.tagmanager.ca.a */
    public static class C0375a<R extends Result> extends Handler {
        public C0375a() {
            this(Looper.getMainLooper());
        }

        public C0375a(Looper looper) {
            super(looper);
        }

        public void m1279a(ResultCallback<R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void m1280a(ca<R> caVar, long j) {
            sendMessageDelayed(obtainMessage(2, caVar), j);
        }

        protected void m1281b(ResultCallback<R> resultCallback, R r) {
            resultCallback.onResult(r);
        }

        public void dw() {
            removeMessages(2);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    Pair pair = (Pair) msg.obj;
                    m1281b((ResultCallback) pair.first, (Result) pair.second);
                case Value.STRING_FIELD_NUMBER /*2*/:
                    ca caVar = (ca) msg.obj;
                    caVar.m2285a(caVar.m2286d(Status.zS));
                default:
                    bh.m1266t("Don't know how to handle this message.");
            }
        }
    }

    public ca(Looper looper) {
        this.zd = new Object();
        this.zf = new CountDownLatch(1);
        this.zg = new ArrayList();
        this.VK = new C0375a(looper);
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

    public final void m2285a(R r) {
        synchronized (this.zd) {
            if (isReady()) {
                return;
            }
            er.m717a(!this.zj, "Result has already been consumed");
            this.zi = r;
            this.zf.countDown();
            Status status = this.zi.getStatus();
            if (this.zh != null) {
                this.VK.dw();
                this.VK.m1279a(this.zh, ds());
            }
            Iterator it = this.zg.iterator();
            while (it.hasNext()) {
                ((C0133a) it.next()).m138k(status);
            }
            this.zg.clear();
        }
    }

    public R await() {
        er.m717a(!this.zj, "Results has already been consumed");
        try {
            this.zf.await();
        } catch (InterruptedException e) {
            m2285a(m2286d(Status.zR));
        }
        er.m717a(isReady(), "Result is not ready.");
        return ds();
    }

    public R await(long time, TimeUnit units) {
        er.m717a(!this.zj, "Result has already been consumed.");
        try {
            if (!this.zf.await(time, units)) {
                m2285a(m2286d(Status.zS));
            }
        } catch (InterruptedException e) {
            m2285a(m2286d(Status.zR));
        }
        er.m717a(isReady(), "Result is not ready.");
        return ds();
    }

    protected abstract R m2286d(Status status);

    void dt() {
        this.zj = true;
        this.zi = null;
    }

    public boolean isReady() {
        return this.zf.getCount() == 0;
    }

    public final void setResultCallback(ResultCallback<R> callback) {
        er.m717a(!this.zj, "Result has already been consumed.");
        synchronized (this.zd) {
            if (isReady()) {
                this.VK.m1279a((ResultCallback) callback, ds());
            } else {
                this.zh = callback;
            }
        }
    }

    public final void setResultCallback(ResultCallback<R> callback, long time, TimeUnit units) {
        er.m717a(!this.zj, "Result has already been consumed.");
        synchronized (this.zd) {
            if (isReady()) {
                this.VK.m1279a((ResultCallback) callback, ds());
            } else {
                this.zh = callback;
                this.VK.m1280a(this, units.toMillis(time));
            }
        }
    }
}
