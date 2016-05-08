package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.widget.TextViewCompat$TextViewCompatImpl;
import android.support.v4.widget.TextViewCompatDonut;
import android.widget.TextView;

class TextViewCompat$BaseTextViewCompatImpl implements TextViewCompat$TextViewCompatImpl {
   public int getMaxLines(TextView var1) {
      return TextViewCompatDonut.getMaxLines(var1);
   }

   public int getMinLines(TextView var1) {
      return TextViewCompatDonut.getMinLines(var1);
   }

   public void setCompoundDrawablesRelative(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5) {
      var1.setCompoundDrawables(var2, var3, var4, var5);
   }

   public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, @DrawableRes int var2, @DrawableRes int var3, @DrawableRes int var4, @DrawableRes int var5) {
      var1.setCompoundDrawablesWithIntrinsicBounds(var2, var3, var4, var5);
   }

   public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5) {
      var1.setCompoundDrawablesWithIntrinsicBounds(var2, var3, var4, var5);
   }

   public void setTextAppearance(TextView var1, @StyleRes int var2) {
      TextViewCompatDonut.setTextAppearance(var1, var2);
   }
}
