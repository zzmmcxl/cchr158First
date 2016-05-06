package android.support.design.widget;

import android.view.View;
import java.util.Comparator;

class CoordinatorLayout$1 implements Comparator<View> {
    final /* synthetic */ CoordinatorLayout this$0;
    
    CoordinatorLayout$1(final CoordinatorLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public int compare(final View view, final View view2) {
        if (view == view2) {
            return 0;
        }
        if (((LayoutParams)view.getLayoutParams()).dependsOn(this$0, view, view2)) {
            return 1;
        }
        if (((LayoutParams)view2.getLayoutParams()).dependsOn(this$0, view2, view)) {
            return -1;
        }
        return 0;
    }
    
    @Override
    public /* bridge */ int compare(final Object o, final Object o2) {
        return this.compare((View)o, (View)o2);
    }
}