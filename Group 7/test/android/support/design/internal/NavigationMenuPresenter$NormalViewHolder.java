package android.support.design.internal;

import android.support.design.R$layout;
import android.support.design.internal.NavigationMenuPresenter$ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

class NavigationMenuPresenter$NormalViewHolder extends NavigationMenuPresenter$ViewHolder {
   public NavigationMenuPresenter$NormalViewHolder(LayoutInflater var1, ViewGroup var2, OnClickListener var3) {
      super(var1.inflate(R$layout.design_navigation_item, var2, false));
      this.itemView.setOnClickListener(var3);
   }
}
