package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.v7.appcompat.R;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class AppCompatRadioButton extends RadioButton {
   private static final int[] TINT_ATTRS = new int[]{16843015};
   private Drawable mButtonDrawable;
   private TintManager mTintManager;

   public AppCompatRadioButton(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public AppCompatRadioButton(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.radioButtonStyle);
   }

   public AppCompatRadioButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      if(TintManager.SHOULD_BE_USED) {
         TintTypedArray var4 = TintTypedArray.obtainStyledAttributes(this.getContext(), var2, TINT_ATTRS, var3, 0);
         this.setButtonDrawable(var4.getDrawable(0));
         var4.recycle();
         this.mTintManager = var4.getTintManager();
      }

   }

   public int getCompoundPaddingLeft() {
      int var2 = super.getCompoundPaddingLeft();
      int var1 = var2;
      if(VERSION.SDK_INT < 17) {
         var1 = var2;
         if(this.mButtonDrawable != null) {
            var1 = var2 + this.mButtonDrawable.getIntrinsicWidth();
         }
      }

      return var1;
   }

   public void setButtonDrawable(@DrawableRes int var1) {
      if(this.mTintManager != null) {
         this.setButtonDrawable(this.mTintManager.getDrawable(var1));
      } else {
         super.setButtonDrawable(var1);
      }
   }

   public void setButtonDrawable(Drawable var1) {
      super.setButtonDrawable(var1);
      this.mButtonDrawable = var1;
   }
}
