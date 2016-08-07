package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.ContainerHolder.ContainerAvailableListener;

/* renamed from: com.google.android.gms.tagmanager.n */
class C0981n implements ContainerHolder {
    private Container TU;
    private Container TV;
    private C0403b TW;
    private C0402a TX;
    private TagManager TY;
    private Status vl;
    private boolean zk;
    private final Looper zs;

    /* renamed from: com.google.android.gms.tagmanager.n.a */
    public interface C0402a {
        void bc(String str);

        String iF();

        void iH();
    }

    /* renamed from: com.google.android.gms.tagmanager.n.b */
    private class C0403b extends Handler {
        private final ContainerAvailableListener TZ;
        final /* synthetic */ C0981n Ua;

        public C0403b(C0981n c0981n, ContainerAvailableListener containerAvailableListener, Looper looper) {
            this.Ua = c0981n;
            super(looper);
            this.TZ = containerAvailableListener;
        }

        public void bd(String str) {
            sendMessage(obtainMessage(1, str));
        }

        protected void be(String str) {
            this.TZ.onContainerAvailable(this.Ua, str);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    be((String) msg.obj);
                default:
                    bh.m1266t("Don't know how to handle this message.");
            }
        }
    }

    public C0981n(Status status) {
        this.vl = status;
        this.zs = null;
    }

    public C0981n(TagManager tagManager, Looper looper, Container container, C0402a c0402a) {
        this.TY = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.zs = looper;
        this.TU = container;
        this.TX = c0402a;
        this.vl = Status.zQ;
        tagManager.m1235a(this);
    }

    private void iG() {
        if (this.TW != null) {
            this.TW.bd(this.TV.iD());
        }
    }

    public synchronized void m2899a(Container container) {
        if (!this.zk) {
            if (container == null) {
                bh.m1266t("Unexpected null container.");
            } else {
                this.TV = container;
                iG();
            }
        }
    }

    public synchronized void ba(String str) {
        if (!this.zk) {
            this.TU.ba(str);
        }
    }

    void bc(String str) {
        if (this.zk) {
            bh.m1266t("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.TX.bc(str);
        }
    }

    public synchronized Container getContainer() {
        Container container = null;
        synchronized (this) {
            if (this.zk) {
                bh.m1266t("ContainerHolder is released.");
            } else {
                if (this.TV != null) {
                    this.TU = this.TV;
                    this.TV = null;
                }
                container = this.TU;
            }
        }
        return container;
    }

    String getContainerId() {
        if (!this.zk) {
            return this.TU.getContainerId();
        }
        bh.m1266t("getContainerId called on a released ContainerHolder.");
        return "";
    }

    public Status getStatus() {
        return this.vl;
    }

    String iF() {
        if (!this.zk) {
            return this.TX.iF();
        }
        bh.m1266t("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }

    public synchronized void refresh() {
        if (this.zk) {
            bh.m1266t("Refreshing a released ContainerHolder.");
        } else {
            this.TX.iH();
        }
    }

    public synchronized void release() {
        if (this.zk) {
            bh.m1266t("Releasing a released ContainerHolder.");
        } else {
            this.zk = true;
            this.TY.m1236b(this);
            this.TU.release();
            this.TU = null;
            this.TV = null;
            this.TX = null;
            this.TW = null;
        }
    }

    public synchronized void setContainerAvailableListener(ContainerAvailableListener listener) {
        if (this.zk) {
            bh.m1266t("ContainerHolder is released.");
        } else if (listener == null) {
            this.TW = null;
        } else {
            this.TW = new C0403b(this, listener, this.zs);
            if (this.TV != null) {
                iG();
            }
        }
    }
}
