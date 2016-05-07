/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.proxy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.proxy.ProxyGrpcRequest;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
implements Parcelable.Creator {
    static void a(ProxyGrpcRequest proxyGrpcRequest, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, proxyGrpcRequest.b, false);
        c.a(parcel, 1000, proxyGrpcRequest.a);
        c.a(parcel, 2, proxyGrpcRequest.c);
        c.a(parcel, 3, proxyGrpcRequest.d);
        c.a(parcel, 4, proxyGrpcRequest.e, false);
        c.a(parcel, 5, proxyGrpcRequest.f, false);
        c.a(parcel, n3);
    }

    public ProxyGrpcRequest a(Parcel parcel) {
        int n2 = 0;
        String string = null;
        int n3 = a.b(parcel);
        long l2 = 0;
        byte[] arrby = null;
        String string2 = null;
        int n4 = 0;
        block8 : do {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new ProxyGrpcRequest(n4, string2, n2, l2, arrby, string);
                throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + n3, parcel);
            }
            int n5 = a.a(parcel);
            switch (a.a(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block8;
                }
                case 1: {
                    string2 = a.l(parcel, n5);
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
            string = a.l(parcel, n5);
        } while (true);
    }

    public ProxyGrpcRequest[] a(int n2) {
        return new ProxyGrpcRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

