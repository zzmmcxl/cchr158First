package android.support.design.widget;

import android.os.Message;
import android.os.Handler.Callback;
import android.support.design.widget.Snackbar;

final class Snackbar$1 implements Callback {
   public boolean handleMessage(Message var1) {
      switch(var1.what) {
      case 0:
         ((Snackbar)var1.obj).showView();
         return true;
      case 1:
         ((Snackbar)var1.obj).hideView(var1.arg1);
         return true;
      default:
         return false;
      }
   }
}
