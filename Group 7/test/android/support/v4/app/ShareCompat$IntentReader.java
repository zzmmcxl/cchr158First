package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import java.util.ArrayList;

public class ShareCompat$IntentReader {
   private static final String TAG = "IntentReader";
   private Activity mActivity;
   private ComponentName mCallingActivity;
   private String mCallingPackage;
   private Intent mIntent;
   private ArrayList<Uri> mStreams;

   private ShareCompat$IntentReader(Activity var1) {
      this.mActivity = var1;
      this.mIntent = var1.getIntent();
      this.mCallingPackage = ShareCompat.getCallingPackage(var1);
      this.mCallingActivity = ShareCompat.getCallingActivity(var1);
   }

   public static ShareCompat$IntentReader from(Activity var0) {
      return new ShareCompat$IntentReader(var0);
   }

   public ComponentName getCallingActivity() {
      return this.mCallingActivity;
   }

   public Drawable getCallingActivityIcon() {
      if(this.mCallingActivity == null) {
         return null;
      } else {
         PackageManager var1 = this.mActivity.getPackageManager();

         try {
            Drawable var3 = var1.getActivityIcon(this.mCallingActivity);
            return var3;
         } catch (NameNotFoundException var2) {
            Log.e("IntentReader", "Could not retrieve icon for calling activity", var2);
            return null;
         }
      }
   }

   public Drawable getCallingApplicationIcon() {
      if(this.mCallingPackage == null) {
         return null;
      } else {
         PackageManager var1 = this.mActivity.getPackageManager();

         try {
            Drawable var3 = var1.getApplicationIcon(this.mCallingPackage);
            return var3;
         } catch (NameNotFoundException var2) {
            Log.e("IntentReader", "Could not retrieve icon for calling application", var2);
            return null;
         }
      }
   }

   public CharSequence getCallingApplicationLabel() {
      if(this.mCallingPackage == null) {
         return null;
      } else {
         PackageManager var1 = this.mActivity.getPackageManager();

         try {
            CharSequence var3 = var1.getApplicationLabel(var1.getApplicationInfo(this.mCallingPackage, 0));
            return var3;
         } catch (NameNotFoundException var2) {
            Log.e("IntentReader", "Could not retrieve label for calling application", var2);
            return null;
         }
      }
   }

   public String getCallingPackage() {
      return this.mCallingPackage;
   }

   public String[] getEmailBcc() {
      return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
   }

   public String[] getEmailCc() {
      return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
   }

   public String[] getEmailTo() {
      return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
   }

   public String getHtmlText() {
      String var2 = this.mIntent.getStringExtra("android.intent.extra.HTML_TEXT");
      String var1 = var2;
      if(var2 == null) {
         CharSequence var3 = this.getText();
         if(var3 instanceof Spanned) {
            var1 = Html.toHtml((Spanned)var3);
         } else {
            var1 = var2;
            if(var3 != null) {
               return ShareCompat.access$000().escapeHtml(var3);
            }
         }
      }

      return var1;
   }

   public Uri getStream() {
      return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
   }

   public Uri getStream(int var1) {
      if(this.mStreams == null && this.isMultipleShare()) {
         this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
      }

      if(this.mStreams != null) {
         return (Uri)this.mStreams.get(var1);
      } else if(var1 == 0) {
         return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
      } else {
         throw new IndexOutOfBoundsException("Stream items available: " + this.getStreamCount() + " index requested: " + var1);
      }
   }

   public int getStreamCount() {
      if(this.mStreams == null && this.isMultipleShare()) {
         this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
      }

      return this.mStreams != null?this.mStreams.size():(this.mIntent.hasExtra("android.intent.extra.STREAM")?1:0);
   }

   public String getSubject() {
      return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
   }

   public CharSequence getText() {
      return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
   }

   public String getType() {
      return this.mIntent.getType();
   }

   public boolean isMultipleShare() {
      return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
   }

   public boolean isShareIntent() {
      String var1 = this.mIntent.getAction();
      return "android.intent.action.SEND".equals(var1) || "android.intent.action.SEND_MULTIPLE".equals(var1);
   }

   public boolean isSingleShare() {
      return "android.intent.action.SEND".equals(this.mIntent.getAction());
   }
}
