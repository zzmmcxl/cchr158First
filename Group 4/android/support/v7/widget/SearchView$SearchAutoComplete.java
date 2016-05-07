/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.b.b;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.al;
import android.support.v7.widget.fs;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;

public class SearchView$SearchAutoComplete
extends al {
    private int a;
    private SearchView b;

    public SearchView$SearchAutoComplete(Context context) {
        this(context, null);
    }

    public SearchView$SearchAutoComplete(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.autoCompleteTextViewStyle);
    }

    public SearchView$SearchAutoComplete(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a = this.getThreshold();
    }

    public boolean enoughToFilter() {
        if (this.a <= 0) return true;
        if (!super.enoughToFilter()) return false;
        return true;
    }

    protected void onFocusChanged(boolean bl2, int n2, Rect rect) {
        super.onFocusChanged(bl2, n2, rect);
        this.b.d();
    }

    public boolean onKeyPreIme(int n2, KeyEvent keyEvent) {
        if (n2 != 4) return super.onKeyPreIme(n2, keyEvent);
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            KeyEvent.DispatcherState dispatcherState = this.getKeyDispatcherState();
            if (dispatcherState == null) return true;
            dispatcherState.startTracking(keyEvent, (Object)this);
            return true;
        }
        if (keyEvent.getAction() != 1) return super.onKeyPreIme(n2, keyEvent);
        KeyEvent.DispatcherState dispatcherState = this.getKeyDispatcherState();
        if (dispatcherState != null) {
            dispatcherState.handleUpEvent(keyEvent);
        }
        if (!keyEvent.isTracking()) return super.onKeyPreIme(n2, keyEvent);
        if (keyEvent.isCanceled()) return super.onKeyPreIme(n2, keyEvent);
        this.b.clearFocus();
        SearchView.a(this.b, false);
        return true;
    }

    public void onWindowFocusChanged(boolean bl2) {
        super.onWindowFocusChanged(bl2);
        if (!bl2) return;
        if (!this.b.hasFocus()) return;
        if (this.getVisibility() != 0) return;
        ((InputMethodManager)this.getContext().getSystemService("input_method")).showSoftInput((View)this, 0);
        if (!SearchView.a(this.getContext())) return;
        SearchView.a.a(this, true);
    }

    public void performCompletion() {
    }

    protected void replaceText(CharSequence charSequence) {
    }

    void setSearchView(SearchView searchView) {
        this.b = searchView;
    }

    public void setThreshold(int n2) {
        super.setThreshold(n2);
        this.a = n2;
    }
}

