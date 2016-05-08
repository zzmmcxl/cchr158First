package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.support.v4.os.AsyncTaskCompat;
import android.support.v7.widget.ActivityChooserModel$1;
import android.support.v7.widget.ActivityChooserModel$ActivityResolveInfo;
import android.support.v7.widget.ActivityChooserModel$ActivitySorter;
import android.support.v7.widget.ActivityChooserModel$DefaultSorter;
import android.support.v7.widget.ActivityChooserModel$HistoricalRecord;
import android.support.v7.widget.ActivityChooserModel$OnChooseActivityListener;
import android.support.v7.widget.ActivityChooserModel$PersistHistoryAsyncTask;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ActivityChooserModel extends DataSetObservable {
   private static final String ATTRIBUTE_ACTIVITY = "activity";
   private static final String ATTRIBUTE_TIME = "time";
   private static final String ATTRIBUTE_WEIGHT = "weight";
   private static final boolean DEBUG = false;
   private static final int DEFAULT_ACTIVITY_INFLATION = 5;
   private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0F;
   public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
   public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
   private static final String HISTORY_FILE_EXTENSION = ".xml";
   private static final int INVALID_INDEX = -1;
   private static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
   private static final String TAG_HISTORICAL_RECORD = "historical-record";
   private static final String TAG_HISTORICAL_RECORDS = "historical-records";
   private static final Map<String, ActivityChooserModel> sDataModelRegistry = new HashMap();
   private static final Object sRegistryLock = new Object();
   private final List<ActivityChooserModel$ActivityResolveInfo> mActivities = new ArrayList();
   private ActivityChooserModel$OnChooseActivityListener mActivityChoserModelPolicy;
   private ActivityChooserModel$ActivitySorter mActivitySorter = new ActivityChooserModel$DefaultSorter(this, (ActivityChooserModel$1)null);
   private boolean mCanReadHistoricalData = true;
   private final Context mContext;
   private final List<ActivityChooserModel$HistoricalRecord> mHistoricalRecords = new ArrayList();
   private boolean mHistoricalRecordsChanged = true;
   private final String mHistoryFileName;
   private int mHistoryMaxSize = 50;
   private final Object mInstanceLock = new Object();
   private Intent mIntent;
   private boolean mReadShareHistoryCalled = false;
   private boolean mReloadActivities = false;

   private ActivityChooserModel(Context var1, String var2) {
      this.mContext = var1.getApplicationContext();
      if(!TextUtils.isEmpty(var2) && !var2.endsWith(".xml")) {
         this.mHistoryFileName = var2 + ".xml";
      } else {
         this.mHistoryFileName = var2;
      }
   }

   private boolean addHisoricalRecord(ActivityChooserModel$HistoricalRecord var1) {
      boolean var2 = this.mHistoricalRecords.add(var1);
      if(var2) {
         this.mHistoricalRecordsChanged = true;
         this.pruneExcessiveHistoricalRecordsIfNeeded();
         this.persistHistoricalDataIfNeeded();
         this.sortActivitiesIfNeeded();
         this.notifyChanged();
      }

      return var2;
   }

   private void ensureConsistentState() {
      boolean var1 = this.loadActivitiesIfNeeded();
      boolean var2 = this.readHistoricalDataIfNeeded();
      this.pruneExcessiveHistoricalRecordsIfNeeded();
      if(var1 | var2) {
         this.sortActivitiesIfNeeded();
         this.notifyChanged();
      }

   }

   public static ActivityChooserModel get(Context param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   private boolean loadActivitiesIfNeeded() {
      boolean var4 = false;
      boolean var3 = var4;
      if(this.mReloadActivities) {
         var3 = var4;
         if(this.mIntent != null) {
            this.mReloadActivities = false;
            this.mActivities.clear();
            List var5 = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
            int var2 = var5.size();

            for(int var1 = 0; var1 < var2; ++var1) {
               ResolveInfo var6 = (ResolveInfo)var5.get(var1);
               this.mActivities.add(new ActivityChooserModel$ActivityResolveInfo(this, var6));
            }

            var3 = true;
         }
      }

      return var3;
   }

   private void persistHistoricalDataIfNeeded() {
      if(!this.mReadShareHistoryCalled) {
         throw new IllegalStateException("No preceding call to #readHistoricalData");
      } else {
         if(this.mHistoricalRecordsChanged) {
            this.mHistoricalRecordsChanged = false;
            if(!TextUtils.isEmpty(this.mHistoryFileName)) {
               AsyncTaskCompat.executeParallel(new ActivityChooserModel$PersistHistoryAsyncTask(this, (ActivityChooserModel$1)null), new Object[]{new ArrayList(this.mHistoricalRecords), this.mHistoryFileName});
               return;
            }
         }

      }
   }

   private void pruneExcessiveHistoricalRecordsIfNeeded() {
      int var2 = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
      if(var2 > 0) {
         this.mHistoricalRecordsChanged = true;

         for(int var1 = 0; var1 < var2; ++var1) {
            ActivityChooserModel$HistoricalRecord var3 = (ActivityChooserModel$HistoricalRecord)this.mHistoricalRecords.remove(0);
         }
      }

   }

   private boolean readHistoricalDataIfNeeded() {
      if(this.mCanReadHistoricalData && this.mHistoricalRecordsChanged && !TextUtils.isEmpty(this.mHistoryFileName)) {
         this.mCanReadHistoricalData = false;
         this.mReadShareHistoryCalled = true;
         this.readHistoricalDataImpl();
         return true;
      } else {
         return false;
      }
   }

   private void readHistoricalDataImpl() {
      // $FF: Couldn't be decompiled
   }

   private boolean sortActivitiesIfNeeded() {
      if(this.mActivitySorter != null && this.mIntent != null && !this.mActivities.isEmpty() && !this.mHistoricalRecords.isEmpty()) {
         this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
         return true;
      } else {
         return false;
      }
   }

   public Intent chooseActivity(int param1) {
      // $FF: Couldn't be decompiled
   }

   public ResolveInfo getActivity(int param1) {
      // $FF: Couldn't be decompiled
   }

   public int getActivityCount() {
      // $FF: Couldn't be decompiled
   }

   public int getActivityIndex(ResolveInfo param1) {
      // $FF: Couldn't be decompiled
   }

   public ResolveInfo getDefaultActivity() {
      // $FF: Couldn't be decompiled
   }

   public int getHistoryMaxSize() {
      // $FF: Couldn't be decompiled
   }

   public int getHistorySize() {
      // $FF: Couldn't be decompiled
   }

   public Intent getIntent() {
      // $FF: Couldn't be decompiled
   }

   public void setActivitySorter(ActivityChooserModel$ActivitySorter param1) {
      // $FF: Couldn't be decompiled
   }

   public void setDefaultActivity(int param1) {
      // $FF: Couldn't be decompiled
   }

   public void setHistoryMaxSize(int param1) {
      // $FF: Couldn't be decompiled
   }

   public void setIntent(Intent param1) {
      // $FF: Couldn't be decompiled
   }

   public void setOnChooseActivityListener(ActivityChooserModel$OnChooseActivityListener param1) {
      // $FF: Couldn't be decompiled
   }
}
