package android.support.v7.widget.helper;

import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.R;
import java.util.List;
import android.graphics.Canvas;
import android.os.Build$VERSION;
import android.view.animation.Interpolator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.GestureDetector$SimpleOnGestureListener;

private class ItemTouchHelperGestureListener extends GestureDetector$SimpleOnGestureListener
{
    final /* synthetic */ ItemTouchHelper this$0;
    
    private ItemTouchHelperGestureListener(final ItemTouchHelper this$0) {
        this$0 = this$0;
        super();
    }
    
    ItemTouchHelperGestureListener(final ItemTouchHelper itemTouchHelper, final ItemTouchHelper$1 runnable) {
        this(itemTouchHelper);
    }
    
    public boolean onDown(final MotionEvent motionEvent) {
        return true;
    }
    
    public void onLongPress(final MotionEvent motionEvent) {
        final View access$2400 = ItemTouchHelper.access$2400(this$0, motionEvent);
        if (access$2400 != null) {
            final RecyclerView.ViewHolder childViewHolder = ItemTouchHelper.access$300(this$0).getChildViewHolder(access$2400);
            if (childViewHolder != null && mCallback.hasDragFlag(ItemTouchHelper.access$300(this$0), childViewHolder) && MotionEventCompat.getPointerId(motionEvent, 0) == mActivePointerId) {
                final int pointerIndex = MotionEventCompat.findPointerIndex(motionEvent, mActivePointerId);
                final float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                final float y = MotionEventCompat.getY(motionEvent, pointerIndex);
                mInitialTouchX = x;
                mInitialTouchY = y;
                final ItemTouchHelper this$0 = this.this$0;
                mDy = 0.0f;
                mDx = 0.0f;
                if (mCallback.isLongPressDragEnabled()) {
                    ItemTouchHelper.access$800(this.this$0, childViewHolder, 2);
                }
            }
        }
    }
}
