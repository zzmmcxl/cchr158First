package android.support.design.widget;

import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;

class TextInputLayout$1 implements TextWatcher {
   TextInputLayout$1(TextInputLayout var1) {
      this.this$0 = var1;
   }

   public void afterTextChanged(Editable var1) {
      TextInputLayout.access$100(this.this$0, true);
      if(TextInputLayout.access$200(this.this$0)) {
         TextInputLayout.access$300(this.this$0, var1.length());
      }

   }

   public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
   }

   public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
   }
}
