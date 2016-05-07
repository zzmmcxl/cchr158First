/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.support.v7.b.k;
import android.view.LayoutInflater;

public class e
extends ContextWrapper {
    private int a;
    private Resources.Theme b;
    private LayoutInflater c;

    public e(Context context, int n2) {
        super(context);
        this.a = n2;
    }

    public e(Context context, Resources.Theme theme) {
        super(context);
        this.b = theme;
    }

    private void b() {
        boolean bl2 = this.b == null;
        if (bl2) {
            this.b = this.getResources().newTheme();
            Resources.Theme theme = this.getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        this.a(this.b, this.a, bl2);
    }

    public int a() {
        return this.a;
    }

    protected void a(Resources.Theme theme, int n2, boolean bl2) {
        theme.applyStyle(n2, true);
    }

    public Object getSystemService(String string) {
        if (!"layout_inflater".equals(string)) return this.getBaseContext().getSystemService(string);
        if (this.c != null) return this.c;
        this.c = LayoutInflater.from((Context)this.getBaseContext()).cloneInContext((Context)this);
        return this.c;
    }

    public Resources.Theme getTheme() {
        if (this.b != null) {
            return this.b;
        }
        if (this.a == 0) {
            this.a = k.Theme_AppCompat_Light;
        }
        this.b();
        return this.b;
    }

    public void setTheme(int n2) {
        if (this.a == n2) return;
        this.a = n2;
        this.b();
    }
}

