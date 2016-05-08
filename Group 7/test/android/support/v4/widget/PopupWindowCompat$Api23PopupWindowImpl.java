package android.support.v4.widget;

import android.support.v4.widget.PopupWindowCompat$Api21PopupWindowImpl;
import android.support.v4.widget.PopupWindowCompatApi23;
import android.widget.PopupWindow;

class PopupWindowCompat$Api23PopupWindowImpl extends PopupWindowCompat$Api21PopupWindowImpl {
   public boolean getOverlapAnchor(PopupWindow var1) {
      return PopupWindowCompatApi23.getOverlapAnchor(var1);
   }

   public int getWindowLayoutType(PopupWindow var1) {
      return PopupWindowCompatApi23.getWindowLayoutType(var1);
   }

   public void setOverlapAnchor(PopupWindow var1, boolean var2) {
      PopupWindowCompatApi23.setOverlapAnchor(var1, var2);
   }

   public void setWindowLayoutType(PopupWindow var1, int var2) {
      PopupWindowCompatApi23.setWindowLayoutType(var1, var2);
   }
}
