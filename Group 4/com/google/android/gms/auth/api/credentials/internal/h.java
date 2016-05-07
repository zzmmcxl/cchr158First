/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials.internal;

import android.os.IInterface;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.internal.DeleteRequest;
import com.google.android.gms.auth.api.credentials.internal.GeneratePasswordRequest;
import com.google.android.gms.auth.api.credentials.internal.SaveRequest;
import com.google.android.gms.auth.api.credentials.internal.e;

public interface h
extends IInterface {
    public void a(e var1);

    public void a(e var1, CredentialRequest var2);

    public void a(e var1, DeleteRequest var2);

    public void a(e var1, GeneratePasswordRequest var2);

    public void a(e var1, SaveRequest var2);
}

