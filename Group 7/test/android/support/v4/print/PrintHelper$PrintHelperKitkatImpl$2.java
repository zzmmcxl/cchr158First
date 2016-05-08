package android.support.v4.print;

import android.support.v4.print.PrintHelper$OnPrintFinishCallback;
import android.support.v4.print.PrintHelper$PrintHelperKitkatImpl;
import android.support.v4.print.PrintHelperKitkat$OnPrintFinishCallback;

class PrintHelper$PrintHelperKitkatImpl$2 implements PrintHelperKitkat$OnPrintFinishCallback {
   PrintHelper$PrintHelperKitkatImpl$2(PrintHelper$PrintHelperKitkatImpl var1, PrintHelper$OnPrintFinishCallback var2) {
      this.this$0 = var1;
      this.val$callback = var2;
   }

   public void onFinish() {
      this.val$callback.onFinish();
   }
}
