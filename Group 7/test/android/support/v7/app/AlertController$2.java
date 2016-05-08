package android.support.v7.app;

import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView$OnScrollChangeListener;
import android.support.v7.app.AlertController;
import android.view.View;

class AlertController$2 implements NestedScrollView$OnScrollChangeListener {
   AlertController$2(AlertController var1, View var2, View var3) {
      this.this$0 = var1;
      this.val$top = var2;
      this.val$bottom = var3;
   }

   public void onScrollChange(NestedScrollView var1, int var2, int var3, int var4, int var5) {
      AlertController.access$800(var1, this.val$top, this.val$bottom);
   }
}
