/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.support.v7.a.s;
import android.support.v7.a.t;
import android.support.v7.view.menu.g;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.x;
import android.support.v7.view.menu.y;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListAdapter;

class l
implements DialogInterface.OnClickListener,
DialogInterface.OnDismissListener,
DialogInterface.OnKeyListener,
y {
    g a;
    private i b;
    private s c;
    private y d;

    public l(i i2) {
        this.b = i2;
    }

    public void a() {
        if (this.c == null) return;
        this.c.dismiss();
    }

    public void a(IBinder iBinder) {
        i i2 = this.b;
        t t2 = new t(i2.e());
        this.a = new g(t2.a(), android.support.v7.b.i.abc_list_menu_item_layout);
        this.a.a(this);
        this.b.a(this.a);
        t2.a(this.a.a(), this);
        View view = i2.o();
        if (view != null) {
            t2.a(view);
        } else {
            t2.a(i2.n()).a(i2.m());
        }
        t2.a(this);
        this.c = t2.b();
        this.c.setOnDismissListener((DialogInterface.OnDismissListener)this);
        WindowManager.LayoutParams layoutParams = this.c.getWindow().getAttributes();
        layoutParams.type = 1003;
        if (iBinder != null) {
            layoutParams.token = iBinder;
        }
        layoutParams.flags = 131072 | layoutParams.flags;
        this.c.show();
    }

    @Override
    public void a(i i2, boolean bl2) {
        if (bl2 || i2 == this.b) {
            this.a();
        }
        if (this.d == null) return;
        this.d.a(i2, bl2);
    }

    @Override
    public boolean a(i i2) {
        if (this.d == null) return false;
        return this.d.a(i2);
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        this.b.a((m)this.a.a().getItem(n2), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.a.a(this.b, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int n2, KeyEvent keyEvent) {
        if (n2 != 82) {
            if (n2 != 4) return this.b.performShortcut(n2, keyEvent, 0);
        }
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            Window window = this.c.getWindow();
            if (window == null) return this.b.performShortcut(n2, keyEvent, 0);
            View view = window.getDecorView();
            if (view == null) return this.b.performShortcut(n2, keyEvent, 0);
            KeyEvent.DispatcherState dispatcherState = view.getKeyDispatcherState();
            if (dispatcherState == null) return this.b.performShortcut(n2, keyEvent, 0);
            dispatcherState.startTracking(keyEvent, (Object)this);
            return true;
        }
        if (keyEvent.getAction() != 1) return this.b.performShortcut(n2, keyEvent, 0);
        if (keyEvent.isCanceled()) return this.b.performShortcut(n2, keyEvent, 0);
        Window window = this.c.getWindow();
        if (window == null) return this.b.performShortcut(n2, keyEvent, 0);
        View view = window.getDecorView();
        if (view == null) return this.b.performShortcut(n2, keyEvent, 0);
        KeyEvent.DispatcherState dispatcherState = view.getKeyDispatcherState();
        if (dispatcherState == null) return this.b.performShortcut(n2, keyEvent, 0);
        if (!dispatcherState.isTracking(keyEvent)) return this.b.performShortcut(n2, keyEvent, 0);
        this.b.a(true);
        dialogInterface.dismiss();
        return true;
    }
}

