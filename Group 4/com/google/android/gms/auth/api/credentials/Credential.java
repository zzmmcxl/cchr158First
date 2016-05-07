/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.credentials.f;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public class Credential
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new f();
    final int a;
    private final String b;
    private final String c;
    private final Uri d;
    private final List e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;

    Credential(int n2, String string, String string2, Uri uri, List list, String string3, String string4, String string5, String string6) {
        this.a = n2;
        String string7 = ((String)bf.a((Object)string, (Object)"credential identifier cannot be null")).trim();
        bf.a(string7, (Object)"credential identifier cannot be empty");
        this.b = string7;
        if (string2 != null && TextUtils.isEmpty((CharSequence)string2.trim())) {
            string2 = null;
        }
        this.c = string2;
        this.d = uri;
        List list2 = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.e = list2;
        this.f = string3;
        if (string3 != null && string3.isEmpty()) {
            throw new IllegalArgumentException("password cannot be empty");
        }
        if (!TextUtils.isEmpty((CharSequence)string4)) {
            String string8 = Uri.parse((String)string4).getScheme();
            boolean bl2 = "http".equalsIgnoreCase(string8) || "https".equalsIgnoreCase(string8);
            bf.b(bl2);
        }
        this.g = string4;
        this.h = string5;
        this.i = string6;
        if (TextUtils.isEmpty((CharSequence)this.f)) return;
        if (TextUtils.isEmpty((CharSequence)this.g)) return;
        throw new IllegalStateException("password and accountType cannot both be set");
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public Uri c() {
        return this.d;
    }

    public List d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential)object;
        if (!TextUtils.equals((CharSequence)this.b, (CharSequence)credential.b)) return false;
        if (!TextUtils.equals((CharSequence)this.c, (CharSequence)credential.c)) return false;
        if (!bc.a((Object)this.d, (Object)credential.d)) return false;
        if (!TextUtils.equals((CharSequence)this.f, (CharSequence)credential.f)) return false;
        if (!TextUtils.equals((CharSequence)this.g, (CharSequence)credential.g)) return false;
        if (TextUtils.equals((CharSequence)this.h, (CharSequence)credential.h)) return true;
        return false;
    }

    public String f() {
        return this.h;
    }

    public String g() {
        return this.g;
    }

    public String h() {
        return this.i;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.b, this.c, this.d, this.f, this.g, this.h};
        return bc.a(arrobject);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        f.a(this, parcel, n2);
    }
}

