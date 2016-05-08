package android.support.design.widget;

import android.support.design.widget.TabLayout$OnTabSelectedListener;
import android.support.design.widget.TabLayout$Tab;
import android.support.v4.view.ViewPager;

public class TabLayout$ViewPagerOnTabSelectedListener implements TabLayout$OnTabSelectedListener {
   private final ViewPager mViewPager;

   public TabLayout$ViewPagerOnTabSelectedListener(ViewPager var1) {
      this.mViewPager = var1;
   }

   public void onTabReselected(TabLayout$Tab var1) {
   }

   public void onTabSelected(TabLayout$Tab var1) {
      this.mViewPager.setCurrentItem(var1.getPosition());
   }

   public void onTabUnselected(TabLayout$Tab var1) {
   }
}
