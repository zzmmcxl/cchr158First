package android.support.v4.view;

import android.view.View;

static class ICSMr1ViewCompatImpl extends ICSViewCompatImpl
{
    ICSMr1ViewCompatImpl() {
        super();
    }
    
    @Override
    public boolean hasOnClickListeners(final View view) {
        return ViewCompatICSMr1.hasOnClickListeners(view);
    }
}
