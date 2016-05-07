/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.support.v7.a.x;
import android.support.v7.view.menu.i;
import android.support.v7.view.n;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;

class y
extends n {
    final /* synthetic */ x a;

    y(x x2, Window.Callback callback) {
        this.a = x2;
        super(callback);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.a.a(keyEvent)) return true;
        if (!super.dispatchKeyEvent(keyEvent)) return false;
        return true;
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyShortcutEvent(keyEvent)) return true;
        if (!this.a.a(keyEvent.getKeyCode(), keyEvent)) return false;
        return true;
    }

    @Override
    public void onContentChanged() {
    }

    @Override
    public boolean onCreatePanelMenu(int n2, Menu menu) {
        if (n2 != 0) return super.onCreatePanelMenu(n2, menu);
        if (menu instanceof i) return super.onCreatePanelMenu(n2, menu);
        return false;
    }

    @Override
    public boolean onMenuOpened(int n2, Menu menu) {
        super.onMenuOpened(n2, menu);
        this.a.b(n2, menu);
        return true;
    }

    @Override
    public void onPanelClosed(int n2, Menu menu) {
        super.onPanelClosed(n2, menu);
        this.a.a(n2, menu);
    }

    @Override
    public boolean onPreparePanel(int n2, View view, Menu menu) {
        i i2 = menu instanceof i ? (i)menu : null;
        if (n2 == 0) {
            if (i2 == null) {
                return false;
            }
            if (i2 != null) {
                i2.c(true);
            }
        }
        boolean bl2 = super.onPreparePanel(n2, view, menu);
        if (i2 == null) return bl2;
        i2.c(false);
        return bl2;
    }
}

