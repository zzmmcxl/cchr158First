package android.support.design.widget;

import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;

class TextInputLayout$3 extends ViewPropertyAnimatorListenerAdapter {
   TextInputLayout$3(TextInputLayout var1, CharSequence var2) {
      this.this$0 = var1;
      this.val$error = var2;
   }

   public void onAnimationEnd(View var1) {
      TextInputLayout.access$400(this.this$0).setText(this.val$error);
      var1.setVisibility(4);
   }
}
