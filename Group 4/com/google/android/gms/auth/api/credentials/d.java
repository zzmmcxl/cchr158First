/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.credentials;

import android.text.TextUtils;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.credentials.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class d {
    private final TreeSet a = new TreeSet();
    private final List b = new ArrayList();
    private final List c = new ArrayList();
    private int d = 12;
    private int e = 16;

    private TreeSet a(String string, String string2) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            throw new e(string2 + " cannot be null or empty");
        }
        TreeSet<Character> treeSet = new TreeSet<Character>();
        char[] arrc = string.toCharArray();
        int n2 = arrc.length;
        int n3 = 0;
        while (n3 < n2) {
            char c2 = arrc[n3];
            if (PasswordSpecification.a(c2, 32, 126)) {
                throw new e(string2 + " must only contain ASCII printable characters");
            }
            treeSet.add(Character.valueOf(c2));
            ++n3;
        }
        return treeSet;
    }

    private void b() {
        Iterator iterator = this.c.iterator();
        int n2 = 0;
        do {
            if (!iterator.hasNext()) {
                if (n2 <= this.e) return;
                throw new e("required character count cannot be greater than the max password size");
            }
            n2 += ((Integer)iterator.next()).intValue();
        } while (true);
    }

    private void c() {
        boolean[] arrbl = new boolean[95];
        Iterator iterator = this.b.iterator();
        block0 : while (iterator.hasNext()) {
            char[] arrc = ((String)iterator.next()).toCharArray();
            int n2 = arrc.length;
            int n3 = 0;
            do {
                if (n3 >= n2) continue block0;
                char c2 = arrc[n3];
                if (arrbl[c2 - 32]) {
                    throw new e("character " + c2 + " occurs in more than one required character set");
                }
                arrbl[c2 - 32] = true;
                ++n3;
            } while (true);
            break;
        }
        return;
    }

    public PasswordSpecification a() {
        if (this.a.isEmpty()) {
            throw new e("no allowed characters specified");
        }
        this.b();
        this.c();
        return new PasswordSpecification(1, PasswordSpecification.a(this.a), this.b, this.c, this.d, this.e);
    }

    public d a(int n2, int n3) {
        if (n2 < 1) {
            throw new e("minimumSize must be at least 1");
        }
        if (n2 > n3) {
            throw new e("maximumSize must be greater than or equal to minimumSize");
        }
        this.d = n2;
        this.e = n3;
        return this;
    }

    public d a(String string) {
        this.a.addAll(this.a(string, "allowedChars"));
        return this;
    }

    public d a(String string, int n2) {
        if (n2 < 1) {
            throw new e("count must be at least 1");
        }
        TreeSet treeSet = this.a(string, "requiredChars");
        this.b.add(PasswordSpecification.a(treeSet));
        this.c.add(n2);
        return this;
    }
}

