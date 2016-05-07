/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.d.a.b;
import android.support.v4.h.aq;
import android.support.v4.h.n;
import android.support.v7.view.menu.e;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.q;
import android.support.v7.view.menu.r;
import android.support.v7.view.menu.s;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

@TargetApi(value=14)
public class o
extends e
implements MenuItem {
    private Method c;

    o(Context context, b b2) {
        super(context, b2);
    }

    p a(ActionProvider actionProvider) {
        return new p(this, this.a, actionProvider);
    }

    public void a(boolean bl2) {
        try {
            if (this.c == null) {
                Class class_ = ((b)this.b).getClass();
                Class[] arrclass = new Class[]{Boolean.TYPE};
                this.c = class_.getDeclaredMethod("setExclusiveCheckable", arrclass);
            }
            Method method = this.c;
            Object object = this.b;
            Object[] arrobject = new Object[]{bl2};
            method.invoke(object, arrobject);
            return;
        }
        catch (Exception var2_7) {
            Log.w((String)"MenuItemWrapper", (String)"Error while calling setExclusiveCheckable", (Throwable)var2_7);
            return;
        }
    }

    public boolean collapseActionView() {
        return ((b)this.b).collapseActionView();
    }

    public boolean expandActionView() {
        return ((b)this.b).expandActionView();
    }

    public ActionProvider getActionProvider() {
        n n2 = ((b)this.b).a();
        if (!(n2 instanceof p)) return null;
        return ((p)n2).a;
    }

    public View getActionView() {
        View view = ((b)this.b).getActionView();
        if (!(view instanceof q)) return view;
        return ((q)view).c();
    }

    public char getAlphabeticShortcut() {
        return ((b)this.b).getAlphabeticShortcut();
    }

    public int getGroupId() {
        return ((b)this.b).getGroupId();
    }

    public Drawable getIcon() {
        return ((b)this.b).getIcon();
    }

    public Intent getIntent() {
        return ((b)this.b).getIntent();
    }

    public int getItemId() {
        return ((b)this.b).getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((b)this.b).getMenuInfo();
    }

    public char getNumericShortcut() {
        return ((b)this.b).getNumericShortcut();
    }

    public int getOrder() {
        return ((b)this.b).getOrder();
    }

    public SubMenu getSubMenu() {
        return this.a(((b)this.b).getSubMenu());
    }

    public CharSequence getTitle() {
        return ((b)this.b).getTitle();
    }

    public CharSequence getTitleCondensed() {
        return ((b)this.b).getTitleCondensed();
    }

    public boolean hasSubMenu() {
        return ((b)this.b).hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return ((b)this.b).isActionViewExpanded();
    }

    public boolean isCheckable() {
        return ((b)this.b).isCheckable();
    }

    public boolean isChecked() {
        return ((b)this.b).isChecked();
    }

    public boolean isEnabled() {
        return ((b)this.b).isEnabled();
    }

    public boolean isVisible() {
        return ((b)this.b).isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        b b2 = (b)this.b;
        p p2 = actionProvider != null ? this.a(actionProvider) : null;
        b2.a(p2);
        return this;
    }

    public MenuItem setActionView(int n2) {
        ((b)this.b).setActionView(n2);
        View view = ((b)this.b).getActionView();
        if (!(view instanceof CollapsibleActionView)) return this;
        ((b)this.b).setActionView((View)new q(view));
        return this;
    }

    public MenuItem setActionView(View object) {
        if (object instanceof CollapsibleActionView) {
            object = new q((View)object);
        }
        ((b)this.b).setActionView((View)object);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        ((b)this.b).setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setCheckable(boolean bl2) {
        ((b)this.b).setCheckable(bl2);
        return this;
    }

    public MenuItem setChecked(boolean bl2) {
        ((b)this.b).setChecked(bl2);
        return this;
    }

    public MenuItem setEnabled(boolean bl2) {
        ((b)this.b).setEnabled(bl2);
        return this;
    }

    public MenuItem setIcon(int n2) {
        ((b)this.b).setIcon(n2);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        ((b)this.b).setIcon(drawable);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        ((b)this.b).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        ((b)this.b).setNumericShortcut(c2);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        b b2 = (b)this.b;
        r r2 = onActionExpandListener != null ? new r(this, onActionExpandListener) : null;
        b2.a(r2);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        b b2 = (b)this.b;
        s s2 = onMenuItemClickListener != null ? new s(this, onMenuItemClickListener) : null;
        b2.setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)s2);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        ((b)this.b).setShortcut(c2, c3);
        return this;
    }

    public void setShowAsAction(int n2) {
        ((b)this.b).setShowAsAction(n2);
    }

    public MenuItem setShowAsActionFlags(int n2) {
        ((b)this.b).setShowAsActionFlags(n2);
        return this;
    }

    public MenuItem setTitle(int n2) {
        ((b)this.b).setTitle(n2);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((b)this.b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((b)this.b).setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean bl2) {
        return ((b)this.b).setVisible(bl2);
    }
}

