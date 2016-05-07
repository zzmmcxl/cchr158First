/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.measurement.internal.AppMetadata;

public class ah
implements Parcelable.Creator {
    static void a(AppMetadata appMetadata, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, appMetadata.a);
        c.a(parcel, 2, appMetadata.b, false);
        c.a(parcel, 3, appMetadata.c, false);
        c.a(parcel, 4, appMetadata.d, false);
        c.a(parcel, 5, appMetadata.e, false);
        c.a(parcel, 6, appMetadata.f);
        c.a(parcel, 7, appMetadata.g);
        c.a(parcel, 8, appMetadata.h, false);
        c.a(parcel, 9, appMetadata.i);
        c.a(parcel, 10, appMetadata.j);
        c.a(parcel, n3);
    }

    public AppMetadata a(Parcel parcel) {
        int n2 = a.b(parcel);
        int n3 = 0;
        String string = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        long l2 = 0;
        long l3 = 0;
        String string5 = null;
        boolean bl2 = false;
        boolean bl3 = false;
        block12 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new AppMetadata(n3, string, string2, string3, string4, l2, l3, string5, bl2, bl3);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block12;
                }
                case 1: {
                    n3 = a.e(parcel, n4);
                    continue block12;
                }
                case 2: {
                    string = a.l(parcel, n4);
                    continue block12;
                }
                case 3: {
                    string2 = a.l(parcel, n4);
                    continue block12;
                }
                case 4: {
                    string3 = a.l(parcel, n4);
                    continue block12;
                }
                case 5: {
                    string4 = a.l(parcel, n4);
                    continue block12;
                }
                case 6: {
                    l2 = a.g(parcel, n4);
                    continue block12;
                }
                case 7: {
                    l3 = a.g(parcel, n4);
                    continue block12;
                }
                case 8: {
                    string5 = a.l(parcel, n4);
                    continue block12;
                }
                case 9: {
                    bl2 = a.c(parcel, n4);
                    continue block12;
                }
                case 10: 
            }
            bl3 = a.c(parcel, n4);
        } while (true);
    }

    public AppMetadata[] a(int n2) {
        return new AppMetadata[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

