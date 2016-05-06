package android.support.design.internal;

import android.support.design.R;
import android.view.ViewGroup;
import android.view.LayoutInflater;

private static class SeparatorViewHolder extends ViewHolder
{
    public SeparatorViewHolder(final LayoutInflater layoutInflater, final ViewGroup viewGroup) {
        super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
    }
}
