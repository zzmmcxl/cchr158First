/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.aa;
import com.google.android.gms.b.ab;
import com.google.android.gms.b.ac;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.u;
import com.google.android.gms.b.w;
import com.google.android.gms.b.x;
import com.google.android.gms.b.y;
import com.google.android.gms.b.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@fi
public class v {
    private final int a;
    private final int b;
    private final int c;
    private final u d = new aa();

    public v(int n2) {
        this.b = n2;
        this.a = 6;
        this.c = 0;
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    private String b(String string) {
        String[] arrstring = string.split("\n");
        if (arrstring.length == 0) {
            return "";
        }
        y y2 = this.a();
        Arrays.sort(arrstring, new w(this));
        int n2 = 0;
        while (n2 < arrstring.length) {
            if (n2 >= this.b) return y2.toString();
            if (arrstring[n2].trim().length() != 0) {
                y2.a(this.d.a(arrstring[n2]));
            }
            ++n2;
        }
        return y2.toString();
        catch (IOException iOException) {
            fp.b("Error while writing hash to byteStream", iOException);
        }
        return y2.toString();
    }

    y a() {
        return new y();
    }

    String a(String string) {
        String[] arrstring = string.split("\n");
        if (arrstring.length == 0) {
            return "";
        }
        y y2 = this.a();
        PriorityQueue priorityQueue = new PriorityQueue(this.b, new x(this));
        for (int i2 = 0; i2 < arrstring.length; ++i2) {
            String[] arrstring2 = z.b(arrstring[i2]);
            if (arrstring2.length == 0) continue;
            ab.a(arrstring2, this.b, this.a, priorityQueue);
        }
        Iterator iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            ac ac2 = (ac)iterator.next();
            try {
                y2.a(this.d.a(ac2.b));
                continue;
            }
            catch (IOException var8_9) {
                fp.b("Error while writing hash to byteStream", var8_9);
                return y2.toString();
            }
        }
        return y2.toString();
    }

    public String a(ArrayList arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            stringBuffer.append(((String)iterator.next()).toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        switch (this.c) {
            default: {
                return "";
            }
            case 0: {
                return this.a(stringBuffer.toString());
            }
            case 1: 
        }
        return this.b(stringBuffer.toString());
    }
}

