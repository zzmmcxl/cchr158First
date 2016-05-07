/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials.internal;

import android.os.IInterface;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

public interface e
extends IInterface {
    public void a(Status var1);

    public void a(Status var1, Credential var2);

    public void a(Status var1, String var2);
}

