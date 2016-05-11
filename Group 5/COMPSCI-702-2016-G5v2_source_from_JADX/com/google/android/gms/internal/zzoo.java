package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.request.SubscribeRequest;
import com.google.android.gms.fitness.request.UnsubscribeRequest;

public interface zzoo extends IInterface {

    public static abstract class zza extends Binder implements zzoo {

        private static class zza implements zzoo {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(ListSubscriptionsRequest listSubscriptionsRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (listSubscriptionsRequest != null) {
                        obtain.writeInt(1);
                        listSubscriptionsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SubscribeRequest subscribeRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (subscribeRequest != null) {
                        obtain.writeInt(1);
                        subscribeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UnsubscribeRequest unsubscribeRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (unsubscribeRequest != null) {
                        obtain.writeInt(1);
                        unsubscribeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzoo zzbJ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzoo)) ? new zza(iBinder) : (zzoo) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ListSubscriptionsRequest listSubscriptionsRequest = null;
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    SubscribeRequest subscribeRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (data.readInt() != 0) {
                        subscribeRequest = (SubscribeRequest) SubscribeRequest.CREATOR.createFromParcel(data);
                    }
                    zza(subscribeRequest);
                    reply.writeNoException();
                    return true;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    UnsubscribeRequest unsubscribeRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (data.readInt() != 0) {
                        unsubscribeRequest = (UnsubscribeRequest) UnsubscribeRequest.CREATOR.createFromParcel(data);
                    }
                    zza(unsubscribeRequest);
                    reply.writeNoException();
                    return true;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (data.readInt() != 0) {
                        listSubscriptionsRequest = (ListSubscriptionsRequest) ListSubscriptionsRequest.CREATOR.createFromParcel(data);
                    }
                    zza(listSubscriptionsRequest);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(ListSubscriptionsRequest listSubscriptionsRequest) throws RemoteException;

    void zza(SubscribeRequest subscribeRequest) throws RemoteException;

    void zza(UnsubscribeRequest unsubscribeRequest) throws RemoteException;
}
