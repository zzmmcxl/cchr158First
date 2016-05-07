/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.x;
import com.google.android.gms.auth.api.signin.internal.y;
import com.google.android.gms.common.internal.bf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class w {
    private static final WeakHashMap a = new WeakHashMap();
    private static final Lock b = new ReentrantLock();
    private final Lock c = new ReentrantLock();
    private final Map d;

    private w(Map map) {
        this.d = map;
    }

    public static w a(String string) {
        bf.a(string);
        b.lock();
        try {
            w w2 = (w)a.get(string);
            if (w2 != null) return w2;
            w2 = new w(new y(20));
            a.put(string, w2);
            return w2;
        }
        finally {
            b.unlock();
        }
    }

    public boolean a(Set set, x x2) {
        bf.a(set);
        bf.a(x2);
        if (set.size() == 0) return false;
        if (x2.a()) {
            return false;
        }
        ArrayList arrayList = new ArrayList(set);
        Collections.sort(arrayList);
        this.c.lock();
        try {
            String string = TextUtils.join((CharSequence)" ", arrayList);
            this.d.put(string, x2);
            return true;
        }
        finally {
            this.c.unlock();
        }
    }
}

