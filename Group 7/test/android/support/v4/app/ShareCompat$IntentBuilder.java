package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.annotation.StringRes;
import android.text.Html;
import java.util.ArrayList;

public class ShareCompat$IntentBuilder {
   private Activity mActivity;
   private ArrayList<String> mBccAddresses;
   private ArrayList<String> mCcAddresses;
   private CharSequence mChooserTitle;
   private Intent mIntent;
   private ArrayList<Uri> mStreams;
   private ArrayList<String> mToAddresses;

   private ShareCompat$IntentBuilder(Activity var1) {
      this.mActivity = var1;
      this.mIntent = (new Intent()).setAction("android.intent.action.SEND");
      this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", var1.getPackageName());
      this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", var1.getComponentName());
      this.mIntent.addFlags(524288);
   }

   private void combineArrayExtra(String var1, ArrayList<String> var2) {
      String[] var4 = this.mIntent.getStringArrayExtra(var1);
      int var3;
      if(var4 != null) {
         var3 = var4.length;
      } else {
         var3 = 0;
      }

      String[] var5 = new String[var2.size() + var3];
      var2.toArray(var5);
      if(var4 != null) {
         System.arraycopy(var4, 0, var5, var2.size(), var3);
      }

      this.mIntent.putExtra(var1, var5);
   }

   private void combineArrayExtra(String var1, String[] var2) {
      Intent var4 = this.getIntent();
      String[] var5 = var4.getStringArrayExtra(var1);
      int var3;
      if(var5 != null) {
         var3 = var5.length;
      } else {
         var3 = 0;
      }

      String[] var6 = new String[var2.length + var3];
      if(var5 != null) {
         System.arraycopy(var5, 0, var6, 0, var3);
      }

      System.arraycopy(var2, 0, var6, var3, var2.length);
      var4.putExtra(var1, var6);
   }

   public static ShareCompat$IntentBuilder from(Activity var0) {
      return new ShareCompat$IntentBuilder(var0);
   }

   public ShareCompat$IntentBuilder addEmailBcc(String var1) {
      if(this.mBccAddresses == null) {
         this.mBccAddresses = new ArrayList();
      }

      this.mBccAddresses.add(var1);
      return this;
   }

   public ShareCompat$IntentBuilder addEmailBcc(String[] var1) {
      this.combineArrayExtra("android.intent.extra.BCC", var1);
      return this;
   }

   public ShareCompat$IntentBuilder addEmailCc(String var1) {
      if(this.mCcAddresses == null) {
         this.mCcAddresses = new ArrayList();
      }

      this.mCcAddresses.add(var1);
      return this;
   }

   public ShareCompat$IntentBuilder addEmailCc(String[] var1) {
      this.combineArrayExtra("android.intent.extra.CC", var1);
      return this;
   }

   public ShareCompat$IntentBuilder addEmailTo(String var1) {
      if(this.mToAddresses == null) {
         this.mToAddresses = new ArrayList();
      }

      this.mToAddresses.add(var1);
      return this;
   }

   public ShareCompat$IntentBuilder addEmailTo(String[] var1) {
      this.combineArrayExtra("android.intent.extra.EMAIL", var1);
      return this;
   }

   public ShareCompat$IntentBuilder addStream(Uri var1) {
      Uri var2 = (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
      if(var2 == null) {
         return this.setStream(var1);
      } else {
         if(this.mStreams == null) {
            this.mStreams = new ArrayList();
         }

         if(var2 != null) {
            this.mIntent.removeExtra("android.intent.extra.STREAM");
            this.mStreams.add(var2);
         }

         this.mStreams.add(var1);
         return this;
      }
   }

   public Intent createChooserIntent() {
      return Intent.createChooser(this.getIntent(), this.mChooserTitle);
   }

   Activity getActivity() {
      return this.mActivity;
   }

   public Intent getIntent() {
      boolean var1 = true;
      if(this.mToAddresses != null) {
         this.combineArrayExtra("android.intent.extra.EMAIL", this.mToAddresses);
         this.mToAddresses = null;
      }

      if(this.mCcAddresses != null) {
         this.combineArrayExtra("android.intent.extra.CC", this.mCcAddresses);
         this.mCcAddresses = null;
      }

      if(this.mBccAddresses != null) {
         this.combineArrayExtra("android.intent.extra.BCC", this.mBccAddresses);
         this.mBccAddresses = null;
      }

      if(this.mStreams == null || this.mStreams.size() <= 1) {
         var1 = false;
      }

      boolean var2 = this.mIntent.getAction().equals("android.intent.action.SEND_MULTIPLE");
      if(!var1 && var2) {
         this.mIntent.setAction("android.intent.action.SEND");
         if(this.mStreams != null && !this.mStreams.isEmpty()) {
            this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)this.mStreams.get(0));
         } else {
            this.mIntent.removeExtra("android.intent.extra.STREAM");
         }

         this.mStreams = null;
      }

      if(var1 && !var2) {
         this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
         if(this.mStreams != null && !this.mStreams.isEmpty()) {
            this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
         } else {
            this.mIntent.removeExtra("android.intent.extra.STREAM");
         }
      }

      return this.mIntent;
   }

   public ShareCompat$IntentBuilder setChooserTitle(@StringRes int var1) {
      return this.setChooserTitle(this.mActivity.getText(var1));
   }

   public ShareCompat$IntentBuilder setChooserTitle(CharSequence var1) {
      this.mChooserTitle = var1;
      return this;
   }

   public ShareCompat$IntentBuilder setEmailBcc(String[] var1) {
      this.mIntent.putExtra("android.intent.extra.BCC", var1);
      return this;
   }

   public ShareCompat$IntentBuilder setEmailCc(String[] var1) {
      this.mIntent.putExtra("android.intent.extra.CC", var1);
      return this;
   }

   public ShareCompat$IntentBuilder setEmailTo(String[] var1) {
      if(this.mToAddresses != null) {
         this.mToAddresses = null;
      }

      this.mIntent.putExtra("android.intent.extra.EMAIL", var1);
      return this;
   }

   public ShareCompat$IntentBuilder setHtmlText(String var1) {
      this.mIntent.putExtra("android.intent.extra.HTML_TEXT", var1);
      if(!this.mIntent.hasExtra("android.intent.extra.TEXT")) {
         this.setText(Html.fromHtml(var1));
      }

      return this;
   }

   public ShareCompat$IntentBuilder setStream(Uri var1) {
      if(!this.mIntent.getAction().equals("android.intent.action.SEND")) {
         this.mIntent.setAction("android.intent.action.SEND");
      }

      this.mStreams = null;
      this.mIntent.putExtra("android.intent.extra.STREAM", var1);
      return this;
   }

   public ShareCompat$IntentBuilder setSubject(String var1) {
      this.mIntent.putExtra("android.intent.extra.SUBJECT", var1);
      return this;
   }

   public ShareCompat$IntentBuilder setText(CharSequence var1) {
      this.mIntent.putExtra("android.intent.extra.TEXT", var1);
      return this;
   }

   public ShareCompat$IntentBuilder setType(String var1) {
      this.mIntent.setType(var1);
      return this;
   }

   public void startChooser() {
      this.mActivity.startActivity(this.createChooserIntent());
   }
}
