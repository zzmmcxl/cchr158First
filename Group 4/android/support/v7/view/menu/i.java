/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.b.c;
import android.support.v4.d.a.a;
import android.support.v4.h.al;
import android.support.v4.h.n;
import android.support.v7.view.menu.ad;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.x;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class i
implements a {
    private static final int[] d = new int[]{1, 4, 5, 3, 2, 0};
    CharSequence a;
    Drawable b;
    View c;
    private final Context e;
    private final Resources f;
    private boolean g;
    private boolean h;
    private j i;
    private ArrayList j;
    private ArrayList k;
    private boolean l;
    private ArrayList m;
    private ArrayList n;
    private boolean o;
    private int p = 0;
    private ContextMenu.ContextMenuInfo q;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private ArrayList v = new ArrayList();
    private CopyOnWriteArrayList w = new CopyOnWriteArrayList();
    private m x;
    private boolean y;

    public i(Context context) {
        this.e = context;
        this.f = context.getResources();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = true;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = true;
        this.e(true);
    }

    private static int a(ArrayList arrayList, int n2) {
        int n3 = -1 + arrayList.size();
        while (n3 >= 0) {
            if (((m)arrayList.get(n3)).c() <= n2) {
                return n3 + 1;
            }
            --n3;
        }
        return 0;
    }

    private m a(int n2, int n3, int n4, int n5, CharSequence charSequence, int n6) {
        return new m(this, n2, n3, n4, n5, charSequence, n6);
    }

    private void a(int n2, CharSequence charSequence, int n3, Drawable drawable, View view) {
        Resources resources = this.d();
        if (view != null) {
            this.c = view;
            this.a = null;
            this.b = null;
        } else {
            if (n2 > 0) {
                this.a = resources.getText(n2);
            } else if (charSequence != null) {
                this.a = charSequence;
            }
            if (n3 > 0) {
                this.b = c.a(this.e(), n3);
            } else if (drawable != null) {
                this.b = drawable;
            }
            this.c = null;
        }
        this.b(false);
    }

    private void a(int n2, boolean bl2) {
        if (n2 < 0) return;
        if (n2 >= this.j.size()) {
            return;
        }
        this.j.remove(n2);
        if (!bl2) return;
        this.b(true);
    }

    private boolean a(ad ad2, x x2) {
        if (this.w.isEmpty()) {
            return false;
        }
        boolean bl2 = false;
        if (x2 != null) {
            bl2 = x2.a(ad2);
        }
        Iterator iterator = this.w.iterator();
        boolean bl3 = bl2;
        while (iterator.hasNext()) {
            boolean bl4;
            WeakReference weakReference = (WeakReference)iterator.next();
            x x3 = (x)weakReference.get();
            if (x3 == null) {
                this.w.remove(weakReference);
                bl4 = bl3;
            } else {
                bl4 = !bl3 ? x3.a(ad2) : bl3;
            }
            bl3 = bl4;
        }
        return bl3;
    }

    private static int d(int n2) {
        int n3 = (-65536 & n2) >> 16;
        if (n3 < 0) throw new IllegalArgumentException("order does not contain a valid category.");
        if (n3 < d.length) return d[n3] << 16 | 65535 & n2;
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void d(boolean bl2) {
        if (this.w.isEmpty()) {
            return;
        }
        this.g();
        Iterator iterator = this.w.iterator();
        do {
            if (!iterator.hasNext()) {
                this.h();
                return;
            }
            WeakReference weakReference = (WeakReference)iterator.next();
            x x2 = (x)weakReference.get();
            if (x2 == null) {
                this.w.remove(weakReference);
                continue;
            }
            x2.b(bl2);
        } while (true);
    }

    private void e(boolean bl2) {
        int n2 = 1;
        if (!bl2 || this.f.getConfiguration().keyboard == n2 || !this.f.getBoolean(android.support.v7.b.c.abc_config_showMenuShortcutsWhenKeyboardPresent)) {
            n2 = 0;
        }
        this.h = n2;
    }

    public int a(int n2, int n3) {
        int n4 = this.size();
        if (n3 < 0) {
            n3 = 0;
        }
        int n5 = n3;
        while (n5 < n4) {
            if (((m)this.j.get(n5)).getGroupId() == n2) {
                return n5;
            }
            ++n5;
        }
        return -1;
    }

    public i a(int n2) {
        this.p = n2;
        return this;
    }

    protected i a(Drawable drawable) {
        this.a(0, null, 0, drawable, null);
        return this;
    }

    protected i a(View view) {
        this.a(0, null, 0, null, view);
        return this;
    }

    protected i a(CharSequence charSequence) {
        this.a(0, charSequence, 0, null, null);
        return this;
    }

    m a(int n2, KeyEvent keyEvent) {
        ArrayList arrayList = this.v;
        arrayList.clear();
        this.a(arrayList, n2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int n3 = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int n4 = arrayList.size();
        if (n4 == 1) {
            return (m)arrayList.get(0);
        }
        boolean bl2 = this.b();
        int n5 = 0;
        while (n5 < n4) {
            m m2 = (m)arrayList.get(n5);
            char c2 = bl2 ? m2.getAlphabeticShortcut() : m2.getNumericShortcut();
            if (c2 == keyData.meta[0]) {
                if ((n3 & 2) == 0) return m2;
            }
            if (c2 == keyData.meta[2]) {
                if ((n3 & 2) != 0) return m2;
            }
            if (bl2 && c2 == '\b') {
                if (n2 == 67) return m2;
            }
            ++n5;
        }
        return null;
    }

    protected MenuItem a(int n2, int n3, int n4, CharSequence charSequence) {
        int n5 = i.d(n4);
        m m2 = this.a(n2, n3, n4, n5, charSequence, this.p);
        if (this.q != null) {
            m2.a(this.q);
        }
        this.j.add(i.a(this.j, n5), m2);
        this.b(true);
        return m2;
    }

    protected String a() {
        return "android:menu:actionviewstates";
    }

    public void a(Bundle bundle) {
        int n2 = this.size();
        int n3 = 0;
        SparseArray sparseArray = null;
        while (n3 < n2) {
            MenuItem menuItem = this.getItem(n3);
            View view = al.a(menuItem);
            if (view != null && view.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                view.saveHierarchyState(sparseArray);
                if (al.c(menuItem)) {
                    bundle.putInt("android:menu:expandedactionview", menuItem.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (menuItem.hasSubMenu()) {
                ((ad)menuItem.getSubMenu()).a(bundle);
            }
            ++n3;
            sparseArray = sparseArray2;
        }
    }

    public void a(j j2) {
        this.i = j2;
    }

    void a(m m2) {
        this.l = true;
        this.b(true);
    }

    public void a(x x2) {
        this.a(x2, this.e);
    }

    public void a(x x2, Context context) {
        this.w.add(new WeakReference<x>(x2));
        x2.a(context, this);
        this.o = true;
    }

    void a(MenuItem menuItem) {
        int n2 = menuItem.getGroupId();
        int n3 = this.j.size();
        int n4 = 0;
        while (n4 < n3) {
            m m2 = (m)this.j.get(n4);
            if (m2.getGroupId() == n2 && m2.g() && m2.isCheckable()) {
                boolean bl2 = m2 == menuItem;
                m2.b(bl2);
            }
            ++n4;
        }
    }

    void a(List list, int n2, KeyEvent keyEvent) {
        boolean bl2 = this.b();
        int n3 = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (!keyEvent.getKeyData(keyData) && n2 != 67) {
            return;
        }
        int n4 = this.j.size();
        int n5 = 0;
        while (n5 < n4) {
            m m2 = (m)this.j.get(n5);
            if (m2.hasSubMenu()) {
                ((i)m2.getSubMenu()).a(list, n2, keyEvent);
            }
            char c2 = bl2 ? m2.getAlphabeticShortcut() : m2.getNumericShortcut();
            if ((n3 & 5) == 0 && c2 != '\u0000' && (c2 == keyData.meta[0] || c2 == keyData.meta[2] || bl2 && c2 == '\b' && n2 == 67) && m2.isEnabled()) {
                list.add(m2);
            }
            ++n5;
        }
    }

    public final void a(boolean bl2) {
        if (this.u) {
            return;
        }
        this.u = true;
        Iterator iterator = this.w.iterator();
        do {
            if (!iterator.hasNext()) {
                this.u = false;
                return;
            }
            WeakReference weakReference = (WeakReference)iterator.next();
            x x2 = (x)weakReference.get();
            if (x2 == null) {
                this.w.remove(weakReference);
                continue;
            }
            x2.a(this, bl2);
        } while (true);
    }

    boolean a(i i2, MenuItem menuItem) {
        if (this.i == null) return false;
        if (!this.i.a(i2, menuItem)) return false;
        return true;
    }

    public boolean a(MenuItem menuItem, int n2) {
        return this.a(menuItem, null, n2);
    }

    public boolean a(MenuItem menuItem, x x2, int n2) {
        m m2 = (m)menuItem;
        boolean bl2 = false;
        if (m2 == null) return bl2;
        boolean bl3 = m2.isEnabled();
        bl2 = false;
        if (!bl3) {
            return bl2;
        }
        boolean bl4 = m2.b();
        n n3 = m2.a();
        boolean bl5 = n3 != null && n3.e();
        if (m2.n()) {
            bl2 = bl4 | m2.expandActionView();
            if (!bl2) return bl2;
            this.a(true);
            return bl2;
        }
        if (!m2.hasSubMenu() && !bl5) {
            if ((n2 & 1) != 0) return bl4;
            this.a(true);
            return bl4;
        }
        this.a(false);
        if (!m2.hasSubMenu()) {
            m2.a(new ad(this.e(), this, m2));
        }
        ad ad2 = (ad)m2.getSubMenu();
        if (bl5) {
            n3.a(ad2);
        }
        if (bl2 = bl4 | this.a(ad2, x2)) return bl2;
        this.a(true);
        return bl2;
    }

    public MenuItem add(int n2) {
        return this.a(0, 0, 0, this.f.getString(n2));
    }

    public MenuItem add(int n2, int n3, int n4, int n5) {
        return this.a(n2, n3, n4, this.f.getString(n5));
    }

    public MenuItem add(int n2, int n3, int n4, CharSequence charSequence) {
        return this.a(n2, n3, n4, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return this.a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int n2, int n3, int n4, ComponentName componentName, Intent[] arrintent, Intent intent, int n5, MenuItem[] arrmenuItem) {
        PackageManager packageManager = this.e.getPackageManager();
        List list = packageManager.queryIntentActivityOptions(componentName, arrintent, intent, 0);
        int n6 = list != null ? list.size() : 0;
        if ((n5 & 1) == 0) {
            this.removeGroup(n2);
        }
        int n7 = 0;
        while (n7 < n6) {
            ResolveInfo resolveInfo = (ResolveInfo)list.get(n7);
            Intent intent2 = resolveInfo.specificIndex < 0 ? intent : arrintent[resolveInfo.specificIndex];
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem menuItem = this.add(n2, n3, n4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (arrmenuItem != null && resolveInfo.specificIndex >= 0) {
                arrmenuItem[resolveInfo.specificIndex] = menuItem;
            }
            ++n7;
        }
        return n6;
    }

    public SubMenu addSubMenu(int n2) {
        return this.addSubMenu(0, 0, 0, this.f.getString(n2));
    }

    public SubMenu addSubMenu(int n2, int n3, int n4, int n5) {
        return this.addSubMenu(n2, n3, n4, this.f.getString(n5));
    }

    public SubMenu addSubMenu(int n2, int n3, int n4, CharSequence charSequence) {
        m m2 = (m)this.a(n2, n3, n4, charSequence);
        ad ad2 = new ad(this.e, this, m2);
        m2.a(ad2);
        return ad2;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return this.addSubMenu(0, 0, 0, charSequence);
    }

    public int b(int n2) {
        int n3 = this.size();
        int n4 = 0;
        while (n4 < n3) {
            if (((m)this.j.get(n4)).getItemId() == n2) {
                return n4;
            }
            ++n4;
        }
        return -1;
    }

    public void b(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        SparseArray sparseArray = bundle.getSparseParcelableArray(this.a());
        int n2 = this.size();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                int n4 = bundle.getInt("android:menu:expandedactionview");
                if (n4 <= 0) return;
                MenuItem menuItem = this.findItem(n4);
                if (menuItem == null) return;
                al.b(menuItem);
                return;
            }
            MenuItem menuItem = this.getItem(n3);
            View view = al.a(menuItem);
            if (view != null && view.getId() != -1) {
                view.restoreHierarchyState(sparseArray);
            }
            if (menuItem.hasSubMenu()) {
                ((ad)menuItem.getSubMenu()).b(bundle);
            }
            ++n3;
        } while (true);
    }

    void b(m m2) {
        this.o = true;
        this.b(true);
    }

    public void b(x x2) {
        Iterator iterator = this.w.iterator();
        while (iterator.hasNext()) {
            WeakReference weakReference = (WeakReference)iterator.next();
            x x3 = (x)weakReference.get();
            if (x3 != null && x3 != x2) continue;
            this.w.remove(weakReference);
        }
    }

    public void b(boolean bl2) {
        if (this.r) {
            this.s = true;
            return;
        }
        if (bl2) {
            this.l = true;
            this.o = true;
        }
        this.d(bl2);
    }

    boolean b() {
        return this.g;
    }

    public int c(int n2) {
        return this.a(n2, 0);
    }

    public void c(boolean bl2) {
        this.y = bl2;
    }

    public boolean c() {
        return this.h;
    }

    /*
     * Unable to fully structure code
     */
    public boolean c(m var1_1) {
        block3 : {
            var2_2 = this.w.isEmpty();
            var3_3 = false;
            if (var2_2) {
                return var3_3;
            }
            this.g();
            var4_4 = this.w.iterator();
            var5_5 = false;
            while (var4_4.hasNext()) {
                var6_6 = (WeakReference)var4_4.next();
                var7_7 = (x)var6_6.get();
                if (var7_7 != null) ** GOTO lbl15
                this.w.remove(var6_6);
                var3_3 = var5_5;
                ** GOTO lbl-1000
lbl15: // 1 sources:
                var3_3 = var7_7.a(this, var1_1);
                if (!var3_3) lbl-1000: // 2 sources:
                {
                    var5_5 = var3_3;
                    continue;
                }
                break block3;
            }
            var3_3 = var5_5;
        }
        this.h();
        if (var3_3 == false) return var3_3;
        this.x = var1_1;
        return var3_3;
    }

    public void clear() {
        if (this.x != null) {
            this.d(this.x);
        }
        this.j.clear();
        this.b(true);
    }

    public void clearHeader() {
        this.b = null;
        this.a = null;
        this.c = null;
        this.b(false);
    }

    public void close() {
        this.a(true);
    }

    Resources d() {
        return this.f;
    }

    /*
     * Unable to fully structure code
     */
    public boolean d(m var1_1) {
        block3 : {
            var2_2 = this.w.isEmpty();
            var3_3 = false;
            if (var2_2 != false) return var3_3;
            var4_4 = this.x;
            var3_3 = false;
            if (var4_4 != var1_1) {
                return var3_3;
            }
            this.g();
            var5_5 = this.w.iterator();
            var6_6 = false;
            while (var5_5.hasNext()) {
                var7_7 = (WeakReference)var5_5.next();
                var8_8 = (x)var7_7.get();
                if (var8_8 != null) ** GOTO lbl18
                this.w.remove(var7_7);
                var3_3 = var6_6;
                ** GOTO lbl-1000
lbl18: // 1 sources:
                var3_3 = var8_8.b(this, var1_1);
                if (!var3_3) lbl-1000: // 2 sources:
                {
                    var6_6 = var3_3;
                    continue;
                }
                break block3;
            }
            var3_3 = var6_6;
        }
        this.h();
        if (var3_3 == false) return var3_3;
        this.x = null;
        return var3_3;
    }

    public Context e() {
        return this.e;
    }

    public void f() {
        if (this.i == null) return;
        this.i.a(this);
    }

    public MenuItem findItem(int n2) {
        int n3 = this.size();
        int n4 = 0;
        while (n4 < n3) {
            m m2 = (m)this.j.get(n4);
            if (m2.getItemId() == n2) {
                return m2;
            }
            if (m2.hasSubMenu()) {
                if ((m2 = m2.getSubMenu().findItem(n2)) != null) return m2;
            }
            ++n4;
        }
        return null;
    }

    public void g() {
        if (this.r) return;
        this.r = true;
        this.s = false;
    }

    public MenuItem getItem(int n2) {
        return (MenuItem)this.j.get(n2);
    }

    public void h() {
        this.r = false;
        if (!this.s) return;
        this.s = false;
        this.b(true);
    }

    public boolean hasVisibleItems() {
        if (this.y) {
            return true;
        }
        int n2 = this.size();
        int n3 = 0;
        while (n3 < n2) {
            if (((m)this.j.get(n3)).isVisible()) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public ArrayList i() {
        if (!this.l) {
            return this.k;
        }
        this.k.clear();
        int n2 = this.j.size();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.l = false;
                this.o = true;
                return this.k;
            }
            m m2 = (m)this.j.get(n3);
            if (m2.isVisible()) {
                this.k.add(m2);
            }
            ++n3;
        } while (true);
    }

    public boolean isShortcutKey(int n2, KeyEvent keyEvent) {
        if (this.a(n2, keyEvent) == null) return false;
        return true;
    }

    public void j() {
        ArrayList arrayList = this.i();
        if (!this.o) {
            return;
        }
        Iterator iterator = this.w.iterator();
        boolean bl2 = false;
        do {
            boolean bl3;
            if (!iterator.hasNext()) {
                this.m.clear();
                this.n.clear();
                this.n.addAll(this.i());
                this.o = false;
                return;
            }
            WeakReference weakReference = (WeakReference)iterator.next();
            x x2 = (x)weakReference.get();
            if (x2 == null) {
                this.w.remove(weakReference);
                bl3 = bl2;
            } else {
                bl3 = bl2 | x2.b();
            }
            bl2 = bl3;
        } while (true);
    }

    public ArrayList k() {
        this.j();
        return this.m;
    }

    public ArrayList l() {
        this.j();
        return this.n;
    }

    public CharSequence m() {
        return this.a;
    }

    public Drawable n() {
        return this.b;
    }

    public View o() {
        return this.c;
    }

    public i p() {
        return this;
    }

    public boolean performIdentifierAction(int n2, int n3) {
        return this.a(this.findItem(n2), n3);
    }

    public boolean performShortcut(int n2, KeyEvent keyEvent, int n3) {
        m m2 = this.a(n2, keyEvent);
        boolean bl2 = false;
        if (m2 != null) {
            bl2 = this.a(m2, n3);
        }
        if ((n3 & 2) == 0) return bl2;
        this.a(true);
        return bl2;
    }

    boolean q() {
        return this.t;
    }

    public m r() {
        return this.x;
    }

    public void removeGroup(int n2) {
        int n3 = this.c(n2);
        if (n3 < 0) return;
        int n4 = this.j.size() - n3;
        int n5 = 0;
        do {
            int n6 = n5 + 1;
            if (n5 >= n4 || ((m)this.j.get(n3)).getGroupId() != n2) break;
            this.a(n3, false);
            n5 = n6;
        } while (true);
        this.b(true);
    }

    public void removeItem(int n2) {
        this.a(this.b(n2), true);
    }

    public void setGroupCheckable(int n2, boolean bl2, boolean bl3) {
        int n3 = this.j.size();
        int n4 = 0;
        while (n4 < n3) {
            m m2 = (m)this.j.get(n4);
            if (m2.getGroupId() == n2) {
                m2.a(bl3);
                m2.setCheckable(bl2);
            }
            ++n4;
        }
    }

    public void setGroupEnabled(int n2, boolean bl2) {
        int n3 = this.j.size();
        int n4 = 0;
        while (n4 < n3) {
            m m2 = (m)this.j.get(n4);
            if (m2.getGroupId() == n2) {
                m2.setEnabled(bl2);
            }
            ++n4;
        }
    }

    public void setGroupVisible(int n2, boolean bl2) {
        int n3 = this.j.size();
        int n4 = 0;
        boolean bl3 = false;
        while (n4 < n3) {
            m m2 = (m)this.j.get(n4);
            boolean bl4 = m2.getGroupId() == n2 && m2.c(bl2) ? true : bl3;
            ++n4;
            bl3 = bl4;
        }
    }

    public void setQwertyMode(boolean bl2) {
        this.g = bl2;
        this.b(false);
    }

    public int size() {
        return this.j.size();
    }
}

