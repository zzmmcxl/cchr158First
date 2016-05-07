/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.internal.m;

public interface p
extends IInterface {
    public void a(m var1, GoogleSignInOptions var2);

    public void a(m var1, SignInConfiguration var2);

    public void a(m var1, SignInConfiguration var2, SignInAccount var3, String var4);

    public void b(m var1, GoogleSignInOptions var2);

    public void b(m var1, SignInConfiguration var2);

    public void c(m var1, GoogleSignInOptions var2);
}

