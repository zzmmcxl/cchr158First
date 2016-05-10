package android.support.v7.internal.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public class DrawableUtils {
   public static final Rect INSETS_NONE = new Rect();
   private static final String TAG = "DrawableUtils";
   private static Class sInsetsClazz;

   static {
      if(VERSION.SDK_INT >= 18) {
         try {
            sInsetsClazz = Class.forName("android.graphics.Insets");
         } catch (ClassNotFoundException var1) {
            return;
         }
      }

   }

   public static Rect getOpticalBounds(Drawable param0) {
      // $FF: Couldn't be decompiled
   }
}
