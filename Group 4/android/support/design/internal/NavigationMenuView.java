/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.z;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ep;
import android.util.AttributeSet;

public class NavigationMenuView
extends RecyclerView
implements z {
    public NavigationMenuView(Context context) {
        this(context, null);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.setLayoutManager(new LinearLayoutManager(context, 1, false));
    }

    @Override
    public void a(i i2) {
    }

    public int getWindowAnimations() {
        return 0;
    }
}

