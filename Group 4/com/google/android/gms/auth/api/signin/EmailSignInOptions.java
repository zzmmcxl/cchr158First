/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Patterns;
import com.google.android.gms.auth.api.signin.e;
import com.google.android.gms.auth.api.signin.internal.j;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class EmailSignInOptions
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new e();
    final int a;
    private final Uri b;
    private String c;
    private Uri d;

    EmailSignInOptions(int n2, Uri uri, String string, Uri uri2) {
        bf.a((Object)uri, (Object)"Server widget url cannot be null in order to use email/password sign in.");
        bf.a(uri.toString(), (Object)"Server widget url cannot be null in order to use email/password sign in.");
        bf.b(Patterns.WEB_URL.matcher(uri.toString()).matches(), "Invalid server widget url");
        this.a = n2;
        this.b = uri;
        this.c = string;
        this.d = uri2;
    }

    private JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("serverWidgetUrl", (Object)this.b.toString());
            if (!TextUtils.isEmpty((CharSequence)this.c)) {
                jSONObject.put("modeQueryName", (Object)this.c);
            }
            if (this.d == null) return jSONObject;
            jSONObject.put("tosUrl", (Object)this.d.toString());
            return jSONObject;
        }
        catch (JSONException var2_2) {
            throw new RuntimeException((Throwable)var2_2);
        }
    }

    public Uri a() {
        return this.b;
    }

    public Uri b() {
        return this.d;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.e().toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        try {
            EmailSignInOptions emailSignInOptions = (EmailSignInOptions)object;
            if (!this.b.equals((Object)emailSignInOptions.a())) return false;
            if (this.d == null) {
                if (emailSignInOptions.b() != null) return false;
            } else if (!this.d.equals((Object)emailSignInOptions.b())) return false;
            if (TextUtils.isEmpty((CharSequence)this.c)) {
                if (!TextUtils.isEmpty((CharSequence)emailSignInOptions.c())) return false;
                return true;
            }
            boolean bl2 = this.c.equals(emailSignInOptions.c());
            if (!bl2) return false;
            return true;
        }
        catch (ClassCastException var2_4) {
            return false;
        }
    }

    public int hashCode() {
        return new j().a((Object)this.b).a((Object)this.d).a(this.c).a();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        e.a(this, parcel, n2);
    }
}

