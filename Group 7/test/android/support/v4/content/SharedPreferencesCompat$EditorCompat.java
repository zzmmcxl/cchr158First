package android.support.v4.content;

import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.content.SharedPreferencesCompat$1;
import android.support.v4.content.SharedPreferencesCompat$EditorCompat$EditorHelperApi9Impl;
import android.support.v4.content.SharedPreferencesCompat$EditorCompat$EditorHelperBaseImpl;
import android.support.v4.content.SharedPreferencesCompat$EditorCompat$Helper;

public final class SharedPreferencesCompat$EditorCompat {
   private static SharedPreferencesCompat$EditorCompat sInstance;
   private final SharedPreferencesCompat$EditorCompat$Helper mHelper;

   private SharedPreferencesCompat$EditorCompat() {
      if(VERSION.SDK_INT >= 9) {
         this.mHelper = new SharedPreferencesCompat$EditorCompat$EditorHelperApi9Impl((SharedPreferencesCompat$1)null);
      } else {
         this.mHelper = new SharedPreferencesCompat$EditorCompat$EditorHelperBaseImpl((SharedPreferencesCompat$1)null);
      }
   }

   public static SharedPreferencesCompat$EditorCompat getInstance() {
      if(sInstance == null) {
         sInstance = new SharedPreferencesCompat$EditorCompat();
      }

      return sInstance;
   }

   public void apply(@NonNull Editor var1) {
      this.mHelper.apply(var1);
   }
}
