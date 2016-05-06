package android.support.v4.view;

import java.util.Comparator;

static final class ViewPager$1 implements Comparator<ItemInfo> {
    ViewPager$1() {
        super();
    }
    
    @Override
    public int compare(final ItemInfo itemInfo, final ItemInfo itemInfo2) {
        return itemInfo.position - itemInfo2.position;
    }
    
    @Override
    public /* bridge */ int compare(final Object o, final Object o2) {
        return this.compare((ItemInfo)o, (ItemInfo)o2);
    }
}