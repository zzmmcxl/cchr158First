/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

abstract class u
extends Activity {
    u() {
    }

    abstract View a(View var1, String var2, Context var3, AttributeSet var4);

    protected void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT < 11 && this.getLayoutInflater().getFactory() == null) {
            this.getLayoutInflater().setFactory((LayoutInflater.Factory)this);
        }
        super.onCreate(bundle);
    }

    public View onCreateView(String string, Context context, AttributeSet attributeSet) {
        View view = this.a(null, string, context, attributeSet);
        if (view != null) return view;
        return super.onCreateView(string, context, attributeSet);
    }
}

