package android.support.v4.view;

import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.view.LayoutInflater$Factory;

static class FactoryWrapper implements LayoutInflater$Factory
{
    final LayoutInflaterFactory mDelegateFactory;
    
    FactoryWrapper(final LayoutInflaterFactory mDelegateFactory) {
        super();
        this.mDelegateFactory = mDelegateFactory;
    }
    
    public View onCreateView(final String s, final Context context, final AttributeSet set) {
        return mDelegateFactory.onCreateView(null, s, context, set);
    }
    
    @Override
    public String toString() {
        return this.getClass().getName() + "{" + mDelegateFactory + "}";
    }
}
