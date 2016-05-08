package android.support.v4.view;

import android.support.v4.view.ViewPager$ItemInfo;
import java.util.Comparator;

final class ViewPager$1 implements Comparator<ViewPager$ItemInfo> {
   public int compare(ViewPager$ItemInfo var1, ViewPager$ItemInfo var2) {
      return var1.position - var2.position;
   }
}
