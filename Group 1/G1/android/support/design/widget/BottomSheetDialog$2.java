package android.support.design.widget;

import android.support.annotation.NonNull;
import android.view.View;

class BottomSheetDialog$2 extends BottomSheetCallback {
    final /* synthetic */ BottomSheetDialog this$0;
    
    BottomSheetDialog$2(final BottomSheetDialog this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void onSlide(@NonNull final View view, final float n) {
    }
    
    @Override
    public void onStateChanged(@NonNull final View view, final int n) {
        if (n == 5) {
            this$0.dismiss();
        }
    }
}