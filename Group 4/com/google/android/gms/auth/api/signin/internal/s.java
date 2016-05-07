/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.h;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.bf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class s {
    public static void a(SignInConfiguration signInConfiguration, List list, Map map) {
        bf.a(signInConfiguration);
        bf.a(list);
        bf.a(map);
        GoogleSignInOptions googleSignInOptions = signInConfiguration.d();
        if (googleSignInOptions == null) return;
        list.add(h.a);
        LinkedList<String> linkedList = new LinkedList<String>();
        Iterator iterator = googleSignInOptions.a().iterator();
        do {
            if (!iterator.hasNext()) {
                map.put(h.a, linkedList);
                return;
            }
            linkedList.add(((Scope)iterator.next()).a());
        } while (true);
    }
}

