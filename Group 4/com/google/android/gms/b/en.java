/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;
import com.google.android.gms.b.em;
import com.google.android.gms.b.eo;

public abstract class en
extends Binder
implements em {
    public static em a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if (iInterface == null) return new eo(iBinder);
        if (!(iInterface instanceof em)) return new eo(iBinder);
        return (em)iInterface;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                return true;
            }
            case 1: 
        }
        parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        IBinder iBinder = this.a(b.a(parcel.readStrongBinder()));
        parcel2.writeNoException();
        parcel2.writeStrongBinder(iBinder);
        return true;
    }
}

