package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable21;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory$DefaultRoundedBitmapDrawable;
import android.util.Log;
import java.io.InputStream;

public final class RoundedBitmapDrawableFactory {
   private static final String TAG = "RoundedBitmapDrawableFactory";

   public static RoundedBitmapDrawable create(Resources var0, Bitmap var1) {
      return (RoundedBitmapDrawable)(VERSION.SDK_INT >= 21?new RoundedBitmapDrawable21(var0, var1):new RoundedBitmapDrawableFactory$DefaultRoundedBitmapDrawable(var0, var1));
   }

   public static RoundedBitmapDrawable create(Resources var0, InputStream var1) {
      RoundedBitmapDrawable var2 = create(var0, BitmapFactory.decodeStream(var1));
      if(var2.getBitmap() == null) {
         Log.w("RoundedBitmapDrawableFactory", "RoundedBitmapDrawable cannot decode " + var1);
      }

      return var2;
   }

   public static RoundedBitmapDrawable create(Resources var0, String var1) {
      RoundedBitmapDrawable var2 = create(var0, BitmapFactory.decodeFile(var1));
      if(var2.getBitmap() == null) {
         Log.w("RoundedBitmapDrawableFactory", "RoundedBitmapDrawable cannot decode " + var1);
      }

      return var2;
   }
}
