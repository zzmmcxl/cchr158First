package android.support.v4.view;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat$JbMr1ViewCompatImpl;
import android.support.v4.view.ViewCompatJellybeanMr2;
import android.view.View;

class ViewCompat$JbMr2ViewCompatImpl extends ViewCompat$JbMr1ViewCompatImpl {
   public Rect getClipBounds(View var1) {
      return ViewCompatJellybeanMr2.getClipBounds(var1);
   }

   public void setClipBounds(View var1, Rect var2) {
      ViewCompatJellybeanMr2.setClipBounds(var1, var2);
   }
}
