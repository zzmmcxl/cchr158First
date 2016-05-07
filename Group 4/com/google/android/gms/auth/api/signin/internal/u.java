/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import android.app.Activity;
import com.google.android.gms.auth.api.signin.h;
import com.google.android.gms.b.iz;
import com.google.android.gms.b.jc;
import com.google.android.gms.common.internal.bf;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class u {
    private final Map a;

    public u(Activity activity, List list, Map map) {
        bf.a((Object)activity);
        bf.a(list);
        bf.a(map);
        HashMap<h, iz> hashMap = new HashMap<h, iz>();
        Iterator iterator = list.iterator();
        do {
            iz iz2;
            if (!iterator.hasNext()) {
                this.a = Collections.unmodifiableMap(hashMap);
                return;
            }
            h h2 = (h)((Object)iterator.next());
            List list2 = (List)map.get((Object)h2);
            if (list2 == null) {
                list2 = Collections.emptyList();
            }
            if ((iz2 = this.a(h2, activity, list2)) == null) continue;
            hashMap.put(h2, iz2);
        } while (true);
    }

    private iz a(h h2, Activity activity, List list) {
        if (!h.b.equals((Object)h2)) return null;
        return new jc(activity, list);
    }

    public iz a(h h2) {
        bf.a((Object)h2);
        return (iz)this.a.get((Object)h2);
    }

    public Collection a() {
        return this.a.values();
    }
}

