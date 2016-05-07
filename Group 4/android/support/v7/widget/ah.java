/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.support.v4.h.n;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.ag;
import android.support.v7.widget.z;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.PopupWindow;

class ah
implements View.OnClickListener,
View.OnLongClickListener,
AdapterView.OnItemClickListener,
PopupWindow.OnDismissListener {
    final /* synthetic */ ActivityChooserView a;

    private void a() {
        if (ActivityChooserView.f(this.a) == null) return;
        ActivityChooserView.f(this.a).onDismiss();
    }

    public void onClick(View view) {
        if (view == ActivityChooserView.c(this.a)) {
            this.a.b();
            ResolveInfo resolveInfo = ActivityChooserView.a(this.a).b();
            int n2 = ActivityChooserView.a(this.a).d().a(resolveInfo);
            Intent intent = ActivityChooserView.a(this.a).d().b(n2);
            if (intent == null) return;
            intent.addFlags(524288);
            this.a.getContext().startActivity(intent);
            return;
        }
        if (view != ActivityChooserView.d(this.a)) throw new IllegalArgumentException();
        ActivityChooserView.a(this.a, false);
        ActivityChooserView.a(this.a, ActivityChooserView.e(this.a));
    }

    public void onDismiss() {
        this.a();
        if (this.a.a == null) return;
        this.a.a.a(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int n2, long l2) {
        Intent intent;
        switch (((ag)adapterView.getAdapter()).getItemViewType(n2)) {
            default: {
                throw new IllegalArgumentException();
            }
            case 1: {
                ActivityChooserView.a(this.a, Integer.MAX_VALUE);
                return;
            }
            case 0: 
        }
        this.a.b();
        if (ActivityChooserView.b(this.a)) {
            if (n2 <= 0) return;
            ActivityChooserView.a(this.a).d().c(n2);
            return;
        }
        if (!ActivityChooserView.a(this.a).e()) {
            ++n2;
        }
        if ((intent = ActivityChooserView.a(this.a).d().b(n2)) == null) return;
        intent.addFlags(524288);
        this.a.getContext().startActivity(intent);
    }

    public boolean onLongClick(View view) {
        if (view != ActivityChooserView.c(this.a)) throw new IllegalArgumentException();
        if (ActivityChooserView.a(this.a).getCount() <= 0) return true;
        ActivityChooserView.a(this.a, true);
        ActivityChooserView.a(this.a, ActivityChooserView.e(this.a));
        return true;
    }
}

