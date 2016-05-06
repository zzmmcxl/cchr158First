package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;
import android.support.v4.widget.ViewDragHelper;

class BottomSheetBehavior$1 extends Callback {
    final /* synthetic */ BottomSheetBehavior this$0;
    
    BottomSheetBehavior$1(final BottomSheetBehavior this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public int clampViewPositionHorizontal(final View view, final int n, final int n2) {
        return view.getLeft();
    }
    
    @Override
    public int clampViewPositionVertical(final View view, final int n, final int n2) {
        final int access$700 = BottomSheetBehavior.access$700(this$0);
        int n3;
        if (BottomSheetBehavior.access$800(this$0)) {
            n3 = BottomSheetBehavior.access$1000(this$0);
        }
        else {
            n3 = BottomSheetBehavior.access$1100(this$0);
        }
        return MathUtils.constrain(n, access$700, n3);
    }
    
    @Override
    public int getViewVerticalDragRange(final View view) {
        if (BottomSheetBehavior.access$800(this$0)) {
            return BottomSheetBehavior.access$1000(this$0) - BottomSheetBehavior.access$700(this$0);
        }
        return BottomSheetBehavior.access$1100(this$0) - BottomSheetBehavior.access$700(this$0);
    }
    
    @Override
    public void onViewDragStateChanged(final int n) {
        if (n == 1) {
            BottomSheetBehavior.access$600(this$0, 1);
        }
    }
    
    @Override
    public void onViewPositionChanged(final View view, final int n, final int n2, final int n3, final int n4) {
        BottomSheetBehavior.access$500(this$0, n2);
    }
    
    @Override
    public void onViewReleased(final View view, final float n, final float n2) {
        int n3;
        int n4;
        if (n2 < 0.0f) {
            n3 = BottomSheetBehavior.access$700(this$0);
            n4 = 3;
        }
        else if (BottomSheetBehavior.access$800(this$0) && BottomSheetBehavior.access$900(this$0, view, n2)) {
            n3 = BottomSheetBehavior.access$1000(this$0);
            n4 = 5;
        }
        else if (n2 == 0.0f) {
            final int top = view.getTop();
            if (Math.abs(top - BottomSheetBehavior.access$700(this$0)) < Math.abs(top - BottomSheetBehavior.access$1100(this$0))) {
                n3 = BottomSheetBehavior.access$700(this$0);
                n4 = 3;
            }
            else {
                n3 = BottomSheetBehavior.access$1100(this$0);
                n4 = 4;
            }
        }
        else {
            n3 = BottomSheetBehavior.access$1100(this$0);
            n4 = 4;
        }
        if (BottomSheetBehavior.access$1200(this$0).settleCapturedViewAt(view.getLeft(), n3)) {
            BottomSheetBehavior.access$600(this$0, 2);
            ViewCompat.postOnAnimation(view, this$0.new SettleRunnable(view, n4));
            return;
        }
        BottomSheetBehavior.access$600(this$0, n4);
    }
    
    @Override
    public boolean tryCaptureView(final View view, final int n) {
        boolean b = true;
        if (BottomSheetBehavior.access$000(this$0) != (b ? 1 : 0) && !BottomSheetBehavior.access$100(this$0)) {
            if (BottomSheetBehavior.access$000(this$0) == 3 && BottomSheetBehavior.access$200(this$0) == n) {
                final View view2 = (View)BottomSheetBehavior.access$300(this$0).get();
                if (view2 != null && ViewCompat.canScrollVertically(view2, -1)) {
                    return false;
                }
            }
            if (BottomSheetBehavior.access$400(this$0) == null || BottomSheetBehavior.access$400(this$0).get() != view) {
                b = false;
            }
            return b;
        }
        return false;
    }
}