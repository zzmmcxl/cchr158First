package android.support.v4.view;

import android.view.View;
import android.content.Context;
import java.util.Locale;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.widget.TextView;

class PagerTitleStripIcs
{
    PagerTitleStripIcs() {
        super();
    }
    
    public static void setSingleLineAllCaps(final TextView textView) {
        textView.setTransformationMethod((TransformationMethod)new SingleLineAllCapsTransform(textView.getContext()));
    }
}
