package android.support.design.widget;

import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar$SnackbarLayout$OnLayoutChangeListener;
import android.view.View;

class Snackbar$6 implements Snackbar$SnackbarLayout$OnLayoutChangeListener {
   Snackbar$6(Snackbar var1) {
      this.this$0 = var1;
   }

   public void onLayoutChange(View var1, int var2, int var3, int var4, int var5) {
      Snackbar.access$400(this.this$0);
      Snackbar.access$500(this.this$0).setOnLayoutChangeListener((Snackbar$SnackbarLayout$OnLayoutChangeListener)null);
   }
}
