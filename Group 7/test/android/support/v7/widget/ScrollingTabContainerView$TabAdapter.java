package android.support.v7.widget;

import android.support.v7.app.ActionBar$Tab;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.ScrollingTabContainerView$TabView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class ScrollingTabContainerView$TabAdapter extends BaseAdapter {
   private ScrollingTabContainerView$TabAdapter(ScrollingTabContainerView var1) {
      this.this$0 = var1;
   }

   public int getCount() {
      return ScrollingTabContainerView.access$200(this.this$0).getChildCount();
   }

   public Object getItem(int var1) {
      return ((ScrollingTabContainerView$TabView)ScrollingTabContainerView.access$200(this.this$0).getChildAt(var1)).getTab();
   }

   public long getItemId(int var1) {
      return (long)var1;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      if(var2 == null) {
         return ScrollingTabContainerView.access$300(this.this$0, (ActionBar$Tab)this.getItem(var1), true);
      } else {
         ((ScrollingTabContainerView$TabView)var2).bindTab((ActionBar$Tab)this.getItem(var1));
         return var2;
      }
   }
}
