/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.api.f;

public final class h
implements f {
    private final String a;
    private final PasswordSpecification b;

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("consumer_package", this.a);
        bundle.putParcelable("password_specification", (Parcelable)this.b);
        return bundle;
    }
}

