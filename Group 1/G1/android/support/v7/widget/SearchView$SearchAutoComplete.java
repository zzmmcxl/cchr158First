package android.support.v7.widget;

import android.widget.AutoCompleteTextView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.view.KeyEvent$DispatcherState;
import android.view.KeyEvent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.content.Context;

public static class SearchAutoComplete extends AppCompatAutoCompleteTextView
{
    private SearchView mSearchView;
    private int mThreshold;
    
    public SearchAutoComplete(final Context context) {
        this(context, null);
    }
    
    public SearchAutoComplete(final Context context, final AttributeSet set) {
        this(context, set, R.attr.autoCompleteTextViewStyle);
    }
    
    public SearchAutoComplete(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.mThreshold = this.getThreshold();
    }
    
    static /* synthetic */ boolean access$1600(final SearchAutoComplete searchAutoComplete) {
        return searchAutoComplete.isEmpty();
    }
    
    private boolean isEmpty() {
        return TextUtils.getTrimmedLength((CharSequence)this.getText()) == 0;
    }
    
    public boolean enoughToFilter() {
        return mThreshold <= 0 || super.enoughToFilter();
    }
    
    protected void onFocusChanged(final boolean b, final int n, final Rect rect) {
        super.onFocusChanged(b, n, rect);
        mSearchView.onTextFocusChanged();
    }
    
    public boolean onKeyPreIme(final int n, final KeyEvent keyEvent) {
        if (n == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                final KeyEvent$DispatcherState keyDispatcherState = this.getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, (Object)this);
                }
                return true;
            }
            if (keyEvent.getAction() == 1) {
                final KeyEvent$DispatcherState keyDispatcherState2 = this.getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    mSearchView.clearFocus();
                    SearchView.access$2100(mSearchView, false);
                    return true;
                }
            }
        }
        return super.onKeyPreIme(n, keyEvent);
    }
    
    public void onWindowFocusChanged(final boolean b) {
        super.onWindowFocusChanged(b);
        if (b && mSearchView.hasFocus() && this.getVisibility() == 0) {
            ((InputMethodManager)this.getContext().getSystemService("input_method")).showSoftInput((View)this, 0);
            if (SearchView.isLandscapeMode(this.getContext())) {
                HIDDEN_METHOD_INVOKER.ensureImeVisible(this, true);
            }
        }
    }
    
    public void performCompletion() {
    }
    
    protected void replaceText(final CharSequence charSequence) {
    }
    
    void setSearchView(final SearchView mSearchView) {
        this.mSearchView = mSearchView;
    }
    
    public void setThreshold(final int n) {
        super.setThreshold(n);
        mThreshold = n;
    }
}
