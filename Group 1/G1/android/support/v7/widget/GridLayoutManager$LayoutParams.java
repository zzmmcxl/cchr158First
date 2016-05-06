package android.support.v7.widget;

import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup$LayoutParams;
import android.util.AttributeSet;
import android.content.Context;

public static class LayoutParams extends RecyclerView.LayoutParams
{
    public static final int INVALID_SPAN_ID = -1;
    private int mSpanIndex;
    private int mSpanSize;
    
    public LayoutParams(final int n, final int n2) {
        super(n, n2);
        this.mSpanIndex = -1;
        this.mSpanSize = 0;
    }
    
    public LayoutParams(final Context context, final AttributeSet set) {
        super(context, set);
        this.mSpanIndex = -1;
        this.mSpanSize = 0;
    }
    
    public LayoutParams(final RecyclerView.LayoutParams layoutParams) {
        super(layoutParams);
        this.mSpanIndex = -1;
        this.mSpanSize = 0;
    }
    
    public LayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
        this.mSpanIndex = -1;
        this.mSpanSize = 0;
    }
    
    public LayoutParams(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        super(viewGroup$MarginLayoutParams);
        this.mSpanIndex = -1;
        this.mSpanSize = 0;
    }
    
    static /* synthetic */ int access$000(final LayoutParams layoutParams) {
        return layoutParams.mSpanIndex;
    }
    
    static /* synthetic */ int access$002(final LayoutParams layoutParams, final int mSpanIndex) {
        return layoutParams.mSpanIndex = mSpanIndex;
    }
    
    static /* synthetic */ int access$100(final LayoutParams layoutParams) {
        return layoutParams.mSpanSize;
    }
    
    static /* synthetic */ int access$102(final LayoutParams layoutParams, final int mSpanSize) {
        return layoutParams.mSpanSize = mSpanSize;
    }
    
    public int getSpanIndex() {
        return mSpanIndex;
    }
    
    public int getSpanSize() {
        return mSpanSize;
    }
}
