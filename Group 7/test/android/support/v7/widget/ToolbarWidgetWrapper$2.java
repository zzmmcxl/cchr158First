package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.View;

class ToolbarWidgetWrapper$2 extends ViewPropertyAnimatorListenerAdapter {
   private boolean mCanceled;

   ToolbarWidgetWrapper$2(ToolbarWidgetWrapper var1, int var2) {
      this.this$0 = var1;
      this.val$visibility = var2;
      this.mCanceled = false;
   }

   public void onAnimationCancel(View var1) {
      this.mCanceled = true;
   }

   public void onAnimationEnd(View var1) {
      if(!this.mCanceled) {
         ToolbarWidgetWrapper.access$000(this.this$0).setVisibility(this.val$visibility);
      }

   }

   public void onAnimationStart(View var1) {
      ToolbarWidgetWrapper.access$000(this.this$0).setVisibility(0);
   }
}
