package android.support.v7.view.menu;

import android.view.ViewGroup;
import android.view.View;
import java.util.ArrayList;
import android.widget.BaseAdapter;

private class MenuAdapter extends BaseAdapter
{
    private int mExpandedIndex;
    final /* synthetic */ ListMenuPresenter this$0;
    
    public MenuAdapter(final ListMenuPresenter this$0) {
        this$0 = this$0;
        super();
        mExpandedIndex = -1;
        this.findExpandedIndex();
    }
    
    void findExpandedIndex() {
        final MenuItemImpl expandedItem = mMenu.getExpandedItem();
        if (expandedItem != null) {
            final ArrayList<MenuItemImpl> nonActionItems = mMenu.getNonActionItems();
            for (int size = nonActionItems.size(), i = 0; i < size; ++i) {
                if (nonActionItems.get(i) == expandedItem) {
                    mExpandedIndex = i;
                    return;
                }
            }
        }
        mExpandedIndex = -1;
    }
    
    public int getCount() {
        final int n = mMenu.getNonActionItems().size() - ListMenuPresenter.access$000(this$0);
        if (mExpandedIndex < 0) {
            return n;
        }
        return n - 1;
    }
    
    public MenuItemImpl getItem(final int n) {
        final ArrayList<MenuItemImpl> nonActionItems = mMenu.getNonActionItems();
        int n2 = n + ListMenuPresenter.access$000(this$0);
        if (mExpandedIndex >= 0 && n2 >= mExpandedIndex) {
            ++n2;
        }
        return nonActionItems.get(n2);
    }
    
    public /* bridge */ Object getItem(final int n) {
        return this.getItem(n);
    }
    
    public long getItemId(final int n) {
        return n;
    }
    
    public View getView(final int n, View inflate, final ViewGroup viewGroup) {
        if (inflate == null) {
            inflate = mInflater.inflate(mItemLayoutRes, viewGroup, false);
        }
        ((MenuView.ItemView)inflate).initialize(this.getItem(n), 0);
        return inflate;
    }
    
    public void notifyDataSetChanged() {
        this.findExpandedIndex();
        super.notifyDataSetChanged();
    }
}
