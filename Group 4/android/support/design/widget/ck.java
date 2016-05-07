/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

class ck {
    private static final ThreadLocal a = new ThreadLocal();
    private static final ThreadLocal b = new ThreadLocal();
    private static final Matrix c = new Matrix();

    public static void a(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix;
        Matrix matrix2 = (Matrix)a.get();
        if (matrix2 == null) {
            Matrix matrix3 = new Matrix();
            a.set(matrix3);
            matrix = matrix3;
        } else {
            matrix2.set(c);
            matrix = matrix2;
        }
        ck.a((ViewParent)viewGroup, view, matrix);
        RectF rectF = (RectF)b.get();
        if (rectF == null) {
            rectF = new RectF();
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int)(0.5f + rectF.left), (int)(0.5f + rectF.top), (int)(0.5f + rectF.right), (int)(0.5f + rectF.bottom));
    }

    static void a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent viewParent2 = view.getParent();
        if (viewParent2 instanceof View && viewParent2 != viewParent) {
            View view2 = (View)viewParent2;
            ck.a(viewParent, view2, matrix);
            matrix.preTranslate((float)(- view2.getScrollX()), (float)(- view2.getScrollY()));
        }
        matrix.preTranslate((float)view.getLeft(), (float)view.getTop());
        if (view.getMatrix().isIdentity()) return;
        matrix.preConcat(view.getMatrix());
    }
}

