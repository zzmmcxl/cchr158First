/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.support.v7.view.menu.a;
import android.support.v7.widget.gs;
import android.view.MenuItem;
import android.view.View;

class gt
implements View.OnClickListener {
    final a a;
    final /* synthetic */ gs b;

    gt(gs gs2) {
        this.b = gs2;
        this.a = new a(gs.a(this.b).getContext(), 0, 16908332, 0, 0, gs.b(this.b));
    }

    public void onClick(View view) {
        if (gs.c(this.b) == null) return;
        if (!gs.d(this.b)) return;
        gs.c(this.b).onMenuItemSelected(0, (MenuItem)this.a);
    }
}

