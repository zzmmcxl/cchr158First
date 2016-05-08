package android.support.v4.view;

import android.graphics.Rect;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;

class ViewPager$4 implements OnApplyWindowInsetsListener {
   private final Rect mTempRect;

   ViewPager$4(ViewPager var1) {
      this.this$0 = var1;
      this.mTempRect = new Rect();
   }

   public WindowInsetsCompat onApplyWindowInsets(View var1, WindowInsetsCompat var2) {
      WindowInsetsCompat var6 = ViewCompat.onApplyWindowInsets(var1, var2);
      if(var6.isConsumed()) {
         return var6;
      } else {
         Rect var7 = this.mTempRect;
         var7.left = var6.getSystemWindowInsetLeft();
         var7.top = var6.getSystemWindowInsetTop();
         var7.right = var6.getSystemWindowInsetRight();
         var7.bottom = var6.getSystemWindowInsetBottom();
         int var3 = 0;

         for(int var4 = this.this$0.getChildCount(); var3 < var4; ++var3) {
            WindowInsetsCompat var5 = ViewCompat.dispatchApplyWindowInsets(this.this$0.getChildAt(var3), var6);
            var7.left = Math.min(var5.getSystemWindowInsetLeft(), var7.left);
            var7.top = Math.min(var5.getSystemWindowInsetTop(), var7.top);
            var7.right = Math.min(var5.getSystemWindowInsetRight(), var7.right);
            var7.bottom = Math.min(var5.getSystemWindowInsetBottom(), var7.bottom);
         }

         return var6.replaceSystemWindowInsets(var7.left, var7.top, var7.right, var7.bottom);
      }
   }
}
