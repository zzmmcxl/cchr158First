/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.g;

import android.support.v4.g.h;
import android.support.v4.g.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class k
implements Set {
    final /* synthetic */ h a;

    k(h h2) {
        this.a = h2;
    }

    @Override
    public boolean add(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        this.a.c();
    }

    @Override
    public boolean contains(Object object) {
        if (this.a.a(object) < 0) return false;
        return true;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return h.a(this.a.b(), collection);
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
            int n4 = object == null ? 0 : object.hashCode();
            n3 += n4;
            --n2;
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
        return new i(this.a, 0);
    }

    @Override
    public boolean remove(Object object) {
        int n2 = this.a.a(object);
        if (n2 < 0) return false;
        this.a.a(n2);
        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return h.b(this.a.b(), collection);
    }

    @Override
    public boolean retainAll(Collection collection) {
        return h.c(this.a.b(), collection);
    }

    @Override
    public int size() {
        return this.a.a();
    }

    @Override
    public Object[] toArray() {
        return this.a.b(0);
    }

    @Override
    public Object[] toArray(Object[] arrobject) {
        return this.a.a(arrobject, 0);
    }
}

