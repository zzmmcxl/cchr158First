package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

public interface RecyclerView$OnItemTouchListener {
   boolean onInterceptTouchEvent(RecyclerView var1, MotionEvent var2);

   void onRequestDisallowInterceptTouchEvent(boolean var1);

   void onTouchEvent(RecyclerView var1, MotionEvent var2);
}
