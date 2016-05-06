package android.support.v4.app;

import android.view.View;
import android.content.Context;
import android.widget.TabHost$TabContentFactory;

static class DummyTabFactory implements TabHost$TabContentFactory
{
    private final Context mContext;
    
    public DummyTabFactory(final Context mContext) {
        super();
        this.mContext = mContext;
    }
    
    public View createTabContent(final String s) {
        final View view = new View(mContext);
        view.setMinimumWidth(0);
        view.setMinimumHeight(0);
        return view;
    }
}
