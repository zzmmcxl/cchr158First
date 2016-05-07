/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.e;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.e.f;

class g
implements Parcelable.ClassLoaderCreator {
    private final f a;

    public g(f f2) {
        this.a = f2;
    }

    public Object createFromParcel(Parcel parcel) {
        return this.a.b(parcel, null);
    }

    public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.a.b(parcel, classLoader);
    }

    public Object[] newArray(int n2) {
        return this.a.b(n2);
    }
}

