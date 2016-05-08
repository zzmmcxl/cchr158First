package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat$BaseDrawableImpl;
import android.support.v4.graphics.drawable.DrawableCompatEclair;

class DrawableCompat$EclairDrawableImpl extends DrawableCompat$BaseDrawableImpl {
   public Drawable wrap(Drawable var1) {
      return DrawableCompatEclair.wrapForTinting(var1);
   }
}
