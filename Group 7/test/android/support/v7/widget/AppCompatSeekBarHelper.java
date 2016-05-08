package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatProgressBarHelper;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.SeekBar;

class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {
   private static final int[] TINT_ATTRS = new int[]{16843074};
   private final SeekBar mView;

   AppCompatSeekBarHelper(SeekBar var1, AppCompatDrawableManager var2) {
      super(var1, var2);
      this.mView = var1;
   }

   void loadFromAttributes(AttributeSet var1, int var2) {
      super.loadFromAttributes(var1, var2);
      TintTypedArray var4 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), var1, TINT_ATTRS, var2, 0);
      Drawable var3 = var4.getDrawableIfKnown(0);
      if(var3 != null) {
         this.mView.setThumb(var3);
      }

      var4.recycle();
   }
}
