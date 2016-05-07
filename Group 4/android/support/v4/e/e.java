/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.e;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.e.f;

class e
implements Parcelable.Creator {
    final f a;

    public e(f f2) {
        this.a = f2;
    }

    public Object createFromParcel(Parcel parcel) {
        return this.a.b(parcel, null);
    }

    public Object[] newArray(int n2) {
        return this.a.b(n2);
    }
}

