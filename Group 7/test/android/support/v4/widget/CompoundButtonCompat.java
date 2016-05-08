package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.CompoundButtonCompat$Api23CompoundButtonImpl;
import android.support.v4.widget.CompoundButtonCompat$BaseCompoundButtonCompat;
import android.support.v4.widget.CompoundButtonCompat$CompoundButtonCompatImpl;
import android.support.v4.widget.CompoundButtonCompat$LollipopCompoundButtonImpl;
import android.widget.CompoundButton;

public final class CompoundButtonCompat {
   private static final CompoundButtonCompat$CompoundButtonCompatImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 23) {
         IMPL = new CompoundButtonCompat$Api23CompoundButtonImpl();
      } else if(var0 >= 21) {
         IMPL = new CompoundButtonCompat$LollipopCompoundButtonImpl();
      } else {
         IMPL = new CompoundButtonCompat$BaseCompoundButtonCompat();
      }
   }

   @Nullable
   public static Drawable getButtonDrawable(@NonNull CompoundButton var0) {
      return IMPL.getButtonDrawable(var0);
   }

   @Nullable
   public static ColorStateList getButtonTintList(@NonNull CompoundButton var0) {
      return IMPL.getButtonTintList(var0);
   }

   @Nullable
   public static Mode getButtonTintMode(@NonNull CompoundButton var0) {
      return IMPL.getButtonTintMode(var0);
   }

   public static void setButtonTintList(@NonNull CompoundButton var0, @Nullable ColorStateList var1) {
      IMPL.setButtonTintList(var0, var1);
   }

   public static void setButtonTintMode(@NonNull CompoundButton var0, @Nullable Mode var1) {
      IMPL.setButtonTintMode(var0, var1);
   }
}
