package android.support.v4.graphics.drawable;

import android.content.res.Resources.Theme;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableWrapperKitKat;

class DrawableWrapperLollipop extends DrawableWrapperKitKat {
   DrawableWrapperLollipop(Drawable var1) {
      super(var1);
   }

   public void applyTheme(Theme var1) {
      this.mDrawable.applyTheme(var1);
   }

   public boolean canApplyTheme() {
      return this.mDrawable.canApplyTheme();
   }

   public Rect getDirtyBounds() {
      return this.mDrawable.getDirtyBounds();
   }

   public void getOutline(Outline var1) {
      this.mDrawable.getOutline(var1);
   }

   public void setHotspot(float var1, float var2) {
      this.mDrawable.setHotspot(var1, var2);
   }

   public void setHotspotBounds(int var1, int var2, int var3, int var4) {
      this.mDrawable.setHotspotBounds(var1, var2, var3, var4);
   }
}
