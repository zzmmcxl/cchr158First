package android.support.v4.view;

import android.support.v4.view.ViewCompat$EclairMr1ViewCompatImpl;
import android.support.v4.view.ViewCompatGingerbread;
import android.view.View;

class ViewCompat$GBViewCompatImpl extends ViewCompat$EclairMr1ViewCompatImpl {
   public int getOverScrollMode(View var1) {
      return ViewCompatGingerbread.getOverScrollMode(var1);
   }

   public void setOverScrollMode(View var1, int var2) {
      ViewCompatGingerbread.setOverScrollMode(var1, var2);
   }
}
