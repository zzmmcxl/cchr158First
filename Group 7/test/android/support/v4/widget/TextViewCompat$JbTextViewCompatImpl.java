package android.support.v4.widget;

import android.support.v4.widget.TextViewCompat$BaseTextViewCompatImpl;
import android.support.v4.widget.TextViewCompatJb;
import android.widget.TextView;

class TextViewCompat$JbTextViewCompatImpl extends TextViewCompat$BaseTextViewCompatImpl {
   public int getMaxLines(TextView var1) {
      return TextViewCompatJb.getMaxLines(var1);
   }

   public int getMinLines(TextView var1) {
      return TextViewCompatJb.getMinLines(var1);
   }
}
