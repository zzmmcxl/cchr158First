/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.ValidateAccountRequest;
import com.google.android.gms.common.internal.at;
import com.google.android.gms.common.internal.aw;

class ay
implements aw {
    private IBinder a;

    ay(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public void a() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.a.transact(28, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(at at2, int n2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            this.a.transact(4, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(at at2, int n2, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            this.a.transact(3, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(at at2, int n2, String string, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(2, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(at at2, int n2, String string, IBinder iBinder, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder2 = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder2);
            parcel.writeInt(n2);
            parcel.writeString(string);
            parcel.writeStrongBinder(iBinder);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(19, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(at at2, int n2, String string, String string2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            parcel.writeString(string2);
            this.a.transact(34, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(at at2, int n2, String string, String string2, String string3, String[] arrstring) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            parcel.writeString(string2);
            parcel.writeString(string3);
            parcel.writeStringArray(arrstring);
            this.a.transact(33, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(at at2, int n2, String string, String string2, String[] arrstring) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            parcel.writeString(string2);
            parcel.writeStringArray(arrstring);
            this.a.transact(10, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(at at2, int n2, String string, String string2, String[] arrstring, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            parcel.writeString(string2);
            parcel.writeStringArray(arrstring);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(30, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(at at2, int n2, String string, String string2, String[] arrstring, String string3, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            parcel.writeString(string2);
            parcel.writeStringArray(arrstring);
            parcel.writeString(string3);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(at at2, int n2, String string, String string2, String[] arrstring, String string3, IBinder iBinder, String string4, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder2 = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder2);
            parcel.writeInt(n2);
            parcel.writeString(string);
            parcel.writeString(string2);
            parcel.writeStringArray(arrstring);
            parcel.writeString(string3);
            parcel.writeStrongBinder(iBinder);
            parcel.writeString(string4);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(9, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(at at2, int n2, String string, String[] arrstring, String string2, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            parcel.writeStringArray(arrstring);
            parcel.writeString(string2);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(20, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(at at2, GetServiceRequest getServiceRequest) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (getServiceRequest != null) {
                parcel.writeInt(1);
                getServiceRequest.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(46, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(at at2, ValidateAccountRequest validateAccountRequest) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (validateAccountRequest != null) {
                parcel.writeInt(1);
                validateAccountRequest.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(47, parcel, parcel2, 0);
            parcel2.readException();
            return;
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
    public void b(at at2, int n2, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            this.a.transact(21, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void b(at at2, int n2, String string, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(5, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void c(at at2, int n2, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            this.a.transact(22, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void c(at at2, int n2, String string, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(6, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void d(at at2, int n2, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            this.a.transact(24, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void d(at at2, int n2, String string, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(7, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void e(at at2, int n2, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            this.a.transact(26, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void e(at at2, int n2, String string, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(8, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void f(at at2, int n2, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            this.a.transact(31, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void f(at at2, int n2, String string, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(11, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void g(at at2, int n2, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            this.a.transact(32, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void g(at at2, int n2, String string, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(12, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void h(at at2, int n2, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            this.a.transact(35, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void h(at at2, int n2, String string, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(13, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void i(at at2, int n2, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            this.a.transact(36, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void i(at at2, int n2, String string, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(14, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void j(at at2, int n2, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            this.a.transact(40, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void j(at at2, int n2, String string, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(15, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void k(at at2, int n2, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            this.a.transact(42, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void k(at at2, int n2, String string, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(16, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void l(at at2, int n2, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            this.a.transact(44, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void l(at at2, int n2, String string, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(17, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void m(at at2, int n2, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            this.a.transact(45, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void m(at at2, int n2, String string, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(18, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void n(at at2, int n2, String string, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(23, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void o(at at2, int n2, String string, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(25, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void p(at at2, int n2, String string, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(27, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void q(at at2, int n2, String string, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(37, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void r(at at2, int n2, String string, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(38, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void s(at at2, int n2, String string, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(41, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void t(at at2, int n2, String string, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder iBinder = at2 != null ? at2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeInt(n2);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(43, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }
}

