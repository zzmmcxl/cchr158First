package android.support.v7.view.menu;

import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.widget.Toast;
import android.support.v4.view.ViewCompat;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.content.res.Configuration;
import android.view.View;
import android.text.TextUtils;
import android.content.res.TypedArray;
import android.content.res.Resources;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ActionMenuView;
import android.view.View$OnLongClickListener;
import android.view.View$OnClickListener;
import android.support.v7.widget.AppCompatTextView;

public class ActionMenuItemView extends AppCompatTextView implements ItemView, View$OnClickListener, View$OnLongClickListener, ActionMenuChildView
{
    private static final int MAX_ICON_SIZE = 32;
    private static final String TAG = "ActionMenuItemView";
    private boolean mAllowTextWithIcon;
    private boolean mExpandedFormat;
    private ListPopupWindow.ForwardingListener mForwardingListener;
    private Drawable mIcon;
    private MenuItemImpl mItemData;
    private ItemInvoker mItemInvoker;
    private int mMaxIconSize;
    private int mMinWidth;
    private PopupCallback mPopupCallback;
    private int mSavedPaddingLeft;
    private CharSequence mTitle;
    
    public ActionMenuItemView(final Context context) {
        this(context, null);
    }
    
    public ActionMenuItemView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public ActionMenuItemView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        final Resources resources = context.getResources();
        mAllowTextWithIcon = resources.getBoolean(R.bool.abc_config_allowActionMenuItemTextWithIcon);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.ActionMenuItemView, n, 0);
        mMinWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        mMaxIconSize = (int)(0.5f + 32.0f * resources.getDisplayMetrics().density);
        this.setOnClickListener((View$OnClickListener)this);
        this.setOnLongClickListener((View$OnLongClickListener)this);
        mSavedPaddingLeft = -1;
    }
    
    static /* synthetic */ PopupCallback access$000(final ActionMenuItemView actionMenuItemView) {
        return actionMenuItemView.mPopupCallback;
    }
    
    static /* synthetic */ ItemInvoker access$100(final ActionMenuItemView actionMenuItemView) {
        return actionMenuItemView.mItemInvoker;
    }
    
    static /* synthetic */ MenuItemImpl access$200(final ActionMenuItemView actionMenuItemView) {
        return actionMenuItemView.mItemData;
    }
    
    private void updateTextButtonVisibility() {
        final boolean b = !TextUtils.isEmpty(mTitle) && true;
        boolean b2 = false;
        Label_0057: {
            if (mIcon != null) {
                final boolean showsTextAsAction = mItemData.showsTextAsAction();
                b2 = false;
                if (!showsTextAsAction) {
                    break Label_0057;
                }
                if (!mAllowTextWithIcon) {
                    final boolean mExpandedFormat = this.mExpandedFormat;
                    b2 = false;
                    if (!mExpandedFormat) {
                        break Label_0057;
                    }
                }
            }
            b2 = true;
        }
        CharSequence mTitle;
        if (b & b2) {
            mTitle = this.mTitle;
        }
        else {
            mTitle = null;
        }
        this.setText(mTitle);
    }
    
    @Override
    public MenuItemImpl getItemData() {
        return mItemData;
    }
    
    public boolean hasText() {
        return !TextUtils.isEmpty(this.getText());
    }
    
    @Override
    public void initialize(final MenuItemImpl mItemData, final int n) {
        this.mItemData = mItemData;
        this.setIcon(mItemData.getIcon());
        this.setTitle(mItemData.getTitleForItemView((ItemView)this));
        this.setId(mItemData.getItemId());
        int visibility;
        if (mItemData.isVisible()) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        this.setVisibility(visibility);
        ((MenuView.ItemView)this).setEnabled(mItemData.isEnabled());
        if (mItemData.hasSubMenu() && mForwardingListener == null) {
            mForwardingListener = new ActionMenuItemForwardingListener();
        }
    }
    
    public boolean needsDividerAfter() {
        return this.hasText();
    }
    
    public boolean needsDividerBefore() {
        return this.hasText() && mItemData.getIcon() == null;
    }
    
    public void onClick(final View view) {
        if (mItemInvoker != null) {
            mItemInvoker.invokeItem(mItemData);
        }
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        if (Build$VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        mAllowTextWithIcon = this.getContext().getResources().getBoolean(R.bool.abc_config_allowActionMenuItemTextWithIcon);
        this.updateTextButtonVisibility();
    }
    
    public boolean onLongClick(final View view) {
        if (this.hasText()) {
            return false;
        }
        final int[] array = new int[2];
        final Rect rect = new Rect();
        this.getLocationOnScreen(array);
        this.getWindowVisibleDisplayFrame(rect);
        final Context context = this.getContext();
        final int width = this.getWidth();
        final int height = this.getHeight();
        final int n = array[1] + height / 2;
        int n2 = array[0] + width / 2;
        if (ViewCompat.getLayoutDirection(view) == 0) {
            n2 = context.getResources().getDisplayMetrics().widthPixels - n2;
        }
        final Toast text = Toast.makeText(context, mItemData.getTitle(), 0);
        if (n < rect.height()) {
            text.setGravity(8388661, n2, height + array[1] - rect.top);
        }
        else {
            text.setGravity(81, 0, height);
        }
        text.show();
        return true;
    }
    
    protected void onMeasure(final int n, final int n2) {
        final boolean hasText = this.hasText();
        if (hasText && mSavedPaddingLeft >= 0) {
            super.setPadding(mSavedPaddingLeft, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        }
        super.onMeasure(n, n2);
        final int mode = View$MeasureSpec.getMode(n);
        final int size = View$MeasureSpec.getSize(n);
        final int measuredWidth = this.getMeasuredWidth();
        int n3;
        if (mode == Integer.MIN_VALUE) {
            n3 = Math.min(size, mMinWidth);
        }
        else {
            n3 = mMinWidth;
        }
        if (mode != 1073741824 && mMinWidth > 0 && measuredWidth < n3) {
            super.onMeasure(View$MeasureSpec.makeMeasureSpec(n3, 1073741824), n2);
        }
        if (!hasText && mIcon != null) {
            super.setPadding((this.getMeasuredWidth() - mIcon.getBounds().width()) / 2, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        return (mItemData.hasSubMenu() && mForwardingListener != null && mForwardingListener.onTouch((View)this, motionEvent)) || super.onTouchEvent(motionEvent);
    }
    
    @Override
    public boolean prefersCondensedTitle() {
        return true;
    }
    
    @Override
    public void setCheckable(final boolean b) {
    }
    
    @Override
    public void setChecked(final boolean b) {
    }
    
    public void setExpandedFormat(final boolean mExpandedFormat) {
        if (this.mExpandedFormat != mExpandedFormat) {
            this.mExpandedFormat = mExpandedFormat;
            if (mItemData != null) {
                mItemData.actionFormatChanged();
            }
        }
    }
    
    @Override
    public void setIcon(final Drawable mIcon) {
        this.mIcon = mIcon;
        if (mIcon != null) {
            int n = mIcon.getIntrinsicWidth();
            int n2 = mIcon.getIntrinsicHeight();
            if (n > mMaxIconSize) {
                final float n3 = mMaxIconSize / n;
                n = mMaxIconSize;
                n2 *= n3;
            }
            if (n2 > mMaxIconSize) {
                final float n4 = mMaxIconSize / n2;
                n2 = mMaxIconSize;
                n *= n4;
            }
            mIcon.setBounds(0, 0, n, n2);
        }
        this.setCompoundDrawables(mIcon, (Drawable)null, (Drawable)null, (Drawable)null);
        this.updateTextButtonVisibility();
    }
    
    public void setItemInvoker(final ItemInvoker mItemInvoker) {
        this.mItemInvoker = mItemInvoker;
    }
    
    public void setPadding(final int mSavedPaddingLeft, final int n, final int n2, final int n3) {
        super.setPadding(this.mSavedPaddingLeft = mSavedPaddingLeft, n, n2, n3);
    }
    
    public void setPopupCallback(final PopupCallback mPopupCallback) {
        this.mPopupCallback = mPopupCallback;
    }
    
    @Override
    public void setShortcut(final boolean b, final char c) {
    }
    
    @Override
    public void setTitle(final CharSequence mTitle) {
        this.setContentDescription(this.mTitle = mTitle);
        this.updateTextButtonVisibility();
    }
    
    @Override
    public boolean showsIcon() {
        return true;
    }
}
