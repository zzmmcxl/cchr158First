package android.support.design.internal;

import android.graphics.drawable.Drawable$Callback;
import android.support.annotation.NonNull;
import android.graphics.Canvas;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.design.R;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

public class ScrimInsetsFrameLayout extends FrameLayout
{
    private Drawable mInsetForeground;
    private Rect mInsets;
    private Rect mTempRect;
    
    public ScrimInsetsFrameLayout(final Context context) {
        this(context, null);
    }
    
    public ScrimInsetsFrameLayout(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public ScrimInsetsFrameLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        mTempRect = new Rect();
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.ScrimInsetsFrameLayout, n, R.style.Widget_Design_ScrimInsetsFrameLayout);
        mInsetForeground = obtainStyledAttributes.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
        obtainStyledAttributes.recycle();
        this.setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this, (OnApplyWindowInsetsListener)new OnApplyWindowInsetsListener() {
            final /* synthetic */ ScrimInsetsFrameLayout this$0;
            
            ScrimInsetsFrameLayout$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public WindowInsetsCompat onApplyWindowInsets(final View view, final WindowInsetsCompat windowInsetsCompat) {
                if (mInsets == null) {
                    mInsets = new Rect();
                }
                mInsets.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                this$0.onInsetsChanged(mInsets);
                this$0.setWillNotDraw(mInsets.isEmpty() || mInsetForeground == null);
                ViewCompat.postInvalidateOnAnimation((View)this$0);
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
    }
    
    static /* synthetic */ Rect access$000(final ScrimInsetsFrameLayout scrimInsetsFrameLayout) {
        return scrimInsetsFrameLayout.mInsets;
    }
    
    static /* synthetic */ Rect access$002(final ScrimInsetsFrameLayout scrimInsetsFrameLayout, final Rect mInsets) {
        return scrimInsetsFrameLayout.mInsets = mInsets;
    }
    
    static /* synthetic */ Drawable access$100(final ScrimInsetsFrameLayout scrimInsetsFrameLayout) {
        return scrimInsetsFrameLayout.mInsetForeground;
    }
    
    public void draw(@NonNull final Canvas canvas) {
        super.draw(canvas);
        final int width = this.getWidth();
        final int height = this.getHeight();
        if (mInsets != null && mInsetForeground != null) {
            final int save = canvas.save();
            canvas.translate((float)this.getScrollX(), (float)this.getScrollY());
            mTempRect.set(0, 0, width, mInsets.top);
            mInsetForeground.setBounds(mTempRect);
            mInsetForeground.draw(canvas);
            mTempRect.set(0, height - mInsets.bottom, width, height);
            mInsetForeground.setBounds(mTempRect);
            mInsetForeground.draw(canvas);
            mTempRect.set(0, mInsets.top, mInsets.left, height - mInsets.bottom);
            mInsetForeground.setBounds(mTempRect);
            mInsetForeground.draw(canvas);
            mTempRect.set(width - mInsets.right, mInsets.top, width, height - mInsets.bottom);
            mInsetForeground.setBounds(mTempRect);
            mInsetForeground.draw(canvas);
            canvas.restoreToCount(save);
        }
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mInsetForeground != null) {
            mInsetForeground.setCallback((Drawable$Callback)this);
        }
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mInsetForeground != null) {
            mInsetForeground.setCallback((Drawable$Callback)null);
        }
    }
    
    protected void onInsetsChanged(final Rect rect) {
    }
}
