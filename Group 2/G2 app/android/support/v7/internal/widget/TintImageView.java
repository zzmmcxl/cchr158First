package android.support.v7.internal.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

public class TintImageView extends ImageView {
   private static final int[] TINT_ATTRS = new int[]{16842964, 16843033};
   private final TintManager mTintManager;

   public TintImageView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public TintImageView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public TintImageView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      TintTypedArray var4 = TintTypedArray.obtainStyledAttributes(this.getContext(), var2, TINT_ATTRS, var3, 0);
      if(var4.length() > 0) {
         if(var4.hasValue(0)) {
            this.setBackgroundDrawable(var4.getDrawable(0));
         }

         if(var4.hasValue(1)) {
            this.setImageDrawable(var4.getDrawable(1));
         }
      }

      var4.recycle();
      this.mTintManager = var4.getTintManager();
   }

   public void setImageResource(@DrawableRes int var1) {
      this.setImageDrawable(this.mTintManager.getDrawable(var1));
   }
}
