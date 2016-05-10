package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.TextViewCompatJbMr1;
import android.support.v4.widget.TextViewCompatJbMr2;
import android.widget.TextView;

public class TextViewCompat {
   static final TextViewCompat.TextViewCompatImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 18) {
         IMPL = new TextViewCompat.JbMr2TextViewCompatImpl();
      } else if(var0 >= 17) {
         IMPL = new TextViewCompat.JbMr1TextViewCompatImpl();
      } else {
         IMPL = new TextViewCompat.BaseTextViewCompatImpl();
      }
   }

   public static void setCompoundDrawablesRelative(@NonNull TextView var0, @Nullable Drawable var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4) {
      IMPL.setCompoundDrawablesRelative(var0, var1, var2, var3, var4);
   }

   public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var0, int var1, int var2, int var3, int var4) {
      IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(var0, var1, var2, var3, var4);
   }

   public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var0, @Nullable Drawable var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4) {
      IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(var0, var1, var2, var3, var4);
   }

   static class BaseTextViewCompatImpl implements TextViewCompat.TextViewCompatImpl {
      public void setCompoundDrawablesRelative(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5) {
         var1.setCompoundDrawables(var2, var3, var4, var5);
      }

      public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, int var2, int var3, int var4, int var5) {
         var1.setCompoundDrawablesWithIntrinsicBounds(var2, var3, var4, var5);
      }

      public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5) {
         var1.setCompoundDrawablesWithIntrinsicBounds(var2, var3, var4, var5);
      }
   }

   static class JbMr1TextViewCompatImpl extends TextViewCompat.BaseTextViewCompatImpl {
      public void setCompoundDrawablesRelative(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5) {
         TextViewCompatJbMr1.setCompoundDrawablesRelative(var1, var2, var3, var4, var5);
      }

      public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, int var2, int var3, int var4, int var5) {
         TextViewCompatJbMr1.setCompoundDrawablesRelativeWithIntrinsicBounds(var1, var2, var3, var4, var5);
      }

      public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5) {
         TextViewCompatJbMr1.setCompoundDrawablesRelativeWithIntrinsicBounds(var1, var2, var3, var4, var5);
      }
   }

   static class JbMr2TextViewCompatImpl extends TextViewCompat.JbMr1TextViewCompatImpl {
      public void setCompoundDrawablesRelative(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5) {
         TextViewCompatJbMr2.setCompoundDrawablesRelative(var1, var2, var3, var4, var5);
      }

      public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, int var2, int var3, int var4, int var5) {
         TextViewCompatJbMr2.setCompoundDrawablesRelativeWithIntrinsicBounds(var1, var2, var3, var4, var5);
      }

      public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5) {
         TextViewCompatJbMr2.setCompoundDrawablesRelativeWithIntrinsicBounds(var1, var2, var3, var4, var5);
      }
   }

   interface TextViewCompatImpl {
      void setCompoundDrawablesRelative(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5);

      void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, int var2, int var3, int var4, int var5);

      void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5);
   }
}
