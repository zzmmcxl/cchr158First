/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view;

import android.view.InflateException;
import android.view.MenuItem;
import java.lang.reflect.Method;

class j
implements MenuItem.OnMenuItemClickListener {
    private static final Class[] a = new Class[]{MenuItem.class};
    private Object b;
    private Method c;

    public j(Object object, String string) {
        this.b = object;
        Class class_ = object.getClass();
        try {
            this.c = class_.getMethod(string, a);
            return;
        }
        catch (Exception var4_4) {
            InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + string + " in class " + class_.getName());
            inflateException.initCause((Throwable)var4_4);
            throw inflateException;
        }
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        try {
            if (this.c.getReturnType() == Boolean.TYPE) {
                return (Boolean)this.c.invoke(this.b, new Object[]{menuItem});
            }
            this.c.invoke(this.b, new Object[]{menuItem});
            return true;
        }
        catch (Exception var2_2) {
            throw new RuntimeException(var2_2);
        }
    }
}

