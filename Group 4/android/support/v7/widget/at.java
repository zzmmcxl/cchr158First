/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.a.a.b;
import android.support.v7.widget.as;
import android.support.v7.widget.av;
import android.util.AttributeSet;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;

class at
implements av {
    private at() {
    }

    /* synthetic */ at(as as2) {
        this();
    }

    @Override
    public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        try {
            return b.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
        }
        catch (Exception var5_6) {
            Log.e((String)"AvdcInflateDelegate", (String)"Exception while inflating <animated-vector>", (Throwable)var5_6);
            return null;
        }
    }
}

