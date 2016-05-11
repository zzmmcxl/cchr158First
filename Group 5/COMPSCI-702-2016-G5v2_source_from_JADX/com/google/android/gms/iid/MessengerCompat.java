package com.google.android.gms.iid;

import android.annotation.TargetApi;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public class MessengerCompat implements Parcelable {
    public static final Creator<MessengerCompat> CREATOR;
    Messenger zzaNd;
    zzb zzaNe;

    /* renamed from: com.google.android.gms.iid.MessengerCompat.1 */
    static class C03761 implements Creator<MessengerCompat> {
        C03761() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzeO(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return zzhm(i);
        }

        public MessengerCompat zzeO(Parcel parcel) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            return readStrongBinder != null ? new MessengerCompat(readStrongBinder) : null;
        }

        public MessengerCompat[] zzhm(int i) {
            return new MessengerCompat[i];
        }
    }

    private final class zza extends com.google.android.gms.iid.zzb.zza {
        Handler handler;
        final /* synthetic */ MessengerCompat zzaNf;

        zza(MessengerCompat messengerCompat, Handler handler) {
            this.zzaNf = messengerCompat;
            this.handler = handler;
        }

        public void send(Message msg) throws RemoteException {
            msg.arg2 = Binder.getCallingUid();
            this.handler.dispatchMessage(msg);
        }
    }

    static {
        CREATOR = new C03761();
    }

    public MessengerCompat(Handler handler) {
        if (VERSION.SDK_INT >= 21) {
            this.zzaNd = new Messenger(handler);
        } else {
            this.zzaNe = new zza(this, handler);
        }
    }

    public MessengerCompat(IBinder target) {
        if (VERSION.SDK_INT >= 21) {
            this.zzaNd = new Messenger(target);
        } else {
            this.zzaNe = com.google.android.gms.iid.zzb.zza.zzcd(target);
        }
    }

    public static int zzc(Message message) {
        return VERSION.SDK_INT >= 21 ? zzd(message) : message.arg2;
    }

    @TargetApi(21)
    private static int zzd(Message message) {
        return message.sendingUid;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object otherObj) {
        boolean z = false;
        if (otherObj != null) {
            try {
                z = getBinder().equals(((MessengerCompat) otherObj).getBinder());
            } catch (ClassCastException e) {
            }
        }
        return z;
    }

    public IBinder getBinder() {
        return this.zzaNd != null ? this.zzaNd.getBinder() : this.zzaNe.asBinder();
    }

    public int hashCode() {
        return getBinder().hashCode();
    }

    public void send(Message message) throws RemoteException {
        if (this.zzaNd != null) {
            this.zzaNd.send(message);
        } else {
            this.zzaNe.send(message);
        }
    }

    public void writeToParcel(Parcel out, int flags) {
        if (this.zzaNd != null) {
            out.writeStrongBinder(this.zzaNd.getBinder());
        } else {
            out.writeStrongBinder(this.zzaNe.asBinder());
        }
    }
}
