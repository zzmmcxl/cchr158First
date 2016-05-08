package android.support.v7.widget;

import android.support.v7.view.ActionMode;
import android.support.v7.widget.ActionBarContextView;
import android.view.View;
import android.view.View.OnClickListener;

class ActionBarContextView$1 implements OnClickListener {
   ActionBarContextView$1(ActionBarContextView var1, ActionMode var2) {
      this.this$0 = var1;
      this.val$mode = var2;
   }

   public void onClick(View var1) {
      this.val$mode.finish();
   }
}
