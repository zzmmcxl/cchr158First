package android.support.design.widget;

import android.support.design.widget.TextInputLayout;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

class TextInputLayout$TextInputAccessibilityDelegate extends AccessibilityDelegateCompat {
   private TextInputLayout$TextInputAccessibilityDelegate(TextInputLayout var1) {
      this.this$0 = var1;
   }

   public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
      super.onInitializeAccessibilityEvent(var1, var2);
      var2.setClassName(TextInputLayout.class.getSimpleName());
   }

   public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
      super.onInitializeAccessibilityNodeInfo(var1, var2);
      var2.setClassName(TextInputLayout.class.getSimpleName());
      CharSequence var3 = TextInputLayout.access$500(this.this$0).getText();
      if(!TextUtils.isEmpty(var3)) {
         var2.setText(var3);
      }

      if(TextInputLayout.access$600(this.this$0) != null) {
         var2.setLabelFor(TextInputLayout.access$600(this.this$0));
      }

      if(TextInputLayout.access$400(this.this$0) != null) {
         var3 = TextInputLayout.access$400(this.this$0).getText();
      } else {
         var3 = null;
      }

      if(!TextUtils.isEmpty(var3)) {
         var2.setContentInvalid(true);
         var2.setError(var3);
      }

   }

   public void onPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
      super.onPopulateAccessibilityEvent(var1, var2);
      CharSequence var3 = TextInputLayout.access$500(this.this$0).getText();
      if(!TextUtils.isEmpty(var3)) {
         var2.getText().add(var3);
      }

   }
}
