/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.res.Resources;
import android.database.DataSetObserver;
import android.support.v7.widget.bj;
import android.support.v7.widget.gg;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

class bl
implements ListAdapter,
SpinnerAdapter {
    private SpinnerAdapter a;
    private ListAdapter b;

    public bl(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
        this.a = spinnerAdapter;
        if (spinnerAdapter instanceof ListAdapter) {
            this.b = (ListAdapter)spinnerAdapter;
        }
        if (theme == null) return;
        if (bj.a() && spinnerAdapter instanceof ThemedSpinnerAdapter) {
            ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter)spinnerAdapter;
            if (themedSpinnerAdapter.getDropDownViewTheme() == theme) return;
            themedSpinnerAdapter.setDropDownViewTheme(theme);
            return;
        }
        if (!(spinnerAdapter instanceof gg)) return;
        gg gg2 = (gg)spinnerAdapter;
        if (gg2.a() != null) return;
        gg2.a(theme);
    }

    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.b;
        if (listAdapter == null) return true;
        return listAdapter.areAllItemsEnabled();
    }

    public int getCount() {
        if (this.a != null) return this.a.getCount();
        return 0;
    }

    public View getDropDownView(int n2, View view, ViewGroup viewGroup) {
        if (this.a != null) return this.a.getDropDownView(n2, view, viewGroup);
        return null;
    }

    public Object getItem(int n2) {
        if (this.a != null) return this.a.getItem(n2);
        return null;
    }

    public long getItemId(int n2) {
        if (this.a != null) return this.a.getItemId(n2);
        return -1;
    }

    public int getItemViewType(int n2) {
        return 0;
    }

    public View getView(int n2, View view, ViewGroup viewGroup) {
        return this.getDropDownView(n2, view, viewGroup);
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean hasStableIds() {
        if (this.a == null) return false;
        if (!this.a.hasStableIds()) return false;
        return true;
    }

    public boolean isEmpty() {
        if (this.getCount() != 0) return false;
        return true;
    }

    public boolean isEnabled(int n2) {
        ListAdapter listAdapter = this.b;
        if (listAdapter == null) return true;
        return listAdapter.isEnabled(n2);
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.a == null) return;
        this.a.registerDataSetObserver(dataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.a == null) return;
        this.a.unregisterDataSetObserver(dataSetObserver);
    }
}

