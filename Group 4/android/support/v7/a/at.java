/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.g.a;
import android.support.v4.h.bo;
import android.support.v7.a.au;
import android.support.v7.b.l;
import android.support.v7.view.e;
import android.support.v7.widget.al;
import android.support.v7.widget.an;
import android.support.v7.widget.ao;
import android.support.v7.widget.ap;
import android.support.v7.widget.ax;
import android.support.v7.widget.ay;
import android.support.v7.widget.ba;
import android.support.v7.widget.bb;
import android.support.v7.widget.bf;
import android.support.v7.widget.bg;
import android.support.v7.widget.bh;
import android.support.v7.widget.bj;
import android.support.v7.widget.bs;
import android.support.v7.widget.gh;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.Map;

class at {
    private static final Class[] a = new Class[]{Context.class, AttributeSet.class};
    private static final int[] b = new int[]{16843375};
    private static final String[] c = new String[]{"android.widget.", "android.view.", "android.webkit."};
    private static final Map d = new a();
    private final Object[] e = new Object[2];

    at() {
    }

    private static Context a(Context object, AttributeSet attributeSet, boolean bl2, boolean bl3) {
        TypedArray typedArray = object.obtainStyledAttributes(attributeSet, l.View, 0, 0);
        int n2 = bl2 ? typedArray.getResourceId(l.View_android_theme, 0) : 0;
        if (bl3 && n2 == 0 && (n2 = typedArray.getResourceId(l.View_theme, 0)) != 0) {
            Log.i((String)"AppCompatViewInflater", (String)"app:theme is now deprecated. Please move to using android:theme instead.");
        }
        int n3 = n2;
        typedArray.recycle();
        if (n3 == 0) return object;
        if (!(object instanceof e)) return new e((Context)object, n3);
        if (((e)((Object)object)).a() == n3) return object;
        return new e((Context)object, n3);
    }

