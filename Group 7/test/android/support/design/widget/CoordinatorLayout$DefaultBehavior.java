package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout$Behavior;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CoordinatorLayout$DefaultBehavior {
   Class<? extends CoordinatorLayout$Behavior> value();
}
