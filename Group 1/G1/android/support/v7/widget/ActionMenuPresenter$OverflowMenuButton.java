package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View$OnTouchListener;
import android.view.View;
import android.util.AttributeSet;
import android.support.v7.appcompat.R;
import android.content.Context;

private class OverflowMenuButton extends AppCompatImageView implements ActionMenuChildView
{
    private final float[] mTempPts;
    final /* synthetic */ ActionMenuPresenter this$0;
    
    public OverflowMenuButton(final ActionMenuPresenter this$0, final Context context) {
        this$0 = this$0;
        super(context, null, R.attr.actionOverflowButtonStyle);
        mTempPts = new float[2];
        this.setClickable(true);
        this.setFocusable(true);
        this.setVisibility(0);
        this.setEnabled(true);
        this.setOnTouchListener((View$OnTouchListener)new ListPopupWindow.ForwardingListener(this) {
            final /* synthetic */ OverflowMenuButton this$1;
            final /* synthetic */ ActionMenuPresenter val$this$0;
            
            ActionMenuPresenter$OverflowMenuButton$1(final View view) {
                this$1 = this$1;
                super(view);
            }
            
            @Override
            public ListPopupWindow getPopup() {
                if (ActionMenuPresenter.access$200(this$0) == null) {
                    return null;
                }
                return ActionMenuPresenter.access$200(this$0).getPopup();
            }
            
            public boolean onForwardingStarted() {
                this$0.showOverflowMenu();
                return true;
            }
            
            public boolean onForwardingStopped() {
                if (ActionMenuPresenter.access$300(this$0) != null) {
                    return false;
                }
                this$0.hideOverflowMenu();
                return true;
            }
        });
    }
    
    @Override
    public boolean needsDividerAfter() {
        return false;
    }
    
    @Override
    public boolean needsDividerBefore() {
        return false;
    }
    
    public boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        this.playSoundEffect(0);
        this$0.showOverflowMenu();
        return true;
    }
    
    protected boolean setFrame(final int n, final int n2, final int n3, final int n4) {
        final boolean setFrame = super.setFrame(n, n2, n3, n4);
        final Drawable drawable = this.getDrawable();
        final Drawable background = this.getBackground();
        if (drawable != null && background != null) {
            final int width = this.getWidth();
            final int height = this.getHeight();
            final int n5 = Math.max(width, height) / 2;
            final int n6 = this.getPaddingLeft() - this.getPaddingRight();
            final int n7 = this.getPaddingTop() - this.getPaddingBottom();
            final int n8 = (width + n6) / 2;
            final int n9 = (height + n7) / 2;
            DrawableCompat.setHotspotBounds(background, n8 - n5, n9 - n5, n8 + n5, n9 + n5);
        }
        return setFrame;
    }
}
