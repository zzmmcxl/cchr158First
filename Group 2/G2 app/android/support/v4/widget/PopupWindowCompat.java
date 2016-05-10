package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.widget.PopupWindowCompatKitKat;
import android.view.View;
import android.widget.PopupWindow;

public class PopupWindowCompat {
   static final PopupWindowCompat.PopupWindowImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 19) {
         IMPL = new PopupWindowCompat.KitKatPopupWindowImpl();
      } else {
         IMPL = new PopupWindowCompat.BasePopupWindowImpl();
      }
   }

   public static void showAsDropDown(PopupWindow var0, View var1, int var2, int var3, int var4) {
      IMPL.showAsDropDown(var0, var1, var2, var3, var4);
   }

   static class BasePopupWindowImpl implements PopupWindowCompat.PopupWindowImpl {
      public void showAsDropDown(PopupWindow var1, View var2, int var3, int var4, int var5) {
         var1.showAsDropDown(var2, var3, var4);
      }
   }

   static class KitKatPopupWindowImpl extends PopupWindowCompat.BasePopupWindowImpl {
      public void showAsDropDown(PopupWindow var1, View var2, int var3, int var4, int var5) {
         PopupWindowCompatKitKat.showAsDropDown(var1, var2, var3, var4, var5);
      }
   }

   interface PopupWindowImpl {
      void showAsDropDown(PopupWindow var1, View var2, int var3, int var4, int var5);
   }
}
