package android.support.v7.widget;

import android.database.DataSetObserver;
import android.support.v7.widget.ActivityChooserView;

class ActivityChooserView$1 extends DataSetObserver {
   ActivityChooserView$1(ActivityChooserView var1) {
      this.this$0 = var1;
   }

   public void onChanged() {
      super.onChanged();
      ActivityChooserView.access$000(this.this$0).notifyDataSetChanged();
   }

   public void onInvalidated() {
      super.onInvalidated();
      ActivityChooserView.access$000(this.this$0).notifyDataSetInvalidated();
   }
}
