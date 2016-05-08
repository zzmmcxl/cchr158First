package android.support.v4.view;

import android.support.v4.view.PagerTabStrip;
import android.view.View;
import android.view.View.OnClickListener;

class PagerTabStrip$2 implements OnClickListener {
   PagerTabStrip$2(PagerTabStrip var1) {
      this.this$0 = var1;
   }

   public void onClick(View var1) {
      this.this$0.mPager.setCurrentItem(this.this$0.mPager.getCurrentItem() + 1);
   }
}
