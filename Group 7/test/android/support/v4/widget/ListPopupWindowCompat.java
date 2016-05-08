package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.widget.ListPopupWindowCompat$BaseListPopupWindowImpl;
import android.support.v4.widget.ListPopupWindowCompat$KitKatListPopupWindowImpl;
import android.support.v4.widget.ListPopupWindowCompat$ListPopupWindowImpl;
import android.view.View;
import android.view.View.OnTouchListener;

public final class ListPopupWindowCompat {
   static final ListPopupWindowCompat$ListPopupWindowImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 19) {
         IMPL = new ListPopupWindowCompat$KitKatListPopupWindowImpl();
      } else {
         IMPL = new ListPopupWindowCompat$BaseListPopupWindowImpl();
      }
   }

   public static OnTouchListener createDragToOpenListener(Object var0, View var1) {
      return IMPL.createDragToOpenListener(var0, var1);
   }
}
