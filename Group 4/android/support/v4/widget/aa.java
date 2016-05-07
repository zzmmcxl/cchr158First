/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.os.Build;
import android.support.v4.widget.ab;
import android.support.v4.widget.ac;
import android.widget.ListView;

public final class aa {
    public static void a(ListView listView, int n2) {
        if (Build.VERSION.SDK_INT >= 19) {
            ac.a(listView, n2);
            return;
        }
        ab.a(listView, n2);
    }
}

