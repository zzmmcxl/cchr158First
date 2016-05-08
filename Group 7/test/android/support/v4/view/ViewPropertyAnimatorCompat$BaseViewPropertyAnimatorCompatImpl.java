package android.support.v4.view;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat$1;
import android.support.v4.view.ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl$Starter;
import android.support.v4.view.ViewPropertyAnimatorCompat$ViewPropertyAnimatorCompatImpl;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

class ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl implements ViewPropertyAnimatorCompat$ViewPropertyAnimatorCompatImpl {
   WeakHashMap<View, Runnable> mStarterMap = null;

   private void postStartMessage(ViewPropertyAnimatorCompat var1, View var2) {
      Runnable var3 = null;
      if(this.mStarterMap != null) {
         var3 = (Runnable)this.mStarterMap.get(var2);
      }

      Object var4 = var3;
      if(var3 == null) {
         var4 = new ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl$Starter(this, var1, var2, (ViewPropertyAnimatorCompat$1)null);
         if(this.mStarterMap == null) {
            this.mStarterMap = new WeakHashMap();
         }

         this.mStarterMap.put(var2, var4);
      }

      var2.removeCallbacks((Runnable)var4);
      var2.post((Runnable)var4);
   }

   private void removeStartMessage(View var1) {
      if(this.mStarterMap != null) {
         Runnable var2 = (Runnable)this.mStarterMap.get(var1);
         if(var2 != null) {
            var1.removeCallbacks(var2);
         }
      }

   }

   private void startAnimation(ViewPropertyAnimatorCompat var1, View var2) {
      Object var4 = var2.getTag(2113929216);
      ViewPropertyAnimatorListener var3 = null;
      if(var4 instanceof ViewPropertyAnimatorListener) {
         var3 = (ViewPropertyAnimatorListener)var4;
      }

      Runnable var6 = ViewPropertyAnimatorCompat.access$100(var1);
      Runnable var5 = ViewPropertyAnimatorCompat.access$000(var1);
      ViewPropertyAnimatorCompat.access$102(var1, (Runnable)null);
      ViewPropertyAnimatorCompat.access$002(var1, (Runnable)null);
      if(var6 != null) {
         var6.run();
      }

      if(var3 != null) {
         var3.onAnimationStart(var2);
         var3.onAnimationEnd(var2);
      }

      if(var5 != null) {
         var5.run();
      }

      if(this.mStarterMap != null) {
         this.mStarterMap.remove(var2);
      }

   }

   public void alpha(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      this.postStartMessage(var1, var2);
   }

   public void alphaBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      this.postStartMessage(var1, var2);
   }

   public void cancel(ViewPropertyAnimatorCompat var1, View var2) {
      this.postStartMessage(var1, var2);
   }

   public long getDuration(ViewPropertyAnimatorCompat var1, View var2) {
      return 0L;
   }

   public Interpolator getInterpolator(ViewPropertyAnimatorCompat var1, View var2) {
      return null;
   }

   public long getStartDelay(ViewPropertyAnimatorCompat var1, View var2) {
      return 0L;
   }

   public void rotation(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      this.postStartMessage(var1, var2);
   }

   public void rotationBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      this.postStartMessage(var1, var2);
   }

   public void rotationX(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      this.postStartMessage(var1, var2);
   }

   public void rotationXBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      this.postStartMessage(var1, var2);
   }

   public void rotationY(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      this.postStartMessage(var1, var2);
   }

   public void rotationYBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      this.postStartMessage(var1, var2);
   }

   public void scaleX(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      this.postStartMessage(var1, var2);
   }

   public void scaleXBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      this.postStartMessage(var1, var2);
   }

   public void scaleY(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      this.postStartMessage(var1, var2);
   }

   public void scaleYBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      this.postStartMessage(var1, var2);
   }

   public void setDuration(ViewPropertyAnimatorCompat var1, View var2, long var3) {
   }

   public void setInterpolator(ViewPropertyAnimatorCompat var1, View var2, Interpolator var3) {
   }

   public void setListener(ViewPropertyAnimatorCompat var1, View var2, ViewPropertyAnimatorListener var3) {
      var2.setTag(2113929216, var3);
   }

   public void setStartDelay(ViewPropertyAnimatorCompat var1, View var2, long var3) {
   }

   public void setUpdateListener(ViewPropertyAnimatorCompat var1, View var2, ViewPropertyAnimatorUpdateListener var3) {
   }

   public void start(ViewPropertyAnimatorCompat var1, View var2) {
      this.removeStartMessage(var2);
      this.startAnimation(var1, var2);
   }

   public void translationX(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      this.postStartMessage(var1, var2);
   }

   public void translationXBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      this.postStartMessage(var1, var2);
   }

   public void translationY(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      this.postStartMessage(var1, var2);
   }

   public void translationYBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      this.postStartMessage(var1, var2);
   }

   public void translationZ(ViewPropertyAnimatorCompat var1, View var2, float var3) {
   }

   public void translationZBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
   }

   public void withEndAction(ViewPropertyAnimatorCompat var1, View var2, Runnable var3) {
      ViewPropertyAnimatorCompat.access$002(var1, var3);
      this.postStartMessage(var1, var2);
   }

   public void withLayer(ViewPropertyAnimatorCompat var1, View var2) {
   }

   public void withStartAction(ViewPropertyAnimatorCompat var1, View var2, Runnable var3) {
      ViewPropertyAnimatorCompat.access$102(var1, var3);
      this.postStartMessage(var1, var2);
   }

   public void x(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      this.postStartMessage(var1, var2);
   }

   public void xBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      this.postStartMessage(var1, var2);
   }

   public void y(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      this.postStartMessage(var1, var2);
   }

   public void yBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      this.postStartMessage(var1, var2);
   }

   public void z(ViewPropertyAnimatorCompat var1, View var2, float var3) {
   }

   public void zBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
   }
}
