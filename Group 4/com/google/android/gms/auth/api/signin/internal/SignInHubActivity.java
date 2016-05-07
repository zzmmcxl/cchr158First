/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.aa;
import android.support.v4.app.bb;
import android.support.v4.app.bc;
import android.support.v4.b.m;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.auth.api.signin.h;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.internal.a;
import com.google.android.gms.auth.api.signin.internal.ac;
import com.google.android.gms.auth.api.signin.internal.b;
import com.google.android.gms.auth.api.signin.internal.s;
import com.google.android.gms.auth.api.signin.internal.u;
import com.google.android.gms.auth.api.signin.internal.w;
import com.google.android.gms.auth.api.signin.internal.x;
import com.google.android.gms.b.iz;
import com.google.android.gms.b.ja;
import com.google.android.gms.b.jc;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@KeepName
public class SignInHubActivity
extends aa {
    private ac m;
    private u n;
    private SignInConfiguration o;
    private boolean p;
    private String q;
    private String r;
    private boolean s;
    private int t;
    private Intent u;

    static /* synthetic */ int a(SignInHubActivity signInHubActivity) {
        return signInHubActivity.t;
    }

    private ja a(String string) {
        return new a(this, string);
    }

    private void a(int n2, int n3, Intent intent) {
        Iterator iterator = this.n.a().iterator();
        while (iterator.hasNext() && !((iz)iterator.next()).a(n2, n3, intent, this.a(this.r))) {
        }
        if (n3 != 0) return;
        this.finish();
    }

    private void a(int n2, Intent intent) {
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount)intent.getParcelableExtra("signInAccount");
            if (signInAccount != null && signInAccount.f() != null) {
                GoogleSignInAccount googleSignInAccount = signInAccount.f();
                this.m.b(googleSignInAccount, this.o.d());
                intent.removeExtra("signInAccount");
                intent.putExtra("googleSignInAccount", (Parcelable)googleSignInAccount);
                this.s = true;
                this.t = n2;
                this.u = intent;
                this.d(n2, intent);
                return;
            }
            if (intent.hasExtra("errorCode")) {
                this.c(intent.getIntExtra("errorCode", 8));
                return;
            }
        }
        this.c(8);
    }

    private void a(Intent intent) {
        intent.setPackage("com.google.android.gms");
        intent.putExtra("config", (Parcelable)this.o);
        int n2 = this.p ? 40962 : 40961;
        try {
            this.startActivityForResult(intent, n2);
            return;
        }
        catch (ActivityNotFoundException var5_3) {
            Log.w((String)"AuthSignInClient", (String)"Could not launch sign in Intent. Google Play Service is probably being updated...");
            if (this.p) {
                this.c(8);
                return;
            }
            this.b(2);
            return;
        }
    }

    static /* synthetic */ void a(SignInHubActivity signInHubActivity, int n2) {
        signInHubActivity.b(n2);
    }

    static /* synthetic */ void a(SignInHubActivity signInHubActivity, Intent intent) {
        signInHubActivity.a(intent);
    }

    static /* synthetic */ Intent b(SignInHubActivity signInHubActivity) {
        return signInHubActivity.u;
    }

    private void b(int n2) {
        Intent intent = new Intent();
        intent.putExtra("errorCode", n2);
        this.setResult(0, intent);
        this.finish();
    }

    private void b(int n2, Intent intent) {
        if (n2 == -1) {
            SignInAccount signInAccount = (SignInAccount)intent.getParcelableExtra("signInAccount");
            if (signInAccount == null) {
                Log.w((String)"AuthSignInClient", (String)"[SignInHubActivity] SignInAccount is null.");
                this.b(2);
                return;
            }
            this.m.b(signInAccount, this.o);
            String string = intent.getStringExtra("accessToken");
            if (!TextUtils.isEmpty((CharSequence)string) && !TextUtils.isEmpty((CharSequence)this.r)) {
                HashSet<String> hashSet = new HashSet<String>(Arrays.asList(TextUtils.split((String)this.r, (String)" ")));
                w.a(signInAccount.g()).a(hashSet, new x(string, intent.getLongExtra("accessTokenExpiresAtSecs", 0)));
                intent.removeExtra("accessTokenExpiresAtSecs");
            }
            this.setResult(-1, intent);
            this.finish();
            return;
        }
        if (intent == null) {
            this.finish();
            return;
        }
        String string = intent.getStringExtra("email");
        h h2 = h.a(intent.getStringExtra("idProvider"));
        if (h2 == null) {
            this.setResult(n2, intent);
            this.finish();
            return;
        }
        this.q = intent.getStringExtra("pendingToken");
        iz iz2 = this.n.a(h2);
        if (iz2 == null) {
            CharSequence charSequence = h2.a((Context)this);
            Log.w((String)"AuthSignInClient", (String)(charSequence + " is not supported. Please check your configuration"));
            this.b(1);
            return;
        }
        int n3 = intent.getIntExtra("idpAction", -1);
        if (n3 == 0) {
            if (TextUtils.isEmpty((CharSequence)string)) {
                iz2.a(this.a(this.r));
                return;
            }
            iz2.a(string, this.a(this.r));
            return;
        }
        if (n3 == 1 && !TextUtils.isEmpty((CharSequence)this.q) && !TextUtils.isEmpty((CharSequence)string)) {
            iz2.a(string, this.q, this.a(this.r));
            return;
        }
        Log.w((String)"AuthSignInClient", (String)"Internal error!");
        this.b(2);
    }

    private void c(int n2) {
        Status status = new Status(n2);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", (Parcelable)status);
        this.setResult(0, intent);
        this.finish();
    }

    private void c(int n2, Intent intent) {
        if (n2 == 0) {
            this.setResult(0, intent);
            this.finish();
            return;
        }
        Intent intent2 = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
        intent2.putExtra("idpTokenType", (Parcelable)IdpTokenType.a);
        intent2.putExtra("idpToken", intent.getStringExtra("idpToken"));
        intent2.putExtra("pendingToken", this.q);
        intent2.putExtra("idProvider", h.b.a());
        this.a(intent2);
    }

    private void d(int n2, Intent intent) {
        this.g().a(0, null, new b(this, null));
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    @Override
    protected void onActivityResult(int n2, int n3, Intent intent) {
        this.setResult(0);
        switch (n2) {
            default: {
                this.a(n2, n3, intent);
                return;
            }
            case 40962: {
                this.a(n3, intent);
                return;
            }
            case 40961: {
                this.b(n3, intent);
                return;
            }
            case 45057: 
        }
        this.c(n3, intent);
    }

    @Override
    protected void onCreate(Bundle bundle) {
        SignInAccount signInAccount;
        Intent intent;
        super.onCreate(bundle);
        this.m = ac.a((Context)this);
        Intent intent2 = this.getIntent();
        this.o = (SignInConfiguration)intent2.getParcelableExtra("config");
        this.p = "com.google.android.gms.auth.GOOGLE_SIGN_IN".equals(intent2.getAction());
        this.r = intent2.getStringExtra("scopes");
        if (this.o == null) {
            Log.e((String)"AuthSignInClient", (String)"Activity started with invalid configuration.");
            this.setResult(0);
            this.finish();
            return;
        }
        LinkedList linkedList = new LinkedList();
        HashMap hashMap = new HashMap();
        s.a(this.o, linkedList, hashMap);
        this.n = new u(this, linkedList, hashMap);
        if (bundle != null) {
            this.q = bundle.getString("pendingToken");
            this.s = bundle.getBoolean("signingInGoogleApiClients");
            if (!this.s) return;
            this.t = bundle.getInt("signInResultCode");
            this.u = (Intent)bundle.getParcelable("signInResultData");
            this.d(this.t, this.u);
            return;
        }
        if (this.p) {
            intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
            signInAccount = null;
        } else {
            intent = new Intent("com.google.android.gms.auth.LOGIN_PICKER");
            if ("com.google.android.gms.auth.RESOLVE_CREDENTIAL".equals(intent2.getAction())) {
                intent.fillIn(intent2, 3);
                signInAccount = (SignInAccount)intent2.getParcelableExtra("signInAccount");
            } else {
                this.m.c();
                if (false) {
                    try {
                        jc.a((Context)this);
                        signInAccount = null;
                    }
                    catch (IllegalStateException var7_7) {
                        signInAccount = null;
                    }
                } else {
                    signInAccount = null;
                }
            }
        }
        if (signInAccount != null && signInAccount.e() == h.b) {
            ((jc)null).a(this.a(this.r));
            return;
        }
        this.a(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("pendingToken", this.q);
        bundle.putBoolean("signingInGoogleApiClients", this.s);
        if (!this.s) return;
        bundle.putInt("signInResultCode", this.t);
        bundle.putParcelable("signInResultData", (Parcelable)this.u);
    }
}

