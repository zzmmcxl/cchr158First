package android.support.v4.view;

import android.database.DataSetObserver;
import android.support.v4.view.ViewPager;

class ViewPager$PagerObserver extends DataSetObserver {
   private ViewPager$PagerObserver(ViewPager var1) {
      this.this$0 = var1;
   }

   public void onChanged() {
      this.this$0.dataSetChanged();
   }

   public void onInvalidated() {
      this.this$0.dataSetChanged();
   }
}
