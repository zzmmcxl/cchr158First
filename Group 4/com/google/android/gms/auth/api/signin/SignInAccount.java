/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.h;
import com.google.android.gms.auth.api.signin.i;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

public class SignInAccount
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new i();
    final int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private Uri f;
    private GoogleSignInAccount g;
    private String h;
    private String i;

    SignInAccount(int n2, String string, String string2, String string3, String string4, Uri uri, GoogleSignInAccount googleSignInAccount, String string5, String string6) {
        this.a = n2;
        this.d = bf.a(string3, (Object)"Email cannot be empty.");
        this.e = string4;
        this.f = uri;
        this.b = string;
        this.c = string2;
        this.g = googleSignInAccount;
        this.h = bf.a(string5);
        this.i = string6;
    }

    public static SignInAccount a(h h2, String string, String string2, String string3, Uri uri, String string4, String string5) {
        String string6 = null;
        if (h2 == null) return new SignInAccount(2, string6, string, string2, string3, uri, null, string4, string5);
        string6 = h2.a();
        return new SignInAccount(2, string6, string, string2, string3, uri, null, string4, string5);
    }

    public static SignInAccount a(String string) {
        Uri uri;
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(string);
        String string2 = jSONObject.optString("photoUrl", null);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            uri = Uri.parse((String)string2);
            return SignInAccount.a(h.a(jSONObject.optString("providerId", null)), jSONObject.optString("tokenId", null), jSONObject.getString("email"), jSONObject.optString("displayName", null), uri, jSONObject.getString("localId"), jSONObject.optString("refreshToken")).a(GoogleSignInAccount.a(jSONObject.optString("googleSignInAccount")));
        }
        uri = null;
        return SignInAccount.a(h.a(jSONObject.optString("providerId", null)), jSONObject.optString("tokenId", null), jSONObject.getString("email"), jSONObject.optString("displayName", null), uri, jSONObject.getString("localId"), jSONObject.optString("refreshToken")).a(GoogleSignInAccount.a(jSONObject.optString("googleSignInAccount")));
    }

    private JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("email", (Object)this.b());
            if (!TextUtils.isEmpty((CharSequence)this.e)) {
                jSONObject.put("displayName", (Object)this.e);
            }
            if (this.f != null) {
                jSONObject.put("photoUrl", (Object)this.f.toString());
            }
            if (!TextUtils.isEmpty((CharSequence)this.b)) {
                jSONObject.put("providerId", (Object)this.b);
            }
            if (!TextUtils.isEmpty((CharSequence)this.c)) {
                jSONObject.put("tokenId", (Object)this.c);
            }
            if (this.g != null) {
                jSONObject.put("googleSignInAccount", (Object)this.g.i());
            }
            if (!TextUtils.isEmpty((CharSequence)this.i)) {
                jSONObject.put("refreshToken", (Object)this.i);
            }
            jSONObject.put("localId", (Object)this.g());
            return jSONObject;
        }
        catch (JSONException var2_2) {
            throw new RuntimeException((Throwable)var2_2);
        }
    }

    public SignInAccount a(GoogleSignInAccount googleSignInAccount) {
        this.g = googleSignInAccount;
        return this;
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public Uri d() {
        return this.f;
    }

    public int describeContents() {
        return 0;
    }

    public h e() {
        return h.a(this.b);
    }

    public GoogleSignInAccount f() {
        return this.g;
    }

    public String g() {
        return this.h;
    }

    public String h() {
        return this.i;
    }

    public String i() {
        return this.k().toString();
    }

    String j() {
        return this.b;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        i.a(this, parcel, n2);
    }
}

