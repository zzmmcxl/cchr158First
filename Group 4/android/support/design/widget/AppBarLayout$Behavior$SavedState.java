/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.f;
import android.support.v4.e.d;
import android.view.View;

public class AppBarLayout$Behavior$SavedState
extends View.BaseSavedState {
    public static final Parcelable.Creator CREATOR = d.a(new f());
    int a;
    float b;
    boolean c;

    public AppBarLayout$Behavior$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel);
        this.a = parcel.readInt();
        this.b = parcel.readFloat();
        boolean bl2 = parcel.readByte() != 0;
        this.c = bl2;
    }

    public AppBarLayout$Behavior$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        super.writeToParcel(parcel, n2);
        parcel.writeInt(this.a);
        parcel.writeFloat(this.b);
        byte by2 = this.c ? 1 : 0;
        parcel.writeByte(by2);
    }
}

