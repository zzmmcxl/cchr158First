/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.os.Message;
import android.support.v7.a.e;
import android.view.View;

class f
implements View.OnClickListener {
    final /* synthetic */ e a;

    f(e e2) {
        this.a = e2;
    }

    public void onClick(View view) {
        Message message = view == e.a(this.a) && e.b(this.a) != null ? Message.obtain((Message)e.b(this.a)) : (view == e.c(this.a) && e.d(this.a) != null ? Message.obtain((Message)e.d(this.a)) : (view == e.e(this.a) && e.f(this.a) != null ? Message.obtain((Message)e.f(this.a)) : null));
        if (message != null) {
            message.sendToTarget();
        }
        e.h(this.a).obtainMessage(1, (Object)e.g(this.a)).sendToTarget();
    }
}

