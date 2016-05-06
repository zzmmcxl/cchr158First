package android.support.design.widget;

import android.view.ViewParent;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.support.v4.widget.ViewDragHelper;

class SwipeDismissBehavior$1 extends Callback {
    private int mOriginalCapturedViewLeft;
    final /* synthetic */ SwipeDismissBehavior this$0;
    
    SwipeDismissBehavior$1(final SwipeDismissBehavior this$0) {
        this$0 = this$0;
        super();
    }
    
    private boolean shouldDismiss(final View view, final float n) {
        if (n != 0.0f) {
            final boolean b = ViewCompat.getLayoutDirection(view) == 1;
            if (SwipeDismissBehavior.access$200(this$0) != 2) {
                if (SwipeDismissBehavior.access$200(this$0) == 0) {
                    if (b) {
                        if (n >= 0.0f) {
                            return false;
                        }
                    }
                    else if (n <= 0.0f) {
                        return false;
                    }
                }
                else {
                    if (SwipeDismissBehavior.access$200(this$0) != 1) {
                        return false;
                    }
                    if (b) {
                        if (n <= 0.0f) {
                            return false;
                        }
                    }
                    else if (n >= 0.0f) {
                        return false;
                    }
                }
            }
        }
        else if (Math.abs(view.getLeft() - mOriginalCapturedViewLeft) < Math.round((float)view.getWidth() * SwipeDismissBehavior.access$300(this$0))) {
            return false;
        }
        return true;
    }
    
    @Override
    public int clampViewPositionHorizontal(final View view, final int n, final int n2) {
        boolean b;
        if (ViewCompat.getLayoutDirection(view) == 1) {
            b = true;
        }
        else {
            b = false;
        }
        int n3;
        int n4;
        if (SwipeDismissBehavior.access$200(this$0) == 0) {
            if (b) {
                n3 = mOriginalCapturedViewLeft - view.getWidth();
                n4 = mOriginalCapturedViewLeft;
            }
            else {
                n3 = mOriginalCapturedViewLeft;
                n4 = mOriginalCapturedViewLeft + view.getWidth();
            }
        }
        else if (SwipeDismissBehavior.access$200(this$0) == 1) {
            if (b) {
                n3 = mOriginalCapturedViewLeft;
                n4 = mOriginalCapturedViewLeft + view.getWidth();
            }
            else {
                n3 = mOriginalCapturedViewLeft - view.getWidth();
                n4 = mOriginalCapturedViewLeft;
            }
        }
        else {
            n3 = mOriginalCapturedViewLeft - view.getWidth();
            n4 = mOriginalCapturedViewLeft + view.getWidth();
        }
        return SwipeDismissBehavior.access$400(n3, n, n4);
    }
    
    @Override
    public int clampViewPositionVertical(final View view, final int n, final int n2) {
        return view.getTop();
    }
    
    @Override
    public int getViewHorizontalDragRange(final View view) {
        return view.getWidth();
    }
    
    @Override
    public void onViewCaptured(final View view, final int n) {
        mOriginalCapturedViewLeft = view.getLeft();
        final ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }
    
    @Override
    public void onViewDragStateChanged(final int n) {
        if (SwipeDismissBehavior.access$000(this$0) != null) {
            SwipeDismissBehavior.access$000(this$0).onDragStateChanged(n);
        }
    }
    
    @Override
    public void onViewPositionChanged(final View view, final int n, final int n2, final int n3, final int n4) {
        final float n5 = mOriginalCapturedViewLeft + view.getWidth() * SwipeDismissBehavior.access$500(this$0);
        final float n6 = mOriginalCapturedViewLeft + view.getWidth() * SwipeDismissBehavior.access$600(this$0);
        if (n <= n5) {
            ViewCompat.setAlpha(view, 1.0f);
            return;
        }
        if (n >= n6) {
            ViewCompat.setAlpha(view, 0.0f);
            return;
        }
        ViewCompat.setAlpha(view, SwipeDismissBehavior.access$700(0.0f, 1.0f - SwipeDismissBehavior.fraction(n5, n6, n), 1.0f));
    }
    
    @Override
    public void onViewReleased(final View view, final float n, final float n2) {
        final ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        final int width = view.getWidth();
        int mOriginalCapturedViewLeft;
        boolean b;
        if (this.shouldDismiss(view, n)) {
            if (view.getLeft() < this.mOriginalCapturedViewLeft) {
                mOriginalCapturedViewLeft = this.mOriginalCapturedViewLeft - width;
            }
            else {
                mOriginalCapturedViewLeft = width + this.mOriginalCapturedViewLeft;
            }
            b = true;
        }
        else {
            mOriginalCapturedViewLeft = this.mOriginalCapturedViewLeft;
            b = false;
        }
        if (SwipeDismissBehavior.access$100(this$0).settleCapturedViewAt(mOriginalCapturedViewLeft, view.getTop())) {
            ViewCompat.postOnAnimation(view, this$0.new SettleRunnable(view, b));
        }
        else if (b && SwipeDismissBehavior.access$000(this$0) != null) {
            SwipeDismissBehavior.access$000(this$0).onDismiss(view);
        }
    }
    
    @Override
    public boolean tryCaptureView(final View view, final int n) {
        return this$0.canSwipeDismissView(view);
    }
}