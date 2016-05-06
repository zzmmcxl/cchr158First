package android.support.design.widget;

import android.view.ViewParent;
import android.support.design.R;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.support.v4.widget.TextViewCompat;
import android.view.View$MeasureSpec;
import android.widget.Toast;
import android.view.accessibility.AccessibilityNodeInfo;
import android.annotation.TargetApi;
import android.support.v7.app.ActionBar;
import android.view.accessibility.AccessibilityEvent;
import android.view.ViewGroup$MarginLayoutParams;
import android.text.TextUtils;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatDrawableManager;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View$OnLongClickListener;
import android.widget.LinearLayout;

class TabView extends LinearLayout implements View$OnLongClickListener
{
    private ImageView mCustomIconView;
    private TextView mCustomTextView;
    private View mCustomView;
    private int mDefaultMaxLines;
    private ImageView mIconView;
    private Tab mTab;
    private TextView mTextView;
    final /* synthetic */ TabLayout this$0;
    
    public TabView(final TabLayout this$0, final Context context) {
        this$0 = this$0;
        super(context);
        mDefaultMaxLines = 2;
        if (TabLayout.access$900(this$0) != 0) {
            this.setBackgroundDrawable(AppCompatDrawableManager.get().getDrawable(context, TabLayout.access$900(this$0)));
        }
        ViewCompat.setPaddingRelative((View)this, TabLayout.access$1000(this$0), TabLayout.access$1100(this$0), TabLayout.access$1200(this$0), TabLayout.access$1300(this$0));
        this.setGravity(17);
        this.setOrientation(1);
        this.setClickable(true);
    }
    
    static /* synthetic */ void access$700(final TabView tabView, final Tab tab) {
        tabView.setTab(tab);
    }
    
    static /* synthetic */ void access$800(final TabView tabView) {
        tabView.reset();
    }
    
    private float approximateLineWidth(final Layout layout, final int n, final float n2) {
        return layout.getLineWidth(n) * (n2 / layout.getPaint().getTextSize());
    }
    
    private void reset() {
        this.setTab(null);
        this.setSelected(false);
    }
    
    private void setTab(@Nullable final Tab mTab) {
        if (mTab != this.mTab) {
            this.mTab = mTab;
            this.update();
        }
    }
    
