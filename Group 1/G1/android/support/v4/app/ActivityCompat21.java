package android.support.v4.app;

import java.util.Map;
import java.util.List;
import android.content.Context;
import android.os.Parcelable;
import android.graphics.RectF;
import android.graphics.Matrix;
import android.view.View;
import android.media.session.MediaController;
import android.app.Activity;
import android.app.SharedElementCallback;

class ActivityCompat21
{
    ActivityCompat21() {
        super();
    }
    
    private static SharedElementCallback createCallback(final SharedElementCallback21 sharedElementCallback21) {
        SharedElementCallback sharedElementCallback22 = null;
        if (sharedElementCallback21 != null) {
            sharedElementCallback22 = new SharedElementCallbackImpl(sharedElementCallback21);
        }
        return sharedElementCallback22;
    }
    
    public static void finishAfterTransition(final Activity activity) {
        activity.finishAfterTransition();
    }
    
    public static void postponeEnterTransition(final Activity activity) {
        activity.postponeEnterTransition();
    }
    
    public static void setEnterSharedElementCallback(final Activity activity, final SharedElementCallback21 sharedElementCallback21) {
        activity.setEnterSharedElementCallback(createCallback(sharedElementCallback21));
    }
    
    public static void setExitSharedElementCallback(final Activity activity, final SharedElementCallback21 sharedElementCallback21) {
        activity.setExitSharedElementCallback(createCallback(sharedElementCallback21));
    }
    
    public static void setMediaController(final Activity activity, final Object o) {
        activity.setMediaController((MediaController)o);
    }
    
    public static void startPostponedEnterTransition(final Activity activity) {
        activity.startPostponedEnterTransition();
    }
}
