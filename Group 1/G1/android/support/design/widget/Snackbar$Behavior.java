package android.support.design.widget;

import android.view.MotionEvent;
import android.view.View;

final class Behavior extends SwipeDismissBehavior<SnackbarLayout>
{
    final /* synthetic */ Snackbar this$0;
    
    Behavior(final Snackbar this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public boolean canSwipeDismissView(final View view) {
        return view instanceof SnackbarLayout;
    }
    
    @Override
    public boolean onInterceptTouchEvent(final CoordinatorLayout coordinatorLayout, final SnackbarLayout snackbarLayout, final MotionEvent motionEvent) {
        if (coordinatorLayout.isPointInChildBounds((View)snackbarLayout, (int)motionEvent.getX(), (int)motionEvent.getY())) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    SnackbarManager.getInstance().cancelTimeout(Snackbar.access$200(this$0));
                    break;
                case 1:
                case 3:
                    SnackbarManager.getInstance().restoreTimeout(Snackbar.access$200(this$0));
                    break;
            }
        }
        return super.onInterceptTouchEvent(coordinatorLayout, snackbarLayout, motionEvent);
    }
    
    @Override
    public /* bridge */ boolean onInterceptTouchEvent(final CoordinatorLayout coordinatorLayout, final View view, final MotionEvent motionEvent) {
        return this.onInterceptTouchEvent(coordinatorLayout, (SnackbarLayout)view, motionEvent);
    }
}
