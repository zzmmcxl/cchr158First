package android.support.v7.widget.helper;

import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.support.v7.widget.RecyclerView;

class ItemTouchHelper$2 implements OnItemTouchListener {
    final /* synthetic */ ItemTouchHelper this$0;
    
    ItemTouchHelper$2(final ItemTouchHelper this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public boolean onInterceptTouchEvent(final RecyclerView recyclerView, final MotionEvent motionEvent) {
        ItemTouchHelper.access$400(this$0).onTouchEvent(motionEvent);
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            this$0.mInitialTouchX = motionEvent.getX();
            this$0.mInitialTouchY = motionEvent.getY();
            ItemTouchHelper.access$500(this$0);
            if (mSelected == null) {
                final RecoverAnimation access$600 = ItemTouchHelper.access$600(this$0, motionEvent);
                if (access$600 != null) {
                    final ItemTouchHelper this$0 = this.this$0;
                    this$0.mInitialTouchX -= access$600.mX;
                    final ItemTouchHelper this$2 = this.this$0;
                    this$2.mInitialTouchY -= access$600.mY;
                    ItemTouchHelper.access$700(this.this$0, access$600.mViewHolder, true);
                    if (mPendingCleanup.remove(access$600.mViewHolder.itemView)) {
                        mCallback.clearView(ItemTouchHelper.access$300(this.this$0), access$600.mViewHolder);
                    }
                    ItemTouchHelper.access$800(this.this$0, access$600.mViewHolder, access$600.mActionState);
                    ItemTouchHelper.access$900(this.this$0, motionEvent, mSelectedFlags, 0);
                }
            }
        }
        else if (actionMasked == 3 || actionMasked == 1) {
            mActivePointerId = -1;
            ItemTouchHelper.access$800(this$0, null, 0);
        }
        else if (mActivePointerId != -1) {
            final int pointerIndex = MotionEventCompat.findPointerIndex(motionEvent, mActivePointerId);
            if (pointerIndex >= 0) {
                ItemTouchHelper.access$1000(this$0, actionMasked, motionEvent, pointerIndex);
            }
        }
        if (ItemTouchHelper.access$1100(this$0) != null) {
            ItemTouchHelper.access$1100(this$0).addMovement(motionEvent);
        }
        return mSelected != null;
    }
    
    @Override
    public void onRequestDisallowInterceptTouchEvent(final boolean b) {
        if (!b) {
            return;
        }
        ItemTouchHelper.access$800(this$0, null, 0);
    }
    
    @Override
    public void onTouchEvent(final RecyclerView recyclerView, final MotionEvent motionEvent) {
        ItemTouchHelper.access$400(this$0).onTouchEvent(motionEvent);
        if (ItemTouchHelper.access$1100(this$0) != null) {
            ItemTouchHelper.access$1100(this$0).addMovement(motionEvent);
        }
        if (mActivePointerId != -1) {
            final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            final int pointerIndex = MotionEventCompat.findPointerIndex(motionEvent, mActivePointerId);
            if (pointerIndex >= 0) {
                ItemTouchHelper.access$1000(this$0, actionMasked, motionEvent, pointerIndex);
            }
            final ViewHolder mSelected = this$0.mSelected;
            if (mSelected != null) {
                switch (actionMasked) {
                    default:
                    case 3:
                        if (ItemTouchHelper.access$1100(this$0) != null) {
                            ItemTouchHelper.access$1100(this$0).clear();
                        }
                    case 1:
                        ItemTouchHelper.access$800(this$0, null, 0);
                        mActivePointerId = -1;
                    case 2:
                        if (pointerIndex >= 0) {
                            ItemTouchHelper.access$900(this$0, motionEvent, mSelectedFlags, pointerIndex);
                            ItemTouchHelper.access$100(this$0, mSelected);
                            ItemTouchHelper.access$300(this$0).removeCallbacks(ItemTouchHelper.access$200(this$0));
                            ItemTouchHelper.access$200(this$0).run();
                            ItemTouchHelper.access$300(this$0).invalidate();
                            return;
                        }
                        break;
                    case 6: {
                        final int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == mActivePointerId) {
                            int n = 0;
                            if (actionIndex == 0) {
                                n = 1;
                            }
                            mActivePointerId = MotionEventCompat.getPointerId(motionEvent, n);
                            ItemTouchHelper.access$900(this$0, motionEvent, mSelectedFlags, actionIndex);
                            return;
                        }
                        break;
                    }
                }
            }
        }
    }
}