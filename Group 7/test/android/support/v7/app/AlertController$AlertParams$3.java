package android.support.v7.app;

import android.support.v7.app.AlertController;
import android.support.v7.app.AlertController$AlertParams;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class AlertController$AlertParams$3 implements OnItemClickListener {
   AlertController$AlertParams$3(AlertController$AlertParams var1, AlertController var2) {
      this.this$0 = var1;
      this.val$dialog = var2;
   }

   public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
      this.this$0.mOnClickListener.onClick(AlertController.access$600(this.val$dialog), var3);
      if(!this.this$0.mIsSingleChoice) {
         AlertController.access$600(this.val$dialog).dismiss();
      }

   }
}
