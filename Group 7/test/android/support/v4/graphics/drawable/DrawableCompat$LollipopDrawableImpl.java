package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat$KitKatDrawableImpl;
import android.support.v4.graphics.drawable.DrawableCompatLollipop;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class DrawableCompat$LollipopDrawableImpl extends DrawableCompat$KitKatDrawableImpl {
   public void applyTheme(Drawable var1, Theme var2) {
      DrawableCompatLollipop.applyTheme(var1, var2);
   }

   public boolean canApplyTheme(Drawable var1) {
      return DrawableCompatLollipop.canApplyTheme(var1);
   }

   public ColorFilter getColorFilter(Drawable var1) {
      return DrawableCompatLollipop.getColorFilter(var1);
   }

   public void inflate(Drawable var1, Resources var2, XmlPullParser var3, AttributeSet var4, Theme var5) throws IOException, XmlPullParserException {
      DrawableCompatLollipop.inflate(var1, var2, var3, var4, var5);
   }

   public void setHotspot(Drawable var1, float var2, float var3) {
      DrawableCompatLollipop.setHotspot(var1, var2, var3);
   }

   public void setHotspotBounds(Drawable var1, int var2, int var3, int var4, int var5) {
      DrawableCompatLollipop.setHotspotBounds(var1, var2, var3, var4, var5);
   }

   public void setTint(Drawable var1, int var2) {
      DrawableCompatLollipop.setTint(var1, var2);
   }

   public void setTintList(Drawable var1, ColorStateList var2) {
      DrawableCompatLollipop.setTintList(var1, var2);
   }

   public void setTintMode(Drawable var1, Mode var2) {
      DrawableCompatLollipop.setTintMode(var1, var2);
   }

   public Drawable wrap(Drawable var1) {
      return DrawableCompatLollipop.wrapForTinting(var1);
   }
}
