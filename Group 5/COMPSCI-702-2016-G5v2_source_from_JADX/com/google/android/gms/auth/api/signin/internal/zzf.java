package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;

public interface zzf extends IInterface {

    public static abstract class zza extends Binder implements zzf {
        public zza() {
            attachInterface(this, "com.google.android.gms.auth.api.signin.internal.IRevocationService");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.IRevocationService");
                    zznf();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.auth.api.signin.internal.IRevocationService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zznf() throws RemoteException;
}
