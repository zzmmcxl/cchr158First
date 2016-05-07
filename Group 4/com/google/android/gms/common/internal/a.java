/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.aq;
import com.google.android.gms.common.r;

public class a
extends aq {
    int a;
    private Account b;
    private Context c;

    public static Account a(ap ap2) {
        Account account = null;
        if (ap2 == null) return account;
        long l2 = Binder.clearCallingIdentity();
        try {
            Account account2;
            account = account2 = ap2.a();
        }
        catch (RemoteException var5_4) {
            Log.w((String)"AccountAccessor", (String)"Remote account accessor probably died");
            return null;
        }
        finally {
            Binder.restoreCallingIdentity((long)l2);
        }
        Binder.restoreCallingIdentity((long)l2);
        return account;
    }

    @Override
    public Account a() {
        int n2 = Binder.getCallingUid();
        if (n2 == this.a) {
            return this.b;
        }
        if (!r.b(this.c, n2)) throw new SecurityException("Caller is not GooglePlayServices");
        this.a = n2;
        return this.b;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof a) return this.b.equals((Object)((a)object).b);
        return false;
    }
}

