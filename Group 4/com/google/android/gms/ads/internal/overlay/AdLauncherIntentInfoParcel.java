/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.ads.internal.overlay.b;
import com.google.android.gms.b.fi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@fi
public final class AdLauncherIntentInfoParcel
implements SafeParcelable {
    public static final b CREATOR = new b();
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final Intent i;

    public AdLauncherIntentInfoParcel(int n2, String string, String string2, String string3, String string4, String string5, String string6, String string7, Intent intent) {
        this.a = n2;
        this.b = string;
        this.c = string2;
        this.d = string3;
        this.e = string4;
        this.f = string5;
        this.g = string6;
        this.h = string7;
        this.i = intent;
    }

    public AdLauncherIntentInfoParcel(Intent intent) {
        this(2, null, null, null, null, null, null, null, intent);
    }

    public AdLauncherIntentInfoParcel(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
        this(2, string, string2, string3, string4, string5, string6, string7, null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        b.a(this, parcel, n2);
    }
}

