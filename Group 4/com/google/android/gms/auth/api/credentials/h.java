/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class h
implements Parcelable.Creator {
    static void a(CredentialRequest credentialRequest, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, credentialRequest.a());
        c.a(parcel, 1000, credentialRequest.a);
        c.a(parcel, 2, credentialRequest.b(), false);
        c.a(parcel, 3, credentialRequest.c(), n2, false);
        c.a(parcel, 4, credentialRequest.d(), n2, false);
        c.a(parcel, n3);
    }

    public CredentialRequest a(Parcel parcel) {
        boolean bl2 = false;
        CredentialPickerConfig credentialPickerConfig = null;
        int n2 = a.b(parcel);
        CredentialPickerConfig credentialPickerConfig2 = null;
        String[] arrstring = null;
        int n3 = 0;
        block7 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new CredentialRequest(n3, bl2, arrstring, credentialPickerConfig2, credentialPickerConfig);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block7;
                }
                case 1: {
                    bl2 = a.c(parcel, n4);
                    continue block7;
                }
                case 1000: {
                    n3 = a.e(parcel, n4);
                    continue block7;
                }
                case 2: {
                    arrstring = a.p(parcel, n4);
                    continue block7;
                }
                case 3: {
                    credentialPickerConfig2 = (CredentialPickerConfig)a.a(parcel, n4, CredentialPickerConfig.CREATOR);
                    continue block7;
                }
                case 4: 
            }
            credentialPickerConfig = (CredentialPickerConfig)a.a(parcel, n4, CredentialPickerConfig.CREATOR);
        } while (true);
    }

    public CredentialRequest[] a(int n2) {
        return new CredentialRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

