/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.f;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

public class a
implements TransformationMethod {
    private Locale a;

    public a(Context context) {
        this.a = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence == null) return null;
        return charSequence.toString().toUpperCase(this.a);
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean bl2, int n2, Rect rect) {
    }
}

