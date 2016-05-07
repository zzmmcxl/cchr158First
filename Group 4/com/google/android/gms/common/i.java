/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class i
implements Parcelable.Creator {
    static void a(ConnectionResult connectionResult, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, connectionResult.b);
        c.a(parcel, 2, connectionResult.c());
        c.a(parcel, 3, (Parcelable)connectionResult.d(), n2, false);
        c.a(parcel, 4, connectionResult.e(), false);
        c.a(parcel, n3);
    }

    public ConnectionResult a(Parcel parcel) {
        String string = null;
        int n2 = 0;
        int n3 = a.b(parcel);
        PendingIntent pendingIntent = null;
        int n4 = 0;
        do {
            PendingIntent pendingIntent2;
            String string2;
            int n5;
            int n6;
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new ConnectionResult(n4, n2, pendingIntent, string);
                throw new b("Overread allowed size end=" + n3, parcel);
            }
            int n7 = a.a(parcel);
            switch (a.a(n7)) {
                default: {
                    a.b(parcel, n7);
                    string2 = string;
                    pendingIntent2 = pendingIntent;
                    n5 = n2;
                    n6 = n4;
                    break;
                }
                case 1: {
                    int n8 = a.e(parcel, n7);
                    String string3 = string;
                    pendingIntent2 = pendingIntent;
                    n5 = n2;
                    n6 = n8;
                    string2 = string3;
                    break;
                }
                case 2: {
                    int n9 = a.e(parcel, n7);
                    n6 = n4;
                    PendingIntent pendingIntent3 = pendingIntent;
                    n5 = n9;
                    string2 = string;
                    pendingIntent2 = pendingIntent3;
                    break;
                }
                case 3: {
                    PendingIntent pendingIntent4 = (PendingIntent)a.a(parcel, n7, PendingIntent.CREATOR);
                    n5 = n2;
                    n6 = n4;
                    String string4 = string;
                    pendingIntent2 = pendingIntent4;
                    string2 = string4;
                    break;
                }
                case 4: {
                    string2 = a.l(parcel, n7);
                    pendingIntent2 = pendingIntent;
                    n5 = n2;
                    n6 = n4;
                }
            }
            n4 = n6;
            n2 = n5;
            pendingIntent = pendingIntent2;
            string = string2;
        } while (true);
    }

    public ConnectionResult[] a(int n2) {
        return new ConnectionResult[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

