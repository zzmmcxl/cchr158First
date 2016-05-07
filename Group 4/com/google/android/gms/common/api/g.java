/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.t;
import java.util.Collections;
import java.util.List;

public abstract class g {
    public int a() {
        return Integer.MAX_VALUE;
    }

    public abstract h a(Context var1, Looper var2, t var3, Object var4, q var5, r var6);

    public List a(Object object) {
        return Collections.emptyList();
    }
}

