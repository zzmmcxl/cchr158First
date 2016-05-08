package android.support.v7.app;

import android.support.v7.app.AppCompatDelegateImplV7;

class AppCompatDelegateImplV7$1 implements Runnable {
   AppCompatDelegateImplV7$1(AppCompatDelegateImplV7 var1) {
      this.this$0 = var1;
   }

   public void run() {
      if((AppCompatDelegateImplV7.access$000(this.this$0) & 1) != 0) {
         AppCompatDelegateImplV7.access$100(this.this$0, 0);
      }

      if((AppCompatDelegateImplV7.access$000(this.this$0) & 4096) != 0) {
         AppCompatDelegateImplV7.access$100(this.this$0, 108);
      }

      AppCompatDelegateImplV7.access$202(this.this$0, false);
      AppCompatDelegateImplV7.access$002(this.this$0, 0);
   }
}
