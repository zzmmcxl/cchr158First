package android.support.v7.widget;

import android.graphics.PointF;
import android.content.Context;

class StaggeredGridLayoutManager$2 extends LinearSmoothScroller {
    final /* synthetic */ StaggeredGridLayoutManager this$0;
    
    StaggeredGridLayoutManager$2(final StaggeredGridLayoutManager this$0, final Context context) {
        this$0 = this$0;
        super(context);
    }
    
    @Override
    public PointF computeScrollVectorForPosition(final int n) {
        final int access$400 = StaggeredGridLayoutManager.access$400(this$0, n);
        if (access$400 == 0) {
            return null;
        }
        if (StaggeredGridLayoutManager.access$500(this$0) == 0) {
            return new PointF((float)access$400, 0.0f);
        }
        return new PointF(0.0f, (float)access$400);
    }
}