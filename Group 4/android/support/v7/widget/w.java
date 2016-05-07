/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.support.v7.widget.da;
import android.util.AttributeSet;
import android.view.ViewDebug;
import android.view.ViewGroup;

public class w
extends da {
    @ViewDebug.ExportedProperty
    public boolean a;
    @ViewDebug.ExportedProperty
    public int b;
    @ViewDebug.ExportedProperty
    public int c;
    @ViewDebug.ExportedProperty
    public boolean d;
    @ViewDebug.ExportedProperty
    public boolean e;
    boolean f;

    public w(int n2, int n3) {
        super(n2, n3);
        this.a = false;
    }

    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public w(w w2) {
        super((ViewGroup.LayoutParams)w2);
        this.a = w2.a;
    }

    public w(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }
}

