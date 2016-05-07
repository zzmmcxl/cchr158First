/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.m;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class ar
extends m {
    private int j;
    private int k;
    private LayoutInflater l;

    public ar(Context context, int n2, Cursor cursor, boolean bl2) {
        super(context, cursor, bl2);
        this.k = n2;
        this.j = n2;
        this.l = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    @Override
    public View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.l.inflate(this.j, viewGroup, false);
    }

    @Override
    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.l.inflate(this.k, viewGroup, false);
    }
}

