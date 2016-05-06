package android.support.v7.widget;

import android.view.ViewGroup$LayoutParams;
import android.util.AttributeSet;
import android.content.Context;
import android.view.ViewGroup$MarginLayoutParams;

public static class LayoutParams extends ViewGroup$MarginLayoutParams
{
    public LayoutParams(final int n, final int n2) {
        super(n, n2);
    }
    
    public LayoutParams(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public LayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
    }
    
    public LayoutParams(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        super(viewGroup$MarginLayoutParams);
    }
}
