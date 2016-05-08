package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.CompoundButtonCompat$CompoundButtonCompatImpl;
import android.support.v4.widget.CompoundButtonCompatDonut;
import android.widget.CompoundButton;

class CompoundButtonCompat$BaseCompoundButtonCompat implements CompoundButtonCompat$CompoundButtonCompatImpl {
   public Drawable getButtonDrawable(CompoundButton var1) {
      return CompoundButtonCompatDonut.getButtonDrawable(var1);
   }

   public ColorStateList getButtonTintList(CompoundButton var1) {
      return CompoundButtonCompatDonut.getButtonTintList(var1);
   }

   public Mode getButtonTintMode(CompoundButton var1) {
      return CompoundButtonCompatDonut.getButtonTintMode(var1);
   }

   public void setButtonTintList(CompoundButton var1, ColorStateList var2) {
      CompoundButtonCompatDonut.setButtonTintList(var1, var2);
   }

   public void setButtonTintMode(CompoundButton var1, Mode var2) {
      CompoundButtonCompatDonut.setButtonTintMode(var1, var2);
   }
}
