/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class i
implements Parcelable.Creator {
    static void a(SignInAccount signInAccount, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, signInAccount.a);
        c.a(parcel, 2, signInAccount.j(), false);
        c.a(parcel, 3, signInAccount.a(), false);
        c.a(parcel, 4, signInAccount.b(), false);
        c.a(parcel, 5, signInAccount.c(), false);
        c.a(parcel, 6, (Parcelable)signInAccount.d(), n2, false);
        c.a(parcel, 7, signInAccount.f(), n2, false);
        c.a(parcel, 8, signInAccount.g(), false);
        c.a(parcel, 9, signInAccount.h(), false);
        c.a(parcel, n3);
    }

    public SignInAccount a(Parcel parcel) {
        String string = null;
        int n2 = a.b(parcel);
        int n3 = 0;
        String string2 = "";
        GoogleSignInAccount googleSignInAccount = null;
        Uri uri = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        block11 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new SignInAccount(n3, string6, string5, string4, string3, uri, googleSignInAccount, string2, string);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block11;
                }
                case 1: {
                    n3 = a.e(parcel, n4);
                    continue block11;
                }
                case 2: {
                    string6 = a.l(parcel, n4);
                    continue block11;
                }
                case 3: {
                    string5 = a.l(parcel, n4);
                    continue block11;
                }
                case 4: {
                    string4 = a.l(parcel, n4);
                    continue block11;
                }
                case 5: {
                    string3 = a.l(parcel, n4);
                    continue block11;
                }
                case 6: {
                    uri = (Uri)a.a(parcel, n4, Uri.CREATOR);
                    continue block11;
                }
                case 7: {
                    googleSignInAccount = (GoogleSignInAccount)a.a(parcel, n4, GoogleSignInAccount.CREATOR);
                    continue block11;
                }
                case 8: {
                    string2 = a.l(parcel, n4);
                    continue block11;
                }
                case 9: 
            }
            string = a.l(parcel, n4);
        } while (true);
    }

    public SignInAccount[] a(int n2) {
        return new SignInAccount[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

