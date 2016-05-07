/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.ef;
import android.support.v7.widget.ff;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;

public class ev {
    private SparseArray a = new SparseArray();
    private SparseIntArray b = new SparseIntArray();
    private int c = 0;

    private ArrayList b(int n2) {
        ArrayList arrayList = (ArrayList)this.a.get(n2);
        if (arrayList != null) return arrayList;
        arrayList = new ArrayList();
        this.a.put(n2, arrayList);
        if (this.b.indexOfKey(n2) >= 0) return arrayList;
        this.b.put(n2, 5);
        return arrayList;
    }

    public ff a(int n2) {
        ArrayList arrayList = (ArrayList)this.a.get(n2);
        if (arrayList == null) return null;
        if (arrayList.isEmpty()) return null;
        int n3 = -1 + arrayList.size();
        ff ff2 = (ff)arrayList.get(n3);
        arrayList.remove(n3);
        return ff2;
    }

    public void a() {
        this.a.clear();
    }

    void a(ef ef2) {
        this.c = 1 + this.c;
    }

    void a(ef ef2, ef ef3, boolean bl2) {
        if (ef2 != null) {
            this.b();
        }
        if (!bl2 && this.c == 0) {
            this.a();
        }
        if (ef3 == null) return;
        this.a(ef3);
    }

    public void a(ff ff2) {
        int n2 = ff2.h();
        ArrayList arrayList = this.b(n2);
        if (this.b.get(n2) <= arrayList.size()) {
            return;
        }
        ff2.v();
        arrayList.add(ff2);
    }

    void b() {
        this.c = -1 + this.c;
    }
}

