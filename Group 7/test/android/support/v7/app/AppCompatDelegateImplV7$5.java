package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatDelegateImplV7;
import android.support.v7.app.AppCompatDelegateImplV7$5$1;

class AppCompatDelegateImplV7$5 implements Runnable {
   AppCompatDelegateImplV7$5(AppCompatDelegateImplV7 var1) {
      this.this$0 = var1;
   }

   public void run() {
      this.this$0.mActionModePopup.showAtLocation(this.this$0.mActionModeView, 55, 0, 0);
      AppCompatDelegateImplV7.access$500(this.this$0);
      ViewCompat.setAlpha(this.this$0.mActionModeView, 0.0F);
      this.this$0.mFadeAnim = ViewCompat.animate(this.this$0.mActionModeView).alpha(1.0F);
      this.this$0.mFadeAnim.setListener(new AppCompatDelegateImplV7$5$1(this));
   }
}
