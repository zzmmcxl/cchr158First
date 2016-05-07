/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

class x {
    public static Object a(Context context) {
        return new EdgeEffect(context);
    }

    public static void a(Object object, int n2, int n3) {
        ((EdgeEffect)object).setSize(n2, n3);
    }

    public static boolean a(Object object) {
        return ((EdgeEffect)object).isFinished();
    }

    public static boolean a(Object object, float f2) {
        ((EdgeEffect)object).onPull(f2);
        return true;
    }

    public static boolean a(Object object, int n2) {
        ((EdgeEffect)object).onAbsorb(n2);
        return true;
    }

    public static boolean a(Object object, Canvas canvas) {
        return ((EdgeEffect)object).draw(canvas);
    }

    public static boolean b(Object object) {
        EdgeEffect edgeEffect = (EdgeEffect)object;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }
}

