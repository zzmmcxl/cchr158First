/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

public class n
implements Window.Callback {
    final Window.Callback d;

    public n(Window.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.d = callback;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.d.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.d.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.d.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.d.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.d.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.d.dispatchTrackballEvent(motionEvent);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.d.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.d.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.d.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.d.onContentChanged();
    }

    public boolean onCreatePanelMenu(int n2, Menu menu) {
        return this.d.onCreatePanelMenu(n2, menu);
    }

    public View onCreatePanelView(int n2) {
        return this.d.onCreatePanelView(n2);
    }

    public void onDetachedFromWindow() {
        this.d.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int n2, MenuItem menuItem) {
        return this.d.onMenuItemSelected(n2, menuItem);
    }

    public boolean onMenuOpened(int n2, Menu menu) {
        return this.d.onMenuOpened(n2, menu);
    }

    public void onPanelClosed(int n2, Menu menu) {
        this.d.onPanelClosed(n2, menu);
    }

    public boolean onPreparePanel(int n2, View view, Menu menu) {
        return this.d.onPreparePanel(n2, view, menu);
    }

    public boolean onSearchRequested() {
        return this.d.onSearchRequested();
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.d.onSearchRequested(searchEvent);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.d.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean bl2) {
        this.d.onWindowFocusChanged(bl2);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.d.onWindowStartingActionMode(callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int n2) {
        return this.d.onWindowStartingActionMode(callback, n2);
    }
}

