package android.support.v4.app;

import android.support.annotation.NonNull;
import android.content.Context;
import android.support.annotation.Nullable;
import android.content.DialogInterface;
import android.view.View;
import android.app.Activity;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.app.Dialog;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnCancelListener;

public class DialogFragment extends Fragment implements DialogInterface$OnCancelListener, DialogInterface$OnDismissListener
{
    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    int mBackStackId;
    boolean mCancelable;
    Dialog mDialog;
    boolean mDismissed;
    boolean mShownByMe;
    boolean mShowsDialog;
    int mStyle;
    int mTheme;
    boolean mViewDestroyed;
    
    public DialogFragment() {
        super();
        mStyle = 0;
        mTheme = 0;
        mCancelable = true;
        mShowsDialog = true;
        mBackStackId = -1;
    }
    
    public void dismiss() {
        this.dismissInternal(false);
    }
    
    public void dismissAllowingStateLoss() {
        this.dismissInternal(true);
    }
    
    void dismissInternal(final boolean b) {
        if (mDismissed) {
            return;
        }
        mDismissed = true;
        mShownByMe = false;
        if (mDialog != null) {
            mDialog.dismiss();
            mDialog = null;
        }
        mViewDestroyed = true;
        if (mBackStackId >= 0) {
            this.getFragmentManager().popBackStack(mBackStackId, 1);
            mBackStackId = -1;
            return;
        }
        final FragmentTransaction beginTransaction = this.getFragmentManager().beginTransaction();
        beginTransaction.remove(this);
        if (b) {
            beginTransaction.commitAllowingStateLoss();
            return;
        }
        beginTransaction.commit();
    }
    
    public Dialog getDialog() {
        return mDialog;
    }
    
    @Override
    public LayoutInflater getLayoutInflater(final Bundle bundle) {
        if (!mShowsDialog) {
            return super.getLayoutInflater(bundle);
        }
        mDialog = this.onCreateDialog(bundle);
        if (mDialog != null) {
            this.setupDialog(mDialog, mStyle);
            return (LayoutInflater)mDialog.getContext().getSystemService("layout_inflater");
        }
        return (LayoutInflater)this.mHost.getContext().getSystemService("layout_inflater");
    }
    
    public boolean getShowsDialog() {
        return mShowsDialog;
    }
    
    @StyleRes
    public int getTheme() {
        return mTheme;
    }
    
    public boolean isCancelable() {
        return mCancelable;
    }
    
    @Override
    public void onActivityCreated(final Bundle bundle) {
        super.onActivityCreated(bundle);
        if (mShowsDialog) {
            final View view = this.getView();
            if (view != null) {
                if (view.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                mDialog.setContentView(view);
            }
            mDialog.setOwnerActivity((Activity)this.getActivity());
            mDialog.setCancelable(mCancelable);
            mDialog.setOnCancelListener((DialogInterface$OnCancelListener)this);
            mDialog.setOnDismissListener((DialogInterface$OnDismissListener)this);
            if (bundle != null) {
                final Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    mDialog.onRestoreInstanceState(bundle2);
                }
            }
        }
    }
    
    @Override
    public void onAttach(final Activity activity) {
        super.onAttach(activity);
        if (!mShownByMe) {
            mDismissed = false;
        }
    }
    
    public void onCancel(final DialogInterface dialogInterface) {
    }
    
    @Override
    public void onCreate(@Nullable final Bundle bundle) {
        super.onCreate(bundle);
        mShowsDialog = (this.mContainerId == 0);
        if (bundle != null) {
            mStyle = bundle.getInt("android:style", 0);
            mTheme = bundle.getInt("android:theme", 0);
            mCancelable = bundle.getBoolean("android:cancelable", true);
            mShowsDialog = bundle.getBoolean("android:showsDialog", mShowsDialog);
            mBackStackId = bundle.getInt("android:backStackId", -1);
        }
    }
    
    @NonNull
    public Dialog onCreateDialog(final Bundle bundle) {
        return new Dialog((Context)this.getActivity(), this.getTheme());
    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mDialog != null) {
            mViewDestroyed = true;
            mDialog.dismiss();
            mDialog = null;
        }
    }
    
    @Override
    public void onDetach() {
        super.onDetach();
        if (!mShownByMe && !mDismissed) {
            mDismissed = true;
        }
    }
    
    public void onDismiss(final DialogInterface dialogInterface) {
        if (!mViewDestroyed) {
            this.dismissInternal(true);
        }
    }
    
    @Override
    public void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (mDialog != null) {
            final Bundle onSaveInstanceState = mDialog.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (mStyle != 0) {
            bundle.putInt("android:style", mStyle);
        }
        if (mTheme != 0) {
            bundle.putInt("android:theme", mTheme);
        }
        if (!mCancelable) {
            bundle.putBoolean("android:cancelable", mCancelable);
        }
        if (!mShowsDialog) {
            bundle.putBoolean("android:showsDialog", mShowsDialog);
        }
        if (mBackStackId != -1) {
            bundle.putInt("android:backStackId", mBackStackId);
        }
    }
    
    @Override
    public void onStart() {
        super.onStart();
        if (mDialog != null) {
            mViewDestroyed = false;
            mDialog.show();
        }
    }
    
    @Override
    public void onStop() {
        super.onStop();
        if (mDialog != null) {
            mDialog.hide();
        }
    }
    
    public void setCancelable(final boolean b) {
        mCancelable = b;
        if (mDialog != null) {
            mDialog.setCancelable(b);
        }
    }
    
    public void setShowsDialog(final boolean mShowsDialog) {
        this.mShowsDialog = mShowsDialog;
    }
    
    public void setStyle(final int mStyle, @StyleRes final int mTheme) {
        this.mStyle = mStyle;
        if (this.mStyle == 2 || this.mStyle == 3) {
            this.mTheme = 16973913;
        }
        if (mTheme != 0) {
            this.mTheme = mTheme;
        }
    }
    
    public void setupDialog(final Dialog dialog, final int n) {
        switch (n) {
            default:
            case 3:
                dialog.getWindow().addFlags(24);
            case 1:
            case 2:
                dialog.requestWindowFeature(1);
        }
    }
    
    public int show(final FragmentTransaction fragmentTransaction, final String s) {
        mDismissed = false;
        mShownByMe = true;
        fragmentTransaction.add(this, s);
        mViewDestroyed = false;
        return mBackStackId = fragmentTransaction.commit();
    }
    
    public void show(final FragmentManager fragmentManager, final String s) {
        mDismissed = false;
        mShownByMe = true;
        final FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(this, s);
        beginTransaction.commit();
    }
}
