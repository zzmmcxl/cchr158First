package android.support.v4.view;

import android.support.v4.view.ViewCompat$BaseViewCompatImpl;
import android.support.v4.view.ViewCompatEclairMr1;
import android.view.View;
import android.view.ViewGroup;

class ViewCompat$EclairMr1ViewCompatImpl extends ViewCompat$BaseViewCompatImpl {
   public boolean isOpaque(View var1) {
      return ViewCompatEclairMr1.isOpaque(var1);
   }

   public void setChildrenDrawingOrderEnabled(ViewGroup var1, boolean var2) {
      ViewCompatEclairMr1.setChildrenDrawingOrderEnabled(var1, var2);
   }
}
