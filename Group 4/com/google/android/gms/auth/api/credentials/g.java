/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class g
implements Parcelable.Creator {
    static void a(CredentialPickerConfig credentialPickerConfig, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, credentialPickerConfig.a());
        c.a(parcel, 1000, credentialPickerConfig.a);
        c.a(parcel, 2, credentialPickerConfig.b());
        c.a(parcel, 3, credentialPickerConfig.c());
        c.a(parcel, n3);
    }

    public CredentialPickerConfig a(Parcel parcel) {
        boolean bl2 = false;
        int n2 = a.b(parcel);
        boolean bl3 = false;
        boolean bl4 = false;
        int n3 = 0;
        block6 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new CredentialPickerConfig(n3, bl4, bl3, bl2);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block6;
                }
                case 1: {
                    bl4 = a.c(parcel, n4);
                    continue block6;
                }
                case 1000: {
                    n3 = a.e(parcel, n4);
                    continue block6;
                }
                case 2: {
                    bl3 = a.c(parcel, n4);
                    continue block6;
                }
                case 3: 
            }
            bl2 = a.c(parcel, n4);
        } while (true);
    }

    public CredentialPickerConfig[] a(int n2) {
        return new CredentialPickerConfig[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

