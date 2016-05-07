/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

final class bd
implements ViewTreeObserver.OnScrollChangedListener {
    final /* synthetic */ Field a;
    final /* synthetic */ PopupWindow b;
    final /* synthetic */ ViewTreeObserver.OnScrollChangedListener c;

    bd(Field field, PopupWindow popupWindow, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.a = field;
        this.b = popupWindow;
        this.c = onScrollChangedListener;
    }

    public void onScrollChanged() {
        try {
            WeakReference weakReference = (WeakReference)this.a.get((Object)this.b);
            if (weakReference == null) return;
            if (weakReference.get() == null) {
                return;
            }
            this.c.onScrollChanged();
            return;
        }
        catch (IllegalAccessException var1_2) {
            // empty catch block
        }
    }
}

