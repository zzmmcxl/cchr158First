package android.support.v7.widget;

import android.view.View;

public static class ItemHolderInfo
{
    public int bottom;
    public int changeFlags;
    public int left;
    public int right;
    public int top;
    
    public ItemHolderInfo() {
        super();
    }
    
    public ItemHolderInfo setFrom(final ViewHolder viewHolder) {
        return this.setFrom(viewHolder, 0);
    }
    
    public ItemHolderInfo setFrom(final ViewHolder viewHolder, final int n) {
        final View itemView = viewHolder.itemView;
        left = itemView.getLeft();
        top = itemView.getTop();
        right = itemView.getRight();
        bottom = itemView.getBottom();
        return this;
    }
}
