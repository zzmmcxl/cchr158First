package android.support.v7.widget;

import android.support.v7.widget.ActivityChooserView;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ActivityChooserView$2 implements OnGlobalLayoutListener {
   ActivityChooserView$2(ActivityChooserView var1) {
      this.this$0 = var1;
   }

   public void onGlobalLayout() {
      if(this.this$0.isShowingPopup()) {
         if(!this.this$0.isShown()) {
            ActivityChooserView.access$100(this.this$0).dismiss();
         } else {
            ActivityChooserView.access$100(this.this$0).show();
            if(this.this$0.mProvider != null) {
               this.this$0.mProvider.subUiVisibilityChanged(true);
               return;
            }
         }
      }

   }
}
