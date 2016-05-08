package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat$EclairDrawableImpl;
import android.support.v4.graphics.drawable.DrawableCompatHoneycomb;

class DrawableCompat$HoneycombDrawableImpl extends DrawableCompat$EclairDrawableImpl {
   public void jumpToCurrentState(Drawable var1) {
      DrawableCompatHoneycomb.jumpToCurrentState(var1);
   }

   public Drawable wrap(Drawable var1) {
      return DrawableCompatHoneycomb.wrapForTinting(var1);
   }
}
