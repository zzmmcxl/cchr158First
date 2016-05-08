package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class DrawerLayout$LayoutParams extends MarginLayoutParams {
   private static final int FLAG_IS_CLOSING = 4;
   private static final int FLAG_IS_OPENED = 1;
   private static final int FLAG_IS_OPENING = 2;
   public int gravity;
   private boolean isPeeking;
   private float onScreen;
   private int openState;

   public DrawerLayout$LayoutParams(int var1, int var2) {
      super(var1, var2);
      this.gravity = 0;
   }

   public DrawerLayout$LayoutParams(int var1, int var2, int var3) {
      this(var1, var2);
      this.gravity = var3;
   }

   public DrawerLayout$LayoutParams(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.gravity = 0;
      TypedArray var3 = var1.obtainStyledAttributes(var2, DrawerLayout.access$400());
      this.gravity = var3.getInt(0, 0);
      var3.recycle();
   }

   public DrawerLayout$LayoutParams(DrawerLayout$LayoutParams var1) {
      super(var1);
      this.gravity = 0;
      this.gravity = var1.gravity;
   }

   public DrawerLayout$LayoutParams(LayoutParams var1) {
      super(var1);
      this.gravity = 0;
   }

   public DrawerLayout$LayoutParams(MarginLayoutParams var1) {
      super(var1);
      this.gravity = 0;
   }
}
