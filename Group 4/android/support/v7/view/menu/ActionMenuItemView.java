/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.h.bo;
import android.support.v7.b.l;
import android.support.v7.view.menu.aa;
import android.support.v7.view.menu.b;
import android.support.v7.view.menu.c;
import android.support.v7.view.menu.k;
import android.support.v7.view.menu.m;
import android.support.v7.widget.bs;
import android.support.v7.widget.dk;
import android.support.v7.widget.u;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class ActionMenuItemView
extends bs
implements aa,
u,
View.OnClickListener,
View.OnLongClickListener {
    private m a;
    private CharSequence b;
    private Drawable c;
    private k d;
    private dk e;
    private c f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private int k;

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        Resources resources = context.getResources();
        this.g = resources.getBoolean(android.support.v7.b.c.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, l.ActionMenuItemView, n2, 0);
        this.i = typedArray.getDimensionPixelSize(l.ActionMenuItemView_android_minWidth, 0);
        typedArray.recycle();
        this.k = (int)(0.5f + 32.0f * resources.getDisplayMetrics().density);
        this.setOnClickListener((View.OnClickListener)this);
        this.setOnLongClickListener((View.OnLongClickListener)this);
        this.j = -1;
    }

    static /* synthetic */ c a(ActionMenuItemView actionMenuItemView) {
        return actionMenuItemView.f;
    }

    static /* synthetic */ k b(ActionMenuItemView actionMenuItemView) {
        return actionMenuItemView.d;
    }

    static /* synthetic */ m c(ActionMenuItemView actionMenuItemView) {
        return actionMenuItemView.a;
    }

    /*
     * Unable to fully structure code
     */
    private void e() {
        var1_1 = TextUtils.isEmpty((CharSequence)this.b) == false;
        if (this.c == null) ** GOTO lbl-1000
        var4_2 = this.a.m();
        var2_3 = false;
        if (!var4_2) ** GOTO lbl11
        if (this.g) ** GOTO lbl-1000
        var5_4 = this.h;
        var2_3 = false;
        if (var5_4) lbl-1000: // 3 sources:
        {
            var2_3 = true;
        }
lbl11: // 4 sources:
        var3_5 = (var1_1 & var2_3) != false ? this.b : null;
        this.setText(var3_5);
    }

    @Override
    public void a(m m2, int n2) {
        this.a = m2;
        this.setIcon(m2.getIcon());
        this.setTitle(m2.a(this));
        this.setId(m2.getItemId());
        int n3 = m2.isVisible() ? 0 : 8;
        this.setVisibility(n3);
        this.setEnabled(m2.isEnabled());
        if (!m2.hasSubMenu()) return;
        if (this.e != null) return;
        this.e = new b(this);
    }

    @Override
    public boolean a() {
        return true;
    }

    public boolean b() {
        if (TextUtils.isEmpty((CharSequence)this.getText())) return false;
        return true;
    }

    @Override
    public boolean c() {
        if (!this.b()) return false;
        if (this.a.getIcon() != null) return false;
        return true;
    }

    @Override
    public boolean d() {
        return this.b();
    }

    @Override
    public m getItemData() {
        return this.a;
    }

    public void onClick(View view) {
        if (this.d == null) return;
        this.d.a(this.a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.g = this.getContext().getResources().getBoolean(android.support.v7.b.c.abc_config_allowActionMenuItemTextWithIcon);
        this.e();
    }

    public boolean onLongClick(View view) {
        if (this.b()) {
            return false;
        }
        int[] arrn = new int[2];
        Rect rect = new Rect();
        this.getLocationOnScreen(arrn);
        this.getWindowVisibleDisplayFrame(rect);
        Context context = this.getContext();
        int n2 = this.getWidth();
        int n3 = this.getHeight();
        int n4 = arrn[1] + n3 / 2;
        int n5 = arrn[0] + n2 / 2;
        if (bo.h(view) == 0) {
            n5 = context.getResources().getDisplayMetrics().widthPixels - n5;
        }
        Toast toast = Toast.makeText((Context)context, (CharSequence)this.a.getTitle(), (int)0);
        if (n4 < rect.height()) {
            toast.setGravity(8388661, n5, n3 + arrn[1] - rect.top);
        } else {
            toast.setGravity(81, 0, n3);
        }
        toast.show();
        return true;
    }

    protected void onMeasure(int n2, int n3) {
        boolean bl2 = this.b();
        if (bl2 && this.j >= 0) {
            super.setPadding(this.j, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        }
        super.onMeasure(n2, n3);
        int n4 = View.MeasureSpec.getMode((int)n2);
        int n5 = View.MeasureSpec.getSize((int)n2);
        int n6 = this.getMeasuredWidth();
        int n7 = n4 == Integer.MIN_VALUE ? Math.min(n5, this.i) : this.i;
        if (n4 != 1073741824 && this.i > 0 && n6 < n7) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((int)n7, (int)1073741824), n3);
        }
        if (bl2) return;
        if (this.c == null) return;
        super.setPadding((this.getMeasuredWidth() - this.c.getBounds().width()) / 2, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.a.hasSubMenu()) return super.onTouchEvent(motionEvent);
        if (this.e == null) return super.onTouchEvent(motionEvent);
        if (!this.e.onTouch((View)this, motionEvent)) return super.onTouchEvent(motionEvent);
        return true;
    }

    public void setCheckable(boolean bl2) {
    }

    public void setChecked(boolean bl2) {
    }

    public void setExpandedFormat(boolean bl2) {
        if (this.h == bl2) return;
        this.h = bl2;
        if (this.a == null) return;
        this.a.h();
    }

    public void setIcon(Drawable drawable) {
        this.c = drawable;
        if (drawable != null) {
            int n2 = drawable.getIntrinsicWidth();
            int n3 = drawable.getIntrinsicHeight();
            if (n2 > this.k) {
                float f2 = (float)this.k / (float)n2;
                n2 = this.k;
                n3 = (int)(f2 * (float)n3);
            }
            if (n3 > this.k) {
                float f3 = (float)this.k / (float)n3;
                n3 = this.k;
                n2 = (int)(f3 * (float)n2);
            }
            drawable.setBounds(0, 0, n2, n3);
        }
        this.setCompoundDrawables(drawable, null, null, null);
        this.e();
    }

    public void setItemInvoker(k k2) {
        this.d = k2;
    }

    public void setPadding(int n2, int n3, int n4, int n5) {
        this.j = n2;
        super.setPadding(n2, n3, n4, n5);
    }

    public void setPopupCallback(c c2) {
        this.f = c2;
    }

    public void setTitle(CharSequence charSequence) {
        this.b = charSequence;
        this.setContentDescription(this.b);
        this.e();
    }
}

