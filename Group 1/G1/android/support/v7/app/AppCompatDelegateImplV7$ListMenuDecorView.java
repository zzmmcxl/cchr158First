package android.support.v7.app;

import android.support.v7.widget.AppCompatDrawableManager;
import android.view.MotionEvent;
import android.view.KeyEvent;
import android.content.Context;
import android.support.v7.widget.ContentFrameLayout;

private class ListMenuDecorView extends ContentFrameLayout
{
    final /* synthetic */ AppCompatDelegateImplV7 this$0;
    
    public ListMenuDecorView(final AppCompatDelegateImplV7 this$0, final Context context) {
        this$0 = this$0;
        super(context);
    }
    
    private boolean isOutOfBounds(final int n, final int n2) {
        return n < -5 || n2 < -5 || n > 5 + this.getWidth() || n2 > 5 + this.getHeight();
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        return this$0.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.isOutOfBounds((int)motionEvent.getX(), (int)motionEvent.getY())) {
            AppCompatDelegateImplV7.access$1400(this$0, 0);
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
    
    public void setBackgroundResource(final int n) {
        this.setBackgroundDrawable(AppCompatDrawableManager.get().getDrawable(this.getContext(), n));
    }
}
