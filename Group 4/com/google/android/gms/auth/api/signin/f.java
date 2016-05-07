/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;
import java.util.List;

public class f
implements Parcelable.Creator {
    static void a(GoogleSignInAccount googleSignInAccount, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, googleSignInAccount.b);
        c.a(parcel, 2, googleSignInAccount.a(), false);
        c.a(parcel, 3, googleSignInAccount.b(), false);
        c.a(parcel, 4, googleSignInAccount.c(), false);
        c.a(parcel, 5, googleSignInAccount.d(), false);
        c.a(parcel, 6, (Parcelable)googleSignInAccount.e(), n2, false);
        c.a(parcel, 7, googleSignInAccount.f(), false);
        c.a(parcel, 8, googleSignInAccount.g());
        c.a(parcel, 9, googleSignInAccount.h(), false);
        c.c(parcel, 10, googleSignInAccount.c, false);
        c.a(parcel, n3);
    }

    public GoogleSignInAccount a(Parcel parcel) {
        ArrayList arrayList = null;
        int n2 = a.b(parcel);
        int n3 = 0;
        long l2 = 0;
        String string = null;
        String string2 = null;
        Uri uri = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        block12 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new GoogleSignInAccount(n3, string6, string5, string4, string3, uri, string2, l2, string, arrayList);
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
                    string6 = a.l(parcel, n4);
                    continue block12;
                }
                case 3: {
                    string5 = a.l(parcel, n4);
                    continue block12;
                }
                case 4: {
                    string4 = a.l(parcel, n4);
                    continue block12;
                }
                case 5: {
                    string3 = a.l(parcel, n4);
                    continue block12;
                }
                case 6: {
                    uri = (Uri)a.a(parcel, n4, Uri.CREATOR);
                    continue block12;
                }
                case 7: {
                    string2 = a.l(parcel, n4);
                    continue block12;
                }
                case 8: {
                    l2 = a.g(parcel, n4);
                    continue block12;
                }
                case 9: {
                    string = a.l(parcel, n4);
                    continue block12;
                }
                case 10: 
            }
            arrayList = a.c(parcel, n4, Scope.CREATOR);
        } while (true);
    }

    public GoogleSignInAccount[] a(int n2) {
        return new GoogleSignInAccount[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

