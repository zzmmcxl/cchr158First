package android.support.v7.app;

import android.support.v7.view.SupportActionModeWrapper;
import android.view.ActionMode;
import android.view.ActionMode$Callback;
import android.view.Window$Callback;

class AppCompatWindowCallbackV14 extends AppCompatWindowCallbackBase
{
    final /* synthetic */ AppCompatDelegateImplV14 this$0;
    
    AppCompatWindowCallbackV14(final AppCompatDelegateImplV14 this$0, final Window$Callback window$Callback) {
        this$0 = this$0;
        super(this$0, window$Callback);
    }
    
    @Override
    public ActionMode onWindowStartingActionMode(final ActionMode$Callback actionMode$Callback) {
        if (this$0.isHandleNativeActionModesEnabled()) {
            return this.startAsSupportActionMode(actionMode$Callback);
        }
        return super.onWindowStartingActionMode(actionMode$Callback);
    }
    
    final ActionMode startAsSupportActionMode(final ActionMode$Callback actionMode$Callback) {
        final SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(this$0.mContext, actionMode$Callback);
        final android.support.v7.view.ActionMode startSupportActionMode = this$0.startSupportActionMode(callbackWrapper);
        if (startSupportActionMode != null) {
            return callbackWrapper.getActionModeWrapper(startSupportActionMode);
        }
        return null;
    }
}
