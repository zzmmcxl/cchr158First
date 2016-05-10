package android.support.v7.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

public class AppCompatCheckedTextView extends CheckedTextView {
   private static final int[] TINT_ATTRS = new int[]{16843016};
   private TintManager mTintManager;

   public AppCompatCheckedTextView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public AppCompatCheckedTextView(Context var1, AttributeSet var2) {
      this(var1, var2, 16843720);
   }

   public AppCompatCheckedTextView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      if(TintManager.SHOULD_BE_USED) {
         TintTypedArray var4 = TintTypedArray.obtainStyledAttributes(this.getContext(), var2, TINT_ATTRS, var3, 0);
         this.setCheckMarkDrawable(var4.getDrawable(0));
         var4.recycle();
         this.mTintManager = var4.getTintManager();
      }

   }

   public void setCheckMarkDrawable(@DrawableRes int var1) {
      if(this.mTintManager != null) {
         this.setCheckMarkDrawable(this.mTintManager.getDrawable(var1));
      } else {
         super.setCheckMarkDrawable(var1);
      }
   }
}
