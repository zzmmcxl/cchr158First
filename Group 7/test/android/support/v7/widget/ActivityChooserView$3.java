package android.support.v7.widget;

import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow$ForwardingListener;
import android.view.View;

class ActivityChooserView$3 extends ListPopupWindow$ForwardingListener {
   ActivityChooserView$3(ActivityChooserView var1, View var2) {
      super(var2);
      this.this$0 = var1;
   }

   public ListPopupWindow getPopup() {
      return ActivityChooserView.access$100(this.this$0);
   }

   protected boolean onForwardingStarted() {
      this.this$0.showPopup();
      return true;
   }

   protected boolean onForwardingStopped() {
      this.this$0.dismissPopup();
      return true;
   }
}
