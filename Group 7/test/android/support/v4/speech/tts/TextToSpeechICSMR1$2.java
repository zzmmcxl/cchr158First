package android.support.v4.speech.tts;

import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;
import android.support.v4.speech.tts.TextToSpeechICSMR1$UtteranceProgressListenerICSMR1;

final class TextToSpeechICSMR1$2 implements OnUtteranceCompletedListener {
   TextToSpeechICSMR1$2(TextToSpeechICSMR1$UtteranceProgressListenerICSMR1 var1) {
      this.val$listener = var1;
   }

   public void onUtteranceCompleted(String var1) {
      this.val$listener.onStart(var1);
      this.val$listener.onDone(var1);
   }
}
