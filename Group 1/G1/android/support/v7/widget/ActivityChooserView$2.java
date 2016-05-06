package android.support.v7.widget;

import android.view.ViewTreeObserver$OnGlobalLayoutListener;

class ActivityChooserView$2 implements ViewTreeObserver$OnGlobalLayoutListener {
    final /* synthetic */ ActivityChooserView this$0;
    
    ActivityChooserView$2(final ActivityChooserView this$0) {
        this$0 = this$0;
        super();
    }
    
    public void onGlobalLayout() {
        if (this$0.isShowingPopup()) {
            if (!this$0.isShown()) {
                ActivityChooserView.access$100(this$0).dismiss();
            }
            else {
                ActivityChooserView.access$100(this$0).show();
                if (mProvider != null) {
                    mProvider.subUiVisibilityChanged(true);
                }
            }
        }
    }
}