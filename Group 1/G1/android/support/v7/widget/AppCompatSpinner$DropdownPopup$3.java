package android.support.v7.widget;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.widget.PopupWindow$OnDismissListener;

class AppCompatSpinner$DropdownPopup$3 implements PopupWindow$OnDismissListener {
    final /* synthetic */ DropdownPopup this$1;
    final /* synthetic */ ViewTreeObserver$OnGlobalLayoutListener val$layoutListener;
    
    AppCompatSpinner$DropdownPopup$3(final DropdownPopup this$1, final ViewTreeObserver$OnGlobalLayoutListener val$layoutListener) {
        this$1 = this$1;
        val$layoutListener = val$layoutListener;
        super();
    }
    
    public void onDismiss() {
        final ViewTreeObserver viewTreeObserver = this$0.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(val$layoutListener);
        }
    }
}