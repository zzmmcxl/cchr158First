package android.support.v4.app;

import android.support.v4.app.FragmentManagerImpl;

class FragmentManagerImpl$4 implements Runnable {
   FragmentManagerImpl$4(FragmentManagerImpl var1, int var2, int var3) {
      this.this$0 = var1;
      this.val$id = var2;
      this.val$flags = var3;
   }

   public void run() {
      this.this$0.popBackStackState(this.this$0.mHost.getHandler(), (String)null, this.val$id, this.val$flags);
   }
}
