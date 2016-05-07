/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.b.ja;

class a
implements ja {
    final /* synthetic */ String a;
    final /* synthetic */ SignInHubActivity b;

    a(SignInHubActivity signInHubActivity, String string) {
        this.b = signInHubActivity;
        this.a = string;
    }

    @Override
    public void a(Intent intent) {
        if (intent == null) {
            Log.w((String)"AuthSignInClient", (String)"Idp signin failed!");
            SignInHubActivity.a(this.b, 4);
            return;
        }
        if (!TextUtils.isEmpty((CharSequence)this.a)) {
            intent.putExtra("scopes", this.a);
        }
        SignInHubActivity.a(this.b, intent);
    }
}

