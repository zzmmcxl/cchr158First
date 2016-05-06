package android.support.v7.widget;

import android.view.View;

class ActivityChooserView$3 extends ForwardingListener {
    final /* synthetic */ ActivityChooserView this$0;
    
    ActivityChooserView$3(final ActivityChooserView this$0, final View view) {
        this$0 = this$0;
        super(view);
    }
    
    @Override
    public ListPopupWindow getPopup() {
        return ActivityChooserView.access$100(this$0);
    }
    
    @Override
    protected boolean onForwardingStarted() {
        this$0.showPopup();
        return true;
    }
    
    @Override
    protected boolean onForwardingStopped() {
        this$0.dismissPopup();
        return true;
    }
}