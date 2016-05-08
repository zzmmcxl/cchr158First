package android.support.v4.app;

import android.support.v4.app.FragmentManagerImpl;

class FragmentManagerImpl$1 implements Runnable {
   FragmentManagerImpl$1(FragmentManagerImpl var1) {
      this.this$0 = var1;
   }

   public void run() {
      this.this$0.execPendingActions();
   }
}
