/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.b;

import android.support.v4.b.a;
import android.support.v4.b.p;
import android.support.v4.e.c;
import java.util.concurrent.CountDownLatch;

final class b
extends p
implements Runnable {
    boolean a;
    final /* synthetic */ a b;
    private final CountDownLatch d;

    b(a a2) {
        this.b = a2;
        this.d = new CountDownLatch(1);
    }

    protected /* varargs */ Object a(Void ... arrvoid) {
        try {
            return this.b.e();
        }
        catch (c var2_3) {
            if (this.c()) return null;
            throw var2_3;
        }
    }

    @Override
    protected void a(Object object) {
        try {
            this.b.b(this, object);
            return;
        }
        finally {
            this.d.countDown();
        }
    }

    @Override
    protected void b(Object object) {
        try {
            this.b.a(this, object);
            return;
        }
        finally {
            this.d.countDown();
        }
    }

    @Override
    public void run() {
        this.a = false;
        this.b.c();
    }
}

