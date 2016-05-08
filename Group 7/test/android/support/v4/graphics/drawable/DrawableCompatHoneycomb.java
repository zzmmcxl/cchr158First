package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableWrapperHoneycomb;

class DrawableCompatHoneycomb {
   public static void jumpToCurrentState(Drawable var0) {
      var0.jumpToCurrentState();
   }

   public static Drawable wrapForTinting(Drawable var0) {
      Object var1 = var0;
      if(!(var0 instanceof DrawableWrapperHoneycomb)) {
         var1 = new DrawableWrapperHoneycomb(var0);
      }

      return (Drawable)var1;
   }
}
