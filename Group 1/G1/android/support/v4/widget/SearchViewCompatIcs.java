package android.support.v4.widget;

import android.widget.SearchView;
import android.view.View;
import android.content.Context;

class SearchViewCompatIcs
{
    SearchViewCompatIcs() {
        super();
    }
    
    public static View newSearchView(final Context context) {
        return (View)new MySearchView(context);
    }
    
    public static void setImeOptions(final View view, final int imeOptions) {
        ((SearchView)view).setImeOptions(imeOptions);
    }
    
    public static void setInputType(final View view, final int inputType) {
        ((SearchView)view).setInputType(inputType);
    }
}
