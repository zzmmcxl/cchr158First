package android.support.design.widget;

import android.view.ViewParent;
import android.os.Build$VERSION;
import android.support.v4.view.ViewCompat;
import android.view.View;

class ViewOffsetHelper
{
    private int mLayoutLeft;
    private int mLayoutTop;
    private int mOffsetLeft;
    private int mOffsetTop;
    private final View mView;
    
    public ViewOffsetHelper(final View mView) {
        super();
        mView = mView;
    }
    
    private static void tickleInvalidationFlag(final View view) {
        final float translationY = ViewCompat.getTranslationY(view);
        ViewCompat.setTranslationY(view, 1.0f + translationY);
        ViewCompat.setTranslationY(view, translationY);
    }
    
    private void updateOffsets() {
        ViewCompat.offsetTopAndBottom(mView, mOffsetTop - (mView.getTop() - mLayoutTop));
        ViewCompat.offsetLeftAndRight(mView, mOffsetLeft - (mView.getLeft() - mLayoutLeft));
        if (Build$VERSION.SDK_INT < 23) {
            tickleInvalidationFlag(mView);
            final ViewParent parent = mView.getParent();
            if (parent instanceof View) {
                tickleInvalidationFlag((View)parent);
            }
        }
    }
    
    public int getLeftAndRightOffset() {
        return mOffsetLeft;
    }
    
    public int getTopAndBottomOffset() {
        return mOffsetTop;
    }
    
    public void onViewLayout() {
        mLayoutTop = mView.getTop();
        mLayoutLeft = mView.getLeft();
        this.updateOffsets();
    }
    
    public boolean setLeftAndRightOffset(final int mOffsetLeft) {
        if (this.mOffsetLeft != mOffsetLeft) {
            this.mOffsetLeft = mOffsetLeft;
            this.updateOffsets();
            return true;
        }
        return false;
    }
    
    public boolean setTopAndBottomOffset(final int mOffsetTop) {
        if (this.mOffsetTop != mOffsetTop) {
            this.mOffsetTop = mOffsetTop;
            this.updateOffsets();
            return true;
        }
        return false;
    }
}
