package android.support.v4.app;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.ViewCompat;

class ActionBarDrawerToggle$SlideDrawable extends InsetDrawable implements Callback {
   private final boolean mHasMirroring;
   private float mOffset;
   private float mPosition;
   private final Rect mTmpRect;

   private ActionBarDrawerToggle$SlideDrawable(ActionBarDrawerToggle var1, Drawable var2) {
      boolean var3 = false;
      this.this$0 = var1;
      super(var2, 0);
      if(VERSION.SDK_INT > 18) {
         var3 = true;
      }

      this.mHasMirroring = var3;
      this.mTmpRect = new Rect();
   }

   public void draw(Canvas var1) {
      byte var3 = 1;
      this.copyBounds(this.mTmpRect);
      var1.save();
      boolean var2;
      if(ViewCompat.getLayoutDirection(ActionBarDrawerToggle.access$400(this.this$0).getWindow().getDecorView()) == 1) {
         var2 = true;
      } else {
         var2 = false;
      }

      if(var2) {
         var3 = -1;
      }

      int var4 = this.mTmpRect.width();
      var1.translate(-this.mOffset * (float)var4 * this.mPosition * (float)var3, 0.0F);
      if(var2 && !this.mHasMirroring) {
         var1.translate((float)var4, 0.0F);
         var1.scale(-1.0F, 1.0F);
      }

      super.draw(var1);
      var1.restore();
   }

   public float getPosition() {
      return this.mPosition;
   }

   public void setOffset(float var1) {
      this.mOffset = var1;
      this.invalidateSelf();
   }

   public void setPosition(float var1) {
      this.mPosition = var1;
      this.invalidateSelf();
   }
}
