package android.support.v7.view.menu;

import android.view.ViewGroup;
import android.view.View;
import java.util.ArrayList;
import android.widget.BaseAdapter;

private class MenuAdapter extends BaseAdapter
{
    private MenuBuilder mAdapterMenu;
    private int mExpandedIndex;
    final /* synthetic */ MenuPopupHelper this$0;
    
    public MenuAdapter(final MenuPopupHelper this$0, final MenuBuilder mAdapterMenu) {
        this$0 = this$0;
        super();
        mExpandedIndex = -1;
        mAdapterMenu = mAdapterMenu;
        this.findExpandedIndex();
    }
    
    static /* synthetic */ MenuBuilder access$000(final MenuAdapter menuAdapter) {
        return menuAdapter.mAdapterMenu;
    }
    
    void findExpandedIndex() {
        final MenuItemImpl expandedItem = MenuPopupHelper.access$300(this$0).getExpandedItem();
        if (expandedItem != null) {
            final ArrayList<MenuItemImpl> nonActionItems = MenuPopupHelper.access$300(this$0).getNonActionItems();
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
        ArrayList<MenuItemImpl> list;
        if (MenuPopupHelper.access$100(this$0)) {
            list = mAdapterMenu.getNonActionItems();
        }
        else {
            list = mAdapterMenu.getVisibleItems();
        }
        if (mExpandedIndex < 0) {
            return list.size();
        }
        return -1 + list.size();
    }
    
    public MenuItemImpl getItem(int n) {
        ArrayList<MenuItemImpl> list;
        if (MenuPopupHelper.access$100(this$0)) {
            list = mAdapterMenu.getNonActionItems();
        }
        else {
            list = mAdapterMenu.getVisibleItems();
        }
        if (mExpandedIndex >= 0 && n >= mExpandedIndex) {
            ++n;
        }
        return list.get(n);
    }
    
    public /* bridge */ Object getItem(final int n) {
        return this.getItem(n);
    }
    
    public long getItemId(final int n) {
        return n;
    }
    
    public View getView(final int n, View inflate, final ViewGroup viewGroup) {
        if (inflate == null) {
            inflate = MenuPopupHelper.access$200(this$0).inflate(ITEM_LAYOUT, viewGroup, false);
        }
        final MenuView.ItemView itemView = (MenuView.ItemView)inflate;
        if (mForceShowIcon) {
            ((ListMenuItemView)inflate).setForceShowIcon(true);
        }
        itemView.initialize(this.getItem(n), 0);
        return inflate;
    }
    
    public void notifyDataSetChanged() {
        this.findExpandedIndex();
        super.notifyDataSetChanged();
    }
}
