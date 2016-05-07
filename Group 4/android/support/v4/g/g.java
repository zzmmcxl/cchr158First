/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.g;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class g {
    private final LinkedHashMap a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public g(int n2) {
        if (n2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.c = n2;
        this.a = new LinkedHashMap(0, 0.75f, true);
    }

    private int c(Object object, Object object2) {
        int n2 = this.b(object, object2);
        if (n2 >= 0) return n2;
        throw new IllegalStateException("Negative size: " + object + "=" + object2);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final Object a(Object object) {
        if (object == null) {
            throw new NullPointerException("key == null");
        }
        // MONITORENTER : this
        Object v2 = this.a.get(object);
        if (v2 != null) {
            this.g = 1 + this.g;
            // MONITOREXIT : this
            return v2;
        }
        this.h = 1 + this.h;
        // MONITOREXIT : this
        Object object2 = this.b(object);
        if (object2 == null) {
            return null;
        }
        // MONITORENTER : this
        this.e = 1 + this.e;
        Object object3 = this.a.put(object, object2);
        if (object3 != null) {
            this.a.put(object, object3);
        } else {
            this.b += this.c(object, object2);
        }
        // MONITOREXIT : this
        if (object3 != null) {
            this.a(false, object, object2, object3);
            return object3;
        }
        this.a(this.c);
        return object2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final Object a(Object object, Object object2) {
        if (object == null) throw new NullPointerException("key == null || value == null");
        if (object2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        // MONITORENTER : this
        this.d = 1 + this.d;
        this.b += this.c(object, object2);
        Object object3 = this.a.put(object, object2);
        if (object3 != null) {
            this.b -= this.c(object, object3);
        }
        // MONITOREXIT : this
        if (object3 != null) {
            this.a(false, object, object3, object2);
        }
        this.a(this.c);
        return object3;
    }

    public void a(int n2) {
        do {
            // MONITORENTER : this
            if (this.b < 0) throw new IllegalStateException(this.getClass().getName() + ".sizeOf() is reporting inconsistent results!");
            if (this.a.isEmpty() && this.b != 0) {
                throw new IllegalStateException(this.getClass().getName() + ".sizeOf() is reporting inconsistent results!");
            }
            if (this.b <= n2 || this.a.isEmpty()) {
                // MONITOREXIT : this
                return;
            }
            Map.Entry entry = this.a.entrySet().iterator().next();
            Object k2 = entry.getKey();
            Object v2 = entry.getValue();
            this.a.remove(k2);
            this.b -= this.c(k2, v2);
            this.f = 1 + this.f;
            // MONITOREXIT : this
            this.a(true, k2, v2, null);
        } while (true);
    }

    protected void a(boolean bl2, Object object, Object object2, Object object3) {
    }

    protected int b(Object object, Object object2) {
        return 1;
    }

    protected Object b(Object object) {
        return null;
    }

    public final String toString() {
        // MONITORENTER : this
        int n2 = this.g + this.h;
        int n3 = 0;
        if (n2 != 0) {
            n3 = 100 * this.g / n2;
        }
        Object[] arrobject = new Object[]{this.c, this.g, this.h, n3};
        String string = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", arrobject);
        // MONITOREXIT : this
        return string;
    }
}

