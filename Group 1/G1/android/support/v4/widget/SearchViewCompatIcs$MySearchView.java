package android.support.v4.widget;

import android.content.Context;
import android.widget.SearchView;

public static class MySearchView extends SearchView
{
    public MySearchView(final Context context) {
        super(context);
    }
    
    public void onActionViewCollapsed() {
        this.setQuery((CharSequence)"", false);
        super.onActionViewCollapsed();
    }
}
