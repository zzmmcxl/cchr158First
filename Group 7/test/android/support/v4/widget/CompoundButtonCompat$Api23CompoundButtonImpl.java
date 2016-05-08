package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.widget.CompoundButtonCompat$LollipopCompoundButtonImpl;
import android.support.v4.widget.CompoundButtonCompatApi23;
import android.widget.CompoundButton;

class CompoundButtonCompat$Api23CompoundButtonImpl extends CompoundButtonCompat$LollipopCompoundButtonImpl {
   public Drawable getButtonDrawable(CompoundButton var1) {
      return CompoundButtonCompatApi23.getButtonDrawable(var1);
   }
}
