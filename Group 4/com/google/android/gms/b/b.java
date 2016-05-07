/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.mq;
import java.io.ByteArrayOutputStream;

public class b
extends ByteArrayOutputStream {
    private final mq a;

    public b(mq mq2, int n2) {
        this.a = mq2;
        this.buf = this.a.a(Math.max(n2, 256));
    }

    private void a(int n2) {
        if (n2 + this.count <= this.buf.length) {
            return;
        }
        byte[] arrby = this.a.a(2 * (n2 + this.count));
        System.arraycopy(this.buf, 0, arrby, 0, this.count);
        this.a.a(this.buf);
        this.buf = arrby;
    }

    @Override
    public void close() {
        this.a.a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.a.a(this.buf);
    }

    @Override
    public void write(int n2) {
        // MONITORENTER : this
        this.a(1);
        super.write(n2);
        // MONITOREXIT : this
        return;
    }

    @Override
    public void write(byte[] arrby, int n2, int n3) {
        // MONITORENTER : this
        this.a(n3);
        super.write(arrby, n2, n3);
        // MONITOREXIT : this
        return;
    }
}

