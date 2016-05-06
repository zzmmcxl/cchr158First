package android.support.v7.widget.helper;

import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.graphics.Canvas;

static class Gingerbread implements ItemTouchUIUtil
{
    Gingerbread() {
        super();
    }
    
    private void draw(final Canvas canvas, final RecyclerView recyclerView, final View view, final float n, final float n2) {
        canvas.save();
        canvas.translate(n, n2);
        recyclerView.drawChild(canvas, view, 0L);
        canvas.restore();
    }
    
    @Override
    public void clearView(final View view) {
        view.setVisibility(0);
    }
    
    @Override
    public void onDraw(final Canvas canvas, final RecyclerView recyclerView, final View view, final float n, final float n2, final int n3, final boolean b) {
        if (n3 != 2) {
            this.draw(canvas, recyclerView, view, n, n2);
        }
    }
    
    @Override
    public void onDrawOver(final Canvas canvas, final RecyclerView recyclerView, final View view, final float n, final float n2, final int n3, final boolean b) {
        if (n3 == 2) {
            this.draw(canvas, recyclerView, view, n, n2);
        }
    }
    
    @Override
    public void onSelected(final View view) {
        view.setVisibility(4);
    }
}
