package android.support.v4.widget;

import android.view.ViewGroup$LayoutParams;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;
import android.view.ViewGroup$MarginLayoutParams;

public static class LayoutParams extends ViewGroup$MarginLayoutParams
{
    private static final int FLAG_IS_CLOSING = 4;
    private static final int FLAG_IS_OPENED = 1;
    private static final int FLAG_IS_OPENING = 2;
    public int gravity;
    private boolean isPeeking;
    private float onScreen;
    private int openState;
    
    public LayoutParams(final int n, final int n2) {
        super(n, n2);
        this.gravity = 0;
    }
    
    public LayoutParams(final int n, final int n2, final int gravity) {
        this(n, n2);
        this.gravity = gravity;
    }
    
    public LayoutParams(final Context context, final AttributeSet set) {
        super(context, set);
        this.gravity = 0;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, DrawerLayout.access$400());
        this.gravity = obtainStyledAttributes.getInt(0, 0);
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
    
    public LayoutParams(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        super(viewGroup$MarginLayoutParams);
        this.gravity = 0;
    }
    
    static /* synthetic */ float access$000(final LayoutParams layoutParams) {
        return layoutParams.onScreen;
    }
    
    static /* synthetic */ float access$002(final LayoutParams layoutParams, final float onScreen) {
        return layoutParams.onScreen = onScreen;
    }
    
    static /* synthetic */ int access$100(final LayoutParams layoutParams) {
        return layoutParams.openState;
    }
    
    static /* synthetic */ int access$102(final LayoutParams layoutParams, final int openState) {
        return layoutParams.openState = openState;
    }
    
    static /* synthetic */ int access$176(final LayoutParams layoutParams, final int n) {
        return layoutParams.openState |= n;
    }
    
    static /* synthetic */ boolean access$200(final LayoutParams layoutParams) {
        return layoutParams.isPeeking;
    }
    
    static /* synthetic */ boolean access$202(final LayoutParams layoutParams, final boolean isPeeking) {
        return layoutParams.isPeeking = isPeeking;
    }
}
