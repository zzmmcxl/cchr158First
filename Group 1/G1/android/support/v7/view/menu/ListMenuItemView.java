package android.support.v7.view.menu;

import android.widget.CompoundButton;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.RadioButton;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.content.Context;
import android.widget.CheckBox;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;

public class ListMenuItemView extends LinearLayout implements ItemView
{
    private static final String TAG = "ListMenuItemView";
    private Drawable mBackground;
    private CheckBox mCheckBox;
    private Context mContext;
    private boolean mForceShowIcon;
    private ImageView mIconView;
    private LayoutInflater mInflater;
    private MenuItemImpl mItemData;
    private int mMenuType;
    private boolean mPreserveIconSpacing;
    private RadioButton mRadioButton;
    private TextView mShortcutView;
    private int mTextAppearance;
    private Context mTextAppearanceContext;
    private TextView mTitleView;
    
    public ListMenuItemView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public ListMenuItemView(final Context context, final AttributeSet set, final int n) {
        super(context, set);
        mContext = context;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.MenuView, n, 0);
        mBackground = obtainStyledAttributes.getDrawable(R.styleable.MenuView_android_itemBackground);
        mTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
        mPreserveIconSpacing = obtainStyledAttributes.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
        mTextAppearanceContext = context;
        obtainStyledAttributes.recycle();
    }
    
    private LayoutInflater getInflater() {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(mContext);
        }
        return mInflater;
    }
    
    private void insertCheckBox() {
        this.addView((View)(mCheckBox = (CheckBox)this.getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup)this, false)));
    }
    
    private void insertIconView() {
        this.addView((View)(mIconView = (ImageView)this.getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup)this, false)), 0);
    }
    
    private void insertRadioButton() {
        this.addView((View)(mRadioButton = (RadioButton)this.getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup)this, false)));
    }
    
    public MenuItemImpl getItemData() {
        return mItemData;
    }
    
    public void initialize(final MenuItemImpl mItemData, final int mMenuType) {
        this.mItemData = mItemData;
        this.mMenuType = mMenuType;
        int visibility;
        if (mItemData.isVisible()) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        this.setVisibility(visibility);
        this.setTitle(mItemData.getTitleForItemView((ItemView)this));
        this.setCheckable(mItemData.isCheckable());
        this.setShortcut(mItemData.shouldShowShortcut(), mItemData.getShortcut());
        this.setIcon(mItemData.getIcon());
        ((MenuView.ItemView)this).setEnabled(mItemData.isEnabled());
    }
    
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.setBackgroundDrawable(mBackground);
        mTitleView = (TextView)this.findViewById(R.id.title);
        if (mTextAppearance != -1) {
            mTitleView.setTextAppearance(mTextAppearanceContext, mTextAppearance);
        }
        mShortcutView = (TextView)this.findViewById(R.id.shortcut);
    }
    
    protected void onMeasure(final int n, final int n2) {
        if (mIconView != null && mPreserveIconSpacing) {
            final ViewGroup$LayoutParams layoutParams = this.getLayoutParams();
            final LinearLayout$LayoutParams linearLayout$LayoutParams = (LinearLayout$LayoutParams)mIconView.getLayoutParams();
            if (layoutParams.height > 0 && linearLayout$LayoutParams.width <= 0) {
                linearLayout$LayoutParams.width = layoutParams.height;
            }
        }
        super.onMeasure(n, n2);
    }
    
    public boolean prefersCondensedTitle() {
        return false;
    }
    
    public void setCheckable(final boolean b) {
        if (b || mRadioButton != null || mCheckBox != null) {
            Object o;
            Object o2;
            if (mItemData.isExclusiveCheckable()) {
                if (mRadioButton == null) {
                    this.insertRadioButton();
                }
                o = mRadioButton;
                o2 = mCheckBox;
            }
            else {
                if (mCheckBox == null) {
                    this.insertCheckBox();
                }
                o = mCheckBox;
                o2 = mRadioButton;
            }
            if (b) {
                ((CompoundButton)o).setChecked(mItemData.isChecked());
                int visibility;
                if (b) {
                    visibility = 0;
                }
                else {
                    visibility = 8;
                }
                if (((CompoundButton)o).getVisibility() != visibility) {
                    ((CompoundButton)o).setVisibility(visibility);
                }
                if (o2 != null && ((CompoundButton)o2).getVisibility() != 8) {
                    ((CompoundButton)o2).setVisibility(8);
                }
            }
            else {
                if (mCheckBox != null) {
                    mCheckBox.setVisibility(8);
                }
                if (mRadioButton != null) {
                    mRadioButton.setVisibility(8);
                }
            }
        }
    }
    
    public void setChecked(final boolean checked) {
        Object o;
        if (mItemData.isExclusiveCheckable()) {
            if (mRadioButton == null) {
                this.insertRadioButton();
            }
            o = mRadioButton;
        }
        else {
            if (mCheckBox == null) {
                this.insertCheckBox();
            }
            o = mCheckBox;
        }
        ((CompoundButton)o).setChecked(checked);
    }
    
    public void setForceShowIcon(final boolean b) {
        mForceShowIcon = b;
        mPreserveIconSpacing = b;
    }
    
    public void setIcon(Drawable imageDrawable) {
        boolean b;
        if (mItemData.shouldShowIcon() || mForceShowIcon) {
            b = true;
        }
        else {
            b = false;
        }
        if ((b || mPreserveIconSpacing) && (mIconView != null || imageDrawable != null || mPreserveIconSpacing)) {
            if (mIconView == null) {
                this.insertIconView();
            }
            if (imageDrawable == null && !mPreserveIconSpacing) {
                mIconView.setVisibility(8);
                return;
            }
            final ImageView mIconView = this.mIconView;
            if (!b) {
                imageDrawable = null;
            }
            mIconView.setImageDrawable(imageDrawable);
            if (this.mIconView.getVisibility() != 0) {
                this.mIconView.setVisibility(0);
            }
        }
    }
    
    public void setShortcut(final boolean b, final char c) {
        int visibility;
        if (b && mItemData.shouldShowShortcut()) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        if (visibility == 0) {
            mShortcutView.setText((CharSequence)mItemData.getShortcutLabel());
        }
        if (mShortcutView.getVisibility() != visibility) {
            mShortcutView.setVisibility(visibility);
        }
    }
    
    public void setTitle(final CharSequence text) {
        if (text != null) {
            mTitleView.setText(text);
            if (mTitleView.getVisibility() != 0) {
                mTitleView.setVisibility(0);
            }
        }
        else if (mTitleView.getVisibility() != 8) {
            mTitleView.setVisibility(8);
        }
    }
    
    public boolean showsIcon() {
        return mForceShowIcon;
    }
}
