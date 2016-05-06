package android.support.design.internal;

import android.support.design.R;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import android.view.LayoutInflater;

private static class NormalViewHolder extends ViewHolder
{
    public NormalViewHolder(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final View$OnClickListener onClickListener) {
        super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
        this.itemView.setOnClickListener(onClickListener);
    }
}
