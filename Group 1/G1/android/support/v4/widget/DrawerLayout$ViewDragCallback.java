package android.support.v4.widget;

import android.view.ViewGroup$LayoutParams;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.View;

private class ViewDragCallback extends Callback
{
    private final int mAbsGravity;
    private ViewDragHelper mDragger;
    private final Runnable mPeekRunnable;
    final /* synthetic */ DrawerLayout this$0;
    
    public ViewDragCallback(final DrawerLayout this$0, final int mAbsGravity) {
        this$0 = this$0;
        super();
        mPeekRunnable = new Runnable() {
            final /* synthetic */ ViewDragCallback this$1;
            
            DrawerLayout$ViewDragCallback$1() {
                this$1 = this$1;
                super();
            }
            
            @Override
            public void run() {
                this$1.peekDrawer();
            }
        };
        mAbsGravity = mAbsGravity;
    }
    
    static /* synthetic */ void access$300(final ViewDragCallback viewDragCallback) {
        viewDragCallback.peekDrawer();
    }
    
    private void closeOtherDrawer() {
        int n = 3;
        if (mAbsGravity == n) {
            n = 5;
        }
        final View drawerWithGravity = this$0.findDrawerWithGravity(n);
        if (drawerWithGravity != null) {
            this$0.closeDrawer(drawerWithGravity);
        }
    }
    
    private void peekDrawer() {
        final int edgeSize = mDragger.getEdgeSize();
        boolean b;
        if (mAbsGravity == 3) {
            b = true;
        }
        else {
            b = false;
        }
        View view;
        int n2;
        if (b) {
            view = this$0.findDrawerWithGravity(3);
            int n = 0;
            if (view != null) {
                n = -view.getWidth();
            }
            n2 = n + edgeSize;
        }
        else {
            view = this$0.findDrawerWithGravity(5);
            n2 = this$0.getWidth() - edgeSize;
        }
        if (view != null && ((b && view.getLeft() < n2) || (!b && view.getLeft() > n2)) && this$0.getDrawerLockMode(view) == 0) {
            final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            mDragger.smoothSlideViewTo(view, n2, view.getTop());
            layoutParams.isPeeking = true;
            this$0.invalidate();
            this.closeOtherDrawer();
            this$0.cancelChildViewTouch();
        }
    }
    
    @Override
    public int clampViewPositionHorizontal(final View view, final int n, final int n2) {
        if (this$0.checkDrawerViewAbsoluteGravity(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(n, 0));
        }
        final int width = this$0.getWidth();
        return Math.max(width - view.getWidth(), Math.min(n, width));
    }
    
    @Override
    public int clampViewPositionVertical(final View view, final int n, final int n2) {
        return view.getTop();
    }
    
    @Override
    public int getViewHorizontalDragRange(final View view) {
        if (this$0.isDrawerView(view)) {
            return view.getWidth();
        }
        return 0;
    }
    
    @Override
    public void onEdgeDragStarted(final int n, final int n2) {
        View view;
        if ((n & 0x1) == 0x1) {
            view = this$0.findDrawerWithGravity(3);
        }
        else {
            view = this$0.findDrawerWithGravity(5);
        }
        if (view != null && this$0.getDrawerLockMode(view) == 0) {
            mDragger.captureChildView(view, n2);
        }
    }
    
    @Override
    public boolean onEdgeLock(final int n) {
        return false;
    }
    
    @Override
    public void onEdgeTouched(final int n, final int n2) {
        this$0.postDelayed(mPeekRunnable, 160L);
    }
    
    @Override
    public void onViewCaptured(final View view, final int n) {
        ((LayoutParams)view.getLayoutParams()).isPeeking = false;
        this.closeOtherDrawer();
    }
    
    @Override
    public void onViewDragStateChanged(final int n) {
        this$0.updateDrawerState(mAbsGravity, n, mDragger.getCapturedView());
    }
    
    @Override
    public void onViewPositionChanged(final View view, final int n, final int n2, final int n3, final int n4) {
        final int width = view.getWidth();
        float n5;
        if (this$0.checkDrawerViewAbsoluteGravity(view, 3)) {
            n5 = (width + n) / width;
        }
        else {
            n5 = (this$0.getWidth() - n) / width;
        }
        this$0.setDrawerViewOffset(view, n5);
        int visibility;
        if (n5 == 0.0f) {
            visibility = 4;
        }
        else {
            visibility = 0;
        }
        view.setVisibility(visibility);
        this$0.invalidate();
    }
    
    @Override
    public void onViewReleased(final View view, final float n, final float n2) {
        final float drawerViewOffset = this$0.getDrawerViewOffset(view);
        final int width = view.getWidth();
        int n3;
        if (this$0.checkDrawerViewAbsoluteGravity(view, 3)) {
            if (n > 0.0f || (n == 0.0f && drawerViewOffset > 0.5f)) {
                n3 = 0;
            }
            else {
                n3 = -width;
            }
        }
        else {
            final int width2 = this$0.getWidth();
            if (n < 0.0f || (n == 0.0f && drawerViewOffset > 0.5f)) {
                n3 = width2 - width;
            }
            else {
                n3 = width2;
            }
        }
        mDragger.settleCapturedViewAt(n3, view.getTop());
        this$0.invalidate();
    }
    
    public void removeCallbacks() {
        this$0.removeCallbacks(mPeekRunnable);
    }
    
    public void setDragger(final ViewDragHelper mDragger) {
        this.mDragger = mDragger;
    }
    
    @Override
    public boolean tryCaptureView(final View view, final int n) {
        return this$0.isDrawerView(view) && this$0.checkDrawerViewAbsoluteGravity(view, mAbsGravity) && this$0.getDrawerLockMode(view) == 0;
    }
}
