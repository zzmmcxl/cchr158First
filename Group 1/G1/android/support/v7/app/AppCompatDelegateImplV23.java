package android.support.v7.app;

import android.view.ActionMode;
import android.view.ActionMode$Callback;
import android.view.Window$Callback;
import android.view.Window;
import android.content.Context;

class AppCompatDelegateImplV23 extends AppCompatDelegateImplV14
{
    AppCompatDelegateImplV23(final Context context, final Window window, final AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }
    
    @Override
    Window$Callback wrapWindowCallback(final Window$Callback window$Callback) {
        return (Window$Callback)new AppCompatWindowCallbackV23(window$Callback);
    }
}
