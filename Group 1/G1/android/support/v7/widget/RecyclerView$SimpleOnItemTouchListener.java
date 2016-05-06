package android.support.v7.widget;

import android.view.MotionEvent;

public static class SimpleOnItemTouchListener implements OnItemTouchListener
{
    public SimpleOnItemTouchListener() {
        super();
    }
    
    @Override
    public boolean onInterceptTouchEvent(final RecyclerView recyclerView, final MotionEvent motionEvent) {
        return false;
    }
    
    @Override
    public void onRequestDisallowInterceptTouchEvent(final boolean b) {
    }
    
    @Override
    public void onTouchEvent(final RecyclerView recyclerView, final MotionEvent motionEvent) {
    }
}
