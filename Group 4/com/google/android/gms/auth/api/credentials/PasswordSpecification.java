/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import com.google.android.gms.auth.api.credentials.d;
import com.google.android.gms.auth.api.credentials.j;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public final class PasswordSpecification
implements SafeParcelable {
    public static final j CREATOR = new j();
    public static final PasswordSpecification a = new d().a(12, 16).a("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").a("abcdefghijkmnopqrstxyz", 1).a("ABCDEFGHJKLMNPQRSTXY", 1).a("3456789", 1).a();
    public static final PasswordSpecification b = new d().a(12, 16).a("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").a("abcdefghijklmnopqrstuvwxyz", 1).a("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).a("1234567890", 1).a();
    final int c;
    final String d;
    final List e;
    final List f;
    final int g;
    final int h;
    private final int[] i;
    private final Random j;

    PasswordSpecification(int n2, String string, List list, List list2, int n3, int n4) {
        this.c = n2;
        this.d = string;
        this.e = Collections.unmodifiableList(list);
        this.f = Collections.unmodifiableList(list2);
        this.g = n3;
        this.h = n4;
        this.i = this.a();
        this.j = new SecureRandom();
    }

    private int a(char c2) {
        return c2 - 32;
    }

    static /* synthetic */ String a(Collection collection) {
        return PasswordSpecification.b(collection);
    }

    static /* synthetic */ boolean a(int n2, int n3, int n4) {
        return PasswordSpecification.b(n2, n3, n4);
    }

    private int[] a() {
        int[] arrn = new int[95];
        Arrays.fill(arrn, -1);
        Iterator iterator = this.e.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            char[] arrc = ((String)iterator.next()).toCharArray();
            int n3 = arrc.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                arrn[this.a((char)arrc[i2])] = n2;
            }
            ++n2;
        }
        return arrn;
    }

    private static String b(Collection collection) {
        char[] arrc = new char[collection.size()];
        Iterator iterator = collection.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            char c2 = ((Character)iterator.next()).charValue();
            int n3 = n2 + 1;
            arrc[n2] = c2;
            n2 = n3;
        }
        return new String(arrc);
    }

    private static boolean b(int n2, int n3, int n4) {
        if (n2 < n3) return true;
        if (n2 <= n4) return false;
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        j.a(this, parcel, n2);
    }
}

