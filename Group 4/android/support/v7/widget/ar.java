/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.v4.b.c;
import android.support.v4.c.a;
import android.support.v4.g.f;
import android.support.v7.b.b;
import android.support.v7.widget.as;
import android.support.v7.widget.at;
import android.support.v7.widget.au;
import android.support.v7.widget.av;
import android.support.v7.widget.aw;
import android.support.v7.widget.cs;
import android.support.v7.widget.gf;
import android.support.v7.widget.gi;
import android.support.v7.widget.gj;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ar {
    private static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
    private static ar b;
    private static final au c;
    private static final int[] d;
    private static final int[] e;
    private static final int[] f;
    private static final int[] g;
    private static final int[] h;
    private static final int[] i;
    private WeakHashMap j;
    private android.support.v4.g.a k;
    private SparseArray l;
    private final Object m = new Object();
    private final WeakHashMap n = new WeakHashMap(0);
    private TypedValue o;

    static {
        c = new au(6);
        int[] arrn = new int[]{android.support.v7.b.f.abc_textfield_search_default_mtrl_alpha, android.support.v7.b.f.abc_textfield_default_mtrl_alpha, android.support.v7.b.f.abc_ab_share_pack_mtrl_alpha};
        d = arrn;
        int[] arrn2 = new int[]{android.support.v7.b.f.abc_ic_search_api_mtrl_alpha, android.support.v7.b.f.abc_ic_commit_search_api_mtrl_alpha};
        e = arrn2;
        int[] arrn3 = new int[]{android.support.v7.b.f.abc_textfield_activated_mtrl_alpha, android.support.v7.b.f.abc_textfield_search_activated_mtrl_alpha, android.support.v7.b.f.abc_cab_background_top_mtrl_alpha, android.support.v7.b.f.abc_text_cursor_material};
        f = arrn3;
        int[] arrn4 = new int[]{android.support.v7.b.f.abc_popup_background_mtrl_mult, android.support.v7.b.f.abc_cab_background_internal_bg, android.support.v7.b.f.abc_menu_hardkey_panel_mtrl_mult};
        g = arrn4;
        int[] arrn5 = new int[]{android.support.v7.b.f.abc_tab_indicator_material, android.support.v7.b.f.abc_textfield_search_material, android.support.v7.b.f.abc_ratingbar_full_material};
        h = arrn5;
        int[] arrn6 = new int[]{android.support.v7.b.f.abc_btn_check_material, android.support.v7.b.f.abc_btn_radio_material};
        i = arrn6;
    }

    private ColorStateList a(Context context) {
        int n2 = gf.a(context, b.colorControlNormal);
        int n3 = gf.a(context, b.colorControlActivated);
        int[][] arrarrn = new int[7][];
        int[] arrn = new int[7];
        arrarrn[0] = gf.a;
        arrn[0] = gf.c(context, b.colorControlNormal);
        arrarrn[1] = gf.b;
        arrn[1] = n3;
        arrarrn[2] = gf.c;
        arrn[2] = n3;
        arrarrn[3] = gf.d;
        arrn[3] = n3;
        arrarrn[4] = gf.e;
        arrn[4] = n3;
        arrarrn[5] = gf.f;
        arrn[5] = n3;
        arrarrn[6] = gf.h;
        arrn[6] = n2;
        return new ColorStateList((int[][])arrarrn, arrn);
    }

    public static PorterDuffColorFilter a(int n2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter = c.a(n2, mode);
        if (porterDuffColorFilter != null) return porterDuffColorFilter;
        porterDuffColorFilter = new PorterDuffColorFilter(n2, mode);
        c.a(n2, mode, porterDuffColorFilter);
        return porterDuffColorFilter;
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] arrn) {
        if (colorStateList == null) return null;
        if (mode != null) return ar.a(colorStateList.getColorForState(arrn, 0), mode);
        return null;
    }

    private Drawable a(Context context, int n2, boolean bl2, Drawable drawable) {
        ColorStateList colorStateList = this.b(context, n2);
        if (colorStateList != null) {
            if (cs.b(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = android.support.v4.c.a.a.f(drawable);
            android.support.v4.c.a.a.a(drawable, colorStateList);
            PorterDuff.Mode mode = this.a(n2);
            if (mode == null) return drawable;
            android.support.v4.c.a.a.a(drawable, mode);
            return drawable;
        }
        if (n2 == android.support.v7.b.f.abc_cab_background_top_material) {
            Drawable[] arrdrawable = new Drawable[]{this.a(context, android.support.v7.b.f.abc_cab_background_internal_bg), this.a(context, android.support.v7.b.f.abc_cab_background_top_mtrl_alpha)};
            return new LayerDrawable(arrdrawable);
        }
        if (n2 == android.support.v7.b.f.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable)drawable;
            ar.a(layerDrawable.findDrawableByLayerId(16908288), gf.a(context, b.colorControlNormal), a);
            ar.a(layerDrawable.findDrawableByLayerId(16908303), gf.a(context, b.colorControlNormal), a);
            ar.a(layerDrawable.findDrawableByLayerId(16908301), gf.a(context, b.colorControlActivated), a);
            return drawable;
        }
        if (n2 != android.support.v7.b.f.abc_ratingbar_indicator_material && n2 != android.support.v7.b.f.abc_ratingbar_small_material) {
            if (ar.a(context, n2, drawable)) return drawable;
            if (!bl2) return drawable;
            return null;
        }
        LayerDrawable layerDrawable = (LayerDrawable)drawable;
        ar.a(layerDrawable.findDrawableByLayerId(16908288), gf.c(context, b.colorControlNormal), a);
        ar.a(layerDrawable.findDrawableByLayerId(16908303), gf.a(context, b.colorControlActivated), a);
        ar.a(layerDrawable.findDrawableByLayerId(16908301), gf.a(context, b.colorControlActivated), a);
        return drawable;
    }

    private Drawable a(Context context, long l2) {
        Object object = this.m;
        // MONITORENTER : object
        f f2 = (f)this.n.get((Object)context);
        if (f2 == null) {
            // MONITOREXIT : object
            return null;
        }
        WeakReference weakReference = (WeakReference)f2.a(l2);
        if (weakReference == null) return null;
        Drawable.ConstantState constantState = (Drawable.ConstantState)weakReference.get();
        if (constantState != null) {
            Drawable drawable = constantState.newDrawable(context.getResources());
            // MONITOREXIT : object
            return drawable;
        }
        f2.b(l2);
        // MONITOREXIT : object
        return null;
    }

    public static ar a() {
        if (b != null) return b;
        b = new ar();
        ar.a(b);
        return b;
    }

    private void a(Context context, int n2, ColorStateList colorStateList) {
        SparseArray sparseArray;
        if (this.j == null) {
            this.j = new WeakHashMap();
        }
        if ((sparseArray = (SparseArray)this.j.get((Object)context)) == null) {
            sparseArray = new SparseArray();
            this.j.put(context, sparseArray);
        }
        sparseArray.append(n2, (Object)colorStateList);
    }

    private static void a(Drawable drawable, int n2, PorterDuff.Mode mode) {
        if (cs.b(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = a;
        }
        drawable.setColorFilter((ColorFilter)ar.a(n2, mode));
    }

    public static void a(Drawable drawable, gi gi2, int[] arrn) {
        if (cs.b(drawable) && drawable.mutate() != drawable) {
            Log.d((String)"AppCompatDrawableManager", (String)"Mutated drawable is not the same instance as the input.");
            return;
        }
        if (gi2.d || gi2.c) {
            ColorStateList colorStateList = gi2.d ? gi2.a : null;
            PorterDuff.Mode mode = gi2.c ? gi2.b : a;
            drawable.setColorFilter((ColorFilter)ar.a(colorStateList, mode, arrn));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT > 23) return;
        drawable.invalidateSelf();
    }

    private static void a(ar ar2) {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 21) return;
        ar2.a("vector", new aw(null));
        if (n2 < 11) return;
        ar2.a("animated-vector", new at(null));
    }

    private void a(String string, av av2) {
        if (this.k == null) {
            this.k = new android.support.v4.g.a();
        }
        this.k.put(string, av2);
    }

    private static boolean a(Context context, int n2, Drawable drawable) {
        PorterDuff.Mode mode;
        int n3;
        int n4;
        boolean bl2;
        PorterDuff.Mode mode2 = a;
        if (ar.a(d, n2)) {
            n4 = b.colorControlNormal;
            mode = mode2;
            bl2 = true;
            n3 = -1;
        } else if (ar.a(f, n2)) {
            n4 = b.colorControlActivated;
            mode = mode2;
            bl2 = true;
            n3 = -1;
        } else if (ar.a(g, n2)) {
            PorterDuff.Mode mode3 = PorterDuff.Mode.MULTIPLY;
            bl2 = true;
            mode = mode3;
            n4 = 16842801;
            n3 = -1;
        } else if (n2 == android.support.v7.b.f.abc_list_divider_mtrl_alpha) {
            n4 = 16842800;
            n3 = Math.round(40.8f);
            mode = mode2;
            bl2 = true;
        } else {
            n3 = -1;
            mode = mode2;
            n4 = 0;
            bl2 = false;
        }
        if (!bl2) return false;
        if (cs.b(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter((ColorFilter)ar.a(gf.a(context, n4), mode));
        if (n3 == -1) return true;
        drawable.setAlpha(n3);
        return true;
    }

    private boolean a(Context context, long l2, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) return false;
        Object object = this.m;
        // MONITORENTER : object
        f f2 = (f)this.n.get((Object)context);
        if (f2 == null) {
            f2 = new f();
            this.n.put(context, f2);
        }
        f2.b(l2, new WeakReference<Drawable.ConstantState>(constantState));
        // MONITOREXIT : object
        return true;
    }

    private static boolean a(int[] arrn, int n2) {
        int n3 = arrn.length;
        int n4 = 0;
        do {
            boolean bl2 = false;
            if (n4 >= n3) return bl2;
            if (arrn[n4] == n2) {
                return true;
            }
            ++n4;
        } while (true);
    }

    private ColorStateList b(Context context) {
        int[][] arrarrn = new int[3][];
        int[] arrn = new int[3];
        arrarrn[0] = gf.a;
        arrn[0] = gf.c(context, b.colorControlNormal);
        arrarrn[1] = gf.e;
        arrn[1] = gf.a(context, b.colorControlActivated);
        arrarrn[2] = gf.h;
        arrn[2] = gf.a(context, b.colorControlNormal);
        return new ColorStateList((int[][])arrarrn, arrn);
    }

    private ColorStateList c(Context context) {
        int[][] arrarrn = new int[3][];
        int[] arrn = new int[3];
        arrarrn[0] = gf.a;
        arrn[0] = gf.a(context, 16842800, 0.1f);
        arrarrn[1] = gf.e;
        arrn[1] = gf.a(context, b.colorControlActivated, 0.3f);
        arrarrn[2] = gf.h;
        arrn[2] = gf.a(context, 16842800, 0.3f);
        return new ColorStateList((int[][])arrarrn, arrn);
    }

    private Drawable c(Context context, int n2) {
        Drawable drawable;
        block14 : {
            if (this.k == null) return null;
            if (this.k.isEmpty()) return null;
            if (this.l != null) {
                String string = (String)this.l.get(n2);
                if ("appcompat_skip_skip".equals(string)) return null;
                if (string != null && this.k.get(string) == null) {
                    return null;
                }
            } else {
                this.l = new SparseArray();
            }
            if (this.o == null) {
                this.o = new TypedValue();
            }
            TypedValue typedValue = this.o;
            Resources resources = context.getResources();
            resources.getValue(n2, typedValue, true);
            long l2 = (long)typedValue.assetCookie << 32 | (long)typedValue.data;
            Drawable drawable2 = this.a(context, l2);
            if (drawable2 != null) {
                return drawable2;
            }
            if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
                try {
                    int n3;
                    XmlResourceParser xmlResourceParser = resources.getXml(n2);
                    AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
                    while ((n3 = xmlResourceParser.next()) != 2 && n3 != 1) {
                    }
                    if (n3 != 2) {
                        throw new XmlPullParserException("No start tag found");
                    }
                    String string = xmlResourceParser.getName();
                    this.l.append(n2, (Object)string);
                    av av2 = (av)this.k.get(string);
                    if (av2 != null) {
                        drawable2 = av2.a(context, (XmlPullParser)xmlResourceParser, attributeSet, context.getTheme());
                    }
                    if (drawable2 != null) {
                        drawable2.setChangingConfigurations(typedValue.changingConfigurations);
                        boolean bl2 = this.a(context, l2, drawable2);
                        if (bl2) {
                            // empty if block
                        }
                    }
                    drawable = drawable2;
                    break block14;
                }
                catch (Exception var9_12) {
                    Log.e((String)"AppCompatDrawableManager", (String)"Exception while inflating drawable", (Throwable)var9_12);
                }
            }
            drawable = drawable2;
        }
        if (drawable != null) return drawable;
        this.l.append(n2, (Object)"appcompat_skip_skip");
        return drawable;
    }

    private ColorStateList d(Context context) {
        int[][] arrarrn = new int[3][];
        int[] arrn = new int[3];
        ColorStateList colorStateList = gf.b(context, b.colorSwitchThumbNormal);
        if (colorStateList != null && colorStateList.isStateful()) {
            arrarrn[0] = gf.a;
            arrn[0] = colorStateList.getColorForState(arrarrn[0], 0);
            arrarrn[1] = gf.e;
            arrn[1] = gf.a(context, b.colorControlActivated);
            arrarrn[2] = gf.h;
            arrn[2] = colorStateList.getDefaultColor();
            return new ColorStateList((int[][])arrarrn, arrn);
        }
        arrarrn[0] = gf.a;
        arrn[0] = gf.c(context, b.colorSwitchThumbNormal);
        arrarrn[1] = gf.e;
        arrn[1] = gf.a(context, b.colorControlActivated);
        arrarrn[2] = gf.h;
        arrn[2] = gf.a(context, b.colorSwitchThumbNormal);
        return new ColorStateList((int[][])arrarrn, arrn);
    }

    private ColorStateList d(Context context, int n2) {
        if (this.j == null) return null;
        SparseArray sparseArray = (SparseArray)this.j.get((Object)context);
        if (sparseArray == null) return null;
        return (ColorStateList)sparseArray.get(n2);
    }

    private ColorStateList e(Context context) {
        int[][] arrarrn = new int[3][];
        int[] arrn = new int[3];
        arrarrn[0] = gf.a;
        arrn[0] = gf.c(context, b.colorControlNormal);
        arrarrn[1] = gf.g;
        arrn[1] = gf.a(context, b.colorControlNormal);
        arrarrn[2] = gf.h;
        arrn[2] = gf.a(context, b.colorControlActivated);
        return new ColorStateList((int[][])arrarrn, arrn);
    }

    private ColorStateList e(Context context, int n2) {
        int[][] arrarrn = new int[4][];
        int[] arrn = new int[4];
        int n3 = gf.a(context, n2);
        int n4 = gf.a(context, b.colorControlHighlight);
        arrarrn[0] = gf.a;
        arrn[0] = gf.c(context, b.colorButtonNormal);
        arrarrn[1] = gf.d;
        arrn[1] = a.a(n4, n3);
        arrarrn[2] = gf.b;
        arrn[2] = a.a(n4, n3);
        arrarrn[3] = gf.h;
        arrn[3] = n3;
        return new ColorStateList((int[][])arrarrn, arrn);
    }

    private ColorStateList f(Context context) {
        return this.e(context, b.colorButtonNormal);
    }

    private ColorStateList g(Context context) {
        return this.e(context, b.colorAccent);
    }

    private ColorStateList h(Context context) {
        int[][] arrarrn = new int[3][];
        int[] arrn = new int[3];
        arrarrn[0] = gf.a;
        arrn[0] = gf.c(context, b.colorControlNormal);
        arrarrn[1] = gf.g;
        arrn[1] = gf.a(context, b.colorControlNormal);
        arrarrn[2] = gf.h;
        arrn[2] = gf.a(context, b.colorControlActivated);
        return new ColorStateList((int[][])arrarrn, arrn);
    }

    private ColorStateList i(Context context) {
        int[][] arrarrn = new int[2][];
        int[] arrn = new int[2];
        arrarrn[0] = gf.a;
        arrn[0] = gf.c(context, b.colorControlActivated);
        arrarrn[1] = gf.h;
        arrn[1] = gf.a(context, b.colorControlActivated);
        return new ColorStateList((int[][])arrarrn, arrn);
    }

    final PorterDuff.Mode a(int n2) {
        int n3 = android.support.v7.b.f.abc_switch_thumb_material;
        PorterDuff.Mode mode = null;
        if (n2 != n3) return mode;
        return PorterDuff.Mode.MULTIPLY;
    }

    public Drawable a(Context context, int n2) {
        return this.a(context, n2, false);
    }

    public Drawable a(Context context, int n2, boolean bl2) {
        Drawable drawable = this.c(context, n2);
        if (drawable == null) {
            drawable = c.a(context, n2);
        }
        if (drawable != null) {
            drawable = this.a(context, n2, bl2, drawable);
        }
        if (drawable == null) return drawable;
        cs.a(drawable);
        return drawable;
    }

    public final Drawable a(Context context, gj gj2, int n2) {
        Drawable drawable = this.c(context, n2);
        if (drawable == null) {
            drawable = gj2.a(n2);
        }
        if (drawable == null) return null;
        return this.a(context, n2, false, drawable);
    }

    public final ColorStateList b(Context context, int n2) {
        ColorStateList colorStateList = this.d(context, n2);
        if (colorStateList != null) return colorStateList;
        if (n2 == android.support.v7.b.f.abc_edit_text_material) {
            colorStateList = this.e(context);
        } else if (n2 == android.support.v7.b.f.abc_switch_track_mtrl_alpha) {
            colorStateList = this.c(context);
        } else if (n2 == android.support.v7.b.f.abc_switch_thumb_material) {
            colorStateList = this.d(context);
        } else if (n2 == android.support.v7.b.f.abc_btn_default_mtrl_shape || n2 == android.support.v7.b.f.abc_btn_borderless_material) {
            colorStateList = this.f(context);
        } else if (n2 == android.support.v7.b.f.abc_btn_colored_material) {
            colorStateList = this.g(context);
        } else if (n2 == android.support.v7.b.f.abc_spinner_mtrl_am_alpha || n2 == android.support.v7.b.f.abc_spinner_textfield_background_material) {
            colorStateList = this.h(context);
        } else if (ar.a(e, n2)) {
            colorStateList = gf.b(context, b.colorControlNormal);
        } else if (ar.a(h, n2)) {
            colorStateList = this.a(context);
        } else if (ar.a(i, n2)) {
            colorStateList = this.b(context);
        } else if (n2 == android.support.v7.b.f.abc_seekbar_thumb_material) {
            colorStateList = this.i(context);
        }
        if (colorStateList == null) return colorStateList;
        this.a(context, n2, colorStateList);
        return colorStateList;
    }
}

