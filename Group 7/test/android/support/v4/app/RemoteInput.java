package android.support.v4.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.app.RemoteInput$1;
import android.support.v4.app.RemoteInput$Impl;
import android.support.v4.app.RemoteInput$ImplApi20;
import android.support.v4.app.RemoteInput$ImplBase;
import android.support.v4.app.RemoteInput$ImplJellybean;
import android.support.v4.app.RemoteInputCompatBase$RemoteInput;
import android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory;

public final class RemoteInput extends RemoteInputCompatBase$RemoteInput {
   public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
   public static final RemoteInputCompatBase$RemoteInput$Factory FACTORY;
   private static final RemoteInput$Impl IMPL;
   public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
   private static final String TAG = "RemoteInput";
   private final boolean mAllowFreeFormInput;
   private final CharSequence[] mChoices;
   private final Bundle mExtras;
   private final CharSequence mLabel;
   private final String mResultKey;

   static {
      if(VERSION.SDK_INT >= 20) {
         IMPL = new RemoteInput$ImplApi20();
      } else if(VERSION.SDK_INT >= 16) {
         IMPL = new RemoteInput$ImplJellybean();
      } else {
         IMPL = new RemoteInput$ImplBase();
      }

      FACTORY = new RemoteInput$1();
   }

   private RemoteInput(String var1, CharSequence var2, CharSequence[] var3, boolean var4, Bundle var5) {
      this.mResultKey = var1;
      this.mLabel = var2;
      this.mChoices = var3;
      this.mAllowFreeFormInput = var4;
      this.mExtras = var5;
   }

   public static void addResultsToIntent(RemoteInput[] var0, Intent var1, Bundle var2) {
      IMPL.addResultsToIntent(var0, var1, var2);
   }

   public static Bundle getResultsFromIntent(Intent var0) {
      return IMPL.getResultsFromIntent(var0);
   }

   public boolean getAllowFreeFormInput() {
      return this.mAllowFreeFormInput;
   }

   public CharSequence[] getChoices() {
      return this.mChoices;
   }

   public Bundle getExtras() {
      return this.mExtras;
   }

   public CharSequence getLabel() {
      return this.mLabel;
   }

   public String getResultKey() {
      return this.mResultKey;
   }
}
