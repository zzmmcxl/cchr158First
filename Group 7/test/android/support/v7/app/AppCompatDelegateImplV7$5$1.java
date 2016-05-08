package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.app.AppCompatDelegateImplV7$5;
import android.view.View;

class AppCompatDelegateImplV7$5$1 extends ViewPropertyAnimatorListenerAdapter {
   AppCompatDelegateImplV7$5$1(AppCompatDelegateImplV7$5 var1) {
      this.this$1 = var1;
   }

   public void onAnimationEnd(View var1) {
      ViewCompat.setAlpha(this.this$1.this$0.mActionModeView, 1.0F);
      this.this$1.this$0.mFadeAnim.setListener((ViewPropertyAnimatorListener)null);
      this.this$1.this$0.mFadeAnim = null;
   }

   public void onAnimationStart(View var1) {
      this.this$1.this$0.mActionModeView.setVisibility(0);
   }
}
