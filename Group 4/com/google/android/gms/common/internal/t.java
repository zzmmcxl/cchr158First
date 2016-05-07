/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.b.ma;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.o;
import com.google.android.gms.common.internal.u;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class t {
    private final Account a;
    private final Set b;
    private final Set c;
    private final Map d;
    private final int e;
    private final View f;
    private final String g;
    private final String h;
    private final ma i;
    private Integer j;

    public t(Account account, Set set, Map map, int n2, View view, String string, String string2, ma ma2) {
        this.a = account;
        Set set2 = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.b = set2;
        if (map == null) {
            map = Collections.EMPTY_MAP;
        }
        this.d = map;
        this.f = view;
        this.e = n2;
        this.g = string;
        this.h = string2;
        this.i = ma2;
        HashSet hashSet = new HashSet(this.b);
        Iterator iterator = this.d.values().iterator();
        do {
            if (!iterator.hasNext()) {
                this.c = Collections.unmodifiableSet(hashSet);
                return;
            }
            hashSet.addAll(((u)iterator.next()).a);
        } while (true);
    }

    public static t a(Context context) {
        return new o(context).a();
    }

    @Deprecated
    public String a() {
        if (this.a == null) return null;
        return this.a.name;
    }

    public Set a(a a2) {
        u u2 = (u)this.d.get(a2);
        if (u2 == null) return this.b;
        if (u2.a.isEmpty()) {
            return this.b;
        }
        HashSet hashSet = new HashSet(this.b);
        hashSet.addAll(u2.a);
        return hashSet;
    }

    public void a(Integer n2) {
        this.j = n2;
    }

    public Account b() {
        return this.a;
    }

    public Account c() {
        if (this.a == null) return new Account("<<default account>>", "com.google");
        return this.a;
    }

    public Set d() {
        return this.b;
    }

    public Set e() {
        return this.c;
    }

    public Map f() {
        return this.d;
    }

    public String g() {
        return this.g;
    }

    public String h() {
        return this.h;
    }

    public ma i() {
        return this.i;
    }

    public Integer j() {
        return this.j;
    }
}

