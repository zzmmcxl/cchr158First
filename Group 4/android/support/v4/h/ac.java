/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.support.v4.h.ad;
import android.support.v4.h.af;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

class ac {
    private static Field a;
    private static boolean b;

    static void a(LayoutInflater layoutInflater, af af2) {
        ad ad2 = af2 != null ? new ad(af2) : null;
        layoutInflater.setFactory2((LayoutInflater.Factory2)ad2);
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof LayoutInflater.Factory2) {
            ac.a(layoutInflater, (LayoutInflater.Factory2)factory);
            return;
        }
        ac.a(layoutInflater, ad2);
    }

    static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!b) {
            try {
                a = LayoutInflater.class.getDeclaredField("mFactory2");
                a.setAccessible(true);
            }
            catch (NoSuchFieldException var4_2) {
                Log.e((String)"LayoutInflaterCompatHC", (String)("forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results."), (Throwable)var4_2);
            }
            b = true;
        }
        if (a == null) return;
        try {
            a.set((Object)layoutInflater, (Object)factory2);
            return;
        }
        catch (IllegalAccessException var2_3) {
            Log.e((String)"LayoutInflaterCompatHC", (String)("forceSetFactory2 could not set the Factory2 on LayoutInflater " + (Object)layoutInflater + "; inflation may have unexpected results."), (Throwable)var2_3);
            return;
        }
    }
}

