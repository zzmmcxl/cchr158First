/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.support.v4.h.a;
import android.support.v4.h.bs;
import android.support.v4.h.cf;
import android.support.v4.h.dc;
import android.view.View;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

class bu
extends bs {
    static Field b;
    static boolean c;

    static {
        c = false;
    }

    bu() {
    }

    @Override
    public void a(View view, a a2) {
        Object object = a2 == null ? null : a2.a();
        cf.a(view, object);
    }

    @Override
    public void a(View view, boolean bl2) {
        cf.a(view, bl2);
    }

    @Override
    public boolean a(View view, int n2) {
        return cf.a(view, n2);
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    @Override
    public boolean b(View view) {
        boolean bl2 = true;
        if (c) {
            return false;
        }
        if (b == null) {
            b = View.class.getDeclaredField("mAccessibilityDelegate");
            b.setAccessible(true);
        }
        try {
            Object object = b.get((Object)view);
            if (object == null) return false;
            return bl2;
        }
        catch (Throwable var3_5) {
            c = bl2;
            return false;
        }
        catch (Throwable throwable) {
            c = bl2;
            return false;
        }
    }

    @Override
    public boolean b(View view, int n2) {
        return cf.b(view, n2);
    }

    @Override
    public dc r(View view) {
        dc dc2;
        if (this.a == null) {
            this.a = new WeakHashMap();
        }
        if ((dc2 = (dc)this.a.get((Object)view)) != null) return dc2;
        dc2 = new dc(view);
        this.a.put(view, dc2);
        return dc2;
    }
}

