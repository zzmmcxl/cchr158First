/*
 * Decompiled with CFR 0_115.
 */
package android.support.a.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.support.a.a.a;
import android.support.a.a.j;
import android.support.a.a.k;
import android.support.a.a.n;
import android.support.a.a.o;
import android.support.a.a.q;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

class p {
    final ArrayList a = new ArrayList();
    private final Matrix b = new Matrix();
    private float c = 0.0f;
    private float d = 0.0f;
    private float e = 0.0f;
    private float f = 1.0f;
    private float g = 1.0f;
    private float h = 0.0f;
    private float i = 0.0f;
    private final Matrix j = new Matrix();
    private int k;
    private int[] l;
    private String m = null;

    public p() {
    }

    public p(p p2, android.support.v4.g.a a2) {
        this.c = p2.c;
        this.d = p2.d;
        this.e = p2.e;
        this.f = p2.f;
        this.g = p2.g;
        this.h = p2.h;
        this.i = p2.i;
        this.l = p2.l;
        this.m = p2.m;
        this.k = p2.k;
        if (this.m != null) {
            a2.put(this.m, this);
        }
        this.j.set(p2.j);
        ArrayList arrayList = p2.a;
        int n2 = 0;
        while (n2 < arrayList.size()) {
            Object e2 = arrayList.get(n2);
            if (e2 instanceof p) {
                p p3 = (p)e2;
                this.a.add(new p(p3, a2));
            } else {
                q q22;
                q q22;
                if (e2 instanceof o) {
                    q22 = new o((o)e2);
                } else {
                    if (!(e2 instanceof n)) throw new IllegalStateException("Unknown object in the tree!");
                    q22 = new n((n)e2);
                }
                this.a.add(q22);
                if (q22.n != null) {
                    a2.put(q22.n, q22);
                }
            }
            ++n2;
        }
    }

    static /* synthetic */ int a(p p2) {
        return p2.k;
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        this.l = null;
        this.c = j.a(typedArray, xmlPullParser, "rotation", 5, this.c);
        this.d = typedArray.getFloat(1, this.d);
        this.e = typedArray.getFloat(2, this.e);
        this.f = j.a(typedArray, xmlPullParser, "scaleX", 3, this.f);
        this.g = j.a(typedArray, xmlPullParser, "scaleY", 4, this.g);
        this.h = j.a(typedArray, xmlPullParser, "translateX", 6, this.h);
        this.i = j.a(typedArray, xmlPullParser, "translateY", 7, this.i);
        String string = typedArray.getString(0);
        if (string != null) {
            this.m = string;
        }
        this.b();
    }

    static /* synthetic */ Matrix b(p p2) {
        return p2.b;
    }

    private void b() {
        this.j.reset();
        this.j.postTranslate(- this.d, - this.e);
        this.j.postScale(this.f, this.g);
        this.j.postRotate(this.c, 0.0f, 0.0f);
        this.j.postTranslate(this.h + this.d, this.i + this.e);
    }

    static /* synthetic */ Matrix c(p p2) {
        return p2.j;
    }

    public String a() {
        return this.m;
    }

    public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
        TypedArray typedArray = k.b(resources, theme, attributeSet, a.b);
        this.a(typedArray, xmlPullParser);
        typedArray.recycle();
    }
}

