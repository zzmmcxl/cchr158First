package android.support.v4.widget;

import android.widget.ListView;

class ListViewCompatKitKat
{
    ListViewCompatKitKat() {
        super();
    }
    
    static void scrollListBy(final ListView listView, final int n) {
        listView.scrollListBy(n);
    }
}
