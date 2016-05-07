/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.ArrayList;
import java.util.List;

public class j
implements Parcelable.Creator {
    static void a(WakeLockEvent wakeLockEvent, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, wakeLockEvent.a);
        c.a(parcel, 2, wakeLockEvent.a());
        c.a(parcel, 4, wakeLockEvent.c(), false);
        c.a(parcel, 5, wakeLockEvent.e());
        c.b(parcel, 6, wakeLockEvent.f(), false);
        c.a(parcel, 8, wakeLockEvent.h());
        c.a(parcel, 10, wakeLockEvent.d(), false);
        c.a(parcel, 11, wakeLockEvent.b());
        c.a(parcel, 12, wakeLockEvent.g(), false);
        c.a(parcel, 13, wakeLockEvent.k(), false);
        c.a(parcel, 14, wakeLockEvent.j());
        c.a(parcel, 15, wakeLockEvent.m());
        c.a(parcel, 16, wakeLockEvent.n());
        c.a(parcel, n3);
    }

    public WakeLockEvent a(Parcel parcel) {
        int n2 = a.b(parcel);
        int n3 = 0;
        long l2 = 0;
        int n4 = 0;
        String string = null;
        int n5 = 0;
        ArrayList arrayList = null;
        String string2 = null;
        long l3 = 0;
        int n6 = 0;
        String string3 = null;
        String string4 = null;
        float f2 = 0.0f;
        long l4 = 0;
        block15 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new WakeLockEvent(n3, l2, n4, string, n5, arrayList, string2, l3, n6, string3, string4, f2, l4);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n7 = a.a(parcel);
            switch (a.a(n7)) {
                default: {
                    a.b(parcel, n7);
                    continue block15;
                }
                case 1: {
                    n3 = a.e(parcel, n7);
                    continue block15;
                }
                case 2: {
                    l2 = a.g(parcel, n7);
                    continue block15;
                }
                case 4: {
                    string = a.l(parcel, n7);
                    continue block15;
                }
                case 5: {
                    n5 = a.e(parcel, n7);
                    continue block15;
                }
                case 6: {
                    arrayList = a.r(parcel, n7);
                    continue block15;
                }
                case 8: {
                    l3 = a.g(parcel, n7);
                    continue block15;
                }
                case 10: {
                    string3 = a.l(parcel, n7);
                    continue block15;
                }
                case 11: {
                    n4 = a.e(parcel, n7);
                    continue block15;
                }
                case 12: {
                    string2 = a.l(parcel, n7);
                    continue block15;
                }
                case 13: {
                    string4 = a.l(parcel, n7);
                    continue block15;
                }
                case 14: {
                    n6 = a.e(parcel, n7);
                    continue block15;
                }
                case 15: {
                    f2 = a.i(parcel, n7);
                    continue block15;
                }
                case 16: 
            }
            l4 = a.g(parcel, n7);
        } while (true);
    }

    public WakeLockEvent[] a(int n2) {
        return new WakeLockEvent[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

