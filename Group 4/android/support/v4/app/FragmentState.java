/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.ag;
import android.support.v4.app.aj;
import android.support.v4.app.as;
import android.support.v4.app.x;
import android.util.Log;

final class FragmentState
implements Parcelable {
    public static final Parcelable.Creator CREATOR = new as();
    final String a;
    final int b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    Bundle j;
    x k;

    public FragmentState(Parcel parcel) {
        boolean bl2 = true;
        this.a = parcel.readString();
        this.b = parcel.readInt();
        boolean bl3 = parcel.readInt() != 0 ? bl2 : false;
        this.c = bl3;
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        boolean bl4 = parcel.readInt() != 0 ? bl2 : false;
        this.g = bl4;
        if (parcel.readInt() == 0) {
            bl2 = false;
        }
        this.h = bl2;
        this.i = parcel.readBundle();
        this.j = parcel.readBundle();
    }

    public FragmentState(x x2) {
        this.a = x2.getClass().getName();
        this.b = x2.p;
        this.c = x2.x;
        this.d = x2.F;
        this.e = x2.G;
        this.f = x2.H;
        this.g = x2.K;
        this.h = x2.J;
        this.i = x2.r;
    }

    public x a(ag ag2, x x2) {
        if (this.k != null) {
            return this.k;
        }
        Context context = ag2.g();
        if (this.i != null) {
            this.i.setClassLoader(context.getClassLoader());
        }
        this.k = x.a(context, this.a, this.i);
        if (this.j != null) {
            this.j.setClassLoader(context.getClassLoader());
            this.k.n = this.j;
        }
        this.k.a(this.b, x2);
        this.k.x = this.c;
        this.k.z = true;
        this.k.F = this.d;
        this.k.G = this.e;
        this.k.H = this.f;
        this.k.K = this.g;
        this.k.J = this.h;
        this.k.B = ag2.d;
        if (!aj.a) return this.k;
        Log.v((String)"FragmentManager", (String)("Instantiated fragment " + this.k));
        return this.k;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        int n3 = 1;
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        int n4 = this.c ? n3 : 0;
        parcel.writeInt(n4);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        int n5 = this.g ? n3 : 0;
        parcel.writeInt(n5);
        if (!this.h) {
            n3 = 0;
        }
        parcel.writeInt(n3);
        parcel.writeBundle(this.i);
        parcel.writeBundle(this.j);
    }
}

