/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class d
implements Parcelable.Creator {
    static void a(ProxyResponse proxyResponse, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, proxyResponse.b);
        c.a(parcel, 1000, proxyResponse.a);
        c.a(parcel, 2, (Parcelable)proxyResponse.c, n2, false);
        c.a(parcel, 3, proxyResponse.d);
        c.a(parcel, 4, proxyResponse.e, false);
        c.a(parcel, 5, proxyResponse.f, false);
        c.a(parcel, n3);
    }

    public ProxyResponse a(Parcel parcel) {
        byte[] arrby = null;
        int n2 = 0;
        int n3 = a.b(parcel);
        Bundle bundle = null;
        PendingIntent pendingIntent = null;
        int n4 = 0;
        int n5 = 0;
        block8 : do {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new ProxyResponse(n5, n4, pendingIntent, n2, bundle, arrby);
                throw new b("Overread allowed size end=" + n3, parcel);
            }
            int n6 = a.a(parcel);
            switch (a.a(n6)) {
                default: {
                    a.b(parcel, n6);
                    continue block8;
                }
                case 1: {
                    n4 = a.e(parcel, n6);
                    continue block8;
                }
                case 1000: {
                    n5 = a.e(parcel, n6);
                    continue block8;
                }
                case 2: {
                    pendingIntent = (PendingIntent)a.a(parcel, n6, PendingIntent.CREATOR);
                    continue block8;
                }
                case 3: {
                    n2 = a.e(parcel, n6);
                    continue block8;
                }
                case 4: {
                    bundle = a.n(parcel, n6);
                    continue block8;
                }
                case 5: 
            }
            arrby = a.o(parcel, n6);
        } while (true);
    }

    public ProxyResponse[] a(int n2) {
        return new ProxyResponse[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

