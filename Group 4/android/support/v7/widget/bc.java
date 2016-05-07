/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.widget.ag;
import android.support.v7.b.l;
import android.support.v7.widget.bd;
import android.support.v7.widget.gk;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

public class bc
extends PopupWindow {
    private static final boolean a;
    private boolean b;

    static {
        boolean bl2 = Build.VERSION.SDK_INT < 21;
        a = bl2;
    }

    public bc(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        gk gk2 = gk.a(context, attributeSet, l.PopupWindow, n2, 0);
        if (gk2.f(l.PopupWindow_overlapAnchor)) {
            this.a(gk2.a(l.PopupWindow_overlapAnchor, false));
        }
        this.setBackgroundDrawable(gk2.a(l.PopupWindow_android_popupBackground));
        gk2.a();
        if (Build.VERSION.SDK_INT >= 14) return;
        bc.a(this);
    }

    private static void a(PopupWindow popupWindow) {
        try {
            Field field = PopupWindow.class.getDeclaredField("mAnchor");
            field.setAccessible(true);
            Field field2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            field2.setAccessible(true);
            field2.set((Object)popupWindow, new bd(field, popupWindow, (ViewTreeObserver.OnScrollChangedListener)field2.get((Object)popupWindow)));
            return;
        }
        catch (Exception var1_3) {
            Log.d((String)"AppCompatPopupWindow", (String)"Exception while installing workaround OnScrollChangedListener", (Throwable)var1_3);
            return;
        }
    }

    public void a(boolean bl2) {
        if (a) {
            this.b = bl2;
            return;
        }
        ag.a((PopupWindow)this, bl2);
    }

    public void showAsDropDown(View view, int n2, int n3) {
        if (a && this.b) {
            n3 -= view.getHeight();
        }
        super.showAsDropDown(view, n2, n3);
    }

    @TargetApi(value=19)
    public void showAsDropDown(View view, int n2, int n3, int n4) {
        if (a && this.b) {
            n3 -= view.getHeight();
        }
        super.showAsDropDown(view, n2, n3, n4);
    }

    public void update(View view, int n2, int n3, int n4, int n5) {
        int n6 = a && this.b ? n3 - view.getHeight() : n3;
        super.update(view, n2, n6, n4, n5);
    }
}

