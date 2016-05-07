/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class e
implements Parcelable.Creator {
    static void a(EmailSignInOptions emailSignInOptions, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, emailSignInOptions.a);
        c.a(parcel, 2, (Parcelable)emailSignInOptions.a(), n2, false);
        c.a(parcel, 3, emailSignInOptions.c(), false);
        c.a(parcel, 4, (Parcelable)emailSignInOptions.b(), n2, false);
        c.a(parcel, n3);
    }

    public EmailSignInOptions a(Parcel parcel) {
        Uri uri = null;
        int n2 = a.b(parcel);
        int n3 = 0;
        String string = null;
        Uri uri2 = null;
        do {
            String string2;
            Uri uri3;
            Uri uri4;
            int n4;
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new EmailSignInOptions(n3, uri2, string, uri);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n5 = a.a(parcel);
            switch (a.a(n5)) {
                default: {
                    a.b(parcel, n5);
                    uri4 = uri;
                    string2 = string;
                    uri3 = uri2;
                    n4 = n3;
                    break;
                }
                case 1: {
                    int n6 = a.e(parcel, n5);
                    Uri uri5 = uri;
                    string2 = string;
                    uri3 = uri2;
                    n4 = n6;
                    uri4 = uri5;
                    break;
                }
                case 2: {
                    Uri uri6 = (Uri)a.a(parcel, n5, Uri.CREATOR);
                    n4 = n3;
                    String string3 = string;
                    uri3 = uri6;
                    uri4 = uri;
                    string2 = string3;
                    break;
                }
                case 3: {
                    String string4 = a.l(parcel, n5);
                    uri3 = uri2;
                    n4 = n3;
                    Uri uri7 = uri;
                    string2 = string4;
                    uri4 = uri7;
                    break;
                }
                case 4: {
                    uri4 = (Uri)a.a(parcel, n5, Uri.CREATOR);
                    string2 = string;
                    uri3 = uri2;
                    n4 = n3;
                }
            }
            n3 = n4;
            uri2 = uri3;
            string = string2;
            uri = uri4;
        } while (true);
    }

    public EmailSignInOptions[] a(int n2) {
        return new EmailSignInOptions[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

