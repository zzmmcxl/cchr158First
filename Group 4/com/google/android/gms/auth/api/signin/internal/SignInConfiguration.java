/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.ab;
import com.google.android.gms.auth.api.signin.internal.j;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

public final class SignInConfiguration
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new ab();
    final int a;
    private final String b;
    private String c;
    private EmailSignInOptions d;
    private GoogleSignInOptions e;
    private String f;

    SignInConfiguration(int n2, String string, String string2, EmailSignInOptions emailSignInOptions, GoogleSignInOptions googleSignInOptions, String string3) {
        this.a = n2;
        this.b = bf.a(string);
        this.c = string2;
        this.d = emailSignInOptions;
        this.e = googleSignInOptions;
        this.f = string3;
    }

    public SignInConfiguration(String string) {
        this(2, string, null, null, null, null);
    }

    private JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("consumerPackageName", (Object)this.b);
            if (!TextUtils.isEmpty((CharSequence)this.c)) {
                jSONObject.put("serverClientId", (Object)this.c);
            }
            if (this.d != null) {
                jSONObject.put("emailSignInOptions", (Object)this.d.d());
            }
            if (this.e != null) {
                jSONObject.put("googleSignInOptions", (Object)this.e.h());
            }
            if (TextUtils.isEmpty((CharSequence)this.f)) return jSONObject;
            jSONObject.put("apiKey", (Object)this.f);
            return jSONObject;
        }
        catch (JSONException var2_2) {
            throw new RuntimeException((Throwable)var2_2);
        }
    }

    public SignInConfiguration a(GoogleSignInOptions googleSignInOptions) {
        this.e = (GoogleSignInOptions)bf.a(googleSignInOptions, (Object)"GoogleSignInOptions cannot be null.");
        return this;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public EmailSignInOptions c() {
        return this.d;
    }

    public GoogleSignInOptions d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        try {
            SignInConfiguration signInConfiguration = (SignInConfiguration)object;
            if (!this.b.equals(signInConfiguration.a())) return false;
            if (TextUtils.isEmpty((CharSequence)this.c)) {
                if (!TextUtils.isEmpty((CharSequence)signInConfiguration.b())) return false;
            } else if (!this.c.equals(signInConfiguration.b())) return false;
            if (TextUtils.isEmpty((CharSequence)this.f)) {
                if (!TextUtils.isEmpty((CharSequence)signInConfiguration.e())) return false;
            } else if (!this.f.equals(signInConfiguration.e())) return false;
            if (this.d == null) {
                if (signInConfiguration.c() != null) return false;
            } else if (!this.d.equals(signInConfiguration.c())) return false;
            if (this.e == null) {
                if (signInConfiguration.d() != null) return false;
                return true;
            }
            boolean bl2 = this.e.equals(signInConfiguration.d());
            if (!bl2) return false;
            return true;
        }
        catch (ClassCastException var2_4) {
            return false;
        }
    }

    public String f() {
        return this.g().toString();
    }

    public int hashCode() {
        return new j().a(this.b).a(this.c).a(this.f).a(this.d).a(this.e).a();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        ab.a(this, parcel, n2);
    }
}

