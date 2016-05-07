/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h.a;

import android.os.Bundle;
import android.support.v4.h.a.aa;
import android.support.v4.h.a.ai;
import android.support.v4.h.a.g;
import android.support.v4.h.a.w;
import java.util.ArrayList;
import java.util.List;

class ab
implements ai {
    final /* synthetic */ w a;
    final /* synthetic */ aa b;

    ab(aa aa2, w w2) {
        this.b = aa2;
        this.a = w2;
    }

    @Override
    public Object a(int n2) {
        g g2 = this.a.a(n2);
        if (g2 != null) return g2.a();
        return null;
    }

    @Override
    public List a(String string, int n2) {
        List list = this.a.a(string, n2);
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n3 = list.size();
        int n4 = 0;
        while (n4 < n3) {
            arrayList.add(((g)list.get(n4)).a());
            ++n4;
        }
        return arrayList;
    }

    @Override
    public boolean a(int n2, int n3, Bundle bundle) {
        return this.a.a(n2, n3, bundle);
    }

    @Override
    public Object b(int n2) {
        g g2 = this.a.b(n2);
        if (g2 != null) return g2.a();
        return null;
    }
}

