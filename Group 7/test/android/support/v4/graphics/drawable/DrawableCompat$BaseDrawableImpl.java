package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat$DrawableImpl;
import android.support.v4.graphics.drawable.DrawableCompatBase;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class DrawableCompat$BaseDrawableImpl implements DrawableCompat$DrawableImpl {
   public void applyTheme(Drawable var1, Theme var2) {
   }

   public boolean canApplyTheme(Drawable var1) {
      return false;
   }

   public int getAlpha(Drawable var1) {
      return 0;
   }

   public ColorFilter getColorFilter(Drawable var1) {
      return null;
   }

   public int getLayoutDirection(Drawable var1) {
      return 0;
   }

   public void inflate(Drawable var1, Resources var2, XmlPullParser var3, AttributeSet var4, Theme var5) throws IOException, XmlPullParserException {
      DrawableCompatBase.inflate(var1, var2, var3, var4, var5);
   }

   public boolean isAutoMirrored(Drawable var1) {
      return false;
   }

   public void jumpToCurrentState(Drawable var1) {
   }

   public void setAutoMirrored(Drawable var1, boolean var2) {
   }

   public void setHotspot(Drawable var1, float var2, float var3) {
   }

   public void setHotspotBounds(Drawable var1, int var2, int var3, int var4, int var5) {
   }

   public void setLayoutDirection(Drawable var1, int var2) {
   }

   public void setTint(Drawable var1, int var2) {
      DrawableCompatBase.setTint(var1, var2);
   }

   public void setTintList(Drawable var1, ColorStateList var2) {
      DrawableCompatBase.setTintList(var1, var2);
   }

   public void setTintMode(Drawable var1, Mode var2) {
      DrawableCompatBase.setTintMode(var1, var2);
   }

   public Drawable wrap(Drawable var1) {
      return DrawableCompatBase.wrapForTinting(var1);
   }
}
