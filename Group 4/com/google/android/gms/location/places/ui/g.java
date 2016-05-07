/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.places.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.TypedValue;
import com.google.android.gms.common.b;

public abstract class g {
    protected final Intent a;

    public g(String string) {
        this.a = new Intent(string);
        this.a.setPackage("com.google.android.gms");
    }

    protected Intent a(Activity activity) {
        Resources.Theme theme = activity.getTheme();
        TypedValue typedValue = new TypedValue();
        TypedValue typedValue2 = new TypedValue();
        if (theme.resolveAttribute(16843827, typedValue, true) && !this.a.hasExtra("primary_color")) {
            this.a.putExtra("primary_color", typedValue.data);
        }
        if (theme.resolveAttribute(16843828, typedValue2, true) && !this.a.hasExtra("primary_color_dark")) {
            this.a.putExtra("primary_color_dark", typedValue2.data);
        }
        b.a().b((Context)activity);
        return this.a;
    }
}

