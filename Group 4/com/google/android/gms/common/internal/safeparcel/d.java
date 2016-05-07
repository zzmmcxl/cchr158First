/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class d {
    public static SafeParcelable a(Intent intent, String string, Parcelable.Creator creator) {
        byte[] arrby = intent.getByteArrayExtra(string);
        if (arrby != null) return d.a(arrby, creator);
        return null;
    }

    public static SafeParcelable a(byte[] arrby, Parcelable.Creator creator) {
        bf.a((Object)creator);
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(arrby, 0, arrby.length);
        parcel.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable)creator.createFromParcel(parcel);
        parcel.recycle();
        return safeParcelable;
    }
}

