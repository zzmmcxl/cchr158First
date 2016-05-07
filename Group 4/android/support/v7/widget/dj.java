/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.os.Build;
import android.support.v4.h.at;
import android.support.v4.h.dc;
import android.support.v4.widget.a;
import android.support.v4.widget.z;
import android.support.v7.b.b;
import android.support.v7.widget.ds;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

class dj
extends ds {
    private boolean g;
    private boolean h;
    private boolean i;
    private dc j;
    private z k;

    public dj(Context context, boolean bl2) {
        super(context, null, b.dropDownListViewStyle);
        this.h = bl2;
        this.setCacheColorHint(0);
    }

    private void a(View view, int n2) {
        this.performItemClick(view, n2, this.getItemIdAtPosition(n2));
    }

    private void a(View view, int n2, float f2, float f3) {
        View view2;
        this.i = true;
        if (Build.VERSION.SDK_INT >= 21) {
            this.drawableHotspotChanged(f2, f3);
        }
        if (!this.isPressed()) {
            this.setPressed(true);
        }
        this.layoutChildren();
        if (this.f != -1 && (view2 = this.getChildAt(this.f - this.getFirstVisiblePosition())) != null && view2 != view && view2.isPressed()) {
            view2.setPressed(false);
        }
        this.f = n2;
        float f4 = f2 - (float)view.getLeft();
        float f5 = f3 - (float)view.getTop();
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(f4, f5);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        this.a(n2, view, f2, f3);
        this.setSelectorEnabled(false);
        this.refreshDrawableState();
    }

    static /* synthetic */ boolean a(dj dj2, boolean bl2) {
        dj2.g = bl2;
        return bl2;
    }

    private void d() {
        this.i = false;
        this.setPressed(false);
        this.drawableStateChanged();
        View view = this.getChildAt(this.f - this.getFirstVisiblePosition());
        if (view != null) {
            view.setPressed(false);
        }
        if (this.j == null) return;
        this.j.b();
        this.j = null;
    }

    @Override
    protected boolean a() {
        if (this.i) return true;
        if (!super.a()) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public boolean a(MotionEvent var1_1, int var2_2) {
        var3_3 = at.a(var1_1);
        switch (var3_3) {
            case 3: {
                var6_4 = false;
                var7_5 = false;
                ** GOTO lbl28
            }
            case 1: {
                var4_6 = false;
                ** GOTO lbl12
            }
            case 2: {
                var4_6 = true;
lbl12: // 2 sources:
                if ((var5_7 = var1_1.findPointerIndex(var2_2)) >= 0) ** GOTO lbl16
                var6_4 = false;
                var7_5 = false;
                ** GOTO lbl28
lbl16: // 1 sources:
                var11_8 = (int)var1_1.getX(var5_7);
                var13_10 = this.pointToPosition(var11_8, var12_9 = (int)var1_1.getY(var5_7));
                if (var13_10 != -1) ** GOTO lbl22
                var7_5 = var4_6;
                var6_4 = true;
                ** GOTO lbl28
lbl22: // 1 sources:
                var14_11 = this.getChildAt(var13_10 - this.getFirstVisiblePosition());
                this.a(var14_11, var13_10, var11_8, var12_9);
                if (var3_3 != 1) break;
                this.a(var14_11, var13_10);
            }
        }
        var6_4 = false;
        var7_5 = true;
lbl28: // 4 sources:
        if (var7_5 && !var6_4) ** GOTO lbl-1000
        this.d();
        if (var7_5) lbl-1000: // 2 sources:
        {
            if (this.k == null) {
                this.k = new z(this);
            }
            this.k.a(true);
            this.k.onTouch((View)this, var1_1);
            return var7_5;
        }
        if (this.k == null) return var7_5;
        this.k.a(false);
        return var7_5;
    }

    public boolean hasFocus() {
        if (this.h) return true;
        if (!super.hasFocus()) return false;
        return true;
    }

    public boolean hasWindowFocus() {
        if (this.h) return true;
        if (!super.hasWindowFocus()) return false;
        return true;
    }

    public boolean isFocused() {
        if (this.h) return true;
        if (!super.isFocused()) return false;
        return true;
    }

    public boolean isInTouchMode() {
        if (this.h) {
            if (this.g) return true;
        }
        if (!super.isInTouchMode()) return false;
        return true;
    }
}

