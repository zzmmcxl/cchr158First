package android.support.v7.app;

import android.support.v7.app.AlertController;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class AlertController$4 implements OnScrollListener {
   AlertController$4(AlertController var1, View var2, View var3) {
      this.this$0 = var1;
      this.val$top = var2;
      this.val$bottom = var3;
   }

   public void onScroll(AbsListView var1, int var2, int var3, int var4) {
      AlertController.access$800(var1, this.val$top, this.val$bottom);
   }

   public void onScrollStateChanged(AbsListView var1, int var2) {
   }
}
