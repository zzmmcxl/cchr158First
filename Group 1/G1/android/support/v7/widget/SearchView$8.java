package android.support.v7.widget;

import android.widget.AutoCompleteTextView;
import android.view.inputmethod.InputMethodManager;
import android.view.KeyEvent$DispatcherState;
import android.graphics.Rect;
import android.text.TextUtils;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.content.Context;
import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.View;
import android.view.View$OnKeyListener;

class SearchView$8 implements View$OnKeyListener {
    final /* synthetic */ SearchView this$0;
    
    SearchView$8(final SearchView this$0) {
        this$0 = this$0;
        super();
    }
    
    public boolean onKey(final View view, final int n, final KeyEvent keyEvent) {
        if (SearchView.access$1400(this$0) != null) {
            if (SearchView.access$1200(this$0).isPopupShowing() && SearchView.access$1200(this$0).getListSelection() != -1) {
                return SearchView.access$1500(this$0, view, n, keyEvent);
            }
            if (!SearchView.access$1200(this$0).isEmpty() && KeyEventCompat.hasNoModifiers(keyEvent) && keyEvent.getAction() == 1 && n == 66) {
                view.cancelLongPress();
                SearchView.access$1700(this$0, 0, null, SearchView.access$1200(this$0).getText().toString());
                return true;
            }
        }
        return false;
    }
}