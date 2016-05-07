/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.aa;
import android.support.v4.app.af;

class ab
extends Handler {
    final /* synthetic */ aa a;

    ab(aa aa2) {
        this.a = aa2;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            default: {
                super.handleMessage(message);
                return;
            }
            case 1: {
                if (!this.a.e) return;
                this.a.a(false);
                return;
            }
            case 2: 
        }
        this.a.b();
        this.a.b.p();
    }
}

