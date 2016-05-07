/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;

public class g
implements Parcelable.Creator {
    static void a(GoogleSignInOptions googleSignInOptions, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, googleSignInOptions.e);
        c.c(parcel, 2, googleSignInOptions.a(), false);
        c.a(parcel, 3, (Parcelable)googleSignInOptions.b(), n2, false);
        c.a(parcel, 4, googleSignInOptions.c());
        c.a(parcel, 5, googleSignInOptions.d());
        c.a(parcel, 6, googleSignInOptions.e());
        c.a(parcel, 7, googleSignInOptions.f(), false);
        c.a(parcel, 8, googleSignInOptions.g(), false);
        c.a(parcel, n3);
    }

    public GoogleSignInOptions a(Parcel parcel) {
        String string = null;
        boolean bl2 = false;
        int n2 = a.b(parcel);
        String string2 = null;
        boolean bl3 = false;
        boolean bl4 = false;
        Account account = null;
        ArrayList arrayList = null;
        int n3 = 0;
        block10 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new GoogleSignInOptions(n3, arrayList, account, bl4, bl3, bl2, string2, string);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = a.a(parcel);
            switch (a.a(n4)) {
                default: {
                    a.b(parcel, n4);
                    continue block10;
                }
                case 1: {
                    n3 = a.e(parcel, n4);
                    continue block10;
                }
                case 2: {
                    arrayList = a.c(parcel, n4, Scope.CREATOR);
                    continue block10;
                }
                case 3: {
                    account = (Account)a.a(parcel, n4, Account.CREATOR);
                    continue block10;
                }
                case 4: {
                    bl4 = a.c(parcel, n4);
                    continue block10;
                }
                case 5: {
                    bl3 = a.c(parcel, n4);
                    continue block10;
                }
                case 6: {
                    bl2 = a.c(parcel, n4);
                    continue block10;
                }
                case 7: {
                    string2 = a.l(parcel, n4);
                    continue block10;
                }
                case 8: 
            }
            string = a.l(parcel, n4);
        } while (true);
    }

    public GoogleSignInOptions[] a(int n2) {
        return new GoogleSignInOptions[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

