package android.support.v4.widget;

import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v4.widget.TextViewCompat$JbMr2TextViewCompatImpl;
import android.support.v4.widget.TextViewCompatApi23;
import android.widget.TextView;

class TextViewCompat$Api23TextViewCompatImpl extends TextViewCompat$JbMr2TextViewCompatImpl {
   public void setTextAppearance(@NonNull TextView var1, @StyleRes int var2) {
      TextViewCompatApi23.setTextAppearance(var1, var2);
   }
}
