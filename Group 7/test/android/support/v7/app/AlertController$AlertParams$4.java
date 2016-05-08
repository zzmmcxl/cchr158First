package android.support.v7.app;

import android.support.v7.app.AlertController;
import android.support.v7.app.AlertController$AlertParams;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

class AlertController$AlertParams$4 implements OnItemClickListener {
   AlertController$AlertParams$4(AlertController$AlertParams var1, ListView var2, AlertController var3) {
      this.this$0 = var1;
      this.val$listView = var2;
      this.val$dialog = var3;
   }

   public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
      if(this.this$0.mCheckedItems != null) {
         this.this$0.mCheckedItems[var3] = this.val$listView.isItemChecked(var3);
      }

      this.this$0.mOnCheckboxClickListener.onClick(AlertController.access$600(this.val$dialog), var3, this.val$listView.isItemChecked(var3));
   }
}
