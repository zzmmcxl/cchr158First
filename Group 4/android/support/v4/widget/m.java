/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.support.v4.widget.n;
import android.support.v4.widget.o;
import android.support.v4.widget.p;
import android.support.v4.widget.q;
import android.support.v4.widget.r;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class m
extends BaseAdapter
implements r,
Filterable {
    protected boolean a;
    protected boolean b;
    protected Cursor c;
    protected Context d;
    protected int e;
    protected o f;
    protected DataSetObserver g;
    protected q h;
    protected FilterQueryProvider i;

    public m(Context context, Cursor cursor, boolean bl2) {
        int n2 = bl2 ? 1 : 2;
        this.a(context, cursor, n2);
    }

    @Override
    public Cursor a() {
        return this.c;
    }

    @Override
    public Cursor a(CharSequence charSequence) {
        if (this.i == null) return this.c;
        return this.i.runQuery(charSequence);
    }

    public abstract View a(Context var1, Cursor var2, ViewGroup var3);

    void a(Context context, Cursor cursor, int n2) {
        int n3 = 1;
        if ((n2 & 1) == n3) {
            n2 |= 2;
            this.b = n3;
        } else {
            this.b = false;
        }
        if (cursor == null) {
            n3 = 0;
        }
        this.c = cursor;
        this.a = n3;
        this.d = context;
        int n4 = n3 != 0 ? cursor.getColumnIndexOrThrow("_id") : -1;
        this.e = n4;
        if ((n2 & 2) == 2) {
            this.f = new o(this);
            this.g = new p(this, null);
        } else {
            this.f = null;
            this.g = null;
        }
        if (n3 == 0) return;
        if (this.f != null) {
            cursor.registerContentObserver((ContentObserver)this.f);
        }
        if (this.g == null) return;
        cursor.registerDataSetObserver(this.g);
    }

    @Override
    public void a(Cursor cursor) {
        Cursor cursor2 = this.b(cursor);
        if (cursor2 == null) return;
        cursor2.close();
    }

    public abstract void a(View var1, Context var2, Cursor var3);

    public Cursor b(Cursor cursor) {
        if (cursor == this.c) {
            return null;
        }
        Cursor cursor2 = this.c;
        if (cursor2 != null) {
            if (this.f != null) {
                cursor2.unregisterContentObserver((ContentObserver)this.f);
            }
            if (this.g != null) {
                cursor2.unregisterDataSetObserver(this.g);
            }
        }
        this.c = cursor;
        if (cursor == null) {
            this.e = -1;
            this.a = false;
            this.notifyDataSetInvalidated();
            return cursor2;
        }
        if (this.f != null) {
            cursor.registerContentObserver((ContentObserver)this.f);
        }
        if (this.g != null) {
            cursor.registerDataSetObserver(this.g);
        }
        this.e = cursor.getColumnIndexOrThrow("_id");
        this.a = true;
        this.notifyDataSetChanged();
        return cursor2;
    }

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.a(context, cursor, viewGroup);
    }

    protected void b() {
        if (!this.b) return;
        if (this.c == null) return;
        if (this.c.isClosed()) return;
        this.a = this.c.requery();
    }

    @Override
    public CharSequence c(Cursor cursor) {
        if (cursor != null) return cursor.toString();
        return "";
    }

    public int getCount() {
        if (!this.a) return 0;
        if (this.c == null) return 0;
        return this.c.getCount();
    }

    public View getDropDownView(int n2, View view, ViewGroup viewGroup) {
        if (!this.a) return null;
        this.c.moveToPosition(n2);
        if (view == null) {
            view = this.b(this.d, this.c, viewGroup);
        }
        this.a(view, this.d, this.c);
        return view;
    }

    public Filter getFilter() {
        if (this.h != null) return this.h;
        this.h = new q(this);
        return this.h;
    }

    public Object getItem(int n2) {
        if (!this.a) return null;
        if (this.c == null) return null;
        this.c.moveToPosition(n2);
        return this.c;
    }

    public long getItemId(int n2) {
        long l2 = 0;
        if (!this.a) return l2;
        if (this.c == null) return l2;
        if (!this.c.moveToPosition(n2)) return l2;
        return this.c.getLong(this.e);
    }

    public View getView(int n2, View view, ViewGroup viewGroup) {
        if (!this.a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.c.moveToPosition(n2)) {
            throw new IllegalStateException("couldn't move cursor to position " + n2);
        }
        if (view == null) {
            view = this.a(this.d, this.c, viewGroup);
        }
        this.a(view, this.d, this.c);
        return view;
    }

    public boolean hasStableIds() {
        return true;
    }
}

