package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;

public interface DrawableWrapper {
   Drawable getWrappedDrawable();

   void setTint(int var1);

   void setTintList(ColorStateList var1);

   void setTintMode(Mode var1);

   void setWrappedDrawable(Drawable var1);
}
