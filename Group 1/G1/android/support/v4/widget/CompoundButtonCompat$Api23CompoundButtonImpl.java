package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

static class Api23CompoundButtonImpl extends LollipopCompoundButtonImpl
{
    Api23CompoundButtonImpl() {
        super();
    }
    
    @Override
    public Drawable getButtonDrawable(final CompoundButton compoundButton) {
        return CompoundButtonCompatApi23.getButtonDrawable(compoundButton);
    }
}
