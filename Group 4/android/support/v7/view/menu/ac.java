/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.d.a.a;
import android.support.v7.view.menu.e;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

class ac
extends e
implements Menu {
    ac(Context context, a a2) {
        super(context, a2);
    }

    public MenuItem add(int n2) {
        return this.a(((a)this.b).add(n2));
    }

    public MenuItem add(int n2, int n3, int n4, int n5) {
        return this.a(((a)this.b).add(n2, n3, n4, n5));
    }

    public MenuItem add(int n2, int n3, int n4, CharSequence charSequence) {
        return this.a(((a)this.b).add(n2, n3, n4, charSequence));
    }

    public MenuItem add(CharSequence charSequence) {
        return this.a(((a)this.b).add(charSequence));
    }

    public int addIntentOptions(int n2, int n3, int n4, ComponentName componentName, Intent[] arrintent, Intent intent, int n5, MenuItem[] arrmenuItem) {
        MenuItem[] arrmenuItem2 = null;
        if (arrmenuItem != null) {
            arrmenuItem2 = new MenuItem[arrmenuItem.length];
        }
        int n6 = ((a)this.b).addIntentOptions(n2, n3, n4, componentName, arrintent, intent, n5, arrmenuItem2);
        if (arrmenuItem2 == null) return n6;
        int n7 = 0;
        int n8 = arrmenuItem2.length;
        while (n7 < n8) {
            arrmenuItem[n7] = this.a(arrmenuItem2[n7]);
            ++n7;
        }
        return n6;
    }

    public SubMenu addSubMenu(int n2) {
        return this.a(((a)this.b).addSubMenu(n2));
    }

    public SubMenu addSubMenu(int n2, int n3, int n4, int n5) {
        return this.a(((a)this.b).addSubMenu(n2, n3, n4, n5));
    }

    public SubMenu addSubMenu(int n2, int n3, int n4, CharSequence charSequence) {
        return this.a(((a)this.b).addSubMenu(n2, n3, n4, charSequence));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return this.a(((a)this.b).addSubMenu(charSequence));
    }

    public void clear() {
        this.a();
        ((a)this.b).clear();
    }

    public void close() {
        ((a)this.b).close();
    }

    public MenuItem findItem(int n2) {
        return this.a(((a)this.b).findItem(n2));
    }

    public MenuItem getItem(int n2) {
        return this.a(((a)this.b).getItem(n2));
    }

    public boolean hasVisibleItems() {
        return ((a)this.b).hasVisibleItems();
    }

    public boolean isShortcutKey(int n2, KeyEvent keyEvent) {
        return ((a)this.b).isShortcutKey(n2, keyEvent);
    }

    public boolean performIdentifierAction(int n2, int n3) {
        return ((a)this.b).performIdentifierAction(n2, n3);
    }

    public boolean performShortcut(int n2, KeyEvent keyEvent, int n3) {
        return ((a)this.b).performShortcut(n2, keyEvent, n3);
    }

    public void removeGroup(int n2) {
        this.a(n2);
        ((a)this.b).removeGroup(n2);
    }

    public void removeItem(int n2) {
        this.b(n2);
        ((a)this.b).removeItem(n2);
    }

    public void setGroupCheckable(int n2, boolean bl2, boolean bl3) {
        ((a)this.b).setGroupCheckable(n2, bl2, bl3);
    }

    public void setGroupEnabled(int n2, boolean bl2) {
        ((a)this.b).setGroupEnabled(n2, bl2);
    }

    public void setGroupVisible(int n2, boolean bl2) {
        ((a)this.b).setGroupVisible(n2, bl2);
    }

    public void setQwertyMode(boolean bl2) {
        ((a)this.b).setQwertyMode(bl2);
    }

    public int size() {
        return ((a)this.b).size();
    }
}

