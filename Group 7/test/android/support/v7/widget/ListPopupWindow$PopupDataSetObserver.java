package android.support.v7.widget;

import android.database.DataSetObserver;
import android.support.v7.widget.ListPopupWindow;

class ListPopupWindow$PopupDataSetObserver extends DataSetObserver {
   private ListPopupWindow$PopupDataSetObserver(ListPopupWindow var1) {
      this.this$0 = var1;
   }

   public void onChanged() {
      if(this.this$0.isShowing()) {
         this.this$0.show();
      }

   }

   public void onInvalidated() {
      this.this$0.dismiss();
   }
}
