/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.places.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.d;
import com.google.android.gms.location.places.a;
import com.google.android.gms.location.places.internal.PlaceImpl;

abstract class f {
    public static a c(Context context, Intent intent) {
        bf.a((Object)intent, (Object)"intent must not be null");
        bf.a((Object)context, (Object)"context must not be null");
        return (a)((Object)d.a(intent, "selected_place", PlaceImpl.CREATOR));
    }

    public static Status d(Context context, Intent intent) {
        bf.a((Object)intent, (Object)"intent must not be null");
        bf.a((Object)context, (Object)"context must not be null");
        return (Status)d.a(intent, "status", Status.CREATOR);
    }
}

