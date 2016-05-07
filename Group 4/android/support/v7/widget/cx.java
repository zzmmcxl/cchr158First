/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.util.SparseIntArray;

public abstract class cx {
    final SparseIntArray a = new SparseIntArray();
    private boolean b = false;

    public abstract int a(int var1);

    public int a(int n2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7 = this.a(n2);
        if (n7 == n3) {
            return 0;
        }
        if (this.b && this.a.size() > 0 && (n4 = this.b(n2)) >= 0) {
            n6 = this.a.get(n4) + this.a(n4);
            n5 = n4 + 1;
        } else {
            n5 = 0;
            n6 = 0;
        }
        int n8 = n5;
        do {
            if (n8 >= n2) {
                if (n6 + n7 > n3) return 0;
                return n6;
            }
            int n9 = this.a(n8);
            int n10 = n6 + n9;
            if (n10 == n3) {
                n9 = 0;
            } else if (n10 <= n3) {
                n9 = n10;
            }
            ++n8;
            n6 = n9;
        } while (true);
    }

    public void a() {
        this.a.clear();
    }

    int b(int n2) {
        int n3 = 0;
        int n4 = -1 + this.a.size();
        do {
            if (n3 > n4) {
                int n5 = n3 - 1;
                if (n5 < 0) return -1;
                if (n5 >= this.a.size()) return -1;
                return this.a.keyAt(n5);
            }
            int n6 = n3 + n4 >>> 1;
            if (this.a.keyAt(n6) < n2) {
                n3 = n6 + 1;
                continue;
            }
            n4 = n6 - 1;
        } while (true);
    }

    int b(int n2, int n3) {
        if (!this.b) {
            return this.a(n2, n3);
        }
        int n4 = this.a.get(n2, -1);
        if (n4 != -1) return n4;
        int n5 = this.a(n2, n3);
        this.a.put(n2, n5);
        return n5;
    }

    public int c(int n2, int n3) {
        int n4 = this.a(n2);
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        do {
            if (n5 >= n2) {
                if (n7 + n4 <= n3) return n6;
                ++n6;
                return n6;
            }
            int n8 = this.a(n5);
            int n9 = n7 + n8;
            if (n9 == n3) {
                ++n6;
                n8 = 0;
            } else if (n9 > n3) {
                ++n6;
            } else {
                n8 = n9;
            }
            ++n5;
            n7 = n8;
        } while (true);
    }
}

