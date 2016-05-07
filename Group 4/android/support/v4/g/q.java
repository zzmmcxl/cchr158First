/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.g;

import android.support.v4.g.c;
import java.util.Map;

public class q {
    static Object[] b;
    static int c;
    static Object[] d;
    static int e;
    int[] f;
    Object[] g;
    int h;

    public q() {
        this.f = c.a;
        this.g = c.c;
        this.h = 0;
    }

    public q(int n2) {
        if (n2 == 0) {
            this.f = c.a;
            this.g = c.c;
        } else {
            this.e(n2);
        }
        this.h = 0;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private static void a(int[] arrn, Object[] arrobject, int n2) {
        if (arrn.length == 8) {
            // MONITORENTER : android.support.v4.g.a.class
            if (e < 10) {
                arrobject[0] = d;
                arrobject[1] = arrn;
                for (int i2 = -1 + (n2 << 1); i2 >= 2; --i2) {
                    arrobject[i2] = null;
                }
                d = arrobject;
                e = 1 + e;
            }
            // MONITOREXIT : android.support.v4.g.a.class
            return;
        }
        if (arrn.length != 4) return;
        // MONITORENTER : android.support.v4.g.a.class
        if (c < 10) {
            arrobject[0] = b;
            arrobject[1] = arrn;
            for (int i3 = -1 + (n2 << 1); i3 >= 2; --i3) {
                arrobject[i3] = null;
            }
            b = arrobject;
            c = 1 + c;
        }
        // MONITOREXIT : android.support.v4.g.a.class
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void e(int n2) {
        if (n2 == 8) {
            // MONITORENTER : android.support.v4.g.a.class
            if (d != null) {
                Object[] arrobject;
                this.g = arrobject = d;
                d = (Object[])arrobject[0];
                this.f = (int[])arrobject[1];
                arrobject[1] = null;
                arrobject[0] = null;
                e = -1 + e;
                // MONITOREXIT : android.support.v4.g.a.class
                return;
            }
            // MONITOREXIT : android.support.v4.g.a.class
        } else if (n2 == 4) {
            // MONITORENTER : android.support.v4.g.a.class
            if (b != null) {
                Object[] arrobject;
                this.g = arrobject = b;
                b = (Object[])arrobject[0];
                this.f = (int[])arrobject[1];
                arrobject[1] = null;
                arrobject[0] = null;
                c = -1 + c;
                // MONITOREXIT : android.support.v4.g.a.class
                return;
            }
            // MONITOREXIT : android.support.v4.g.a.class
        }
        this.f = new int[n2];
        this.g = new Object[n2 << 1];
    }

    int a() {
        int n2;
        int n3 = this.h;
        if (n3 == 0) {
            return -1;
        }
        int n4 = c.a(this.f, n3, 0);
        if (n4 < 0) return n4;
        if (this.g[n4 << 1] == null) return n4;
        for (n2 = n4 + 1; n2 < n3 && this.f[n2] == 0; ++n2) {
            if (this.g[n2 << 1] != null) continue;
            return n2;
        }
        --n4;
        while (n4 >= 0) {
            if (this.f[n4] != 0) return ~ n2;
            if (this.g[n4 << 1] == null) return n4;
            --n4;
        }
        return ~ n2;
    }

    public int a(Object object) {
        if (object != null) return this.a(object, object.hashCode());
        return this.a();
    }

    int a(Object object, int n2) {
        int n3;
        int n4 = this.h;
        if (n4 == 0) {
            return -1;
        }
        int n5 = c.a(this.f, n4, n2);
        if (n5 < 0) return n5;
        if (object.equals(this.g[n5 << 1])) return n5;
        for (n3 = n5 + 1; n3 < n4 && this.f[n3] == n2; ++n3) {
            if (!object.equals(this.g[n3 << 1])) continue;
            return n3;
        }
        --n5;
        while (n5 >= 0) {
            if (this.f[n5] != n2) return ~ n3;
            if (object.equals(this.g[n5 << 1])) return n5;
            --n5;
        }
        return ~ n3;
    }

    public Object a(int n2, Object object) {
        int n3 = 1 + (n2 << 1);
        Object object2 = this.g[n3];
        this.g[n3] = object;
        return object2;
    }

    public void a(int n2) {
        if (this.f.length >= n2) return;
        int[] arrn = this.f;
        Object[] arrobject = this.g;
        this.e(n2);
        if (this.h > 0) {
            System.arraycopy(arrn, 0, this.f, 0, this.h);
            System.arraycopy(arrobject, 0, this.g, 0, this.h << 1);
        }
        q.a(arrn, arrobject, this.h);
    }

    public void a(q q2) {
        int n2 = q2.h;
        this.a(n2 + this.h);
        int n3 = this.h;
        int n4 = 0;
        if (n3 == 0) {
            if (n2 <= 0) return;
            System.arraycopy(q2.f, 0, this.f, 0, n2);
            System.arraycopy(q2.g, 0, this.g, 0, n2 << 1);
            this.h = n2;
            return;
        }
        while (n4 < n2) {
            this.put(q2.b(n4), q2.c(n4));
            ++n4;
        }
    }

    /*
     * Unable to fully structure code
     */
    int b(Object var1_1) {
        var2_2 = 1;
        var3_3 = 2 * this.h;
        var4_4 = this.g;
        if (var1_1 != null) ** GOTO lbl12
        while (var2_2 < var3_3) {
            if (var4_4[var2_2] == null) {
                return var2_2 >> 1;
            }
            var2_2 += 2;
        }
        return -1;
lbl-1000: // 1 sources:
        {
            var2_2 += 2;
lbl12: // 2 sources:
            if (var2_2 >= var3_3) return -1;
            ** while (!var1_1.equals((Object)var4_4[var2_2]))
        }
lbl14: // 1 sources:
        return var2_2 >> 1;
    }

    public Object b(int n2) {
        return this.g[n2 << 1];
    }

    public Object c(int n2) {
        return this.g[1 + (n2 << 1)];
    }

    public void clear() {
        if (this.h == 0) return;
        q.a(this.f, this.g, this.h);
        this.f = c.a;
        this.g = c.c;
        this.h = 0;
    }

    public boolean containsKey(Object object) {
        if (this.a(object) < 0) return false;
        return true;
    }

    public boolean containsValue(Object object) {
        if (this.b(object) < 0) return false;
        return true;
    }

    public Object d(int n2) {
        int n3 = 8;
        Object object = this.g[1 + (n2 << 1)];
        if (this.h <= 1) {
            q.a(this.f, this.g, this.h);
            this.f = c.a;
            this.g = c.c;
            this.h = 0;
            return object;
        }
        if (this.f.length > n3 && this.h < this.f.length / 3) {
            if (this.h > n3) {
                n3 = this.h + (this.h >> 1);
            }
            int[] arrn = this.f;
            Object[] arrobject = this.g;
            this.e(n3);
            this.h = -1 + this.h;
            if (n2 > 0) {
                System.arraycopy(arrn, 0, this.f, 0, n2);
                System.arraycopy(arrobject, 0, this.g, 0, n2 << 1);
            }
            if (n2 >= this.h) return object;
            System.arraycopy(arrn, n2 + 1, this.f, n2, this.h - n2);
            System.arraycopy(arrobject, n2 + 1 << 1, this.g, n2 << 1, this.h - n2 << 1);
            return object;
        }
        this.h = -1 + this.h;
        if (n2 < this.h) {
            System.arraycopy(this.f, n2 + 1, this.f, n2, this.h - n2);
            System.arraycopy(this.g, n2 + 1 << 1, this.g, n2 << 1, this.h - n2 << 1);
        }
        this.g[this.h << 1] = null;
        this.g[1 + (this.h << 1)] = null;
        return object;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Map)) return false;
        Map map = (Map)object;
        if (this.size() != map.size()) {
            return false;
        }
        int n2 = 0;
        try {
            while (n2 < this.h) {
                Object object2 = this.b(n2);
                Object object3 = this.c(n2);
                Object v2 = map.get(object2);
                if (object3 == null) {
                    if (v2 != null) return false;
                    if (!map.containsKey(object2)) {
                        return false;
                    }
                } else {
                    boolean bl2 = object3.equals(v2);
                    if (!bl2) {
                        return false;
                    }
                }
                ++n2;
            }
            return true;
        }
        catch (NullPointerException var5_8) {
            return false;
        }
        catch (ClassCastException var4_9) {
            return false;
        }
    }

