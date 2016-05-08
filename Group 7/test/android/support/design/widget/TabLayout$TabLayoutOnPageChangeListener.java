package android.support.design.widget;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager$OnPageChangeListener;
import java.lang.ref.WeakReference;

public class TabLayout$TabLayoutOnPageChangeListener implements ViewPager$OnPageChangeListener {
   private int mPreviousScrollState;
   private int mScrollState;
   private final WeakReference<TabLayout> mTabLayoutRef;

   public TabLayout$TabLayoutOnPageChangeListener(TabLayout var1) {
      this.mTabLayoutRef = new WeakReference(var1);
   }

   private void reset() {
      this.mScrollState = 0;
      this.mPreviousScrollState = 0;
   }

   public void onPageScrollStateChanged(int var1) {
      this.mPreviousScrollState = this.mScrollState;
      this.mScrollState = var1;
   }

   public void onPageScrolled(int var1, float var2, int var3) {
      TabLayout var6 = (TabLayout)this.mTabLayoutRef.get();
      if(var6 != null) {
         boolean var4;
         if(this.mScrollState == 2 && this.mPreviousScrollState != 1) {
            var4 = false;
         } else {
            var4 = true;
         }

         boolean var5;
         if(this.mScrollState == 2 && this.mPreviousScrollState == 0) {
            var5 = false;
         } else {
            var5 = true;
         }

         TabLayout.access$2700(var6, var1, var2, var4, var5);
      }

   }

   public void onPageSelected(int var1) {
      TabLayout var3 = (TabLayout)this.mTabLayoutRef.get();
      if(var3 != null && var3.getSelectedTabPosition() != var1) {
         boolean var2;
         if(this.mScrollState != 0 && (this.mScrollState != 2 || this.mPreviousScrollState != 0)) {
            var2 = false;
         } else {
            var2 = true;
         }

         var3.selectTab(var3.getTabAt(var1), var2);
      }

   }
}
