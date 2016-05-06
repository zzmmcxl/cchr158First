package android.support.design.widget;

import android.support.v7.widget.AppCompatDrawableManager;
import android.support.annotation.DrawableRes;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.annotation.Nullable;
import android.graphics.drawable.Drawable;
import android.view.View;

public static final class Tab
{
    public static final int INVALID_POSITION = -1;
    private CharSequence mContentDesc;
    private View mCustomView;
    private Drawable mIcon;
    private TabLayout mParent;
    private int mPosition;
    private Object mTag;
    private CharSequence mText;
    private TabView mView;
    
    private Tab() {
        super();
        this.mPosition = -1;
    }
    
    Tab(final TabLayout$1 animatorUpdateListener) {
        this();
    }
    
    static /* synthetic */ TabLayout access$000(final Tab tab) {
        return tab.mParent;
    }
    
    static /* synthetic */ TabLayout access$002(final Tab tab, final TabLayout mParent) {
        return tab.mParent = mParent;
    }
    
    static /* synthetic */ TabView access$200(final Tab tab) {
        return tab.mView;
    }
    
    static /* synthetic */ TabView access$202(final Tab tab, final TabView mView) {
        return tab.mView = mView;
    }
    
    static /* synthetic */ void access$300(final Tab tab) {
        tab.reset();
    }
    
    static /* synthetic */ void access$600(final Tab tab) {
        tab.updateView();
    }
    
    private void reset() {
        mParent = null;
        mView = null;
        mTag = null;
        mIcon = null;
        mText = null;
        mContentDesc = null;
        mPosition = -1;
        mCustomView = null;
    }
    
    private void updateView() {
        if (mView != null) {
            mView.update();
        }
    }
    
    @Nullable
    public CharSequence getContentDescription() {
        return mContentDesc;
    }
    
    @Nullable
    public View getCustomView() {
        return mCustomView;
    }
    
    @Nullable
    public Drawable getIcon() {
        return mIcon;
    }
    
    public int getPosition() {
        return mPosition;
    }
    
    @Nullable
    public Object getTag() {
        return mTag;
    }
    
    @Nullable
    public CharSequence getText() {
        return mText;
    }
    
    public boolean isSelected() {
        if (mParent == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
        return mParent.getSelectedTabPosition() == mPosition;
    }
    
    public void select() {
        if (mParent == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
        mParent.selectTab(this);
    }
    
    @NonNull
    public Tab setContentDescription(@StringRes final int n) {
        if (mParent == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
        return this.setContentDescription(mParent.getResources().getText(n));
    }
    
    @NonNull
    public Tab setContentDescription(@Nullable final CharSequence mContentDesc) {
        this.mContentDesc = mContentDesc;
        this.updateView();
        return this;
    }
    
    @NonNull
    public Tab setCustomView(@LayoutRes final int n) {
        return this.setCustomView(LayoutInflater.from(mView.getContext()).inflate(n, (ViewGroup)mView, false));
    }
    
    @NonNull
    public Tab setCustomView(@Nullable final View mCustomView) {
        this.mCustomView = mCustomView;
        this.updateView();
        return this;
    }
    
    @NonNull
    public Tab setIcon(@DrawableRes final int n) {
        if (mParent == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
        return this.setIcon(AppCompatDrawableManager.get().getDrawable(mParent.getContext(), n));
    }
    
    @NonNull
    public Tab setIcon(@Nullable final Drawable mIcon) {
        this.mIcon = mIcon;
        this.updateView();
        return this;
    }
    
    void setPosition(final int mPosition) {
        this.mPosition = mPosition;
    }
    
    @NonNull
    public Tab setTag(@Nullable final Object mTag) {
        this.mTag = mTag;
        return this;
    }
    
    @NonNull
    public Tab setText(@StringRes final int n) {
        if (mParent == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
        return this.setText(mParent.getResources().getText(n));
    }
    
    @NonNull
    public Tab setText(@Nullable final CharSequence mText) {
        this.mText = mText;
        this.updateView();
        return this;
    }
}