    public Object get(Object object) {
        int n2 = this.a(object);
        if (n2 < 0) return null;
        return this.g[1 + (n2 << 1)];
    }

    public int hashCode() {
        int[] arrn = this.f;
        Object[] arrobject = this.g;
        int n2 = this.h;
        int n3 = 1;
        int n4 = 0;
        int n5 = 0;
        while (n4 < n2) {
            Object object = arrobject[n3];
            int n6 = arrn[n4];
            int n7 = object == null ? 0 : object.hashCode();
            n5 += n7 ^ n6;
            ++n4;
            n3 += 2;
        }
        return n5;
    }

    public boolean isEmpty() {
        if (this.h > 0) return false;
        return true;
    }

    public Object put(Object object, Object object2) {
        int n2;
        int n3;
        int n4 = 8;
        if (object == null) {
            n2 = this.a();
            n3 = 0;
        } else {
            n3 = object.hashCode();
            n2 = this.a(object, n3);
        }
        if (n2 >= 0) {
            int n5 = 1 + (n2 << 1);
            Object object3 = this.g[n5];
            this.g[n5] = object2;
            return object3;
        }
        int n6 = ~ n2;
        if (this.h >= this.f.length) {
            if (this.h >= n4) {
                n4 = this.h + (this.h >> 1);
            } else if (this.h < 4) {
                n4 = 4;
            }
            int[] arrn = this.f;
            Object[] arrobject = this.g;
            this.e(n4);
            if (this.f.length > 0) {
                System.arraycopy(arrn, 0, this.f, 0, arrn.length);
                System.arraycopy(arrobject, 0, this.g, 0, arrobject.length);
            }
            q.a(arrn, arrobject, this.h);
        }
        if (n6 < this.h) {
            System.arraycopy(this.f, n6, this.f, n6 + 1, this.h - n6);
            System.arraycopy(this.g, n6 << 1, this.g, n6 + 1 << 1, this.h - n6 << 1);
        }
        this.f[n6] = n3;
        this.g[n6 << 1] = object;
        this.g[1 + (n6 << 1)] = object2;
        this.h = 1 + this.h;
        return null;
    }

    public Object remove(Object object) {
        int n2 = this.a(object);
        if (n2 < 0) return null;
        return this.d(n2);
    }

    public int size() {
        return this.h;
    }

    public String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(28 * this.h);
        stringBuilder.append('{');
        int n2 = 0;
        do {
            Object object;
            if (n2 >= this.h) {
                stringBuilder.append('}');
                return stringBuilder.toString();
            }
            if (n2 > 0) {
                stringBuilder.append(", ");
            }
            if ((object = this.b(n2)) != this) {
                stringBuilder.append(object);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            Object object2 = this.c(n2);
            if (object2 != this) {
                stringBuilder.append(object2);
            } else {
                stringBuilder.append("(this Map)");
            }
            ++n2;
        } while (true);
    }
}

