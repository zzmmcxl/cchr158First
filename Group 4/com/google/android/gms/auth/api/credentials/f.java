/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.IdToken;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;
import java.util.List;

public class f
implements Parcelable.Creator {
    static void a(Credential credential, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, credential.a(), false);
        c.a(parcel, 1000, credential.a);
        c.a(parcel, 2, credential.b(), false);
        c.a(parcel, 3, (Parcelable)credential.c(), n2, false);
        c.c(parcel, 4, credential.d(), false);
        c.a(parcel, 5, credential.e(), false);
        c.a(parcel, 6, credential.g(), false);
        c.a(parcel, 7, credential.f(), false);
        c.a(parcel, 8, credential.h(), false);
        c.a(parcel, n3);
    }

    public Credential a(Parcel parcel) {
        String string = null;
        int n2 = a.b(parcel);
        int n3 = 0;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        ArrayList arrayList = null;
        Uri uri = null;
        String string5 = null;
        String string6 = null;
        block11 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new Credential(n3, string6, string5, uri, arrayList, string4, string3, string2, string);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block11;
                }
                case 1: {
                    string6 = a.l(parcel, n4);
                    continue block11;
                }
                case 1000: {
                    n3 = a.e(parcel, n4);
                    continue block11;
                }
                case 2: {
                    string5 = a.l(parcel, n4);
                    continue block11;
                }
                case 3: {
                    uri = (Uri)a.a(parcel, n4, Uri.CREATOR);
                    continue block11;
                }
                case 4: {
                    arrayList = a.c(parcel, n4, IdToken.CREATOR);
                    continue block11;
                }
                case 5: {
                    string4 = a.l(parcel, n4);
                    continue block11;
                }
                case 6: {
                    string3 = a.l(parcel, n4);
                    continue block11;
                }
                case 7: {
                    string2 = a.l(parcel, n4);
                    continue block11;
                }
                case 8: 
            }
            string = a.l(parcel, n4);
        } while (true);
    }

    public Credential[] a(int n2) {
        return new Credential[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

