package android.support.v7.app;

import android.view.ViewGroup$LayoutParams;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.support.annotation.NonNull;
import android.content.Context;
import android.view.ViewGroup$MarginLayoutParams;

public static class LayoutParams extends ViewGroup$MarginLayoutParams
{
    public int gravity;
    
    public LayoutParams(final int n) {
        this(-2, -1, n);
    }
    
    public LayoutParams(final int n, final int n2) {
        super(n, n2);
        this.gravity = 0;
        this.gravity = 8388627;
    }
    
    public LayoutParams(final int n, final int n2, final int gravity) {
        super(n, n2);
        this.gravity = 0;
        this.gravity = gravity;
    }
    
    public LayoutParams(@NonNull final Context context, final AttributeSet set) {
        super(context, set);
        this.gravity = 0;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.ActionBarLayout);
        this.gravity = obtainStyledAttributes.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
        obtainStyledAttributes.recycle();
    }
    
    public LayoutParams(final LayoutParams layoutParams) {
        super((ViewGroup$MarginLayoutParams)layoutParams);
        this.gravity = 0;
        this.gravity = layoutParams.gravity;
    }
    
    public LayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
        this.gravity = 0;
    }
}
