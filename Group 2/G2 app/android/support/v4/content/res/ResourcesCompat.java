package android.support.v4.content.res;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.res.ResourcesCompatApi21;
import android.support.v4.content.res.ResourcesCompatIcsMr1;

public class ResourcesCompat {
   public static Drawable getDrawable(Resources var0, int var1, Theme var2) throws NotFoundException {
      return VERSION.SDK_INT >= 21?ResourcesCompatApi21.getDrawable(var0, var1, var2):var0.getDrawable(var1);
   }

   public static Drawable getDrawableForDensity(Resources var0, int var1, int var2, Theme var3) throws NotFoundException {
      int var4 = VERSION.SDK_INT;
      return var4 >= 21?ResourcesCompatApi21.getDrawableForDensity(var0, var1, var2, var3):(var4 >= 15?ResourcesCompatIcsMr1.getDrawableForDensity(var0, var1, var2):var0.getDrawable(var1));
   }
}
