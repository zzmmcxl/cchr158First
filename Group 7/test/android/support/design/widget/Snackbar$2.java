package android.support.design.widget;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.View.OnClickListener;

class Snackbar$2 implements OnClickListener {
   Snackbar$2(Snackbar var1, OnClickListener var2) {
      this.this$0 = var1;
      this.val$listener = var2;
   }

   public void onClick(View var1) {
      this.val$listener.onClick(var1);
      Snackbar.access$000(this.this$0, 1);
   }
}
