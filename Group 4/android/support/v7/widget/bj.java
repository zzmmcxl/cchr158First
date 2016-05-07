/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.h.bi;
import android.support.v7.b.b;
import android.support.v7.widget.am;
import android.support.v7.widget.ar;
import android.support.v7.widget.bl;
import android.support.v7.widget.bm;
import android.support.v7.widget.dk;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class bj
extends Spinner
implements bi {
    private static final boolean a;
    private static final boolean b;
    private static final int[] c;
    private ar d;
    private am e;
    private Context f;
    private dk g;
    private SpinnerAdapter h;
    private boolean i;
    private bm j;
    private int k;
    private final Rect l;

    static {
        boolean bl2 = Build.VERSION.SDK_INT >= 23;
        a = bl2;
        boolean bl3 = Build.VERSION.SDK_INT >= 16;
        b = bl3;
        c = new int[]{16843505};
    }

    public bj(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.spinnerStyle);
    }

    public bj(Context context, AttributeSet attributeSet, int n2) {
        this(context, attributeSet, n2, -1);
    }

    public bj(Context context, AttributeSet attributeSet, int n2, int n3) {
        this(context, attributeSet, n2, n3, null);
    }

    /*
     * Exception decompiling
     */
    public bj(Context var1_1, AttributeSet var2_2, int var3_3, int var4_4, Resources.Theme var5_5) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[CATCHBLOCK]], but top level block is 4[CATCHBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    static /* synthetic */ int a(bj bj2, SpinnerAdapter spinnerAdapter, Drawable drawable) {
        return bj2.a(spinnerAdapter, drawable);
    }

    private int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int n2 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)0);
        int n3 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredHeight(), (int)0);
        int n4 = Math.max(0, this.getSelectedItemPosition());
        int n5 = Math.min(spinnerAdapter.getCount(), n4 + 15);
        int n6 = Math.max(0, n4 - (15 - (n5 - n4)));
        View view = null;
        int n7 = 0;
        int n8 = 0;
        do {
            View view2;
            if (n6 >= n5) {
                if (drawable == null) return n7;
                drawable.getPadding(this.l);
                return n7 + (this.l.left + this.l.right);
            }
            int n9 = spinnerAdapter.getItemViewType(n6);
            if (n9 != n8) {
                view2 = null;
            } else {
                n9 = n8;
                view2 = view;
            }
            if ((view = spinnerAdapter.getView(n6, view2, (ViewGroup)this)).getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(n2, n3);
            n7 = Math.max(n7, view.getMeasuredWidth());
            ++n6;
            n8 = n9;
        } while (true);
    }

    static /* synthetic */ bm a(bj bj2) {
        return bj2.j;
    }

    static /* synthetic */ boolean a() {
        return a;
    }

    static /* synthetic */ Rect b(bj bj2) {
        return bj2.l;
    }

    static /* synthetic */ int c(bj bj2) {
        return bj2.k;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.e == null) return;
        this.e.c();
    }

    public int getDropDownHorizontalOffset() {
        if (this.j != null) {
            return this.j.f();
        }
        if (!b) return 0;
        return super.getDropDownHorizontalOffset();
    }

    public int getDropDownVerticalOffset() {
        if (this.j != null) {
            return this.j.g();
        }
        if (!b) return 0;
        return super.getDropDownVerticalOffset();
    }

    public int getDropDownWidth() {
        if (this.j != null) {
            return this.k;
        }
        if (!b) return 0;
        return super.getDropDownWidth();
    }

    public Drawable getPopupBackground() {
        if (this.j != null) {
            return this.j.d();
        }
        if (!b) return null;
        return super.getPopupBackground();
    }

    public Context getPopupContext() {
        if (this.j != null) {
            return this.f;
        }
        if (!a) return null;
        return super.getPopupContext();
    }

    public CharSequence getPrompt() {
        if (this.j == null) return super.getPrompt();
        return this.j.a();
    }

    @Override
    public ColorStateList getSupportBackgroundTintList() {
        if (this.e == null) return null;
        return this.e.a();
    }

    @Override
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.e == null) return null;
        return this.e.b();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.j == null) return;
        if (!this.j.k()) return;
        this.j.i();
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        if (this.j == null) return;
        if (View.MeasureSpec.getMode((int)n2) != Integer.MIN_VALUE) return;
        this.setMeasuredDimension(Math.min(Math.max(this.getMeasuredWidth(), this.a(this.getAdapter(), this.getBackground())), View.MeasureSpec.getSize((int)n2)), this.getMeasuredHeight());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.g == null) return super.onTouchEvent(motionEvent);
        if (!this.g.onTouch((View)this, motionEvent)) return super.onTouchEvent(motionEvent);
        return true;
    }

    public boolean performClick() {
        if (this.j == null) return super.performClick();
        if (this.j.k()) return super.performClick();
        this.j.c();
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.i) {
            this.h = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.j == null) return;
        Context context = this.f == null ? this.getContext() : this.f;
        this.j.a(new bl(spinnerAdapter, context.getTheme()));
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.e == null) return;
        this.e.a(drawable);
    }

    public void setBackgroundResource(int n2) {
        super.setBackgroundResource(n2);
        if (this.e == null) return;
        this.e.a(n2);
    }

    public void setDropDownHorizontalOffset(int n2) {
        if (this.j != null) {
            this.j.b(n2);
            return;
        }
        if (!b) return;
        super.setDropDownHorizontalOffset(n2);
    }

    public void setDropDownVerticalOffset(int n2) {
        if (this.j != null) {
            this.j.c(n2);
            return;
        }
        if (!b) return;
        super.setDropDownVerticalOffset(n2);
    }

    public void setDropDownWidth(int n2) {
        if (this.j != null) {
            this.k = n2;
            return;
        }
        if (!b) return;
        super.setDropDownWidth(n2);
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.j != null) {
            this.j.a(drawable);
            return;
        }
        if (!b) return;
        super.setPopupBackgroundDrawable(drawable);
    }

    public void setPopupBackgroundResource(int n2) {
        this.setPopupBackgroundDrawable(this.getPopupContext().getDrawable(n2));
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.j != null) {
            this.j.a(charSequence);
            return;
        }
        super.setPrompt(charSequence);
    }

    @Override
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.e == null) return;
        this.e.a(colorStateList);
    }

    @Override
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.e == null) return;
        this.e.a(mode);
    }
}

