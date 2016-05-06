package android.support.v4.view;

import android.view.View;
import android.view.KeyEvent$Callback;
import android.view.KeyEvent;
import android.os.Build$VERSION;

public final class KeyEventCompat
{
    static final KeyEventVersionImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 11) {
            IMPL = (KeyEventVersionImpl)new HoneycombKeyEventVersionImpl();
            return;
        }
        IMPL = (KeyEventVersionImpl)new BaseKeyEventVersionImpl();
    }
    
    private KeyEventCompat() {
        super();
    }
    
    public static boolean dispatch(final KeyEvent keyEvent, final KeyEvent$Callback keyEvent$Callback, final Object o, final Object o2) {
        return IMPL.dispatch(keyEvent, keyEvent$Callback, o, o2);
    }
    
    public static Object getKeyDispatcherState(final View view) {
        return IMPL.getKeyDispatcherState(view);
    }
    
    public static boolean hasModifiers(final KeyEvent keyEvent, final int n) {
        return IMPL.metaStateHasModifiers(keyEvent.getMetaState(), n);
    }
    
    public static boolean hasNoModifiers(final KeyEvent keyEvent) {
        return IMPL.metaStateHasNoModifiers(keyEvent.getMetaState());
    }
    
    public static boolean isTracking(final KeyEvent keyEvent) {
        return IMPL.isTracking(keyEvent);
    }
    
    public static boolean metaStateHasModifiers(final int n, final int n2) {
        return IMPL.metaStateHasModifiers(n, n2);
    }
    
    public static boolean metaStateHasNoModifiers(final int n) {
        return IMPL.metaStateHasNoModifiers(n);
    }
    
    public static int normalizeMetaState(final int n) {
        return IMPL.normalizeMetaState(n);
    }
    
    public static void startTracking(final KeyEvent keyEvent) {
        IMPL.startTracking(keyEvent);
    }
}
