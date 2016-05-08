package android.support.annotation;

import android.support.annotation.RequiresPermission;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
public @interface RequiresPermission$Write {
   RequiresPermission value();
}
