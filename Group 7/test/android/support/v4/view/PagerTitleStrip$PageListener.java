package android.support.v4.view;

import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager$OnAdapterChangeListener;
import android.support.v4.view.ViewPager$OnPageChangeListener;

class PagerTitleStrip$PageListener extends DataSetObserver implements ViewPager$OnPageChangeListener, ViewPager$OnAdapterChangeListener {
   private int mScrollState;

   private PagerTitleStrip$PageListener(PagerTitleStrip var1) {
      this.this$0 = var1;
   }

   public void onAdapterChanged(PagerAdapter var1, PagerAdapter var2) {
      this.this$0.updateAdapter(var1, var2);
   }

   public void onChanged() {
      float var1 = 0.0F;
      this.this$0.updateText(this.this$0.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
      if(PagerTitleStrip.access$100(this.this$0) >= 0.0F) {
         var1 = PagerTitleStrip.access$100(this.this$0);
      }

      this.this$0.updateTextPositions(this.this$0.mPager.getCurrentItem(), var1, true);
   }

   public void onPageScrollStateChanged(int var1) {
      this.mScrollState = var1;
   }

   public void onPageScrolled(int var1, float var2, int var3) {
      var3 = var1;
      if(var2 > 0.5F) {
         var3 = var1 + 1;
      }

      this.this$0.updateTextPositions(var3, var2, false);
   }

   public void onPageSelected(int var1) {
      float var2 = 0.0F;
      if(this.mScrollState == 0) {
         this.this$0.updateText(this.this$0.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
         if(PagerTitleStrip.access$100(this.this$0) >= 0.0F) {
            var2 = PagerTitleStrip.access$100(this.this$0);
         }

         this.this$0.updateTextPositions(this.this$0.mPager.getCurrentItem(), var2, true);
      }

   }
}
