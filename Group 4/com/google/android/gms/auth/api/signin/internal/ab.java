/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class ab
implements Parcelable.Creator {
    static void a(SignInConfiguration signInConfiguration, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, signInConfiguration.a);
        c.a(parcel, 2, signInConfiguration.a(), false);
        c.a(parcel, 3, signInConfiguration.b(), false);
        c.a(parcel, 4, signInConfiguration.c(), n2, false);
        c.a(parcel, 5, signInConfiguration.d(), n2, false);
        c.a(parcel, 7, signInConfiguration.e(), false);
        c.a(parcel, n3);
    }

    public SignInConfiguration a(Parcel parcel) {
        String string = null;
        int n2 = a.b(parcel);
        int n3 = 0;
        GoogleSignInOptions googleSignInOptions = null;
        EmailSignInOptions emailSignInOptions = null;
        String string2 = null;
        String string3 = null;
        block8 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new SignInConfiguration(n3, string3, string2, emailSignInOptions, googleSignInOptions, string);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block8;
                }
                case 1: {
                    n3 = a.e(parcel, n4);
                    continue block8;
                }
                case 2: {
                    string3 = a.l(parcel, n4);
                    continue block8;
                }
                case 3: {
                    string2 = a.l(parcel, n4);
                    continue block8;
                }
                case 4: {
                    emailSignInOptions = (EmailSignInOptions)a.a(parcel, n4, EmailSignInOptions.CREATOR);
                    continue block8;
                }
                case 5: {
                    googleSignInOptions = (GoogleSignInOptions)a.a(parcel, n4, GoogleSignInOptions.CREATOR);
                    continue block8;
                }
                case 7: 
            }
            string = a.l(parcel, n4);
        } while (true);
    }

    public SignInConfiguration[] a(int n2) {
        return new SignInConfiguration[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

