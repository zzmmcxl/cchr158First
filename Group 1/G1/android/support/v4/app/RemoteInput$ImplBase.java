package android.support.v4.app;

import android.util.Log;
import android.os.Bundle;
import android.content.Intent;

static class ImplBase implements Impl
{
    ImplBase() {
        super();
    }
    
    @Override
    public void addResultsToIntent(final RemoteInput[] array, final Intent intent, final Bundle bundle) {
        Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
    }
    
    @Override
    public Bundle getResultsFromIntent(final Intent intent) {
        Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
        return null;
    }
}
