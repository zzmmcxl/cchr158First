package android.support.v4.text;

import android.support.v4.text.BidiFormatter;
import android.support.v4.text.BidiFormatter$1;
import android.support.v4.text.TextDirectionHeuristicCompat;
import java.util.Locale;

public final class BidiFormatter$Builder {
   private int mFlags;
   private boolean mIsRtlContext;
   private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

   public BidiFormatter$Builder() {
      this.initialize(BidiFormatter.access$000(Locale.getDefault()));
   }

   public BidiFormatter$Builder(Locale var1) {
      this.initialize(BidiFormatter.access$000(var1));
   }

   public BidiFormatter$Builder(boolean var1) {
      this.initialize(var1);
   }

   private static BidiFormatter getDefaultInstanceFromContext(boolean var0) {
      return var0?BidiFormatter.access$200():BidiFormatter.access$300();
   }

   private void initialize(boolean var1) {
      this.mIsRtlContext = var1;
      this.mTextDirectionHeuristicCompat = BidiFormatter.access$100();
      this.mFlags = 2;
   }

   public BidiFormatter build() {
      return this.mFlags == 2 && this.mTextDirectionHeuristicCompat == BidiFormatter.access$100()?getDefaultInstanceFromContext(this.mIsRtlContext):new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat, (BidiFormatter$1)null);
   }

   public BidiFormatter$Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat var1) {
      this.mTextDirectionHeuristicCompat = var1;
      return this;
   }

   public BidiFormatter$Builder stereoReset(boolean var1) {
      if(var1) {
         this.mFlags |= 2;
         return this;
      } else {
         this.mFlags &= -3;
         return this;
      }
   }
}
