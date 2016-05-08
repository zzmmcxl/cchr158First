package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.support.v4.widget.CompoundButtonCompat$BaseCompoundButtonCompat;
import android.support.v4.widget.CompoundButtonCompatLollipop;
import android.widget.CompoundButton;

class CompoundButtonCompat$LollipopCompoundButtonImpl extends CompoundButtonCompat$BaseCompoundButtonCompat {
   public ColorStateList getButtonTintList(CompoundButton var1) {
      return CompoundButtonCompatLollipop.getButtonTintList(var1);
   }

   public Mode getButtonTintMode(CompoundButton var1) {
      return CompoundButtonCompatLollipop.getButtonTintMode(var1);
   }

   public void setButtonTintList(CompoundButton var1, ColorStateList var2) {
      CompoundButtonCompatLollipop.setButtonTintList(var1, var2);
   }

   public void setButtonTintMode(CompoundButton var1, Mode var2) {
      CompoundButtonCompatLollipop.setButtonTintMode(var1, var2);
   }
}
