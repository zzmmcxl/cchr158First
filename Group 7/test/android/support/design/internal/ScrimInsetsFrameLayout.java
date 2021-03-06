package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.support.design.R$style;
import android.support.design.R$styleable;
import android.support.design.internal.ScrimInsetsFrameLayout$1;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ScrimInsetsFrameLayout extends FrameLayout {
   private Drawable mInsetForeground;
   private Rect mInsets;
   private Rect mTempRect;

   public ScrimInsetsFrameLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public ScrimInsetsFrameLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public ScrimInsetsFrameLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mTempRect = new Rect();
      TypedArray var4 = var1.obtainStyledAttributes(var2, R$styleable.ScrimInsetsFrameLayout, var3, R$style.Widget_Design_ScrimInsetsFrameLayout);
      this.mInsetForeground = var4.getDrawable(R$styleable.ScrimInsetsFrameLayout_insetForeground);
      var4.recycle();
      this.setWillNotDraw(true);
      ViewCompat.setOnApplyWindowInsetsListener(this, new ScrimInsetsFrameLayout$1(this));
   }

   public void draw(@NonNull Canvas var1) {
      super.draw(var1);
      int var2 = this.getWidth();
      int var3 = this.getHeight();
      if(this.mInsets != null && this.mInsetForeground != null) {
         int var4 = var1.save();
         var1.translate((float)this.getScrollX(), (float)this.getScrollY());
         this.mTempRect.set(0, 0, var2, this.mInsets.top);
         this.mInsetForeground.setBounds(this.mTempRect);
         this.mInsetForeground.draw(var1);
         this.mTempRect.set(0, var3 - this.mInsets.bottom, var2, var3);
         this.mInsetForeground.setBounds(this.mTempRect);
         this.mInsetForeground.draw(var1);
         this.mTempRect.set(0, this.mInsets.top, this.mInsets.left, var3 - this.mInsets.bottom);
         this.mInsetForeground.setBounds(this.mTempRect);
         this.mInsetForeground.draw(var1);
         this.mTempRect.set(var2 - this.mInsets.right, this.mInsets.top, var2, var3 - this.mInsets.bottom);
         this.mInsetForeground.setBounds(this.mTempRect);
         this.mInsetForeground.draw(var1);
         var1.restoreToCount(var4);
      }

   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      if(this.mInsetForeground != null) {
         this.mInsetForeground.setCallback(this);
      }

   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if(this.mInsetForeground != null) {
         this.mInsetForeground.setCallback((Callback)null);
      }

   }

   protected void onInsetsChanged(Rect var1) {
   }
}
