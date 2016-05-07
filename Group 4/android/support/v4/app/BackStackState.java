/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.aj;
import android.support.v4.app.n;
import android.support.v4.app.r;
import android.support.v4.app.t;
import android.support.v4.app.x;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

final class BackStackState
implements Parcelable {
    public static final Parcelable.Creator CREATOR = new t();
    final int[] a;
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList j;
    final ArrayList k;

    public BackStackState(Parcel parcel) {
        this.a = parcel.createIntArray();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
    }

    public BackStackState(n n2) {
        r r2 = n2.c;
        int n3 = 0;
        while (r2 != null) {
            if (r2.i != null) {
                n3 += r2.i.size();
            }
            r2 = r2.a;
        }
        this.a = new int[n3 + 7 * n2.e];
        if (!n2.l) {
            throw new IllegalStateException("Not on back stack");
        }
        r r3 = n2.c;
        int n4 = 0;
        do {
            if (r3 == null) {
                this.b = n2.j;
                this.c = n2.k;
                this.d = n2.n;
                this.e = n2.p;
                this.f = n2.q;
                this.g = n2.r;
                this.h = n2.s;
                this.i = n2.t;
                this.j = n2.u;
                this.k = n2.v;
                return;
            }
            int[] arrn = this.a;
            int n5 = n4 + 1;
            arrn[n4] = r3.c;
            int[] arrn2 = this.a;
            int n6 = n5 + 1;
            int n7 = r3.d != null ? r3.d.p : -1;
            arrn2[n5] = n7;
            int[] arrn3 = this.a;
            int n8 = n6 + 1;
            arrn3[n6] = r3.e;
            int[] arrn4 = this.a;
            int n9 = n8 + 1;
            arrn4[n8] = r3.f;
            int[] arrn5 = this.a;
            int n10 = n9 + 1;
            arrn5[n9] = r3.g;
            int[] arrn6 = this.a;
            int n11 = n10 + 1;
            arrn6[n10] = r3.h;
            if (r3.i != null) {
                int n12 = r3.i.size();
                int[] arrn7 = this.a;
                int n13 = n11 + 1;
                arrn7[n11] = n12;
                for (int i2 = 0; i2 < n12; ++i2) {
                    int[] arrn8 = this.a;
                    int n14 = n13 + 1;
                    arrn8[n13] = ((x)r3.i.get((int)i2)).p;
                    n13 = n14;
                }
                n4 = n13;
            } else {
                int[] arrn9 = this.a;
                n4 = n11 + 1;
                arrn9[n11] = 0;
            }
            r3 = r3.a;
        } while (true);
    }

    public n a(aj aj2) {
        n n2 = new n(aj2);
        int n3 = 0;
        int n4 = 0;
        do {
            if (n4 >= this.a.length) {
                n2.j = this.b;
                n2.k = this.c;
                n2.n = this.d;
                n2.p = this.e;
                n2.l = true;
                n2.q = this.f;
                n2.r = this.g;
                n2.s = this.h;
                n2.t = this.i;
                n2.u = this.j;
                n2.v = this.k;
                n2.a(1);
                return n2;
            }
            r r2 = new r();
            int[] arrn = this.a;
            int n5 = n4 + 1;
            r2.c = arrn[n4];
            if (aj.a) {
                Log.v((String)"FragmentManager", (String)("Instantiate " + n2 + " op #" + n3 + " base fragment #" + this.a[n5]));
            }
            int[] arrn2 = this.a;
            int n6 = n5 + 1;
            int n7 = arrn2[n5];
            r2.d = n7 >= 0 ? (x)aj2.f.get(n7) : null;
            int[] arrn3 = this.a;
            int n8 = n6 + 1;
            r2.e = arrn3[n6];
            int[] arrn4 = this.a;
            int n9 = n8 + 1;
            r2.f = arrn4[n8];
            int[] arrn5 = this.a;
            int n10 = n9 + 1;
            r2.g = arrn5[n9];
            int[] arrn6 = this.a;
            int n11 = n10 + 1;
            r2.h = arrn6[n10];
            int[] arrn7 = this.a;
            int n12 = n11 + 1;
            int n13 = arrn7[n11];
            if (n13 > 0) {
                r2.i = new ArrayList(n13);
                for (int i2 = 0; i2 < n13; ++i2) {
                    if (aj.a) {
                        Log.v((String)"FragmentManager", (String)("Instantiate " + n2 + " set remove fragment #" + this.a[n12]));
                    }
                    ArrayList arrayList = aj2.f;
                    int[] arrn8 = this.a;
                    int n14 = n12 + 1;
                    x x2 = (x)arrayList.get(arrn8[n12]);
                    r2.i.add(x2);
                    n12 = n14;
                }
            }
            n2.a(r2);
            ++n3;
            n4 = n12;
        } while (true);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeIntArray(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        TextUtils.writeToParcel((CharSequence)this.g, (Parcel)parcel, (int)0);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel((CharSequence)this.i, (Parcel)parcel, (int)0);
        parcel.writeStringList((List)this.j);
        parcel.writeStringList((List)this.k);
    }
}

