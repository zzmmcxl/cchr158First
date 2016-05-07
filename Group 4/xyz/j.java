/*
 * Decompiled with CFR 0_115.
 */
package xyz;

import android.content.Context;
import android.widget.Toast;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.a;
import com.google.android.gms.location.places.ui.c;
import xyz.m2m5pcv0;

class j
implements c {
    final /* synthetic */ m2m5pcv0 a;

    j(m2m5pcv0 m2m5pcv02) {
        this.a = m2m5pcv02;
    }

    @Override
    public void a(Status status) {
        Toast.makeText((Context)this.a.getBaseContext(), (CharSequence)status.c(), (int)1).show();
    }

    @Override
    public void a(a a2) {
        m2m5pcv0.a(this.a, a2);
        m2m5pcv0.a(this.a, a2.a().toString());
        m2m5pcv0.f(this.a).a(m2m5pcv0.a(this.a));
    }
}

