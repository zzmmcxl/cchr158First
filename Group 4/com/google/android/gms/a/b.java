/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.a.c;

public abstract class b
extends Binder
implements a {
    public b() {
        this.attachInterface((IInterface)this, "com.google.android.gms.dynamic.IObjectWrapper");
    }

    public static a a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
        if (iInterface == null) return new c(iBinder);
        if (!(iInterface instanceof a)) return new c(iBinder);
        return (a)iInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: 
        }
        parcel2.writeString("com.google.android.gms.dynamic.IObjectWrapper");
        return true;
    }
}

