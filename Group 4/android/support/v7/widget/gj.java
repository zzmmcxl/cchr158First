/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ar;
import android.util.DisplayMetrics;

public class gj
extends Resources {
    private final Context a;

    public gj(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.a = context;
    }

    final Drawable a(int n2) {
        return super.getDrawable(n2);
    }

    public Drawable getDrawable(int n2) {
        return ar.a().a(this.a, this, n2);
    }
}

