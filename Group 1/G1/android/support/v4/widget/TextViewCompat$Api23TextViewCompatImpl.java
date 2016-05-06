package android.support.v4.widget;

import android.support.annotation.StyleRes;
import android.support.annotation.NonNull;
import android.widget.TextView;

static class Api23TextViewCompatImpl extends JbMr2TextViewCompatImpl
{
    Api23TextViewCompatImpl() {
        super();
    }
    
    @Override
    public void setTextAppearance(@NonNull final TextView textView, @StyleRes final int n) {
        TextViewCompatApi23.setTextAppearance(textView, n);
    }
}
