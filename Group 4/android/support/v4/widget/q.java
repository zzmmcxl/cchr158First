/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.database.Cursor;
import android.support.v4.widget.r;
import android.widget.Filter;

class q
extends Filter {
    r a;

    q(r r2) {
        this.a = r2;
    }

    public CharSequence convertResultToString(Object object) {
        return this.a.c((Cursor)object);
    }

    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursor = this.a.a(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursor != null) {
            filterResults.count = cursor.getCount();
            filterResults.values = cursor;
            return filterResults;
        }
        filterResults.count = 0;
        filterResults.values = null;
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursor = this.a.a();
        if (filterResults.values == null) return;
        if (filterResults.values == cursor) return;
        this.a.a((Cursor)filterResults.values);
    }
}

