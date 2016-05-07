/*
 * Decompiled with CFR 0_115.
 */
package android.support.a.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.support.a.a.a;
import android.support.a.a.f;
import android.support.a.a.i;
import android.support.a.a.j;
import android.support.a.a.k;
import android.support.a.a.q;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class o
extends q {
    int a = 0;
    float b = 0.0f;
    int c = 0;
    float d = 1.0f;
    int e;
    float f = 1.0f;
    float g = 0.0f;
    float h = 1.0f;
    float i = 0.0f;
    Paint.Cap j = Paint.Cap.BUTT;
    Paint.Join k = Paint.Join.MITER;
    float l = 4.0f;
    private int[] p;

    public o() {
    }

    public o(o o2) {
        super(o2);
        this.p = o2.p;
        this.a = o2.a;
        this.b = o2.b;
        this.d = o2.d;
        this.c = o2.c;
        this.e = o2.e;
        this.f = o2.f;
        this.g = o2.g;
        this.h = o2.h;
        this.i = o2.i;
        this.j = o2.j;
        this.k = o2.k;
        this.l = o2.l;
    }

    private Paint.Cap a(int n2, Paint.Cap cap) {
        switch (n2) {
            default: {
                return cap;
            }
            case 0: {
                return Paint.Cap.BUTT;
            }
            case 1: {
                return Paint.Cap.ROUND;
            }
            case 2: 
        }
        return Paint.Cap.SQUARE;
    }

    private Paint.Join a(int n2, Paint.Join join) {
        switch (n2) {
            default: {
                return join;
            }
            case 0: {
                return Paint.Join.MITER;
            }
            case 1: {
                return Paint.Join.ROUND;
            }
            case 2: 
        }
        return Paint.Join.BEVEL;
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        String string;
        this.p = null;
        if (!j.a(xmlPullParser, "pathData")) {
            return;
        }
        String string2 = typedArray.getString(0);
        if (string2 != null) {
            this.n = string2;
        }
        if ((string = typedArray.getString(2)) != null) {
            this.m = f.a(string);
        }
        this.c = j.b(typedArray, xmlPullParser, "fillColor", 1, this.c);
        this.f = j.a(typedArray, xmlPullParser, "fillAlpha", 12, this.f);
        this.j = this.a(j.a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.j);
        this.k = this.a(j.a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.k);
        this.l = j.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.l);
        this.a = j.b(typedArray, xmlPullParser, "strokeColor", 3, this.a);
        this.d = j.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.d);
        this.b = j.a(typedArray, xmlPullParser, "strokeWidth", 4, this.b);
        this.h = j.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.h);
        this.i = j.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.i);
        this.g = j.a(typedArray, xmlPullParser, "trimPathStart", 5, this.g);
    }

    public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
        TypedArray typedArray = k.b(resources, theme, attributeSet, a.c);
        this.a(typedArray, xmlPullParser);
        typedArray.recycle();
    }
}

