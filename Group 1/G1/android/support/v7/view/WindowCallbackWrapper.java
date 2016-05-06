package android.support.v7.view;

import android.view.ActionMode$Callback;
import android.view.WindowManager$LayoutParams;
import android.view.SearchEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window$Callback;

public class WindowCallbackWrapper implements Window$Callback
{
    final Window$Callback mWrapped;
    
    public WindowCallbackWrapper(final Window$Callback mWrapped) {
        super();
        if (mWrapped == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        mWrapped = mWrapped;
    }
    
    public boolean dispatchGenericMotionEvent(final MotionEvent motionEvent) {
        return mWrapped.dispatchGenericMotionEvent(motionEvent);
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        return mWrapped.dispatchKeyEvent(keyEvent);
    }
    
    public boolean dispatchKeyShortcutEvent(final KeyEvent keyEvent) {
        return mWrapped.dispatchKeyShortcutEvent(keyEvent);
    }
    
    public boolean dispatchPopulateAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        return mWrapped.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }
    
    public boolean dispatchTouchEvent(final MotionEvent motionEvent) {
        return mWrapped.dispatchTouchEvent(motionEvent);
    }
    
    public boolean dispatchTrackballEvent(final MotionEvent motionEvent) {
        return mWrapped.dispatchTrackballEvent(motionEvent);
    }
    
    public void onActionModeFinished(final ActionMode actionMode) {
        mWrapped.onActionModeFinished(actionMode);
    }
    
    public void onActionModeStarted(final ActionMode actionMode) {
        mWrapped.onActionModeStarted(actionMode);
    }
    
    public void onAttachedToWindow() {
        mWrapped.onAttachedToWindow();
    }
    
    public void onContentChanged() {
        mWrapped.onContentChanged();
    }
    
    public boolean onCreatePanelMenu(final int n, final Menu menu) {
        return mWrapped.onCreatePanelMenu(n, menu);
    }
    
    public View onCreatePanelView(final int n) {
        return mWrapped.onCreatePanelView(n);
    }
    
    public void onDetachedFromWindow() {
        mWrapped.onDetachedFromWindow();
    }
    
    public boolean onMenuItemSelected(final int n, final MenuItem menuItem) {
        return mWrapped.onMenuItemSelected(n, menuItem);
    }
    
    public boolean onMenuOpened(final int n, final Menu menu) {
        return mWrapped.onMenuOpened(n, menu);
    }
    
    public void onPanelClosed(final int n, final Menu menu) {
        mWrapped.onPanelClosed(n, menu);
    }
    
    public boolean onPreparePanel(final int n, final View view, final Menu menu) {
        return mWrapped.onPreparePanel(n, view, menu);
    }
    
    public boolean onSearchRequested() {
        return mWrapped.onSearchRequested();
    }
    
    public boolean onSearchRequested(final SearchEvent searchEvent) {
        return mWrapped.onSearchRequested(searchEvent);
    }
    
    public void onWindowAttributesChanged(final WindowManager$LayoutParams windowManager$LayoutParams) {
        mWrapped.onWindowAttributesChanged(windowManager$LayoutParams);
    }
    
    public void onWindowFocusChanged(final boolean b) {
        mWrapped.onWindowFocusChanged(b);
    }
    
    public ActionMode onWindowStartingActionMode(final ActionMode$Callback actionMode$Callback) {
        return mWrapped.onWindowStartingActionMode(actionMode$Callback);
    }
    
    public ActionMode onWindowStartingActionMode(final ActionMode$Callback actionMode$Callback, final int n) {
        return mWrapped.onWindowStartingActionMode(actionMode$Callback, n);
    }
}
