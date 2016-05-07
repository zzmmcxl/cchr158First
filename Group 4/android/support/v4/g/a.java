/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.g;

import android.support.v4.g.b;
import android.support.v4.g.h;
import android.support.v4.g.q;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class a
extends q
implements Map {
    h a;

    public a() {
    }

    public a(int n2) {
        super(n2);
    }

    private h b() {
        if (this.a != null) return this.a;
        this.a = new b(this);
        return this.a;
    }

    public boolean a(Collection collection) {
        return h.c(this, collection);
    }

    public Set entrySet() {
        return this.b().d();
    }

    public Set keySet() {
        return this.b().e();
    }

    public void putAll(Map map) {
        this.a(this.h + map.size());
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            this.put(entry.getKey(), entry.getValue());
        }
    }

    public Collection values() {
        return this.b().f();
    }
}

