package android.support.v7.app;

import java.lang.reflect.InvocationTargetException;
import android.content.ContextWrapper;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import java.lang.reflect.Method;
import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;

private static class DeclaredOnClickListener implements View$OnClickListener
{
    private final View mHostView;
    private final String mMethodName;
    private Context mResolvedContext;
    private Method mResolvedMethod;
    
    public DeclaredOnClickListener(@NonNull final View mHostView, @NonNull final String mMethodName) {
        super();
        this.mHostView = mHostView;
        this.mMethodName = mMethodName;
    }
    
    @NonNull
    private void resolveMethod(@Nullable Context baseContext, @NonNull final String s) {
        while (baseContext != null) {
            try {
                if (!baseContext.isRestricted()) {
                    final Method method = baseContext.getClass().getMethod(mMethodName, View.class);
                    if (method != null) {
                        mResolvedMethod = method;
                        mResolvedContext = baseContext;
                        return;
                    }
                }
            }
            catch (NoSuchMethodException ex) {}
            if (baseContext instanceof ContextWrapper) {
                baseContext = ((ContextWrapper)baseContext).getBaseContext();
            }
            else {
                baseContext = null;
            }
        }
        final int id = mHostView.getId();
        String string;
        if (id == -1) {
            string = "";
        }
        else {
            string = " with id '" + mHostView.getContext().getResources().getResourceEntryName(id) + "'";
        }
        throw new IllegalStateException("Could not find method " + mMethodName + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + mHostView.getClass() + string);
    }
    
    public void onClick(@NonNull final View view) {
        if (mResolvedMethod == null) {
            this.resolveMethod(mHostView.getContext(), mMethodName);
        }
        try {
            mResolvedMethod.invoke(mResolvedContext, view);
        }
        catch (IllegalAccessException ex) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", ex);
        }
        catch (InvocationTargetException ex2) {
            throw new IllegalStateException("Could not execute method for android:onClick", ex2);
        }
    }
}
