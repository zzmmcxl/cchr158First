package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

interface CompoundButtonCompat$CompoundButtonCompatImpl {
   Drawable getButtonDrawable(CompoundButton var1);

   ColorStateList getButtonTintList(CompoundButton var1);

   Mode getButtonTintMode(CompoundButton var1);

   void setButtonTintList(CompoundButton var1, ColorStateList var2);

   void setButtonTintMode(CompoundButton var1, Mode var2);
}
