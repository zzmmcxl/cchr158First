package android.support.v4.speech.tts;

import android.os.Build.VERSION;
import android.speech.tts.TextToSpeech;
import android.support.v4.speech.tts.TextToSpeechICSMR1$1;
import android.support.v4.speech.tts.TextToSpeechICSMR1$2;
import android.support.v4.speech.tts.TextToSpeechICSMR1$UtteranceProgressListenerICSMR1;
import java.util.Locale;
import java.util.Set;

class TextToSpeechICSMR1 {
   public static final String KEY_FEATURE_EMBEDDED_SYNTHESIS = "embeddedTts";
   public static final String KEY_FEATURE_NETWORK_SYNTHESIS = "networkTts";

   static Set<String> getFeatures(TextToSpeech var0, Locale var1) {
      return VERSION.SDK_INT >= 15?var0.getFeatures(var1):null;
   }

   static void setUtteranceProgressListener(TextToSpeech var0, TextToSpeechICSMR1$UtteranceProgressListenerICSMR1 var1) {
      if(VERSION.SDK_INT >= 15) {
         var0.setOnUtteranceProgressListener(new TextToSpeechICSMR1$1(var1));
      } else {
         var0.setOnUtteranceCompletedListener(new TextToSpeechICSMR1$2(var1));
      }
   }
}
