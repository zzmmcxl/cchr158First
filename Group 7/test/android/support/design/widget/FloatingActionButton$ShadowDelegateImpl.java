package android.support.design.widget;

import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.ShadowViewDelegate;

class FloatingActionButton$ShadowDelegateImpl implements ShadowViewDelegate {
   private FloatingActionButton$ShadowDelegateImpl(FloatingActionButton var1) {
      this.this$0 = var1;
   }

   public float getRadius() {
      return (float)this.this$0.getSizeDimension() / 2.0F;
   }

   public boolean isCompatPaddingEnabled() {
      return FloatingActionButton.access$600(this.this$0);
   }

   public void setBackgroundDrawable(Drawable var1) {
      FloatingActionButton.access$501(this.this$0, var1);
   }

   public void setShadowPadding(int var1, int var2, int var3, int var4) {
      FloatingActionButton.access$200(this.this$0).set(var1, var2, var3, var4);
      this.this$0.setPadding(FloatingActionButton.access$400(this.this$0) + var1, FloatingActionButton.access$400(this.this$0) + var2, FloatingActionButton.access$400(this.this$0) + var3, FloatingActionButton.access$400(this.this$0) + var4);
   }
}
