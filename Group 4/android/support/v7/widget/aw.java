/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.a.a.l;
import android.support.v7.widget.as;
import android.support.v7.widget.av;
import android.util.AttributeSet;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;

class aw
implements av {
    private aw() {
    }

    /* synthetic */ aw(as as2) {
        this();
    }

    @Override
    public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        try {
            return l.a(context.getResources(), xmlPullParser, attributeSet, theme);
        }
        catch (Exception var5_6) {
            Log.e((String)"VdcInflateDelegate", (String)"Exception while inflating <vector>", (Throwable)var5_6);
            return null;
        }
    }
}

