package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.appcompat.R$attr;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuPresenter$OverflowMenuButton$1;
import android.support.v7.widget.ActionMenuView$ActionMenuChildView;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

class ActionMenuPresenter$OverflowMenuButton extends AppCompatImageView implements ActionMenuView$ActionMenuChildView {
   private final float[] mTempPts;

   public ActionMenuPresenter$OverflowMenuButton(ActionMenuPresenter var1, Context var2) {
      super(var2, (AttributeSet)null, R$attr.actionOverflowButtonStyle);
      this.this$0 = var1;
      this.mTempPts = new float[2];
      this.setClickable(true);
      this.setFocusable(true);
      this.setVisibility(0);
      this.setEnabled(true);
      this.setOnTouchListener(new ActionMenuPresenter$OverflowMenuButton$1(this, this, var1));
   }

   public boolean needsDividerAfter() {
      return false;
   }

   public boolean needsDividerBefore() {
      return false;
   }

   public boolean performClick() {
      if(super.performClick()) {
         return true;
      } else {
         this.playSoundEffect(0);
         this.this$0.showOverflowMenu();
         return true;
      }
   }

   protected boolean setFrame(int var1, int var2, int var3, int var4) {
      boolean var8 = super.setFrame(var1, var2, var3, var4);
      Drawable var9 = this.getDrawable();
      Drawable var10 = this.getBackground();
      if(var9 != null && var10 != null) {
         int var5 = this.getWidth();
         var2 = this.getHeight();
         var1 = Math.max(var5, var2) / 2;
         int var6 = this.getPaddingLeft();
         int var7 = this.getPaddingRight();
         var3 = this.getPaddingTop();
         var4 = this.getPaddingBottom();
         var5 = (var5 + (var6 - var7)) / 2;
         var2 = (var2 + (var3 - var4)) / 2;
         DrawableCompat.setHotspotBounds(var10, var5 - var1, var2 - var1, var5 + var1, var2 + var1);
      }

      return var8;
   }
}
