/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.v;
import java.util.ArrayList;
import java.util.Iterator;

@fi
public class m {
    private final int a;
    private final int b;
    private final int c;
    private final v d;
    private final Object e = new Object();
    private ArrayList f = new ArrayList();
    private ArrayList g = new ArrayList();
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k;
    private String l = "";
    private String m = "";

    public m(int n2, int n3, int n4, int n5) {
        this.a = n2;
        this.b = n3;
        this.c = n4;
        this.d = new v(n5);
    }

    private String a(ArrayList arrayList, int n2) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            stringBuffer.append((String)iterator.next());
            stringBuffer.append(' ');
            if (stringBuffer.length() <= n2) continue;
        }
        stringBuffer.deleteCharAt(-1 + stringBuffer.length());
        String string = stringBuffer.toString();
        if (string.length() < n2) return string;
        return string.substring(0, n2);
    }

    private void c(String string, boolean bl2) {
        if (string == null) return;
        if (string.length() < this.c) {
            return;
        }
        Object object = this.e;
        // MONITORENTER : object
        this.f.add(string);
        this.h += string.length();
        if (bl2) {
            this.g.add(string);
        }
        // MONITOREXIT : object
        return;
    }

    int a(int n2, int n3) {
        return n2 * this.a + n3 * this.b;
    }

    public void a(int n2) {
        this.i = n2;
    }

    public void a(String string, boolean bl2) {
        this.c(string, bl2);
        Object object = this.e;
        // MONITORENTER : object
        if (this.j < 0) {
            fp.a("ActivityContent: negative number of WebViews.");
        }
        this.e();
        // MONITOREXIT : object
        return;
    }

    public boolean a() {
        Object object = this.e;
        // MONITORENTER : object
        if (this.j != 0) return false;
        boolean bl2 = true;
        // MONITOREXIT : object
        return bl2;
    }

    public String b() {
        return this.l;
    }

    public void b(String string, boolean bl2) {
        this.c(string, bl2);
    }

    public void c() {
        Object object = this.e;
        // MONITORENTER : object
        this.j = -1 + this.j;
        // MONITOREXIT : object
        return;
    }

    public void d() {
        Object object = this.e;
        // MONITORENTER : object
        this.j = 1 + this.j;
        // MONITOREXIT : object
        return;
    }

    public void e() {
        Object object = this.e;
        // MONITORENTER : object
        int n2 = this.a(this.h, this.i);
        if (n2 > this.k) {
            this.k = n2;
            this.l = this.d.a(this.f);
            this.m = this.d.a(this.g);
        }
        // MONITOREXIT : object
        return;
    }

    public boolean equals(Object object) {
        if (!(object instanceof m)) {
            return false;
        }
        if (object == this) {
            return true;
        }
        m m2 = (m)object;
        if (m2.b() == null) return false;
        if (!m2.b().equals(this.b())) return false;
        return true;
    }

    int f() {
        return this.h;
    }

    public int hashCode() {
        return this.b().hashCode();
    }

    public String toString() {
        return "ActivityContent fetchId: " + this.i + " score:" + this.k + " total_length:" + this.h + "\n text: " + this.a(this.f, 100) + "\n viewableText" + this.a(this.g, 100) + "\n signture: " + this.l + "\n viewableSignture: " + this.m;
    }
}

