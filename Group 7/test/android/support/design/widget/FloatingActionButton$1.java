package android.support.design.widget;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.FloatingActionButton$OnVisibilityChangedListener;
import android.support.design.widget.FloatingActionButtonImpl$InternalVisibilityChangedListener;

class FloatingActionButton$1 implements FloatingActionButtonImpl$InternalVisibilityChangedListener {
   FloatingActionButton$1(FloatingActionButton var1, FloatingActionButton$OnVisibilityChangedListener var2) {
      this.this$0 = var1;
      this.val$listener = var2;
   }

   public void onHidden() {
      this.val$listener.onHidden(this.this$0);
   }

   public void onShown() {
      this.val$listener.onShown(this.this$0);
   }
}
