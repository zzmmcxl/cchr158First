/*
 * Decompiled with CFR 0_115.
 */
package android.support.a.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.a.a.a;
import android.support.a.a.f;
import android.support.a.a.i;
import android.support.a.a.j;
import android.support.a.a.k;
import android.support.a.a.q;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class n
extends q {
    public n() {
    }

    public n(n n2) {
        super(n2);
    }

    private void a(TypedArray typedArray) {
        String string;
        String string2 = typedArray.getString(0);
        if (string2 != null) {
            this.n = string2;
        }
        if ((string = typedArray.getString(1)) == null) return;
        this.m = f.a(string);
    }

    public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
        if (!j.a(xmlPullParser, "pathData")) {
            return;
        }
        TypedArray typedArray = k.b(resources, theme, attributeSet, a.d);
        this.a(typedArray);
        typedArray.recycle();
    }

    @Override
    public boolean a() {
        return true;
    }
}

