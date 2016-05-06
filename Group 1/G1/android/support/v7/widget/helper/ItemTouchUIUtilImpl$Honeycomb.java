package android.support.v7.widget.helper;

import android.support.v7.widget.RecyclerView;
import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.view.View;

static class Honeycomb implements ItemTouchUIUtil
{
    Honeycomb() {
        super();
    }
    
    @Override
    public void clearView(final View view) {
        ViewCompat.setTranslationX(view, 0.0f);
        ViewCompat.setTranslationY(view, 0.0f);
    }
    
    @Override
    public void onDraw(final Canvas canvas, final RecyclerView recyclerView, final View view, final float n, final float n2, final int n3, final boolean b) {
        ViewCompat.setTranslationX(view, n);
        ViewCompat.setTranslationY(view, n2);
    }
    
    @Override
    public void onDrawOver(final Canvas canvas, final RecyclerView recyclerView, final View view, final float n, final float n2, final int n3, final boolean b) {
    }
    
    @Override
    public void onSelected(final View view) {
    }
}
