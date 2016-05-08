package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.widget.PopupWindowCompat$Api21PopupWindowImpl;
import android.support.v4.widget.PopupWindowCompat$Api23PopupWindowImpl;
import android.support.v4.widget.PopupWindowCompat$BasePopupWindowImpl;
import android.support.v4.widget.PopupWindowCompat$GingerbreadPopupWindowImpl;
import android.support.v4.widget.PopupWindowCompat$KitKatPopupWindowImpl;
import android.support.v4.widget.PopupWindowCompat$PopupWindowImpl;
import android.view.View;
import android.widget.PopupWindow;

public final class PopupWindowCompat {
   static final PopupWindowCompat$PopupWindowImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 23) {
         IMPL = new PopupWindowCompat$Api23PopupWindowImpl();
      } else if(var0 >= 21) {
         IMPL = new PopupWindowCompat$Api21PopupWindowImpl();
      } else if(var0 >= 19) {
         IMPL = new PopupWindowCompat$KitKatPopupWindowImpl();
      } else if(var0 >= 9) {
         IMPL = new PopupWindowCompat$GingerbreadPopupWindowImpl();
      } else {
         IMPL = new PopupWindowCompat$BasePopupWindowImpl();
      }
   }

   public static boolean getOverlapAnchor(PopupWindow var0) {
      return IMPL.getOverlapAnchor(var0);
   }

   public static int getWindowLayoutType(PopupWindow var0) {
      return IMPL.getWindowLayoutType(var0);
   }

   public static void setOverlapAnchor(PopupWindow var0, boolean var1) {
      IMPL.setOverlapAnchor(var0, var1);
   }

   public static void setWindowLayoutType(PopupWindow var0, int var1) {
      IMPL.setWindowLayoutType(var0, var1);
   }

   public static void showAsDropDown(PopupWindow var0, View var1, int var2, int var3, int var4) {
      IMPL.showAsDropDown(var0, var1, var2, var3, var4);
   }
}
