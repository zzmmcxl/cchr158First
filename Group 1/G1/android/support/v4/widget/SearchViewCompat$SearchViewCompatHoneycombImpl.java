package android.support.v4.widget;

import android.content.ComponentName;
import android.content.Context;
import android.view.View;

static class SearchViewCompatHoneycombImpl extends SearchViewCompatStubImpl
{
    SearchViewCompatHoneycombImpl() {
        super();
    }
    
    @Override
    public CharSequence getQuery(final View view) {
        return SearchViewCompatHoneycomb.getQuery(view);
    }
    
    @Override
    public boolean isIconified(final View view) {
        return SearchViewCompatHoneycomb.isIconified(view);
    }
    
    @Override
    public boolean isQueryRefinementEnabled(final View view) {
        return SearchViewCompatHoneycomb.isQueryRefinementEnabled(view);
    }
    
    @Override
    public boolean isSubmitButtonEnabled(final View view) {
        return SearchViewCompatHoneycomb.isSubmitButtonEnabled(view);
    }
    
    @Override
    public Object newOnCloseListener(final OnCloseListenerCompat onCloseListenerCompat) {
        return SearchViewCompatHoneycomb.newOnCloseListener((SearchViewCompatHoneycomb.OnCloseListenerCompatBridge)new SearchViewCompatHoneycomb.OnCloseListenerCompatBridge() {
            final /* synthetic */ SearchViewCompatHoneycombImpl this$0;
            final /* synthetic */ OnCloseListenerCompat val$listener;
            
            SearchViewCompat$SearchViewCompatHoneycombImpl$2() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public boolean onClose() {
                return onCloseListenerCompat.onClose();
            }
        });
    }
    
    @Override
    public Object newOnQueryTextListener(final OnQueryTextListenerCompat onQueryTextListenerCompat) {
        return SearchViewCompatHoneycomb.newOnQueryTextListener((SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge)new SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge() {
            final /* synthetic */ SearchViewCompatHoneycombImpl this$0;
            final /* synthetic */ OnQueryTextListenerCompat val$listener;
            
            SearchViewCompat$SearchViewCompatHoneycombImpl$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public boolean onQueryTextChange(final String s) {
                return onQueryTextListenerCompat.onQueryTextChange(s);
            }
            
            @Override
            public boolean onQueryTextSubmit(final String s) {
                return onQueryTextListenerCompat.onQueryTextSubmit(s);
            }
        });
    }
    
    @Override
    public View newSearchView(final Context context) {
        return SearchViewCompatHoneycomb.newSearchView(context);
    }
    
    @Override
    public void setIconified(final View view, final boolean b) {
        SearchViewCompatHoneycomb.setIconified(view, b);
    }
    
    @Override
    public void setMaxWidth(final View view, final int n) {
        SearchViewCompatHoneycomb.setMaxWidth(view, n);
    }
    
    @Override
    public void setOnCloseListener(final Object o, final Object o2) {
        SearchViewCompatHoneycomb.setOnCloseListener(o, o2);
    }
    
    @Override
    public void setOnQueryTextListener(final Object o, final Object o2) {
        SearchViewCompatHoneycomb.setOnQueryTextListener(o, o2);
    }
    
    @Override
    public void setQuery(final View view, final CharSequence charSequence, final boolean b) {
        SearchViewCompatHoneycomb.setQuery(view, charSequence, b);
    }
    
    @Override
    public void setQueryHint(final View view, final CharSequence charSequence) {
        SearchViewCompatHoneycomb.setQueryHint(view, charSequence);
    }
    
    @Override
    public void setQueryRefinementEnabled(final View view, final boolean b) {
        SearchViewCompatHoneycomb.setQueryRefinementEnabled(view, b);
    }
    
    @Override
    public void setSearchableInfo(final View view, final ComponentName componentName) {
        SearchViewCompatHoneycomb.setSearchableInfo(view, componentName);
    }
    
    @Override
    public void setSubmitButtonEnabled(final View view, final boolean b) {
        SearchViewCompatHoneycomb.setSubmitButtonEnabled(view, b);
    }
}
