package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

interface DrawableCompat$DrawableImpl {
   void applyTheme(Drawable var1, Theme var2);

   boolean canApplyTheme(Drawable var1);

   int getAlpha(Drawable var1);

   ColorFilter getColorFilter(Drawable var1);

   int getLayoutDirection(Drawable var1);

   void inflate(Drawable var1, Resources var2, XmlPullParser var3, AttributeSet var4, Theme var5) throws IOException, XmlPullParserException;

   boolean isAutoMirrored(Drawable var1);

   void jumpToCurrentState(Drawable var1);

   void setAutoMirrored(Drawable var1, boolean var2);

   void setHotspot(Drawable var1, float var2, float var3);

   void setHotspotBounds(Drawable var1, int var2, int var3, int var4, int var5);

   void setLayoutDirection(Drawable var1, int var2);

   void setTint(Drawable var1, int var2);

   void setTintList(Drawable var1, ColorStateList var2);

   void setTintMode(Drawable var1, Mode var2);

   Drawable wrap(Drawable var1);
}
