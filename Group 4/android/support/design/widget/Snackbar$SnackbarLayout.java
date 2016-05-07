/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.e;
import android.support.design.f;
import android.support.design.g;
import android.support.design.i;
import android.support.design.widget.bh;
import android.support.design.widget.bi;
import android.support.v4.h.bo;
import android.support.v4.h.dc;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Snackbar$SnackbarLayout
extends LinearLayout {
    private TextView a;
    private Button b;
    private int c;
    private int d;
    private bi e;
    private bh f;

    public Snackbar$SnackbarLayout(Context context) {
        this(context, null);
    }

    public Snackbar$SnackbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, i.SnackbarLayout);
        this.c = typedArray.getDimensionPixelSize(i.SnackbarLayout_android_maxWidth, -1);
        this.d = typedArray.getDimensionPixelSize(i.SnackbarLayout_maxActionInlineWidth, -1);
        if (typedArray.hasValue(i.SnackbarLayout_elevation)) {
            bo.d((View)this, (float)typedArray.getDimensionPixelSize(i.SnackbarLayout_elevation, 0));
        }
        typedArray.recycle();
        this.setClickable(true);
        LayoutInflater.from((Context)context).inflate(g.design_layout_snackbar_include, (ViewGroup)this);
        bo.d((View)this, 1);
        bo.c((View)this, 1);
    }

    private static void a(View view, int n2, int n3) {
        if (bo.w(view)) {
            bo.a(view, bo.k(view), n2, bo.l(view), n3);
            return;
        }
        view.setPadding(view.getPaddingLeft(), n2, view.getPaddingRight(), n3);
    }

    private boolean a(int n2, int n3, int n4) {
        int n5 = this.getOrientation();
        boolean bl2 = false;
        if (n2 != n5) {
            this.setOrientation(n2);
            bl2 = true;
        }
        if (this.a.getPaddingTop() == n3) {
            if (this.a.getPaddingBottom() == n4) return bl2;
        }
        Snackbar$SnackbarLayout.a((View)this.a, n3, n4);
        return true;
    }

    void a(int n2, int n3) {
        bo.c((View)this.a, 0.0f);
        bo.q((View)this.a).a(1.0f).a(n3).b(n2).c();
        if (this.b.getVisibility() != 0) return;
        bo.c((View)this.b, 0.0f);
        bo.q((View)this.b).a(1.0f).a(n3).b(n2).c();
    }

    void b(int n2, int n3) {
        bo.c((View)this.a, 1.0f);
        bo.q((View)this.a).a(0.0f).a(n3).b(n2).c();
        if (this.b.getVisibility() != 0) return;
        bo.c((View)this.b, 1.0f);
        bo.q((View)this.b).a(0.0f).a(n3).b(n2).c();
    }

    Button getActionView() {
        return this.b;
    }

    TextView getMessageView() {
        return this.a;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f == null) return;
        this.f.a((View)this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f == null) return;
        this.f.b((View)this);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (TextView)this.findViewById(f.snackbar_text);
        this.b = (Button)this.findViewById(f.snackbar_action);
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        super.onLayout(bl2, n2, n3, n4, n5);
        if (this.e == null) return;
        this.e.a((View)this, n2, n3, n4, n5);
    }

    /*
     * Unable to fully structure code
     */
    protected void onMeasure(int var1_1, int var2_2) {
        super.onMeasure(var1_1, var2_2);
        if (this.c > 0 && this.getMeasuredWidth() > this.c) {
            var1_1 = View.MeasureSpec.makeMeasureSpec((int)this.c, (int)1073741824);
            super.onMeasure(var1_1, var2_2);
        }
        var3_3 = this.getResources().getDimensionPixelSize(e.design_snackbar_padding_vertical_2lines);
        var4_4 = this.getResources().getDimensionPixelSize(e.design_snackbar_padding_vertical);
        var5_5 = this.a.getLayout().getLineCount() > 1;
        if (!var5_5) ** GOTO lbl-1000
        if (this.d > 0) {
            ** if (this.b.getMeasuredWidth() <= this.d) goto lbl-1000
lbl-1000: // 1 sources:
            {
                if (this.a((int)1, (int)var3_3, (int)(var3_3 - var4_4)) == false) return;
                var6_6 = true;
                ** GOTO lbl19
            }
        }
        ** GOTO lbl17
lbl-1000: // 2 sources:
        {
            if (!var5_5) {
                var3_3 = var4_4;
            }
lbl17: // 4 sources:
            if (this.a(0, var3_3, var3_3) == false) return;
            var6_6 = true;
        }
lbl19: // 2 sources:
        if (var6_6 == false) return;
        super.onMeasure(var1_1, var2_2);
    }

    void setOnAttachStateChangeListener(bh bh2) {
        this.f = bh2;
    }

    void setOnLayoutChangeListener(bi bi2) {
        this.e = bi2;
    }
}

