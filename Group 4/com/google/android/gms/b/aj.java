/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.ae;
import com.google.android.gms.b.fi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@fi
public class aj {
    private final Collection a = new ArrayList();
    private final Collection b = new ArrayList();
    private final Collection c = new ArrayList();

    public List a() {
        ArrayList<String> arrayList = new ArrayList<String>();
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            String string = (String)((ae)iterator.next()).c();
            if (string == null) continue;
            arrayList.add(string);
        }
        return arrayList;
    }

    public void a(ae ae2) {
        this.a.add(ae2);
    }

    public void b(ae ae2) {
        this.b.add(ae2);
    }

    public void c(ae ae2) {
        this.c.add(ae2);
    }
}

