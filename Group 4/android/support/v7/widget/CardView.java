/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.support.v7.c.d;
import android.support.v7.c.e;
import android.support.v7.widget.bt;
import android.support.v7.widget.bu;
import android.support.v7.widget.bv;
import android.support.v7.widget.bx;
import android.support.v7.widget.by;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class CardView
extends FrameLayout
implements bu {
    private static final bx a = Build.VERSION.SDK_INT >= 21 ? new bt() : (Build.VERSION.SDK_INT >= 17 ? new by() : new bv());
    private boolean b;
    private boolean c;
    private final Rect d = new Rect();
    private final Rect e = new Rect();

    static {
        a.a();
    }

    public CardView(Context context) {
        super(context);
        this.a(context, null, 0);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a(context, attributeSet, 0);
    }

    public CardView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a(context, attributeSet, n2);
    }

    private void a(Context context, AttributeSet attributeSet, int n2) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, e.CardView, n2, d.CardView_Light);
        int n3 = typedArray.getColor(e.CardView_cardBackgroundColor, 0);
        float f2 = typedArray.getDimension(e.CardView_cardCornerRadius, 0.0f);
        float f3 = typedArray.getDimension(e.CardView_cardElevation, 0.0f);
        float f4 = typedArray.getDimension(e.CardView_cardMaxElevation, 0.0f);
        this.b = typedArray.getBoolean(e.CardView_cardUseCompatPadding, false);
        this.c = typedArray.getBoolean(e.CardView_cardPreventCornerOverlap, true);
        int n4 = typedArray.getDimensionPixelSize(e.CardView_contentPadding, 0);
        this.d.left = typedArray.getDimensionPixelSize(e.CardView_contentPaddingLeft, n4);
        this.d.top = typedArray.getDimensionPixelSize(e.CardView_contentPaddingTop, n4);
        this.d.right = typedArray.getDimensionPixelSize(e.CardView_contentPaddingRight, n4);
        this.d.bottom = typedArray.getDimensionPixelSize(e.CardView_contentPaddingBottom, n4);
        if (f3 > f4) {
            f4 = f3;
        }
        typedArray.recycle();
        a.a(this, context, n3, f2, f3, f4);
    }

    @Override
    public void a(int n2, int n3, int n4, int n5) {
        this.e.set(n2, n3, n4, n5);
        super.setPadding(n2 + this.d.left, n3 + this.d.top, n4 + this.d.right, n5 + this.d.bottom);
    }

    public float getCardElevation() {
        return a.e(this);
    }

    public int getContentPaddingBottom() {
        return this.d.bottom;
    }

    public int getContentPaddingLeft() {
        return this.d.left;
    }

    public int getContentPaddingRight() {
        return this.d.right;
    }

    public int getContentPaddingTop() {
        return this.d.top;
    }

    public float getMaxCardElevation() {
        return a.a(this);
    }

    @Override
    public boolean getPreventCornerOverlap() {
        return this.c;
    }

    public float getRadius() {
        return a.d(this);
    }

    @Override
    public boolean getUseCompatPadding() {
        return this.b;
    }

    /*
     * Exception decompiling
     */
    protected void onMeasure(int var1_1, int var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:486)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:65)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:425)
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

    public void setCardBackgroundColor(int n2) {
        a.a((bu)this, n2);
    }

    public void setCardElevation(float f2) {
        a.c(this, f2);
    }

    public void setMaxCardElevation(float f2) {
        a.b(this, f2);
    }

    public void setPadding(int n2, int n3, int n4, int n5) {
    }

    public void setPaddingRelative(int n2, int n3, int n4, int n5) {
    }

    public void setPreventCornerOverlap(boolean bl2) {
        if (bl2 == this.c) {
            return;
        }
        this.c = bl2;
        a.h(this);
    }

    public void setRadius(float f2) {
        a.a((bu)this, f2);
    }

    public void setUseCompatPadding(boolean bl2) {
        if (this.b == bl2) {
            return;
        }
        this.b = bl2;
        a.g(this);
    }
}

