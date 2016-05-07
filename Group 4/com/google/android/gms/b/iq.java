/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.b.aw;
import com.google.android.gms.b.cu;
import com.google.android.gms.b.di;
import com.google.android.gms.b.ep;
import com.google.android.gms.b.hy;
import com.google.android.gms.b.ir;
import com.google.android.gms.b.k;
import com.google.android.gms.b.kl;
import com.google.android.gms.b.me;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class iq {
    private AtomicInteger a = new AtomicInteger();
    private final Map b = new HashMap();
    private final Set c = new HashSet();
    private final PriorityBlockingQueue d = new PriorityBlockingQueue();
    private final PriorityBlockingQueue e = new PriorityBlockingQueue();
    private final k f;
    private final di g;
    private final kl h;
    private ep[] i;
    private aw j;
    private List k = new ArrayList();

    public iq(k k2, di di2) {
        this(k2, di2, 4);
    }

    public iq(k k2, di di2, int n2) {
        this(k2, di2, n2, new cu(new Handler(Looper.getMainLooper())));
    }

    public iq(k k2, di di2, int n2, kl kl2) {
        this.f = k2;
        this.g = di2;
        this.i = new ep[n2];
        this.h = kl2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public hy a(hy hy2) {
        hy2.a(this);
        Set set = this.c;
        // MONITORENTER : set
        this.c.add(hy2);
        // MONITOREXIT : set
        hy2.a(this.c());
        hy2.b("add-to-queue");
        if (!hy2.p()) {
            this.e.add(hy2);
            return hy2;
        }
        Map map = this.b;
        // MONITORENTER : map
        String string = hy2.e();
        if (!this.b.containsKey(string)) {
            this.b.put(string, null);
            this.d.add(hy2);
            return hy2;
        }
        LinkedList<hy> linkedList = (LinkedList<hy>)this.b.get(string);
        if (linkedList == null) {
            linkedList = new LinkedList<hy>();
        }
        linkedList.add(hy2);
        this.b.put(string, linkedList);
        if (me.b) {
            me.a("Request for cacheKey=%s is in flight, putting on hold.", string);
        }
        // MONITOREXIT : map
        return hy2;
    }

    public void a() {
        this.b();
        this.j = new aw(this.d, this.e, this.f, this.h);
        this.j.start();
        int n2 = 0;
        while (n2 < this.i.length) {
            ep ep2;
            this.i[n2] = ep2 = new ep(this.e, this.g, this.f, this.h);
            ep2.start();
            ++n2;
        }
    }

    public void b() {
        if (this.j != null) {
            this.j.a();
        }
        int n2 = 0;
        while (n2 < this.i.length) {
            if (this.i[n2] != null) {
                this.i[n2].a();
            }
            ++n2;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void b(hy hy2) {
        Set set = this.c;
        // MONITORENTER : set
        this.c.remove(hy2);
        // MONITOREXIT : set
        List list = this.k;
        // MONITORENTER : list
        Iterator iterator = this.k.iterator();
        while (iterator.hasNext()) {
            ((ir)iterator.next()).a(hy2);
        }
        // MONITOREXIT : list
        if (!hy2.p()) return;
        Map map = this.b;
        // MONITORENTER : map
        String string = hy2.e();
        Queue queue = (Queue)this.b.remove(string);
        if (queue != null) {
            if (me.b) {
                Object[] arrobject = new Object[]{queue.size(), string};
                me.a("Releasing %d waiting requests for cacheKey=%s.", arrobject);
            }
            this.d.addAll(queue);
        }
        // MONITOREXIT : map
    }

    public int c() {
        return this.a.incrementAndGet();
    }
}

