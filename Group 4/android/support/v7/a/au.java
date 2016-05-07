/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class au
implements View.OnClickListener {
    private final View a;
    private final String b;
    private Method c;
    private Context d;

    public au(View view, String string) {
        this.a = view;
        this.b = string;
    }

    private void a(Context context, String string) {
        String string2;
        Context context2 = context;
        while (context2 != null) {
            try {
                Method method;
                if (!context2.isRestricted() && (method = context2.getClass().getMethod(this.b, View.class)) != null) {
                    this.c = method;
                    this.d = context2;
                    return;
                }
            }
            catch (NoSuchMethodException var6_4) {
                // empty catch block
            }
            if (context2 instanceof ContextWrapper) {
                context2 = ((ContextWrapper)context2).getBaseContext();
                continue;
            }
            context2 = null;
        }
        int n2 = this.a.getId();
        if (n2 == -1) {
            string2 = "";
            throw new IllegalStateException("Could not find method " + this.b + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.a.getClass() + string2);
        }
        string2 = " with id '" + this.a.getContext().getResources().getResourceEntryName(n2) + "'";
        throw new IllegalStateException("Could not find method " + this.b + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.a.getClass() + string2);
    }

    public void onClick(View view) {
        if (this.c == null) {
            this.a(this.a.getContext(), this.b);
        }
        try {
            this.c.invoke((Object)this.d, new Object[]{view});
            return;
        }
        catch (IllegalAccessException var3_2) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", var3_2);
        }
        catch (InvocationTargetException var2_3) {
            throw new IllegalStateException("Could not execute method for android:onClick", var2_3);
        }
    }
}

