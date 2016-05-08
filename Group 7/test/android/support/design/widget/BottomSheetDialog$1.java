package android.support.design.widget;

import android.support.design.widget.BottomSheetDialog;
import android.view.View;
import android.view.View.OnClickListener;

class BottomSheetDialog$1 implements OnClickListener {
   BottomSheetDialog$1(BottomSheetDialog var1) {
      this.this$0 = var1;
   }

   public void onClick(View var1) {
      if(this.this$0.isShowing()) {
         this.this$0.cancel();
      }

   }
}
