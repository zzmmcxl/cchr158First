package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.widget.AppCompatDrawableManager$InflateDelegate;
import android.util.AttributeSet;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;

class AppCompatDrawableManager$VdcInflateDelegate implements AppCompatDrawableManager$InflateDelegate {
   private AppCompatDrawableManager$VdcInflateDelegate() {
   }

   public Drawable createFromXmlInner(@NonNull Context var1, @NonNull XmlPullParser var2, @NonNull AttributeSet var3, @Nullable Theme var4) {
      try {
         VectorDrawableCompat var6 = VectorDrawableCompat.createFromXmlInner(var1.getResources(), var2, var3, var4);
         return var6;
      } catch (Exception var5) {
         Log.e("VdcInflateDelegate", "Exception while inflating <vector>", var5);
         return null;
      }
   }
}
