/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class s
extends g {
    List p;

    s(List list) {
        this.p = list;
    }

    @Override
    public g a(g g2) {
        ArrayList<Object> arrayList = new ArrayList<Object>(this.p);
        arrayList.add(bf.a(g2));
        return new s(arrayList);
    }

    @Override
    public boolean b(char c2) {
        Iterator iterator = this.p.iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!((g)iterator.next()).b(c2));
        return true;
    }
}

