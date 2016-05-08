package android.support.v4.os;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;

class ResultReceiver$MyRunnable implements Runnable {
   final int mResultCode;
   final Bundle mResultData;

   ResultReceiver$MyRunnable(ResultReceiver var1, int var2, Bundle var3) {
      this.this$0 = var1;
      this.mResultCode = var2;
      this.mResultData = var3;
   }

   public void run() {
      this.this$0.onReceiveResult(this.mResultCode, this.mResultData);
   }
}
