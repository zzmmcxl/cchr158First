package android.support.design.widget;

import android.support.v4.os.ParcelableCompat;
import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import android.support.annotation.StyleRes;
import android.support.v4.content.ContextCompat;
import android.support.annotation.DrawableRes;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.annotation.IdRes;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.graphics.Rect;
import android.support.annotation.LayoutRes;
import android.view.Menu;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.support.v7.view.SupportMenuInflater;
import android.util.TypedValue;
import android.graphics.drawable.Drawable;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.view.ViewGroup;
import android.support.v7.view.menu.MenuPresenter;
import android.view.MenuItem;
import android.support.v7.view.menu.MenuBuilder;
import android.view.View;
import android.support.v4.view.ViewCompat;
import android.support.design.R;
import android.util.AttributeSet;
import android.content.Context;
import android.support.design.internal.NavigationMenuPresenter;
import android.view.MenuInflater;
import android.support.design.internal.NavigationMenu;
import android.support.design.internal.ScrimInsetsFrameLayout;

public class NavigationView extends ScrimInsetsFrameLayout
{
    private static final int[] CHECKED_STATE_SET;
    private static final int[] DISABLED_STATE_SET;
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    private OnNavigationItemSelectedListener mListener;
    private int mMaxWidth;
    private final NavigationMenu mMenu;
    private MenuInflater mMenuInflater;
    private final NavigationMenuPresenter mPresenter;
    
    static {
        CHECKED_STATE_SET = new int[] { 16842912 };
        DISABLED_STATE_SET = new int[] { -16842910 };
    }
    
    public NavigationView(final Context context) {
        this(context, null);
    }
    
