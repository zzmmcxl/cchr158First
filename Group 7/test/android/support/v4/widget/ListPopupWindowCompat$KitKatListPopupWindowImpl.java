package android.support.v4.widget;

import android.support.v4.widget.ListPopupWindowCompat$BaseListPopupWindowImpl;
import android.support.v4.widget.ListPopupWindowCompatKitKat;
import android.view.View;
import android.view.View.OnTouchListener;

class ListPopupWindowCompat$KitKatListPopupWindowImpl extends ListPopupWindowCompat$BaseListPopupWindowImpl {
   public OnTouchListener createDragToOpenListener(Object var1, View var2) {
      return ListPopupWindowCompatKitKat.createDragToOpenListener(var1, var2);
   }
}
