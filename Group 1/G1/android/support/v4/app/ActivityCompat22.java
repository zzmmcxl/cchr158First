package android.support.v4.app;

import android.net.Uri;
import android.app.Activity;

class ActivityCompat22
{
    ActivityCompat22() {
        super();
    }
    
    public static Uri getReferrer(final Activity activity) {
        return activity.getReferrer();
    }
}