    public NavigationView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public NavigationView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        mPresenter = new NavigationMenuPresenter();
        ThemeUtils.checkAppCompatTheme(context);
        mMenu = new NavigationMenu(context);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.NavigationView, n, R.style.Widget_Design_NavigationView);
        this.setBackgroundDrawable(obtainStyledAttributes.getDrawable(R.styleable.NavigationView_android_background));
        if (obtainStyledAttributes.hasValue(R.styleable.NavigationView_elevation)) {
            ViewCompat.setElevation(this, (float)obtainStyledAttributes.getDimensionPixelSize(R.styleable.NavigationView_elevation, 0));
        }
        ViewCompat.setFitsSystemWindows((View)this, obtainStyledAttributes.getBoolean(R.styleable.NavigationView_android_fitsSystemWindows, false));
        mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NavigationView_android_maxWidth, 0);
        ColorStateList itemIconTintList;
        if (obtainStyledAttributes.hasValue(R.styleable.NavigationView_itemIconTint)) {
            itemIconTintList = obtainStyledAttributes.getColorStateList(R.styleable.NavigationView_itemIconTint);
        }
        else {
            itemIconTintList = this.createDefaultColorStateList(16842808);
        }
        final boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.NavigationView_itemTextAppearance);
        int resourceId = 0;
        boolean b = false;
        if (hasValue) {
            resourceId = obtainStyledAttributes.getResourceId(R.styleable.NavigationView_itemTextAppearance, 0);
            b = true;
        }
        final boolean hasValue2 = obtainStyledAttributes.hasValue(R.styleable.NavigationView_itemTextColor);
        ColorStateList itemTextColor = null;
        if (hasValue2) {
            itemTextColor = obtainStyledAttributes.getColorStateList(R.styleable.NavigationView_itemTextColor);
        }
        if (!b && itemTextColor == null) {
            itemTextColor = this.createDefaultColorStateList(16842806);
        }
        final Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.NavigationView_itemBackground);
        mMenu.setCallback((MenuBuilder.Callback)new MenuBuilder.Callback() {
            final /* synthetic */ NavigationView this$0;
            
            NavigationView$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public boolean onMenuItemSelected(final MenuBuilder menuBuilder, final MenuItem menuItem) {
                return mListener != null && mListener.onNavigationItemSelected(menuItem);
            }
            
            @Override
            public void onMenuModeChange(final MenuBuilder menuBuilder) {
            }
        });
        mPresenter.setId(1);
        mPresenter.initForMenu(context, mMenu);
        mPresenter.setItemIconTintList(itemIconTintList);
        if (b) {
            mPresenter.setItemTextAppearance(resourceId);
        }
        mPresenter.setItemTextColor(itemTextColor);
        mPresenter.setItemBackground(drawable);
        mMenu.addMenuPresenter(mPresenter);
        this.addView((View)mPresenter.getMenuView((ViewGroup)this));
        if (obtainStyledAttributes.hasValue(R.styleable.NavigationView_menu)) {
            this.inflateMenu(obtainStyledAttributes.getResourceId(R.styleable.NavigationView_menu, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.NavigationView_headerLayout)) {
            this.inflateHeaderView(obtainStyledAttributes.getResourceId(R.styleable.NavigationView_headerLayout, 0));
        }
        obtainStyledAttributes.recycle();
    }
    
    static /* synthetic */ OnNavigationItemSelectedListener access$000(final NavigationView navigationView) {
        return navigationView.mListener;
    }
    
    private ColorStateList createDefaultColorStateList(final int n) {
        final TypedValue typedValue = new TypedValue();
        if (this.getContext().getTheme().resolveAttribute(n, typedValue, true)) {
            final ColorStateList colorStateList = this.getResources().getColorStateList(typedValue.resourceId);
            if (this.getContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
                final int data = typedValue.data;
                final int defaultColor = colorStateList.getDefaultColor();
                return new ColorStateList(new int[][] { DISABLED_STATE_SET, CHECKED_STATE_SET, NavigationView.EMPTY_STATE_SET }, new int[] { colorStateList.getColorForState(DISABLED_STATE_SET, defaultColor), data, defaultColor });
            }
        }
        return null;
    }
    
    private MenuInflater getMenuInflater() {
        if (mMenuInflater == null) {
            mMenuInflater = new SupportMenuInflater(this.getContext());
        }
        return mMenuInflater;
    }
    
    public void addHeaderView(@NonNull final View view) {
        mPresenter.addHeaderView(view);
    }
    
    public int getHeaderCount() {
        return mPresenter.getHeaderCount();
    }
    
    public View getHeaderView(final int n) {
        return mPresenter.getHeaderView(n);
    }
    
    @Nullable
    public Drawable getItemBackground() {
        return mPresenter.getItemBackground();
    }
    
    @Nullable
    public ColorStateList getItemIconTintList() {
        return mPresenter.getItemTintList();
    }
    
    @Nullable
    public ColorStateList getItemTextColor() {
        return mPresenter.getItemTextColor();
    }
    
    public Menu getMenu() {
        return (Menu)mMenu;
    }
    
    public View inflateHeaderView(@LayoutRes final int n) {
        return mPresenter.inflateHeaderView(n);
    }
    
    public void inflateMenu(final int n) {
        mPresenter.setUpdateSuspended(true);
        this.getMenuInflater().inflate(n, (Menu)mMenu);
        mPresenter.setUpdateSuspended(false);
        mPresenter.updateMenuView(false);
    }
    
    @Override
    protected void onInsetsChanged(final Rect rect) {
        mPresenter.setPaddingTopDefault(rect.top);
    }
    
    protected void onMeasure(int n, final int n2) {
        switch (View$MeasureSpec.getMode(n)) {
            case Integer.MIN_VALUE:
                n = View$MeasureSpec.makeMeasureSpec(Math.min(View$MeasureSpec.getSize(n), mMaxWidth), 1073741824);
                break;
            case 0:
                n = View$MeasureSpec.makeMeasureSpec(mMaxWidth, 1073741824);
                break;
        }
        super.onMeasure(n, n2);
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        final SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        mMenu.restorePresenterStates(savedState.menuState);
    }
    
    protected Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.menuState = new Bundle();
        mMenu.savePresenterStates(savedState.menuState);
        return (Parcelable)savedState;
    }
    
    public void removeHeaderView(@NonNull final View view) {
        mPresenter.removeHeaderView(view);
    }
    
    public void setCheckedItem(@IdRes final int n) {
        final MenuItem item = mMenu.findItem(n);
        if (item != null) {
            mPresenter.setCheckedItem((MenuItemImpl)item);
        }
    }
    
    public void setItemBackground(@Nullable final Drawable itemBackground) {
        mPresenter.setItemBackground(itemBackground);
    }
    
    public void setItemBackgroundResource(@DrawableRes final int n) {
        this.setItemBackground(ContextCompat.getDrawable(this.getContext(), n));
    }
    
    public void setItemIconTintList(@Nullable final ColorStateList itemIconTintList) {
        mPresenter.setItemIconTintList(itemIconTintList);
    }
    
    public void setItemTextAppearance(@StyleRes final int itemTextAppearance) {
        mPresenter.setItemTextAppearance(itemTextAppearance);
    }
    
    public void setItemTextColor(@Nullable final ColorStateList itemTextColor) {
        mPresenter.setItemTextColor(itemTextColor);
    }
    
    public void setNavigationItemSelectedListener(final OnNavigationItemSelectedListener mListener) {
        this.mListener = mListener;
    }
}
