package android.support.v4.widget;

import android.widget.TextView;

class TextViewCompatJb
{
    TextViewCompatJb() {
        super();
    }
    
    static int getMaxLines(final TextView textView) {
        return textView.getMaxLines();
    }
    
    static int getMinLines(final TextView textView) {
        return textView.getMinLines();
    }
}
