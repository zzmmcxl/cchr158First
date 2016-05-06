package android.support.v4.app;

import android.text.Html;
import android.support.annotation.StringRes;
import android.os.Parcelable;
import android.net.Uri;
import android.content.Intent;
import java.util.ArrayList;
import android.app.Activity;

public static class IntentBuilder
{
    private Activity mActivity;
    private ArrayList<String> mBccAddresses;
    private ArrayList<String> mCcAddresses;
    private CharSequence mChooserTitle;
    private Intent mIntent;
    private ArrayList<Uri> mStreams;
    private ArrayList<String> mToAddresses;
    
    private IntentBuilder(final Activity mActivity) {
        super();
        this.mActivity = mActivity;
        (this.mIntent = new Intent().setAction("android.intent.action.SEND")).putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", mActivity.getPackageName());
        this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", (Parcelable)mActivity.getComponentName());
        this.mIntent.addFlags(524288);
    }
    
    private void combineArrayExtra(final String s, final ArrayList<String> list) {
        final String[] stringArrayExtra = mIntent.getStringArrayExtra(s);
        int length;
        if (stringArrayExtra != null) {
            length = stringArrayExtra.length;
        }
        else {
            length = 0;
        }
        final String[] array = new String[length + list.size()];
        list.<String>toArray(array);
        if (stringArrayExtra != null) {
            System.arraycopy(stringArrayExtra, 0, array, list.size(), length);
        }
        mIntent.putExtra(s, array);
    }
    
    private void combineArrayExtra(final String s, final String[] array) {
        final Intent intent = this.getIntent();
        final String[] stringArrayExtra = intent.getStringArrayExtra(s);
        int length;
        if (stringArrayExtra != null) {
            length = stringArrayExtra.length;
        }
        else {
            length = 0;
        }
        final String[] array2 = new String[length + array.length];
        if (stringArrayExtra != null) {
            System.arraycopy(stringArrayExtra, 0, array2, 0, length);
        }
        System.arraycopy(array, 0, array2, length, array.length);
        intent.putExtra(s, array2);
    }
    
    public static IntentBuilder from(final Activity activity) {
        return new IntentBuilder(activity);
    }
    
    public IntentBuilder addEmailBcc(final String s) {
        if (mBccAddresses == null) {
            mBccAddresses = new ArrayList<String>();
        }
        mBccAddresses.add(s);
        return this;
    }
    
    public IntentBuilder addEmailBcc(final String[] array) {
        this.combineArrayExtra("android.intent.extra.BCC", array);
        return this;
    }
    
    public IntentBuilder addEmailCc(final String s) {
        if (mCcAddresses == null) {
            mCcAddresses = new ArrayList<String>();
        }
        mCcAddresses.add(s);
        return this;
    }
    
    public IntentBuilder addEmailCc(final String[] array) {
        this.combineArrayExtra("android.intent.extra.CC", array);
        return this;
    }
    
    public IntentBuilder addEmailTo(final String s) {
        if (mToAddresses == null) {
            mToAddresses = new ArrayList<String>();
        }
        mToAddresses.add(s);
        return this;
    }
    
    public IntentBuilder addEmailTo(final String[] array) {
        this.combineArrayExtra("android.intent.extra.EMAIL", array);
        return this;
    }
    
    public IntentBuilder addStream(final Uri stream) {
        final Uri uri = (Uri)mIntent.getParcelableExtra("android.intent.extra.STREAM");
        if (uri == null) {
            return this.setStream(stream);
        }
        if (mStreams == null) {
            mStreams = new ArrayList<Uri>();
        }
        if (uri != null) {
            mIntent.removeExtra("android.intent.extra.STREAM");
            mStreams.add(uri);
        }
        mStreams.add(stream);
        return this;
    }
    
    public Intent createChooserIntent() {
        return Intent.createChooser(this.getIntent(), mChooserTitle);
    }
    
    Activity getActivity() {
        return mActivity;
    }
    
    public Intent getIntent() {
        int n = 1;
        if (mToAddresses != null) {
            this.combineArrayExtra("android.intent.extra.EMAIL", mToAddresses);
            mToAddresses = null;
        }
        if (mCcAddresses != null) {
            this.combineArrayExtra("android.intent.extra.CC", mCcAddresses);
            mCcAddresses = null;
        }
        if (mBccAddresses != null) {
            this.combineArrayExtra("android.intent.extra.BCC", mBccAddresses);
            mBccAddresses = null;
        }
        if (mStreams == null || mStreams.size() <= n) {
            n = 0;
        }
        final boolean equals = mIntent.getAction().equals("android.intent.action.SEND_MULTIPLE");
        if (n == 0 && equals) {
            mIntent.setAction("android.intent.action.SEND");
            if (mStreams != null && !mStreams.isEmpty()) {
                mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)mStreams.get(0));
            }
            else {
                mIntent.removeExtra("android.intent.extra.STREAM");
            }
            mStreams = null;
        }
        if (n != 0 && !equals) {
            mIntent.setAction("android.intent.action.SEND_MULTIPLE");
            if (mStreams != null && !mStreams.isEmpty()) {
                mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", (ArrayList)mStreams);
            }
            else {
                mIntent.removeExtra("android.intent.extra.STREAM");
            }
        }
        return mIntent;
    }
    
    public IntentBuilder setChooserTitle(@StringRes final int n) {
        return this.setChooserTitle(mActivity.getText(n));
    }
    
    public IntentBuilder setChooserTitle(final CharSequence mChooserTitle) {
        this.mChooserTitle = mChooserTitle;
        return this;
    }
    
    public IntentBuilder setEmailBcc(final String[] array) {
        mIntent.putExtra("android.intent.extra.BCC", array);
        return this;
    }
    
    public IntentBuilder setEmailCc(final String[] array) {
        mIntent.putExtra("android.intent.extra.CC", array);
        return this;
    }
    
    public IntentBuilder setEmailTo(final String[] array) {
        if (mToAddresses != null) {
            mToAddresses = null;
        }
        mIntent.putExtra("android.intent.extra.EMAIL", array);
        return this;
    }
    
    public IntentBuilder setHtmlText(final String s) {
        mIntent.putExtra("android.intent.extra.HTML_TEXT", s);
        if (!mIntent.hasExtra("android.intent.extra.TEXT")) {
            this.setText((CharSequence)Html.fromHtml(s));
        }
        return this;
    }
    
    public IntentBuilder setStream(final Uri uri) {
        if (!mIntent.getAction().equals("android.intent.action.SEND")) {
            mIntent.setAction("android.intent.action.SEND");
        }
        mStreams = null;
        mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)uri);
        return this;
    }
    
    public IntentBuilder setSubject(final String s) {
        mIntent.putExtra("android.intent.extra.SUBJECT", s);
        return this;
    }
    
    public IntentBuilder setText(final CharSequence charSequence) {
        mIntent.putExtra("android.intent.extra.TEXT", charSequence);
        return this;
    }
    
    public IntentBuilder setType(final String type) {
        mIntent.setType(type);
        return this;
    }
    
    public void startChooser() {
        mActivity.startActivity(this.createChooserIntent());
    }
}
