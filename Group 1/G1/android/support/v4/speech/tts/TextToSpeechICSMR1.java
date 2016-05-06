package android.support.v4.speech.tts;

import android.speech.tts.TextToSpeech$OnUtteranceCompletedListener;
import android.speech.tts.UtteranceProgressListener;
import android.os.Build$VERSION;
import java.util.Set;
import java.util.Locale;
import android.speech.tts.TextToSpeech;

class TextToSpeechICSMR1
{
    public static final String KEY_FEATURE_EMBEDDED_SYNTHESIS = "embeddedTts";
    public static final String KEY_FEATURE_NETWORK_SYNTHESIS = "networkTts";
    
    TextToSpeechICSMR1() {
        super();
    }
    
    static Set<String> getFeatures(final TextToSpeech textToSpeech, final Locale locale) {
        if (Build$VERSION.SDK_INT >= 15) {
            return (Set<String>)textToSpeech.getFeatures(locale);
        }
        return null;
    }
    
    static void setUtteranceProgressListener(final TextToSpeech textToSpeech, final UtteranceProgressListenerICSMR1 utteranceProgressListenerICSMR1) {
        if (Build$VERSION.SDK_INT >= 15) {
            textToSpeech.setOnUtteranceProgressListener((UtteranceProgressListener)new UtteranceProgressListener() {
                final /* synthetic */ UtteranceProgressListenerICSMR1 val$listener;
                
                TextToSpeechICSMR1$1() {
                    super();
                }
                
                public void onDone(final String s) {
                    utteranceProgressListenerICSMR1.onDone(s);
                }
                
                public void onError(final String s) {
                    utteranceProgressListenerICSMR1.onError(s);
                }
                
                public void onStart(final String s) {
                    utteranceProgressListenerICSMR1.onStart(s);
                }
            });
            return;
        }
        textToSpeech.setOnUtteranceCompletedListener((TextToSpeech$OnUtteranceCompletedListener)new TextToSpeech$OnUtteranceCompletedListener() {
            final /* synthetic */ UtteranceProgressListenerICSMR1 val$listener;
            
            TextToSpeechICSMR1$2() {
                super();
            }
            
            public void onUtteranceCompleted(final String s) {
                utteranceProgressListenerICSMR1.onStart(s);
                utteranceProgressListenerICSMR1.onDone(s);
            }
        });
    }
}
