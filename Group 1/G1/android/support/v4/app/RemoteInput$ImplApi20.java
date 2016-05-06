package android.support.v4.app;

import android.os.Bundle;
import android.content.Intent;

static class ImplApi20 implements Impl
{
    ImplApi20() {
        super();
    }
    
    @Override
    public void addResultsToIntent(final RemoteInput[] array, final Intent intent, final Bundle bundle) {
        RemoteInputCompatApi20.addResultsToIntent(array, intent, bundle);
    }
    
    @Override
    public Bundle getResultsFromIntent(final Intent intent) {
        return RemoteInputCompatApi20.getResultsFromIntent(intent);
    }
}
