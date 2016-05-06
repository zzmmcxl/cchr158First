package android.support.v7.widget;

import android.support.v7.graphics.drawable.DrawableWrapper;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.MotionEvent;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.view.View$MeasureSpec;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.graphics.drawable.Drawable;
import android.graphics.Canvas;
import android.widget.AbsListView;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Rect;
import java.lang.reflect.Field;
import android.widget.ListView;

public class ListViewCompat extends ListView
{
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;
    private static final int[] STATE_SET_NOTHING;
    private Field mIsChildViewEnabled;
    protected int mMotionPosition;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    private GateKeeperDrawable mSelector;
    final Rect mSelectorRect;
    
    static {
        STATE_SET_NOTHING = new int[] { 0 };
    }
    
    public ListViewCompat(final Context context) {
        this(context, null);
    }
    
    public ListViewCompat(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public ListViewCompat(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        mSelectorRect = new Rect();
        mSelectionLeftPadding = 0;
        mSelectionTopPadding = 0;
        mSelectionRightPadding = 0;
        mSelectionBottomPadding = 0;
        try {
            (mIsChildViewEnabled = AbsListView.class.getDeclaredField("mIsChildViewEnabled")).setAccessible(true);
        }
        catch (NoSuchFieldException ex) {
            ex.printStackTrace();
        }
    }
    
    protected void dispatchDraw(final Canvas canvas) {
        this.drawSelectorCompat(canvas);
        super.dispatchDraw(canvas);
    }
    
    protected void drawSelectorCompat(final Canvas canvas) {
        if (!mSelectorRect.isEmpty()) {
            final Drawable selector = this.getSelector();
            if (selector != null) {
                selector.setBounds(mSelectorRect);
                selector.draw(canvas);
            }
        }
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.setSelectorEnabled(true);
        this.updateSelectorStateCompat();
    }
    
    public int lookForSelectablePosition(final int n, final boolean b) {
        final ListAdapter adapter = this.getAdapter();
        if (adapter != null && !this.isInTouchMode()) {
            final int count = adapter.getCount();
            if (!this.getAdapter().areAllItemsEnabled()) {
                int n2;
                if (b) {
                    for (n2 = Math.max(0, n); n2 < count && !adapter.isEnabled(n2); ++n2) {}
                }
                else {
                    for (n2 = Math.min(n, count - 1); n2 >= 0 && !adapter.isEnabled(n2); --n2) {}
                }
                if (n2 >= 0 && n2 < count) {
                    return n2;
                }
            }
            else if (n >= 0 && n < count) {
                return n;
            }
        }
        return -1;
    }
    
    public int measureHeightOfChildrenCompat(final int n, final int n2, final int n3, final int n4, final int n5) {
        final int listPaddingTop = this.getListPaddingTop();
        final int listPaddingBottom = this.getListPaddingBottom();
        this.getListPaddingLeft();
        this.getListPaddingRight();
        final int dividerHeight = this.getDividerHeight();
        final Drawable divider = this.getDivider();
        final ListAdapter adapter = this.getAdapter();
        if (adapter != null) {
            int n6 = listPaddingTop + listPaddingBottom;
            int n7;
            if (dividerHeight > 0 && divider != null) {
                n7 = dividerHeight;
            }
            else {
                n7 = 0;
            }
            int n8 = 0;
            View view = null;
            int n9 = 0;
            final int count = adapter.getCount();
            int i = 0;
            while (i < count) {
                final int itemViewType = adapter.getItemViewType(i);
                if (itemViewType != n9) {
                    view = null;
                    n9 = itemViewType;
                }
                view = adapter.getView(i, view, (ViewGroup)this);
                ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = this.generateDefaultLayoutParams();
                    view.setLayoutParams(layoutParams);
                }
                int n10;
                if (layoutParams.height > 0) {
                    n10 = View$MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                }
                else {
                    n10 = View$MeasureSpec.makeMeasureSpec(0, 0);
                }
                view.measure(n, n10);
                view.forceLayout();
                if (i > 0) {
                    n6 += n7;
                }
                n6 += view.getMeasuredHeight();
                if (n6 >= n4) {
                    if (n5 < 0 || i <= n5 || n8 <= 0 || n6 == n4) {
                        return n4;
                    }
                    return n8;
                }
                else {
                    if (n5 >= 0 && i >= n5) {
                        n8 = n6;
                    }
                    ++i;
                }
            }
            return n6;
        }
        return listPaddingTop + listPaddingBottom;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                mMotionPosition = this.pointToPosition((int)motionEvent.getX(), (int)motionEvent.getY());
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
    
    protected void positionSelectorCompat(final int n, final View view) {
        final Rect mSelectorRect = this.mSelectorRect;
        mSelectorRect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        mSelectorRect.left -= mSelectionLeftPadding;
        mSelectorRect.top -= mSelectionTopPadding;
        mSelectorRect.right += mSelectionRightPadding;
        mSelectorRect.bottom += mSelectionBottomPadding;
        try {
            final boolean boolean1 = mIsChildViewEnabled.getBoolean(this);
            if (view.isEnabled() != boolean1) {
                mIsChildViewEnabled.set(this, !boolean1);
                if (n != -1) {
                    this.refreshDrawableState();
                }
            }
        }
        catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }
    
    protected void positionSelectorLikeFocusCompat(final int n, final View view) {
        boolean b = true;
        final Drawable selector = this.getSelector();
        final boolean b2 = selector != null && n != -1 && b;
        if (b2) {
            selector.setVisible(false, false);
        }
        this.positionSelectorCompat(n, view);
        if (b2) {
            final Rect mSelectorRect = this.mSelectorRect;
            final float exactCenterX = mSelectorRect.exactCenterX();
            final float exactCenterY = mSelectorRect.exactCenterY();
            if (this.getVisibility() != 0) {
                b = false;
            }
            selector.setVisible(b, false);
            DrawableCompat.setHotspot(selector, exactCenterX, exactCenterY);
        }
    }
    
    protected void positionSelectorLikeTouchCompat(final int n, final View view, final float n2, final float n3) {
        this.positionSelectorLikeFocusCompat(n, view);
        final Drawable selector = this.getSelector();
        if (selector != null && n != -1) {
            DrawableCompat.setHotspot(selector, n2, n3);
        }
    }
    
    public void setSelector(final Drawable drawable) {
        GateKeeperDrawable mSelector;
        if (drawable != null) {
            mSelector = new GateKeeperDrawable(drawable);
        }
        else {
            mSelector = null;
        }
        super.setSelector((Drawable)(this.mSelector = mSelector));
        final Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        mSelectionLeftPadding = rect.left;
        mSelectionTopPadding = rect.top;
        mSelectionRightPadding = rect.right;
        mSelectionBottomPadding = rect.bottom;
    }
    
    protected void setSelectorEnabled(final boolean enabled) {
        if (mSelector != null) {
            mSelector.setEnabled(enabled);
        }
    }
    
    protected boolean shouldShowSelectorCompat() {
        return this.touchModeDrawsInPressedStateCompat() && this.isPressed();
    }
    
    protected boolean touchModeDrawsInPressedStateCompat() {
        return false;
    }
    
    protected void updateSelectorStateCompat() {
        final Drawable selector = this.getSelector();
        if (selector != null && this.shouldShowSelectorCompat()) {
            selector.setState(this.getDrawableState());
        }
    }
}
