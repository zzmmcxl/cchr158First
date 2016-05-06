package android.support.v7.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnTouchListener;

private class PopupTouchInterceptor implements View$OnTouchListener
{
    final /* synthetic */ ListPopupWindow this$0;
    
    private PopupTouchInterceptor(final ListPopupWindow this$0) {
        this$0 = this$0;
        super();
    }
    
    PopupTouchInterceptor(final ListPopupWindow listPopupWindow, final ListPopupWindow$1 forwardingListener) {
        this(listPopupWindow);
    }
    
    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        final int action = motionEvent.getAction();
        final int n = (int)motionEvent.getX();
        final int n2 = (int)motionEvent.getY();
        if (action == 0 && ListPopupWindow.access$1100(this$0) != null && ListPopupWindow.access$1100(this$0).isShowing() && n >= 0 && n < ListPopupWindow.access$1100(this$0).getWidth() && n2 >= 0 && n2 < ListPopupWindow.access$1100(this$0).getHeight()) {
            ListPopupWindow.access$1300(this$0).postDelayed((Runnable)ListPopupWindow.access$1200(this$0), 250L);
        }
        else if (action == 1) {
            ListPopupWindow.access$1300(this$0).removeCallbacks((Runnable)ListPopupWindow.access$1200(this$0));
        }
        return false;
    }
}
