/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.common.stats.ConnectionEvent;

public class a
implements Parcelable.Creator {
    static void a(ConnectionEvent connectionEvent, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, connectionEvent.a);
        c.a(parcel, 2, connectionEvent.a());
        c.a(parcel, 4, connectionEvent.c(), false);
        c.a(parcel, 5, connectionEvent.d(), false);
        c.a(parcel, 6, connectionEvent.e(), false);
        c.a(parcel, 7, connectionEvent.f(), false);
        c.a(parcel, 8, connectionEvent.g(), false);
        c.a(parcel, 10, connectionEvent.k());
        c.a(parcel, 11, connectionEvent.j());
        c.a(parcel, 12, connectionEvent.b());
        c.a(parcel, 13, connectionEvent.h(), false);
        c.a(parcel, n3);
    }

    public ConnectionEvent a(Parcel parcel) {
        int n2 = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int n3 = 0;
        long l2 = 0;
        int n4 = 0;
        String string = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        long l3 = 0;
        long l4 = 0;
        block13 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new ConnectionEvent(n3, l2, n4, string, string2, string3, string4, string5, string6, l3, l4);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n5 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(n5)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, n5);
                    continue block13;
                }
                case 1: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, n5);
                    continue block13;
                }
                case 2: {
                    l2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, n5);
                    continue block13;
                }
                case 4: {
                    string = com.google.android.gms.common.internal.safeparcel.a.l(parcel, n5);
                    continue block13;
                }
                case 5: {
                    string2 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, n5);
                    continue block13;
                }
                case 6: {
                    string3 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, n5);
                    continue block13;
                }
                case 7: {
                    string4 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, n5);
                    continue block13;
                }
                case 8: {
                    string5 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, n5);
                    continue block13;
                }
                case 10: {
                    l3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, n5);
                    continue block13;
                }
                case 11: {
                    l4 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, n5);
                    continue block13;
                }
                case 12: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, n5);
                    continue block13;
                }
                case 13: 
            }
            string6 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, n5);
        } while (true);
    }

    public ConnectionEvent[] a(int n2) {
        return new ConnectionEvent[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

