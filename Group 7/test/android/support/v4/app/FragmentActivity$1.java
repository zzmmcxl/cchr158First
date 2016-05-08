package android.support.v4.app;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;

class FragmentActivity$1 extends Handler {
   FragmentActivity$1(FragmentActivity var1) {
      this.this$0 = var1;
   }

   public void handleMessage(Message var1) {
      switch(var1.what) {
      case 1:
         if(this.this$0.mStopped) {
            this.this$0.doReallyStop(false);
            return;
         }
         break;
      case 2:
         this.this$0.onResumeFragments();
         this.this$0.mFragments.execPendingActions();
         return;
      default:
         super.handleMessage(var1);
      }

   }
}
