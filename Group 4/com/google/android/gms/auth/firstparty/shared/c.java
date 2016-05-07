/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.firstparty.shared.FACLData;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.auth.firstparty.shared.b;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;
import java.util.List;

public class c
implements Parcelable.Creator {
    static void a(ScopeDetail scopeDetail, Parcel parcel, int n2) {
        int n3 = com.google.android.gms.common.internal.safeparcel.c.a(parcel);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1, scopeDetail.a);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, scopeDetail.b, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, scopeDetail.c, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 4, scopeDetail.d, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 5, scopeDetail.e, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 6, scopeDetail.f, false);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, 7, scopeDetail.g, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 8, scopeDetail.h, n2, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, n3);
    }

    public ScopeDetail a(Parcel parcel) {
        FACLData fACLData = null;
        int n2 = a.b(parcel);
        int n3 = 0;
        ArrayList arrayList = new ArrayList();
        String string = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        block10 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new ScopeDetail(n3, string5, string4, string3, string2, string, arrayList, fACLData);
                throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block10;
                }
                case 1: {
                    n3 = a.e(parcel, n4);
                    continue block10;
                }
                case 2: {
                    string5 = a.l(parcel, n4);
                    continue block10;
                }
                case 3: {
                    string4 = a.l(parcel, n4);
                    continue block10;
                }
                case 4: {
                    string3 = a.l(parcel, n4);
                    continue block10;
                }
                case 5: {
                    string2 = a.l(parcel, n4);
                    continue block10;
                }
                case 6: {
                    string = a.l(parcel, n4);
                    continue block10;
                }
                case 7: {
                    arrayList = a.r(parcel, n4);
                    continue block10;
                }
                case 8: 
            }
            fACLData = (FACLData)a.a(parcel, n4, FACLData.CREATOR);
        } while (true);
    }

    public ScopeDetail[] a(int n2) {
        return new ScopeDetail[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

