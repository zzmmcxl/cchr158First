package android.support.v4.app;

import android.support.v4.app.FragmentManagerImpl;

class FragmentManagerImpl$2 implements Runnable {
   FragmentManagerImpl$2(FragmentManagerImpl var1) {
      this.this$0 = var1;
   }

   public void run() {
      this.this$0.popBackStackState(this.this$0.mHost.getHandler(), (String)null, -1, 0);
   }
}
