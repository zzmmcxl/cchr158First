/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.a;

import android.os.IBinder;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;
import java.lang.reflect.Field;

public final class d
extends b {
    private final Object a;

    private d(Object object) {
        this.a = object;
    }

    public static a a(Object object) {
        return new d(object);
    }

    public static Object a(a a2) {
        if (a2 instanceof d) {
            return ((d)a2).a;
        }
        IBinder iBinder = a2.asBinder();
        Field[] arrfield = iBinder.getClass().getDeclaredFields();
        if (arrfield.length != 1) throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
        Field field = arrfield[0];
        if (field.isAccessible()) throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
        field.setAccessible(true);
        try {
            return field.get((Object)iBinder);
        }
        catch (NullPointerException var6_5) {
            throw new IllegalArgumentException("Binder object is null.", var6_5);
        }
        catch (IllegalArgumentException var5_6) {
            throw new IllegalArgumentException("remoteBinder is the wrong class.", var5_6);
        }
        catch (IllegalAccessException var4_7) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", var4_7);
        }
    }
}

