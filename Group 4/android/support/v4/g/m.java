/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.g;

import android.support.v4.g.h;
import android.support.v4.g.i;
import java.util.Collection;
import java.util.Iterator;

final class m
implements Collection {
    final /* synthetic */ h a;

    m(h h2) {
        this.a = h2;
    }

    public boolean add(Object object) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        this.a.c();
    }

    @Override
    public boolean contains(Object object) {
        if (this.a.b(object) < 0) return false;
        return true;
    }

    public boolean containsAll(Collection collection) {
        Iterator iterator = collection.iterator();
        do {
            if (!iterator.hasNext()) return true;
        } while (this.contains(iterator.next()));
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (this.a.a() != 0) return false;
        return true;
    }

    @Override
    public Iterator iterator() {
        return new i(this.a, 1);
    }

    @Override
    public boolean remove(Object object) {
        int n2 = this.a.b(object);
        if (n2 < 0) return false;
        this.a.a(n2);
        return true;
    }

    public boolean removeAll(Collection collection) {
        int n2 = 0;
        int n3 = this.a.a();
        boolean bl2 = false;
        while (n2 < n3) {
            if (collection.contains(this.a.a(n2, 1))) {
                this.a.a(n2);
                --n2;
                --n3;
                bl2 = true;
            }
            ++n2;
        }
        return bl2;
    }

    public boolean retainAll(Collection collection) {
        int n2 = 0;
        int n3 = this.a.a();
        boolean bl2 = false;
        while (n2 < n3) {
            if (!collection.contains(this.a.a(n2, 1))) {
                this.a.a(n2);
                --n2;
                --n3;
                bl2 = true;
            }
            ++n2;
        }
        return bl2;
    }

    @Override
    public int size() {
        return this.a.a();
    }

    @Override
    public Object[] toArray() {
        return this.a.b(1);
    }

    public Object[] toArray(Object[] arrobject) {
        return this.a.a(arrobject, 1);
    }
}

