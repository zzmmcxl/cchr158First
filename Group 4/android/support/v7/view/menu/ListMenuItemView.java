/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.b.g;
import android.support.v7.b.i;
import android.support.v7.b.l;
import android.support.v7.view.menu.aa;
import android.support.v7.view.menu.m;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView
extends LinearLayout
implements aa {
    private m a;
    private ImageView b;
    private RadioButton c;
    private TextView d;
    private CheckBox e;
    private TextView f;
    private Drawable g;
    private int h;
    private Context i;
    private boolean j;
    private int k;
    private Context l;
    private LayoutInflater m;
    private boolean n;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet);
        this.l = context;
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, l.MenuView, n2, 0);
        this.g = typedArray.getDrawable(l.MenuView_android_itemBackground);
        this.h = typedArray.getResourceId(l.MenuView_android_itemTextAppearance, -1);
        this.j = typedArray.getBoolean(l.MenuView_preserveIconSpacing, false);
        this.i = context;
        typedArray.recycle();
    }

    private void b() {
        this.b = (ImageView)this.getInflater().inflate(i.abc_list_menu_item_icon, (ViewGroup)this, false);
        this.addView((View)this.b, 0);
    }

    private void c() {
        this.c = (RadioButton)this.getInflater().inflate(i.abc_list_menu_item_radio, (ViewGroup)this, false);
        this.addView((View)this.c);
    }

    private void d() {
        this.e = (CheckBox)this.getInflater().inflate(i.abc_list_menu_item_checkbox, (ViewGroup)this, false);
        this.addView((View)this.e);
    }

    private LayoutInflater getInflater() {
        if (this.m != null) return this.m;
        this.m = LayoutInflater.from((Context)this.l);
        return this.m;
    }

    @Override
    public void a(m m2, int n2) {
        this.a = m2;
        this.k = n2;
        int n3 = m2.isVisible() ? 0 : 8;
        this.setVisibility(n3);
        this.setTitle(m2.a(this));
        this.setCheckable(m2.isCheckable());
        this.a(m2.f(), m2.d());
        this.setIcon(m2.getIcon());
        this.setEnabled(m2.isEnabled());
    }

    public void a(boolean bl2, char c2) {
        int n2 = bl2 && this.a.f() ? 0 : 8;
        if (n2 == 0) {
            this.f.setText((CharSequence)this.a.e());
        }
        if (this.f.getVisibility() == n2) return;
        this.f.setVisibility(n2);
    }

    @Override
    public boolean a() {
        return false;
    }

    @Override
    public m getItemData() {
        return this.a;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.setBackgroundDrawable(this.g);
        this.d = (TextView)this.findViewById(g.title);
        if (this.h != -1) {
            this.d.setTextAppearance(this.i, this.h);
        }
        this.f = (TextView)this.findViewById(g.shortcut);
    }

    protected void onMeasure(int n2, int n3) {
        if (this.b != null && this.j) {
            ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams)this.b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(n2, n3);
    }

    public void setCheckable(boolean bl2) {
        CheckBox checkBox;
        RadioButton radioButton;
        if (!bl2 && this.c == null && this.e == null) {
            return;
        }
        if (this.a.g()) {
            if (this.c == null) {
                this.c();
            }
            RadioButton radioButton2 = this.c;
            CheckBox checkBox2 = this.e;
            radioButton = radioButton2;
            checkBox = checkBox2;
        } else {
            if (this.e == null) {
                this.d();
            }
            CheckBox checkBox3 = this.e;
            RadioButton radioButton3 = this.c;
            radioButton = checkBox3;
            checkBox = radioButton3;
        }
        if (bl2) {
            radioButton.setChecked(this.a.isChecked());
            int n2 = bl2 ? 0 : 8;
            if (radioButton.getVisibility() != n2) {
                radioButton.setVisibility(n2);
            }
            if (checkBox == null) return;
            if (checkBox.getVisibility() == 8) return;
            checkBox.setVisibility(8);
            return;
        }
        if (this.e != null) {
            this.e.setVisibility(8);
        }
        if (this.c == null) return;
        this.c.setVisibility(8);
    }

    public void setChecked(boolean bl2) {
        RadioButton radioButton;
        if (this.a.g()) {
            if (this.c == null) {
                this.c();
            }
            radioButton = this.c;
        } else {
            if (this.e == null) {
                this.d();
            }
            radioButton = this.e;
        }
        radioButton.setChecked(bl2);
    }

    public void setForceShowIcon(boolean bl2) {
        this.n = bl2;
        this.j = bl2;
    }

    public void setIcon(Drawable drawable) {
        boolean bl2 = this.a.i() || this.n;
        if (!bl2 && !this.j) {
            return;
        }
        if (this.b == null && drawable == null) {
            if (!this.j) return;
        }
        if (this.b == null) {
            this.b();
        }
        if (drawable == null && !this.j) {
            this.b.setVisibility(8);
            return;
        }
        ImageView imageView = this.b;
        if (!bl2) {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
        if (this.b.getVisibility() == 0) return;
        this.b.setVisibility(0);
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.d.setText(charSequence);
            if (this.d.getVisibility() == 0) return;
            this.d.setVisibility(0);
            return;
        }
        if (this.d.getVisibility() == 8) return;
        this.d.setVisibility(8);
    }
}

