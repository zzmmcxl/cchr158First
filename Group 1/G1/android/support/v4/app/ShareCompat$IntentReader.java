package android.support.v4.app;

import android.text.Html;
import android.text.Spanned;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.util.ArrayList;
import android.content.Intent;
import android.content.ComponentName;
import android.app.Activity;

public static class IntentReader
{
    private static final String TAG = "IntentReader";
    private Activity mActivity;
    private ComponentName mCallingActivity;
    private String mCallingPackage;
    private Intent mIntent;
    private ArrayList<Uri> mStreams;
    
    private IntentReader(final Activity mActivity) {
        super();
        this.mActivity = mActivity;
        this.mIntent = mActivity.getIntent();
        this.mCallingPackage = ShareCompat.getCallingPackage(mActivity);
        this.mCallingActivity = ShareCompat.getCallingActivity(mActivity);
    }
    
    public static IntentReader from(final Activity activity) {
        return new IntentReader(activity);
    }
    
    public ComponentName getCallingActivity() {
        return mCallingActivity;
    }
    
    public Drawable getCallingActivityIcon() {
        if (mCallingActivity == null) {
            return null;
        }
        final PackageManager packageManager = mActivity.getPackageManager();
        try {
            return packageManager.getActivityIcon(mCallingActivity);
        }
        catch (PackageManager$NameNotFoundException ex) {
            Log.e("IntentReader", "Could not retrieve icon for calling activity", (Throwable)ex);
            return null;
        }
    }
    
    public Drawable getCallingApplicationIcon() {
        if (mCallingPackage == null) {
            return null;
        }
        final PackageManager packageManager = mActivity.getPackageManager();
        try {
            return packageManager.getApplicationIcon(mCallingPackage);
        }
        catch (PackageManager$NameNotFoundException ex) {
            Log.e("IntentReader", "Could not retrieve icon for calling application", (Throwable)ex);
            return null;
        }
    }
    
    public CharSequence getCallingApplicationLabel() {
        if (mCallingPackage == null) {
            return null;
        }
        final PackageManager packageManager = mActivity.getPackageManager();
        try {
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(mCallingPackage, 0));
        }
        catch (PackageManager$NameNotFoundException ex) {
            Log.e("IntentReader", "Could not retrieve label for calling application", (Throwable)ex);
            return null;
        }
    }
    
    public String getCallingPackage() {
        return mCallingPackage;
    }
    
    public String[] getEmailBcc() {
        return mIntent.getStringArrayExtra("android.intent.extra.BCC");
    }
    
    public String[] getEmailCc() {
        return mIntent.getStringArrayExtra("android.intent.extra.CC");
    }
    
    public String[] getEmailTo() {
        return mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
    }
    
    public String getHtmlText() {
        String s = mIntent.getStringExtra("android.intent.extra.HTML_TEXT");
        if (s == null) {
            final CharSequence text = this.getText();
            if (text instanceof Spanned) {
                s = Html.toHtml((Spanned)text);
            }
            else if (text != null) {
                return ShareCompat.access$000().escapeHtml(text);
            }
        }
        return s;
    }
    
    public Uri getStream() {
        return (Uri)mIntent.getParcelableExtra("android.intent.extra.STREAM");
    }
    
    public Uri getStream(final int n) {
        if (mStreams == null && this.isMultipleShare()) {
            mStreams = (ArrayList<Uri>)mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        }
        if (mStreams != null) {
            return mStreams.get(n);
        }
        if (n == 0) {
            return (Uri)mIntent.getParcelableExtra("android.intent.extra.STREAM");
        }
        throw new IndexOutOfBoundsException("Stream items available: " + this.getStreamCount() + " index requested: " + n);
    }
    
    public int getStreamCount() {
        if (mStreams == null && this.isMultipleShare()) {
            mStreams = (ArrayList<Uri>)mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        }
        if (mStreams != null) {
            return mStreams.size();
        }
        if (mIntent.hasExtra("android.intent.extra.STREAM")) {
            return 1;
        }
        return 0;
    }
    
    public String getSubject() {
        return mIntent.getStringExtra("android.intent.extra.SUBJECT");
    }
    
    public CharSequence getText() {
        return mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
    }
    
    public String getType() {
        return mIntent.getType();
    }
    
    public boolean isMultipleShare() {
        return "android.intent.action.SEND_MULTIPLE".equals(mIntent.getAction());
    }
    
    public boolean isShareIntent() {
        final String action = mIntent.getAction();
        return "android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action);
    }
    
    public boolean isSingleShare() {
        return "android.intent.action.SEND".equals(mIntent.getAction());
    }
}
