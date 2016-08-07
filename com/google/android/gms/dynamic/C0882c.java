package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.C0192b.C0557a;
import java.lang.reflect.Field;

/* renamed from: com.google.android.gms.dynamic.c */
public final class C0882c<T> extends C0557a {
    private final T FB;

    private C0882c(T t) {
        this.FB = t;
    }

    public static <T> T m2445b(C0192b c0192b) {
        if (c0192b instanceof C0882c) {
            return ((C0882c) c0192b).FB;
        }
        IBinder asBinder = c0192b.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
            } catch (Throwable e22) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e22);
            }
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }

    public static <T> C0192b m2446h(T t) {
        return new C0882c(t);
    }
}
