package android.support.v4.app;

import android.support.v4.app.FragmentManagerImpl;

class FragmentManagerImpl$3 implements Runnable {
   FragmentManagerImpl$3(FragmentManagerImpl var1, String var2, int var3) {
      this.this$0 = var1;
      this.val$name = var2;
      this.val$flags = var3;
   }

   public void run() {
      this.this$0.popBackStackState(this.this$0.mHost.getHandler(), this.val$name, -1, this.val$flags);
   }
}
