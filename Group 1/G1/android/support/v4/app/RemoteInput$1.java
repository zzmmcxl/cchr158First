package android.support.v4.app;

import android.os.Bundle;

static final class RemoteInput$1 implements Factory {
    RemoteInput$1() {
        super();
    }
    
    public RemoteInput build(final String s, final CharSequence charSequence, final CharSequence[] array, final boolean b, final Bundle bundle) {
        return new RemoteInput(s, charSequence, array, b, bundle, null);
    }
    
    @Override
    public /* bridge */ RemoteInputCompatBase.RemoteInput build(final String s, final CharSequence charSequence, final CharSequence[] array, final boolean b, final Bundle bundle) {
        return this.build(s, charSequence, array, b, bundle);
    }
    
    public RemoteInput[] newArray(final int n) {
        return new RemoteInput[n];
    }
    
    @Override
    public /* bridge */ RemoteInputCompatBase.RemoteInput[] newArray(final int n) {
        return this.newArray(n);
    }
}