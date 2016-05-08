package android.support.v4.speech.tts;

import android.speech.tts.UtteranceProgressListener;
import android.support.v4.speech.tts.TextToSpeechICSMR1$UtteranceProgressListenerICSMR1;

final class TextToSpeechICSMR1$1 extends UtteranceProgressListener {
   TextToSpeechICSMR1$1(TextToSpeechICSMR1$UtteranceProgressListenerICSMR1 var1) {
      this.val$listener = var1;
   }

   public void onDone(String var1) {
      this.val$listener.onDone(var1);
   }

   public void onError(String var1) {
      this.val$listener.onError(var1);
   }

   public void onStart(String var1) {
      this.val$listener.onStart(var1);
   }
}
