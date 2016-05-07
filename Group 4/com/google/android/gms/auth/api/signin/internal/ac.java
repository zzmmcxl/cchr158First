/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.common.internal.bf;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class ac {
    private static final Lock a = new ReentrantLock();
    private static ac b;
    private final Lock c = new ReentrantLock();
    private final SharedPreferences d;

    ac(Context context) {
        this.d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static ac a(Context context) {
        bf.a((Object)context);
        a.lock();
        try {
            if (b == null) {
                b = new ac(context.getApplicationContext());
            }
            ac ac2 = b;
            return ac2;
        }
        finally {
            a.unlock();
        }
    }

    private String b(String string, String string2) {
        return string + ":" + string2;
    }

    public GoogleSignInAccount a() {
        return this.b(this.d("defaultGoogleSignInAccount"));
    }

    SignInAccount a(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        String string2 = this.d(this.b("signInAccount", string));
        if (TextUtils.isEmpty((CharSequence)string2)) return null;
        try {
            SignInAccount signInAccount = SignInAccount.a(string2);
            if (signInAccount.f() == null) return signInAccount;
            GoogleSignInAccount googleSignInAccount = this.b(signInAccount.f().h());
            if (googleSignInAccount == null) return signInAccount;
            signInAccount.a(googleSignInAccount);
            return signInAccount;
        }
        catch (JSONException var3_5) {
            return null;
        }
    }

    void a(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        bf.a(googleSignInAccount);
        bf.a(googleSignInOptions);
        String string = googleSignInAccount.h();
        this.a(this.b("googleSignInAccount", string), googleSignInAccount.j());
        this.a(this.b("googleSignInOptions", string), googleSignInOptions.h());
    }

    void a(SignInAccount signInAccount, SignInConfiguration signInConfiguration) {
        bf.a(signInAccount);
        bf.a(signInConfiguration);
        String string = signInAccount.g();
        SignInAccount signInAccount2 = this.a(string);
        if (signInAccount2 != null && signInAccount2.f() != null) {
            this.f(signInAccount2.f().h());
        }
        this.a(this.b("signInConfiguration", string), signInConfiguration.f());
        this.a(this.b("signInAccount", string), signInAccount.i());
        if (signInAccount.f() == null) return;
        this.a(signInAccount.f(), signInConfiguration.d());
    }

    protected void a(String string, String string2) {
        this.c.lock();
        try {
            this.d.edit().putString(string, string2).apply();
            return;
        }
        finally {
            this.c.unlock();
        }
    }

    GoogleSignInAccount b(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        String string2 = this.d(this.b("googleSignInAccount", string));
        if (string2 == null) return null;
        try {
            return GoogleSignInAccount.a(string2);
        }
        catch (JSONException var3_4) {
            return null;
        }
    }

    public GoogleSignInOptions b() {
        return this.c(this.d("defaultGoogleSignInAccount"));
    }

    public void b(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        bf.a(googleSignInAccount);
        bf.a(googleSignInOptions);
        this.a("defaultGoogleSignInAccount", googleSignInAccount.h());
        this.a(googleSignInAccount, googleSignInOptions);
    }

    public void b(SignInAccount signInAccount, SignInConfiguration signInConfiguration) {
        bf.a(signInAccount);
        bf.a(signInConfiguration);
        this.c();
        this.a("defaultSignInAccount", signInAccount.g());
        if (signInAccount.f() != null) {
            this.a("defaultGoogleSignInAccount", signInAccount.f().h());
        }
        this.a(signInAccount, signInConfiguration);
    }

    GoogleSignInOptions c(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        String string2 = this.d(this.b("googleSignInOptions", string));
        if (string2 == null) return null;
        try {
            return GoogleSignInOptions.a(string2);
        }
        catch (JSONException var3_4) {
            return null;
        }
    }

    public void c() {
        String string = this.d("defaultSignInAccount");
        this.g("defaultSignInAccount");
        this.d();
        this.e(string);
    }

    protected String d(String string) {
        this.c.lock();
        try {
            String string2 = this.d.getString(string, null);
            return string2;
        }
        finally {
            this.c.unlock();
        }
    }

    public void d() {
        String string = this.d("defaultGoogleSignInAccount");
        this.g("defaultGoogleSignInAccount");
        this.f(string);
    }

    void e(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return;
        }
        SignInAccount signInAccount = this.a(string);
        this.g(this.b("signInAccount", string));
        this.g(this.b("signInConfiguration", string));
        if (signInAccount == null) return;
        if (signInAccount.f() == null) return;
        this.f(signInAccount.f().h());
    }

    void f(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return;
        }
        this.g(this.b("googleSignInAccount", string));
        this.g(this.b("googleSignInOptions", string));
    }

    protected void g(String string) {
        this.c.lock();
        try {
            this.d.edit().remove(string).apply();
            return;
        }
        finally {
            this.c.unlock();
        }
    }
}

