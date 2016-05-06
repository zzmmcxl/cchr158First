package android.support.v7.widget;

import android.view.MenuItem;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager;
import android.view.MenuItem$OnMenuItemClickListener;
import android.view.SubMenu;
import android.support.v7.appcompat.R;
import android.util.TypedValue;
import android.view.View;
import android.os.Build$VERSION;
import android.content.Intent;
import android.content.Context;
import android.support.v4.view.ActionProvider;

public class ShareActionProvider extends ActionProvider
{
    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
    private final Context mContext;
    private int mMaxShownActivityCount;
    private ActivityChooserModel.OnChooseActivityListener mOnChooseActivityListener;
    private final ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener;
    private OnShareTargetSelectedListener mOnShareTargetSelectedListener;
    private String mShareHistoryFileName;
    
    public ShareActionProvider(final Context mContext) {
        super(mContext);
        mMaxShownActivityCount = 4;
        mOnMenuItemClickListener = new ShareMenuItemOnMenuItemClickListener(this);
        mShareHistoryFileName = "share_history.xml";
        mContext = mContext;
    }
    
    static /* synthetic */ Context access$100(final ShareActionProvider shareActionProvider) {
        return shareActionProvider.mContext;
    }
    
    static /* synthetic */ String access$200(final ShareActionProvider shareActionProvider) {
        return shareActionProvider.mShareHistoryFileName;
    }
    
    static /* synthetic */ void access$300(final ShareActionProvider shareActionProvider, final Intent intent) {
        shareActionProvider.updateIntent(intent);
    }
    
    static /* synthetic */ OnShareTargetSelectedListener access$500(final ShareActionProvider shareActionProvider) {
        return shareActionProvider.mOnShareTargetSelectedListener;
    }
    
    private void setActivityChooserPolicyIfNeeded() {
        if (mOnShareTargetSelectedListener == null) {
            return;
        }
        if (mOnChooseActivityListener == null) {
            mOnChooseActivityListener = new ShareActivityChooserModelPolicy(this);
        }
        ActivityChooserModel.get(mContext, mShareHistoryFileName).setOnChooseActivityListener(mOnChooseActivityListener);
    }
    
    private void updateIntent(final Intent intent) {
        if (Build$VERSION.SDK_INT >= 21) {
            intent.addFlags(134742016);
            return;
        }
        intent.addFlags(524288);
    }
    
    @Override
    public boolean hasSubMenu() {
        return true;
    }
    
    @Override
    public View onCreateActionView() {
        final ActivityChooserView activityChooserView = new ActivityChooserView(mContext);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(ActivityChooserModel.get(mContext, mShareHistoryFileName));
        }
        final TypedValue typedValue = new TypedValue();
        mContext.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(AppCompatDrawableManager.get().getDrawable(mContext, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
        return (View)activityChooserView;
    }
    
    @Override
    public void onPrepareSubMenu(final SubMenu subMenu) {
        subMenu.clear();
        final ActivityChooserModel value = ActivityChooserModel.get(mContext, mShareHistoryFileName);
        final PackageManager packageManager = mContext.getPackageManager();
        final int activityCount = value.getActivityCount();
        final int min = Math.min(activityCount, mMaxShownActivityCount);
        for (int i = 0; i < min; ++i) {
            final ResolveInfo activity = value.getActivity(i);
            subMenu.add(0, i, i, activity.loadLabel(packageManager)).setIcon(activity.loadIcon(packageManager)).setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)mOnMenuItemClickListener);
        }
        if (min < activityCount) {
            final SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, (CharSequence)mContext.getString(R.string.abc_activity_chooser_view_see_all));
            for (int j = 0; j < activityCount; ++j) {
                final ResolveInfo activity2 = value.getActivity(j);
                addSubMenu.add(0, j, j, activity2.loadLabel(packageManager)).setIcon(activity2.loadIcon(packageManager)).setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)mOnMenuItemClickListener);
            }
        }
    }
    
    public void setOnShareTargetSelectedListener(final OnShareTargetSelectedListener mOnShareTargetSelectedListener) {
        this.mOnShareTargetSelectedListener = mOnShareTargetSelectedListener;
        this.setActivityChooserPolicyIfNeeded();
    }
    
    public void setShareHistoryFileName(final String mShareHistoryFileName) {
        this.mShareHistoryFileName = mShareHistoryFileName;
        this.setActivityChooserPolicyIfNeeded();
    }
    
    public void setShareIntent(final Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                this.updateIntent(intent);
            }
        }
        ActivityChooserModel.get(mContext, mShareHistoryFileName).setIntent(intent);
    }
}
