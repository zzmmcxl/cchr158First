package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableWrapperEclair;

class DrawableCompatEclair {
   public static Drawable wrapForTinting(Drawable var0) {
      Object var1 = var0;
      if(!(var0 instanceof DrawableWrapperEclair)) {
         var1 = new DrawableWrapperEclair(var0);
      }

      return (Drawable)var1;
   }
}
