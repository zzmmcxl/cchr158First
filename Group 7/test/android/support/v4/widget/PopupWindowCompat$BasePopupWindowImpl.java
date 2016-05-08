package android.support.v4.widget;

import android.support.v4.widget.PopupWindowCompat$PopupWindowImpl;
import android.view.View;
import android.widget.PopupWindow;

class PopupWindowCompat$BasePopupWindowImpl implements PopupWindowCompat$PopupWindowImpl {
   public boolean getOverlapAnchor(PopupWindow var1) {
      return false;
   }

   public int getWindowLayoutType(PopupWindow var1) {
      return 0;
   }

   public void setOverlapAnchor(PopupWindow var1, boolean var2) {
   }

   public void setWindowLayoutType(PopupWindow var1, int var2) {
   }

   public void showAsDropDown(PopupWindow var1, View var2, int var3, int var4, int var5) {
      var1.showAsDropDown(var2, var3, var4);
   }
}
