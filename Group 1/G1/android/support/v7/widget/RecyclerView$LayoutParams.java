package android.support.v7.widget;

import android.view.ViewGroup$LayoutParams;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup$MarginLayoutParams;

public static class LayoutParams extends ViewGroup$MarginLayoutParams
{
    final Rect mDecorInsets;
    boolean mInsetsDirty;
    boolean mPendingInvalidate;
    ViewHolder mViewHolder;
    
    public LayoutParams(final int n, final int n2) {
        super(n, n2);
        this.mDecorInsets = new Rect();
        this.mInsetsDirty = true;
        this.mPendingInvalidate = false;
    }
    
    public LayoutParams(final Context context, final AttributeSet set) {
        super(context, set);
        this.mDecorInsets = new Rect();
        this.mInsetsDirty = true;
        this.mPendingInvalidate = false;
    }
    
    public LayoutParams(final LayoutParams layoutParams) {
        super((ViewGroup$LayoutParams)layoutParams);
        this.mDecorInsets = new Rect();
        this.mInsetsDirty = true;
        this.mPendingInvalidate = false;
    }
    
    public LayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
        this.mDecorInsets = new Rect();
        this.mInsetsDirty = true;
        this.mPendingInvalidate = false;
    }
    
    public LayoutParams(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        super(viewGroup$MarginLayoutParams);
        this.mDecorInsets = new Rect();
        this.mInsetsDirty = true;
        this.mPendingInvalidate = false;
    }
    
    public int getViewAdapterPosition() {
        return mViewHolder.getAdapterPosition();
    }
    
    public int getViewLayoutPosition() {
        return mViewHolder.getLayoutPosition();
    }
    
    public int getViewPosition() {
        return mViewHolder.getPosition();
    }
    
    public boolean isItemChanged() {
        return mViewHolder.isUpdated();
    }
    
    public boolean isItemRemoved() {
        return mViewHolder.isRemoved();
    }
    
    public boolean isViewInvalid() {
        return mViewHolder.isInvalid();
    }
    
    public boolean viewNeedsUpdate() {
        return mViewHolder.needsUpdate();
    }
}
