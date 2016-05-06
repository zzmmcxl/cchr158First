package android.support.design.widget;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

public abstract static class Callback
{
    public static final int DISMISS_EVENT_ACTION = 1;
    public static final int DISMISS_EVENT_CONSECUTIVE = 4;
    public static final int DISMISS_EVENT_MANUAL = 3;
    public static final int DISMISS_EVENT_SWIPE = 0;
    public static final int DISMISS_EVENT_TIMEOUT = 2;
    
    public Callback() {
        super();
    }
    
    public void onDismissed(final Snackbar snackbar, final int n) {
    }
    
    public void onShown(final Snackbar snackbar) {
    }
}
