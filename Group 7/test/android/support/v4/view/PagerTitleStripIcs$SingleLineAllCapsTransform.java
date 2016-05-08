package android.support.v4.view;

import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import java.util.Locale;

class PagerTitleStripIcs$SingleLineAllCapsTransform extends SingleLineTransformationMethod {
   private static final String TAG = "SingleLineAllCapsTransform";
   private Locale mLocale;

   public PagerTitleStripIcs$SingleLineAllCapsTransform(Context var1) {
      this.mLocale = var1.getResources().getConfiguration().locale;
   }

   public CharSequence getTransformation(CharSequence var1, View var2) {
      var1 = super.getTransformation(var1, var2);
      return var1 != null?var1.toString().toUpperCase(this.mLocale):null;
   }
}
