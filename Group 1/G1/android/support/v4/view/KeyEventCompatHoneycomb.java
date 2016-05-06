package android.support.v4.view;

import android.view.KeyEvent;

class KeyEventCompatHoneycomb
{
    KeyEventCompatHoneycomb() {
        super();
    }
    
    public static boolean metaStateHasModifiers(final int n, final int n2) {
        return KeyEvent.metaStateHasModifiers(n, n2);
    }
    
    public static boolean metaStateHasNoModifiers(final int n) {
        return KeyEvent.metaStateHasNoModifiers(n);
    }
    
    public static int normalizeMetaState(final int n) {
        return KeyEvent.normalizeMetaState(n);
    }
}
