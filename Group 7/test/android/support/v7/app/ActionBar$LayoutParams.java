package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v7.appcompat.R$styleable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class ActionBar$LayoutParams extends MarginLayoutParams {
   public int gravity;

   public ActionBar$LayoutParams(int var1) {
      this(-2, -1, var1);
   }

   public ActionBar$LayoutParams(int var1, int var2) {
      super(var1, var2);
      this.gravity = 0;
      this.gravity = 8388627;
   }

   public ActionBar$LayoutParams(int var1, int var2, int var3) {
      super(var1, var2);
      this.gravity = 0;
      this.gravity = var3;
   }

   public ActionBar$LayoutParams(@NonNull Context var1, AttributeSet var2) {
      super(var1, var2);
      this.gravity = 0;
      TypedArray var3 = var1.obtainStyledAttributes(var2, R$styleable.ActionBarLayout);
      this.gravity = var3.getInt(R$styleable.ActionBarLayout_android_layout_gravity, 0);
      var3.recycle();
   }

   public ActionBar$LayoutParams(ActionBar$LayoutParams var1) {
      super(var1);
      this.gravity = 0;
      this.gravity = var1.gravity;
   }

   public ActionBar$LayoutParams(LayoutParams var1) {
      super(var1);
      this.gravity = 0;
   }
}
