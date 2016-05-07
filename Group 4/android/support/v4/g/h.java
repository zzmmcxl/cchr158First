/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.g;

import android.support.v4.g.j;
import android.support.v4.g.k;
import android.support.v4.g.m;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class h {
    j b;
    k c;
    m d;

    h() {
    }

    public static boolean a(Map map, Collection collection) {
        Iterator iterator = collection.iterator();
        do {
            if (!iterator.hasNext()) return true;
        } while (map.containsKey(iterator.next()));
        return false;
    }

    public static boolean a(Set set, Object object) {
        boolean bl2 = true;
        if (set == object) {
            return bl2;
        }
        boolean bl3 = object instanceof Set;
        boolean bl4 = false;
        if (!bl3) return bl4;
        Set set2 = (Set)object;
        try {
            if (set.size() != set2.size()) return false;
            boolean bl5 = set.containsAll(set2);
            if (!bl5) return false;
            return bl2;
        }
        catch (ClassCastException var7_7) {
            return false;
        }
        catch (NullPointerException var6_8) {
            return false;
        }
    }

    public static boolean b(Map map, Collection collection) {
        int n2 = map.size();
        Iterator iterator = collection.iterator();
        do {
            if (!iterator.hasNext()) {
                if (n2 == map.size()) return false;
                return true;
            }
            map.remove(iterator.next());
        } while (true);
    }

    public static boolean c(Map map, Collection collection) {
        int n2 = map.size();
        Iterator iterator = map.keySet().iterator();
        do {
            if (!iterator.hasNext()) {
                if (n2 == map.size()) return false;
                return true;
            }
            if (collection.contains(iterator.next())) continue;
            iterator.remove();
        } while (true);
    }

    protected abstract int a();

    protected abstract int a(Object var1);

    protected abstract Object a(int var1, int var2);

    protected abstract Object a(int var1, Object var2);

    protected abstract void a(int var1);

    protected abstract void a(Object var1, Object var2);

    public Object[] a(Object[] arrobject, int n2) {
        int n3 = this.a();
        Object[] arrobject2 = arrobject.length < n3 ? (Object[])Array.newInstance(arrobject.getClass().getComponentType(), n3) : arrobject;
        int n4 = 0;
        do {
            if (n4 >= n3) {
                if (arrobject2.length <= n3) return arrobject2;
                arrobject2[n3] = null;
                return arrobject2;
            }
            arrobject2[n4] = this.a(n4, n2);
            ++n4;
        } while (true);
    }

    protected abstract int b(Object var1);

    protected abstract Map b();

    public Object[] b(int n2) {
        int n3 = this.a();
        Object[] arrobject = new Object[n3];
        int n4 = 0;
        while (n4 < n3) {
            arrobject[n4] = this.a(n4, n2);
            ++n4;
        }
        return arrobject;
    }

    protected abstract void c();

    public Set d() {
        if (this.b != null) return this.b;
        this.b = new j(this);
        return this.b;
    }

    public Set e() {
        if (this.c != null) return this.c;
        this.c = new k(this);
        return this.c;
    }

    public Collection f() {
        if (this.d != null) return this.d;
        this.d = new m(this);
        return this.d;
    }
}

