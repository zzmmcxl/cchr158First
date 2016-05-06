package android.support.v7.widget;

import android.support.v7.app.ActionBar;
import android.view.ViewGroup;
import android.view.View;
import android.widget.BaseAdapter;

private class TabAdapter extends BaseAdapter
{
    final /* synthetic */ ScrollingTabContainerView this$0;
    
    private TabAdapter(final ScrollingTabContainerView this$0) {
        this$0 = this$0;
        super();
    }
    
    TabAdapter(final ScrollingTabContainerView scrollingTabContainerView, final ScrollingTabContainerView$1 runnable) {
        this(scrollingTabContainerView);
    }
    
    public int getCount() {
        return ScrollingTabContainerView.access$200(this$0).getChildCount();
    }
    
    public Object getItem(final int n) {
        return ((TabView)ScrollingTabContainerView.access$200(this$0).getChildAt(n)).getTab();
    }
    
    public long getItemId(final int n) {
        return n;
    }
    
    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        if (view == null) {
            return (View)ScrollingTabContainerView.access$300(this$0, (ActionBar.Tab)this.getItem(n), true);
        }
        ((TabView)view).bindTab((ActionBar.Tab)this.getItem(n));
        return view;
    }
}
