/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.g;

import android.util.Log;
import java.io.Writer;

public class e
extends Writer {
    private final String a;
    private StringBuilder b = new StringBuilder(128);

    public e(String string) {
        this.a = string;
    }

    private void a() {
        if (this.b.length() <= 0) return;
        Log.d((String)this.a, (String)this.b.toString());
        this.b.delete(0, this.b.length());
    }

    @Override
    public void close() {
        this.a();
    }

    @Override
    public void flush() {
        this.a();
    }

    @Override
    public void write(char[] arrc, int n2, int n3) {
        int n4 = 0;
        while (n4 < n3) {
            char c2 = arrc[n2 + n4];
            if (c2 == '\n') {
                this.a();
            } else {
                this.b.append(c2);
            }
            ++n4;
        }
    }
}

