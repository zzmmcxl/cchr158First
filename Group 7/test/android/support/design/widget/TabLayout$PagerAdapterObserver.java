package android.support.design.widget;

import android.database.DataSetObserver;
import android.support.design.widget.TabLayout;

class TabLayout$PagerAdapterObserver extends DataSetObserver {
   private TabLayout$PagerAdapterObserver(TabLayout var1) {
      this.this$0 = var1;
   }

   public void onChanged() {
      TabLayout.access$2800(this.this$0);
   }

   public void onInvalidated() {
      TabLayout.access$2800(this.this$0);
   }
}
