package android.support.v4.widget;

import android.view.View;

private class DragHelperCallback extends Callback
{
    final /* synthetic */ SlidingPaneLayout this$0;
    
    private DragHelperCallback(final SlidingPaneLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    DragHelperCallback(final SlidingPaneLayout slidingPaneLayout, final SlidingPaneLayout$1 object) {
        this(slidingPaneLayout);
    }
    
    @Override
    public int clampViewPositionHorizontal(final View view, final int n, final int n2) {
        final LayoutParams layoutParams = (LayoutParams)SlidingPaneLayout.access$400(this$0).getLayoutParams();
        if (SlidingPaneLayout.access$700(this$0)) {
            final int n3 = this$0.getWidth() - (this$0.getPaddingRight() + layoutParams.rightMargin + SlidingPaneLayout.access$400(this$0).getWidth());
            return Math.max(Math.min(n, n3), n3 - SlidingPaneLayout.access$800(this$0));
        }
        final int n4 = this$0.getPaddingLeft() + layoutParams.leftMargin;
        return Math.min(Math.max(n, n4), n4 + SlidingPaneLayout.access$800(this$0));
    }
    
    @Override
    public int clampViewPositionVertical(final View view, final int n, final int n2) {
        return view.getTop();
    }
    
    @Override
    public int getViewHorizontalDragRange(final View view) {
        return SlidingPaneLayout.access$800(this$0);
    }
    
    @Override
    public void onEdgeDragStarted(final int n, final int n2) {
        SlidingPaneLayout.access$200(this$0).captureChildView(SlidingPaneLayout.access$400(this$0), n2);
    }
    
    @Override
    public void onViewCaptured(final View view, final int n) {
        this$0.setAllChildrenVisible();
    }
    
    @Override
    public void onViewDragStateChanged(final int n) {
        if (SlidingPaneLayout.access$200(this$0).getViewDragState() == 0) {
            if (SlidingPaneLayout.access$300(this$0) != 0.0f) {
                this$0.dispatchOnPanelOpened(SlidingPaneLayout.access$400(this$0));
                SlidingPaneLayout.access$502(this$0, true);
                return;
            }
            this$0.updateObscuredViewsVisibility(SlidingPaneLayout.access$400(this$0));
            this$0.dispatchOnPanelClosed(SlidingPaneLayout.access$400(this$0));
            SlidingPaneLayout.access$502(this$0, false);
        }
    }
    
    @Override
    public void onViewPositionChanged(final View view, final int n, final int n2, final int n3, final int n4) {
        SlidingPaneLayout.access$600(this$0, n);
        this$0.invalidate();
    }
    
    @Override
    public void onViewReleased(final View view, final float n, final float n2) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        int n4;
        if (SlidingPaneLayout.access$700(this$0)) {
            int n3 = this$0.getPaddingRight() + layoutParams.rightMargin;
            if (n < 0.0f || (n == 0.0f && SlidingPaneLayout.access$300(this$0) > 0.5f)) {
                n3 += SlidingPaneLayout.access$800(this$0);
            }
            n4 = this$0.getWidth() - n3 - SlidingPaneLayout.access$400(this$0).getWidth();
        }
        else {
            n4 = this$0.getPaddingLeft() + layoutParams.leftMargin;
            if (n > 0.0f || (n == 0.0f && SlidingPaneLayout.access$300(this$0) > 0.5f)) {
                n4 += SlidingPaneLayout.access$800(this$0);
            }
        }
        SlidingPaneLayout.access$200(this$0).settleCapturedViewAt(n4, view.getTop());
        this$0.invalidate();
    }
    
    @Override
    public boolean tryCaptureView(final View view, final int n) {
        return !SlidingPaneLayout.access$100(this$0) && ((LayoutParams)view.getLayoutParams()).slideable;
    }
}