    private View a(Context context, String string, AttributeSet attributeSet) {
        if (string.equals("view")) {
            string = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.e[0] = context;
            this.e[1] = attributeSet;
            if (-1 != string.indexOf(46)) return this.a(context, string, (String)null);
        }
        catch (Exception var5_7) {
            return null;
        }
        catch (Throwable var4_8) {
            throw var4_8;
        }
        for (int i2 = 0; i2 < c.length; ++i2) {
            View view = this.a(context, string, c[i2]);
            if (view == null) continue;
            this.e[0] = null;
            this.e[1] = null;
            return view;
        }
        this.e[0] = null;
        this.e[1] = null;
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private View a(Context var1_1, String var2_2, String var3_3) {
        var4_4 = (Constructor<U>)at.d.get(var2_2);
        if (var4_4 != null) ** GOTO lbl8
        try {
            var7_5 = var1_1.getClassLoader();
            var8_6 = var3_3 != null ? var3_3 + var2_2 : var2_2;
            var4_4 = var7_5.loadClass(var8_6).asSubclass(View.class).getConstructor(at.a);
            at.d.put(var2_2, var4_4);
lbl8: // 2 sources:
            var4_4.setAccessible(true);
            return (View)var4_4.newInstance(this.e);
        }
        catch (Exception var5_8) {
            return null;
        }
    }

    private void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) return;
        if (Build.VERSION.SDK_INT >= 15 && !bo.D(view)) {
            return;
        }
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, b);
        String string = typedArray.getString(0);
        if (string != null) {
            view.setOnClickListener((View.OnClickListener)new au(view, string));
        }
        typedArray.recycle();
    }

    /*
     * Unable to fully structure code
     */
    public final View a(View var1_1, String var2_2, Context var3_3, AttributeSet var4_4, boolean var5_5, boolean var6_6, boolean var7_7, boolean var8_8) {
        var9_9 = var5_5 != false && var1_1 != null ? var1_1.getContext() : var3_3;
        if (var6_6 || var7_7) {
            var9_9 = at.a(var9_9, var4_4, var6_6, var7_7);
        }
        if (var8_8) {
            var9_9 = gh.a(var9_9);
        }
        var10_10 = -1;
        switch (var2_2.hashCode()) {
            case -938935918: {
                if (var2_2.equals("TextView")) {
                    var10_10 = 0;
                    ** break;
                }
                ** GOTO lbl66
            }
            case 1125864064: {
                if (var2_2.equals("ImageView")) {
                    var10_10 = 1;
                    ** break;
                }
                ** GOTO lbl66
            }
            case 2001146706: {
                if (var2_2.equals("Button")) {
                    var10_10 = 2;
                    ** break;
                }
                ** GOTO lbl66
            }
            case 1666676343: {
                if (var2_2.equals("EditText")) {
                    var10_10 = 3;
                    ** break;
                }
                ** GOTO lbl66
            }
            case -339785223: {
                if (var2_2.equals("Spinner")) {
                    var10_10 = 4;
                    ** break;
                }
                ** GOTO lbl66
            }
            case -937446323: {
                if (var2_2.equals("ImageButton")) {
                    var10_10 = 5;
                    ** break;
                }
                ** GOTO lbl66
            }
            case 1601505219: {
                if (var2_2.equals("CheckBox")) {
                    var10_10 = 6;
                    ** break;
                }
                ** GOTO lbl66
            }
            case 776382189: {
                if (var2_2.equals("RadioButton")) {
                    var10_10 = 7;
                    ** break;
                }
                ** GOTO lbl66
            }
            case -1455429095: {
                if (var2_2.equals("CheckedTextView")) {
                    var10_10 = 8;
                    ** break;
                }
                ** GOTO lbl66
            }
            case 1413872058: {
                if (var2_2.equals("AutoCompleteTextView")) {
                    var10_10 = 9;
                    ** break;
                }
                ** GOTO lbl66
            }
            case -1346021293: {
                if (var2_2.equals("MultiAutoCompleteTextView")) {
                    var10_10 = 10;
                    ** break;
                }
                ** GOTO lbl66
            }
            case -1946472170: {
                if (var2_2.equals("RatingBar")) {
                    var10_10 = 11;
                }
            }
lbl66: // 26 sources:
            default: {
                ** GOTO lbl71
            }
            case -658531749: 
        }
        if (var2_2.equals("SeekBar")) {
            var10_10 = 12;
        }
lbl71: // 4 sources:
        var11_11 = null;
        switch (var10_10) {
            case 0: {
                var11_11 = new bs(var9_9, var4_4);
                break;
            }
            case 1: {
                var11_11 = new ba(var9_9, var4_4);
                break;
            }
            case 2: {
                var11_11 = new an(var9_9, var4_4);
                break;
            }
            case 3: {
                var11_11 = new ax(var9_9, var4_4);
                break;
            }
            case 4: {
                var11_11 = new bj(var9_9, var4_4);
                break;
            }
            case 5: {
                var11_11 = new ay(var9_9, var4_4);
                break;
            }
            case 6: {
                var11_11 = new ao(var9_9, var4_4);
                break;
            }
            case 7: {
                var11_11 = new bf(var9_9, var4_4);
                break;
            }
            case 8: {
                var11_11 = new ap(var9_9, var4_4);
                break;
            }
            case 9: {
                var11_11 = new al(var9_9, var4_4);
                break;
            }
            case 10: {
                var11_11 = new bb(var9_9, var4_4);
                break;
            }
            case 11: {
                var11_11 = new bg(var9_9, var4_4);
                break;
            }
            case 12: {
                var11_11 = new bh(var9_9, var4_4);
            }
        }
        var12_12 = var11_11 == null && var3_3 != var9_9 ? this.a(var9_9, var2_2, var4_4) : var11_11;
        if (var12_12 == null) return var12_12;
        this.a((View)var12_12, var4_4);
        return var12_12;
    }
}

