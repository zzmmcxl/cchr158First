/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.a.e;
import android.support.v7.a.k;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ListView;

class m
extends CursorAdapter {
    final /* synthetic */ ListView a;
    final /* synthetic */ e b;
    final /* synthetic */ k c;
    private final int d;
    private final int e;

    m(k k2, Context context, Cursor cursor, boolean bl2, ListView listView, e e2) {
        this.c = k2;
        this.a = listView;
        this.b = e2;
        super(context, cursor, bl2);
        Cursor cursor2 = this.getCursor();
        this.d = cursor2.getColumnIndexOrThrow(this.c.I);
        this.e = cursor2.getColumnIndexOrThrow(this.c.J);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView)view.findViewById(16908308)).setText((CharSequence)cursor.getString(this.d));
        ListView listView = this.a;
        int n2 = cursor.getPosition();
        boolean bl2 = cursor.getInt(this.e) == 1;
        listView.setItemChecked(n2, bl2);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.c.b.inflate(e.l(this.b), viewGroup, false);
    }
}

