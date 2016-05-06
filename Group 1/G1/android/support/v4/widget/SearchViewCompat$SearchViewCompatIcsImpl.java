package android.support.v4.widget;

import android.view.View;
import android.content.Context;

static class SearchViewCompatIcsImpl extends SearchViewCompatHoneycombImpl
{
    SearchViewCompatIcsImpl() {
        super();
    }
    
    @Override
    public View newSearchView(final Context context) {
        return SearchViewCompatIcs.newSearchView(context);
    }
    
    @Override
    public void setImeOptions(final View view, final int n) {
        SearchViewCompatIcs.setImeOptions(view, n);
    }
    
    @Override
    public void setInputType(final View view, final int n) {
        SearchViewCompatIcs.setInputType(view, n);
    }
}
