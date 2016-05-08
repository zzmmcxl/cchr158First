package android.support.v7.app;

import android.content.Context;
import android.support.v7.app.AlertController$AlertParams;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

class AlertController$AlertParams$1 extends ArrayAdapter<CharSequence> {
   AlertController$AlertParams$1(AlertController$AlertParams var1, Context var2, int var3, int var4, CharSequence[] var5, ListView var6) {
      super(var2, var3, var4, var5);
      this.this$0 = var1;
      this.val$listView = var6;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      var2 = super.getView(var1, var2, var3);
      if(this.this$0.mCheckedItems != null && this.this$0.mCheckedItems[var1]) {
         this.val$listView.setItemChecked(var1, true);
      }

      return var2;
   }
}
