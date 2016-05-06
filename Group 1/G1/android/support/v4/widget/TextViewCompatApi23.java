package android.support.v4.widget;

import android.support.annotation.StyleRes;
import android.support.annotation.NonNull;
import android.widget.TextView;

class TextViewCompatApi23
{
    TextViewCompatApi23() {
        super();
    }
    
    public static void setTextAppearance(@NonNull final TextView textView, @StyleRes final int textAppearance) {
        textView.setTextAppearance(textAppearance);
    }
}
