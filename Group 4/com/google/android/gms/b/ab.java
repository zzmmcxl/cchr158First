/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.ac;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.z;
import java.util.PriorityQueue;

@fi
public class ab {
    static long a(int n2, int n3, long l2, long l3, long l4) {
        long l5 = l3 * ((Integer.MAX_VALUE + (long)n2) % 1073807359) % 1073807359;
        return (l4 * ((l2 + 1073807359 - l5) % 1073807359) % 1073807359 + (Integer.MAX_VALUE + (long)n3) % 1073807359) % 1073807359;
    }

    static long a(long l2, int n2) {
        if (n2 == 0) {
            return 1;
        }
        if (n2 == 1) return l2;
        if (n2 % 2 != 0) return l2 * (ab.a(l2 * l2 % 1073807359, n2 / 2) % 1073807359) % 1073807359;
        return ab.a(l2 * l2 % 1073807359, n2 / 2) % 1073807359;
    }

    static String a(String[] arrstring, int n2, int n3) {
        if (arrstring.length < n2 + n3) {
            fp.b("Unable to construct shingle");
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int n4 = n2;
        do {
            if (n4 >= -1 + (n2 + n3)) {
                stringBuffer.append(arrstring[-1 + (n2 + n3)]);
                return stringBuffer.toString();
            }
            stringBuffer.append(arrstring[n4]);
            stringBuffer.append(' ');
            ++n4;
        } while (true);
    }

    static void a(int n2, long l2, String string, int n3, PriorityQueue priorityQueue) {
        ac ac2 = new ac(l2, string, n3);
        if (priorityQueue.size() == n2 && ((ac)priorityQueue.peek()).a > ac2.a) {
            return;
        }
        if (priorityQueue.contains(ac2)) return;
        priorityQueue.add(ac2);
        if (priorityQueue.size() <= n2) return;
        priorityQueue.poll();
    }

    public static void a(String[] arrstring, int n2, int n3, PriorityQueue priorityQueue) {
        if (arrstring.length < n3) {
            ab.a(n2, ab.b(arrstring, 0, arrstring.length), ab.a(arrstring, 0, arrstring.length), arrstring.length, priorityQueue);
            return;
        }
        long l2 = ab.b(arrstring, 0, n3);
        ab.a(n2, l2, ab.a(arrstring, 0, n3), n3, priorityQueue);
        long l3 = ab.a(16785407, n3 - 1);
        int n4 = 1;
        while (n4 < 1 + (arrstring.length - n3)) {
            long l4 = ab.a(z.a(arrstring[n4 - 1]), z.a(arrstring[-1 + (n4 + n3)]), l2, l3, 16785407);
            ab.a(n2, l4, ab.a(arrstring, n4, n3), arrstring.length, priorityQueue);
            ++n4;
            l2 = l4;
        }
    }

    private static long b(String[] arrstring, int n2, int n3) {
        long l2 = (Integer.MAX_VALUE + (long)z.a(arrstring[n2])) % 1073807359;
        int n4 = n2 + 1;
        while (n4 < n2 + n3) {
            l2 = (l2 * 16785407 % 1073807359 + (Integer.MAX_VALUE + (long)z.a(arrstring[n4])) % 1073807359) % 1073807359;
            ++n4;
        }
        return l2;
    }
}

