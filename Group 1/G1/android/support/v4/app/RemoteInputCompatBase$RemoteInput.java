package android.support.v4.app;

import android.os.Bundle;

public abstract static class RemoteInput
{
    public RemoteInput() {
        super();
    }
    
    protected abstract boolean getAllowFreeFormInput();
    
    protected abstract CharSequence[] getChoices();
    
    protected abstract Bundle getExtras();
    
    protected abstract CharSequence getLabel();
    
    protected abstract String getResultKey();
}
