/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.g;

import android.support.v4.g.c;
import android.support.v4.g.h;
import android.support.v4.g.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class j
implements Set {
    final /* synthetic */ h a;

    j(h h2) {
        this.a = h2;
    }

    public boolean a(Map.Entry entry) {
        throw new UnsupportedOperationException();
    }

    @Override
    public /* synthetic */ boolean add(Object object) {
        return this.a((Map.Entry)object);
    }

    @Override
    public boolean addAll(Collection collection) {
        int n2 = this.a.a();
        Iterator iterator = collection.iterator();
        do {
            if (!iterator.hasNext()) {
                if (n2 == this.a.a()) return false;
                return true;
            }
            Map.Entry entry = (Map.Entry)iterator.next();
            this.a.a(entry.getKey(), entry.getValue());
        } while (true);
    }

    @Override
    public void clear() {
        this.a.c();
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry)object;
        int n2 = this.a.a(entry.getKey());
        if (n2 < 0) return false;
        return c.a(this.a.a(n2, 1), entry.getValue());
    }

    @Override
    public boolean containsAll(Collection collection) {
        Iterator iterator = collection.iterator();
        do {
            if (!iterator.hasNext()) return true;
        } while (this.contains(iterator.next()));
        return false;
    }

    @Override
    public boolean equals(Object object) {
        return h.a(this, object);
    }

    @Override
    public int hashCode() {
        int n2 = -1 + this.a.a();
        int n3 = 0;
        while (n2 >= 0) {
            Object object = this.a.a(n2, 0);
            Object object2 = this.a.a(n2, 1);
            int n4 = object == null ? 0 : object.hashCode();
            int n5 = object2 == null ? 0 : object2.hashCode();
            int n6 = n3 + (n5 ^ n4);
            --n2;
            n3 = n6;
        }
        return n3;
    }

    @Override
    public boolean isEmpty() {
        if (this.a.a() != 0) return false;
        return true;
    }

    @Override
    public Iterator iterator() {
        return new l(this.a);
    }

    @Override
    public boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return this.a.a();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray(Object[] arrobject) {
        throw new UnsupportedOperationException();
    }
}

