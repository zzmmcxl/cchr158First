package android.support.design.internal;

import android.graphics.drawable.Drawable$ConstantState;
import android.widget.TextView;
import android.support.v4.widget.TextViewCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.ViewStub;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.graphics.drawable.StateListDrawable;
import android.view.ViewGroup;
import android.support.design.R;
import android.view.LayoutInflater;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.CheckedTextView;
import android.support.v7.view.menu.MenuItemImpl;
import android.content.res.ColorStateList;
import android.widget.FrameLayout;
import android.support.v7.view.menu.MenuView;

public class NavigationMenuItemView extends ForegroundLinearLayout implements ItemView
{
    private static final int[] CHECKED_STATE_SET;
    private FrameLayout mActionArea;
    private final int mIconSize;
    private ColorStateList mIconTintList;
    private MenuItemImpl mItemData;
    private final CheckedTextView mTextView;
    
    static {
        CHECKED_STATE_SET = new int[] { 16842912 };
    }
    
    public NavigationMenuItemView(final Context context) {
        this(context, null);
    }
    
    public NavigationMenuItemView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public NavigationMenuItemView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.design_navigation_menu_item, (ViewGroup)this, true);
        mIconSize = context.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size);
        (mTextView = (CheckedTextView)this.findViewById(R.id.design_menu_item_text)).setDuplicateParentStateEnabled(true);
    }
    
    private StateListDrawable createDefaultBackground() {
        final TypedValue typedValue = new TypedValue();
        if (this.getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, typedValue, true)) {
            final StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(CHECKED_STATE_SET, (Drawable)new ColorDrawable(typedValue.data));
            stateListDrawable.addState(NavigationMenuItemView.EMPTY_STATE_SET, (Drawable)new ColorDrawable(0));
            return stateListDrawable;
        }
        return null;
    }
    
    private void setActionView(final View view) {
        if (mActionArea == null) {
            mActionArea = (FrameLayout)((ViewStub)this.findViewById(R.id.design_menu_item_action_area_stub)).inflate();
        }
        mActionArea.removeAllViews();
        if (view != null) {
            mActionArea.addView(view);
        }
    }
    
    @Override
    public MenuItemImpl getItemData() {
        return mItemData;
    }
    
    @Override
    public void initialize(final MenuItemImpl mItemData, final int n) {
        this.mItemData = mItemData;
        int visibility;
        if (mItemData.isVisible()) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        this.setVisibility(visibility);
        if (this.getBackground() == null) {
            this.setBackgroundDrawable((Drawable)this.createDefaultBackground());
        }
        this.setCheckable(mItemData.isCheckable());
        this.setChecked(mItemData.isChecked());
        ((MenuView.ItemView)this).setEnabled(mItemData.isEnabled());
        this.setTitle(mItemData.getTitle());
        this.setIcon(mItemData.getIcon());
        this.setActionView(mItemData.getActionView());
    }
    
    protected int[] onCreateDrawableState(final int n) {
        final int[] onCreateDrawableState = super.onCreateDrawableState(n + 1);
        if (mItemData != null && mItemData.isCheckable() && mItemData.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }
    
    @Override
    public boolean prefersCondensedTitle() {
        return false;
    }
    
    public void recycle() {
        if (mActionArea != null) {
            mActionArea.removeAllViews();
        }
        mTextView.setCompoundDrawables((Drawable)null, (Drawable)null, (Drawable)null, (Drawable)null);
    }
    
    @Override
    public void setCheckable(final boolean b) {
        this.refreshDrawableState();
    }
    
    @Override
    public void setChecked(final boolean checked) {
        this.refreshDrawableState();
        mTextView.setChecked(checked);
    }
    
    @Override
    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            final Drawable$ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.wrap(drawable).mutate();
            drawable.setBounds(0, 0, mIconSize, mIconSize);
            DrawableCompat.setTintList(drawable, mIconTintList);
        }
        TextViewCompat.setCompoundDrawablesRelative(mTextView, drawable, (Drawable)null, (Drawable)null, (Drawable)null);
    }
    
    void setIconTintList(final ColorStateList mIconTintList) {
        this.mIconTintList = mIconTintList;
        if (mItemData != null) {
            this.setIcon(mItemData.getIcon());
        }
    }
    
    @Override
    public void setShortcut(final boolean b, final char c) {
    }
    
    public void setTextAppearance(final Context context, final int n) {
        mTextView.setTextAppearance(context, n);
    }
    
    public void setTextColor(final ColorStateList textColor) {
        mTextView.setTextColor(textColor);
    }
    
    @Override
    public void setTitle(final CharSequence text) {
        mTextView.setText(text);
    }
    
    @Override
    public boolean showsIcon() {
        return true;
    }
}
