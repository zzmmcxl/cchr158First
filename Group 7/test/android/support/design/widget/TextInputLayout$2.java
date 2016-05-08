package android.support.design.widget;

import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;

class TextInputLayout$2 extends ViewPropertyAnimatorListenerAdapter {
   TextInputLayout$2(TextInputLayout var1) {
      this.this$0 = var1;
   }

   public void onAnimationStart(View var1) {
      var1.setVisibility(0);
   }
}
