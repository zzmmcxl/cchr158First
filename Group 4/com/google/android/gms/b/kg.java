/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.support.v4.g.a;
import com.google.android.gms.b.kd;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class kg {
    public static Map a(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12) {
        a a2 = new a(6);
        a2.put(object, object2);
        a2.put(object3, object4);
        a2.put(object5, object6);
        a2.put(object7, object8);
        a2.put(object9, object10);
        a2.put(object11, object12);
        return Collections.unmodifiableMap(a2);
    }

    public static Set a() {
        return Collections.emptySet();
    }

    public static Set a(Object object) {
        return Collections.singleton(object);
    }

    public static Set a(Object object, Object object2) {
        kd kd2 = new kd(2);
        kd2.add(object);
        kd2.add(object2);
        return Collections.unmodifiableSet(kd2);
    }

    public static Set a(Object object, Object object2, Object object3) {
        kd kd2 = new kd(3);
        kd2.add(object);
        kd2.add(object2);
        kd2.add(object3);
        return Collections.unmodifiableSet(kd2);
    }

    public static Set a(Object object, Object object2, Object object3, Object object4) {
        kd kd2 = new kd(4);
        kd2.add(object);
        kd2.add(object2);
        kd2.add(object3);
        kd2.add(object4);
        return Collections.unmodifiableSet(kd2);
    }

    public static /* varargs */ Set a(Object ... arrobject) {
        void var1_2;
        switch (arrobject.length) {
            default: {
                if (arrobject.length > 32) break;
                kd kd2 = new kd(Arrays.asList(arrobject));
                return Collections.unmodifiableSet(var1_2);
            }
            case 0: {
                return kg.a();
            }
            case 1: {
                return kg.a(arrobject[0]);
            }
            case 2: {
                return kg.a(arrobject[0], arrobject[1]);
            }
            case 3: {
                return kg.a(arrobject[0], arrobject[1], arrobject[2]);
            }
            case 4: {
                return kg.a(arrobject[0], arrobject[1], arrobject[2], arrobject[3]);
            }
        }
        HashSet<Object> hashSet = new HashSet<Object>(Arrays.asList(arrobject));
        return Collections.unmodifiableSet(var1_2);
    }
}

