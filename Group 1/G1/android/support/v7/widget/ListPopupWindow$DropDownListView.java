package android.support.v7.widget;

import android.widget.ListView;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.os.Build$VERSION;
import android.view.View;
import android.util.AttributeSet;
import android.support.v7.appcompat.R;
import android.content.Context;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v4.view.ViewPropertyAnimatorCompat;

private static class DropDownListView extends ListViewCompat
{
    private ViewPropertyAnimatorCompat mClickAnimation;
    private boolean mDrawsInPressedState;
    private boolean mHijackFocus;
    private boolean mListSelectionHidden;
    private ListViewAutoScrollHelper mScrollHelper;
    
    public DropDownListView(final Context context, final boolean mHijackFocus) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.mHijackFocus = mHijackFocus;
        this.setCacheColorHint(0);
    }
    
    static /* synthetic */ boolean access$502(final DropDownListView dropDownListView, final boolean mListSelectionHidden) {
        return dropDownListView.mListSelectionHidden = mListSelectionHidden;
    }
    
    private void clearPressedItem() {
        this.setPressed(mDrawsInPressedState = false);
        this.drawableStateChanged();
        final View child = this.getChildAt(this.mMotionPosition - this.getFirstVisiblePosition());
        if (child != null) {
            child.setPressed(false);
        }
        if (mClickAnimation != null) {
            mClickAnimation.cancel();
            mClickAnimation = null;
        }
    }
    
    private void clickPressedItem(final View view, final int n) {
        this.performItemClick(view, n, this.getItemIdAtPosition(n));
    }
    
    private void setPressedItem(final View view, final int mMotionPosition, final float n, final float n2) {
        mDrawsInPressedState = true;
        if (Build$VERSION.SDK_INT >= 21) {
            this.drawableHotspotChanged(n, n2);
        }
        if (!this.isPressed()) {
            this.setPressed(true);
        }
        this.layoutChildren();
        if (this.mMotionPosition != -1) {
            final View child = this.getChildAt(this.mMotionPosition - this.getFirstVisiblePosition());
            if (child != null && child != view && child.isPressed()) {
                child.setPressed(false);
            }
        }
        this.mMotionPosition = mMotionPosition;
        final float n3 = n - view.getLeft();
        final float n4 = n2 - view.getTop();
        if (Build$VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(n3, n4);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        this.positionSelectorLikeTouchCompat(mMotionPosition, view, n, n2);
        this.setSelectorEnabled(false);
        this.refreshDrawableState();
    }
    
    public boolean hasFocus() {
        return mHijackFocus || super.hasFocus();
    }
    
    public boolean hasWindowFocus() {
        return mHijackFocus || super.hasWindowFocus();
    }
    
    public boolean isFocused() {
        return mHijackFocus || super.isFocused();
    }
    
    public boolean isInTouchMode() {
        return (mHijackFocus && mListSelectionHidden) || super.isInTouchMode();
    }
    
    public boolean onForwardedEvent(final MotionEvent motionEvent, final int n) {
        boolean b = true;
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean b2 = false;
        switch (actionMasked) {
            case 3:
                b2 = false;
                b = false;
                break;
            case 1:
                b = false;
            case 2: {
                final int pointerIndex = motionEvent.findPointerIndex(n);
                if (pointerIndex < 0) {
                    b2 = false;
                    b = false;
                    break;
                }
                final int n2 = (int)motionEvent.getX(pointerIndex);
                final int n3 = (int)motionEvent.getY(pointerIndex);
                final int pointToPosition = this.pointToPosition(n2, n3);
                if (pointToPosition == -1) {
                    b2 = true;
                    break;
                }
                final View child = this.getChildAt(pointToPosition - this.getFirstVisiblePosition());
                this.setPressedItem(child, pointToPosition, n2, n3);
                b = true;
                b2 = false;
                if (actionMasked == 1) {
                    this.clickPressedItem(child, pointToPosition);
                    b2 = false;
                    break;
                }
                break;
            }
        }
        if (!b || b2) {
            this.clearPressedItem();
        }
        if (b) {
            if (mScrollHelper == null) {
                mScrollHelper = new ListViewAutoScrollHelper(this);
            }
            mScrollHelper.setEnabled(true);
            mScrollHelper.onTouch((View)this, motionEvent);
        }
        else if (mScrollHelper != null) {
            mScrollHelper.setEnabled(false);
            return b;
        }
        return b;
    }
    
    @Override
    protected boolean touchModeDrawsInPressedStateCompat() {
        return mDrawsInPressedState || super.touchModeDrawsInPressedStateCompat();
    }
}