    private void updateTextAndIcon(@Nullable final TextView textView, @Nullable final ImageView imageView) {
        Drawable icon;
        if (mTab != null) {
            icon = mTab.getIcon();
        }
        else {
            icon = null;
        }
        CharSequence text;
        if (mTab != null) {
            text = mTab.getText();
        }
        else {
            text = null;
        }
        CharSequence contentDescription;
        if (mTab != null) {
            contentDescription = mTab.getContentDescription();
        }
        else {
            contentDescription = null;
        }
        if (imageView != null) {
            if (icon != null) {
                imageView.setImageDrawable(icon);
                imageView.setVisibility(0);
                this.setVisibility(0);
            }
            else {
                imageView.setVisibility(8);
                imageView.setImageDrawable((Drawable)null);
            }
            imageView.setContentDescription(contentDescription);
        }
        boolean b;
        if (!TextUtils.isEmpty(text)) {
            b = true;
        }
        else {
            b = false;
        }
        if (textView != null) {
            if (b) {
                textView.setText(text);
                textView.setVisibility(0);
                this.setVisibility(0);
            }
            else {
                textView.setVisibility(8);
                textView.setText((CharSequence)null);
            }
            textView.setContentDescription(contentDescription);
        }
        if (imageView != null) {
            final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)imageView.getLayoutParams();
            int access$2100 = 0;
            if (b) {
                final int visibility = imageView.getVisibility();
                access$2100 = 0;
                if (visibility == 0) {
                    access$2100 = TabLayout.access$2100(this$0, 8);
                }
            }
            if (access$2100 != viewGroup$MarginLayoutParams.bottomMargin) {
                viewGroup$MarginLayoutParams.bottomMargin = access$2100;
                imageView.requestLayout();
            }
        }
        if (!b && !TextUtils.isEmpty(contentDescription)) {
            this.setOnLongClickListener((View$OnLongClickListener)this);
            return;
        }
        this.setOnLongClickListener((View$OnLongClickListener)null);
        this.setLongClickable(false);
    }
    
    public Tab getTab() {
        return mTab;
    }
    
    @TargetApi(14)
    public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)ActionBar.Tab.class.getName());
    }
    
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(final AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)ActionBar.Tab.class.getName());
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
        final int size = View$MeasureSpec.getSize(n);
        final int mode = View$MeasureSpec.getMode(n);
        final int access$1400 = TabLayout.access$1400(this$0);
        int measureSpec;
        if (access$1400 > 0 && (mode == 0 || size > access$1400)) {
            measureSpec = View$MeasureSpec.makeMeasureSpec(TabLayout.access$1500(this$0), Integer.MIN_VALUE);
        }
        else {
            measureSpec = n;
        }
        super.onMeasure(measureSpec, n2);
        if (mTextView != null) {
            this.getResources();
            float n3 = TabLayout.access$1600(this$0);
            int mDefaultMaxLines = this.mDefaultMaxLines;
            if (mIconView != null && mIconView.getVisibility() == 0) {
                mDefaultMaxLines = 1;
            }
            else if (mTextView != null && mTextView.getLineCount() > 1) {
                n3 = TabLayout.access$1700(this$0);
            }
            final float textSize = mTextView.getTextSize();
            final int lineCount = mTextView.getLineCount();
            final int maxLines = TextViewCompat.getMaxLines(mTextView);
            if (n3 != textSize || (maxLines >= 0 && mDefaultMaxLines != maxLines)) {
                boolean b = true;
                if (TabLayout.access$1800(this$0) == 1 && n3 > textSize && lineCount == 1) {
                    final Layout layout = mTextView.getLayout();
                    if (layout == null || this.approximateLineWidth(layout, 0, n3) > layout.getWidth()) {
                        b = false;
                    }
                }
                if (b) {
                    mTextView.setTextSize(0, n3);
                    mTextView.setMaxLines(mDefaultMaxLines);
                    super.onMeasure(measureSpec, n2);
                }
            }
        }
    }
    
    public boolean performClick() {
        boolean performClick = super.performClick();
        if (mTab != null) {
            mTab.select();
            performClick = true;
        }
        return performClick;
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
            if (mTextView != null) {
                mTextView.setSelected(selected);
            }
            if (mIconView != null) {
                mIconView.setSelected(selected);
            }
        }
    }
    
    final void update() {
        final Tab mTab = this.mTab;
        View customView;
        if (mTab != null) {
            customView = mTab.getCustomView();
        }
        else {
            customView = null;
        }
        if (customView != null) {
            final ViewParent parent = customView.getParent();
            if (parent != this) {
                if (parent != null) {
                    ((ViewGroup)parent).removeView(customView);
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
            mCustomTextView = (TextView)customView.findViewById(16908308);
            if (mCustomTextView != null) {
                mDefaultMaxLines = TextViewCompat.getMaxLines(mCustomTextView);
            }
            mCustomIconView = (ImageView)customView.findViewById(16908294);
        }
        else {
            if (mCustomView != null) {
                this.removeView(mCustomView);
                mCustomView = null;
            }
            mCustomTextView = null;
            mCustomIconView = null;
        }
        if (mCustomView == null) {
            if (mIconView == null) {
                final ImageView mIconView = (ImageView)LayoutInflater.from(this.getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup)this, false);
                this.addView((View)mIconView, 0);
                this.mIconView = mIconView;
            }
            if (mTextView == null) {
                final TextView mTextView = (TextView)LayoutInflater.from(this.getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup)this, false);
                this.addView((View)mTextView);
                this.mTextView = mTextView;
                mDefaultMaxLines = TextViewCompat.getMaxLines(this.mTextView);
            }
            mTextView.setTextAppearance(this.getContext(), TabLayout.access$1900(this$0));
            if (TabLayout.access$2000(this$0) != null) {
                mTextView.setTextColor(TabLayout.access$2000(this$0));
            }
            this.updateTextAndIcon(mTextView, mIconView);
        }
        else if (mCustomTextView != null || mCustomIconView != null) {
            this.updateTextAndIcon(mCustomTextView, mCustomIconView);
        }
    }
}
