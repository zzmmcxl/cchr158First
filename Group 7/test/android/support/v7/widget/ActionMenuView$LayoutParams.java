package android.support.v7.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat$LayoutParams;
import android.util.AttributeSet;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;

public class ActionMenuView$LayoutParams extends LinearLayoutCompat$LayoutParams {
   @ExportedProperty
   public int cellsUsed;
   @ExportedProperty
   public boolean expandable;
   boolean expanded;
   @ExportedProperty
   public int extraPixels;
   @ExportedProperty
   public boolean isOverflowButton;
   @ExportedProperty
   public boolean preventEdgeOffset;

   public ActionMenuView$LayoutParams(int var1, int var2) {
      super(var1, var2);
      this.isOverflowButton = false;
   }

   ActionMenuView$LayoutParams(int var1, int var2, boolean var3) {
      super(var1, var2);
      this.isOverflowButton = var3;
   }

   public ActionMenuView$LayoutParams(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public ActionMenuView$LayoutParams(ActionMenuView$LayoutParams var1) {
      super((LayoutParams)var1);
      this.isOverflowButton = var1.isOverflowButton;
   }

   public ActionMenuView$LayoutParams(LayoutParams var1) {
      super(var1);
   }
}
