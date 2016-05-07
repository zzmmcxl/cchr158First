/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.b.jx;
import com.google.android.gms.b.jy;
import com.google.android.gms.b.ka;
import com.google.android.gms.b.kc;

public abstract class kb
extends Binder
implements ka {
    public static ka a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
        if (iInterface == null) return new kc(iBinder);
        if (!(iInterface instanceof ka)) return new kc(iBinder);
        return (ka)iInterface;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.common.internal.service.ICommonService");
                return true;
            }
            case 1: 
        }
        parcel.enforceInterface("com.google.android.gms.common.internal.service.ICommonService");
        this.a(jy.a(parcel.readStrongBinder()));
        return true;
    }
}

