package android.support.v4.widget;

import android.support.v4.widget.PopupWindowCompat$GingerbreadPopupWindowImpl;
import android.support.v4.widget.PopupWindowCompatKitKat;
import android.view.View;
import android.widget.PopupWindow;

class PopupWindowCompat$KitKatPopupWindowImpl extends PopupWindowCompat$GingerbreadPopupWindowImpl {
   public void showAsDropDown(PopupWindow var1, View var2, int var3, int var4, int var5) {
      PopupWindowCompatKitKat.showAsDropDown(var1, var2, var3, var4, var5);
   }
}
