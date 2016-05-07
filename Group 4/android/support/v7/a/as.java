/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.a.v;
import android.support.v7.a.w;
import android.support.v7.b.b;
import android.support.v7.view.c;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

public class as
extends Dialog
implements v {
    private w a;

    public as(Context context, int n2) {
        super(context, as.a(context, n2));
        this.a().a((Bundle)null);
        this.a().h();
    }

    private static int a(Context context, int n2) {
        if (n2 != 0) return n2;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public w a() {
        if (this.a != null) return this.a;
        this.a = w.a(this, (v)this);
        return this.a;
    }

    @Override
    public android.support.v7.view.b a(c c2) {
        return null;
    }

    @Override
    public void a(android.support.v7.view.b b2) {
    }

    public boolean a(int n2) {
        return this.a().b(n2);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.a().b(view, layoutParams);
    }

    @Override
    public void b(android.support.v7.view.b b2) {
    }

    public void invalidateOptionsMenu() {
        this.a().e();
    }

    protected void onCreate(Bundle bundle) {
        this.a().g();
        super.onCreate(bundle);
        this.a().a(bundle);
    }

    protected void onStop() {
        super.onStop();
        this.a().c();
    }

    public void setContentView(int n2) {
        this.a().a(n2);
    }

    public void setContentView(View view) {
        this.a().a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.a().a(view, layoutParams);
    }

    public void setTitle(int n2) {
        super.setTitle(n2);
        this.a().a(this.getContext().getString(n2));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.a().a(charSequence);
    }
}

