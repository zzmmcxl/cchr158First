package android.support.v4.view;

import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;

class ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener implements ViewPropertyAnimatorListener {
   boolean mAnimEndCalled;
   ViewPropertyAnimatorCompat mVpa;

   ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener(ViewPropertyAnimatorCompat var1) {
      this.mVpa = var1;
   }

   public void onAnimationCancel(View var1) {
      Object var3 = var1.getTag(2113929216);
      ViewPropertyAnimatorListener var2 = null;
      if(var3 instanceof ViewPropertyAnimatorListener) {
         var2 = (ViewPropertyAnimatorListener)var3;
      }

      if(var2 != null) {
         var2.onAnimationCancel(var1);
      }

   }

   public void onAnimationEnd(View var1) {
      if(ViewPropertyAnimatorCompat.access$400(this.mVpa) >= 0) {
         ViewCompat.setLayerType(var1, ViewPropertyAnimatorCompat.access$400(this.mVpa), (Paint)null);
         ViewPropertyAnimatorCompat.access$402(this.mVpa, -1);
      }

      if(VERSION.SDK_INT >= 16 || !this.mAnimEndCalled) {
         if(ViewPropertyAnimatorCompat.access$000(this.mVpa) != null) {
            Runnable var2 = ViewPropertyAnimatorCompat.access$000(this.mVpa);
            ViewPropertyAnimatorCompat.access$002(this.mVpa, (Runnable)null);
            var2.run();
         }

         Object var3 = var1.getTag(2113929216);
         ViewPropertyAnimatorListener var4 = null;
         if(var3 instanceof ViewPropertyAnimatorListener) {
            var4 = (ViewPropertyAnimatorListener)var3;
         }

         if(var4 != null) {
            var4.onAnimationEnd(var1);
         }

         this.mAnimEndCalled = true;
      }

   }

   public void onAnimationStart(View var1) {
      this.mAnimEndCalled = false;
      if(ViewPropertyAnimatorCompat.access$400(this.mVpa) >= 0) {
         ViewCompat.setLayerType(var1, 2, (Paint)null);
      }

      if(ViewPropertyAnimatorCompat.access$100(this.mVpa) != null) {
         Runnable var2 = ViewPropertyAnimatorCompat.access$100(this.mVpa);
         ViewPropertyAnimatorCompat.access$102(this.mVpa, (Runnable)null);
         var2.run();
      }

      Object var3 = var1.getTag(2113929216);
      ViewPropertyAnimatorListener var4 = null;
      if(var3 instanceof ViewPropertyAnimatorListener) {
         var4 = (ViewPropertyAnimatorListener)var3;
      }

      if(var4 != null) {
         var4.onAnimationStart(var1);
      }

   }
}
