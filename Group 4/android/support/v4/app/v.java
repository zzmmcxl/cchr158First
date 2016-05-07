/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.u;
import android.util.AttributeSet;
import android.view.View;

abstract class v
extends u {
    v() {
    }

    public View onCreateView(View view, String string, Context context, AttributeSet attributeSet) {
        View view2 = this.a(view, string, context, attributeSet);
        if (view2 != null) return view2;
        if (Build.VERSION.SDK_INT < 11) return view2;
        return super.onCreateView(view, string, context, attributeSet);
    }
}

