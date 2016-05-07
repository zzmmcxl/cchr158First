/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.a.d;
import android.support.v7.b.b;
import android.support.v7.widget.bs;
import android.support.v7.widget.cz;
import android.support.v7.widget.da;
import android.support.v7.widget.fn;
import android.support.v7.widget.gk;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

class fr
extends cz
implements View.OnLongClickListener {
    final /* synthetic */ fn a;
    private final int[] b;
    private d c;
    private TextView d;
    private ImageView e;
    private View f;

    public fr(fn fn2, Context context, d d2, boolean bl2) {
        this.a = fn2;
        super(context, null, b.actionBarTabStyle);
        this.b = new int[]{16842964};
        this.c = d2;
        gk gk2 = gk.a(context, null, this.b, b.actionBarTabStyle, 0);
        if (gk2.f(0)) {
            this.setBackgroundDrawable(gk2.a(0));
        }
        gk2.a();
        if (bl2) {
            this.setGravity(8388627);
        }
        this.a();
    }

    public void a() {
        d d2 = this.c;
        View view = d2.c();
        if (view != null) {
            ViewParent viewParent = view.getParent();
            if (viewParent != this) {
                if (viewParent != null) {
                    ((ViewGroup)viewParent).removeView(view);
                }
                this.addView(view);
            }
            this.f = view;
            if (this.d != null) {
                this.d.setVisibility(8);
            }
            if (this.e == null) return;
            this.e.setVisibility(8);
            this.e.setImageDrawable(null);
            return;
        }
        if (this.f != null) {
            this.removeView(this.f);
            this.f = null;
        }
        Drawable drawable = d2.a();
        CharSequence charSequence = d2.b();
        if (drawable != null) {
            if (this.e == null) {
                ImageView imageView = new ImageView(this.getContext());
                da da2 = new da(-2, -2);
                da2.h = 16;
                imageView.setLayoutParams((ViewGroup.LayoutParams)da2);
                this.addView((View)imageView, 0);
                this.e = imageView;
            }
            this.e.setImageDrawable(drawable);
            this.e.setVisibility(0);
        } else if (this.e != null) {
            this.e.setVisibility(8);
            this.e.setImageDrawable(null);
        }
        boolean bl2 = !TextUtils.isEmpty((CharSequence)charSequence);
        if (bl2) {
            if (this.d == null) {
                bs bs2 = new bs(this.getContext(), null, b.actionBarTabTextStyle);
                bs2.setEllipsize(TextUtils.TruncateAt.END);
                da da3 = new da(-2, -2);
                da3.h = 16;
                bs2.setLayoutParams((ViewGroup.LayoutParams)da3);
                this.addView((View)bs2);
                this.d = bs2;
            }
            this.d.setText(charSequence);
            this.d.setVisibility(0);
        } else if (this.d != null) {
            this.d.setVisibility(8);
            this.d.setText(null);
        }
        if (this.e != null) {
            this.e.setContentDescription(d2.e());
        }
        if (!bl2 && !TextUtils.isEmpty((CharSequence)d2.e())) {
            this.setOnLongClickListener((View.OnLongClickListener)this);
            return;
        }
        this.setOnLongClickListener(null);
        this.setLongClickable(false);
    }

    public void a(d d2) {
        this.c = d2;
        this.a();
    }

    public d b() {
        return this.c;
    }

    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)d.class.getName());
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (Build.VERSION.SDK_INT < 14) return;
        accessibilityNodeInfo.setClassName((CharSequence)d.class.getName());
    }

    public boolean onLongClick(View view) {
        int[] arrn = new int[2];
        this.getLocationOnScreen(arrn);
        Context context = this.getContext();
        int n2 = this.getWidth();
        int n3 = this.getHeight();
        int n4 = context.getResources().getDisplayMetrics().widthPixels;
        Toast toast = Toast.makeText((Context)context, (CharSequence)this.c.e(), (int)0);
        toast.setGravity(49, arrn[0] + n2 / 2 - n4 / 2, n3);
        toast.show();
        return true;
    }

    @Override
    public void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        if (this.a.b <= 0) return;
        if (this.getMeasuredWidth() <= this.a.b) return;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int)this.a.b, (int)1073741824), n3);
    }

    public void setSelected(boolean bl2) {
        boolean bl3 = this.isSelected() != bl2;
        super.setSelected(bl2);
        if (!bl3) return;
        if (!bl2) return;
        this.sendAccessibilityEvent(4);
    }
}

