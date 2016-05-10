package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R;
import android.support.v7.internal.text.AllCapsTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

public class AppCompatTextView extends TextView {
   public AppCompatTextView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public AppCompatTextView(Context var1, AttributeSet var2) {
      this(var1, var2, 16842884);
   }

   public AppCompatTextView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      TypedArray var5 = var1.obtainStyledAttributes(var2, R.styleable.AppCompatTextView, var3, 0);
      int var4 = var5.getResourceId(R.styleable.AppCompatTextView_android_textAppearance, -1);
      var5.recycle();
      if(var4 != -1) {
         var5 = var1.obtainStyledAttributes(var4, R.styleable.TextAppearance);
         if(var5.hasValue(R.styleable.TextAppearance_textAllCaps)) {
            this.setAllCaps(var5.getBoolean(R.styleable.TextAppearance_textAllCaps, false));
         }

         var5.recycle();
      }

      TypedArray var6 = var1.obtainStyledAttributes(var2, R.styleable.AppCompatTextView, var3, 0);
      if(var6.hasValue(R.styleable.AppCompatTextView_textAllCaps)) {
         this.setAllCaps(var6.getBoolean(R.styleable.AppCompatTextView_textAllCaps, false));
      }

      var6.recycle();
   }

   public void setAllCaps(boolean var1) {
      AllCapsTransformationMethod var2;
      if(var1) {
         var2 = new AllCapsTransformationMethod(this.getContext());
      } else {
         var2 = null;
      }

      this.setTransformationMethod(var2);
   }

   public void setTextAppearance(Context var1, int var2) {
      super.setTextAppearance(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, R.styleable.TextAppearance);
      if(var3.hasValue(R.styleable.TextAppearance_textAllCaps)) {
         this.setAllCaps(var3.getBoolean(R.styleable.TextAppearance_textAllCaps, false));
      }

      var3.recycle();
   }
}
