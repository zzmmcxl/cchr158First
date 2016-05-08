package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;
import java.util.Comparator;

class CoordinatorLayout$ViewElevationComparator implements Comparator<View> {
   public int compare(View var1, View var2) {
      float var3 = ViewCompat.getZ(var1);
      float var4 = ViewCompat.getZ(var2);
      return var3 > var4?-1:(var3 < var4?1:0);
   }
}
