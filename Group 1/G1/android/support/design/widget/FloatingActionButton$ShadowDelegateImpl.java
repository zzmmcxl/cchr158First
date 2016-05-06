package android.support.design.widget;

import android.graphics.drawable.Drawable;

private class ShadowDelegateImpl implements ShadowViewDelegate
{
    final /* synthetic */ FloatingActionButton this$0;
    
    private ShadowDelegateImpl(final FloatingActionButton this$0) {
        this$0 = this$0;
        super();
    }
    
    ShadowDelegateImpl(final FloatingActionButton floatingActionButton, final FloatingActionButton$1 internalVisibilityChangedListener) {
        this(floatingActionButton);
    }
    
    @Override
    public float getRadius() {
        return this$0.getSizeDimension() / 2.0f;
    }
    
    @Override
    public boolean isCompatPaddingEnabled() {
        return FloatingActionButton.access$600(this$0);
    }
    
    @Override
    public void setBackgroundDrawable(final Drawable drawable) {
        FloatingActionButton.access$501(this$0, drawable);
    }
    
    @Override
    public void setShadowPadding(final int n, final int n2, final int n3, final int n4) {
        FloatingActionButton.access$200(this$0).set(n, n2, n3, n4);
        this$0.setPadding(n + FloatingActionButton.access$400(this$0), n2 + FloatingActionButton.access$400(this$0), n3 + FloatingActionButton.access$400(this$0), n4 + FloatingActionButton.access$400(this$0));
    }
}
