/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.api.Status;

public interface m
extends IInterface {
    public void a(GoogleSignInAccount var1, Status var2);

    public void a(Status var1);

    public void a(Status var1, SignInAccount var2);

    public void a(Status var1, String var2, String var3, long var4);

    public void b(Status var1);

    public void c(Status var1);
}

