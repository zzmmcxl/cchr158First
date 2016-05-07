/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;

public class b
extends RuntimeException {
    public b(String string, Parcel parcel) {
        super(string + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
    }
}

