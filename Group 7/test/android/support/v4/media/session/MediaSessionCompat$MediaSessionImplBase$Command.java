package android.support.v4.media.session;

import android.os.Bundle;
import android.os.ResultReceiver;

final class MediaSessionCompat$MediaSessionImplBase$Command {
   public final String command;
   public final Bundle extras;
   public final ResultReceiver stub;

   public MediaSessionCompat$MediaSessionImplBase$Command(String var1, Bundle var2, ResultReceiver var3) {
      this.command = var1;
      this.extras = var2;
      this.stub = var3;
   }
}
