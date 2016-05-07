/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view;

import android.content.res.TypedArray;
import android.support.v4.h.al;
import android.support.v4.h.n;
import android.support.v7.b.l;
import android.support.v7.view.i;
import android.support.v7.view.j;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.o;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;

class k {
    final /* synthetic */ i a;
    private Menu b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private CharSequence l;
    private CharSequence m;
    private int n;
    private char o;
    private char p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private String w;
    private String x;
    private String y;
    private n z;

    public k(i i2, Menu menu) {
        this.a = i2;
        this.b = menu;
        this.a();
    }

    private char a(String string) {
        if (string != null) return string.charAt(0);
        return '\u0000';
    }

    static /* synthetic */ n a(k k2) {
        return k2.z;
    }

    private Object a(String string, Class[] arrclass, Object[] arrobject) {
        try {
            Constructor constructor = i.a(this.a).getClassLoader().loadClass(string).getConstructor(arrclass);
            constructor.setAccessible(true);
            return constructor.newInstance(arrobject);
        }
        catch (Exception var4_6) {
            Log.w((String)"SupportMenuInflater", (String)("Cannot instantiate class: " + string), (Throwable)var4_6);
            return null;
        }
    }

    private void a(MenuItem menuItem) {
        boolean bl2 = true;
        MenuItem menuItem2 = menuItem.setChecked(this.r).setVisible(this.s).setEnabled(this.t);
        boolean bl3 = this.q >= bl2 ? bl2 : false;
        menuItem2.setCheckable(bl3).setTitleCondensed(this.m).setIcon(this.n).setAlphabeticShortcut(this.o).setNumericShortcut(this.p);
        if (this.u >= 0) {
            al.a(menuItem, this.u);
        }
        if (this.y != null) {
            if (i.a(this.a).isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            menuItem.setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new j(i.c(this.a), this.y));
        }
        if (menuItem instanceof m) {
            (m)menuItem;
        }
        if (this.q >= 2) {
            if (menuItem instanceof m) {
                ((m)menuItem).a(bl2);
            } else if (menuItem instanceof o) {
                ((o)menuItem).a(bl2);
            }
        }
        if (this.w != null) {
            al.a(menuItem, (View)this.a(this.w, i.b(), i.d(this.a)));
        } else {
            bl2 = false;
        }
        if (this.v > 0) {
            if (!bl2) {
                al.b(menuItem, this.v);
            } else {
                Log.w((String)"SupportMenuInflater", (String)"Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            }
        }
        if (this.z == null) return;
        al.a(menuItem, this.z);
    }

    public void a() {
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = true;
        this.h = true;
    }

    public void a(AttributeSet attributeSet) {
        TypedArray typedArray = i.a(this.a).obtainStyledAttributes(attributeSet, l.MenuGroup);
        this.c = typedArray.getResourceId(l.MenuGroup_android_id, 0);
        this.d = typedArray.getInt(l.MenuGroup_android_menuCategory, 0);
        this.e = typedArray.getInt(l.MenuGroup_android_orderInCategory, 0);
        this.f = typedArray.getInt(l.MenuGroup_android_checkableBehavior, 0);
        this.g = typedArray.getBoolean(l.MenuGroup_android_visible, true);
        this.h = typedArray.getBoolean(l.MenuGroup_android_enabled, true);
        typedArray.recycle();
    }

    public void b() {
        this.i = true;
        this.a(this.b.add(this.c, this.j, this.k, this.l));
    }

    public void b(AttributeSet attributeSet) {
        int n2 = 1;
        TypedArray typedArray = i.a(this.a).obtainStyledAttributes(attributeSet, l.MenuItem);
        this.j = typedArray.getResourceId(l.MenuItem_android_id, 0);
        int n3 = typedArray.getInt(l.MenuItem_android_menuCategory, this.d);
        int n4 = typedArray.getInt(l.MenuItem_android_orderInCategory, this.e);
        this.k = n3 & -65536 | n4 & 65535;
        this.l = typedArray.getText(l.MenuItem_android_title);
        this.m = typedArray.getText(l.MenuItem_android_titleCondensed);
        this.n = typedArray.getResourceId(l.MenuItem_android_icon, 0);
        this.o = this.a(typedArray.getString(l.MenuItem_android_alphabeticShortcut));
        this.p = this.a(typedArray.getString(l.MenuItem_android_numericShortcut));
        if (typedArray.hasValue(l.MenuItem_android_checkable)) {
            int n5 = typedArray.getBoolean(l.MenuItem_android_checkable, false) ? n2 : 0;
            this.q = n5;
        } else {
            this.q = this.f;
        }
        this.r = typedArray.getBoolean(l.MenuItem_android_checked, false);
        this.s = typedArray.getBoolean(l.MenuItem_android_visible, this.g);
        this.t = typedArray.getBoolean(l.MenuItem_android_enabled, this.h);
        this.u = typedArray.getInt(l.MenuItem_showAsAction, -1);
        this.y = typedArray.getString(l.MenuItem_android_onClick);
        this.v = typedArray.getResourceId(l.MenuItem_actionLayout, 0);
        this.w = typedArray.getString(l.MenuItem_actionViewClass);
        this.x = typedArray.getString(l.MenuItem_actionProviderClass);
        if (this.x == null) {
            n2 = 0;
        }
        if (n2 != 0 && this.v == 0 && this.w == null) {
            this.z = (n)this.a(this.x, i.a(), i.b(this.a));
        } else {
            if (n2 != 0) {
                Log.w((String)"SupportMenuInflater", (String)"Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.z = null;
        }
        typedArray.recycle();
        this.i = false;
    }

    public SubMenu c() {
        this.i = true;
        SubMenu subMenu = this.b.addSubMenu(this.c, this.j, this.k, this.l);
        this.a(subMenu.getItem());
        return subMenu;
    }

    public boolean d() {
        return this.i;
    }
}

