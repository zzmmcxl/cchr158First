/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.design.c;
import android.support.design.e;
import android.support.design.f;
import android.support.design.g;
import android.support.design.internal.a;
import android.support.v4.widget.az;
import android.support.v7.view.menu.aa;
import android.support.v7.view.menu.m;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.TextView;

public class NavigationMenuItemView
extends a
implements aa {
    private static final int[] c = new int[]{16842912};
    private final int d;
    private final CheckedTextView e;
    private FrameLayout f;
    private m g;
    private ColorStateList h;

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.setOrientation(0);
        LayoutInflater.from((Context)context).inflate(g.design_navigation_menu_item, (ViewGroup)this, true);
        this.d = context.getResources().getDimensionPixelSize(e.design_navigation_icon_size);
        this.e = (CheckedTextView)this.findViewById(f.design_menu_item_text);
        this.e.setDuplicateParentStateEnabled(true);
    }

    private StateListDrawable b() {
        TypedValue typedValue = new TypedValue();
        if (!this.getContext().getTheme().resolveAttribute(c.colorControlHighlight, typedValue, true)) return null;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(c, (Drawable)new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, (Drawable)new ColorDrawable(0));
        return stateListDrawable;
    }

    private void setActionView(View view) {
        if (this.f == null) {
            this.f = (FrameLayout)((ViewStub)this.findViewById(f.design_menu_item_action_area_stub)).inflate();
        }
        this.f.removeAllViews();
        if (view == null) return;
        this.f.addView(view);
    }

    @Override
    public void a(m m2, int n2) {
        this.g = m2;
        int n3 = m2.isVisible() ? 0 : 8;
        this.setVisibility(n3);
        if (this.getBackground() == null) {
            this.setBackgroundDrawable((Drawable)this.b());
        }
        this.setCheckable(m2.isCheckable());
        this.setChecked(m2.isChecked());
        this.setEnabled(m2.isEnabled());
        this.setTitle(m2.getTitle());
        this.setIcon(m2.getIcon());
        this.setActionView(m2.getActionView());
    }

    @Override
    public boolean a() {
        return false;
    }

    @Override
    public m getItemData() {
        return this.g;
    }

    protected int[] onCreateDrawableState(int n2) {
        int[] arrn = super.onCreateDrawableState(n2 + 1);
        if (this.g == null) return arrn;
        if (!this.g.isCheckable()) return arrn;
        if (!this.g.isChecked()) return arrn;
        NavigationMenuItemView.mergeDrawableStates((int[])arrn, (int[])c);
        return arrn;
    }

    public void setCheckable(boolean bl2) {
        this.refreshDrawableState();
    }

    public void setChecked(boolean bl2) {
        this.refreshDrawableState();
        this.e.setChecked(bl2);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = android.support.v4.c.a.a.f(drawable).mutate();
            drawable.setBounds(0, 0, this.d, this.d);
            android.support.v4.c.a.a.a(drawable, this.h);
        }
        az.a((TextView)this.e, drawable, null, null, null);
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.h = colorStateList;
        if (this.g == null) return;
        this.setIcon(this.g.getIcon());
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.e.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.e.setText(charSequence);
    }
}

