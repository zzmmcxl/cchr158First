package android.support.v4.view;

import android.support.v4.view.ViewPager$LayoutParams;
import android.view.View;
import java.util.Comparator;

class ViewPager$ViewPositionComparator implements Comparator<View> {
   public int compare(View var1, View var2) {
      ViewPager$LayoutParams var3 = (ViewPager$LayoutParams)var1.getLayoutParams();
      ViewPager$LayoutParams var4 = (ViewPager$LayoutParams)var2.getLayoutParams();
      return var3.isDecor != var4.isDecor?(var3.isDecor?1:-1):var3.position - var4.position;
   }
}
