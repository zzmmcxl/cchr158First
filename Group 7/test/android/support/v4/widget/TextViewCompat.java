package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.widget.TextViewCompat$Api23TextViewCompatImpl;
import android.support.v4.widget.TextViewCompat$BaseTextViewCompatImpl;
import android.support.v4.widget.TextViewCompat$JbMr1TextViewCompatImpl;
import android.support.v4.widget.TextViewCompat$JbMr2TextViewCompatImpl;
import android.support.v4.widget.TextViewCompat$JbTextViewCompatImpl;
import android.support.v4.widget.TextViewCompat$TextViewCompatImpl;
import android.widget.TextView;

public final class TextViewCompat {
   static final TextViewCompat$TextViewCompatImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 23) {
         IMPL = new TextViewCompat$Api23TextViewCompatImpl();
      } else if(var0 >= 18) {
         IMPL = new TextViewCompat$JbMr2TextViewCompatImpl();
      } else if(var0 >= 17) {
         IMPL = new TextViewCompat$JbMr1TextViewCompatImpl();
      } else if(var0 >= 16) {
         IMPL = new TextViewCompat$JbTextViewCompatImpl();
      } else {
         IMPL = new TextViewCompat$BaseTextViewCompatImpl();
      }
   }

   public static int getMaxLines(@NonNull TextView var0) {
      return IMPL.getMaxLines(var0);
   }

   public static int getMinLines(@NonNull TextView var0) {
      return IMPL.getMinLines(var0);
   }

   public static void setCompoundDrawablesRelative(@NonNull TextView var0, @Nullable Drawable var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4) {
      IMPL.setCompoundDrawablesRelative(var0, var1, var2, var3, var4);
   }

   public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var0, @DrawableRes int var1, @DrawableRes int var2, @DrawableRes int var3, @DrawableRes int var4) {
      IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(var0, var1, var2, var3, var4);
   }

   public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var0, @Nullable Drawable var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4) {
      IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(var0, var1, var2, var3, var4);
   }

   public static void setTextAppearance(@NonNull TextView var0, @StyleRes int var1) {
      IMPL.setTextAppearance(var0, var1);
   }
}
