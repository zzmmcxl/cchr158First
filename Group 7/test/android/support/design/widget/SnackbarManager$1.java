package android.support.design.widget;

import android.os.Message;
import android.os.Handler.Callback;
import android.support.design.widget.SnackbarManager;
import android.support.design.widget.SnackbarManager$SnackbarRecord;

class SnackbarManager$1 implements Callback {
   SnackbarManager$1(SnackbarManager var1) {
      this.this$0 = var1;
   }

   public boolean handleMessage(Message var1) {
      switch(var1.what) {
      case 0:
         SnackbarManager.access$000(this.this$0, (SnackbarManager$SnackbarRecord)var1.obj);
         return true;
      default:
         return false;
      }
   }
}
