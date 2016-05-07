/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.ai;
import com.google.android.gms.common.api.internal.aj;
import com.google.android.gms.common.api.internal.z;
import java.util.Set;

class aa
implements ai {
    final /* synthetic */ z a;

    aa(z z2) {
        this.a = z2;
    }

    @Override
    public void a(aj aj2) {
        this.a.h.remove(aj2);
        if (aj2.a() == null) return;
        if (z.a(this.a) == null) return;
        z.a(this.a).a(aj2.a());
    }
}

