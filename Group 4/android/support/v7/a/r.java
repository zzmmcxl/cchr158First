/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.Context;
import android.widget.ArrayAdapter;

class r
extends ArrayAdapter {
    public r(Context context, int n2, int n3, CharSequence[] arrcharSequence) {
        super(context, n2, n3, (Object[])arrcharSequence);
    }

    public long getItemId(int n2) {
        return n2;
    }

    public boolean hasStableIds() {
        return true;
    }
}

