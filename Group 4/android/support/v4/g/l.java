/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.g;

import android.support.v4.g.c;
import android.support.v4.g.h;
import java.util.Iterator;
import java.util.Map;

final class l
implements Iterator,
Map.Entry {
    int a;
    int b;
    boolean c;
    final /* synthetic */ h d;

    l(h h2) {
        this.d = h2;
        this.c = false;
        this.a = -1 + h2.a();
        this.b = -1;
    }

    public Map.Entry a() {
        this.b = 1 + this.b;
        this.c = true;
        return this;
    }

    @Override
    public final boolean equals(Object object) {
        int n2 = 1;
        if (!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(object instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry)object;
        if (!c.a(entry.getKey(), this.d.a(this.b, 0))) return (boolean)0;
        if (!c.a(entry.getValue(), this.d.a(this.b, n2))) return (boolean)0;
        return (boolean)n2;
    }

    public Object getKey() {
        if (this.c) return this.d.a(this.b, 0);
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public Object getValue() {
        if (this.c) return this.d.a(this.b, 1);
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override
    public boolean hasNext() {
        if (this.b >= this.a) return false;
        return true;
    }

    @Override
    public final int hashCode() {
        if (!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        Object object = this.d.a(this.b, 0);
        Object object2 = this.d.a(this.b, 1);
        int n2 = object == null ? 0 : object.hashCode();
        int n3 = 0;
        if (object2 == null) {
            return n3 ^ n2;
        }
        n3 = object2.hashCode();
        return n3 ^ n2;
    }

    public /* synthetic */ Object next() {
        return this.a();
    }

    @Override
    public void remove() {
        if (!this.c) {
            throw new IllegalStateException();
        }
        this.d.a(this.b);
        this.b = -1 + this.b;
        this.a = -1 + this.a;
        this.c = false;
    }

    public Object setValue(Object object) {
        if (this.c) return this.d.a(this.b, object);
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return this.getKey() + "=" + this.getValue();
    }
}

