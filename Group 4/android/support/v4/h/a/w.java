/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h.a;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.h.a.aa;
import android.support.v4.h.a.ac;
import android.support.v4.h.a.g;
import android.support.v4.h.a.x;
import android.support.v4.h.a.y;
import java.util.List;

public class w {
    private static final x a;
    private final Object b;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            a = new aa();
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            a = new y();
            return;
        }
        a = new ac();
    }

    public w() {
        this.b = a.a(this);
    }

    public w(Object object) {
        this.b = object;
    }

    public g a(int n2) {
        return null;
    }

    public Object a() {
        return this.b;
    }

    public List a(String string, int n2) {
        return null;
    }

    public boolean a(int n2, int n3, Bundle bundle) {
        return false;
    }

    public g b(int n2) {
        return null;
    }
}

