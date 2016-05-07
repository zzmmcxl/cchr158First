/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.media.session;

import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat$Token;

final class a
implements Parcelable.Creator {
    a() {
    }

    public MediaSessionCompat$Token a(Parcel parcel) {
        IBinder iBinder;
        if (Build.VERSION.SDK_INT >= 21) {
            iBinder = parcel.readParcelable(null);
            return new MediaSessionCompat$Token((Object)iBinder);
        }
        iBinder = parcel.readStrongBinder();
        return new MediaSessionCompat$Token((Object)iBinder);
    }

    public MediaSessionCompat$Token[] a(int n2) {
        return new MediaSessionCompat$Token[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

