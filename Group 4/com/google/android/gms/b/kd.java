/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.support.v4.g.a;
import android.support.v4.g.q;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class kd
extends AbstractSet {
    private final a a;

    public kd() {
        this.a = new a();
    }

    public kd(int n2) {
        this.a = new a(n2);
    }

    public kd(Collection collection) {
        this(collection.size());
        this.addAll(collection);
    }

    public boolean a(kd kd2) {
        int n2 = this.size();
        this.a.a(kd2.a);
        if (this.size() <= n2) return false;
        return true;
    }

    @Override
    public boolean add(Object object) {
        if (this.a.containsKey(object)) {
            return false;
        }
        this.a.put(object, object);
        return true;
    }

    @Override
    public boolean addAll(Collection collection) {
        if (!(collection instanceof kd)) return super.addAll(collection);
        return this.a((kd)collection);
    }

    @Override
    public void clear() {
        this.a.clear();
    }

    @Override
    public boolean contains(Object object) {
        return this.a.containsKey(object);
    }

    @Override
    public Iterator iterator() {
        return this.a.keySet().iterator();
    }

    @Override
    public boolean remove(Object object) {
        if (!this.a.containsKey(object)) {
            return false;
        }
        this.a.remove(object);
        return true;
    }

    @Override
    public int size() {
        return this.a.size();
    }
}

