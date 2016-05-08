package android.support.v4.widget;

import android.support.v4.widget.PopupWindowCompat$BasePopupWindowImpl;
import android.support.v4.widget.PopupWindowCompatGingerbread;
import android.widget.PopupWindow;

class PopupWindowCompat$GingerbreadPopupWindowImpl extends PopupWindowCompat$BasePopupWindowImpl {
   public int getWindowLayoutType(PopupWindow var1) {
      return PopupWindowCompatGingerbread.getWindowLayoutType(var1);
   }

   public void setWindowLayoutType(PopupWindow var1, int var2) {
      PopupWindowCompatGingerbread.setWindowLayoutType(var1, var2);
   }
}
