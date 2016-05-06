package android.support.v7.widget;

import android.view.View;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;

class AppCompatSpinner$DropdownPopup$2 implements ViewTreeObserver$OnGlobalLayoutListener {
    final /* synthetic */ DropdownPopup this$1;
    
    AppCompatSpinner$DropdownPopup$2(final DropdownPopup this$1) {
        this$1 = this$1;
        super();
    }
    
    public void onGlobalLayout() {
        if (!DropdownPopup.access$600(this$1, (View)this$0)) {
            this$1.dismiss();
            return;
        }
        this$1.computeContentWidth();
        DropdownPopup.access$701(this$1);
    }
}