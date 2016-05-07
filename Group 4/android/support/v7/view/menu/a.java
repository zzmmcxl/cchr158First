/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.b.c;
import android.support.v4.d.a.b;
import android.support.v4.h.aq;
import android.support.v4.h.n;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class a
implements b {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private CharSequence e;
    private CharSequence f;
    private Intent g;
    private char h;
    private char i;
    private Drawable j;
    private int k = 0;
    private Context l;
    private MenuItem.OnMenuItemClickListener m;
    private int n = 16;

    public a(Context context, int n2, int n3, int n4, int n5, CharSequence charSequence) {
        this.l = context;
        this.a = n3;
        this.b = n2;
        this.c = n4;
        this.d = n5;
        this.e = charSequence;
    }

    public b a(int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public b a(aq aq2) {
        return this;
    }

    @Override
    public b a(n n2) {
        throw new UnsupportedOperationException();
    }

    public b a(View view) {
        throw new UnsupportedOperationException();
    }

    @Override
    public n a() {
        return null;
    }

    public b b(int n2) {
        this.setShowAsAction(n2);
        return this;
    }

    @Override
    public boolean collapseActionView() {
        return false;
    }

    @Override
    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override
    public View getActionView() {
        return null;
    }

    public char getAlphabeticShortcut() {
        return this.i;
    }

    public int getGroupId() {
        return this.b;
    }

    public Drawable getIcon() {
        return this.j;
    }

    public Intent getIntent() {
        return this.g;
    }

    public int getItemId() {
        return this.a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.h;
    }

    public int getOrder() {
        return this.d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.e;
    }

    public CharSequence getTitleCondensed() {
        if (this.f == null) return this.e;
        return this.f;
    }

    public boolean hasSubMenu() {
        return false;
    }

    @Override
    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        if ((1 & this.n) == 0) return false;
        return true;
    }

    public boolean isChecked() {
        if ((2 & this.n) == 0) return false;
        return true;
    }

    public boolean isEnabled() {
        if ((16 & this.n) == 0) return false;
        return true;
    }

    public boolean isVisible() {
        if ((8 & this.n) != 0) return false;
        return true;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override
    public /* synthetic */ MenuItem setActionView(int n2) {
        return this.a(n2);
    }

    @Override
    public /* synthetic */ MenuItem setActionView(View view) {
        return this.a(view);
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.i = c2;
        return this;
    }

    public MenuItem setCheckable(boolean bl2) {
        int n2 = -2 & this.n;
        int n3 = bl2 ? 1 : 0;
        this.n = n3 | n2;
        return this;
    }

    public MenuItem setChecked(boolean bl2) {
        int n2 = -3 & this.n;
        int n3 = bl2 ? 2 : 0;
        this.n = n3 | n2;
        return this;
    }

    public MenuItem setEnabled(boolean bl2) {
        int n2 = -17 & this.n;
        int n3 = bl2 ? 16 : 0;
        this.n = n3 | n2;
        return this;
    }

    public MenuItem setIcon(int n2) {
        this.k = n2;
        this.j = c.a(this.l, n2);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.j = drawable;
        this.k = 0;
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.h = c2;
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.h = c2;
        this.i = c3;
        return this;
    }

    @Override
    public void setShowAsAction(int n2) {
    }

    @Override
    public /* synthetic */ MenuItem setShowAsActionFlags(int n2) {
        return this.b(n2);
    }

    public MenuItem setTitle(int n2) {
        this.e = this.l.getResources().getString(n2);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean bl2) {
        int n2 = 8 & this.n;
        int n3 = bl2 ? 0 : 8;
        this.n = n3 | n2;
        return this;
    }
}

