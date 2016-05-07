/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.av;
import android.support.design.widget.z;

class ac
implements av {
    final /* synthetic */ FloatingActionButton a;

    private ac(FloatingActionButton floatingActionButton) {
        this.a = floatingActionButton;
    }

    /* synthetic */ ac(FloatingActionButton floatingActionButton, z z2) {
        this(floatingActionButton);
    }

    @Override
    public float a() {
        return (float)this.a.getSizeDimension() / 2.0f;
    }

    @Override
    public void a(int n2, int n3, int n4, int n5) {
        FloatingActionButton.a(this.a).set(n2, n3, n4, n5);
        this.a.setPadding(n2 + FloatingActionButton.b(this.a), n3 + FloatingActionButton.b(this.a), n4 + FloatingActionButton.b(this.a), n5 + FloatingActionButton.b(this.a));
    }

    @Override
    public void a(Drawable drawable) {
        FloatingActionButton.a(this.a, drawable);
    }

    @Override
    public boolean b() {
        return FloatingActionButton.c(this.a);
    }
}

