package android.support.v4.widget;

import android.view.View;
import android.widget.PopupWindow;

interface PopupWindowCompat$PopupWindowImpl {
   boolean getOverlapAnchor(PopupWindow var1);

   int getWindowLayoutType(PopupWindow var1);

   void setOverlapAnchor(PopupWindow var1, boolean var2);

   void setWindowLayoutType(PopupWindow var1, int var2);

   void showAsDropDown(PopupWindow var1, View var2, int var3, int var4, int var5);
}
