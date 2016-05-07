/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.d;
import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

class q
extends FrameLayout
implements d {
    final CollapsibleActionView a;

    q(View view) {
        super(view.getContext());
        this.a = (CollapsibleActionView)view;
        this.addView(view);
    }

    @Override
    public void a() {
        this.a.onActionViewExpanded();
    }

    @Override
    public void b() {
        this.a.onActionViewCollapsed();
    }

    View c() {
        return (View)this.a;
    }
}

