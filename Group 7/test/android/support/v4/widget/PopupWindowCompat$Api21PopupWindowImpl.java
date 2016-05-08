package android.support.v4.widget;

import android.support.v4.widget.PopupWindowCompat$KitKatPopupWindowImpl;
import android.support.v4.widget.PopupWindowCompatApi21;
import android.widget.PopupWindow;

class PopupWindowCompat$Api21PopupWindowImpl extends PopupWindowCompat$KitKatPopupWindowImpl {
   public boolean getOverlapAnchor(PopupWindow var1) {
      return PopupWindowCompatApi21.getOverlapAnchor(var1);
   }

   public void setOverlapAnchor(PopupWindow var1, boolean var2) {
      PopupWindowCompatApi21.setOverlapAnchor(var1, var2);
   }
}
