package android.support.v4.content.res;

import android.content.res.Resources$NotFoundException;
import android.graphics.drawable.Drawable;
import android.content.res.Resources;

class ResourcesCompatIcsMr1
{
    ResourcesCompatIcsMr1() {
        super();
    }
    
    public static Drawable getDrawableForDensity(final Resources resources, final int n, final int n2) throws Resources$NotFoundException {
        return resources.getDrawableForDensity(n, n2);
    }
}
