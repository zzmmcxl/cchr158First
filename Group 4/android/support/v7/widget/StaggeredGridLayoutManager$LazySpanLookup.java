/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
import android.support.v7.widget.gc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StaggeredGridLayoutManager$LazySpanLookup {
    int[] a;
    List b;

    StaggeredGridLayoutManager$LazySpanLookup() {
    }

    private void c(int n2, int n3) {
        if (this.b == null) {
            return;
        }
        int n4 = n2 + n3;
        int n5 = -1 + this.b.size();
        while (n5 >= 0) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.b.get(n5);
            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.a >= n2) {
                if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.a < n4) {
                    this.b.remove(n5);
                } else {
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.a -= n3;
                }
            }
            --n5;
        }
    }

    private void d(int n2, int n3) {
        if (this.b == null) {
            return;
        }
        int n4 = -1 + this.b.size();
        while (n4 >= 0) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.b.get(n4);
            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.a >= n2) {
                staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.a = n3 + staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.a;
            }
            --n4;
        }
    }

    private int g(int n2) {
        if (this.b == null) {
            return -1;
        }
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = this.f(n2);
        if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem != null) {
            this.b.remove(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem);
        }
        int n3 = this.b.size();
        int n4 = 0;
        while (n4 < n3) {
            if (((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.b.get((int)n4)).a >= n2) {
                if (n4 == -1) return -1;
                StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2 = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.b.get(n4);
                this.b.remove(n4);
                return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.a;
            }
            ++n4;
        }
        return -1;
    }

    int a(int n2) {
        if (this.b == null) return this.b(n2);
        int n3 = -1 + this.b.size();
        while (n3 >= 0) {
            if (((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.b.get((int)n3)).a >= n2) {
                this.b.remove(n3);
            }
            --n3;
        }
        return this.b(n2);
    }

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem a(int n2, int n3, int n4, boolean bl2) {
        if (this.b == null) {
            return null;
        }
        int n5 = this.b.size();
        int n6 = 0;
        while (n6 < n5) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.b.get(n6);
            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.a >= n3) {
                return null;
            }
            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.a >= n2) {
                if (n4 == 0) return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
                if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.b == n4) return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
                if (bl2) {
                    if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.d) return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
                }
            }
            ++n6;
        }
        return null;
    }

    void a() {
        if (this.a != null) {
            Arrays.fill(this.a, -1);
        }
        this.b = null;
    }

    void a(int n2, int n3) {
        if (this.a == null) return;
        if (n2 >= this.a.length) {
            return;
        }
        this.e(n2 + n3);
        System.arraycopy(this.a, n2 + n3, this.a, n2, this.a.length - n2 - n3);
        Arrays.fill(this.a, this.a.length - n3, this.a.length, -1);
        this.c(n2, n3);
    }

    void a(int n2, gc gc2) {
        this.e(n2);
        this.a[n2] = gc2.d;
    }

    public void a(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        int n2 = this.b.size();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.b.add(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem);
                return;
            }
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2 = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.b.get(n3);
            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.a == staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.a) {
                this.b.remove(n3);
            }
            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.a >= staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.a) {
                this.b.add(n3, staggeredGridLayoutManager$LazySpanLookup$FullSpanItem);
                return;
            }
            ++n3;
        } while (true);
    }

    int b(int n2) {
        if (this.a == null) {
            return -1;
        }
        if (n2 >= this.a.length) return -1;
        int n3 = this.g(n2);
        if (n3 == -1) {
            Arrays.fill(this.a, n2, this.a.length, -1);
            return this.a.length;
        }
        Arrays.fill(this.a, n2, n3 + 1, -1);
        return n3 + 1;
    }

    void b(int n2, int n3) {
        if (this.a == null) return;
        if (n2 >= this.a.length) {
            return;
        }
        this.e(n2 + n3);
        System.arraycopy(this.a, n2, this.a, n2 + n3, this.a.length - n2 - n3);
        Arrays.fill(this.a, n2, n2 + n3, -1);
        this.d(n2, n3);
    }

    int c(int n2) {
        if (this.a == null) return -1;
        if (n2 < this.a.length) return this.a[n2];
        return -1;
    }

    int d(int n2) {
        int n3 = this.a.length;
        while (n3 <= n2) {
            n3 *= 2;
        }
        return n3;
    }

    void e(int n2) {
        if (this.a == null) {
            this.a = new int[1 + Math.max(n2, 10)];
            Arrays.fill(this.a, -1);
            return;
        }
        if (n2 < this.a.length) return;
        int[] arrn = this.a;
        this.a = new int[this.d(n2)];
        System.arraycopy(arrn, 0, this.a, 0, arrn.length);
        Arrays.fill(this.a, arrn.length, this.a.length, -1);
    }

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem f(int n2) {
        if (this.b == null) {
            return null;
        }
        int n3 = -1 + this.b.size();
        while (n3 >= 0) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.b.get(n3);
            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.a == n2) return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
            --n3;
        }
        return null;
    }
}

