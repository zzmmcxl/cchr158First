package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.TextViewCompat$JbMr1TextViewCompatImpl;
import android.support.v4.widget.TextViewCompatJbMr2;
import android.widget.TextView;

class TextViewCompat$JbMr2TextViewCompatImpl extends TextViewCompat$JbMr1TextViewCompatImpl {
   public void setCompoundDrawablesRelative(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5) {
      TextViewCompatJbMr2.setCompoundDrawablesRelative(var1, var2, var3, var4, var5);
   }

   public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, @DrawableRes int var2, @DrawableRes int var3, @DrawableRes int var4, @DrawableRes int var5) {
      TextViewCompatJbMr2.setCompoundDrawablesRelativeWithIntrinsicBounds(var1, var2, var3, var4, var5);
   }

   public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5) {
      TextViewCompatJbMr2.setCompoundDrawablesRelativeWithIntrinsicBounds(var1, var2, var3, var4, var5);
   }
}
