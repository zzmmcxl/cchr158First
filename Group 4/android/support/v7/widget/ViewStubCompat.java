/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.b.l;
import android.support.v7.widget.gy;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class ViewStubCompat
extends View {
    private int a = 0;
    private int b;
    private WeakReference c;
    private LayoutInflater d;
    private gy e;

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, l.ViewStubCompat, n2, 0);
        this.b = typedArray.getResourceId(l.ViewStubCompat_android_inflatedId, -1);
        this.a = typedArray.getResourceId(l.ViewStubCompat_android_layout, 0);
        this.setId(typedArray.getResourceId(l.ViewStubCompat_android_id, -1));
        typedArray.recycle();
        this.setVisibility(8);
        this.setWillNotDraw(true);
    }

    public View a() {
        ViewParent viewParent = this.getParent();
        if (viewParent == null) throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        if (!(viewParent instanceof ViewGroup)) throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        if (this.a == 0) throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        ViewGroup viewGroup = (ViewGroup)viewParent;
        LayoutInflater layoutInflater = this.d != null ? this.d : LayoutInflater.from((Context)this.getContext());
        View view = layoutInflater.inflate(this.a, viewGroup, false);
        if (this.b != -1) {
            view.setId(this.b);
        }
        int n2 = viewGroup.indexOfChild((View)this);
        viewGroup.removeViewInLayout((View)this);
        ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, n2, layoutParams);
        } else {
            viewGroup.addView(view, n2);
        }
        this.c = new WeakReference<View>(view);
        if (this.e == null) return view;
        this.e.a(this, view);
        return view;
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.d;
    }

    public int getLayoutResource() {
        return this.a;
    }

    protected void onMeasure(int n2, int n3) {
        this.setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int n2) {
        this.b = n2;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.d = layoutInflater;
    }

    public void setLayoutResource(int n2) {
        this.a = n2;
    }

    public void setOnInflateListener(gy gy2) {
        this.e = gy2;
    }

    public void setVisibility(int n2) {
        if (this.c != null) {
            View view = (View)this.c.get();
            if (view == null) throw new IllegalStateException("setVisibility called on un-referenced view");
            view.setVisibility(n2);
            return;
        }
        super.setVisibility(n2);
        if (n2 != 0) {
            if (n2 != 4) return;
        }
        this.a();
    }
}

