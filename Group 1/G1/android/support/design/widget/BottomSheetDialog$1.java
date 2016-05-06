package android.support.design.widget;

import android.view.View;
import android.view.View$OnClickListener;

class BottomSheetDialog$1 implements View$OnClickListener {
    final /* synthetic */ BottomSheetDialog this$0;
    
    BottomSheetDialog$1(final BottomSheetDialog this$0) {
        this$0 = this$0;
        super();
    }
    
    public void onClick(final View view) {
        if (this$0.isShowing()) {
            this$0.cancel();
        }
    }
}