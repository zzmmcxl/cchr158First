package android.support.v7.widget;

import android.util.AttributeSet;
import android.content.Context;

public static class InnerLayout extends LinearLayoutCompat
{
    private static final int[] TINT_ATTRS;
    
    static {
        TINT_ATTRS = new int[] { 16842964 };
    }
    
    public InnerLayout(final Context context, final AttributeSet set) {
        super(context, set);
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, set, TINT_ATTRS);
        this.setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
        obtainStyledAttributes.recycle();
    }
}
