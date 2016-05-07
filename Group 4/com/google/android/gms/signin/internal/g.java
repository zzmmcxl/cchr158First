/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.IInterface;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.az;
import com.google.android.gms.signin.internal.CheckServerAuthResult;
import com.google.android.gms.signin.internal.RecordConsentRequest;
import com.google.android.gms.signin.internal.SignInRequest;
import com.google.android.gms.signin.internal.d;

public interface g
extends IInterface {
    public void a(int var1);

    public void a(int var1, Account var2, d var3);

    public void a(AuthAccountRequest var1, d var2);

    public void a(ResolveAccountRequest var1, az var2);

    public void a(ap var1, int var2, boolean var3);

    public void a(CheckServerAuthResult var1);

    public void a(RecordConsentRequest var1, d var2);

    public void a(SignInRequest var1, d var2);

    public void a(d var1);

    public void a(boolean var1);
}

