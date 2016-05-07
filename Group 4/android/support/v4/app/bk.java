/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

class bk
extends FrameLayout {
    public bk(Context context) {
        super(context);
    }

    static ViewGroup a(View view) {
        bk bk2 = new bk(view.getContext());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            bk2.setLayoutParams(layoutParams);
        }
        view.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        bk2.addView(view);
        return bk2;
    }

    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.dispatchThawSelfOnly(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray sparseArray) {
        this.dispatchFreezeSelfOnly(sparseArray);
    }
}

