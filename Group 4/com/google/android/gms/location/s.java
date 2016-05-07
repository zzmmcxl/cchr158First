/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.location.GestureRequest;
import java.util.ArrayList;
import java.util.List;

public class s
implements Parcelable.Creator {
    static void a(GestureRequest gestureRequest, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, gestureRequest.b(), false);
        c.a(parcel, 1000, gestureRequest.a());
        c.a(parcel, n3);
    }

    public GestureRequest a(Parcel parcel) {
        int n2 = a.b(parcel);
        int n3 = 0;
        ArrayList arrayList = null;
        block4 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new GestureRequest(n3, arrayList);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block4;
                }
                case 1: {
                    arrayList = a.q(parcel, n4);
                    continue block4;
                }
                case 1000: 
            }
            n3 = a.e(parcel, n4);
        } while (true);
    }

    public GestureRequest[] a(int n2) {
        return new GestureRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

