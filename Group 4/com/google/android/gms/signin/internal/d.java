/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.signin.internal;

import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.AuthAccountResult;
import com.google.android.gms.signin.internal.SignInResponse;

public interface d
extends IInterface {
    public void a(ConnectionResult var1, AuthAccountResult var2);

    public void a(Status var1);

    public void a(Status var1, GoogleSignInAccount var2);

    public void a(SignInResponse var1);

    public void b(Status var1);
}

