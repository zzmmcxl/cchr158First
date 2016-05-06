package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

public class NestedScrollingChildHelper
{
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParent;
    private int[] mTempNestedScrollConsumed;
    private final View mView;
    
    public NestedScrollingChildHelper(final View mView) {
        super();
        mView = mView;
    }
    
    public boolean dispatchNestedFling(final float n, final float n2, final boolean b) {
        return this.isNestedScrollingEnabled() && mNestedScrollingParent != null && ViewParentCompat.onNestedFling(mNestedScrollingParent, mView, n, n2, b);
    }
    
    public boolean dispatchNestedPreFling(final float n, final float n2) {
        return this.isNestedScrollingEnabled() && mNestedScrollingParent != null && ViewParentCompat.onNestedPreFling(mNestedScrollingParent, mView, n, n2);
    }
    
    public boolean dispatchNestedPreScroll(final int n, final int n2, int[] mTempNestedScrollConsumed, final int[] array) {
        final boolean nestedScrollingEnabled = this.isNestedScrollingEnabled();
        boolean b = false;
        if (nestedScrollingEnabled) {
            final ViewParent mNestedScrollingParent = this.mNestedScrollingParent;
            b = false;
            if (mNestedScrollingParent != null) {
                if (n != 0 || n2 != 0) {
                    int n3 = 0;
                    int n4 = 0;
                    if (array != null) {
                        mView.getLocationInWindow(array);
                        n3 = array[0];
                        n4 = array[1];
                    }
                    if (mTempNestedScrollConsumed == null) {
                        if (this.mTempNestedScrollConsumed == null) {
                            this.mTempNestedScrollConsumed = new int[2];
                        }
                        mTempNestedScrollConsumed = this.mTempNestedScrollConsumed;
                    }
                    mTempNestedScrollConsumed[1] = (mTempNestedScrollConsumed[0] = 0);
                    ViewParentCompat.onNestedPreScroll(this.mNestedScrollingParent, mView, n, n2, mTempNestedScrollConsumed);
                    if (array != null) {
                        mView.getLocationInWindow(array);
                        array[0] -= n3;
                        array[1] -= n4;
                    }
                    if (mTempNestedScrollConsumed[0] == 0) {
                        final int n5 = mTempNestedScrollConsumed[1];
                        b = false;
                        if (n5 == 0) {
                            return b;
                        }
                    }
                    b = true;
                }
                else {
                    b = false;
                    if (array != null) {
                        array[1] = (array[0] = 0);
                        return false;
                    }
                }
            }
        }
        return b;
    }
    
    public boolean dispatchNestedScroll(final int n, final int n2, final int n3, final int n4, final int[] array) {
        if (this.isNestedScrollingEnabled() && mNestedScrollingParent != null) {
            if (n != 0 || n2 != 0 || n3 != 0 || n4 != 0) {
                int n5 = 0;
                int n6 = 0;
                if (array != null) {
                    mView.getLocationInWindow(array);
                    n5 = array[0];
                    n6 = array[1];
                }
                ViewParentCompat.onNestedScroll(mNestedScrollingParent, mView, n, n2, n3, n4);
                if (array != null) {
                    mView.getLocationInWindow(array);
                    array[0] -= n5;
                    array[1] -= n6;
                }
                return true;
            }
            if (array != null) {
                array[1] = (array[0] = 0);
            }
        }
        return false;
    }
    
    public boolean hasNestedScrollingParent() {
        return mNestedScrollingParent != null;
    }
    
    public boolean isNestedScrollingEnabled() {
        return mIsNestedScrollingEnabled;
    }
    
    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(mView);
    }
    
    public void onStopNestedScroll(final View view) {
        ViewCompat.stopNestedScroll(mView);
    }
    
    public void setNestedScrollingEnabled(final boolean mIsNestedScrollingEnabled) {
        if (this.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll(mView);
        }
        this.mIsNestedScrollingEnabled = mIsNestedScrollingEnabled;
    }
    
    public boolean startNestedScroll(final int n) {
        if (this.hasNestedScrollingParent()) {
            return true;
        }
        if (this.isNestedScrollingEnabled()) {
            ViewParent mNestedScrollingParent = mView.getParent();
            View mView = this.mView;
            while (mNestedScrollingParent != null) {
                if (ViewParentCompat.onStartNestedScroll(mNestedScrollingParent, mView, this.mView, n)) {
                    ViewParentCompat.onNestedScrollAccepted(this.mNestedScrollingParent = mNestedScrollingParent, mView, this.mView, n);
                    return true;
                }
                if (mNestedScrollingParent instanceof View) {
                    mView = (View)mNestedScrollingParent;
                }
                mNestedScrollingParent = mNestedScrollingParent.getParent();
            }
        }
        return false;
    }
    
    public void stopNestedScroll() {
        if (mNestedScrollingParent != null) {
            ViewParentCompat.onStopNestedScroll(mNestedScrollingParent, mView);
            mNestedScrollingParent = null;
        }
    }
}
