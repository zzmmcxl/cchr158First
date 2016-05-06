package android.support.design.widget;

import android.util.AttributeSet;
import android.content.Context;
import android.view.View;

class ViewOffsetBehavior<V extends View> extends Behavior<V>
{
    private int mTempLeftRightOffset;
    private int mTempTopBottomOffset;
    private ViewOffsetHelper mViewOffsetHelper;
    
    public ViewOffsetBehavior() {
        super();
        mTempTopBottomOffset = 0;
        mTempLeftRightOffset = 0;
    }
    
    public ViewOffsetBehavior(final Context context, final AttributeSet set) {
        super(context, set);
        mTempTopBottomOffset = 0;
        mTempLeftRightOffset = 0;
    }
    
    public int getLeftAndRightOffset() {
        if (mViewOffsetHelper != null) {
            return mViewOffsetHelper.getLeftAndRightOffset();
        }
        return 0;
    }
    
    public int getTopAndBottomOffset() {
        if (mViewOffsetHelper != null) {
            return mViewOffsetHelper.getTopAndBottomOffset();
        }
        return 0;
    }
    
    protected void layoutChild(final CoordinatorLayout coordinatorLayout, final V v, final int n) {
        coordinatorLayout.onLayoutChild(v, n);
    }
    
    @Override
    public boolean onLayoutChild(final CoordinatorLayout coordinatorLayout, final V v, final int n) {
        this.layoutChild(coordinatorLayout, v, n);
        if (mViewOffsetHelper == null) {
            mViewOffsetHelper = new ViewOffsetHelper(v);
        }
        mViewOffsetHelper.onViewLayout();
        if (mTempTopBottomOffset != 0) {
            mViewOffsetHelper.setTopAndBottomOffset(mTempTopBottomOffset);
            mTempTopBottomOffset = 0;
        }
        if (mTempLeftRightOffset != 0) {
            mViewOffsetHelper.setLeftAndRightOffset(mTempLeftRightOffset);
            mTempLeftRightOffset = 0;
        }
        return true;
    }
    
    public boolean setLeftAndRightOffset(final int n) {
        if (mViewOffsetHelper != null) {
            return mViewOffsetHelper.setLeftAndRightOffset(n);
        }
        mTempLeftRightOffset = n;
        return false;
    }
    
    public boolean setTopAndBottomOffset(final int n) {
        if (mViewOffsetHelper != null) {
            return mViewOffsetHelper.setTopAndBottomOffset(n);
        }
        mTempTopBottomOffset = n;
        return false;
    }
}
