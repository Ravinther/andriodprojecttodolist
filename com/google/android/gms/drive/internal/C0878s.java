package com.google.android.gms.drive.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.internal.C0175w.C0544a;
import com.google.android.gms.internal.er;

/* renamed from: com.google.android.gms.drive.internal.s */
public class C0878s<C extends DriveEvent> extends C0544a {
    private final Listener<C> DR;
    private final C0171a<C> DS;
    private final int Dm;

    /* renamed from: com.google.android.gms.drive.internal.s.a */
    private static class C0171a<E extends DriveEvent> extends Handler {
        private C0171a(Looper looper) {
            super(looper);
        }

        public void m296a(Listener<E> listener, E e) {
            sendMessage(obtainMessage(1, new Pair(listener, e)));
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    Pair pair = (Pair) msg.obj;
                    ((Listener) pair.first).onEvent((DriveEvent) pair.second);
                default:
                    Log.wtf("EventCallback", "Don't know how to handle this event");
            }
        }
    }

    public C0878s(Looper looper, int i, Listener<C> listener) {
        this.Dm = i;
        this.DR = listener;
        this.DS = new C0171a(null);
    }

    public void m2428a(OnEventResponse onEventResponse) throws RemoteException {
        er.m722v(this.Dm == onEventResponse.getEventType());
        switch (onEventResponse.getEventType()) {
            case Value.TYPE_FIELD_NUMBER /*1*/:
                this.DS.m296a(this.DR, onEventResponse.fa());
            case Value.STRING_FIELD_NUMBER /*2*/:
                this.DS.m296a(this.DR, onEventResponse.fb());
            default:
                Log.w("EventCallback", "Unexpected event type:" + onEventResponse.getEventType());
        }
    }
}
