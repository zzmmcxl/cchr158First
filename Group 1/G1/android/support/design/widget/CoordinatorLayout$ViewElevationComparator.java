package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;
import java.util.Comparator;

static class ViewElevationComparator implements Comparator<View>
{
    ViewElevationComparator() {
        super();
    }
    
    @Override
    public int compare(final View view, final View view2) {
        final float z = ViewCompat.getZ(view);
        final float z2 = ViewCompat.getZ(view2);
        if (z > z2) {
            return -1;
        }
        if (z < z2) {
            return 1;
        }
        return 0;
    }
    
    @Override
    public /* bridge */ int compare(final Object o, final Object o2) {
        return this.compare((View)o, (View)o2);
    }
}
