package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$OnItemTouchListener;
import android.view.MotionEvent;

public class RecyclerView$SimpleOnItemTouchListener implements RecyclerView$OnItemTouchListener {
   public boolean onInterceptTouchEvent(RecyclerView var1, MotionEvent var2) {
      return false;
   }

   public void onRequestDisallowInterceptTouchEvent(boolean var1) {
   }

   public void onTouchEvent(RecyclerView var1, MotionEvent var2) {
   }
}
