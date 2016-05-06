package android.support.design.widget;

import android.content.res.TypedArray;
import android.content.Context;
import android.support.design.R;

class ThemeUtils
{
    private static final int[] APPCOMPAT_CHECK_ATTRS;
    
    static {
        APPCOMPAT_CHECK_ATTRS = new int[] { R.attr.colorPrimary };
    }
    
    ThemeUtils() {
        super();
    }
    
    static void checkAppCompatTheme(final Context context) {
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(APPCOMPAT_CHECK_ATTRS);
        final boolean hasValue = obtainStyledAttributes.hasValue(0);
        boolean b = false;
        if (!hasValue) {
            b = true;
        }
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        if (b) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
