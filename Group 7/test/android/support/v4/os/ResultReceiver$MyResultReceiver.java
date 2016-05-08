package android.support.v4.os;

import android.os.Bundle;
import android.support.v4.os.IResultReceiver$Stub;
import android.support.v4.os.ResultReceiver;
import android.support.v4.os.ResultReceiver$MyRunnable;

class ResultReceiver$MyResultReceiver extends IResultReceiver$Stub {
   ResultReceiver$MyResultReceiver(ResultReceiver var1) {
      this.this$0 = var1;
   }

   public void send(int var1, Bundle var2) {
      if(this.this$0.mHandler != null) {
         this.this$0.mHandler.post(new ResultReceiver$MyRunnable(this.this$0, var1, var2));
      } else {
         this.this$0.onReceiveResult(var1, var2);
      }
   }
}
