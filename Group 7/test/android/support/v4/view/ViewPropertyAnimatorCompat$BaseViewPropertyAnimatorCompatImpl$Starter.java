package android.support.v4.view;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl;
import android.view.View;
import java.lang.ref.WeakReference;

class ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl$Starter implements Runnable {
   WeakReference<View> mViewRef;
   ViewPropertyAnimatorCompat mVpa;

   private ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl$Starter(ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl var1, ViewPropertyAnimatorCompat var2, View var3) {
      this.this$0 = var1;
      this.mViewRef = new WeakReference(var3);
      this.mVpa = var2;
   }

   public void run() {
      View var1 = (View)this.mViewRef.get();
      if(var1 != null) {
         ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl.access$200(this.this$0, this.mVpa, var1);
      }

   }
}
