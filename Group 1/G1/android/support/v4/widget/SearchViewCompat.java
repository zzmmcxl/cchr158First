package android.support.v4.widget;

import android.content.ComponentName;
import android.view.View;
import android.content.Context;
import android.os.Build$VERSION;

public final class SearchViewCompat
{
    private static final SearchViewCompatImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 14) {
            IMPL = (SearchViewCompatImpl)new SearchViewCompatIcsImpl();
            return;
        }
        if (Build$VERSION.SDK_INT >= 11) {
            IMPL = (SearchViewCompatImpl)new SearchViewCompatHoneycombImpl();
            return;
        }
        IMPL = (SearchViewCompatImpl)new SearchViewCompatStubImpl();
    }
    
    private SearchViewCompat(final Context context) {
        super();
    }
    
    static /* synthetic */ SearchViewCompatImpl access$000() {
        return IMPL;
    }
    
    public static CharSequence getQuery(final View view) {
        return IMPL.getQuery(view);
    }
    
    public static boolean isIconified(final View view) {
        return IMPL.isIconified(view);
    }
    
    public static boolean isQueryRefinementEnabled(final View view) {
        return IMPL.isQueryRefinementEnabled(view);
    }
    
    public static boolean isSubmitButtonEnabled(final View view) {
        return IMPL.isSubmitButtonEnabled(view);
    }
    
    public static View newSearchView(final Context context) {
        return IMPL.newSearchView(context);
    }
    
    public static void setIconified(final View view, final boolean b) {
        IMPL.setIconified(view, b);
    }
    
    public static void setImeOptions(final View view, final int n) {
        IMPL.setImeOptions(view, n);
    }
    
    public static void setInputType(final View view, final int n) {
        IMPL.setInputType(view, n);
    }
    
    public static void setMaxWidth(final View view, final int n) {
        IMPL.setMaxWidth(view, n);
    }
    
    public static void setOnCloseListener(final View view, final OnCloseListenerCompat onCloseListenerCompat) {
        IMPL.setOnCloseListener(view, onCloseListenerCompat.mListener);
    }
    
    public static void setOnQueryTextListener(final View view, final OnQueryTextListenerCompat onQueryTextListenerCompat) {
        IMPL.setOnQueryTextListener(view, onQueryTextListenerCompat.mListener);
    }
    
    public static void setQuery(final View view, final CharSequence charSequence, final boolean b) {
        IMPL.setQuery(view, charSequence, b);
    }
    
    public static void setQueryHint(final View view, final CharSequence charSequence) {
        IMPL.setQueryHint(view, charSequence);
    }
    
    public static void setQueryRefinementEnabled(final View view, final boolean b) {
        IMPL.setQueryRefinementEnabled(view, b);
    }
    
    public static void setSearchableInfo(final View view, final ComponentName componentName) {
        IMPL.setSearchableInfo(view, componentName);
    }
    
    public static void setSubmitButtonEnabled(final View view, final boolean b) {
        IMPL.setSubmitButtonEnabled(view, b);
    }
}
