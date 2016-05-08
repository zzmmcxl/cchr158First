package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.app.AppCompatDelegateImplV7$ActionModeCallbackWrapperV7;
import android.view.View;

class AppCompatDelegateImplV7$ActionModeCallbackWrapperV7$1 extends ViewPropertyAnimatorListenerAdapter {
   AppCompatDelegateImplV7$ActionModeCallbackWrapperV7$1(AppCompatDelegateImplV7$ActionModeCallbackWrapperV7 var1) {
      this.this$1 = var1;
   }

   public void onAnimationEnd(View var1) {
      this.this$1.this$0.mActionModeView.setVisibility(8);
      if(this.this$1.this$0.mActionModePopup != null) {
         this.this$1.this$0.mActionModePopup.dismiss();
      } else if(this.this$1.this$0.mActionModeView.getParent() instanceof View) {
         ViewCompat.requestApplyInsets((View)this.this$1.this$0.mActionModeView.getParent());
      }

      this.this$1.this$0.mActionModeView.removeAllViews();
      this.this$1.this$0.mFadeAnim.setListener((ViewPropertyAnimatorListener)null);
      this.this$1.this$0.mFadeAnim = null;
   }
}
