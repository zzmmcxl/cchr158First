package wseemann.media;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;
import wseemann.media.FFmpegMediaMetadataRetriever;

public class FFmpegMediaMetadataRetriever$Metadata {
   public static final int BOOLEAN_VAL = 3;
   public static final int BYTE_ARRAY_VAL = 7;
   public static final int DATE_VAL = 6;
   public static final int DOUBLE_VAL = 5;
   public static final int INTEGER_VAL = 2;
   public static final int LONG_VAL = 4;
   public static final int STRING_VAL = 1;
   private HashMap<String, String> mParcel;

   public FFmpegMediaMetadataRetriever$Metadata(FFmpegMediaMetadataRetriever var1) {
      this.this$0 = var1;
   }

   private boolean checkMetadataId(String var1) {
      return true;
   }

   private void checkType(String var1, int var2) {
      var1 = (String)this.mParcel.get(var1);
      if(var1 == null) {
         throw new IllegalStateException("Wrong type " + var2 + " but got " + var1);
      }
   }

   public HashMap<String, String> getAll() {
      return this.mParcel;
   }

   public boolean getBoolean(String var1) {
      this.checkType(var1, 3);
      return Integer.valueOf((String)this.mParcel.get(var1)).intValue() == 1;
   }

   public byte[] getByteArray(String var1) {
      this.checkType(var1, 7);
      return ((String)this.mParcel.get(var1)).getBytes();
   }

   public Date getDate(String var1) {
      this.checkType(var1, 6);
      long var2 = Long.valueOf((String)this.mParcel.get(var1)).longValue();
      var1 = (String)this.mParcel.get(var1);
      if(var1.length() == 0) {
         return new Date(var2);
      } else {
         Calendar var4 = Calendar.getInstance(TimeZone.getTimeZone(var1));
         var4.setTimeInMillis(var2);
         return var4.getTime();
      }
   }

   public double getDouble(String var1) {
      this.checkType(var1, 5);
      return Double.valueOf((String)this.mParcel.get(var1)).doubleValue();
   }

   public int getInt(String var1) {
      this.checkType(var1, 2);
      return Integer.valueOf((String)this.mParcel.get(var1)).intValue();
   }

   public long getLong(String var1) {
      this.checkType(var1, 4);
      return Long.valueOf((String)this.mParcel.get(var1)).longValue();
   }

   public String getString(String var1) {
      this.checkType(var1, 1);
      return String.valueOf(this.mParcel.get(var1));
   }

   public boolean has(String var1) {
      if(!this.checkMetadataId(var1)) {
         throw new IllegalArgumentException("Invalid key: " + var1);
      } else {
         return this.mParcel.containsKey(var1);
      }
   }

   public boolean parse(HashMap<String, String> var1) {
      if(var1 == null) {
         return false;
      } else {
         this.mParcel = var1;
         return true;
      }
   }
}
