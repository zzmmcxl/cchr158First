package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.widget.AppCompatDrawableManager$InflateDelegate;
import android.util.AttributeSet;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;

class AppCompatDrawableManager$AvdcInflateDelegate implements AppCompatDrawableManager$InflateDelegate {
   private AppCompatDrawableManager$AvdcInflateDelegate() {
   }

   public Drawable createFromXmlInner(@NonNull Context var1, @NonNull XmlPullParser var2, @NonNull AttributeSet var3, @Nullable Theme var4) {
      try {
         AnimatedVectorDrawableCompat var6 = AnimatedVectorDrawableCompat.createFromXmlInner(var1, var1.getResources(), var2, var3, var4);
         return var6;
      } catch (Exception var5) {
         Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", var5);
         return null;
      }
   }
}
