package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.widget.TextView;

interface TextViewCompat$TextViewCompatImpl {
   int getMaxLines(TextView var1);

   int getMinLines(TextView var1);

   void setCompoundDrawablesRelative(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5);

   void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, @DrawableRes int var2, @DrawableRes int var3, @DrawableRes int var4, @DrawableRes int var5);

   void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5);

   void setTextAppearance(@NonNull TextView var1, @StyleRes int var2);
}
