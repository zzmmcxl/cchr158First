/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.j;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.s;
import java.util.Arrays;
import java.util.List;

public abstract class g {
    public static final g a = g.a("\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000\u00a0\u180e\u202f").a(g.a('\u2000', '\u200a'));
    public static final g b = g.a("\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000").a(g.a('\u2000', '\u2006')).a(g.a('\u2008', '\u200a'));
    public static final g c = g.a('\u0000', '');
    public static final g d;
    public static final g e;
    public static final g f;
    public static final g g;
    public static final g h;
    public static final g i;
    public static final g j;
    public static final g k;
    public static final g l;
    public static final g m;
    public static final g n;
    public static final g o;

    static {
        g g2 = g.a('0', '9');
        char[] arrc = "\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".toCharArray();
        int n2 = arrc.length;
        g g3 = g2;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                d = g3;
                e = g.a('\t', '\r').a(g.a('\u001c', ' ')).a(g.a('\u1680')).a(g.a('\u180e')).a(g.a('\u2000', '\u2006')).a(g.a('\u2008', '\u200b')).a(g.a('\u2028', '\u2029')).a(g.a('\u205f')).a(g.a('\u3000'));
                f = new h();
                g = new n();
                h = new o();
                i = new p();
                j = new q();
                k = g.a('\u0000', '\u001f').a(g.a('', '\u009f'));
                l = g.a('\u0000', ' ').a(g.a('', '\u00a0')).a(g.a('\u00ad')).a(g.a('\u0600', '\u0603')).a(g.a("\u06dd\u070f\u1680\u17b4\u17b5\u180e")).a(g.a('\u2000', '\u200f')).a(g.a('\u2028', '\u202f')).a(g.a('\u205f', '\u2064')).a(g.a('\u206a', '\u206f')).a(g.a('\u3000')).a(g.a('\ud800', '\uf8ff')).a(g.a("\ufeff\ufff9\ufffa\ufffb"));
                m = g.a('\u0000', '\u04f9').a(g.a('\u05be')).a(g.a('\u05d0', '\u05ea')).a(g.a('\u05f3')).a(g.a('\u05f4')).a(g.a('\u0600', '\u06ff')).a(g.a('\u0750', '\u077f')).a(g.a('\u0e00', '\u0e7f')).a(g.a('\u1e00', '\u20af')).a(g.a('\u2100', '\u213a')).a(g.a('\ufb50', '\ufdff')).a(g.a('\ufe70', '\ufeff')).a(g.a('\uff61', '\uffdc'));
                n = new r();
                o = new i();
                return;
            }
            char c2 = arrc[n3];
            g3 = g3.a(g.a(c2, (char)(c2 + 9)));
            ++n3;
        } while (true);
    }

    public static g a(char c2) {
        return new j(c2);
    }

    public static g a(char c2, char c3) {
        boolean bl2 = c3 >= c2;
        bf.b(bl2);
        return new m(c2, c3);
    }

    public static g a(CharSequence charSequence) {
        switch (charSequence.length()) {
            default: {
                char[] arrc = charSequence.toString().toCharArray();
                Arrays.sort(arrc);
                return new l(arrc);
            }
            case 0: {
                return o;
            }
            case 1: {
                return g.a(charSequence.charAt(0));
            }
            case 2: 
        }
        return new k(charSequence.charAt(0), charSequence.charAt(1));
    }

    public g a(g g2) {
        g[] arrg = new g[]{this, (g)bf.a(g2)};
        return new s(Arrays.asList(arrg));
    }

    public abstract boolean b(char var1);

    public boolean b(CharSequence charSequence) {
        int n2 = -1 + charSequence.length();
        while (n2 >= 0) {
            if (!this.b(charSequence.charAt(n2))) {
                return false;
            }
            --n2;
        }
        return true;
    }
}

