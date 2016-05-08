package android.support.v4.view;

import android.support.v4.view.PagerTitleStripIcs$SingleLineAllCapsTransform;
import android.widget.TextView;

class PagerTitleStripIcs {
   public static void setSingleLineAllCaps(TextView var0) {
      var0.setTransformationMethod(new PagerTitleStripIcs$SingleLineAllCapsTransform(var0.getContext()));
   }
}
