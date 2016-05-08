package android.support.v7.app;

import android.content.Context;
import android.support.v7.app.AppCompatDelegateImplV7;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.ContentFrameLayout;
import android.view.KeyEvent;
import android.view.MotionEvent;

class AppCompatDelegateImplV7$ListMenuDecorView extends ContentFrameLayout {
   public AppCompatDelegateImplV7$ListMenuDecorView(AppCompatDelegateImplV7 var1, Context var2) {
      super(var2);
      this.this$0 = var1;
   }

   private boolean isOutOfBounds(int var1, int var2) {
      return var1 < -5 || var2 < -5 || var1 > this.getWidth() + 5 || var2 > this.getHeight() + 5;
   }

   public boolean dispatchKeyEvent(KeyEvent var1) {
      return this.this$0.dispatchKeyEvent(var1) || super.dispatchKeyEvent(var1);
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      if(var1.getAction() == 0 && this.isOutOfBounds((int)var1.getX(), (int)var1.getY())) {
         AppCompatDelegateImplV7.access$1400(this.this$0, 0);
         return true;
      } else {
         return super.onInterceptTouchEvent(var1);
      }
   }

   public void setBackgroundResource(int var1) {
      this.setBackgroundDrawable(AppCompatDrawableManager.get().getDrawable(this.getContext(), var1));
   }
}
