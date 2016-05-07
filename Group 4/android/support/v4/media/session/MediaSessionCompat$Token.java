/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.media.session;

import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.a;

public final class MediaSessionCompat$Token
implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    private final Object a;

    MediaSessionCompat$Token(Object object) {
        this.a = object;
    }

    public Object a() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        if (Build.VERSION.SDK_INT >= 21) {
            parcel.writeParcelable((Parcelable)this.a, n2);
            return;
        }
        parcel.writeStrongBinder((IBinder)this.a);
    }
}

