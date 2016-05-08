package android.support.design.widget;

import android.support.design.widget.Snackbar;
import android.support.design.widget.SnackbarManager$Callback;

class Snackbar$3 implements SnackbarManager$Callback {
   Snackbar$3(Snackbar var1) {
      this.this$0 = var1;
   }

   public void dismiss(int var1) {
      Snackbar.access$100().sendMessage(Snackbar.access$100().obtainMessage(1, var1, 0, this.this$0));
   }

   public void show() {
      Snackbar.access$100().sendMessage(Snackbar.access$100().obtainMessage(0, this.this$0));
   }
}
