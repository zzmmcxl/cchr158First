package android.support.v7.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar$LayoutParams;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class Toolbar$LayoutParams extends ActionBar$LayoutParams {
   static final int CUSTOM = 0;
   static final int EXPANDED = 2;
   static final int SYSTEM = 1;
   int mViewType;

   public Toolbar$LayoutParams(int var1) {
      this(-2, -1, var1);
   }

   public Toolbar$LayoutParams(int var1, int var2) {
      super(var1, var2);
      this.mViewType = 0;
      this.gravity = 8388627;
   }

   public Toolbar$LayoutParams(int var1, int var2, int var3) {
      super(var1, var2);
      this.mViewType = 0;
      this.gravity = var3;
   }

   public Toolbar$LayoutParams(@NonNull Context var1, AttributeSet var2) {
      super(var1, var2);
      this.mViewType = 0;
   }

   public Toolbar$LayoutParams(ActionBar$LayoutParams var1) {
      super(var1);
      this.mViewType = 0;
   }

   public Toolbar$LayoutParams(Toolbar$LayoutParams var1) {
      super((ActionBar$LayoutParams)var1);
      this.mViewType = 0;
      this.mViewType = var1.mViewType;
   }

   public Toolbar$LayoutParams(LayoutParams var1) {
      super(var1);
      this.mViewType = 0;
   }

   public Toolbar$LayoutParams(MarginLayoutParams var1) {
      super((LayoutParams)var1);
      this.mViewType = 0;
      this.copyMarginsFromCompat(var1);
   }

   void copyMarginsFromCompat(MarginLayoutParams var1) {
      this.leftMargin = var1.leftMargin;
      this.topMargin = var1.topMargin;
      this.rightMargin = var1.rightMargin;
      this.bottomMargin = var1.bottomMargin;
   }
}
