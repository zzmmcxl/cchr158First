package android.support.v7.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class AlertController$ButtonHandler extends Handler {
   private static final int MSG_DISMISS_DIALOG = 1;
   private WeakReference<DialogInterface> mDialog;

   public AlertController$ButtonHandler(DialogInterface var1) {
      this.mDialog = new WeakReference(var1);
   }

   public void handleMessage(Message var1) {
      switch(var1.what) {
      case -3:
      case -2:
      case -1:
         ((OnClickListener)var1.obj).onClick((DialogInterface)this.mDialog.get(), var1.what);
         return;
      case 0:
      default:
         return;
      case 1:
         ((DialogInterface)var1.obj).dismiss();
      }
   }
}
