package android.support.design.widget;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.View;
import android.view.ViewParent;
import android.graphics.RectF;
import android.graphics.Matrix;

class ViewGroupUtilsHoneycomb
{
    private static final Matrix IDENTITY;
    private static final ThreadLocal<Matrix> sMatrix;
    private static final ThreadLocal<RectF> sRectF;
    
    static {
        sMatrix = new ThreadLocal<Matrix>();
        sRectF = new ThreadLocal<RectF>();
        IDENTITY = new Matrix();
    }
    
    ViewGroupUtilsHoneycomb() {
        super();
    }
    
    static void offsetDescendantMatrix(final ViewParent viewParent, final View view, final Matrix matrix) {
        final ViewParent parent = view.getParent();
        if (parent instanceof View && parent != viewParent) {
            final View view2 = (View)parent;
            offsetDescendantMatrix(viewParent, view2, matrix);
            matrix.preTranslate((float)(-view2.getScrollX()), (float)(-view2.getScrollY()));
        }
        matrix.preTranslate((float)view.getLeft(), (float)view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
    
    public static void offsetDescendantRect(final ViewGroup viewGroup, final View view, final Rect rect) {
        Matrix matrix = (Matrix)sMatrix.get();
        if (matrix == null) {
            matrix = new Matrix();
            sMatrix.set(matrix);
        }
        else {
            matrix.set(IDENTITY);
        }
        offsetDescendantMatrix((ViewParent)viewGroup, view, matrix);
        RectF rectF = (RectF)sRectF.get();
        if (rectF == null) {
            rectF = new RectF();
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int)(0.5f + rectF.left), (int)(0.5f + rectF.top), (int)(0.5f + rectF.right), (int)(0.5f + rectF.bottom));
    }
}
