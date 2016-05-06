package android.support.v7.widget;

import android.util.Log;
import android.support.v4.view.ViewCompat;
import java.util.ArrayList;
import java.util.Collections;
import android.view.View;
import java.util.List;

private class ItemAnimatorRestoreListener implements ItemAnimatorListener
{
    final /* synthetic */ RecyclerView this$0;
    
    private ItemAnimatorRestoreListener(final RecyclerView this$0) {
        this$0 = this$0;
        super();
    }
    
    ItemAnimatorRestoreListener(final RecyclerView recyclerView, final RecyclerView$1 runnable) {
        this(recyclerView);
    }
    
    @Override
    public void onAnimationFinished(final ViewHolder viewHolder) {
        viewHolder.setIsRecyclable(true);
        if (viewHolder.mShadowedHolder != null && viewHolder.mShadowingHolder == null) {
            viewHolder.mShadowedHolder = null;
        }
        viewHolder.mShadowingHolder = null;
        if (!viewHolder.shouldBeKeptAsChild() && !RecyclerView.access$6400(this$0, viewHolder.itemView) && viewHolder.isTmpDetached()) {
            this$0.removeDetachedView(viewHolder.itemView, false);
        }
    }
}
