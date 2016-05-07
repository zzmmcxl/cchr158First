/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v7.a.e;
import android.support.v7.a.k;
import android.support.v7.a.s;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ListAdapter;

public class t {
    private final k a;
    private int b;

    public t(Context context) {
        this(context, s.a(context, 0));
    }

    public t(Context context, int n2) {
        this.a = new k((Context)new ContextThemeWrapper(context, s.a(context, n2)));
        this.b = n2;
    }

    public Context a() {
        return this.a.a;
    }

    public t a(DialogInterface.OnKeyListener onKeyListener) {
        this.a.r = onKeyListener;
        return this;
    }

    public t a(Drawable drawable) {
        this.a.d = drawable;
        return this;
    }

    public t a(View view) {
        this.a.g = view;
        return this;
    }

    public t a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        this.a.t = listAdapter;
        this.a.u = onClickListener;
        return this;
    }

    public t a(CharSequence charSequence) {
        this.a.f = charSequence;
        return this;
    }

    public s b() {
        s s2 = new s(this.a.a, this.b, false);
        this.a.a(s.a(s2));
        s2.setCancelable(this.a.o);
        if (this.a.o) {
            s2.setCanceledOnTouchOutside(true);
        }
        s2.setOnCancelListener(this.a.p);
        s2.setOnDismissListener(this.a.q);
        if (this.a.r == null) return s2;
        s2.setOnKeyListener(this.a.r);
        return s2;
    }
}

