/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.internal.SaveRequest;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class k
implements Parcelable.Creator {
    static void a(SaveRequest saveRequest, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, saveRequest.a(), n2, false);
        c.a(parcel, 1000, saveRequest.a);
        c.a(parcel, n3);
    }

    public SaveRequest a(Parcel parcel) {
        int n2 = a.b(parcel);
        int n3 = 0;
        Credential credential = null;
        block4 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new SaveRequest(n3, credential);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block4;
                }
                case 1: {
                    credential = (Credential)a.a(parcel, n4, Credential.CREATOR);
                    continue block4;
                }
                case 1000: 
            }
            n3 = a.e(parcel, n4);
        } while (true);
    }

    public SaveRequest[] a(int n2) {
        return new SaveRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

