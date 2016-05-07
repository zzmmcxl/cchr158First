/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Handler;
import com.google.android.gms.b.cv;
import com.google.android.gms.b.cw;
import com.google.android.gms.b.hy;
import com.google.android.gms.b.jk;
import com.google.android.gms.b.kl;
import com.google.android.gms.b.lt;
import java.util.concurrent.Executor;

public class cu
implements kl {
    private final Executor a;

    public cu(Handler handler) {
        this.a = new cv(this, handler);
    }

    @Override
    public void a(hy hy2, jk jk2) {
        this.a(hy2, jk2, null);
    }

    @Override
    public void a(hy hy2, jk jk2, Runnable runnable) {
        hy2.t();
        hy2.b("post-response");
        this.a.execute(new cw(this, hy2, jk2, runnable));
    }

    @Override
    public void a(hy hy2, lt lt2) {
        hy2.b("post-error");
        jk jk2 = jk.a(lt2);
        this.a.execute(new cw(this, hy2, jk2, null));
    }
}

