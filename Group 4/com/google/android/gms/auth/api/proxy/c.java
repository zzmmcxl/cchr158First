/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
implements Parcelable.Creator {
    static void a(ProxyRequest proxyRequest, Parcel parcel, int n2) {
        int n3 = com.google.android.gms.common.internal.safeparcel.c.a(parcel);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1, proxyRequest.k, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1000, proxyRequest.j);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, proxyRequest.l);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, proxyRequest.m);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 4, proxyRequest.n, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 5, proxyRequest.o, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, n3);
    }

    public ProxyRequest a(Parcel parcel) {
        int n2 = 0;
        Bundle bundle = null;
        int n3 = a.b(parcel);
        long l2 = 0;
        byte[] arrby = null;
        String string = null;
        int n4 = 0;
        block8 : do {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new ProxyRequest(n4, string, n2, l2, arrby, bundle);
                throw new b("Overread allowed size end=" + n3, parcel);
            }
            int n5 = a.a(parcel);
            switch (a.a(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block8;
                }
                case 1: {
                    string = a.l(parcel, n5);
                    continue block8;
                }
                case 1000: {
                    n4 = a.e(parcel, n5);
                    continue block8;
                }
                case 2: {
                    n2 = a.e(parcel, n5);
                    continue block8;
                }
                case 3: {
                    l2 = a.g(parcel, n5);
                    continue block8;
                }
                case 4: {
                    arrby = a.o(parcel, n5);
                    continue block8;
                }
                case 5: 
            }
            bundle = a.n(parcel, n5);
        } while (true);
    }

    public ProxyRequest[] a(int n2) {
        return new ProxyRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

