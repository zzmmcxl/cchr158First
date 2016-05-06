package android.support.v4.widget;

import android.widget.TextView;

static class JbTextViewCompatImpl extends BaseTextViewCompatImpl
{
    JbTextViewCompatImpl() {
        super();
    }
    
    @Override
    public int getMaxLines(final TextView textView) {
        return TextViewCompatJb.getMaxLines(textView);
    }
    
    @Override
    public int getMinLines(final TextView textView) {
        return TextViewCompatJb.getMinLines(textView);
    }
}
