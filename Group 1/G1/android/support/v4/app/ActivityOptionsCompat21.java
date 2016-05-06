package android.support.v4.app;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.app.Activity;
import android.app.ActivityOptions;

class ActivityOptionsCompat21
{
    private final ActivityOptions mActivityOptions;
    
    private ActivityOptionsCompat21(final ActivityOptions mActivityOptions) {
        super();
        mActivityOptions = mActivityOptions;
    }
    
    public static ActivityOptionsCompat21 makeSceneTransitionAnimation(final Activity activity, final View view, final String s) {
        return new ActivityOptionsCompat21(ActivityOptions.makeSceneTransitionAnimation(activity, view, s));
    }
    
    public static ActivityOptionsCompat21 makeSceneTransitionAnimation(final Activity activity, final View[] array, final String[] array2) {
        Pair[] array3 = null;
        if (array != null) {
            array3 = new Pair[array.length];
            for (int i = 0; i < array3.length; ++i) {
                array3[i] = Pair.create((Object)array[i], (Object)array2[i]);
            }
        }
        return new ActivityOptionsCompat21(ActivityOptions.makeSceneTransitionAnimation(activity, array3));
    }
    
    public Bundle toBundle() {
        return mActivityOptions.toBundle();
    }
    
    public void update(final ActivityOptionsCompat21 activityOptionsCompat21) {
        mActivityOptions.update(mActivityOptions);
    }
}
