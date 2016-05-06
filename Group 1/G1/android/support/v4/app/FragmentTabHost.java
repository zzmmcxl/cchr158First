package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import android.os.Parcelable;
import android.widget.TabHost$TabContentFactory;
import android.os.Bundle;
import android.widget.TabHost$TabSpec;
import android.content.res.TypedArray;
import android.widget.LinearLayout$LayoutParams;
import android.widget.TabWidget;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.widget.FrameLayout$LayoutParams;
import android.widget.LinearLayout;
import android.util.AttributeSet;
import java.util.ArrayList;
import android.widget.FrameLayout;
import android.content.Context;
import android.widget.TabHost$OnTabChangeListener;
import android.widget.TabHost;

public class FragmentTabHost extends TabHost implements TabHost$OnTabChangeListener
{
    private boolean mAttached;
    private int mContainerId;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private TabInfo mLastTab;
    private TabHost$OnTabChangeListener mOnTabChangeListener;
    private FrameLayout mRealTabContent;
    private final ArrayList<TabInfo> mTabs;
    
    public FragmentTabHost(final Context context) {
        super(context, (AttributeSet)null);
        mTabs = new ArrayList<TabInfo>();
        this.initFragmentTabHost(context, null);
    }
    
    public FragmentTabHost(final Context context, final AttributeSet set) {
        super(context, set);
        mTabs = new ArrayList<TabInfo>();
        this.initFragmentTabHost(context, set);
    }
    
    private FragmentTransaction doTabChanged(final String s, FragmentTransaction beginTransaction) {
        TabInfo mLastTab = null;
        for (int i = 0; i < mTabs.size(); ++i) {
            final TabInfo tabInfo = (TabInfo)mTabs.get(i);
            if (tabInfo.tag.equals(s)) {
                mLastTab = tabInfo;
            }
        }
        if (mLastTab == null) {
            throw new IllegalStateException("No tab known for tag " + s);
        }
        if (this.mLastTab != mLastTab) {
            if (beginTransaction == null) {
                beginTransaction = mFragmentManager.beginTransaction();
            }
            if (this.mLastTab != null && this.mLastTab.fragment != null) {
                beginTransaction.detach(this.mLastTab.fragment);
            }
            if (mLastTab != null) {
                if (mLastTab.fragment == null) {
                    mLastTab.fragment = Fragment.instantiate(mContext, mLastTab.clss.getName(), mLastTab.args);
                    beginTransaction.add(mContainerId, mLastTab.fragment, mLastTab.tag);
                }
                else {
                    beginTransaction.attach(mLastTab.fragment);
                }
            }
            this.mLastTab = mLastTab;
        }
        return beginTransaction;
    }
    
    private void ensureContent() {
        if (mRealTabContent == null) {
            mRealTabContent = (FrameLayout)this.findViewById(mContainerId);
            if (mRealTabContent == null) {
                throw new IllegalStateException("No tab content FrameLayout found for id " + mContainerId);
            }
        }
    }
    
    private void ensureHierarchy(final Context context) {
        if (this.findViewById(16908307) == null) {
            final LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            this.addView((View)linearLayout, (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-1, -1));
            final TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(16908307);
            tabWidget.setOrientation(0);
            linearLayout.addView((View)tabWidget, (ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -2, 0.0f));
            final FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(16908305);
            linearLayout.addView((View)frameLayout, (ViewGroup$LayoutParams)new LinearLayout$LayoutParams(0, 0, 0.0f));
            final FrameLayout mRealTabContent = new FrameLayout(context);
            (this.mRealTabContent = mRealTabContent).setId(mContainerId);
            linearLayout.addView((View)mRealTabContent, (ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, 0, 1.0f));
        }
    }
    
    private void initFragmentTabHost(final Context context, final AttributeSet set) {
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, new int[] { 16842995 }, 0, 0);
        mContainerId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener((TabHost$OnTabChangeListener)this);
    }
    
    public void addTab(final TabHost$TabSpec tabHost$TabSpec, final Class<?> clazz, final Bundle bundle) {
        tabHost$TabSpec.setContent((TabHost$TabContentFactory)new DummyTabFactory(mContext));
        final String tag = tabHost$TabSpec.getTag();
        final TabInfo tabInfo = new TabInfo(tag, clazz, bundle);
        if (mAttached) {
            tabInfo.fragment = mFragmentManager.findFragmentByTag(tag);
            if (tabInfo.fragment != null && !tabInfo.fragment.isDetached()) {
                final FragmentTransaction beginTransaction = mFragmentManager.beginTransaction();
                beginTransaction.detach(tabInfo.fragment);
                beginTransaction.commit();
            }
        }
        mTabs.add(tabInfo);
        this.addTab(tabHost$TabSpec);
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final String currentTabTag = this.getCurrentTabTag();
        FragmentTransaction beginTransaction = null;
        for (int i = 0; i < mTabs.size(); ++i) {
            final TabInfo mLastTab = (TabInfo)mTabs.get(i);
            mLastTab.fragment = mFragmentManager.findFragmentByTag(mLastTab.tag);
            if (mLastTab.fragment != null && !mLastTab.fragment.isDetached()) {
                if (mLastTab.tag.equals(currentTabTag)) {
                    this.mLastTab = mLastTab;
                }
                else {
                    if (beginTransaction == null) {
                        beginTransaction = mFragmentManager.beginTransaction();
                    }
                    beginTransaction.detach(mLastTab.fragment);
                }
            }
        }
        mAttached = true;
        final FragmentTransaction doTabChanged = this.doTabChanged(currentTabTag, beginTransaction);
        if (doTabChanged != null) {
            doTabChanged.commit();
            mFragmentManager.executePendingTransactions();
        }
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mAttached = false;
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        final SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.setCurrentTabByTag(savedState.curTab);
    }
    
    protected Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.curTab = this.getCurrentTabTag();
        return (Parcelable)savedState;
    }
    
    public void onTabChanged(final String s) {
        if (mAttached) {
            final FragmentTransaction doTabChanged = this.doTabChanged(s, null);
            if (doTabChanged != null) {
                doTabChanged.commit();
            }
        }
        if (mOnTabChangeListener != null) {
            mOnTabChangeListener.onTabChanged(s);
        }
    }
    
    public void setOnTabChangedListener(final TabHost$OnTabChangeListener mOnTabChangeListener) {
        this.mOnTabChangeListener = mOnTabChangeListener;
    }
    
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }
    
    public void setup(final Context mContext, final FragmentManager mFragmentManager) {
        this.ensureHierarchy(mContext);
        super.setup();
        this.mContext = mContext;
        this.mFragmentManager = mFragmentManager;
        this.ensureContent();
    }
    
    public void setup(final Context mContext, final FragmentManager mFragmentManager, final int n) {
        this.ensureHierarchy(mContext);
        super.setup();
        this.mContext = mContext;
        this.mFragmentManager = mFragmentManager;
        mContainerId = n;
        this.ensureContent();
        mRealTabContent.setId(n);
        if (this.getId() == -1) {
            this.setId(16908306);
        }
    }
}
