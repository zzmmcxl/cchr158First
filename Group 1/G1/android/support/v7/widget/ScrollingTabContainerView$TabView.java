package android.support.v7.widget;

import android.view.ViewParent;
import android.text.TextUtils$TruncateAt;
import android.text.TextUtils;
import android.view.ViewGroup$LayoutParams;
import android.graphics.drawable.Drawable;
import android.view.View$MeasureSpec;
import android.widget.Toast;
import android.os.Build$VERSION;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityEvent;
import android.util.AttributeSet;
import android.support.v7.appcompat.R;
import android.content.Context;
import android.widget.TextView;
import android.support.v7.app.ActionBar;
import android.widget.ImageView;
import android.view.View;
import android.view.View$OnLongClickListener;

private class TabView extends LinearLayoutCompat implements View$OnLongClickListener
{
    private final int[] BG_ATTRS;
    private View mCustomView;
    private ImageView mIconView;
    private ActionBar.Tab mTab;
    private TextView mTextView;
    final /* synthetic */ ScrollingTabContainerView this$0;
    
    public TabView(final ScrollingTabContainerView this$0, final Context context, final ActionBar.Tab mTab, final boolean b) {
        this$0 = this$0;
        super(context, null, R.attr.actionBarTabStyle);
        BG_ATTRS = new int[] { 16842964 };
        mTab = mTab;
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, null, BG_ATTRS, R.attr.actionBarTabStyle, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
        }
        obtainStyledAttributes.recycle();
        if (b) {
            this.setGravity(8388627);
        }
        this.update();
    }
    
    public void bindTab(final ActionBar.Tab mTab) {
        this.mTab = mTab;
        this.update();
    }
    
    public ActionBar.Tab getTab() {
        return mTab;
    }
    
    @Override
    public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)ActionBar.Tab.class.getName());
    }
    
    @Override
    public void onInitializeAccessibilityNodeInfo(final AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (Build$VERSION.SDK_INT >= 14) {
            accessibilityNodeInfo.setClassName((CharSequence)ActionBar.Tab.class.getName());
        }
    }
    
    public boolean onLongClick(final View view) {
        final int[] array = new int[2];
        this.getLocationOnScreen(array);
        final Context context = this.getContext();
        final int width = this.getWidth();
        final int height = this.getHeight();
        final int widthPixels = context.getResources().getDisplayMetrics().widthPixels;
        final Toast text = Toast.makeText(context, mTab.getContentDescription(), 0);
        text.setGravity(49, array[0] + width / 2 - widthPixels / 2, height);
        text.show();
        return true;
    }
    
    public void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        if (mMaxTabWidth > 0 && this.getMeasuredWidth() > mMaxTabWidth) {
            super.onMeasure(View$MeasureSpec.makeMeasureSpec(mMaxTabWidth, 1073741824), n2);
        }
    }
    
    public void setSelected(final boolean selected) {
        boolean b;
        if (this.isSelected() != selected) {
            b = true;
        }
        else {
            b = false;
        }
        super.setSelected(selected);
        if (b && selected) {
            this.sendAccessibilityEvent(4);
        }
    }
    
    public void update() {
        final ActionBar.Tab mTab = this.mTab;
        final View customView = mTab.getCustomView();
        if (customView != null) {
            final ViewParent parent = customView.getParent();
            if (parent != this) {
                if (parent != null) {
                    ((TabView)parent).removeView(customView);
                }
                this.addView(customView);
            }
            mCustomView = customView;
            if (mTextView != null) {
                mTextView.setVisibility(8);
            }
            if (mIconView != null) {
                mIconView.setVisibility(8);
                mIconView.setImageDrawable((Drawable)null);
            }
            return;
        }
        if (mCustomView != null) {
            this.removeView(mCustomView);
            mCustomView = null;
        }
        final Drawable icon = mTab.getIcon();
        final CharSequence text = mTab.getText();
        if (icon != null) {
            if (mIconView == null) {
                final ImageView mIconView = new ImageView(this.getContext());
                final LayoutParams layoutParams = new LayoutParams(-2, -2);
                layoutParams.gravity = 16;
                mIconView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                this.addView((View)mIconView, 0);
                this.mIconView = mIconView;
            }
            mIconView.setImageDrawable(icon);
            mIconView.setVisibility(0);
        }
        else if (mIconView != null) {
            mIconView.setVisibility(8);
            mIconView.setImageDrawable((Drawable)null);
        }
        boolean b;
        if (!TextUtils.isEmpty(text)) {
            b = true;
        }
        else {
            b = false;
        }
        if (b) {
            if (mTextView == null) {
                final AppCompatTextView mTextView = new AppCompatTextView(this.getContext(), null, R.attr.actionBarTabTextStyle);
                mTextView.setEllipsize(TextUtils$TruncateAt.END);
                final LayoutParams layoutParams2 = new LayoutParams(-2, -2);
                layoutParams2.gravity = 16;
                mTextView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
                this.addView((View)mTextView);
                this.mTextView = mTextView;
            }
            mTextView.setText(text);
            mTextView.setVisibility(0);
        }
        else if (mTextView != null) {
            mTextView.setVisibility(8);
            mTextView.setText((CharSequence)null);
        }
        if (mIconView != null) {
            mIconView.setContentDescription(mTab.getContentDescription());
        }
        if (!b && !TextUtils.isEmpty(mTab.getContentDescription())) {
            this.setOnLongClickListener((View$OnLongClickListener)this);
            return;
        }
        this.setOnLongClickListener((View$OnLongClickListener)null);
        this.setLongClickable(false);
    }
}
