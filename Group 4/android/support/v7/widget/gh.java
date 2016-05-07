/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.support.v7.widget.gj;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class gh
extends ContextWrapper {
    private static final ArrayList a = new ArrayList();
    private Resources b;
    private final Resources.Theme c;

    private gh(Context context) {
        super(context);
        this.c = this.getResources().newTheme();
        this.c.setTo(context.getTheme());
    }

    public static Context a(Context object) {
        if (!gh.b((Context)object)) return object;
        int n2 = a.size();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                gh gh2 = new gh((Context)object);
                a.add(new WeakReference<gh>(gh2));
                return gh2;
            }
            WeakReference weakReference = (WeakReference)a.get(n3);
            gh gh3 = weakReference != null ? (gh)((Object)weakReference.get()) : null;
            if (gh3 != null && gh3.getBaseContext() == object) {
                return gh3;
            }
            ++n3;
        } while (true);
    }

    private static boolean b(Context context) {
        if (context instanceof gh) {
            return false;
        }
        if (context.getResources() instanceof gj) return false;
        return true;
    }

    public Resources getResources() {
        if (this.b != null) return this.b;
        this.b = new gj((Context)this, super.getResources());
        return this.b;
    }

    public Resources.Theme getTheme() {
        return this.c;
    }

    public void setTheme(int n2) {
        this.c.applyStyle(n2, true);
    }
}

