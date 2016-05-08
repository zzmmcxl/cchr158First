package android.support.v4.widget;

import android.database.DataSetObserver;
import android.support.v4.widget.CursorAdapter;

class CursorAdapter$MyDataSetObserver extends DataSetObserver {
   private CursorAdapter$MyDataSetObserver(CursorAdapter var1) {
      this.this$0 = var1;
   }

   public void onChanged() {
      this.this$0.mDataValid = true;
      this.this$0.notifyDataSetChanged();
   }

   public void onInvalidated() {
      this.this$0.mDataValid = false;
      this.this$0.notifyDataSetInvalidated();
   }
}
