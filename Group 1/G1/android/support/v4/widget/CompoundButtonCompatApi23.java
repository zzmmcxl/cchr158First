package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

class CompoundButtonCompatApi23
{
    CompoundButtonCompatApi23() {
        super();
    }
    
    static Drawable getButtonDrawable(final CompoundButton compoundButton) {
        return compoundButton.getButtonDrawable();
    }
}
