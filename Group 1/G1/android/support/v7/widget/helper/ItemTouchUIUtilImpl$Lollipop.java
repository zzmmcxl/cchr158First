package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.support.v7.recyclerview.R;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.support.v7.widget.RecyclerView;

static class Lollipop extends Honeycomb
{
    Lollipop() {
        super();
    }
    
    private float findMaxElevation(final RecyclerView recyclerView, final View view) {
        final int childCount = recyclerView.getChildCount();
        float n = 0.0f;
        for (int i = 0; i < childCount; ++i) {
            final View child = recyclerView.getChildAt(i);
            if (child != view) {
                final float elevation = ViewCompat.getElevation(child);
                if (elevation > n) {
                    n = elevation;
                }
            }
        }
        return n;
    }
    
    @Override
    public void clearView(final View view) {
        final Object tag = view.getTag(R.id.item_touch_helper_previous_elevation);
        if (tag != null && tag instanceof Float) {
            ViewCompat.setElevation(view, (float)tag);
        }
        view.setTag(R.id.item_touch_helper_previous_elevation, (Object)null);
        super.clearView(view);
    }
    
    @Override
    public void onDraw(final Canvas canvas, final RecyclerView recyclerView, final View view, final float n, final float n2, final int n3, final boolean b) {
        if (b && view.getTag(R.id.item_touch_helper_previous_elevation) == null) {
            final Float value = ViewCompat.getElevation(view);
            ViewCompat.setElevation(view, 1.0f + this.findMaxElevation(recyclerView, view));
            view.setTag(R.id.item_touch_helper_previous_elevation, (Object)value);
        }
        super.onDraw(canvas, recyclerView, view, n, n2, n3, b);
    }
}
