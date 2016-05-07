/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.a;
import com.google.android.gms.auth.api.signin.f;
import com.google.android.gms.b.kf;
import com.google.android.gms.b.kh;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new f();
    public static kf a = kh.c();
    private static Comparator l = new a();
    final int b;
    List c;
    private String d;
    private String e;
    private String f;
    private String g;
    private Uri h;
    private String i;
    private long j;
    private String k;

    GoogleSignInAccount(int n2, String string, String string2, String string3, String string4, Uri uri, String string5, long l2, String string6, List list) {
        this.b = n2;
        this.d = string;
        this.e = string2;
        this.f = string3;
        this.g = string4;
        this.h = uri;
        this.i = string5;
        this.j = l2;
        this.k = string6;
        this.c = list;
    }

    public static GoogleSignInAccount a(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(string);
        String string2 = jSONObject.optString("photoUrl", null);
        Uri uri = !TextUtils.isEmpty((CharSequence)string2) ? Uri.parse((String)string2) : null;
        long l2 = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet<Scope> hashSet = new HashSet<Scope>();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int n2 = jSONArray.length();
        int n3 = 0;
        while (n3 < n2) {
            hashSet.add(new Scope(jSONArray.getString(n3)));
            ++n3;
        }
        return GoogleSignInAccount.a(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), uri, l2, jSONObject.getString("obfuscatedIdentifier"), hashSet).b(jSONObject.optString("serverAuthCode", null));
    }

    public static GoogleSignInAccount a(String string, String string2, String string3, String string4, Uri uri, Long l2, String string5, Set set) {
        if (l2 != null) return new GoogleSignInAccount(2, string, string2, string3, string4, uri, null, l2, bf.a(string5), new ArrayList((Collection)bf.a(set)));
        l2 = a.a() / 1000;
        return new GoogleSignInAccount(2, string, string2, string3, string4, uri, null, l2, bf.a(string5), new ArrayList((Collection)bf.a(set)));
    }

    private JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.a() != null) {
                jSONObject.put("id", (Object)this.a());
            }
            if (this.b() != null) {
                jSONObject.put("tokenId", (Object)this.b());
            }
            if (this.c() != null) {
                jSONObject.put("email", (Object)this.c());
            }
            if (this.d() != null) {
                jSONObject.put("displayName", (Object)this.d());
            }
            if (this.e() != null) {
                jSONObject.put("photoUrl", (Object)this.e().toString());
            }
            if (this.f() != null) {
                jSONObject.put("serverAuthCode", (Object)this.f());
            }
            jSONObject.put("expirationTime", this.j);
            jSONObject.put("obfuscatedIdentifier", (Object)this.h());
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.c, l);
            Iterator iterator = this.c.iterator();
            while (iterator.hasNext()) {
                jSONArray.put((Object)((Scope)iterator.next()).a());
            }
            jSONObject.put("grantedScopes", (Object)jSONArray);
            return jSONObject;
        }
        catch (JSONException var2_4) {
            throw new RuntimeException((Throwable)var2_4);
        }
    }

    public String a() {
        return this.d;
    }

    public GoogleSignInAccount b(String string) {
        this.i = string;
        return this;
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.g;
    }

    public int describeContents() {
        return 0;
    }

    public Uri e() {
        return this.h;
    }

    public boolean equals(Object object) {
        if (object instanceof GoogleSignInAccount) return ((GoogleSignInAccount)object).i().equals(this.i());
        return false;
    }

    public String f() {
        return this.i;
    }

    public long g() {
        return this.j;
    }

    public String h() {
        return this.k;
    }

    public String i() {
        return this.k().toString();
    }

    public String j() {
        JSONObject jSONObject = this.k();
        jSONObject.remove("serverAuthCode");
        return jSONObject.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        f.a(this, parcel, n2);
    }
}

