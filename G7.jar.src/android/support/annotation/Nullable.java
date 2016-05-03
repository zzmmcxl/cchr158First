package android.support.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.FIELD})
public @interface Nullable {}


/* Location:              C:\Users\colin\Documents\GitHub\cchr158First\G7.jar!\android\support\annotation\Nullable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */