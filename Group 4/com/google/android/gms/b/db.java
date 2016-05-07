/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.b.cz;
import com.google.android.gms.b.dc;
import com.google.android.gms.b.dd;

class db
implements cz {
    private IBinder a;

    db(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public dc a(String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            parcel.writeString(string);
            this.a.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            dc dc2 = dd.a(parcel2.readStrongBinder());
            return dc2;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }

    @Override
    public boolean b(String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            parcel.writeString(string);
            this.a.transact(2, parcel, parcel2, 0);
            parcel2.readException();
            int n2 = parcel2.readInt();
            boolean bl2 = false;
            if (n2 == 0) return bl2;
            bl2 = true;
            return bl2;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }
}

