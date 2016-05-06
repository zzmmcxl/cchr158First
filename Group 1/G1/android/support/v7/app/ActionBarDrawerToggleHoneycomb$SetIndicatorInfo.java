package android.support.v7.app;

import android.view.View;
import android.view.ViewGroup;
import android.graphics.drawable.Drawable;
import android.app.ActionBar;
import android.app.Activity;
import android.widget.ImageView;
import java.lang.reflect.Method;

static class SetIndicatorInfo
{
    public Method setHomeActionContentDescription;
    public Method setHomeAsUpIndicator;
    public ImageView upIndicatorView;
    
    SetIndicatorInfo(final Activity activity) {
        super();
        try {
            this.setHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
            this.setHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
        }
        catch (NoSuchMethodException ex) {
            final View viewById = activity.findViewById(16908332);
            if (viewById == null) {
                return;
            }
            final ViewGroup viewGroup = (ViewGroup)viewById.getParent();
            if (viewGroup.getChildCount() != 2) {
                return;
            }
            final View child = viewGroup.getChildAt(0);
            final View child2 = viewGroup.getChildAt(1);
            Object o;
            if (child.getId() == 16908332) {
                o = child2;
            }
            else {
                o = child;
            }
            if (o instanceof ImageView) {
                this.upIndicatorView = (ImageView)o;
            }
        }
    }
}
