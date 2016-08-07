package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.er;

/* renamed from: com.google.android.gms.dynamic.e */
public abstract class C0195e<T> {
    private final String FC;
    private T FD;

    /* renamed from: com.google.android.gms.dynamic.e.a */
    public static class C0194a extends Exception {
        public C0194a(String str) {
            super(str);
        }

        public C0194a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected C0195e(String str) {
        this.FC = str;
    }

    protected abstract T m358d(IBinder iBinder);

    protected final T m359z(Context context) throws C0194a {
        if (this.FD == null) {
            er.m721f(context);
            Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
            if (remoteContext == null) {
                throw new C0194a("Could not get remote context.");
            }
            try {
                this.FD = m358d((IBinder) remoteContext.getClassLoader().loadClass(this.FC).newInstance());
            } catch (ClassNotFoundException e) {
                throw new C0194a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new C0194a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new C0194a("Could not access creator.");
            }
        }
        return this.FD;
    }
}
