package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl;
import android.support.v4.view.ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl;
import android.support.v4.view.ViewPropertyAnimatorCompat$JBMr2ViewPropertyAnimatorCompatImpl;
import android.support.v4.view.ViewPropertyAnimatorCompat$JBViewPropertyAnimatorCompatImpl;
import android.support.v4.view.ViewPropertyAnimatorCompat$KitKatViewPropertyAnimatorCompatImpl;
import android.support.v4.view.ViewPropertyAnimatorCompat$LollipopViewPropertyAnimatorCompatImpl;
import android.support.v4.view.ViewPropertyAnimatorCompat$ViewPropertyAnimatorCompatImpl;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class ViewPropertyAnimatorCompat {
   static final ViewPropertyAnimatorCompat$ViewPropertyAnimatorCompatImpl IMPL;
   static final int LISTENER_TAG_ID = 2113929216;
   private static final String TAG = "ViewAnimatorCompat";
   private Runnable mEndAction = null;
   private int mOldLayerType = -1;
   private Runnable mStartAction = null;
   private WeakReference<View> mView;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 21) {
         IMPL = new ViewPropertyAnimatorCompat$LollipopViewPropertyAnimatorCompatImpl();
      } else if(var0 >= 19) {
         IMPL = new ViewPropertyAnimatorCompat$KitKatViewPropertyAnimatorCompatImpl();
      } else if(var0 >= 18) {
         IMPL = new ViewPropertyAnimatorCompat$JBMr2ViewPropertyAnimatorCompatImpl();
      } else if(var0 >= 16) {
         IMPL = new ViewPropertyAnimatorCompat$JBViewPropertyAnimatorCompatImpl();
      } else if(var0 >= 14) {
         IMPL = new ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl();
      } else {
         IMPL = new ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl();
      }
   }

   ViewPropertyAnimatorCompat(View var1) {
      this.mView = new WeakReference(var1);
   }

   public ViewPropertyAnimatorCompat alpha(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.alpha(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat alphaBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.alphaBy(this, var2, var1);
      }

      return this;
   }

   public void cancel() {
      View var1 = (View)this.mView.get();
      if(var1 != null) {
         IMPL.cancel(this, var1);
      }

   }

   public long getDuration() {
      View var1 = (View)this.mView.get();
      return var1 != null?IMPL.getDuration(this, var1):0L;
   }

   public Interpolator getInterpolator() {
      View var1 = (View)this.mView.get();
      return var1 != null?IMPL.getInterpolator(this, var1):null;
   }

   public long getStartDelay() {
      View var1 = (View)this.mView.get();
      return var1 != null?IMPL.getStartDelay(this, var1):0L;
   }

   public ViewPropertyAnimatorCompat rotation(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.rotation(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat rotationBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.rotationBy(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat rotationX(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.rotationX(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat rotationXBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.rotationXBy(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat rotationY(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.rotationY(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat rotationYBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.rotationYBy(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat scaleX(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.scaleX(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat scaleXBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.scaleXBy(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat scaleY(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.scaleY(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat scaleYBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.scaleYBy(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat setDuration(long var1) {
      View var3 = (View)this.mView.get();
      if(var3 != null) {
         IMPL.setDuration(this, var3, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat setInterpolator(Interpolator var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.setInterpolator(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.setListener(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat setStartDelay(long var1) {
      View var3 = (View)this.mView.get();
      if(var3 != null) {
         IMPL.setStartDelay(this, var3, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.setUpdateListener(this, var2, var1);
      }

      return this;
   }

   public void start() {
      View var1 = (View)this.mView.get();
      if(var1 != null) {
         IMPL.start(this, var1);
      }

   }

   public ViewPropertyAnimatorCompat translationX(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.translationX(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat translationXBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.translationXBy(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat translationY(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.translationY(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat translationYBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.translationYBy(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat translationZ(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.translationZ(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat translationZBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.translationZBy(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat withEndAction(Runnable var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.withEndAction(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat withLayer() {
      View var1 = (View)this.mView.get();
      if(var1 != null) {
         IMPL.withLayer(this, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat withStartAction(Runnable var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.withStartAction(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat x(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.x(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat xBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.xBy(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat y(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.y(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat yBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.yBy(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat z(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.z(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat zBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.zBy(this, var2, var1);
      }

      return this;
   }
}
